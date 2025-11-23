import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-motelog',
  templateUrl: './motelog.component.html',
  styleUrl: './motelog.component.css'
})
export class MotelogComponent implements OnInit {
  mealPlans: any[] = [];
  loading: boolean = false;
  error: string = '';

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.loadMealPlans();
  }

  loadMealPlans(): void {
    this.loading = true;
    this.error = '';
    
    this.apiService.getAllWeeklyMealPlansForMote().subscribe({
      next: (data) => {
        // Handle both array and wrapped responses
        if (data && Array.isArray(data)) {
          this.mealPlans = data;
        } else if (data && data.body && Array.isArray(data.body)) {
          this.mealPlans = data.body;
        } else {
          this.mealPlans = [];
        }
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching meal plans:', err);
        this.error = err?.error?.message || 'Failed to load meal plans. Please try again later.';
        this.loading = false;
        this.mealPlans = [];
      }
    });
  }
} 
