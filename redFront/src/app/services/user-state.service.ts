import { Injectable, Output, EventEmitter } from '@angular/core';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserStateService {
  @Output() userLoggedIn = new EventEmitter();
  user: User;
  constructor() { }


  getUser() {
    return this.user;
  }

  setUser(user: User) {
    this.user = user;
    this.userLoggedIn.emit(this.user);
  }
}
