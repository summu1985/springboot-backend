package com.redhat.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.redhat.demo.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
