import {Component, OnInit} from '@angular/core';
import {AuthHelperService} from "../../auth/auth-helper.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public isCollapsed = true;

  constructor(private authHelperService: AuthHelperService) {
  }

  ngOnInit() {
  }

  isAuthenticated() {
    return this.authHelperService.isLoggedIn();
  }

  onLogout() {
    this.authHelperService.logout();
  }
}
