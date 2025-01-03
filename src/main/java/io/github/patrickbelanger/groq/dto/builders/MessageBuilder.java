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

import io.github.patrickbelanger.groq.dto.requests.MessageDTO;
import io.github.patrickbelanger.groq.enums.GroqRoles;

public class MessageBuilder {
    private final MessageDTO message;

    public MessageBuilder() {
        this.message = new MessageDTO();
    }

    /**
     * Set role, helping the assistant to provide specific instructions
     * @param role
     * @return
     */
    public MessageBuilder setRole(GroqRoles role) {
        this.message.setRole(role);
        return this;
    }

    /**
     * Set message for the assistant to respond to.
     * @param content
     * @return
     */
    public MessageBuilder setContent(String content) {
        this.message.setContent(content);
        return this;
    }

    public MessageDTO build() {
        return this.message;
    }
}
