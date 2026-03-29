package com.cts.bankProject.Controller;

import com.cts.bankProject.Dto.AccountRequestDto;
import com.cts.bankProject.Dto.AccountResponseDto;
import com.cts.bankProject.Service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDto> createAccount(@Valid @RequestBody AccountRequestDto accountRequestDto)
    {
        AccountResponseDto responseDto = accountService.createAccount(accountRequestDto);

        return new ResponseEntity<>(responseDto ,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts()
    {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("/account/id/{id}")
    public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable Long id)
    {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @GetMapping("/account/email/{emailId}")
    public ResponseEntity<AccountResponseDto> getAccountByEmail(@PathVariable String emailId)
    {
        return ResponseEntity.ok(accountService.getAccountByEmail(emailId));
    }

    @GetMapping("/account/accountNumber/{accountNumber}")
    public ResponseEntity<AccountResponseDto> getAccountByAccountNumber(@PathVariable Long accountNumber)
    {
        return ResponseEntity.ok(accountService.getAccountByAccountNumber(accountNumber));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDto> updateAccount(@PathVariable Long id , @Valid @RequestBody AccountRequestDto accountRequestDto)
    {
        return ResponseEntity.ok(accountService.updateAccount(id , accountRequestDto));
    }



}
