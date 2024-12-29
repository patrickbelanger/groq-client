// Licensed to the Software Freedom Conservancy (SFC) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The SFC licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package io.github.patrickbelanger.groq.client;

import io.github.patrickbelanger.groq.dto.GroqRequestDTO;
import io.github.patrickbelanger.groq.dto.GroqResponseDTO;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public abstract class GroqWebClient {
    private static final String BASE_URL = "https://api.groq.com";
    private static final String GROQ_API_KEY = System.getenv("GROQ_API_KEY");

    private final WebClient webClient;

    public GroqWebClient() {
        this.webClient = WebClient.builder()
            .baseUrl(BASE_URL)
            .defaultHeaders(headers -> {
                headers.add("Authorization", "Bearer %s".formatted(GROQ_API_KEY));
                headers.add("Content-Type", "application/json");
            })
            .build();
    }

    protected <T> Mono<T> get(String uri, Class<T> responseType) {
        return webClient.get()
            .uri(uri)
            .exchangeToMono(response ->
                handleResponse(response, responseType)
            );
    }

    protected GroqResponseDTO post(String uri, GroqRequestDTO requestBody) {
        return webClient.post()
            .uri(uri)
            .body(Mono.just(requestBody), requestBody.getClass())
            .exchangeToMono(response ->
                handleResponse(response, GroqResponseDTO.class)
            )
            .block();
    }

    private <T> Mono<T> handleResponse(ClientResponse response, Class<T> responseType) {
        if (response.statusCode().is2xxSuccessful()) {
            return response.bodyToMono(responseType);
        }
        return response.bodyToMono(String.class)
            .flatMap(errorBody -> Mono.error(new RuntimeException("Request failed with status: %s, error: %s".formatted(response.statusCode(), errorBody))));
    }
}
