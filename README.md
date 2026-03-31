<h2>All Accounts</h2>

<button routerLink="/create">Create Account</button>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Balance</th>
    <th>Actions</th>
  </tr>

  <tr *ngFor="let acc of accounts">
    <td>{{ acc.id }}</td>
    <td>{{ acc.accountName }}</td>
    <td>{{ acc.emailId }}</td>
    <td>{{ acc.accountBalance }}</td>
    <td>
      <button (click)="deleteAccount(acc.id!)">Delete</button>
    </td>
  </tr>
</table>
