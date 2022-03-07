package com.ifly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Universal {
    public static boolean first = true;
    public void OpenGivenActivity(Context context, Class nextClass) {
        Intent intent = new Intent(context, nextClass);
        context.startActivity(intent);
    }

    public void OpenGivenActivity(Context context, Class nextClass, Boolean finish) {
        Intent intent = new Intent(context, nextClass);
        context.startActivity(intent);
        if (finish) {
            ((Activity) context).finish();
        }
    }
    public void SetStatusBar(Activity context) {
        //setting status bar color
        Window window;
        window = context.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(context.getColor(R.color.bg_blur_white));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public void FinishActivity(Activity activity){
        activity.finish();
    }
}
