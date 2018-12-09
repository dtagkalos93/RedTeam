import { Component, OnInit } from '@angular/core';
import {MatTabsModule} from '@angular/material/tabs';
import {Device} from '../device'

@Component({
  selector: 'app-top-menu',
  templateUrl: './top-menu.component.html',
  styleUrls: ['./top-menu.component.css']
})
export class TopMenuComponent implements OnInit {

  devices: Device[] = [
    {name:'Kitchen Lights', status:true,information:'Lights'},
    {name:'Cooker', status:false,information:'Cooker'}
  ];
    
  constructor() { }

  ngOnInit() {
  }

}
