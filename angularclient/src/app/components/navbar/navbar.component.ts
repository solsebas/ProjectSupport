import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AppComponent} from "../../app.component";
import {StorageService} from "../../services/storage/storage.service";
import {AuthService} from "../../services/auth/auth.service";



@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  isLoggedIn = false;
  roles: string[] = [];

  constructor(private storageService: StorageService, private authService: AuthService) { }

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
    }
  }

  logout() {
    this.authService.logout();
    this.storageService.clean();
    window.location.reload();
  }


}
