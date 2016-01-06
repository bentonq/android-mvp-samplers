package com.quest.modelviewpresenter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView targetValueView = (TextView) findViewById(R.id.targetValueView);
        final TextView resultValueView = (TextView) findViewById(R.id.resultValueView);

        EditText actualEditer = (EditText) findViewById(R.id.actualValueView);
        actualEditer.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (event != null) {
                    try {
                        String actualValue = v.getText().toString();
                        float actual = Float.valueOf(actualValue);

                        String targetValue = targetValueView.getText().toString();
                        float target = Float.valueOf(targetValue);

                        float result = (float) actual / target * 100;
                        String resultValue = result + "%";
                        resultValueView.setText(resultValue);

                        int resultColor = Color.BLACK;
                        if (result < 95f) {
                            resultColor = Color.RED;
                        } else if (result > 110f) {
                            resultColor = Color.BLUE;
                        }
                        resultValueView.setTextColor(resultColor);

                        return true;
                    } catch (NumberFormatException e) {
                        v.setText(null);
                        return false;
                    }
                }
                return false;
            }
        });
    }
}
