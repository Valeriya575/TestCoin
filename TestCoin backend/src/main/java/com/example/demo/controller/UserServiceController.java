package com.example.demo.controller;

import com.example.demo.Random;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TUser;

@RestController
public class UserServiceController {

    @CrossOrigin
    @RequestMapping(value="/api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity <TUser> getUser(@PathVariable int id) {

        TUser user = Random.generateRandomUser(id);

        return new ResponseEntity<TUser>(user,HttpStatus.OK);

    }

}
