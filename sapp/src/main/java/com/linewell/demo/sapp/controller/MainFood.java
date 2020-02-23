package com.linewell.demo.sapp.controller;

import org.apache.commons.codec.binary.Base64;

public class MainFood {

    public static void main(String[] args) {
        String auth = "eureka-client1" + ":" + "secret-test";
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);
        System.out.println("-------"+authHeader);
        System.out.print(authHeader);
    }

}
