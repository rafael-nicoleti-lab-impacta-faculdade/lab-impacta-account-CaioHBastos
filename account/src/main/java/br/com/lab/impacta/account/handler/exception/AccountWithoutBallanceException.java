package br.com.lab.impacta.account.handler.exception;

import lombok.Getter;

public class AccountWithoutBallanceException extends RuntimeException {

    public static final long serialVersionUID = 1L;

    @Getter
    private String description;

    public AccountWithoutBallanceException() {
    }

    public AccountWithoutBallanceException(String message, String description) {
        super(message);
        this.description = description;
    }
}
