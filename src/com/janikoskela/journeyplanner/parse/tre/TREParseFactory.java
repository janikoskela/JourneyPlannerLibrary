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

import com.janikoskela.journeyplanner.model.Coordinates;
import com.janikoskela.journeyplanner.model.Departure;
import com.janikoskela.journeyplanner.model.LocationType;
import com.janikoskela.journeyplanner.model.Geocoding;
import com.janikoskela.journeyplanner.model.LocationDetails;
import com.janikoskela.journeyplanner.model.Stop;
import com.janikoskela.journeyplanner.parse.JSONParser;
import com.janikoskela.journeyplanner.util.Utils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author janikoskela
 */
public abstract class TREParseFactory extends JSONParser {
    private final static String LOCATION_TYPE_STREET = "street";
    private final static String LOCATION_TYPE_ADDRESS = "address";
    private final static String LOCATION_TYPE_POI = "poi";
    private final static String LOCATION_TYPE_STOP = "stop";
    private final static String KEY_HOUSE_NUMBER = "houseNumber";
    private final static String KEY_POI_CLASS = "poiClass";
    private final static String KEY_CODES = "codes";
    private final static String KEY_COORDINATES = "coords";
    private final static String KEY_CITY = "city";
    private final static String KEY_NAME = "name";
    private final static String KEY_LANG = "lang";
    private final static String KEY_MATCHED_NAME = "matchedName";
    private final static String KEY_LOCATION_TYPE = "locType";
    private final static String KEY_DETAILS = "details";
    private final static String KEY_CODE = "code";
    private final static String KEY_SHORT_CODE = "code_short";
    private final static String KEY_TIMETABLE_LINK = "timetable_link";
    private final static String KEY_CITY_FINNISH = "city_fi";
    private final static String KEY_NAME_FINNISH = "name_fi";
    private final static String KEY_ADDRESS_FINNISH = "address_fi";
    private final static String KEY_DATE = "date";
    private final static String KEY_TIME = "time";
    private final static String KEY_DEPARTURES = "departures";
    
    public static Coordinates parseCoordinatesResponse(String response) {
        String[] split = response.split(",");
        if (split.length == 2) {
            Double x = Utils.parseDouble(split[0]);
            Double y = Utils.parseDouble(split[1]);
            if (x != null && y != null) {
                return new Coordinates(x, y);
            }
        }
        return null;
    }
    
    public static String parseShortCodeFromCode(String code) {
        char transportType = code.charAt(0);
        String shortCode = "";
        for (int i = 1; i < 5; i++) {
            char c = code.charAt(i);
            if (c != '0')
                shortCode += code.charAt(i);
        }
        char letterVariant = code.charAt(5);
        return shortCode.trim();
    }
    
    public static List<Departure> parseDeparturesResponse(JSONArray deps) {
        List<Departure> departures = new ArrayList<>();
        if (deps == null)
            return departures;
        Iterator i = deps.iterator();
        while (i.hasNext()) {
            try {
                Departure departure = new Departure();
                JSONObject obj = (JSONObject)i.next();
                String code = getString(obj, KEY_CODE);
                if (code != null) {
                    departure.setCode(code);
                    String shortCode = parseShortCodeFromCode(code);
                    departure.setShortCode(shortCode);
                }
                String date = getString(obj, KEY_DATE);
                if (date != null) {
                    Date d = new SimpleDateFormat("YYYYMMDD").parse(date);
                    departure.setDate(d);
                }
                String time = getString(obj, KEY_TIME);
                if (time != null) {
                    Date d = new SimpleDateFormat("HHmm").parse(time);
                    departure.setTime(d);
                }
                departures.add(departure);
            } catch (Exception e) {}
        }
        return departures;
    }
    
