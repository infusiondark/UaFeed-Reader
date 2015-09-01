package com.app.uafeed;

import android.os.Environment;

public class Const {    
    public static String API_ID="2964785";
    public static String API_Key="kePr7Qy73A6vk1uqJs8h";
    
    public static boolean IsLogEnabled = true; 
    public static String LogTag="klim";
    
    public static String getPhotosDir() {
    	if (!Environment.getExternalStorageState().equals("mounted"))
    		return Environment.getExternalStorageDirectory() + "vk_mini_photos";
    	else 
    		return null;
    }
    public static String avatarsDir="klim";
}
