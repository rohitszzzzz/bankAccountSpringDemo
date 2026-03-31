S C:\Users\2406399\bank-ui> ng serve 
Application bundle generation failed. [4.049 seconds] - 2026-03-31T10:35:03.121Z

▲ [WARNING] NG8103: NG8103: The `*ngFor` directive was used in the template, but neither the `NgFor` directive nor the `CommonModule` was imported. Use Angular's built-in control flow @for or make sure that either the `NgFor` directive or the `CommonModule` is included in the `@Component.imports` array of this component. Find more at https://v21.angular.dev/extended-diagnostics/NG8103 [plugin angular-compiler]       

    src/app/components/account-list/account-list.html:16:9:
      16 │     <tr *ngFor="let acc of accounts">
         ╵          ~~~~~

  Warning occurs in the template of component AccountList.

    src/app/components/account-list/account-list.ts:6:15:
      6 │   templateUrl: './account-list.html',
        ╵                ~~~~~~~~~~~~~~~~~~~~~


X [ERROR] TS2305: Module '"./components/account-list/account-list"' has no exported member 'AccountListComponent'. [plugin angular-compiler]

    src/app/app.routes.ts:2:9:
      2 │ import { AccountListComponent } from './components/account-list/acc...
        ╵          ~~~~~~~~~~~~~~~~~~~~


X [ERROR] NG8004: No pipe found with name 'currency'.
To fix this, import the "CurrencyPipe" class from "@angular/common" and add it to the "imports" array of the component. [plugin angular-compiler]

    src/app/components/account-list/account-list.html:20:34:
      20 │       <td>{{ acc.accountBalance | currency:'INR' }}</td>
         ╵                                   ~~~~~~~~

  Error occurs in the template of component AccountList.

    src/app/components/account-list/account-list.ts:6:15:
      6 │   templateUrl: './account-list.html',
        ╵                ~~~~~~~~~~~~~~~~~~~~~


X [ERROR] TS2339: Property 'deleteAccount' does not exist on type 'AccountList'. [plugin angular-compiler]

    src/app/components/account-list/account-list.html:22:44:
      22 │ ...lass="btn delete" (click)="deleteAccount(acc.id!)">Delete</button>
         ╵                               ~~~~~~~~~~~~~

  Error occurs in the template of component AccountList.

    src/app/components/account-list/account-list.ts:6:15:
      6 │   templateUrl: './account-list.html',
        ╵                ~~~~~~~~~~~~~~~~~~~~~


X [ERROR] TS2305: Module '"./app/app"' has no exported member 'App'. [plugin angular-compiler]

    src/main.server.ts:2:9:
      2 │ import { App } from './app/app';
        ╵          ~~~


X [ERROR] TS2305: Module '"./app/app"' has no exported member 'App'. [plugin angular-compiler]

    src/main.ts:3:9:
      3 │ import { App } from './app/app';
        ╵          ~~~


X [ERROR] No matching export in "src/app/components/account-list/account-list.ts" for import "AccountListComponent"

    src/app/app.routes.ts:1:9:
      1 │ import { AccountListComponent } from './components/account-list/acc...
        ╵          ~~~~~~~~~~~~~~~~~~~~


X [ERROR] No matching export in "src/app/app.ts" for import "App"

    src/main.server.ts:2:9:
      2 │ import { App } from './app/app';
        ╵          ~~~


Watch mode enabled. Watching for file changes...
