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

import com.janikoskela.journeyplanner.exception.ConnectionException;
import com.janikoskela.journeyplanner.model.CoordinateSystem;
import com.janikoskela.journeyplanner.request.HttpRequest;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public abstract class HSLRequest extends HttpRequest {
    private static final String BASE_URL = "http://api.reittiopas.fi/hsl/prod/?request=";
    private final String apiUsername;
    private final String apiPassword;
    private final CoordinateSystem inCoordinateSystem;
    private final CoordinateSystem outCoordinateSystem;
    
    public HSLRequest(String apiUsername, String apiPassword, CoordinateSystem inCoordinateSystem, CoordinateSystem outCoordinateSystem) {
        this.apiPassword = apiPassword;
        this.apiUsername = apiUsername;
        this.inCoordinateSystem = inCoordinateSystem;
        this.outCoordinateSystem = outCoordinateSystem;
    }
        
    @Override
    protected String getUrl() throws ConnectionException {
        return (BASE_URL + this.getActionName() + "&user=" + this.apiUsername + "&pass=" + this.apiPassword + "&epsg_in=" + this.inCoordinateSystem + "&epsg_out=" + this.outCoordinateSystem + "&format=json&" + this.getRequestUrl()).trim();
    }
    
    @Override
    protected abstract <T> List<T> parseResponse(String response);
    
    protected abstract String getActionName();
}
