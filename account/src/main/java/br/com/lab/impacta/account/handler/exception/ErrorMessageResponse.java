package br.com.lab.impacta.account.handler.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageResponse {

    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
