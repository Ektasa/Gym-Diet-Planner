import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { MatDividerModule } from '@angular/material/divider';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { MotelogComponent } from './motelog/motelog.component';
import { PatlelogComponent } from './patlelog/patlelog.component';
import { SliderComponent } from './slider/slider.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
// import { SliderComponent } from './slider/slider.component';

@NgModule({
  // declarations: [
  //   AppComponent,
  //   LoginComponent,
  //   SignupComponent,
  //   HomeComponent,
  //   MotelogComponent,
  //   PatlelogComponent,
  //   SliderComponent
  // ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatMenuModule,
    MatDividerModule
  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent],
  declarations: [
    SliderComponent
  ]
})
export class AppModule { }
