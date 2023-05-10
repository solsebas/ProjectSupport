import {Component, OnInit} from '@angular/core';
import {StorageService} from "../../services/storage.service";
import {AuthService} from "../../services/auth.service";

@Component({
  selector: 'app-side-navbar',
  templateUrl: './side-navbar.component.html',
  styleUrls: ['./side-navbar.component.scss']
})
export class SideNavbarComponent implements OnInit {

  private roles: string[] = [];
  isUserAdmin = false;
  isUserSupervisor = false;
  isUserStudent = false;
  isLoggedIn = false;

  constructor(private storageService: StorageService, private authService: AuthService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.storageService.isLoggedIn();

    if (this.isLoggedIn) {
      const user = this.storageService.getUser();
      this.roles = user.roles;

      this.isUserAdmin = this.roles.includes('ROLE_ADMIN');
      this.isUserSupervisor = this.roles.includes('ROLE_SUPERVISOR');
      this.isUserStudent = this.roles.includes('ROLE_STUDENT');

    }


  }

}
