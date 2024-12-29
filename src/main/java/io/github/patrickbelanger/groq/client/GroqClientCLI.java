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

package io.github.patrickbelanger.groq.client;

import io.github.patrickbelanger.groq.client.cli.CLISelector;
import io.github.patrickbelanger.groq.dto.GroqResponseDTO;
import io.github.patrickbelanger.groq.dto.builders.GroqRequestBuilder;
import io.github.patrickbelanger.groq.dto.builders.MessageBuilder;
import io.github.patrickbelanger.groq.enums.GroqModels;
import io.github.patrickbelanger.groq.enums.GroqRoles;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.AttributedString;
import org.jline.utils.InfoCmp;

public class GroqClientCLI {

    private final LineReader lineReader;
    private final Terminal terminal;

    public GroqClientCLI() throws Exception {
        System.setProperty("org.jline.terminal.dumb", "true");
        terminal = TerminalBuilder.builder()
            .system(true)
            .build();
        terminal.puts(InfoCmp.Capability.clear_screen);
        lineReader = LineReaderBuilder.builder().terminal(terminal).build();
    }

    public GroqModels selectModel() throws Exception {
        CLISelector selector = new CLISelector(terminal);
        return selector.selectItem(GroqModels.getModels(), GroqModels::getName);
    }

    public void chat(GroqModels model) {
        terminal.puts(InfoCmp.Capability.clear_screen);
        terminal.writer().println(AttributedString.fromAnsi("\u001b[36mGroq® Client CLI\u001b[0m (C) Copyright 2024, Patrick Belanger. All rights reserved.").toAnsi());
        terminal.writer().println(AttributedString.fromAnsi("\u001b[36mVersion\u001b[0m 1.0.0-SNAPSHOT.").toAnsi());
        terminal.writer().println("Licensed under the Apache License, Version 2.0.\nYou may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0");
        terminal.writer().println("\nSetup complete! \uD83C\uDF89\n");
        terminal.writer().println("⚠\uFE0F By using this service and client, you agree to comply with the Terms of Use and Conditions of the\n   selected model.");
        terminal.writer().println("\uD83D\uDCE2 Notice: Groq® is a trademark of Groq, Inc. This CLI and Client library are not affiliated with Groq, Inc.\n   This client and library are provided as interfaces to communicate with the Groq API.\n   For more information, refer to Groq's Trademark Policy. (https://groq.com/trademark-policy/)\n\n");
        terminal.writer().println(String.format("You’ve selected the model: \u001b[32m%s\u001b[0m.\n\nYou can now start chatting with the agent. Type your message below to begin the conversation!", model.getName()));
        terminal.writer().println("Please avoid sharing sensitive or confidential information.\n\n");

        try {
            GroqClient client = new GroqClient();
            GroqRequestBuilder requestBuilder = new GroqRequestBuilder().setModel(model);

            while(true) {
                String chatInput = lineReader.readLine(AttributedString.fromAnsi("\u001b[32mYou\u001b[0m: ").toAnsi());
                requestBuilder.setMessage(
                    new MessageBuilder()
                        .setRole(GroqRoles.USER)
                        .setContent(chatInput)
                        .build()
                );
                GroqResponseDTO response = client.createChatCompletion(requestBuilder.build());
                terminal.writer().println(AttributedString.fromAnsi("\u001b[35mAgent\u001b[0m: "
                        + response.getChoices().getFirst().getMessage().getContent()).toAnsi());
                terminal.flush();
            }
        } catch(Exception e) {
            terminal.writer().println("An error has occurred while chatting: " + e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        GroqClientCLI cli = new GroqClientCLI();
        GroqModels selectedModel = cli.selectModel();
        cli.chat(selectedModel);
    }
}
