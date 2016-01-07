package com.quest.modelviewpresenter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by ningyi on 2016/1/8.
 */
public class ActualTextView extends EditText implements PM25Recorder.OnActualChnagedListener {

    public ActualTextView(Context context) {
        super(context);
    }

    public ActualTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ActualTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ActualTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void onActualChanged(String actual) {
        setText(actual);
    }
}
