package br.com.lab.impacta.account.api;

import br.com.lab.impacta.account.application.AccountApplication;
import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.impacta.account.application.impl.AccountApplicationImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/accounts")
public class BalanceController {

    private final AccountApplication accountApplication;

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<AccountBalanceResponse> balance(@PathVariable long accountId) {
        AccountBalanceResponse accountBalanceResponse = accountApplication.balance(accountId);

        return ResponseEntity.ok(accountBalanceResponse);
    }
}
