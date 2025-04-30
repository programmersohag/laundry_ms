package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Users;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    private final HttpServletRequest request;

    public UserDetailServiceImpl(UserService userService, HttpServletRequest request) {
        this.userService = userService;
        this.request = request;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        for (String role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return new User(username, user.getPassword(), grantedAuthorities);
    }


}
