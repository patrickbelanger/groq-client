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

package io.github.patrickbelanger.groq.dto.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import io.github.patrickbelanger.groq.enums.GroqRoles;

import java.io.IOException;

public class GroqRolesDeserializer extends JsonDeserializer<GroqRoles> {

    @Override
    public GroqRoles deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().toUpperCase();
        return switch (value) {
            case "ASSISTANT" -> GroqRoles.ASSISTANT;
            case "USER" -> GroqRoles.USER;
            case "SYSTEM" -> GroqRoles.SYSTEM;
            default -> throw new IllegalArgumentException("Unknown value: " + value);
        };
    }
}
