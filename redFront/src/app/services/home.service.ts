import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Room } from '../models/room';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class HomeService {
  ROOM_URL = 'http://localhost:8083/rooms/';

  constructor(private httpClient: HttpClient) { }

  getRooms(): Observable<Room[]> {
    return this.httpClient.get<any>
      (this.ROOM_URL ).pipe(map(response => {
        return response;
      }));
  }
}
