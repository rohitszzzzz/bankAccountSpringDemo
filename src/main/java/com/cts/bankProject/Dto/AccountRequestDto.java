package com.cts.bankProject.Dto;


import com.cts.bankProject.Enum.AccountType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDto {

    @NotNull(message = "Account number cannot be null")
    private Long accountNumber;

    @NotBlank(message = "Account name cannot be empty")
    private String accountName;

    @NotNull(message = "Account Type cannot be null")
    private AccountType accountType;

    @NotNull(message = "Account Balance cannot be null")
    @PositiveOrZero(message = "Balance cannot be negative")
    private Double accountBalance;

    @NotNull(message = "IFSC number cannot be null")
    @Size(min = 11 , max = 11 , message = "IFSC must be 11 characters")
    private String ifsc;

    @NotBlank(message = "Branch Name cannot be null")
    private String branchName;

    @NotBlank(message = "email ID cannot be null")
    @Email(message = "Invalid email Id format")
    private String emailId;




}
