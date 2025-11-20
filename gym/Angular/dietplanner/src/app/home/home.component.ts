import { Component } from '@angular/core';
import { trigger, style, transition, animate, query, stagger } from '@angular/animations';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  animations: [
    trigger('listStagger', [
      transition(':enter', [
        query(':enter', [
          style({ opacity: 0, transform: 'translateY(20px)' }),
          stagger(100, animate('450ms cubic-bezier(.2,.8,.2,1)', style({ opacity: 1, transform: 'none' })))
        ], { optional: true })
      ])
    ])
  ]
})
export class HomeComponent {
  sliderImages = [
    'assets/chest.jpeg',
    'assets/back.jpeg',
    'assets/legs.jpeg',
    'assets/shoulder.jpeg'
  ];

  exercises = [
    { title: 'Chest', img: 'assets/chest.jpeg', desc: 'Bench press, push-ups, flyes' },
    { title: 'Back', img: 'assets/back.jpeg', desc: 'Pull-ups, rows, deadlifts' },
    { title: 'Legs', img: 'assets/legs.jpeg', desc: 'Squats, lunges, leg-press' },
    { title: 'Shoulders', img: 'assets/shoulder.jpeg', desc: 'Overhead press, lateral raises' },
    { title: 'Arms', img: 'assets/Arms.jpeg', desc: 'Biceps curls, triceps dips' },
    { title: 'Core', img: 'assets/core.jpeg', desc: 'Planks, leg raises, twists' }
  ];
}
