package com.cognizant.attendanceMarking.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.attendanceMarking.auth.model.Admin;
import com.cognizant.attendanceMarking.auth.model.Role;
import com.cognizant.attendanceMarking.auth.repository.AdminRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin == null) throw new UsernameNotFoundException(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
       admin.getRoles().forEach(role->
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().toString())));
        

        return new org.springframework.security.core.userdetails.User(admin.getEmail(), admin.getPassword(), grantedAuthorities);
    }
}
