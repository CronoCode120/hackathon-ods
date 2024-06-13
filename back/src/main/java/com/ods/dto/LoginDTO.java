package com.ods.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	
	@JsonProperty("user")
	private String user;
	@JsonProperty("password")
	private String password;
	
	public LoginDTO(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	@Override
	public String toString() {
		return "loginDTO [user=" + user + ", password=" + password + "]";
	}

	
	
}
