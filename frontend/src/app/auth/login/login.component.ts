import { Component, OnInit } from '@angular/core';
import {AuthService} from "../auth.service";
import {NgForm} from "@angular/forms";
import {slideToBottom} from "../../shared/router.animations";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  animations: [slideToBottom()]
})
export class LoginComponent implements OnInit {

  loginMessage: string = '';
  canLogin: boolean = true;

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
  }

  onLogin(form: NgForm) {
    this.canLogin = false;
    this.loginMessage = "";
    this.authService.loginUser(form.value.username, form.value.password)
      .subscribe(
        response => {
          //console.log(response);
          if (response == undefined || response == null || response.token == null) {
            this.loginMessage = "Empty response or token not found.";
            this.canLogin = true;
          } else {
            this.loginMessage = "Login successful!";
            this.canLogin = false;
            this.router.navigate(["/"]);
          }
        },
        error => {
          //console.log(error);
          this.canLogin = true;
          switch (error.status) {
            case 403:
              this.loginMessage = error.statusText;
              break;
            case 504:
              this.loginMessage = "Some problem with connecting to the server. Status: " + error.statusText;
              break;
          }
        }
      );
  }

}
