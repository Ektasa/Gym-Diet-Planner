import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-motelog',
  templateUrl: './motelog.component.html',
  styleUrl: './motelog.component.css'
})
export class MotelogComponent implements OnInit{

ngOnInit(): void {
    this.Onshow();
}
 constructor(private httpClient:HttpClient) { }

user : any[]=[];

  Onshow(){
       const url="http://localhost:8080/login/getuser"
        // console.log(this.Login.value);
        this.httpClient.get(url).subscribe((response:any)=>{
            console.log(response);
            this.user=response;
        } ,error=>{
            console.log("error on this login "+error);
        }   
        );


    } 

    DeleteUser(id:any){
         const url="http://localhost:8080/login/delete";    
         this.httpClient.get(url+"/"+id).subscribe((response:any)=>{
            console.log(response);
            this.Onshow();
        } ,error=>{
            console.log("error on this delete "+error);
        }
        );
    }    
} 
