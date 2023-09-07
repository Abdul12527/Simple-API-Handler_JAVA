package org.example;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        ApiHandler api1=new ApiHandler("https://api.chucknorris.io/jokes/random");
        JSONObject out1= api1.callApi();
        System.out.println(out1);
        for(var i:out1.keySet()){
            System.out.println(i+":"+out1.get(i));

        }



    }
}