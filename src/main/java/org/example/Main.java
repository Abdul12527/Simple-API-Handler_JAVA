package org.example;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        ApiHandler api1=new ApiHandler("https://api.chucknorris.io/jokes/random");
//        JSONObject out1= api1.callApi();
//        System.out.println(out1);
//        for(var i:out1.keySet()){
//            System.out.println(i+":"+out1.get(i));
//
//        }
        ApiHandler api2=new ApiHandler("https://api.zippopotam.us/us/33162");
        JSONObject out2= api2.callApi();
        System.out.println(out2);
        for(var i:out2.keySet()){
            System.out.println(i+":"+out2.get(i));

        }



    }
}