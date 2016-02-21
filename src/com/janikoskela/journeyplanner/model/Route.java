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
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class Route implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;
    
    /**
     * Length of the route in meters.
     */
    private double length;
    
    /**
     * Duration of the route in seconds.
     */
    private double duration;
    /**
     * Array of legs (part of the route) of the route.
     */
    private List<RouteLeg> legs;

    public Route(double length, double duration, List<RouteLeg> legs) {
        this.length = length;
        this.duration = duration;
        this.legs = legs;
    }

    public Route() {
    }

    /**
     * Gets the length of the route in meters.
     *
     * @return  length   length
     */
    public double getLength() {
        return length;
    }

    /**
     * Gets the duration of the route in seconds.
     *
     * @return  duration   duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Gets the array of legs (part of the route) of the route.
     *
     * @return  legs   legs
     */
    public List<RouteLeg> getLegs() {
        return legs;
    }

    /**
     * Sets the length of the route in meters.
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Sets the duration of the route in seconds.
     * @param duration
     */
    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setLegs(List<RouteLeg> legs) {
        this.legs = legs;
    }
}
