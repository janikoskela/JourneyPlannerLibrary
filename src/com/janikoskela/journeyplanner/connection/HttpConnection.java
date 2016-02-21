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
package com.janikoskela.journeyplanner.connection;

import com.janikoskela.journeyplanner.exception.ConnectionException;
import com.janikoskela.journeyplanner.exception.ConnectionTimeoutException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 *
 * @author janikoskela
 */
public abstract class HttpConnection {
    private final static int TIME_OUT_LENGTH = 10000;
    
    public static String sendRequest(String url) throws ConnectionException, ConnectionTimeoutException {
        InputStream in = null;
        HttpURLConnection urlConnection = null;
        try {
            URL u = new URL(url);
            urlConnection = (HttpURLConnection) u.openConnection();
            urlConnection.setReadTimeout(TIME_OUT_LENGTH);
            HttpURLConnection.setFollowRedirects(false);
            if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK)
                throw new ConnectionException(urlConnection.getResponseMessage());
            in = new BufferedInputStream(urlConnection.getInputStream());
            return HttpConnection.readStream(in);
        } catch (SocketTimeoutException e) {
            throw new ConnectionTimeoutException();
        } catch (IOException | ConnectionException ex) {
            throw new ConnectionException(ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ex) {
                    throw new ConnectionException(ex.getMessage());
                }
            }
            if (urlConnection != null) {
                try {
                    urlConnection.disconnect();
                } catch (Exception e) {
                    throw new ConnectionException(e.getMessage());
                }
            }
        }
    }
    
    private static String readStream(InputStream in) throws IOException {
        String line;
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while((line = r.readLine()) != null) 
                sb.append(line);
        return sb.toString();
    }
}
