package com.odbpo.fenggou.screendensity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.odbpo.fenggou.screendensity.util.DensityUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_w_h)
    TextView tvWH;
    @Bind(R.id.tv_density)
    TextView tvDensity;
    @Bind(R.id.tv_Dpi)
    TextView tvDpi;
    @Bind(R.id.tv_dp2px)
    TextView tvDp2px;
    @Bind(R.id.tv_px2dp)
    TextView tvPx2dp;
    @Bind(R.id.tv_tips_dp2px)
    TextView tvTipsDp2px;
    @Bind(R.id.tv_tips_px2dp)
    TextView tvTipsPx2dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initParams();
    }

    public void initParams() {
        //DisplayMetrics dm = getResources().getDisplayMetrics();//不包含状态栏高度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(dm);//真实宽高
        int widthPixels = dm.widthPixels;
        int heightPixels = dm.heightPixels;
        float density = dm.density;
        int densityDpi = dm.densityDpi;

        tvWH.setText("屏幕宽高：" + widthPixels + "*" + heightPixels);
        tvDensity.setText("屏幕密度：" + density);
        tvDpi.setText("屏幕Dpi：" + densityDpi);

        //=====================换算公式=================================
        int px_pre = 2;
        int dp_pre = 1;

        int dpi = DensityUtil.getDpi(this);
        float dp_result = DensityUtil.px2dp(this, px_pre);
        float px_result = DensityUtil.dp2px(this, dp_pre);
        //px=dp*(dpi/160)
        //dp=px/(dpi/160)
        tvTipsDp2px.setText("公式1：px=dp*(dpi/160)");
        tvTipsPx2dp.setText("公式2：dp=px/(dpi/160)");
        tvDp2px.setText(px_result + "px = " + dp_pre + "dp * (" + dpi + "/160)");
        tvPx2dp.setText(dp_result + "dp = " + px_pre + "px / (" + dpi + "/160)");
    }
}
