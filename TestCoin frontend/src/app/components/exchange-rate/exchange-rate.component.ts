import { Component, OnInit } from '@angular/core';
import { ExchangeRate } from 'src/app/models/exchangeRate/exchange-rate';
import { ExchangeRateService } from 'src/app/services/exchange-rate.service';
import { BrowserModule } from '@angular/platform-browser'


import { NzTableModule } from 'ng-zorro-antd/table';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-exchange-rate',
  templateUrl: './exchange-rate.component.html',
  styleUrls: ['./exchange-rate.component.css']
})
export class ExchangeRateComponent implements OnInit {
	
	exchRate : ExchangeRate[] = [];
	eurAvg = 0;
	usdAvg = 0;
	gbpAvg = 0;
	eurMedian = 0;
	usdMedian = 0;
	gbpMedian = 0;
	
  constructor(
	private exchangeRateService: ExchangeRateService,
	private router: Router,
	private route: ActivatedRoute,
  
  ) { }

  ngOnInit(): void {
	  
	  this.getExchangeRates();
  }
  
  async getExchangeRates() {

		await this.exchangeRateService.getExchangeRates('2019-04-16', '2020-09-06').subscribe(exchRate =>{
			this.exchRate = exchRate;
			console.log(this.exchRate)
			
			let exchangeRateEurArray = exchRate.map( exchangeRateObject => exchangeRateObject.excRateEur);
			let exchangeRateUsdArray = exchRate.map( exchangeRateObject => exchangeRateObject.excRateUsd);
			let exchangeRateGbpArray = exchRate.map( exchangeRateObject => exchangeRateObject.excRateGbp);
			
			this.eurAvg = this.exchangeRateService.average(exchangeRateEurArray)
			this.usdAvg = this.exchangeRateService.average(exchangeRateUsdArray)
			this.gbpAvg = this.exchangeRateService.average(exchangeRateGbpArray)
			
			this.eurMedian=this.exchangeRateService.median(exchangeRateEurArray);
			this.usdMedian=this.exchangeRateService.median(exchangeRateUsdArray);
			this.gbpMedian=this.exchangeRateService.median(exchangeRateGbpArray);

			});
	
	}
	
  showHomePage(): void {
    this.router.navigate(['']);
  }
	
	
}
