package com.cesarbarone.pusherbeams;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import com.pusher.pushnotifications.PushNotifications;


@NativePlugin()
public class PusherBeams extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.success(ret);
    }

//    @PluginMethod()
//    public void start(PluginCall call) {
//        String instanceId = "d774be36-78b4-4efb-95ce-cf406c9d885f";
//        PushNotifications.start(getApplicationContext(), instanceId);
//    }

    @PluginMethod()
    public void addDeviceInterest(PluginCall call) {
        String interest = call.getString("interest");
        PushNotifications.addDeviceInterest(interest);
        JSObject ret = new JSObject();
        ret.put("message", "Interest Added");
        call.success(ret);
    }
}
