package com.hawk.plugin.rollbar;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;


@CapacitorPlugin(name = "CapacitorRollbar")
public class CapacitorRollbarPlugin extends Plugin {

    @PluginMethod
    public void updateAndroidManifest(PluginCall call) {
        String accessToken = call.getString("accessToken");

        if (accessToken != null) {
            updateMetaInManifest(accessToken);

            JSObject result = new JSObject();
            result.put("message", "Meta-data added to AndroidManifest.xml successfully.");
            call.success(result);
        } else {
            call.reject("Invalid access token provided.");
        }
    }

    private void updateMetaInManifest(String accessToken) {
        try {
            // Update the AndroidManifest.xml with the provided meta-data
            getBridge()
                .getActivity()
                .runOnUiThread(
                    () -> {
                        try {
                            String packageName = getBridge().getContext().getPackageName();
                            getBridge()
                                .getContext()
                                .getApplicationInfo()
                                .metaData.putString(packageName + ".com.rollbar.android.ACCESS_TOKEN", accessToken);
                        } catch (Exception e) {
                            Log.e("MyPlugin", "Error updating AndroidManifest.xml: " + e.getMessage());
                        }
                    }
                );
        } catch (Exception e) {
            Log.e("MyPlugin", "Error updating AndroidManifest.xml: " + e.getMessage());
        }
    }
}
