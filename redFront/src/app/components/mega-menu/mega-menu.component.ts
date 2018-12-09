import { Component, OnInit } from '@angular/core';
import {MenuItem} from 'primeng/api';
import { Room } from 'src/app/models/room';
import { HomeService } from 'src/app/services/home.service';
import { User } from 'src/app/models/user';
import { UserStateService } from 'src/app/services/user-state.service';

@Component({
  selector: 'app-mega-menu',
  templateUrl: './mega-menu.component.html',
  styleUrls: ['./mega-menu.component.css']
})
export class MegaMenuComponent implements OnInit {
  room: Room[];
  constructor(private homeSercive: HomeService, private userStateService: UserStateService) { }
  items: MenuItem[];
  ngOnInit() {
    const user = new User();
    user.name = 'Dimitris';
    this.userStateService.setUser(user);
    this.homeSercive.getRooms()
      .subscribe(data => {
        this.room = data;
        this.items = [
          {label: 'Home', routerLink: ['/home']}
        ];
        for (let i = 0 ; i < this.room.length; i++) {
          console.log(this.room[i].name);
          this.items.push({label: `${this.room[i].name}`, routerLink: [`/room/${this.room[i].id}`]});
          }
      });

  }

}
