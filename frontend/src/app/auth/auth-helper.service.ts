import {Injectable} from "@angular/core";

@Injectable()
export class AuthHelperService {

  private tokenKey: string;

  constructor() {
    this.tokenKey = 'id_token'
  }

  setSession(authResult) {
    localStorage.setItem(this.tokenKey, authResult.idToken);
  }

  logout() {
    localStorage.removeItem(this.tokenKey);
  }

  public isLoggedIn(): boolean {
    return this.getToken() != null;
  }

  public getToken(): string {
    return localStorage.getItem(this.tokenKey);
  }

}
