import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomePageComponent } from './home-page/home-page.component';
import { TopMenuComponent } from './top-menu/top-menu.component';


const routes: Routes = [
  { path: '', redirectTo: '/home-page', pathMatch: 'full' },
  { path: 'home-page', component: HomePageComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent},

  { path: 'top-menu', component: TopMenuComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
