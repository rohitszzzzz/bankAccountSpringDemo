<h2>Create Account</h2>

<form (ngSubmit)="saveAccount()">
  <input [(ngModel)]="account.accountNumber" name="accountNumber" placeholder="Account Number" required>
  <input [(ngModel)]="account.accountName" name="accountName" placeholder="Name">
  <input [(ngModel)]="account.accountType" name="accountType" placeholder="Type">
  <input [(ngModel)]="account.accountBalance" name="accountBalance" placeholder="Balance">
  <input [(ngModel)]="account.ifsc" name="ifsc" placeholder="IFSC">
  <input [(ngModel)]="account.emailId" name="emailId" placeholder="Email">
  <input [(ngModel)]="account.branchName" name="branchName" placeholder="Branch">

  <button type="submit">Save</button>
</form>
