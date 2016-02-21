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
package com.janikoskela.journeyplanner.request.hsl;

import com.janikoskela.journeyplanner.annotation.URLParamKey;
import com.janikoskela.journeyplanner.exception.ConnectionException;
import com.janikoskela.journeyplanner.exception.ConnectionTimeoutException;
import com.janikoskela.journeyplanner.model.CoordinateSystem;
import com.janikoskela.journeyplanner.model.Coordinates;
import com.janikoskela.journeyplanner.model.Geocoding;
import com.janikoskela.journeyplanner.model.LocationType;
import com.janikoskela.journeyplanner.parse.hsl.ParseFactory;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class ReverseGeocodingRequest extends Request implements Serializable  {
    private static final long serialVersionUID = 7526472295622776147L;
    private final static String ACTION_NAME = "reverse_geocode";
    
    /**
     * Coordinates.
     */
    @URLParamKey("coordinate")
    private Coordinates coordinates;
    
    /**
     * Limit for the number of locations returned.
     */
    @URLParamKey("limit")
    private Integer limit;
    
    /**
     * Radius of the search in meters.
     */
    @URLParamKey("radius")
    private Integer radius;
    
    /**
     * Limit the search to given location types.
     */
    @URLParamKey("result_contains")
    private LocationType locationType;

    public ReverseGeocodingRequest(String apiUsername, String apiPassword, CoordinateSystem inCoordinateSystem, CoordinateSystem outCoordinateSystem, Coordinates coordinates) {
        super(apiUsername, apiPassword, inCoordinateSystem, outCoordinateSystem);
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    @Override
    protected List<Geocoding> parseResponse(String response) {
        return ParseFactory.parseGeocodingResponse(response);
    }

    @Override
    protected String getActionName() {
        return ACTION_NAME;
    }
    
    /**
     * Executes request
     *
     * @return  a list of GeocodingResources
     * @throws com.janikoskela.journeyplanner.exception.ConnectionException
     * @throws com.janikoskela.journeyplanner.exception.ConnectionTimeoutException
     */
    @Override
    public List<Geocoding> execute() throws ConnectionException, ConnectionTimeoutException {
        return super.execute();
    }
}
