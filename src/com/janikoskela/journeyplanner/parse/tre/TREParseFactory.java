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
package com.janikoskela.journeyplanner.parse.tre;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.janikoskela.journeyplanner.model.LocationType;
import com.janikoskela.journeyplanner.model.tre.Geocoding;
import com.janikoskela.journeyplanner.util.Utils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public abstract class TREParseFactory {
    
    public static List<com.janikoskela.journeyplanner.model.Geocoding> parseGeocodingResponse(String response) {
        Type listType = new TypeToken<List<Geocoding>>(){}.getType();
        List<Geocoding> result = parse(response, listType);
        List<com.janikoskela.journeyplanner.model.Geocoding> out = new ArrayList<>();
        for (Geocoding g : result) {
            com.janikoskela.journeyplanner.model.Geocoding geo = new com.janikoskela.journeyplanner.model.Geocoding();
            if (g.city != null)
                geo.setCity(g.city);
            if (g.coordinates != null) {
                String[] split = g.coordinates.split(",");
                if (split.length == 2) {
                    Double x = Utils.parseDouble(split[0]);
                    Double y = Utils.parseDouble(split[1]);
                    if (x != null && y != null) {
                        com.janikoskela.journeyplanner.model.Coordinates coord = new com.janikoskela.journeyplanner.model.Coordinates(x, y);
                        geo.setCoordinates(coord);
                    }
                }
            }
            if (g.details != null) {
                com.janikoskela.journeyplanner.model.LocationDetails details = new com.janikoskela.journeyplanner.model.LocationDetails();
                if (g.details.codes != null)
                    details.setCodes(g.details.codes);
                if (g.details.houseNumber != null)
                    details.setHouseNumber(g.details.houseNumber);
                if (g.details.poiClass != null)
                    details.setPoiClass(g.details.poiClass);
                geo.setDetails(details);
            }
            if (g.lang != null)
                geo.setLang(g.lang);
            if (g.matchedName != null)
                geo.setMatchedName(g.matchedName);
            if (g.name != null)
                geo.setName(g.name);
            if (g.locationType != null) {
                if (g.locationType.equals("address"))
                    geo.setLocationType(LocationType.ADDRESS);
                else if (g.locationType.equals("poi"))
                    geo.setLocationType(LocationType.POI);
                else if (g.locationType.equals("street"))
                    geo.setLocationType(LocationType.STREET);
                else if (g.locationType.equals("stop"))
                    geo.setLocationType(LocationType.STOP);
                else
                    geo.setLocationType(LocationType.UNKNOWN);
            }
            out.add(geo);
        }
        return out;
    }
    
    private static <T>List <T> parse(String response, Type listType) {
        return new Gson().fromJson(response, listType);    
    }
}
