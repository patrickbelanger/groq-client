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

import io.github.patrickbelanger.groq.client.validators.ModelValidator;
import io.github.patrickbelanger.groq.dto.GroqModelResponseDTO;
import io.github.patrickbelanger.groq.dto.GroqModelsResponseDTO;
import io.github.patrickbelanger.groq.dto.GroqRequestDTO;
import io.github.patrickbelanger.groq.dto.GroqResponseDTO;
import io.github.patrickbelanger.groq.enums.GroqEndPoints;

public class GroqClient extends GroqWebClient {

    public GroqClient() {
         super();
    }

    public GroqResponseDTO createChatCompletion(GroqRequestDTO requestBody) {
        ModelValidator.validateModel(requestBody.getModel());
        return post(GroqEndPoints.CREATE_CHAT_COMPLETION.getPath(), requestBody);
    }

    public GroqModelsResponseDTO getListModels() {
        return get(GroqEndPoints.LIST_MODELS.getPath(), GroqModelsResponseDTO.class).block();
    }

    public GroqModelResponseDTO getModel(String modelName) {
        return get(GroqEndPoints.RETREIVE_MODEL.getPath().formatted(modelName), GroqModelResponseDTO.class).block();
    }
}
