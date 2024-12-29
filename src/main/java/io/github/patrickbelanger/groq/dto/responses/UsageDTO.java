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

package io.github.patrickbelanger.groq.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsageDTO {
    @JsonProperty("queue_time")
    private float queueTime;
    @JsonProperty("prompt_tokens")
    private int promptTokens;
    @JsonProperty("prompt_time")
    private float promptTime;
    @JsonProperty("completion_tokens")
    private int completionTokens;
    @JsonProperty("completion_time")
    private float completionTime;
    @JsonProperty("total_tokens")
    private int totalTokens;
    @JsonProperty("total_time")
    private float totalTime;

    public float getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(float queueTime) {
        this.queueTime = queueTime;
    }

    public int getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }

    public float getPromptTime() {
        return promptTime;
    }

    public void setPromptTime(float promptTime) {
        this.promptTime = promptTime;
    }

    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    public float getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(float completionTime) {
        this.completionTime = completionTime;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "UsageDTO{queueTime=%s, promptTokens=%d, promptTime=%s, completionTokens=%d, completionTime=%s, totalTokens=%d, totalTime=%s}"
            .formatted(queueTime, promptTokens, promptTime, completionTokens, completionTime, totalTokens, totalTime);
    }
}
