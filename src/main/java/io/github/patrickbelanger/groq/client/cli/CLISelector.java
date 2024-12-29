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

package io.github.patrickbelanger.groq.client.cli;

import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.InfoCmp;

import java.util.List;
import java.util.function.Function;

import static org.jline.keymap.KeyMap.key;

public class CLISelector {

    private final Terminal terminal;
    private final BindingReader bindingReader;

    public CLISelector(Terminal terminal) {
        this.terminal = terminal;
        this.bindingReader = new BindingReader(terminal.reader());
    }

    public <T> T selectItem(List<T> items, Function<T, String> displayFunction) {
        KeyMap<Keys> keyMap = new KeyMap<>();
        keyMap.bind(Keys.UP, key(terminal, InfoCmp.Capability.key_up));
        keyMap.bind(Keys.DOWN, key(terminal, InfoCmp.Capability.key_down));
        keyMap.bind(Keys.ENTER, "\r");

        int index = 0;

        while (true) {
            terminal.writer().println("\nSelect an item using UP/DOWN keys and press ENTER:");
            for (int i = 0; i < items.size(); i++) {
                String itemName = displayFunction.apply(items.get(i));
                if (i == index) {
                    terminal.writer().println(AttributedString.fromAnsi("> \u001b[32m" + itemName + "\u001b[0m").toAnsi());
                } else {
                    terminal.writer().println("  " + itemName);
                }
            }

            terminal.flush();
            terminal.enterRawMode();

            switch (bindingReader.readBinding(keyMap)) {
                case Keys.UP:
                    index = (index - 1 + items.size()) % items.size();
                    break;
                case Keys.DOWN:
                    index = (index + 1) % items.size();
                    break;
                case Keys.ENTER:
                    T selectedItem = items.get(index);
                    terminal.writer().println("");
                    terminal.writer().println(AttributedString.fromAnsi("Selected: \u001b[32m" + displayFunction.apply(selectedItem) + "\u001b[0m").toAnsi());
                    return selectedItem;
                default:
                    terminal.writer().println("Invalid key pressed. Use arrow keys to navigate.");
                    break;
            }

            terminal.puts(InfoCmp.Capability.clear_screen);
        }
    }
}
