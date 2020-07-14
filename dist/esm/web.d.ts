import { WebPlugin } from '@capacitor/core';
import { PusherBeamsPlugin } from './definitions';
export declare class PusherBeamsWeb extends WebPlugin implements PusherBeamsPlugin {
    constructor();
    addDeviceInterest(options: {
        interest: string;
    }): Promise<{
        message: string;
    }>;
    setUserID(options: {
        beamsAuthURL: string;
        userID: string;
        headers: JSON;
    }): Promise<string | {
        message: string;
    }>;
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    removeDeviceInterest(options: {
        interest: string;
    }): Promise<{
        success: boolean;
    }>;
}
declare const PusherBeams: PusherBeamsWeb;
export { PusherBeams };
