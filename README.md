import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AccountService } from '../../services/account.service';
import { Account } from '../../models/account';

@Component({
  selector: 'app-account-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './account-form.component.html'
})
export class AccountFormComponent {

  account: Account = {
    accountNumber: 0,
    accountName: '',
    accountType: '',
    accountBalance: 0,
    ifsc: '',
    emailId: '',
    branchName: ''
  };

  constructor(private accountService: AccountService) {}

  saveAccount() {
    this.accountService.createAccount(this.account).subscribe(() => {
      alert('Account Created!');
    });
  }
}
