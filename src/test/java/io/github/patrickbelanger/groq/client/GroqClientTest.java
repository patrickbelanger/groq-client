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

import io.github.patrickbelanger.groq.dto.GroqModelResponseDTO;
import io.github.patrickbelanger.groq.dto.GroqModelsResponseDTO;
import io.github.patrickbelanger.groq.dto.GroqResponseDTO;
import io.github.patrickbelanger.groq.dto.builders.GroqRequestBuilder;
import io.github.patrickbelanger.groq.dto.builders.MessageBuilder;
import io.github.patrickbelanger.groq.enums.GroqModels;
import io.github.patrickbelanger.groq.enums.GroqRoles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GroqClientTest {

    private GroqClient sut;

    @BeforeEach
    void setUp() {
       sut = new GroqClient();
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

    @Test
    void createChatCompletion_shouldGetResponseAndContainsPlayerName() {
        GroqResponseDTO response = sut.createChatCompletion(
            new GroqRequestBuilder()
                .setModel(GroqModels.LLAMA3_8B_8192)
                .setMessage(
                    new MessageBuilder()
                        .setRole(GroqRoles.SYSTEM)
                        .setContent("As an non player character, you are the player love interest caring of the main character. The main character name is Johnny (gender: Male). Your first name is Judy (gender: Female)")
                        .build()
                )
                .setMessage(
                    new MessageBuilder()
                        .setRole(GroqRoles.USER)
                        .setContent("Hey, Judy! How was your day?")
                        .build()
                )
                .build()
        );
        assertEquals(response.getChoices().size(), 1);
        assertTrue(response.getChoices().getFirst().getMessage().getContent().contains("Johnny"));
    }

    @Test
    void getListModels_shouldGetResponseAndReturnSpecifiedModel() {
        GroqModelResponseDTO response = sut.getModel(GroqModels.LLAMA3_8B_8192.getName());
        assertNotNull(response);
        assertEquals(response.getId(), GroqModels.LLAMA3_8B_8192.getName());
    }

    @Test
    void getListModels_shouldGetResponseAndContainsSpecifiedModel() {
        GroqModelsResponseDTO response = sut.getListModels();
        assertFalse(response.getData().isEmpty());
        assertTrue(response.getData().stream()
            .anyMatch(e -> e.getId().equals(GroqModels.LLAMA3_8B_8192.getName()))
        );
    }
}
