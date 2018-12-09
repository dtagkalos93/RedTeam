import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { DeviceComponent } from './components/device/device.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent },
  { path: 'room/:id', component: DeviceComponent , runGuardsAndResolvers: 'always'},
  { path: 'login', component: LoginComponent , runGuardsAndResolvers: 'always'},
  { path: 'register', component: RegisterComponent , runGuardsAndResolvers: 'always'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
