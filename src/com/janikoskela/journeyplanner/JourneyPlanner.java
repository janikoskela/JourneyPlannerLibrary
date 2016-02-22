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
package com.janikoskela.journeyplanner;

import com.janikoskela.journeyplanner.exception.ConnectionException;
import com.janikoskela.journeyplanner.exception.ConnectionTimeoutException;
import com.janikoskela.journeyplanner.model.Geocoding;
import com.janikoskela.journeyplanner.request.hsl.HSLGeocodingRequest;
import com.janikoskela.journeyplanner.request.hsl.HSLReverseGeocodingRequest;
import com.janikoskela.journeyplanner.request.tre.TREGeocodingRequest;
import com.janikoskela.journeyplanner.request.tre.TREReverseGeocodingRequest;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class JourneyPlanner {
    public static List<Geocoding> getHelsinkiRegionGeocoding(HSLGeocodingRequest request) throws ConnectionException, ConnectionTimeoutException {
        return request.execute();
    }
    
    public static List<Geocoding> getTampereRegionGeocoding(TREGeocodingRequest request) throws ConnectionException, ConnectionTimeoutException {
        return request.execute();
    }
    
    public static List<Geocoding> getHelsinkiRegionReverseGeocoding(HSLReverseGeocodingRequest request) throws ConnectionException, ConnectionTimeoutException {
        return request.execute();
    }
    
    public static List<Geocoding> getTampereRegionReverseGeocoding(TREReverseGeocodingRequest request) throws ConnectionException, ConnectionTimeoutException {
        return request.execute();
    }
    
}
