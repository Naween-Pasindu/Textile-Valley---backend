package com.textileValley.authentication.controller;

import com.textileValley.authentication.Response.LoginResponse;
import com.textileValley.authentication.Response.UserInfo;
import com.textileValley.authentication.model.AuthenticationRequest;
import com.textileValley.authentication.repository.UserRepository;
import com.textileValley.authentication.service.UserService;
import com.textileValley.authentication.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/textile-valley/auth/login")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		String userName = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();

		System.out.println("sucess 2");
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
		}catch(Exception e) {
			
			return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
		}
		
		UserDetails loadedUser = userService.loadUserByUsername(userName);
		
		String name = loadedUser.getUsername();
//		System.out.println(name);
		
//		-----------------newly added--1.08.39-NI------------------------------------------
//		Registered_Customer user = (Registered_Customer) authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password)).getPrincipal();
		String generatedToken = jwtUtil.generateToken(name);
		
		LoginResponse response = new LoginResponse();
		response.setToken(generatedToken);
				
		return ResponseEntity.ok(response);
//		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
		
	}
	
//	@PreAuthorize("hasaccountState('MODERATOR') or hasaccountState('ADMIN')")
//	--------------1.13.50---------------
	@GetMapping("/textile-valley/auth/userinfo")
	private ResponseEntity<?> userInfo(Principal user) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<? extends GrantedAuthority> role = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(username);
		userInfo.setRoles(role);

		return ResponseEntity.ok(userInfo);

		
	}

}

