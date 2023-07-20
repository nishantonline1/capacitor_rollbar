package com.hawk.plugin.rollbar;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;
import com.rollbar.android.Rollbar;

public class MainActivity extends BridgeActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize Rollbar in MainActivity's onCreate
        String environment = "spectro_android";
        boolean suspendWhenNetworkIsUnavailable = true;
        Rollbar.init(this, null, environment, suspendWhenNetworkIsUnavailable);
    }
}
