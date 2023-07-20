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
        Rollbar.init(getContext(), accessToken, "spectro_android", true);
    }
}
