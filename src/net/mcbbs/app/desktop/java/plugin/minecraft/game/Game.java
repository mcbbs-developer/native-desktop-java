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

package net.mcbbs.app.desktop.java.plugin.minecraft.game;

import com.google.common.annotations.Beta;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Sets;
import org.shanerx.mojang.Mojang;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

public final class Game {
    public static final Mojang MOJANG = new Mojang();
    public static final UUID CLIENT_TOKEN = UUID.randomUUID();
    private static boolean INITIALIZED = false;

    static {
        init();
    }

    /**
     * Initialize basic information for launcher.
     */
    public static void init() {
        if (INITIALIZED) throw new IllegalStateException("Has already initialized:n.m.c.m.client.game.Game");
        MOJANG.connect();
        INITIALIZED = true;
    }

    /**
     * List the status of all the mojang server.
     * @return Map<ServerName:String,Ststus:[green:OK,yellow:issues,red:unreachable]>
     */
    public static Map<String, String> servicesStatus() {
        Map<String, String> result = Maps.newHashMap();
        for (Mojang.ServiceType type : Mojang.ServiceType.values()) {
            result.put(type.toString(), MOJANG.getStatus(type).name().replaceAll("_", ".").toLowerCase());
        }
        return Collections.unmodifiableMap(result);
    }

    public enum Type {

        /**
         * <strike>(香草)</strike>香子兰！(大雾)
         * 纯净版
         * Vanilla version.
         * 不知道的你自杀吧.
         * If you don't know what it is,you must delete your game and kill yourself.
         */
        VANILLA(
            "(1\\.(\\d|[1-9][0-9]?)\\.(\\d|[1-9][0-9]?))",
            "%d{2}w%d{2}[a-f]}",
            "(1\\.(\\d|[1-9][0-9]?)\\.(\\d|[1-9][0-9]?))-pre\\d*"
        ),
        /**
         * <strike>(锻造)</strike>
         * Forge就是Forge,不知道你就退游吧!
         * Forge is just Forge.If you haven't heard about that,you might have to go killing yourself!
         * Forge
         */
        FORGE(
              "(1\\.(\\d|[1-9][0-9]?)\\.(\\d|[1-9][0-9]?))-forge\\1-(\\d|[1-9][0-9]?)(\\.(\\d|([1-9][0-9]{1,3}))){3}",
              "(1\\.(\\d|[1-9][0-9]?)\\.(\\d|[1-9][0-9]?))-Forge(\\d|[1-9][0-9]?)(\\.(\\d|([1-9][0-9]{1,3}))){3}-\\1",
              "(1\\.(\\d|[1-9][0-9]?)\\.(\\d|[1-9][0-9]?))-forge-(\\d|[1-9][0-9]?)(\\.(\\d|([1-9][0-9]{1,3}))){0,3}",
              "(1\\.(\\d|[1-9][0-9]?)\\.(\\d|[1-9][0-9]?))-Forge(\\d|[1-9][0-9]?)(\\.(\\d|([1-9][0-9]{1,3}))){3}"
        ),
        /**
         * <strike>(Mod加载器)</strike>
         * ModLoader就是ModLoader,不过没人再用了:)(R.I.P.)
         * ModLoader is just ModLoader,but nobody uses it any more.:) (R.I.P.)
         * ModLoader&ModLoaderMP
         */
        @Deprecated MODLOADER,
        /**
         * <strike>(完善的设置)</strike>
         * 高清修复独立版
         * OptiFine's independent version.
         */
        OPTIFINE,
        /**
         * <strike>(轻量级加载器)</strike>
         * w about it,just search it on Google.If you can't understand what it is after reading documents,you might have to kill yourself.
         */
        LITELOADER,
        /**
         * <strike>(织物)</strike>
         * Fabric就是Fabric,没得谈,没听说过自行百度,支持中
         * Fabric is just Fabric,there's nothing to be discussed about.If you haven't heard about it,just search it on Google.Holding out API.
         * Fabric(1.14新轻量级mod api,正在努力支持)
         * Fabric(New mod api in 1.14,Trying holding out API)
         */
        @Beta FABRIC;
        Type(String... pttrn){
            for(String pattern:pttrn){
                patterns.add(Pattern.compile(pattern,Pattern.CASE_INSENSITIVE));
            }
        }


        static Map<String,String> map = Maps.newHashMap();
        Set<Pattern> patterns = Sets.newHashSet();
        public static Type verifyGameType(String gameId) throws InvalidGameException {
            for(Type type:values()){
                for(Pattern pattern:type.patterns){
                    if(pattern.matcher(gameId).matches()){
                        return type;
                    }
                }
            }
            throw new InvalidGameException("Unable to verify game type,it might be an illegal game.");
        }
    }
}
