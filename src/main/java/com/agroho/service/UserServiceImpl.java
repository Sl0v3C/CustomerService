package com.agroho.service;

import com.agroho.model.User;
import com.agroho.repository.UserRepository;
import com.agroho.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rezau on 2016-05-12.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveAdmin(User user) {
        return userRepository.save(user);
    }
}
