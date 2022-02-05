import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    private router: Router,
    private authService: AuthService
  ) { }

  canActivate() {
    if (!this.authService.isLoggedIn())
    {
      this.router.navigate(['/login']);
      return false;
    }
    else
    {
      return true;
    }
  }

  //canActivate(
  //  route: ActivatedRouteSnapshot,
  //  state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
  //  return true;
  //}
  
}
