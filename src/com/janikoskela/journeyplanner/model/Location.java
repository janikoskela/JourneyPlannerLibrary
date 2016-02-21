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
import java.util.Date;

/**
 *
 * @author janikoskela
 */
public class Location implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    /**
     * Coordinate of the location.
     */
    private Coordinates coordinates;
    
    /**
     * Arrival time to the location.
     */
    private Date arrivalTime;
    
    /**
     * Departure time from the location.
     */
    private Date departureTime;
    
    /**
     * Name of the location.
     */
    private String name;
    
    /**
     * Long code of the stop.
     */
    private String code;
    
    /**
     * Short code of the stop.
     */
    private String shortCode;
    
    /**
     * Address of the stop.
     */
    private String stopAddress;

    public Location(Coordinates coordinates, Date arrivalTime, Date departureTime, String name, String code, String shortCode, String stopAddress) {
        this.coordinates = coordinates;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.name = name;
        this.code = code;
        this.shortCode = shortCode;
        this.stopAddress = stopAddress;
    }

    public Location() {
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getStopAddress() {
        return stopAddress;
    }

    public void setStopAddress(String stopAddress) {
        this.stopAddress = stopAddress;
    }

}
