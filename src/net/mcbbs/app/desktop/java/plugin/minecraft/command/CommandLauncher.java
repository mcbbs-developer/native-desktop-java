/*
  Copyright 2019 langyo<langyo.china@gmail.com> and contributors

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */

package net.mcbbs.client.plugin.minecraft.command;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.mcbbs.client.api.plugin.command.CommandResult;
import net.mcbbs.client.api.plugin.command.CommandResultType;
import net.mcbbs.client.api.plugin.command.IPluginCommand;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Map;

public class CommandLauncher implements IPluginCommand<Void,Void> {
    private final Map<String,IPluginCommand> childCommands = Maps.asMap(Sets.newHashSet("launch", "version"), new Function<String, IPluginCommand>() {
        @Nullable
        @Override
        public IPluginCommand apply(@Nullable String s) {
            switch (s){
                case "launch":
                    return new CommandLaunch();
                case "version":
                    return new CommandVersion();
                default:
                    throw new UnsupportedOperationException();
            }
        }
    });
    @Override
    public CommandResult<Void> execute(Void arg) {
        return new CommandResult<>(CommandResultType.IGNORE);
    }

    @Override
    public Class<Void> argumentType() {
        return Void.class;
    }

    @Override
    public String usage() {
        return "Child commands:[launch:void throws LaunchException,version version:string :boolean]";
    }

    @Override
    public IPluginCommand childCommand(String child) {
        return null;
    }

    public static final class CommandLaunch implements IPluginCommand<Void,String>{

        @Override
        public CommandResult<String> execute(Void arg) {
            return null;
        }

        @Override
        public Class<Void> argumentType() {
            return null;
        }

        @Override
        public String usage() {
            return null;
        }

        @Override
        public IPluginCommand childCommand(String child) {
            return null;
        }
    }

    public static final class CommandVersion implements IPluginCommand<String,Boolean> {
        @Override
        public CommandResult<Boolean> execute(String arg) {
            return null;
        }

        @Override
        public Class<String> argumentType() {
            return null;
        }

        @Override
        public String usage() {
            return null;
        }

        @Override
        public IPluginCommand childCommand(String child) {
            return null;
        }
    }
}
