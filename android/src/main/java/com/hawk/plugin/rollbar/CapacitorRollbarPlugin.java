package com.hawk.plugin.rollbar;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.rollbar.android.Rollbar;


@CapacitorPlugin(name = "CapacitorRollbar")
public class CapacitorRollbarPlugin extends Plugin {

    private Rollbar rollbar;

    @Override
    public void load() {
        super.load();

        // Retrieve the access token from capacitor.config.json
        String accessToken = getConfig().getString("accessToken");
        String environment = getConfig().getString("environment");
        Boolean includeLogCat = getConfig().getBoolean("includeLogcat", false);
        Rollbar.init(getContext(), accessToken, environment, true, includeLogCat);
        String deviceBuildSerialNo = android.os.Build.SERIAL;
        rollbar = Rollbar.instance();
        rollbar.setPersonData(deviceBuildSerialNo, "", "");
    }


    @PluginMethod
    public void setPersonData(PluginCall call) {
        JSObject userData = call.getObject("userData");
        if (userData != null) {
            String userEmail = userData.getString("userEmail");
            String userName = userData.getString("userName");
            String deviceBuildSerialNo = android.os.Build.SERIAL;
            rollbar.setPersonData(deviceBuildSerialNo, userEmail, userName);
            call.resolve();
        }else{
            call.reject("Invalid user data provided.");
        }
    }

}
