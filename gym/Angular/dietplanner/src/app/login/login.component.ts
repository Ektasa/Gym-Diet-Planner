import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {


    constructor(private httpClient:HttpClient) { }

    user : any[]=[];

    Login=new FormGroup({
        username:new FormControl(''),
        password:new FormControl('')
    });
    OnSubmit(){
       const url="http://localhost:8080/login/submit"
        console.log(this.Login.value);
        this.httpClient.post(url,this.Login.value).subscribe((response)=>{
            console.log(response);

        } ,error=>{
            console.log("error on this login "+error);
        }   
        );
    } 
     
}
