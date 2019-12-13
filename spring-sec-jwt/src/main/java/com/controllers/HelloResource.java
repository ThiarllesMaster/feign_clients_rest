package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.models.AuthenticationReponse;
import com.models.AuthenticationRequest;
import com.services.MyUserDetailsService;
import com.util.JwtUtil;

@RestController
public class HelloResource {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtService;
	
	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) 
	                         throws Exception{
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
			
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username and password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtService.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationReponse(jwt));
		
		
	}
	
}

