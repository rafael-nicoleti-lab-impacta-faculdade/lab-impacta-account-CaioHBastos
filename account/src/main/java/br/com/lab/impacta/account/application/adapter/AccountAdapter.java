package br.com.lab.impacta.account.application.adapter;

import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.impacta.account.model.Account;

public class AccountAdapter {

    private AccountAdapter() {}

    public static AccountBalanceResponse toDtoBalance(Account account) {
        return new AccountBalanceResponse(account.getNumber(), account.getBalance());
    }

}
