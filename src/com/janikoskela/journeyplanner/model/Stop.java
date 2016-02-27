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
public class Stop implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;
    
    /**
     * Unique, long code of the stop.
     */
    private String code;
    
    /**
     * Short code.
     */
    private String shortCode;
    
    /**
     * Name of the stop.
     */
    private String name;
    
    /**
     * Coordinates of the stop.
     */
    private Coordinates coordinates;
    
    /**
     * Stop's address.
     */
    private String address;
    
    /**
     * Link to the timetable page of the stop.
     */
    private String timetableLink;
    
    private String city;
    
    private List<Departure> departures;
    
    public Stop() {
        
    }

    public Stop(List<Departure> departures, String city, String code, String shortCode, String name, Coordinates coordinates, String address, String timetableLink) {
        this.code = code;
        this.shortCode = shortCode;
        this.name = name;
        this.coordinates = coordinates;
        this.address = address;
        this.timetableLink = timetableLink;
        this.city = city;
        this.departures = departures;
    }

    public List<Departure> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Departure> departures) {
        this.departures = departures;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimetableLink() {
        return timetableLink;
    }

    public void setTimetableLink(String timetableLink) {
        this.timetableLink = timetableLink;
    }
}
