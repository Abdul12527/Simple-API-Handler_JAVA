package org.example;

import org.json.JSONObject;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiHandler {
    private String apiUrl;

    public ApiHandler(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    JSONObject callApi(){
        URL url=null;
        HttpURLConnection connection=null;
        int respCode=0;

        try {
            url=new URL(apiUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection=(HttpURLConnection)url.openConnection();
            respCode=connection.getResponseCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(respCode!=200)return new JSONObject("Not possble","null");

        BufferedReader rawdata=null;
        try {
            rawdata=new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder data=new StringBuilder();
        String readLine = null;

        while(true)
        {
            try {
                if ((readLine = rawdata.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            data.append(readLine);
        }
        JSONObject jsonAPIResponse = new JSONObject(data.toString());
        return jsonAPIResponse;
    }
}
