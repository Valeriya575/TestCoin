package com.example.demo;

import com.example.demo.model.TExchangeRate;
import com.example.demo.model.TUser;
import com.example.demo.model.TWallet;

import java.lang.Math;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


public class Random {

    private static String[] firstNames;
    private static String[] lastNames;
    private static String[] cities;
    private static String[] streetNames;

    static {
        firstNames = new String[]{
                "Franc",
                "Andrej",
                "Luka",
                "Janez",
                "Marko",
                "Marija",
                "Ana",
                "Valerija",
                "Mojca",
                "Nina"
                };

        lastNames = new String[]{
                "Novak",
                "Horvat",
                "Krajnc",
                "Mlakar",
                "Vidmar",
                "Kos",
                "Golob"
        };

        cities = new String[]{
                "Ljubljana",
                "Maribor",
                "Celje",
                "Koper"
        };

        streetNames = new String[]{
            "Gosposvetska cesta",
            "Prvomajska ulica",
            "Resljeva cesta",
            "Dalmatinova ulica",
            "Kolezijska ulica"
        };

    }

    public static void main(String args[]) {

    }


    public static TUser generateRandomUser(int id){
        TUser user = new TUser();
        int randomIndex;
        String firstName,lastName,fullName,streetName;

        user.setId(id);

        randomIndex = (int)(Math.random()*(firstNames.length-1));
        firstName = firstNames[randomIndex];
        randomIndex = (int)(Math.random()*(lastNames.length-1));
        lastName = lastNames[randomIndex];

        fullName = firstName + " " +lastName;
        user.setFullName(fullName);

        randomIndex = (int)(Math.random()*(streetNames.length-1));
        streetName = streetNames[randomIndex];
        streetName = streetName + " " + ((int)(Math.random()*98) + 1);
        user.setAddress(streetName);

        // random number between 1000 and 9265
        user.setPostal((int)(Math.random()*8265)+1000);

        randomIndex = (int)(Math.random()*(cities.length-1));
        user.setCity(cities[randomIndex]);

        user.setCOIN_VALUE(500);


        return user;
    }

    public static Set generateRandomWallets(int idUser)
    {
        Set<TWallet> listOfwallets = new HashSet<TWallet>();

        int IdCount = 1;
        LocalDateTime dateTimeFrom = LocalDateTime.of(2019, Month.JANUARY,1,13,15,40,55000);
        LocalDateTime dateTimeTo = LocalDateTime.of(2020, Month.JANUARY,1,13,15,40,55000);

        while(listOfwallets.size() < 500){

            TWallet wallet = new TWallet();
            wallet.setId(IdCount);
            wallet.setIdUser(idUser);
            wallet.setCoin_token(UUID.randomUUID().toString());

            long daysNumber = dateTimeFrom.until(dateTimeTo, ChronoUnit.DAYS);
            long randomNumberOfHours = (long)(Math.random()*daysNumber*24);

            LocalDateTime randomDate = dateTimeFrom.plusHours(randomNumberOfHours);

            wallet.setCountTimeStamp(randomDate);

            listOfwallets.add(wallet);

            IdCount+=1;


        }
        return listOfwallets;


    }

    public static Set generateExchangeRates(LocalDate datefrom, LocalDate dateto)
    {
        LocalDate currentDate = datefrom;
        LocalDate lastDate = dateto;

        Set<TExchangeRate> exchList = new HashSet<TExchangeRate>();

        while(currentDate.isBefore(lastDate.plusDays(1))) {
            TExchangeRate excRate= new TExchangeRate();
            excRate.setId(1);
            excRate.setExcRateDate(currentDate);
            excRate.setExcRateEur((float)Math.random()*(1.35f-0.60f)+0.60f);
            excRate.setExcRateUsd((float)Math.random()*(1.80f-1.15f)+1.15f);
            excRate.setExcRateGbp((float)Math.random()*(0.70f-0.20f)+0.20f);
            exchList.add(excRate);

            currentDate = currentDate.plusDays(1);

        }


        return exchList;

    }
}


