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
public class Geocoding implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    /**
     * Type of the location: street, address, poi (point of interest) or stop.
     */
    private LocationType locationType;
    
    /**
     * Name of the location.
     */
    private String name;
    
    /**
     * Name of the location in that was matched with the search key.
     */
    private String matchedName;
    
    /**
     * Language of the matched name of the location.
     */
    private String lang;
    
    /**
     * Name of the city the location is in.
     */
    private String city;
    
    /**
     * Wrapped coordinates of the location.
     */
    private Coordinates coordinates;
    
    /**
     * Detailed information about the location such as houseNumber for addresses, poiClass for POIs and codes for stops.
     */
    private LocationDetails details;

    public Geocoding(LocationType locationType, String name, String matchedName, String lang, String city, Coordinates coordinates, LocationDetails details) {
        this.locationType = locationType;
        this.name = name;
        this.matchedName = matchedName;
        this.lang = lang;
        this.city = city;
        this.coordinates = coordinates;
        this.details = details;
    }

    public Geocoding() {
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatchedName() {
        return matchedName;
    }

    public void setMatchedName(String matchedName) {
        this.matchedName = matchedName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocationDetails getDetails() {
        return details;
    }

    public void setDetails(LocationDetails details) {
        this.details = details;
    }
    
    @Override
    public boolean equals(Object obj) {
        try {
            if (this == obj)
                return true;
            if ((obj == null) || (obj.getClass() != this.getClass()))
                return false;
            Geocoding res = (Geocoding) obj;
            Coordinates resCoordinate = res.getCoordinates();
            Coordinates c = this.getCoordinates();
            if (c != null && resCoordinate != null) {
                if (res.coordinates.getX() == this.coordinates.getX() && res.getName().equals(this.getName()) && res.coordinates.getY() == this.coordinates.getY())
                    return true;
            }
            else {
                if (res.getName().equals(this.getName()))
                    return true;
            }
        } catch (Exception e) {}
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 + hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 47 + hash + (this.coordinates != null ? this.coordinates.hashCode() : 0);
        return hash;
    }
}
