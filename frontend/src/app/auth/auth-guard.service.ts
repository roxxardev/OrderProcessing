import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {AuthHelperService} from "./auth-helper.service";

@Injectable()
export class AuthGuardService implements CanActivate {

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if(this.authHelper.isLoggedIn()) {
      return true;
    }

    this.router.navigate(['login']);
    return false;
  }

  constructor(private authHelper: AuthHelperService, private router: Router) {
  }

}
