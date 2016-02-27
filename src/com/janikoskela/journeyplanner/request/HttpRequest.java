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
package com.janikoskela.journeyplanner.request;

import com.janikoskela.journeyplanner.annotation.URLParamKey;
import com.janikoskela.journeyplanner.connection.HttpConnection;
import com.janikoskela.journeyplanner.exception.ConnectionException;
import com.janikoskela.journeyplanner.exception.ConnectionTimeoutException;
import com.janikoskela.journeyplanner.model.Coordinates;
import com.janikoskela.journeyplanner.util.Utils;
import java.lang.reflect.Field;
import java.net.URI;
import java.util.List;

/**
 *
 * @author janikoskela
 */
public abstract class HttpRequest {

    protected String getRequestUrl() throws ConnectionException {
        String requestUrl = "";
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                String key = field.getAnnotation(URLParamKey.class).value();
                String value;
                if (field.get(this) instanceof List) {
                    value = Utils.separateListWithVerticalLines((List) field.get(this));
                } else if (field.get(this) instanceof Coordinates) {
                    value = ((Coordinates) field.get(this)).toString();
                } else {
                    value = field.get(this).toString();
                }
                if (value != null) {
                    requestUrl += key + "=" + value + "&";
                }
            }catch (Exception e) {}
        }
        if (requestUrl.endsWith(("&")))
            requestUrl = requestUrl.substring(0, requestUrl.length() - 1);
        try {
            return new URI(requestUrl).toASCIIString();
        } catch (Exception e) {
            throw new ConnectionException("Request url was formed incorrectly");
        }
    }
    
    protected <T> List<T> execute() throws ConnectionException, ConnectionTimeoutException {
        String url = this.getUrl();
        String resp = HttpConnection.sendRequest(url);
        return this.parseResponse(resp);
    }
    
    protected abstract String getUrl() throws ConnectionException;
    protected abstract <T> List<T> parseResponse(String response);
}
