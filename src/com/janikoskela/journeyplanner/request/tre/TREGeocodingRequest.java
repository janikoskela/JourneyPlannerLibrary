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
package com.janikoskela.journeyplanner.request.tre;

import com.janikoskela.journeyplanner.exception.ConnectionException;
import com.janikoskela.journeyplanner.model.City;
import com.janikoskela.journeyplanner.model.CoordinateSystem;
import com.janikoskela.journeyplanner.model.LocationType;
import com.janikoskela.journeyplanner.model.Geocoding;
import com.janikoskela.journeyplanner.parse.tre.TREParseFactory;
import java.io.Serializable;
import java.util.List;
import com.janikoskela.journeyplanner.annotation.URLParamKey;
import com.janikoskela.journeyplanner.exception.ConnectionTimeoutException;

/**
 *
 * @author janikoskela
 */
final public class TREGeocodingRequest extends TRERequest implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;
    private final static String ACTION_NAME = "geocode";

    /**
     * Search term.
     */
    @URLParamKey("key")
    private String searchTerm;
    
    /**
     * List of city names.
     */
    @URLParamKey("cities")
    private List<City> cities;
    
    /**
     * Location types.
     */
    @URLParamKey("loc_types")
    private List<LocationType> locTypes;
    
    /**
     * Disable levenshtein error correction.
     */
    @URLParamKey("disable_error_correction")
    private int disableErrorCorrection;
    
    /**
     * Disable unique stop names in the result.
     */
    @URLParamKey("disable_unique_stop_names")
    private int disableUniqueStopNames;

    public TREGeocodingRequest(String apiUsername, String apiPassword, CoordinateSystem inCoordinateSystem, CoordinateSystem outCoordinateSystem, String searchTerm) {
        super(apiUsername, apiPassword, inCoordinateSystem, outCoordinateSystem);
        this.searchTerm = searchTerm;
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

    /**
     * Sets the search term.
     *
     * @param  searchTerm   search term. Min length is 3 characters
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Limits the cities.
     * If not set all cities are valid
     *
     * @param  cities   list of cities. Allowed values are "helsinki", "espoo", "kauniainen", "kerava", "sipoo", "kirkkonummi" and "vantaa"
     */
    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    /**
     * Limits the location types.
     * If not set all location types are valid
     *
     * @param  locTypes   list of location types. Allowed values are "stop" and "address"
     */
    public void setLocTypes(List<LocationType> locTypes) {
        this.locTypes = locTypes;
    }

    /**
     * Sets if levenshtein error correction is used or not.
     * By default error correction is in use
     *
     * @param  disableErrorCorrection   if true error correction is not in use, if false error correction is in use
     */
    public void setDisableErrorCorrection(boolean disableErrorCorrection) {
        this.disableErrorCorrection = (disableErrorCorrection) ? 1 : 0;
    }

    /**
     * Sets if unique stop names are included in the result.
     * By default all stop names are included
     *
     * @param  disableUniqueStopNames   if true all stops are shown in the result, if false only one stop is included in the result for stops with same name
     */
    public void setDisableUniqueStopNames(boolean disableUniqueStopNames) {
        this.disableUniqueStopNames = (disableUniqueStopNames) ? 1 : 0;
    }

    /**
     * Gets the search term.
     *
     * @return  searchTerm   search term. Min length is 3 characters
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * Gets cities
     *
     * @return  cities   list of cities. Allowed values are "helsinki", "espoo", "kauniainen", "kerava", "sipoo", "kirkkonummi" and "vantaa"
     */
    public List<City> getCities() {
        return cities;
    }

    /**
     * Gets the location type limits.
     *
     * @return  locTypes   list of location types. Allowed values are "stop" and "address"
     */
    public List<LocationType> getLocTypes() {
        return locTypes;
    }

    /**
     * Gets information if levenshtein error correction is used or not.
     *
     * @return  disableErrorCorrection   if true error correction is not in use, if false error correction is in use
     */
    public int getDisableErrorCorrection() {
        return disableErrorCorrection;
    }

    /**
     * Gets information if unique stop names are included in the result.
     *
     * @return  disableUniqueStopNames   if true all stops are shown in the result, if false only one stop is included in the result for stops with same name
     */
    public int getDisableUniqueStopNames() {
        return disableUniqueStopNames;
    }
    
    @Override
    protected String getActionName() {
        return ACTION_NAME;
    }

    @Override
    protected List<Geocoding> parseResponse(String response) {
        return TREParseFactory.parseGeocodingResponse(response);
    }
}
