package com.example.vinaymavi.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.logging.Logger;

/**
 * Created by vinaymavi on 24/01/16.
 */
public class CalculatorActivity extends Activity implements View.OnClickListener {
    private EditText editText1;
    private EditText editText2;
    private TextView result;
    private final String TAG = "calculator";

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.calculator_layout);
        getterControls();
        setupButtons();
    }

    /**
     * Get EditText references.
     */
    private void getterControls() {
        editText1 = (EditText) this.findViewById(R.id.editText1);
        editText2 = (EditText) this.findViewById(R.id.editText2);
        result = (TextView) this.findViewById(R.id.result);
    }

    private void setupButtons() {
        Button b = (Button) this.findViewById(R.id.plusButton);
        b.setOnClickListener(this);
        b = (Button) this.findViewById(R.id.minusButton);
        b.setOnClickListener(this);
        b = (Button) this.findViewById(R.id.mulButton);
        b.setOnClickListener(this);
        b = (Button) this.findViewById(R.id.divideButton);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String text1 = editText1.getText().toString();
        String text2 = editText2.getText().toString();
        double num1 = getDouble(text1);
        double num2 = getDouble(text2);
        if (b.getId() == R.id.plusButton) {
            result.setText("Result = " + Double.toString(num1 + num2));
            Log.v(TAG, "Result = " + Double.toString(num1 + num2));
        }
        if (b.getId() == R.id.minusButton) {
            result.setText("Result = " + Double.toString(num1 - num2));
            Log.v(TAG, "Result = " + Double.toString(num1 - num2));
        }
        if (b.getId() == R.id.mulButton) {
            result.setText("Result = " + Double.toString(num1 * num2));
            Log.v(TAG, "Result = " + Double.toString(num1 * num2));
        }
        if (b.getId() == R.id.divideButton) {
            result.setText("Result = " + Double.toString(num1 / num2));
            Log.v(TAG, "Result = " + Double.toString(num1 / num2));
        }
    }

    private double getDouble(String s) {
        if (validString(s)) {
            return Double.parseDouble(s);
        }
        return 0;
    }

    private boolean invalidString(String s) {
        return !validString(s);
    }

    private boolean validString(String s) {
        if (s == null) {
            return false;
        }
        if (s.trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }
}
