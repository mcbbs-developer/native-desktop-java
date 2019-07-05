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

import net.mcbbs.app.desktop.java.plugin.minecraft.game.info.GameConfig;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class GameRepo {
    private final Path gameRoot;
    private Path gameRepo;
    private Path versionCfgs;
    public GameRepo(@Nonnull Path gameRoot){
        this.gameRoot=gameRoot;
    }

    public void initialize() throws IOException {
        gameRepo = gameRoot.resolve("versions");
        versionCfgs = gameRoot.resolve("verCfg");
        Stream<Path> games = Files.list(gameRepo);
        games.forEach(path -> {
            try {
                loadGame(path);
            } catch (IOException | InvalidGameException e) {
                e.printStackTrace();
            }
        });
    }

    private GameRoot loadGame(Path path) throws IOException, InvalidGameException {
        Files.walkFileTree(path, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                if(path.endsWith(".jar")){
                    path.g
                }
            }

            @Override
            public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
        return new GameRoot(this,new GameConfig(versionCfgs.resolve()))
    }

    public GameRoot require(String version) {

    }
}
