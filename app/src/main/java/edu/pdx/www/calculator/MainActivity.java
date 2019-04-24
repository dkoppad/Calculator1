package edu.pdx.www.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalculatorActivity";

    private TextView result;
    private EditText op1, op2;
    private Button plus, minus, pct, mult, div, sqrt;

    float output;
    double sqrt_output;
    private double num1, num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView)findViewById(R.id.textView_result);
        //ResultLabel = (TextView)findViewById(R.id.textView_ResultLabel);
        op1 = (EditText) findViewById(R.id.editText_op1);
        op2 = (EditText)findViewById(R.id.editText_op2);
        plus = (Button)findViewById(R.id.button_op_plus);
        minus = (Button)findViewById(R.id.button_op_minus);
        pct = (Button)findViewById(R.id.button_op_pct);
        mult = (Button)findViewById(R.id.button_op_mult);
        div = (Button)findViewById(R.id.button_op_div);
        sqrt = (Button)findViewById(R.id.button_op_sqrt);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                if (!isValidInput(true,true)){
                    Toast.makeText(MainActivity.this,
                            "Input Error: operand missing",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                }
                else {
                    num1 = Double.valueOf(op1.getText().toString());
                    num2 = Double.valueOf(op2.getText().toString());
                    output = (float)(num1 + num2);
                    result.setText(String.valueOf(output));
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!isValidInput(true,true)){
                    Toast.makeText(MainActivity.this,
                            "Input Error: operand missing",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                }
                else {
                    num1 = Double.valueOf(op1.getText().toString());
                    num2 = Double.valueOf(op2.getText().toString());
                    output = (float)(num1 - num2);
                    result.setText(String.valueOf(output));
                }
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidInput(true,true)){
                    Toast.makeText(MainActivity.this,
                            "Input Error: operand missing",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                }
                else {
                    num1 = Double.valueOf(op1.getText().toString());
                    num2 = Double.valueOf(op2.getText().toString());
                    output = (float)(num1 * num2);

                    result.setText(String.valueOf(output));
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidInput(true,true)){
                    Toast.makeText(MainActivity.this,
                            "Input Error: operand missing",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                }
                else {
                    num1 = Double.valueOf(op1.getText().toString());
                    num2 = Double.valueOf(op2.getText().toString());
                    if (num2 == 0) {
                        Toast.makeText(MainActivity.this,
                                "Input Error: Cannot divide by Zero",
                                Toast.LENGTH_SHORT).show();
                    }
                    else {
                        output = (float) (num1 / num2);
                        result.setText(String.valueOf(output));
                    }
                }

            }
        });

        pct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidInput(true,false)){
                    Toast.makeText(MainActivity.this,
                            "Input Error: operand missing",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                }
                else {
                    num1 = Double.valueOf(op1.getText().toString());

                    output = (float)(num1 / 100);
                    result.setText(String.valueOf(output));
                }
            }
        });

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidInput(true,false)){
                    Toast.makeText(MainActivity.this,
                            "Input Error: operand missing",
                            Toast.LENGTH_SHORT).show();
                    clear_input();
                }
                else {
                    num1 = Double.valueOf(op1.getText().toString());
                    sqrt_output = Math.sqrt(num1);
                    result.setText(String.valueOf(sqrt_output));
                }
            }
        });

    }

    @Override public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }


    @Override public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
    private void clear_input() {
        op1.setText("");
        op2.setText("");
    }
    private boolean isValidInput(boolean NeedA, boolean NeedB) {
        boolean result = true;
        String OperandA = op1.getText().toString();
        String OperandB = op2.getText().toString();

        if (NeedA) {
            if ((OperandA.length() == 0)) {
                result = false;
            }
            else if (OperandA == "."){
                result = false;
            }
            else {
                result = true;
            }
        }
         if (NeedB) {
             if ((OperandB.length()==0)){
                 result = false;
             }
             else if (OperandB == "."){
                 result = false;
             }
             else {
                 result = true;
             }
         }
        return result;
    }

}

