import { Component, OnInit, DoCheck } from '@angular/core';
import { Device } from 'src/app/models/device';
import { DeviceType } from 'src/app/models/device-type';
import { DeviceService } from 'src/app/services/device.service';
import { ActivatedRoute } from '@angular/router';
import { Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css']
})
export class DeviceComponent implements OnInit {
  devices: Device[];
  selectedDevice: Device;
  imagesDevice: String[];

  navigationSubscription;
  displayDialog: boolean;
  change = false;

  constructor(private deviceService: DeviceService, private route: ActivatedRoute, private router: Router) {
    this.navigationSubscription = this.router.events.subscribe((e: any) => {
      // If it is a NavigationEnd event re-initalise the component
      if (e instanceof NavigationEnd) {
        this.initialiseInvites();
      }
    });
   }

   initialiseInvites() {
    // Set default values and re-fetch any data you need.
    const id = Number(this.route.snapshot.paramMap.get('id'));
      console.log(id);

      this.deviceService.getDevices(id)
      .subscribe(data => {
        this.devices = data;
        for (let i = 0 ; i < this.devices.length; i++) {
          let stat;
          if(this.devices[i].status){
            stat= 'on';
          }
          else{
            stat = 'off';
          }

            this.devices[i].image=this.devices[i].deviceType.typeName.replace(/\s/g, "").toLowerCase() + "_"+ stat;
            console.log(this.devices[i].image);

          
         }

      });
      
  }

  ngOnInit() {
  }



  selectDevice(event: Event, device: Device) {
    this.selectedDevice = device;
    console.log(this.selectedDevice);
    this.change = false;
    this.displayDialog = true;
    event.preventDefault();
  }

  saveChanges() {
    if (this.change) {
    this.deviceService.updateDevice(this.selectedDevice)
    .subscribe(data => {
      this.displayDialog = false;
      console.log('Update' , data);
      this.selectedDevice = data;
    });
    }
  }

  handleChange(e) {
    let stat;
    if(this.selectedDevice.status){
      stat= 'on';
    }
    else{
      stat = 'off';
    }
    this.selectedDevice.image=this.selectedDevice.deviceType.typeName.replace(/\s/g, "").toLowerCase() + "_"+ stat;
    this.change = !this.change;
  }

  onDialogHide() {
    this.selectedDevice = null;
}
}
