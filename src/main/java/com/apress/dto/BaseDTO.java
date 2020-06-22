package com.apress.dto;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseDTO {
	
	private Collection<String> errors =  new ArrayList<String>();
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
	

}
