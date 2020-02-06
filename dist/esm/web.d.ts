import { WebPlugin } from '@capacitor/core';
import { PusherBeamsPlugin } from './definitions';
export declare class PusherBeamsWeb extends WebPlugin implements PusherBeamsPlugin {
    constructor();
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
}
declare const PusherBeams: PusherBeamsWeb;
export { PusherBeams };
