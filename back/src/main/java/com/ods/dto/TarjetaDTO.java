package com.ods.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarjetaDTO {

	@JsonProperty("answer")
	private String answer;
	@JsonProperty("question")
	private String question;
	
	public TarjetaDTO() {
		
	}
	
	public TarjetaDTO(String answer, String question) {
		super();
		this.answer = answer;
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "tarjetaDTO [answer=" + answer + ", question=" + question + "]";
	}
	
	
	
}
