import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ArticlesListComponent } from './components/articles-list/articles-list.component';
import { ArticleDetailsComponent } from './components/article-details/article-details.component';
import { AddArticleComponent } from './components/add-article/add-article.component';
import { ArticleComponent } from './components/article/article.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { AboutComponent } from './components/about/about.component'

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'articles', canActivate: [AuthGuard], component: ArticlesListComponent },
  //{ path: 'articles', component: ArticlesListComponent },
  { path: 'articles/:id', component: ArticleComponent },
  { path: 'articlesDetails/:id', canActivate: [AuthGuard], component: ArticleDetailsComponent },
  { path: 'add', canActivate: [AuthGuard], component: AddArticleComponent },
  //{ path: 'add', component: AddArticleComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'about', component: AboutComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
