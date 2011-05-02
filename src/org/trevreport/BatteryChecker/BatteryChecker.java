package org.trevreport.BatteryChecker;

import android.os.BatteryManager.*;
import android.content.*;
import android.util.*;
import com.phonegap.api.*;
import org.json.JSONArray;


public class BatteryChecker extends Plugin {
    private BroadcastReceiver mBatInfoReceiver;
    private int level = 0;

    public BatteryChecker() {
        mBatInfoReceiver = new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent intent) {
              level = intent.getIntExtra("level", 0);
            }
          };
    }

    public void setContext(PhonegapActivity ctx) {
        super.setContext(ctx);
        this.ctx.registerReceiver(mBatInfoReceiver,
            new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    public PluginResult execute(String action, JSONArray args, String callbackId) {
        PluginResult.Status status = PluginResult.Status.OK;

        if (action.equals("getLevel")) {
            Log.d("BatteryChecker level: ", "" + level);
        }

        return new PluginResult(status, level);
    }
}
