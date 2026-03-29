package com.cts.bankProject;

import com.cts.bankProject.Dto.AccountRequestDto;
import com.cts.bankProject.Dto.AccountResponseDto;
import com.cts.bankProject.Entity.Account;
import com.cts.bankProject.Exception.AccountNotFoundException;
import com.cts.bankProject.Exception.DuplicateResourceException;
import com.cts.bankProject.Repository.AccountRepository;
import com.cts.bankProject.Service.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTestImpl {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    AccountServiceImpl accountService;

    @Test
    void createAccount_success()
    {
        AccountRequestDto accountRequestDto = new AccountRequestDto();

        accountRequestDto.setAccountNumber(1234L);
        accountRequestDto.setAccountName("Rohit Sri");
        accountRequestDto.setEmailId("rohitsrid@gmail.com");

        when(accountRepository.existsByAccountNumber(1234L)).thenReturn(false);
        when(accountRepository.existsByEmailId("rohitsrid@gmail.com")).thenReturn(false);

        Account account = new Account();
        account.setId(1L);
        account.setAccountNumber(1234L);

        when(accountRepository.save(any(Account.class))).thenReturn(account);

        AccountResponseDto response = accountService.createAccount(accountRequestDto);

        assertNotNull(response);

        assertEquals(1234L , response.getAccountNumber());

    }

    @Test
    void createAccount_duplicateAccountNumber()
    {
        AccountRequestDto accountRequestDto = new AccountRequestDto();
        accountRequestDto.setAccountNumber(123L);

        when(accountRepository.existsByAccountNumber(123L)).thenReturn(true);

        assertThrows(DuplicateResourceException.class , () -> accountService.createAccount(accountRequestDto));
    }

    @Test
    void getAccountById_success()
    {
        Account account = new Account();
        account.setId(1L);
        account.setAccountNumber(1234L);

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        AccountResponseDto accountResponseDto = accountService.getAccountById(1L);

        assertEquals(1L, accountResponseDto.getId());
    }

    @Test
    void getAccountById_NotFound()
    {
        when(accountRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class , () -> accountService.getAccountById(1L));
    }

    @Test
    void deleteAccount_success()
    {
        Account account = new Account();
        account.setId(1L);

        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        accountService.deleteAccount(1L);

        verify(accountRepository , times(1)).delete(account);
    }

    @Test
    void getAllAccounts_success()
    {
        List<Account> accounts = List.of(new Account() , new Account() , new Account());

         when(accountRepository.findAll()).thenReturn(accounts);

         List<AccountResponseDto> response = accountService.getAllAccounts();

         assertEquals(3 , response.size());
    }



}
