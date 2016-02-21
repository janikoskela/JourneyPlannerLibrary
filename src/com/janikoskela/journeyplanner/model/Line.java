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
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class Line implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;

    /**
     * Unique, long code of the line, e.g. 2102T 1.
     */
    private String code;
    
    /**
     * Short code of the line (shown on the bus, e.g. 102T.
     */
    private String shortCode;
    
    /**
     * Name of the start stop.
     */
    private String startStopName;
    
    /**
     * Name of the end stop.
     */
    private String endStopName;
    
    /**
     * Name of the line.
     */
    private String name;
    
    /**
     * URL of the timetable page for the line.
     */
    private String timetableUrl;
    
    /**
     * Array of stops the line passes.
     */
    private List<LineStop> lineStops;
    
    /**
     * The shape of the line's route as a list of coordinates.
     */
    private List<Coordinates> lineShape;

    public Line(String code, String shortCode, String startStopName, String endStopName, String name, String timetableUrl, List<LineStop> lineStops, List<Coordinates> lineShape) {
        this.code = code;
        this.shortCode = shortCode;
        this.startStopName = startStopName;
        this.endStopName = endStopName;
        this.name = name;
        this.timetableUrl = timetableUrl;
        this.lineStops = lineStops;
        this.lineShape = lineShape;
    }

    public Line() {
    }

    /**
     * Gets the unique, long code of the line, e.g. 2102T 1.
     *
     * @return  code   code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the short code of the line (shown on the bus, e.g. 102T.
     *
     * @return  code_short   short code
     */
    public String getShortCode() {
        return shortCode;
    }
    
    /**
     * Gets the name of the start stop.
     *
     * @return  line_start   start stop name
     */
    public String getLineStart() {
        return startStopName;
    }

    /**
     * Gets the name of the end stop.
     *
     * @return  line_end   end stop name
     */
    public String getLineEnd() {
        return endStopName;
    }

    /**
     * Gets the name of the line.
     *
     * @return  name   name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the URL of the timetable page for the line.
     *
     * @return  timetableUrl   timetable url
     */
    public String getTimetableUrl() {
        return timetableUrl;
    }

    /**
     * Gets the array of stops the line passes.
     *
     * @return  lineStops   line stops
     */
    public List<LineStop> getLineStops() {
        return lineStops;
    }

    public String getStartStopName() {
        return startStopName;
    }

    public String getEndStopName() {
        return endStopName;
    }

    public List<Coordinates> getLineShape() {
        return lineShape;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartStopName(String startStopName) {
        this.startStopName = startStopName;
    }

    public void setEndStopName(String endStopName) {
        this.endStopName = endStopName;
    }

    public void setTimetableUrl(String timetableUrl) {
        this.timetableUrl = timetableUrl;
    }

    public void setLineStops(List<LineStop> lineStops) {
        this.lineStops = lineStops;
    }

    public void setLineShape(List<Coordinates> lineShape) {
        this.lineShape = lineShape;
    }
}
