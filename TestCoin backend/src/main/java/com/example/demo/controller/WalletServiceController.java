package com.example.demo.controller;
import com.example.demo.Random;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TWallet;
import com.example.demo.model.TUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class WalletServiceController {

    @CrossOrigin
    @RequestMapping(value="/api/wallets", method = RequestMethod.GET)
    public ResponseEntity<Set<TWallet>> getWallets(@RequestParam int idUser){

        Random r = new Random();
        r.generateRandomWallets(idUser);
        return new ResponseEntity<Set<TWallet>>(r.generateRandomWallets(idUser), HttpStatus.OK);

    }
}
