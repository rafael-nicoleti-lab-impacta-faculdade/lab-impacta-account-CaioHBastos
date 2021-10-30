package br.com.lab.impacta.account.service.impl;

import br.com.lab.impacta.account.handler.exception.AccountDontExistException;
import br.com.lab.impacta.account.model.Account;
import br.com.lab.impacta.account.repository.AccountRepository;
import br.com.lab.impacta.account.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Value("${lab.account.exceptions.account-dont-exists-message}")
    private String mensageExceptionAccountDontExists;

    @Value("${lab.account.exceptions.account-dont-exists-description}")
    private String descriptionExceptionAccountDontExists;

    @Value("${lab.account.exceptions.account-withou-balance-message}")
    private String mensageExceptionAccountWithoutBalance;

    @Value("${lab.account.exceptions.account-without-balance-description}")
    private String descriptionExceptionAccountWithoutBalance;

    @Override
    public Account findAccount(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);

        if (account.isEmpty())
            throw new AccountDontExistException(mensageExceptionAccountDontExists,
                    descriptionExceptionAccountDontExists);

        return null;
    }

    @Override
    public void debitAccount(Long accountId, Double valueOfDebit) {

    }
}
