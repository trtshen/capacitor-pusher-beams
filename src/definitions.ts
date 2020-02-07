declare module "@capacitor/core" {
  interface PluginRegistry {
    PusherBeams: PusherBeamsPlugin;
  }
}

export interface PusherBeamsPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  // start(): Promise<{}>
  addDeviceInterest(options: { interest: string }): Promise<{ message: string }>;
  // removeDeviceInterest(options: { interest: string }): Promise<{ success: boolean }>;
  // getDeviceInterests(options: { interests: Array<String> }): Promise<{ interests: Array<String> }>;
  // setDeviceInterests(): Promise<{ success: boolean }>;
  // clearDeviceInterests(): Promise<{ success: boolean }>;
  // setOnDeviceInterestsChangedListener(): Promise<{ success: boolean }>;
  // setOnMessageReceivedListenerForVisibleActivity(): Promise<{ success: boolean }>;
  setUserID(options: { beamsAuthURL: string, userID: string, headers: JSON }): Promise<{message: string } | string>;
  // clearAllState(): Promise<{ success: boolean }>;
  // stop(): Promise<{ success: boolean }>;
}
