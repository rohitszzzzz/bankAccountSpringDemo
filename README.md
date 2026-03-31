<h2>Account Details</h2>

<div *ngIf="account">
  <p><b>ID:</b> {{ account.id }}</p>
  <p><b>Name:</b> {{ account.accountName }}</p>
  <p><b>Email:</b> {{ account.emailId }}</p>
  <p><b>Balance:</b> {{ account.accountBalance }}</p>
  <p><b>IFSC:</b> {{ account.ifsc }}</p>
  <p><b>Branch:</b> {{ account.branchName }}</p>
  <p><b>Status:</b> {{ account.status }}</p>
  <p><b>Last Updated:</b> {{ account.lastUpdated | date:'medium' }}</p>
</div>
