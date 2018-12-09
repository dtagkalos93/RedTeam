import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CardModule} from 'primeng/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MegaMenuComponent } from './components/mega-menu/mega-menu.component';
import {MenubarModule} from 'primeng/menubar';
import { DeviceComponent } from './components/device/device.component';
import {DataViewModule} from 'primeng/dataview';
import {DialogModule} from 'primeng/dialog';
import {PanelModule} from 'primeng/panel';
import { HttpClientModule } from '@angular/common/http';
import {InputSwitchModule} from 'primeng/inputswitch';
import { FormsModule } from '@angular/forms';
import {ButtonModule} from 'primeng/button';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import { FieldsetModule } from 'primeng/components/fieldset/fieldset';
import { MessagesModule } from 'primeng/components/messages/messages';
import { RegisterComponent } from './components/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    MegaMenuComponent,
    DeviceComponent,
    HomePageComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    CardModule,
    MenubarModule,
    DataViewModule,
    DialogModule,
    PanelModule,
    HttpClientModule,
    InputSwitchModule,
    FormsModule,
    ButtonModule,
    FieldsetModule,
    MessagesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
