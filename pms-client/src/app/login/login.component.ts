import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  submit(){
    console.log(this.form.value);
    this.usersServiceService.create(this.form.value).subscribe((res:any) => {
         console.log('Student added successfully!');
         this.router.navigateByUrl('students');
    })
  }
}
