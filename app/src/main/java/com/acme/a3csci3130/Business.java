package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Business implements Serializable {

    public String businessID;
    public String number;
    public String name;
    public String primaryBusiness;
    public String address;
    public String provTerr;

    public Business(){
    }

    public Business(String number, String name, String primaryBusiness, String address, String provTerr, String bID) {
        this.number = number;
        this.name = name;
        this.primaryBusiness = primaryBusiness;
        this.address = address;
        this.provTerr = provTerr;
        businessID = bID;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("number", number);
        result.put("name", name);
        result.put("primaryBusiness", primaryBusiness);
        result.put("address", address);
        result.put("provTerr", provTerr);
        result.put("businessID",businessID);
        return result;
    }
}
