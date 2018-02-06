import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthHelperService} from "./auth-helper.service";
import "rxjs/add/operator/map";
import "rxjs/add/operator/do";

@Injectable()
export class AuthService {

  constructor(private http: HttpClient, private authHelper: AuthHelperService) {
  }

  loginUser(username: string, password: string) {
    return this.http.post<{token: string}>('/api/login', JSON.stringify({username: username, password: password}))
      .do(
        response => {
          this.authHelper.setSession(response.token);
        }
      );
  }

}
