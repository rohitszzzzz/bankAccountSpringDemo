package com.cts.bankProject.Entity;

import com.cts.bankProject.Enum.AccountType;
import com.cts.bankProject.Enum.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private Long accountNumber;

    @Column(nullable = false)
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private Double accountBalance;

    @Column(nullable = false)
    private String ifsc;

    @Column(nullable = false)
    private String branchName;

    @Email
    @Column(nullable = false)
    private String emailId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private LocalDateTime joiningDate;

    @Column(nullable = false)
    private LocalDateTime lastUpdated;

}
