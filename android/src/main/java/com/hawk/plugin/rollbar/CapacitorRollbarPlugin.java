package com.hawk.plugin.rollbar;

import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.rollbar.android.Rollbar;


@CapacitorPlugin(name = "CapacitorRollbar")
public class CapacitorRollbarPlugin extends Plugin {

    @Override
    public void load() {
        super.load();

        // Retrieve the access token from capacitor.config.json
        String accessToken = getConfig().getString("accessToken");
        String environment = getConfig().getString("environment");
        Rollbar.init(getContext(), accessToken, environment, true);
        String deviceBuildSerialNo = android.os.Build.SERIAL;
        Rollbar.setPersonData(null, null, null, deviceBuildSerialNo);
    }


    @PluginMethod
    public void setPersonData(PluginCall call) {
        JSObject userData = call.getObject("userData");
        if (userData != null) {
            String userId = userData.getString("userId");
            String userEmail = userData.getString("userEmail");
            String userName = userData.getString("userName");
            String deviceBuildSerialNo = android.os.Build.SERIAL;
            Rollbar.setPersonData(userId, userEmail, userName, deviceBuildSerialNo);
            call.resolve();
        }else{
            call.reject("Invalid user data provided.")
        }
    }

}
