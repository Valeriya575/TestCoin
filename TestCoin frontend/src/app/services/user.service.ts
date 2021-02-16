import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from 'src/app/models/user/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
		
	private url = 'http://localhost:8080/api/users';
	constructor(private http: HttpClient) { }
	
  getUser(id: string): Observable<User> {
    const constructedUrl = `${this.url}/${id}`;
    return this.http.get<User>(constructedUrl);
  }


}
