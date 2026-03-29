package com.cts.bankProject.Service;

import com.cts.bankProject.Dto.AccountRequestDto;
import com.cts.bankProject.Dto.AccountResponseDto;


import java.util.List;

public interface AccountService {

    AccountResponseDto createAccount(AccountRequestDto accountRequestDto);
    void deleteAccount(Long id);
    AccountResponseDto updateAccount(Long id , AccountRequestDto accountRequestDto);
    List<AccountResponseDto> getAllAccounts();
    AccountResponseDto getAccountById(Long id);
    AccountResponseDto getAccountByAccountNumber(Long accountNumber);
    AccountResponseDto getAccountByEmail(String emailId);

}
