package com.example.demo.controller;

import com.example.demo.Random;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TUser;

@RestController
public class UserServiceController {

//    @RequestMapping(value= "/users/wallets", method= RequestMethod.GET)
//    public ResponseEntity<TUser>getUser1(@RequestParam int id){
//
//        TUser user = new TUser();
//        user.setId(id);
//        user.setFullName("Honey");
//        user.setAddress("Maribor");
//        user.setPostal(3);
//        user.setCity("Ljubljana");
//        user.setCOIN_VALUE(1);
//
//        return new ResponseEntity<TUser>(user, HttpStatus.OK);
//
//    }
    @CrossOrigin
    @RequestMapping(value="/api/users/{id}", method = RequestMethod.GET)
    public ResponseEntity <TUser> getUser(@PathVariable int id) {

        TUser user = Random.generateRandomUser(id);

        return new ResponseEntity<TUser>(user,HttpStatus.OK);

    }

}
