import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user/user';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { NzTableModule } from 'ng-zorro-antd/table';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NzListModule } from 'ng-zorro-antd/list';



@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
	
  user = new User()
  idParameter = ""

  constructor(
		private route: ActivatedRoute,
		private userService: UserService,
		private router: Router
   ) { }

  ngOnInit(): void {
	  
	this.idParameter = this.route.snapshot.paramMap.get("id") as string
	this.getUser();
  }
  
  async getUser() {
	await this.userService.getUser(this.idParameter).subscribe(user => this.user = user);
  }
  
   showWallets(): void {
    this.router.navigate(['wallets/'+this.idParameter]);
  }
  
    showExchangeRates(): void {
    this.router.navigate(['exchange-rates']);
  }
  
 
}
