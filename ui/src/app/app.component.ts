import { Component, OnInit } from '@angular/core';
import { ViewEncapsulation } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LanguageService } from './services/language.service';
import { AuthService } from './services/auth.service'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent implements OnInit {
  public language: Observable<string>;

  constructor (
    private route: ActivatedRoute,
    private router: Router,
    private languageService: LanguageService,
    private authService: AuthService
  ) {
    this.language = languageService.getLanguageObs()
  }
  
  title = 'yogasiteFrontEnd';

  ngOnInit(): void {
    this.setLanguage('us');
  }

  public setLanguage(language: string) {
    this.languageService.setLanguage(language);
  }

  public logout() {
    this.authService.logout();
  }

  public isLoggedIn() {
    return this.authService.isLoggedIn();
  }
}
