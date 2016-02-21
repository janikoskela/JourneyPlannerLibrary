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
public class RouteLeg implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;
    
    private TransportType transportType;
    
    /**
     * Length of the leg in meters.
     */
    private double length;
    
    /**
     * Duration of the leg in seconds.
     */
    private double duration;
    
    /**
     * Type of the leg: walk or transport type id.
     */
    private String type;
    
    /**
     * Line code.
     */
    private String code;
    
    /**
     * Aarray of locations on the leg (limited detail only lists start and end locations).
     */
    private List<Location> locations;
    
    /**
     * Shape (list of coordinates) of the leg (only in full detail).
     */
    private List<Coordinates> shape;

    public RouteLeg(double length, double duration, String type, String code, List<Location> locations, List<Coordinates> shape, TransportType transportType) {
        this.length = length;
        this.duration = duration;
        this.type = type;
        this.code = code;
        this.locations = locations;
        this.shape = shape;
        this.transportType = transportType;
    }

    public RouteLeg() {
    }
    
    /**
     * Gets the length of the leg in meters.
     *
     * @return  length   leg length
     */
    public double getLength() {
        return length;
    }

    /**
     * Gets the duration of the leg in seconds.
     *
     * @return  duration   leg duration
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Gets the type of the leg: walk or transport type id
     *
     * @return  type   leg type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the line code.
     *
     * @return  code   leg code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the array of locations on the leg (limited detail only lists start and end locations).
     *
     * @return  locations   locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Gets the list of coordinates of the leg.
     *
     * @return  shape   shapes
     */
    public List<Coordinates> getShape() {
        return shape;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void setShape(List<Coordinates> shape) {
        this.shape = shape;
    }
}
