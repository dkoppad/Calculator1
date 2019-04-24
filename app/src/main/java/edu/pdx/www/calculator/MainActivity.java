/*
 * @author Dhakshayini Koppad (dkoppad@pdx.edu), 2019
 *
 * * * This is a mini calculator app which performs the following mathematical operations
 * * Addition, Subtraction, Multipy, Division, Percentage of a no. and Square root.
 * * The app also few toast messages when any one of the operand is missing or
 * * any invalid input is entered.
 * */

package edu.pdx.www.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        // function to calculate the add of two numbers
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidInput(true, true)){
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

        // function to calculate the subtract of two numbers
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

        // function to calculate the Multipy of two numbers
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

        // function to calculate the division of two numbers

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

        // function to calculate the % of a number

        pct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidInput(true,false)){         // operand a should be valid
                    Toast.makeText(MainActivity.this,            // and operand B is optional
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

        // function to calculate the Square root of a number

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isValidInput(true,false)){         // operand a should be valid
                    Toast.makeText(MainActivity.this,           // and operand B is optional
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

    // Override the Activity lifecycle callbacks for logging

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

    /** * Clears the input text edit boxes */

    private void clear_input() {
        op1.setText("");
        op2.setText("");
    }

    //Checks if the required input strings are valid.
    //The caller passes in parameters * to specify which values to check.

    // NeedA is true if the calculation needs a valid OperandA String
    // NeedB is true if the calculation needs a valid Operandb String

    private boolean isValidInput(boolean NeedA, boolean NeedB) {
        boolean result = true;
        String OperandA = op1.getText().toString();
        String OperandB = op2.getText().toString();

        result = isValidDot();                      // Checks if the input is not a "."

        if ((NeedA) && (OperandA.length() == 0)) {     // Checks if Operand A is valid

                result = false;
        }
        if ((NeedB )&&(OperandB.length() == 0)) {       // Checks if Operand A is valid
                result = false;
        }
        return result;
    }

    // Function to check if ".", to pop up toast msg for both operands
    //
    private boolean isValidDot() {
        boolean result_dot = true;
        String OpA = op1.getText().toString();
        String OpB = op2.getText().toString();

            if ((OpA.equals("."))||(OpB.equals("."))) {
                result_dot = false;
            }
        return result_dot;
    }

}

