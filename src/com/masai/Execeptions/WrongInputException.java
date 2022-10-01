package com.masai.Execeptions;

public class WrongInputException extends Exception {

	
	public WrongInputException(){
		
	}
	
	public WrongInputException(String massage){
		super(massage);
	}
}
