package com.acadgild.balu.acd_an_session_18_assignment_1_main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by BALU on 5/12/2016.
 */
public class JSONWeather
{
    private String mUrl;

    public JSONWeather(String url)
    {
        this.mUrl = url;
    }

    public String getJSON()
    {
        String response = "";

        try {
            URL url = new URL(mUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            response = convertInputStreamToString(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
}
