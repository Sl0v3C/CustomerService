package com.agroho.repository;

import com.agroho.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rezaul on 5/8/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    public User findByUserName(String username);




}
