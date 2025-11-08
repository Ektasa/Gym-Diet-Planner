// home.component.ts

import { Component, OnDestroy, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {
  connectionStatus = '';
  
  slides = [
    { img: 'assets/slider1.svg', title: 'Plan your week', text: 'Easy to follow 7-day plans to meet your goals.' },
    { img: 'assets/slider2.svg', title: 'Track progress', text: 'Log your meals and monitor improvements.' },
    { img: 'assets/slider3.svg', title: 'Stay motivated', text: 'Helpful tips and reminders to keep you going.' }
  ];

  currentIndex = 0;
  private intervalId: any = null;

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    // Test backend connection
    this.testBackendConnection();
    
    // Start autoplay
    this.intervalId = setInterval(() => this.next(), 4500);
  }

  ngOnDestroy(): void {
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
  }

  testBackendConnection() {
    this.apiService.testConnection().subscribe({
      next: (response) => {
        console.log('Backend connected:', response);
        this.connectionStatus = 'Connected to backend!';
      },
      error: (error) => {
        console.error('Backend connection failed:', error);
        this.connectionStatus = 'Failed to connect to backend';
      }
    });
  }

  next(): void {
    this.currentIndex = (this.currentIndex + 1) % this.slides.length;
  }

  prev(): void {
    this.currentIndex = (this.currentIndex - 1 + this.slides.length) % this.slides.length;
  }

  goTo(i: number): void {
    this.currentIndex = i;
  }
}
