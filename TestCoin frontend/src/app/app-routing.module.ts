import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserComponent } from './components/user/user.component';
import { WalletComponent } from './components/wallet/wallet.component';
import { ExchangeRateComponent } from './components/exchange-rate/exchange-rate.component';

const routes: Routes = [

	{ path: 'users/:id', component: UserComponent},
	{ path: 'wallets/:idUser', component: WalletComponent},
	{ path: 'exchange-rates', component: ExchangeRateComponent},
    { path: '', pathMatch: 'full', redirectTo: '/users/1' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
