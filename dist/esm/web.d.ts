import { WebPlugin } from '@capacitor/core';
import { PusherBeamsPlugin } from './definitions';
export declare class PusherBeamsWeb extends WebPlugin implements PusherBeamsPlugin {
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
    constructor();
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
declare const PusherBeams: PusherBeamsWeb;
export { PusherBeams };
