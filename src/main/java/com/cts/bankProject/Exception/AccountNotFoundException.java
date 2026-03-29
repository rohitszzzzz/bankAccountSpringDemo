package com.cts.bankProject.Exception;

public class AccountNotFoundException extends RuntimeException{

    public AccountNotFoundException(String message)
    {
        super(message);
    }
}
