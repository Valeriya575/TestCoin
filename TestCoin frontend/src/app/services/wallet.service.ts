import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Wallet } from 'src/app/models/wallet/wallet';

@Injectable({
  providedIn: 'root'
})
export class WalletService {
	
  private url = 'http://localhost:8080/api/wallets';
  constructor(private http: HttpClient) {}
  
  getWallets(idUser:string): Observable<Wallet[]> {
	const constructedUrl = `${this.url}/?idUser=${idUser}`;

    return this.http.get<Wallet[]>(constructedUrl);
  }
  
}
