package org.example.lab2.service.impl;

import org.example.lab2.entity.User;
import org.example.lab2.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@Transactional
public class AwesomeUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public AwesomeUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findByEmail(username);
        //var userDetails = new AwesomeUserDetails(user);
        return user;
    }

}