import { WebPlugin } from '@capacitor/core';
import { PusherBeamsPlugin } from './definitions';

export class PusherBeamsWeb extends WebPlugin implements PusherBeamsPlugin {
  constructor() {
    super({
      name: 'PusherBeams',
      platforms: ['web']
    });
  }

  addDeviceInterest(options: { interest: string; }): Promise<{ message: string; }> {
    console.log(options);
    throw new Error("Method not implemented.");
  }
  setUserID(options: { beamsAuthURL: string; userID: string; headers: JSON; }): Promise<string | { message: string; }> {
    console.log(options);
    throw new Error("Method not implemented.");
  }

  async echo(options: { value: string }): Promise<{value: string}> {
    console.log('ECHO::', options);
    return options;
  }

  async removeDeviceInterest(options: { interest: string }): Promise<{ success: boolean }> {
    console.log('removeDeviceInterest::', options);
    return options;
  };
}

const PusherBeams = new PusherBeamsWeb();

export { PusherBeams };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(PusherBeams);
