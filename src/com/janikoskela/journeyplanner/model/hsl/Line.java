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
package com.janikoskela.journeyplanner.model.hsl;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class Line {
    
    /**
     * Unique, long code of the line, e.g. 2102T 1.
     */
    @SerializedName("code")
    public String code;
    
    /**
     * Short code of the line (shown on the bus, e.g. 102T.
     */
    @SerializedName("code_short")
    public String shortCode;
    
    /**
     * Name of the start stop.
     */
    @SerializedName("line_start")
    public String startStopName;
    
    /**
     * Name of the end stop.
     */
    @SerializedName("line_end")
    public String endStopName;
    
    /**
     * Name of the line.
     */
    @SerializedName("name")
    public String name;
    
    /**
     * URL of the timetable page for the line.
     */
    @SerializedName("timetable_url")
    public String timetableUrl;
    
    /**
     * Array of stops the line passes.
     */
    @SerializedName("line_stops")
    public List<LineStop> lineStops;
    
    /**
     * The shape of the line's route as a list of coordinates.
     */
    @SerializedName("line_shape")
    public List<Coordinates> lineShape;
    
    public Line() {}
}
