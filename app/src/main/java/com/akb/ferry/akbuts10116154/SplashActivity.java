package com.akb.ferry.akbuts10116154;

/**
 * NIM : 10116154
 * Nama : Ferry Hermawan
 * Kelas : IF4
 * Tgl Pengerjaan : 19 Mei 2019
 */

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {
    private int waktu_loading = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(SplashActivity.this, ViewPagerActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_loading);
    }
}
