import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080';
  
  constructor(private http: HttpClient) { }

  private getHeaders(): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });
  }

  // Login/Register
  login(username: string, password: string): Observable<any> {
    const url = `${this.apiUrl}/login/submit`;
    const body = { username, password };
    return this.http.post(url, body, { headers: this.getHeaders() });
  }

  // Get all users
  getAllUsers(): Observable<any> {
    const url = `${this.apiUrl}/login/getuser`;
    return this.http.get(url, { headers: this.getHeaders() });
  }

  // Update user
  updateUser(user: any): Observable<any> {
    const url = `${this.apiUrl}/login/update`;
    return this.http.put(url, user, { headers: this.getHeaders() });
  }

  // Delete user
  deleteUser(id: number): Observable<any> {
    const url = `${this.apiUrl}/login/delete/${id}`;
    return this.http.delete(url, { headers: this.getHeaders() });
  }

  // Get all weekly meal plans
  getAllWeeklyMealPlans(): Observable<any> {
    const url = `${this.apiUrl}/patle`;
    return this.http.get(url, { headers: this.getHeaders() });
  }
}

