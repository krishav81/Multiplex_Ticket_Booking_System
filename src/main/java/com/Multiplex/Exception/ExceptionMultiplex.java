package com.Multiplex.Exception;

public class ExceptionMultiplex extends Exception{
String message;

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public ExceptionMultiplex(String message) {
	super();
	this.message = message;
}

}
