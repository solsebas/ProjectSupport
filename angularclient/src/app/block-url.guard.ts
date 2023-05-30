import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { StorageService } from './services/storage/storage.service';

@Injectable({
  providedIn: 'root'
})
export class BlockUrlGuard implements CanActivate {

  constructor(private storageService: StorageService, private router: Router) {}

  canActivate(): boolean {
    if (this.storageService.isLoggedIn()) {
      const user = this.storageService.getUser();

      if (user.roles.includes('ROLE_ADMIN')) {
        return true; // pozwól adminowi uzyskać dostęp do dowolnej strony
      }
      else {
        const url: string = this.router.url; // url pod jaki uzytkownik chce przejść


        if (user.roles.includes('ROLE_SUPERVISOR')) {
          if (url === '/admin' || url === '/admin/register' || url === '/student' || url === '/student/team' || url === '/student/team/') {
            this.router.navigate(['/access-denied']);
            return false;
          } else {
            return true;
          }
        } else if (user.roles.includes('ROLE_STUDENT')) {
          if (url === '/admin' || url === '/admin/register' || url === '/supervisor' || url === '/supervisor/team' || url === '/supervisor/topic' || url === '/supervisor/team-manage' || url === '/supervisor/team-manage/') {
            this.router.navigate(['/access-denied']);
            return false;
          } else {
            return true;
          }
        } else {
          this.router.navigate(['/access-denied']);
          return false;
        }
      }
    }
    else {
      this.router.navigate(['/login']);
      return false;
    }
  }
}
