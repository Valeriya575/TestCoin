import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { ExchangeRate } from 'src/app/models/exchangeRate/exchange-rate';

@Injectable({
  providedIn: 'root'
})
export class ExchangeRateService {
	
	 private url = 'http://localhost:8080/api/exchange-rates';
  constructor(private http: HttpClient) {}
  
  getExchangeRates(datefrom:string, dateto:string): Observable<ExchangeRate[]> {
	  	const constructedUrl = `${this.url}/?datefrom=${datefrom}&dateto=${dateto}`;
    return this.http.get<ExchangeRate[]>(constructedUrl);
  }
  
    average(values: number[]):number{
	  
	  if(values.length == 0){
		  return 0;
	  }
		
		let sum = 0, i = 0, len = values.length;
		while(i < len){
			sum = sum + values[i];
			i+=1;

		}
		return sum/len;
	}
	
	median(values:number[]):number{
	  if(values.length == 0){
		  return 0;
	  }
	  
	  values.sort(function(a:number,b:number){
		  return a-b;
	  });
	  
	  var half = Math.floor(values.length/2);
	  
	  if(values.length%2){
		  return values[half];
	  }
	  
	  return (values[half-1]+values[half])/2.0;

	}

}
