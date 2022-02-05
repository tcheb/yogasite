import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ReplaySubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  constructor() { }

  private language: ReplaySubject<string> = new ReplaySubject<string>();

  public setLanguage(language: string) {
    this.language.next( language );
    console.log("language in service: " + language);
  }

  public getLanguageObs(): Observable<string> {
    return this.language.asObservable();
  }
}
