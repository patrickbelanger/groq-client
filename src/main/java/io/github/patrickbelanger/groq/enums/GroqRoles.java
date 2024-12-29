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

package io.github.patrickbelanger.groq.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum GroqRoles {
    /**
     * Assistant role: Represents the AI model responding to the user.
     */
    ASSISTANT("assistant"),
    /**
     * System role: Sets the assistant's behavior and can be used to provide specific instructions
     * for how it should behave throughout the conversation.
     */
    SYSTEM("system"),
    /**
     * User role: Sets the role to send messages for the assistant to respond to.
     */
    USER("user")
    ;

    private final String roleName;

    GroqRoles(String roleName) {
        this.roleName = roleName;
    }

    @JsonCreator
    public static GroqRoles fromValue(String value) {
        return Arrays.stream(GroqRoles.values())
            .filter(role -> role.roleName.equalsIgnoreCase(value))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Unknown role: " + value));
    }

    @JsonValue
    public String getRoleName() {
        return roleName;
    }
}
