package com.models;

public class AuthenticationReponse {

	private final String jwt;	

	public AuthenticationReponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}	
}
