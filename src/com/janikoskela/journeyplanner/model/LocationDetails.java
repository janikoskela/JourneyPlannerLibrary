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
public class LocationDetails implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    /**
     * House number.
    */
    private String houseNumber;
    
    /**
     * POI class
    */
    private String poiClass;
    
    /**
     * stop codes.
    */
    private String codes;

    public LocationDetails(String houseNumber, String poiClass, String codes) {
        this.houseNumber = houseNumber;
        this.poiClass = poiClass;
        this.codes = codes;
    }

    public LocationDetails() {
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPoiClass(String poiClass) {
        this.poiClass = poiClass;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }
    
    /**
     * Gets house number.
     *
     * @return  houseNumber   house number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Gets POI class.
     *
     * @return  poiClass   POI class
     */
    public String getPoiClass() {
        return poiClass;
    }

    /**
     * Gets stop codes.
     *
     * @return  codes   stop codes
     */
    public String getCodes() {
        return codes;
    }
}
