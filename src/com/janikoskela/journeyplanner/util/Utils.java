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
package com.janikoskela.journeyplanner.util;

import java.util.List;

/**
 *
 * @author janikoskela
 */
public abstract class Utils {
    
    /**
     * Transforms a list to a string which is passed to HSL API
     * 
     * @param list
     * @return 
     */
    public static String separateListWithVerticalLines(List<?> list) {
        String output = null;
        try {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0)
                    output = list.get(i).toString();
                else
                    output += "|" + list.get(i).toString();
            }
            return output;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Integer parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return null;
        }
    }
}
