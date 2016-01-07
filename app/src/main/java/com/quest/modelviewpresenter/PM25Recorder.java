package com.quest.modelviewpresenter;

import android.graphics.Color;

/**
 * Created by ningyi on 16-1-7.
 */

public class PM25Recorder {

    private final static float TARGET = 100.f;

    private String mActual;
    private String mResult;
    private int mResultColor;

    public void setActual(String actualValue) {
        float actual = Float.valueOf(actualValue);
        mActual = String.valueOf(actual);

        // 1. Compare actual value to target value, calculate out result value.
        float result = actual / TARGET * 100.f;
        mResult = result + "%";

        // 2. Calculate out result color.
        mResultColor = Color.BLACK;
        if (result < 95f) {
            mResultColor = Color.RED;
        } else if (result > 110f) {
            mResultColor = Color.BLUE;
        }
    }
}
