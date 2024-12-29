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

package io.github.patrickbelanger.groq.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.patrickbelanger.groq.dto.responses.ChoicesDTO;
import io.github.patrickbelanger.groq.dto.responses.UsageDTO;
import io.github.patrickbelanger.groq.dto.responses.XGroqDTO;

import java.util.List;

public class GroqResponseDTO {
    private String id;
    private String object;
    private String model;
    private List<ChoicesDTO> choices;
    private UsageDTO usage;
    @JsonProperty("x_groq")
    private XGroqDTO xgroq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChoicesDTO> getChoices() {
        return choices;
    }

    public void setChoices(List<ChoicesDTO> choices) {
        this.choices = choices;
    }

    public UsageDTO getUsage() {
        return usage;
    }

    public void setUsage(UsageDTO usage) {
        this.usage = usage;
    }

    public XGroqDTO getXgroq() {
        return xgroq;
    }

    public void setXgroq(XGroqDTO xgroq) {
        this.xgroq = xgroq;
    }

    @Override
    public String toString() {
        return "GroqResponseDTO{id='%s', object='%s', model='%s', choices=%s, usage=%s, xGroqDTO=%s}"
            .formatted(id, object, model, choices, usage, xgroq);
    }
}
