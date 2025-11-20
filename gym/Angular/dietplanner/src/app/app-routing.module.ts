import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MotelogComponent } from './motelog/motelog.component';
import { PatlelogComponent } from './patlelog/patlelog.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "home", component: HomeComponent },
  { path: "mote", component: MotelogComponent },
  { path: "patle", component: PatlelogComponent },
  { path: "login", component: LoginComponent },
  { path: "signup", component: SignupComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
