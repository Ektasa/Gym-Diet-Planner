import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-slider',
  templateUrl: './slider.component.html',
  styleUrls: ['./slider.component.scss']
})
export class SliderComponent implements OnInit {
  @Input() images: string[] = [];
  interval = 4000; // ms
  active = 0;
  timer: any;

  ngOnInit(): void {
    this.start();
  }

  start() {
    this.timer = setInterval(() => this.next(), this.interval);
  }

  stop() {
    clearInterval(this.timer);
  }

  next() {
    this.active = (this.active + 1) % this.images.length;
  }
  prev() {
    this.active = (this.active - 1 + this.images.length) % this.images.length;
  }
  go(i: number) {
    this.active = i;
  }
}
