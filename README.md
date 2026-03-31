import { Routes } from '@angular/router';
import { AccountListComponent } from './components/account-list/account-list.component';
import { AccountFormComponent } from './components/account-form/account-form.component';
import { AccountDetailsComponent } from './components/account-details/account-details.component';

export const routes: Routes = [
  { path: '', component: AccountListComponent },
  { path: 'create', component: AccountFormComponent },
  { path: 'details/:id', component: AccountDetailsComponent }
];
