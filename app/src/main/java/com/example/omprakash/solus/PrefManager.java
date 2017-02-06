package com.example.omprakash.solus;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context mContext;

    int PIVATE_MODE=0;

    private static final String PREF_NAME = "techofes_welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context){
        this.mContext = context;
        sharedPreferences = mContext.getSharedPreferences(PREF_NAME,PIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
