package com.example.department_service.exception;

public class DataNotFoundException extends RuntimeException
{
	public DataNotFoundException(String msg)
	{
		super(msg);
	}

}
