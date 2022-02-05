import { Component, Input, OnInit } from '@angular/core';
import { ArticleService } from 'src/app/services/article.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LanguageService } from '../../services/language.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  public language: Observable<string>;
  public articles: any;

  constructor(
    private articleService: ArticleService,
    private route: ActivatedRoute,
    private router: Router,
    private languageService: LanguageService) {
      this.language = languageService.getLanguageObs()
    }

  ngOnInit(): void {
    this.articles = {}
    this.retrieveArticles();
  }

  retrieveArticles(): void {
    this.articleService.getAll()
      .subscribe(
        data => {
          data.forEach((e:any) => {
            if (this.articles[e.lang] != undefined) {
              this.articles[e.lang].push(e) ;
            }
            else {
              this.articles[e.lang]=[e];
            }
          });
          //this.articles = data;
        },
        error => {
          console.log(error);
        });
  }
}
