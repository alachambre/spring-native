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
package com.bonita.iht.best;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;

@Component
@Command(name = "bestWine",
        description = "Truth about the best wine to drink, depending on your definition of truth :)")
public class BestWineCommand implements Callable<Integer> {

    @Mixin
    Mode mode;

    @Override
    public Integer call() throws Exception {
        System.out.println("Mode: " + mode.mode.toString());

        switch (mode.mode) {
            case HONNEST:
                System.out.println("True men drink RED wine.");
                return 0;
            case DELUSIONAL:
            default:
                System.out.println("White wine is the sweetest thing on earth, a real gift from gods!");
                return 1;
        }
    }

}
