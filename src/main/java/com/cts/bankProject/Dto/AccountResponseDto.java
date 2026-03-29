package com.cts.bankProject.Dto;

import com.cts.bankProject.Enum.AccountType;
import com.cts.bankProject.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDto {

    private Long id;
    private Long accountNumber;
    private String accountName;
    private AccountType accountType;
    private Double accountBalance;
    private String ifsc;
    private String branchName;
    private String emailId;
    private Status status;
    private LocalDateTime joiningDate;
    private LocalDateTime lastUpdated;


}
