package com.hawk.plugin.rollbar;

import android.util.Log;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import android.util.Log;

public class CapacitorRollbar {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
