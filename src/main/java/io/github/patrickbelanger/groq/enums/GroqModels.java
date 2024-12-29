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

import java.util.Arrays;
import java.util.List;

public enum GroqModels {
    // Production Models (as of 2024-12-28)
    DISTIL_WHISPER_LARGE_V3_EN("distil-whisper-large-v3-en", GroqDeveloper.HUGGING_FACE, false, false),
    GEMMA2_9B_IT("gemma2-9b-it", GroqDeveloper.GOOGLE, false, false),
    GEMMA_7B_IT("gemma-7b-it", GroqDeveloper.GOOGLE, false, true),
    LLAMA_3_3_70B_VERSATILE("llama-3.3-70b-versatile", GroqDeveloper.META, false, false),
    LLAMA_3_1_70B_VERSATILE("llama-3.1-70b-versatile", GroqDeveloper.META, false, true),
    LLAMA_3_1_8B_INSTANT("llama-3.1-8b-instant", GroqDeveloper.META, false, false),
    LLAMA_GUARD_3_8B("llama-guard-3-8b", GroqDeveloper.META, false, false),
    LLAMA3_70B_8192("llama3-70b-8192", GroqDeveloper.META, false, false),
    LLAMA3_8B_8192("llama3-8b-8192", GroqDeveloper.META, false, false),
    MIXTRAL_8X7B_32768("mixtral-8x7b-32768", GroqDeveloper.MISTRAL, false, false),
    WHISPER_LARGE_V3("whisper-large-v3", GroqDeveloper.OPENAI, false, false),
    WHISPER_LARGE_V3_TURBO("whisper-large-v3-turbo", GroqDeveloper.OPENAI, false, false),

    // Preview Models (as of 2024-12-28)
    LLAMA3_GROQ_70B_8192_TOOL_USE_PREVIEW("llama3-groq-70b-8192-tool-use-preview", GroqDeveloper.GROQ, true, false),
    LLAMA3_GROQ_8B_8192_TOOL_USE_PREVIEW("llama3-groq-8b-8192-tool-use-preview", GroqDeveloper.GROQ, true, false),
    LLAMA_3_3_70B_SPECDEC("llama-3.3-70b-specdec", GroqDeveloper.META, true, false),
    LLAMA_3_1_70B_SPECDEC("llama-3.1-70b-specdec", GroqDeveloper.META, true, false),
    LLAMA_3_2_1B_PREVIEW("llama-3.2-1b-preview", GroqDeveloper.META, true, false),
    LLAMA_3_2_3B_PREVIEW("llama-3.2-3b-preview", GroqDeveloper.META, true, false),
    LLAMA_3_2_11B_VISION_PREVIEW("llama-3.2-11b-vision-preview", GroqDeveloper.META, true, false),
    LLAMA_3_2_90B_VISION_PREVIEW("llama-3.2-90b-vision-preview", GroqDeveloper.META, true, false)
    ;

    private final String name;
    private final GroqDeveloper developer;
    private final boolean previewModel;
    private final boolean deprecated;

    GroqModels(final String name, final GroqDeveloper developer, final boolean previewModel, final boolean deprecated) {
        this.name = name;
        this.developer = developer;
        this.previewModel = previewModel;
        this.deprecated = deprecated;
    }

    public String getName() {
        return name;
    }

    public GroqDeveloper getDeveloper() {
        return developer;
    }

    public boolean isPreviewModel() {
        return previewModel;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public static GroqModels getModel(final String name) {
       return Arrays.stream(GroqModels.values()).filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }

    public static List<GroqModels> getModels() {
        return Arrays.stream(GroqModels.values()).toList();
    }

    public static List<GroqModels> getDeprecatedModels() {
        return Arrays.stream(GroqModels.values()).filter(m -> m.deprecated).toList();
    }

    public static List<GroqModels> getPreviewModels() {
        return Arrays.stream(GroqModels.values()).filter(m -> m.previewModel).toList();
    }

}
