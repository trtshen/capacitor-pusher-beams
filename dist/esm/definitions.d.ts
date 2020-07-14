declare module "@capacitor/core" {
    interface PluginRegistry {
        PusherBeams: PusherBeamsPlugin;
    }
}
export interface PusherBeamsPlugin {
    echo(options: {
        value: string;
    }): Promise<{
        value: string;
    }>;
    addDeviceInterest(options: {
        interest: string;
    }): Promise<{
        message: string;
    }>;
    removeDeviceInterest(options: {
        interest: string;
    }): Promise<{
        success: boolean;
    }>;
    setUserID(options: {
        beamsAuthURL: string;
        userID: string;
        headers: JSON;
    }): Promise<{
        message: string;
    } | string>;
}
