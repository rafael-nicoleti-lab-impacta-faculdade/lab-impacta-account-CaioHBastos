package br.com.lab.impacta.account.application.impl;

import br.com.lab.impacta.account.application.AccountApplication;
import br.com.lab.impacta.account.application.adapter.AccountAdapter;
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse;
import br.com.lab.impacta.account.model.Account;
import br.com.lab.impacta.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AccountApplicationImpl implements AccountApplication {

    private AccountService accountService;

    @Override
    public AccountBalanceResponse balance(Long accountId) {
        Account account = accountService.findAccount(accountId);

        return AccountAdapter.toDtoBalance(account);
    }

    @Override
    public DebitAccountResponse debit(Long accountId, DebitAccountRequest debitAccountRequest) {
        accountService.debitAccount(accountId, debitAccountRequest.getValueDebit());

        return new DebitAccountResponse(true);
    }
}
