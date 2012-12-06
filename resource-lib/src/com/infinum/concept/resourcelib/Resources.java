
package com.infinum.concept.resourcelib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.InputStream;

public class Resources {

    private static String getPath(Context context, String packageName, String resourceName) {
        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                return packageName + "/drawable_ldpi/" + resourceName;
            case DisplayMetrics.DENSITY_MEDIUM:
                return packageName + "/drawable_mdpi/" + resourceName;
            case DisplayMetrics.DENSITY_HIGH:
                return packageName + "/drawable_hdpi/" + resourceName;
            case DisplayMetrics.DENSITY_XHIGH:
                return packageName + "/drawable_xhdpi/" + resourceName;
            default:
                return packageName + "/drawable/" + resourceName;
        }
    }

    private static String getDefaultPath(String packageName, String resourceName) {
        return packageName + "/drawable/" + resourceName;
    }

    private static Bitmap getBitmap(String path) {
        InputStream stream = Resources.class.getClassLoader().getResourceAsStream(path);
        if (stream == null) {
            return null;
        }

        return BitmapFactory.decodeStream(stream);
    }

    /**
     * Returns a bitmap resource packaged inside of a source directory. 
     * 
     * @param context			
     * @param packageName			name of the package 
     * @param resourceName
     * @return
     */
    public static Bitmap getBitmapResourceByName(Context context, String packageName, String resourceName) {
    	Log.d("Resources", "loadingBitmapResource: " + getPath(context, packageName, resourceName));
        Bitmap bitmap = getBitmap(getPath(context, packageName, resourceName));

        if (bitmap == null) {
            bitmap = getBitmap(getDefaultPath(packageName, resourceName));
        }

        return bitmap;
    }
}
