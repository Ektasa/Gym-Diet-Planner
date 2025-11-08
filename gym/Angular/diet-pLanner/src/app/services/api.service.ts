import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) { }

  // Example methods for your Diet Planner API
  getMoteLog(): Observable<any> {
    return this.http.get(`${this.apiUrl}/mote`);
  }

  getPatleLog(): Observable<any> {
    return this.http.get(`${this.apiUrl}/patle`);
  }

  // Add a new diet log entry
  addDietLog(data: any, type: 'mote' | 'patle'): Observable<any> {
    return this.http.post(`${this.apiUrl}/${type}`, data);
  }

  // Test endpoint to verify connection
  testConnection(): Observable<any> {
    return this.http.get(`${this.apiUrl}/test`);
  }
}