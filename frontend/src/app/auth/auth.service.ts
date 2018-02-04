import {Injectable} from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {AuthHelperService} from "./auth-helper.service";
import "rxjs/add/operator/map";

@Injectable()
export class AuthService {

  constructor(private router: Router, private http: HttpClient, private authHelper: AuthHelperService) {
  }

  loginUser(username: string, password: string) {
    return this.http.post<{token: string}>('/api/login', JSON.stringify({username: username, password: password}))
      .subscribe(
        response => {
          this.authHelper.setSession(response.token)
        });
  }

}
