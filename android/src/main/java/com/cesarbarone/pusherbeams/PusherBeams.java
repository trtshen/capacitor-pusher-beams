package com.cesarbarone.pusherbeams;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import com.pusher.pushnotifications.BeamsCallback;
import com.pusher.pushnotifications.PushNotifications;
import com.pusher.pushnotifications.PushNotificationsInstance;
import com.pusher.pushnotifications.PusherCallbackError;
import com.pusher.pushnotifications.auth.AuthData;
import com.pusher.pushnotifications.auth.AuthDataGetter;
import com.pusher.pushnotifications.auth.BeamsTokenProvider;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


@NativePlugin()
public class PusherBeams extends Plugin {

    @PluginMethod()
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);

//        Context ctx = this.getActivity().getApplicationContext();
        // PushNotificationsInstance start = PushNotifications.start(call.getApplicationContext(), "f5df7283-144c-458c-ac23-622b2d47eed9");
        PushNotifications.addDeviceInterest(value); // dynamic interest code
        // PushNotifications.addDeviceInterest("testing-interest");

        Log.i("PusherBeams", "Successfully subscribed to 'testing-interest'");
        call.success(ret);
    }

//    // this step should be done inside MainActivity.java where we can extend "capacitor's BridgeActivity"
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

    @PluginMethod()
    public void removeDeviceInterest(PluginCall call) {
        String interest = call.getString("interest");
        PushNotifications.removeDeviceInterest(interest);
        call.success();
    }

    @PluginMethod()
    public void getDeviceInterests(PluginCall call) {
        Set<String> interests = PushNotifications.getDeviceInterests();
        JSObject ret = new JSObject();
        ret.put("interests", interests);
        call.success(ret);
    }

    @PluginMethod()
    public void setDeviceInterests(PluginCall call) {
        throw new NullPointerException("PushNotifications setDeviceInterests metheod not implemented yet");
    }

    @PluginMethod()
    public  void clearDeviceInterests(PluginCall call) {
        PushNotifications.clearDeviceInterests();
        call.success();
    }

    @PluginMethod()
    public void setOnDeviceInterestsChangedListener(PluginCall call) {
        throw new NullPointerException("PushNotifications setOnDeviceInterestsChangedListener metheod not implemented yet");
    }

    @PluginMethod()
    public  void setOnMessageReceivedListenerForVisibleActivity(PluginCall call) {
        throw new NullPointerException("PushNotifications setOnMessageReceivedListenerForVisibleActivity metheod not implemented yet");
    }

    @PluginMethod()
    public void setUserID(final PluginCall call) {
        String beamsAuthURl = call.getString("beamsAuthURL");
        String userID = call.getString("userID");
        JSObject headers = call.getObject("headers");
        final HashMap headersHashMap = hashMapOf(headers);

        BeamsTokenProvider tokenProvider = new BeamsTokenProvider(
            beamsAuthURl,
            new AuthDataGetter() {
                @Override
                public AuthData getAuthData() {
                    HashMap<String, String> queryParams = new HashMap<>();
                    return new AuthData(
                            headersHashMap,
                            queryParams
                    );
                }
            }
        );

        PushNotifications.setUserId(userID, tokenProvider, new BeamsCallback<Void, PusherCallbackError>(){
            @Override
            public void onSuccess(Void... values) {
                JSObject ret = new JSObject();
                Log.i("PusherBeams", "Successfully authenticated with Pusher Beams");
                ret.put("message", "Successfully authenticated with Pusher Beams");
                call.success(ret);
            }

            @Override
            public void onFailure(PusherCallbackError error) {
                Log.i("PusherBeams", "Pusher Beams authentication failed: " + error.getMessage());
                call.reject("Pusher Beams authentication failed: " + error.getMessage());
            }
        });

    }

    @PluginMethod()
    public  void clearAllState(PluginCall call) {
        PushNotifications.clearAllState();
        JSObject ret = new JSObject();
        ret.put("success", false);
        call.success(ret);
    }

    @PluginMethod()
    public  void stop(PluginCall call) {
        PushNotifications.stop();
        JSObject ret = new JSObject();
        ret.put("success", false);
        call.success(ret);
    }

    public static HashMap<String, String> hashMapOf(JSObject object) {
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keysIt = object.keys();
        while (keysIt.hasNext()) {
            String key = keysIt.next();
            String value = object.getString(key);
            hashMap.put(key, value);
        }
        return hashMap;
    }
}
