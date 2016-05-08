package com.agroho.config;

import com.agroho.model.User;
import com.agroho.repository.UserRepository;
import com.agroho.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rezaul on 5/8/16.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
            this.userRepository = userRepository;
            this.userRoleRepository  = userRoleRepository;
        }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);
        if(null==user) {
            throw new UsernameNotFoundException("No user present with username: "+username);
        } else{
            List<String> userRoles=userRoleRepository.findRoleByUserName(username);
                return new CustomUserDetails(user,userRoles);
        }

    }
}
