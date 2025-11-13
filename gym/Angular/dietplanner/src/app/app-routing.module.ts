import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MotelogComponent } from './motelog/motelog.component';

import { PatlelogComponent } from './patlelog/patlelog.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [{ path: "mote", component: MotelogComponent }
  ,{path: "patle", component: PatlelogComponent }
,{path: "login", component: LoginComponent }  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
