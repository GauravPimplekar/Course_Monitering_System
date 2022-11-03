package com.masai.Execeptions;

public class AuthenticationFailException extends Exception {

	
	public AuthenticationFailException(){
		
	}
	
	public AuthenticationFailException(String massage){
		super(massage);
	}
}
