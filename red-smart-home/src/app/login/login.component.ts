import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import { ApiService } from '../api.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  invalidLogin = false;


  constructor(private formBuilder: FormBuilder, private router: Router, private apiService: ApiService) { }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    const loginPayload = {
      email: this.loginForm.controls.username.value,
      password: this.loginForm.controls.password.value
    };
    // // this.apiService.login(loginPayload).subscribe(data => {
    // //   if(data.status === 200) {
    // //     console.log('OK');
    // //     // window.localStorage.setItem('token', data.result.token);
    // //     // this.router.navigate(['dashboard']);
    // //   }else {
    // //     console.log('erro');
    // //     // this.invalidLogin = true;
    // //     // alert(data.message);
    // //   }
    // });
  }

  ngOnInit() {
    window.localStorage.removeItem('token');
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });
  }

}