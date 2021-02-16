package com.example.demo.model;

public class TUser{

    private int id;
    private String fullName;
    private String address;
    private int postal;
    private String city;
    private float COIN_VALUE=500;

    public  TUser(){

    }


    public int getId(){
        return id;
    }

    public String getFullName(){
        return fullName;
    }

    public String getAddress(){
        return address;
    }

    public int getPostal(){
        return postal;
    }

    public String getCity(){
        return city;
    }

    public float getCOIN_VALUE(){
        return COIN_VALUE;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setFullName(String fullName){
        this.fullName=fullName;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public void setPostal(int postal){
        this.postal=postal;
    }

    public void setCity(String city){
        this.city=city;
    }

    public void setCOIN_VALUE(float COIN_VALUE){
        this.COIN_VALUE=COIN_VALUE;
    }

}

