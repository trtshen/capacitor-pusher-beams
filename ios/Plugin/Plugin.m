#import <Foundation/Foundation.h>
#import <Capacitor/Capacitor.h>

// Define the plugin using the CAP_PLUGIN Macro, and
// each method the plugin supports using the CAP_PLUGIN_METHOD macro.
CAP_PLUGIN(PusherBeams, "PusherBeams",
           CAP_PLUGIN_METHOD(echo, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(addDeviceInterest, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(setDeviceInterests, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(setUserId, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(removeDeviceInterest, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(getDeviceInterests, CAPPluginReturnPromise);
           CAP_PLUGIN_METHOD(clearDeviceInterests, CAPPluginReturnPromise);
)
