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

package io.github.patrickbelanger.groq.client.validators;

import io.github.patrickbelanger.groq.client.exceptions.DeprecatedModelException;
import io.github.patrickbelanger.groq.enums.GroqModels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelValidator {
    static Logger logger = LoggerFactory.getLogger(ModelValidator.class);

    private static final String DEPRECATED_MODEL_WARNING = "Deprecated model {} - Deprecated models should not be used in production environments as they may be discontinued at short notice.";
    private static final String PREVIEW_MODEL_WARNING = "Preview model {} - Preview models are intended for evaluation purposes only and should not be used in production environments as they may be discontinued at short notice.";

    public static void validateModel(String model) {
        GroqModels currentModel = GroqModels.getModel(model);
        if (currentModel.isDeprecated()) {
            logger.warn(DEPRECATED_MODEL_WARNING, currentModel.getName());
            throw new DeprecatedModelException();
        }
        if (currentModel.isPreviewModel()) {
            logger.warn(PREVIEW_MODEL_WARNING, currentModel.getName());
        }
    }
}
