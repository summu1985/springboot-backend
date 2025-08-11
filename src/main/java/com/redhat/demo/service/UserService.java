package com.redhat.demo.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.demo.model.User;

@Service
public class UserService {
    public UserService() {
    }

    public ArrayList<User> findAll() {
        //User[] userList = new User[2];
        ArrayList<User> userList = new ArrayList<User>();

        // try {
        //     ObjectMapper mapper = new ObjectMapper();
        //     mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        //     userList = mapper.readValue(usersResponse, User[].class);
        //     // userList = users.getRecords();
        //     // ArrayList<User> users = userList;
        // } catch (Exception ex) {
        //     System.out.println(ex.toString());
        // }
        //for (int i=0 ; i<2 ; i++)
        //{
            User user1 = new User();
            user1.setName("Sumit");
            user1.setId(0);
            user1.setEmail("sumit@example.com");
            System.out.println(user1);
            userList.add(user1);
            // Add another dummy user
            User user2 = new User();
            user2.setName("Sachin");
            user2.setId(1);
            user2.setEmail("sachin@example.com");
            System.out.println(user2);
            userList.add(user2);
        //}
        return userList;
    }
}
