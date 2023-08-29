package com.redhat.demo.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.demo.model.User;

@Component
public class UserService {
    public UserService() {
    }

    public ArrayList<User> findAll() {
        User[] userList = new User[2];

        // try {
        //     ObjectMapper mapper = new ObjectMapper();
        //     mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        //     userList = mapper.readValue(usersResponse, User[].class);
        //     // userList = users.getRecords();
        //     // ArrayList<User> users = userList;
        // } catch (Exception ex) {
        //     System.out.println(ex.toString());
        // }
        for (int i=0 ; i<2 ; i++)
        {
            User user = new User();
            user.setName("Sumit");
            user.setId(i);
            user.setEmail("summukhe@redhat.com");
            userList[i] = user;
        }
        return new ArrayList<User>(Arrays.asList(userList));
    }
}
