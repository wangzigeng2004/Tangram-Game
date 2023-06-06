package com.dawmi2.tangramv6;

import android.graphics.Color;


class HerramientaColor {
    public boolean compruebaMuestra(int color1, int color2) {
        int tolerancia = 25;
        if (Math.abs (Color.red (color1) - Color.red (color2)) > tolerancia) return false;
        if (Math.abs (Color.green (color1) - Color.green (color2)) > tolerancia) return false;
        return Math.abs(Color.blue(color1) - Color.blue(color2)) <= tolerancia;
    } // end match
}
