import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { LoginResponse } from '../models/user';

const baseUrl = 'http://localhost:8080/api/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private router: Router,
    private http: HttpClient
    ) { }

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  // Handle API errors
  handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  }


  // Verify user credentials on server to get token
  loginForm(data: any): Observable<LoginResponse> {
    console.error(data)
    return this.http
      .post<LoginResponse>(baseUrl, data, this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

  // After login save token and other values(if any) in localStorage
  setUser(resp: LoginResponse) {
    localStorage.setItem('name', resp.name);
    localStorage.setItem('access_token', resp.access_token);
    this.router.navigate(['/home']);
  }

  // Checking if token is set
  isLoggedIn() {
    return localStorage.getItem('access_token') != null;
  }

  // After clearing localStorage redirect to login screen
  logout() {
    localStorage.clear();
    this.router.navigate(['/login']);
  }


  // Get data from server for Dashboard
  getData(data : any): Observable<LoginResponse> {
    return this.http
      .post<LoginResponse>(baseUrl, data, this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }
}
