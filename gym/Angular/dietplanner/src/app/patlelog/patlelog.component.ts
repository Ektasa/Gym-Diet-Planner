import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service'; 

@Component({
  selector: 'app-patlelog',
  templateUrl: './patlelog.component.html',
  styleUrl: './patlelog.component.css'
})
export class PatlelogComponent implements OnInit {
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
    
    this.apiService.getAllWeeklyMealPlans().subscribe({
      next: (data) => {
        this.mealPlans = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching meal plans:', err);
        this.error = 'Failed to load meal plans. Please try again later.';
        this.loading = false;
      }
    });
  }
}
