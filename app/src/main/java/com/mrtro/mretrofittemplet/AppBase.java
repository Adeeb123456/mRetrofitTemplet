package com.mrtro.mretrofittemplet;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;


import com.mrtro.mretrofittemplet.ws.ServiceGenerator;
import com.mrtro.mretrofittemplet.ws.WebService;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;



/**
 * Created by adeeb on 1/17/2017.
 */

public class AppBase extends Application {

    Context context;

    public static WebService service;
    public static File cacheDir;

    @Override
    public void onCreate() {
        super.onCreate();


        context = this;
        service = ServiceGenerator.createService(WebService.class);


        try {

            if (android.os.Environment.getExternalStorageState().equals(
                    android.os.Environment.MEDIA_MOUNTED)) {
                cacheDir = new File(android.os.Environment
                        .getExternalStorageDirectory().toString()
                        + "/Android/data/pkgname/", "Temp");
            } else {
                cacheDir = getCacheDir();
            }
            if (!cacheDir.exists()) {
                //noinspection ResultOfMethodCallIgnored
                cacheDir.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }






}
