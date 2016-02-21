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
public class LineStop implements Serializable  {
    private static final long serialVersionUID = 7526472295622776147L;
    
    /**
     * An address of the stop
     */
    private String address;
    
    private String city;
    private String name;
    private String shortCode;
    private String code;
    
    /**
     * Estimated time in minutes it takes for the bus to reach the stop.
     */
    private double time;

    public LineStop(String address, String city, String name, String shortCode, String code, double time) {
        this.address = address;
        this.city = city;
        this.name = name;
        this.shortCode = shortCode;
        this.code = code;
        this.time = time;
    }

    public LineStop() {
    }

    /**
     * Gets the address
     *
     * @return  address  stop address
     */
    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getCode() {
        return code;
    }

    public double getTime() {
        return time;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
