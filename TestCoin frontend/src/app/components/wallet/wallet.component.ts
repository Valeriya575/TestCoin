import { Component, OnInit } from '@angular/core';
import { Wallet } from 'src/app/models/wallet/wallet';
import { WalletService } from 'src/app/services/wallet.service';

import { NzTableModule } from 'ng-zorro-antd/table';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-wallet',
  templateUrl: './wallet.component.html',
  styleUrls: ['./wallet.component.css']
})
export class WalletComponent implements OnInit {
	
	  wallets : Wallet[] = [];
	  idParameter = "";
	  latestWallet = new Wallet();
	

  constructor(
		private route: ActivatedRoute,
		private router: Router,
		private walletService: WalletService,
  
  ) { }

  ngOnInit(): void {
	this.idParameter = this.route.snapshot.paramMap.get("idUser") as string
	this.getWallets();
  }
  
   async getWallets() {
		await this.walletService.getWallets(this.idParameter).subscribe(wallets =>{
			this.wallets = wallets;
			this.wallets.sort((a, b) => (a.countTimeStamp > b.countTimeStamp) ? 1 : -1);
			this.latestWallet = this.wallets[this.wallets.length - 1]
			console.log(this.latestWallet)
			console.log(wallets.length)
		});
  
	}
	
  showUser(): void {
    this.router.navigate(['users/'+this.idParameter]);
  }
  showExchangeRates(): void {
    this.router.navigate(['exchange-rates']);
  }
  

}
