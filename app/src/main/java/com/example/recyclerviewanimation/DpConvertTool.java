package com.example.recyclerviewanimation;

import android.util.TypedValue;

public class DpConvertTool {

    private static DpConvertTool instance = null;

    public static DpConvertTool getInstance(){
        if (instance == null){
            instance = new DpConvertTool();
            return instance;
        }
        return instance;
    }

    public int getDp(int value){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,value,MyApplication.getInstance().getApplicationContext().getResources().getDisplayMetrics());
    }

}
