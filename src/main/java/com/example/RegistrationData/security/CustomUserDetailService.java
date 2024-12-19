package com.example.RegistrationData.security;

import com.example.RegistrationData.ORMEntity.Role;
import com.example.RegistrationData.ORMEntity.User;
import com.example.RegistrationData.repositories.OrmRepositories.UserRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("username not found"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolesAuthorities(user.getRoles()));
    }

    private Collection<GrantedAuthority> mapRolesAuthorities(List<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
