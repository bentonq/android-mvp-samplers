package com.quest.modelviewpresenter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ningyi on 2016/1/8.
 */
public class ResultTextView extends TextView implements
        PM25Recorder.OnResultChangedListener, PM25Recorder.OnResultColorChangedListener {

    public ResultTextView(Context context) {
        super(context);
    }

    public ResultTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ResultTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ResultTextView(Context context, AttributeSet attrs, int defStyleAttr,
            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onResultChanged(String result) {
        setText(result);
    }

    @Override
    public void onResultColorChanged(int resultColor) {
        setTextColor(resultColor);
    }
}
