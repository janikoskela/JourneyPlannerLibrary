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
package com.janikoskela.journeyplanner.parse;

import java.net.IDN;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author janikoskela
 */
public abstract class JSONParser {
    protected static String getString(JSONObject obj, String key) {
        try {
            String value = obj.getString(key);
            return IDN.toUnicode(value);
        } catch (Exception e) {
            return null;
        }
    }
    
    protected static JSONArray getJSONArray(JSONObject obj, String key) {
        try {
            return obj.getJSONArray(key);
        } catch (Exception e) {
            return null;
        }
    }
    
    protected static Long getLong(JSONObject obj, String key) {
        try {
            return obj.getLong(key);
        } catch (Exception e) {
            return null;
        }
    }
}
