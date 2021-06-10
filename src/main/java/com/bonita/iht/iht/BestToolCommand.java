/**
 * Copyright (C) 2021 Bonitasoft S.A.
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.bonita.iht.iht;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;

@Component
@Command(name = "bestTool",
        description = "Truth about the best tool to use, depending on your definition of truth :)")
public class BestToolCommand implements Callable<Integer> {

    @Mixin
    Mode mode;

    @Override
    public Integer call() throws Exception {
        System.out.println("Mode: " + mode.mode.toString());

        switch (mode.mode) {
            case HONNEST:
                System.out.println("Quarkus 4ever");
                return 0;
            case DELUSIONAL:
            default:
                System.out.println("Yeah Spring framework will bring us to mars");
                return 1;
        }
    }

}
