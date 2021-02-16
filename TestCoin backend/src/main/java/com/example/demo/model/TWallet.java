package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class TWallet {

    private int id;
    private int idUser;
    private String coin_token = UUID.randomUUID().toString();
    private LocalDateTime countTimeStamp;

    public  TWallet(){

    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public int getIdUser(){return idUser;}
    public void setIdUser(int idUser){this.idUser=idUser;}

    public String getCoin_token(){return coin_token;}
    public void setCoin_token(String coin_token){this.coin_token=coin_token;}

    public LocalDateTime getCountTimeStamp(){return countTimeStamp;}
    public void setCountTimeStamp(LocalDateTime countTimeStamp){this.countTimeStamp=countTimeStamp;}
}

