import { Injectable } from '@angular/core';
import { Device } from '../models/device';
import { map } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class DeviceService {
  DEVICES_URL = 'http://localhost:8083/devices/';
  ROOM_URL = 'http://localhost:8083/rooms/';



  constructor(private httpClient: HttpClient) { }

  getDevices(id: number): Observable<Device[]> {
    return this.httpClient.get<any>
      (this.ROOM_URL + id).pipe(map(response => {
        return response.devices;
      }));
  }

  updateDevice(device: Device) {
    return this.httpClient.put<Device>
            (this.DEVICES_URL + device.id, device);
  }
}
