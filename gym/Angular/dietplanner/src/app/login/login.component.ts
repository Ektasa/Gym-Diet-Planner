import { Component } from '@angular/core';
import { ApiService } from '../services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
    username: string = '';
    password: string = '';
    errorMessage: string = '';
    isLoading: boolean = false;

    constructor(
        private apiService: ApiService,
        private router: Router
    ) { }

    login() {
        if (!this.username || !this.password) {
            this.errorMessage = 'Please enter both username and password';
            return;
        }

        this.isLoading = true;
        this.errorMessage = '';

        this.apiService.login(this.username, this.password).subscribe({
            next: (response: any) => {
                console.log('Login successful:', response);
                this.isLoading = false;
                if (response.status === 'success') {
                    // Store user info if needed
                    if (response.username) {
                        localStorage.setItem('username', response.username);
                    }
                    // Navigate to home page
                    this.router.navigate(['/home']);
                }
            },
            error: (error: any) => {
                console.error('Login error:', error);
                this.isLoading = false;
                this.errorMessage = error.error?.message || 'Connection failed. Please check if the backend server is running on port 8080.';
            }
        });
    }
}
