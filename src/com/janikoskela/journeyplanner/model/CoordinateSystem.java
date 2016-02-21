/*
 * Copyright (C) 2016 janikoskela
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.janikoskela.journeyplanner.model;

/**
 *
 * @author janikoskela
 */
public enum CoordinateSystem {
    KKJ2("2392"), KKJ1("2391"), KKJ3("2393"), WGS84("4326"), Mercator("3395");

    private final String system;

    private CoordinateSystem(String system) {
        this.system = system;
    }

    @Override
    public String toString(){
        return system;
    }
}
