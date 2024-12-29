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

package io.github.patrickbelanger.groq.dto.builders;

import io.github.patrickbelanger.groq.dto.GroqRequestDTO;
import io.github.patrickbelanger.groq.dto.requests.MessageDTO;
import io.github.patrickbelanger.groq.enums.GroqModels;

import java.util.ArrayList;

public class GroqRequestBuilder {

    private final GroqRequestDTO groqRequestDTO;

    public GroqRequestBuilder() {
        this.groqRequestDTO = new GroqRequestDTO();
        this.groqRequestDTO.setMessages(new ArrayList<>());
    }

    public GroqRequestBuilder setMessage(MessageDTO messages) {
        this.groqRequestDTO.getMessages().add(messages);
        return this;
    }

    public GroqRequestBuilder setMessages(ArrayList<MessageDTO> messages) {
        this.groqRequestDTO.setMessages(messages);
        return this;
    }

    /**
     * The language model which will generate the completion.
     * @param model {@link GroqModels}
     * @return
     */
    public GroqRequestBuilder setModel(GroqModels model) {
        this.groqRequestDTO.setModel(model.getName());
        return this;
    }

    /**
     * The language model which will generate the completion.
     * @param modelName
     * @return
     */
    public GroqRequestBuilder setModel(String modelName) {
        this.groqRequestDTO.setModel(modelName);
        return this;
    }

    /**
     * Controls randomness: lowering results in less random completions.
     * As the temperature approaches zero, the model will become deterministic
     * and repetitive.
     * @param temperature
     * @return
     */
    public GroqRequestBuilder setTemperature(float temperature) {
        this.groqRequestDTO.setTemperature(temperature);
        return this;
    }

    public GroqRequestDTO build() {
        return this.groqRequestDTO;
    }
}
