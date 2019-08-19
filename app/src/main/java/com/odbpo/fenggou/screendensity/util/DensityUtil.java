package com.odbpo.fenggou.screendensity.util;

import android.content.Context;

/**
 * @author: zc
 * @Time: 2019/6/5 9:50
 * @Desc: https://www.cnblogs.com/libertycode/p/5247421.html
 */
public class DensityUtil {

    public static int getDpi(Context context) {
        int densityDpi = context.getResources().getDisplayMetrics().densityDpi;
        return densityDpi;
    }

    //dp=px/(dpi/160)
    public static float px2dp(Context context, int px) {
        float dp = px / (getDpi(context) / 160);
        return dp;
    }

    //px=dp*(dpi/160)
    public static float dp2px(Context context, int dp) {
        float px = dp * (getDpi(context) / 160);
        return px;
    }

}
