package com.quest.modelviewpresenter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private TextView mTarget;
    private TextView mResult;
    private TextView mActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find the three view objects, assign the field.
        mTarget = (TextView) findViewById(R.id.targetValueView);
        mResult = (TextView) findViewById(R.id.resultValueView);
        mActual = (TextView) findViewById(R.id.actualValueView);

        // Register the edit event observer to actual text view.
        mActual.setOnEditorActionListener(this);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // Text changed, user enters a new actual value
        if (event != null) {
            try {
                // 1. Get actual value
                String actualValue = v.getText().toString();
                float actual = Float.valueOf(actualValue);

                // 2. Get target value
                String targetValue = mTarget.getText().toString();
                float target = Float.valueOf(targetValue);

                // 3. Compare actual value to target value, calculate out result value
                //    then update the TextView
                float result = actual / target * 100.f;
                String resultValue = result + "%";
                mResult.setText(resultValue);

                // 4. Calculate out result color and update the TextView
                int resultColor = Color.BLACK;
                if (result < 95f) {
                    resultColor = Color.RED;
                } else if (result > 110f) {
                    resultColor = Color.BLUE;
                }
                mResult.setTextColor(resultColor);

                return true;
            } catch (NumberFormatException e) {
                v.setText(null);

                return false;
            }
        }
        return false;
    }
}
