import { Component, OnInit } from '@angular/core';
import { ArticleService } from 'src/app/services/article.service';
import { ActivatedRoute, Router } from '@angular/router';
import { GroupService } from 'src/app/services/group.service';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent implements OnInit {
  currentArticle = {id: -1, text: '', title: '', description: '', imgage: '', created: '', published: false, group: null};
  message = '';
  groups: any = [];

  constructor(
    private articleService: ArticleService,
    private route: ActivatedRoute,
    private router: Router,
    private groupService: GroupService) { }

  ngOnInit(): void {
    this.message = '';
    this.getArticle(this.route.snapshot.paramMap.get('id'));
    this.groupService.getAll()
    .subscribe(
      data => {
        this.groups = data;
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }

  getArticle(id: string | null): void {
    this.articleService.get(id)
      .subscribe(
        data => {
          this.currentArticle = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
