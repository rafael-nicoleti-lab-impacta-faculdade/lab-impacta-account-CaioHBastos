package br.com.lab.impacta.account.handler;

import br.com.lab.impacta.account.handler.exception.AccountDontExistException;
import br.com.lab.impacta.account.handler.exception.AccountWithoutBallanceException;
import br.com.lab.impacta.account.handler.exception.ErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AccountDontExistException.class)
    public final ResponseEntity<ErrorMessageResponse> accountNotNotFoundException(AccountDontExistException accountDontExistException) {

        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                accountDontExistException.getMessage(),
                accountDontExistException.getDescription());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessageResponse);
    }

    @ExceptionHandler(AccountWithoutBallanceException.class)
    public final ResponseEntity<ErrorMessageResponse> withouBalanceException(AccountWithoutBallanceException accountWithoutBallanceException) {

        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                accountWithoutBallanceException.getMessage(),
                accountWithoutBallanceException.getDescription());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessageResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ErrorMessageResponse> errorGeneral(RuntimeException exception) {

        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                exception.getMessage(),
                "Não foi possível processar a requisição");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessageResponse);
    }
}
