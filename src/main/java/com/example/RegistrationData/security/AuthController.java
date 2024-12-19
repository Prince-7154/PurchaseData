package com.example.RegistrationData.security;

import com.example.RegistrationData.DTO.AuthResponseDTO;
import com.example.RegistrationData.DTO.LoginDTO;
import com.example.RegistrationData.DTO.RegisterDTO;
import com.example.RegistrationData.ORMEntity.Role;
import com.example.RegistrationData.ORMEntity.User;
import com.example.RegistrationData.repositories.OrmRepositories.RoleRepository;
import com.example.RegistrationData.repositories.OrmRepositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        System.out.println(token);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        System.out.println("Helloooooo");
        if(userRepository.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        System.out.println(registerDTO.getUsername());
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role roles = roleRepository.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);
        return new ResponseEntity<>("User register, SUCCESS", HttpStatus.CREATED);


    }

//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        // In a real application, you would validate credentials against a database
////        if (isValidCredentials(loginRequest)) {
////            String token = jwtUtil.generateToken(loginRequest.getUsername());
////            return ResponseEntity.ok(token);
////        }
//
//        String token = jwtUtil.generateToken(loginRequest.getUsername());
//        return ResponseEntity.ok(token);
//
////        return ResponseEntity.status(401).body("Invalid credentials");
//    }
//
//    // Placeholder method - replace with actual credential validation
//    private boolean isValidCredentials(LoginRequest request) {
//        return "user".equals(request.getUsername()) &&
//                "password".equals(request.getPassword());
//    }
}
