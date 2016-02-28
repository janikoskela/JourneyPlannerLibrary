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

import com.janikoskela.journeyplanner.annotation.URLParamKey;
import com.janikoskela.journeyplanner.exception.ConnectionException;
import com.janikoskela.journeyplanner.exception.ConnectionTimeoutException;
import com.janikoskela.journeyplanner.model.CoordinateSystem;
import com.janikoskela.journeyplanner.model.Stop;
import com.janikoskela.journeyplanner.parse.tre.TREParseFactory;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public class TREStopInformationRequest extends TRERequest implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;
    private final static String ACTION_NAME = "stop";
    
    /**
     * Stop's long JORE code, short code, stop name or stop address.
     */
    @URLParamKey("code")
    private String code;
    
    /**
     * Optional, default current date, YYYYMMDD.
     */
    private Date date;
    @URLParamKey("date")
    private String formattedDate;
    
    /**
     * Optional, default current time, HHMM.
     */
    private Date time;
    @URLParamKey("time")
    private String formattedTime;
    
    /**
     * Optional, default 120, max 360 minutes.
     */
    @URLParamKey("time_limit")
    private int timeLimit;
    
    /**
     * Optional, default 10, range 1-20.
     */
    @URLParamKey("dep_limit")
    private int departureLimit;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        try {
            this.formattedDate = new SimpleDateFormat("YYYYMMDD").format(date);
        } catch (Exception e) {}
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
        try {
            this.formattedTime = new SimpleDateFormat("HHMM").format(date);
        } catch (Exception e) {}
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getDepartureLimit() {
        return departureLimit;
    }

    public void setDepartureLimit(int departureLimit) {
        this.departureLimit = departureLimit;
    }

    public TREStopInformationRequest(String code, String apiUsername, String apiPassword, CoordinateSystem inCoordinateSystem, CoordinateSystem outCoordinateSystem) {
        super(apiUsername, apiPassword, inCoordinateSystem, outCoordinateSystem);
        this.code = code;
    }

    @Override
    protected List<Stop> parseResponse(String response) {
        return TREParseFactory.parseStopInformationResponse(response);
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
    public List<Stop> execute() throws ConnectionException, ConnectionTimeoutException {
        return super.execute();
    }
}
