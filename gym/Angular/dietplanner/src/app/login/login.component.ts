import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
    username: string = '';
    password: string = '';

    constructor(private httpClient: HttpClient) { }

    login() {
        const url = "http://localhost:8080/login/submit";
        const loginData = {
            username: this.username,
            password: this.password
        };
        console.log(loginData);
        this.httpClient.post(url, loginData).subscribe((response: any) => {
            console.log(response);
        }, (error: any) => {
            console.log("error on this login " + error);
        });
    }
}
