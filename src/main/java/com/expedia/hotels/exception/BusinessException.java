package com.expedia.hotels.exception;

//import com.expedia.hotels.Log;

public class BusinessException extends Exception {
	
	private static final long serialVersionUID = -2825528273046570710L;

	public BusinessException(){
		super();
	}
	
	public BusinessException(String message) {
        super(message);
//        Log.error(this, message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
//        Log.error(this, message);
    }

}
