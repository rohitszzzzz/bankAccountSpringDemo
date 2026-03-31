export interface Account {
  id?: number;
  accountNumber: number;
  accountName: string;
  accountType: string;
  accountBalance: number;
  ifsc: string;
  emailId: string;
  branchName: string;
  status?: string;
  joiningDate?: string;
  lastUpdated?: string;
}