    public static List<Stop> parseStopInformationResponse(String response) {
        System.out.println(response);
        List<Stop> stops = new ArrayList<>();
        JSONArray arr;
        try {
            arr = new JSONArray(response);
        } catch (Exception e) {
            return stops;
        }
        Iterator i = arr.iterator();
        while (i.hasNext()) {
            try {
                Stop stop = new Stop();
                JSONObject obj = (JSONObject)i.next();
                Coordinates coordinates = parseCoordinatesResponse(getString(obj, KEY_COORDINATES));
                if (coordinates != null)
                    stop.setCoordinates(coordinates);
                else
                    continue;
                String code = getString(obj, KEY_CODE);
                if (code != null)
                    stop.setCode(code);
                String shortCode = getString(obj, KEY_SHORT_CODE);
                if (shortCode != null)
                    stop.setShortCode(shortCode);
                String name = getString(obj, KEY_NAME_FINNISH);
                if (name != null)
                    stop.setName(name);
                String city = getString(obj, KEY_CITY_FINNISH);
                if (city != null)
                    stop.setCity(city);
                String address = getString(obj, KEY_ADDRESS_FINNISH);
                if (address != null)
                    stop.setAddress(address);
                String timetableLink = getString(obj, KEY_TIMETABLE_LINK);
                if (timetableLink != null)
                    stop.setTimetableLink(timetableLink);
                JSONArray departures = getJSONArray(obj, KEY_DEPARTURES);
                stop.setDepartures(parseDeparturesResponse(departures));
                stops.add(stop);
            } catch (Exception e) {}
        }
        return stops;
    }
    
    public static LocationDetails parseDetailsResponse(String response) {
        LocationDetails details = new LocationDetails();
        JSONObject obj;
        try {
            obj = new JSONObject(response);
        } catch (Exception e) {
            return details;
        }
        String houseNumber = getString(obj, KEY_HOUSE_NUMBER);
        if (houseNumber != null)
            details.setHouseNumber(houseNumber);
        String poiClass = getString(obj, KEY_POI_CLASS);
        if (poiClass != null)
            details.setPoiClass(poiClass);
        String codes = getString(obj, KEY_CODES);
        if (codes != null)
            details.setCodes(codes);
        return details;
    }
    
    public static LocationType parseLocationTypeResponse(String response) {
        if (response != null) {
            switch(response) {
                case LOCATION_TYPE_STREET:
                    return LocationType.STREET;
                case LOCATION_TYPE_POI:
                    return LocationType.POI;
                case LOCATION_TYPE_ADDRESS:
                    return LocationType.ADDRESS;
                case LOCATION_TYPE_STOP:
                    return LocationType.STOP;
            }
        }
        return LocationType.UNKNOWN;
    }
    
    public static List<Geocoding> parseGeocodingResponse(String response) {
        List<Geocoding> geocodings = new ArrayList<>();
        JSONArray list;
        try {
            list = new JSONArray(response);
        } catch (Exception e) {
            return geocodings;
        }
        Iterator i = list.iterator();
        while (i.hasNext()) {
            try {
                JSONObject obj = (JSONObject)i.next();
                Geocoding geocode = new Geocoding();
                Coordinates coordinates = parseCoordinatesResponse(getString(obj, KEY_COORDINATES));
                if (coordinates != null)
                    geocode.setCoordinates(coordinates);
                else
                    continue;
                String city = getString(obj, KEY_CITY);
                if (city != null)
                    geocode.setCity(city);
                String locationType = getString(obj, KEY_LOCATION_TYPE);
                geocode.setLocationType(parseLocationTypeResponse(locationType));
                String name = getString(obj, KEY_NAME);
                if (name != null)
                    geocode.setName(name);
                String matchedName = getString(obj, KEY_MATCHED_NAME);
                if (matchedName != null)
                    geocode.setMatchedName(matchedName);
                String lang = getString(obj, KEY_LANG);
                if (lang != null)
                    geocode.setLang(lang);
                geocode.setDetails(parseDetailsResponse(getString(obj, KEY_DETAILS)));
                geocodings.add(geocode);
            } catch (Exception e) {}
        }
        return geocodings;
    }
}
