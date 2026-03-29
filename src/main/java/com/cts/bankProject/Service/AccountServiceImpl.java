package com.cts.bankProject.Service;

import com.cts.bankProject.Dto.AccountRequestDto;
import com.cts.bankProject.Dto.AccountResponseDto;
import com.cts.bankProject.Entity.Account;
import com.cts.bankProject.Enum.Status;
import com.cts.bankProject.Exception.AccountNotFoundException;
import com.cts.bankProject.Exception.DuplicateResourceException;
import com.cts.bankProject.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto)
    {

        if(accountRepository.existsByAccountNumber(accountRequestDto.getAccountNumber()))
        {
            throw new DuplicateResourceException("Account number already exists");
        }
        if(accountRepository.existsByEmailId(accountRequestDto.getEmailId()))
        {
            throw new DuplicateResourceException("Email already exists");
        }
        Account account = mapToEntity(accountRequestDto);

        account.setJoiningDate(LocalDateTime.now());
        account.setLastUpdated(LocalDateTime.now());
        account.setStatus(Status.ACTIVE);

        Account savedAccount = accountRepository.save(account);
        return mapToDto(savedAccount);

    }

    @Override
    public AccountResponseDto updateAccount(Long id , AccountRequestDto accountRequestDto)
    {
        Account account = accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException("Account Not Found with id: " + id));

        account.setAccountNumber(accountRequestDto.getAccountNumber());
        account.setAccountName(accountRequestDto.getAccountName());
        account.setAccountType(accountRequestDto.getAccountType());
        account.setAccountBalance(accountRequestDto.getAccountBalance());
        account.setIfsc(accountRequestDto.getIfsc());
        account.setEmailId(accountRequestDto.getEmailId());
        account.setBranchName(accountRequestDto.getBranchName());
        account.setLastUpdated(LocalDateTime.now());

        Account savedAccount = accountRepository.save(account);


        return mapToDto(savedAccount);

    }
    @Override
    public void deleteAccount(Long id)
    {
        Account account = accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException("Account not Found with id "+ id));
        accountRepository.delete(account);
    }

    @Override
    public List<AccountResponseDto> getAllAccounts()
    {
        return accountRepository.findAll().stream().map(this::mapToDto).toList();

    }

    @Override
    public AccountResponseDto getAccountById(Long id) {
        Account account =  accountRepository.findById(id).orElseThrow(()->new AccountNotFoundException("Account not found with id " + id));
        return mapToDto(account);

    }

    @Override
    public AccountResponseDto getAccountByAccountNumber(Long accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(()-> new AccountNotFoundException("Account not found with account number " + accountNumber));
        return mapToDto(account);
    }

    @Override
    public AccountResponseDto getAccountByEmail(String emailId) {
        Account account = accountRepository.findByEmailId(emailId).orElseThrow(() -> new AccountNotFoundException("Account not found with email id " + emailId));
        return mapToDto(account);
    }

    private Account mapToEntity(AccountRequestDto accountRequestDto)
    {
        Account account = new Account();
        account.setAccountNumber(accountRequestDto.getAccountNumber());
        account.setAccountName(accountRequestDto.getAccountName());
        account.setAccountType(accountRequestDto.getAccountType());
        account.setAccountBalance(accountRequestDto.getAccountBalance());
        account.setIfsc(accountRequestDto.getIfsc());
        account.setEmailId(accountRequestDto.getEmailId());
        account.setBranchName(accountRequestDto.getBranchName());

        return account;

    }

    private AccountResponseDto mapToDto(Account account)
    {
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setId(account.getId());
        accountResponseDto.setAccountNumber(account.getAccountNumber());
        accountResponseDto.setAccountName(account.getAccountName());
        accountResponseDto.setAccountBalance(account.getAccountBalance());
        accountResponseDto.setAccountType(account.getAccountType());
        accountResponseDto.setIfsc(account.getIfsc());
        accountResponseDto.setEmailId(account.getEmailId());
        accountResponseDto.setStatus(account.getStatus());
        accountResponseDto.setBranchName(account.getBranchName());
        accountResponseDto.setJoiningDate(account.getJoiningDate());
        accountResponseDto.setLastUpdated(account.getLastUpdated());

        return accountResponseDto;
    }




}
