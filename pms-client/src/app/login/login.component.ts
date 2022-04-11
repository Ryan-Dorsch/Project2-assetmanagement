import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsersService } from '../services/users-service.service';
import { Users } from '../model/users';
import { FormGroup,Validators, FormControl} from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
form!: FormGroup;
user!: Users; 
  constructor(
    public usersService: UsersService, 
      private router: Router
    ) { }
  
    ngOnInit(): void {
      this.form = new FormGroup({
        username: new FormControl('', [Validators.required]),
        password: new FormControl('', [Validators.required]),
      
      });
    }
  
    
  

    
    get f(){
      return this.form.controls;
    }
     
    submit(){
      console.log(this.form.value);
      this.usersService.create(this.form.value).subscribe((res:any) => {
           console.log('Sign in successful!');
           this.router.navigateByUrl('users');
      })
    }

  }