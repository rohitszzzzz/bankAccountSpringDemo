import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AccountService } from '../../services/account.service';
import { Account } from '../../models/account';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-account-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './account-list.component.html'
})
export class AccountListComponent implements OnInit {

  accounts: Account[] = [];

  constructor(private accountService: AccountService) {}

  ngOnInit(): void {
    this.loadAccounts();
  }

  loadAccounts() {
    this.accountService.getAllAccounts().subscribe(data => {
      this.accounts = data;
    });
  }

  deleteAccount(id: number) {
    this.accountService.deleteAccount(id).subscribe(() => {
      this.loadAccounts();
    });
  }
}
