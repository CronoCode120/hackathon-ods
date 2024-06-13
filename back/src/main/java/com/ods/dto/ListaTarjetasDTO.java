package com.ods.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaTarjetasDTO {

	@JsonProperty("cardList")
	private List<TarjetaDTO> cardList;

	@Override
	public String toString() {
		return "listaTarjetasDTO [cardList=" + cardList + "]";
	}

	public ListaTarjetasDTO() {
		
	}
	
	
	
}
