package br.com.lab.impacta.account.handler.exception;

import lombok.Getter;

public class AccountDontExistException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    @Getter
    private String description;

    public AccountDontExistException() {
    }

    public AccountDontExistException(String message, String description) {
        super(message);
        this.description = description;
    }
}
