package com.example.demo.controller;
import com.example.demo.Random;
import org.apache.coyote.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


import com.example.demo.model.TExchangeRate;

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
public class ExchangeRateServiceController {

    @CrossOrigin
    @RequestMapping(value= "/api/exchange-rates", method= RequestMethod.GET)
    public ResponseEntity<Set<TExchangeRate>> getExchangeRates(@RequestParam (value="datefrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datefrom, @RequestParam (value="dateto") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateto){

        Random r = new Random();
        r.generateExchangeRates(datefrom,dateto);
        return new ResponseEntity<Set<TExchangeRate>>(r.generateExchangeRates(datefrom,dateto), HttpStatus.OK);


    }
}
