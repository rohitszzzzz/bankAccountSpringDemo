import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Account } from '../models/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  private baseUrl = 'http://localhost:8080/accounts';

  constructor(private http: HttpClient) {}

  createAccount(account: Account): Observable<Account> {
    return this.http.post<Account>(this.baseUrl, account);
  }

  getAllAccounts(): Observable<Account[]> {
    return this.http.get<Account[]>(this.baseUrl);
  }

  getAccountById(id: number): Observable<Account> {
    return this.http.get<Account>(`${this.baseUrl}/account/id/${id}`);
  }

  getAccountByEmail(email: string): Observable<Account> {
    return this.http.get<Account>(`${this.baseUrl}/account/email/${email}`);
  }

  getAccountByNumber(accNo: number): Observable<Account> {
    return this.http.get<Account>(`${this.baseUrl}/account/accountNumber/${accNo}`);
  }

  updateAccount(id: number, account: Account): Observable<Account> {
    return this.http.put<Account>(`${this.baseUrl}/${id}`, account);
  }

  deleteAccount(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
