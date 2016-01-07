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

    private OnActualChnagedListener mActualChnagedListener;
    private OnResultChangedListener mResultChangedListener;
    private OnResultColorChangedListener mResultColorChangedListener;

    public void setActual(String actualValue) {
        float actual = Float.valueOf(actualValue);
        mActual = String.valueOf(actual);
        notifyActualChanged();

        // 1. Compare actual value to target value, calculate out result value.
        float result = actual / TARGET * 100.f;
        mResult = result + "%";
        notifyResultChanged();

        // 2. Calculate out result color.
        mResultColor = Color.BLACK;
        if (result < 95f) {
            mResultColor = Color.RED;
        } else if (result > 110f) {
            mResultColor = Color.BLUE;
        }
        notifyResultColorChanged();
    }

    public void registerOnActualChangedListener(OnActualChnagedListener listener) {
        mActualChnagedListener = listener;
    }

    private void notifyActualChanged() {
        if (mActualChnagedListener != null)
            mActualChnagedListener.onActualChanged(mActual);
    }

    public void registerOnResultChangedListener(OnResultChangedListener listener) {
        mResultChangedListener = listener;
    }

    private void notifyResultChanged() {
        if (mResultChangedListener != null)
            mResultChangedListener.onResultChanged(mResult);
    }

    public void registerOnResultColorChangedListener(OnResultColorChangedListener listener) {
        mResultColorChangedListener = listener;
    }

    private void notifyResultColorChanged() {
        if (mResultColorChangedListener != null)
            mResultColorChangedListener.onResultColorChanged(mResultColor);
    }

    public interface OnActualChnagedListener {
        void onActualChanged(String actual);
    }

    public interface OnResultChangedListener {
        void onResultChanged(String result);
    }

    public interface OnResultColorChangedListener {
        void onResultColorChanged(int resultColor);
    }
}
