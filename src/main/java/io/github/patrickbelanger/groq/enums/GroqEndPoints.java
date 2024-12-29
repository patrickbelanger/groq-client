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

public enum GroqEndPoints {
    /**
     * Creates a model response for the given chat conversation. - Implemented
     */
    CREATE_CHAT_COMPLETION("/openai/v1/chat/completions"),
    /**
     * Transcribes audio into the input language. - To implement
     */
    CREATE_TRANSCRIPTION("/openai/v1/audio/transcriptions"),
    /**
     * Translates audio into English. - To implement
     **/
    CREATE_TRANSLATION("/openai/v1/audio/translations"),
    /**
     * List supported models - Implemented
     */
    LIST_MODELS("/openai/v1/models"),
    /**
     * Retrieve model - Implemented
     */
    RETREIVE_MODEL("/openai/v1/models/%s"),
    ;

    final String path;

    GroqEndPoints(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
