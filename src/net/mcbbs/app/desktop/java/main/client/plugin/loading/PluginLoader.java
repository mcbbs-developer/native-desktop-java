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

package net.mcbbs.app.desktop.java.main.client.plugin.loading;

import net.mcbbs.app.desktop.java.api.plugin.BoxedPlugin;
import net.mcbbs.app.desktop.java.api.plugin.IPlugin;

import java.util.jar.JarFile;

public abstract class PluginLoader {
    public abstract JarFile getPluginJar(String pluginId);

    public abstract BoxedPlugin getPlugin(String pluginId);

    public abstract void loadPlugin(String baseLoc);

    public abstract State getState();

    public abstract boolean isPluginLoaded(IPlugin plugin);
}
