import { DeviceType } from './device-type';

export class Device {
  id: number;
  name: string;
  status: boolean;
  information: string;
  image: string;
  deviceType: DeviceType;
}
