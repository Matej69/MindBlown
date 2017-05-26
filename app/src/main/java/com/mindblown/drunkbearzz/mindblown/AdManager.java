package com.mindblown.drunkbearzz.mindblown;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.Console;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Matej on 25/05/2017.
 */
public class AdManager {


    static private Activity curActvity;
    static private AdView adView_banner;


    static private int spawnAdTime = 20000;
    static public void TrySpawnAd(Activity _activity, AdView _adView)
    {
        if(canSpawnAd)
        {
            curActvity = _activity;
            adView_banner = _adView;

            AdRequest adRequest = new AdRequest.Builder().
                    //addTestDevice(AdRequest.DEVICE_ID_EMULATOR).
                    build();
            adView_banner.loadAd(adRequest);

            canSpawnAd = false;
        }
    }



    //CALLED ONLY ONEC FOR APPLICATION
    static private boolean canSpawnAd = false;
    static public void InitCanSpawnAdTimer()
    {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(),0,spawnAdTime);
    }

    static class MyTimerTask extends TimerTask {
        public void run() {
            canSpawnAd = true;
            Log.i("can spawn from now ","$$$$$$$$$$$$$$$$");
        }
    }






}
