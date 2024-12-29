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
import io.github.patrickbelanger.groq.dto.requests.MessageDTO;

public class ChoicesDTO {
    private long index;
    private MessageDTO message;
    private String logprobs;
    @JsonProperty("finish_reason")
    private String finishReason;
    private UsageDTO usage;

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public MessageDTO getMessage() {
        return message;
    }

    public void setMessage(MessageDTO message) {
        this.message = message;
    }

    public String getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(String logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public UsageDTO getUsage() {
        return usage;
    }

    private void setUsage(UsageDTO usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "ChoicesDTO{index=%d, message=%s, logprobs='%s', finishReason='%s', usage=%s}"
            .formatted(index, message, logprobs, finishReason, usage);
    }
}
