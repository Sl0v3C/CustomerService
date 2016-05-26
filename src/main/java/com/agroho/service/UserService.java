package com.agroho.service;

import com.agroho.model.User;
import org.springframework.stereotype.Service;

/**
 * Created by rezau on 2016-05-12.
 */
@Service
public interface UserService {

    public User saveAdmin(User user);
}
