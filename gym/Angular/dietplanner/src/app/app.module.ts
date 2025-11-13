import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MotelogComponent } from './motelog/motelog.component';
import { PatlelogComponent } from './patlelog/patlelog.component';

@NgModule({
  declarations: [
    AppComponent,
    MotelogComponent,
    PatlelogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
