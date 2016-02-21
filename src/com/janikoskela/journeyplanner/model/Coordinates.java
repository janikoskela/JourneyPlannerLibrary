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

import java.io.Serializable;

/**
 *
 * @author janikoskela
 */
public class Coordinates implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    /**
     * X-coordinate.
     */
    private double x;
    
    /**
     * Y-coordinate.
     */
    private double y;

    /**
     * Creates a coordinate
     * @param x
     * @param y
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    /**
     * Gets the x-coordinate.
     *
     * @return  x   x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate.
     *
     * @return  y   y-coordinate
     */
    public double getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return this.getX() + "," + this.getY();
    }
}
