package com.dawmi2.tangramv6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Info extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView tv_puntos = findViewById(R.id.tv_n_puntos);
        TextView tv_nivel = findViewById(R.id.tv_num_nivel);
        TextView tv_completadas = findViewById(R.id.tv_num_fig_comp);

        int puntuacion = getIntent().getIntExtra("PUNTUACION", 0);
        int nivel = getIntent().getIntExtra("NIVEL", 0);
        int completadas = getIntent().getIntExtra("COMPLETADAS", 0);

        tv_puntos.setText(Integer.toString(puntuacion));
        tv_nivel.setText(nivel+"");
        tv_completadas.setText(completadas+"");
    }
    @Override
    protected void onResume() {
        super.onResume();
        hideBottomUIMenu();
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}
