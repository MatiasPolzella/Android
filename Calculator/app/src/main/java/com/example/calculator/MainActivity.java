package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2 ,btn3, btn4 ,btn5, btn6, btn7, btn8, btn9, btnPercent, btnPlus, btnMinus, btnMultiply, btnDivision,
            btnEqual, btnClear, btnDot, btnBracket;
    TextView input, output;
    String process;
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btnZero);
        btn1 = findViewById(R.id.btnOne);
        btn2 = findViewById(R.id.btnTwo);
        btn3 = findViewById(R.id.btnThree);
        btn4 = findViewById(R.id.btnFour);
        btn5 = findViewById(R.id.btnFive);
        btn6 = findViewById(R.id.btnSix);
        btn7 = findViewById(R.id.btnSeven);
        btn8 = findViewById(R.id.btnEight);
        btn9 = findViewById(R.id.btnNine);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnPercent= findViewById(R.id.btnPercent);
        btnBracket = findViewById(R.id.btnBracket);

        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        btnClear.setOnClickListener(v -> {
            input.setText("");
            output.setText("");
        });

        btn0.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "0");
        });
        btn1.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "1");
        });
        btn2.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "2");
        });
        btn3.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "3");
        });
        btn4.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "4");
        });
        btn5.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "5");
        });
        btn6.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "6");
        });
        btn7.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "7");
        });
        btn8.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "8");
        });
        btn9.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "9");
        });
        btnPlus.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "+");
        });
        btn0.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "0");
        });
        btnMinus.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "-");
        });
        btnMultiply.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "x");
        });
        btnDivision.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "÷");
        });
        btnDot.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + ".");
        });
        btnPercent.setOnClickListener(v -> {
            process = input.getText().toString();
            input.setText(process + "%");
        });
        btnBracket.setOnClickListener(v -> {
            if(checkBracket){
                process = input.getText().toString();
                input.setText(process + ")");
                checkBracket = false;
            } else {
                process = input.getText().toString();
                input.setText(process + "(");
                checkBracket = true;
            }
        });

        btnEqual.setOnClickListener(v -> {
               process = input.getText().toString();

               process = process.replaceAll("x", "*");
               process = process.replaceAll("%","/100");
               process = process.replaceAll("÷","/");

            Context rhino = Context.enter();
            rhino.setOptimizationLevel(-1);

            String finalResult = "";

            try {
                Scriptable scriptable = rhino.initSafeStandardObjects();
                finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
            } catch (Exception e){
                finalResult = "0";
            }

            output.setText(finalResult);
        });
    }
}