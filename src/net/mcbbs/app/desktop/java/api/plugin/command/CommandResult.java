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

package net.mcbbs.app.desktop.java.api.plugin.command;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 执行结果与原因结合和类
 *
 * @param <R> 命令执行结果的参数类型
 * @author yinyangshi InitAuther97
 */
public class CommandResult<R> {
    private final CommandResultType type;
    private final List<? extends R> result;

    /**
     * @param type 命令结果类型
     * @param result 命令返回的结果参数
     */
    public CommandResult(CommandResultType type, R... result) {
        this.type = type;
        this.result = Lists.newArrayList(result);
    }

    /**
     * 获得命令结果Type
     * @return the type of the command
     */
    public CommandResultType getType() {
        return type;
    }

    /**
     * 获得命令结果的返回值
     * @return the list of the result, not the copy.
     */
    public List<? extends R> getResult() {
        return result;
    }
}
