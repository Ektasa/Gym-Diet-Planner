// src/app/mote/mote.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-mote',
  templateUrl: './mote.component.html',
  styleUrls: ['./mote.component.css']
})
export class MoteComponent {
  days = [1, 2, 3, 4, 5, 6, 7];
  breakfastInput: any;
  lunchInput: any;
  dinnerInput: any;
}
