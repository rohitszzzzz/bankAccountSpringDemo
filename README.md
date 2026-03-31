import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { AccountService } from '../../services/account.service';
import { Account } from '../../models/account';

@Component({
  selector: 'app-account-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './account-details.component.html'
})
export class AccountDetailsComponent implements OnInit {

  account?: Account;

  constructor(
    private route: ActivatedRoute,
    private accountService: AccountService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));

    this.accountService.getAccountById(id).subscribe(data => {
      this.account = data;
    });
  }
}
