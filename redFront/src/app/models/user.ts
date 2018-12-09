import { Role } from './role';
import { Device } from './device';
import { Room } from './room';

export class User {
  id: number;
  username: string;
  name: string;
  surname: string;
  mail: string;
  password: string;
  // role: Role;
  // device: Device;
  // room: Room;
}
