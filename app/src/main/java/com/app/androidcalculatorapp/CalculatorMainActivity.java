package com.app.androidcalculatorapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.calculatorlogiclibrary.Calculate;

public class CalculatorMainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etInput1, etInput2, etResult;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnSin, btnCos, btnTan, btnClr;
    Calculate calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);

        calc = new Calculate();
        etInput1 = findViewById(R.id.etInput1);
        etInput2 = findViewById(R.id.etInput2);
        etResult = findViewById(R.id.etResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(this);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(this);
        btnDivide = findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(this);
        btnSin = findViewById(R.id.btnSin);
        btnSin.setOnClickListener(this);
        btnCos = findViewById(R.id.btnCos);
        btnCos.setOnClickListener(this);
        btnTan = findViewById(R.id.btnTan);
        btnTan.setOnClickListener(this);
        btnClr = findViewById(R.id.btnClr);
        btnClr.setOnClickListener(this);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom())
                hideKeyboard(this);
        }
        return super.dispatchTouchEvent(ev);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnAdd:
                if((etInput1.getText() != null && etInput1.getText().length() > 0) &&
                        (etInput2.getText() != null && etInput2.getText().length() > 0)){
                    etResult.setText(calc.add(Double.parseDouble(etInput1.getText().toString()),
                            Double.parseDouble(etInput2.getText().toString())));
                }
                else{
                    Toast.makeText(this, "Input Two Values", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnSubtract:
                if((etInput1.getText() != null && etInput1.getText().length() > 0) &&
                        (etInput2.getText() != null && etInput2.getText().length() > 0)){
                    etResult.setText(calc.subtract(Double.parseDouble(etInput1.getText().toString()),
                            Double.parseDouble(etInput2.getText().toString())));
                }
                else{
                    Toast.makeText(this, "Input Two Values", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnMultiply:
                if((etInput1.getText() != null && etInput1.getText().length() > 0) &&
                        (etInput2.getText() != null && etInput2.getText().length() > 0)){
                    etResult.setText(calc.multiply(Double.parseDouble(etInput1.getText().toString()),
                            Double.parseDouble(etInput2.getText().toString())));
                }
                else{
                    Toast.makeText(this, "Input Two Values", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnDivide:
                if((etInput1.getText() != null && etInput1.getText().length() > 0) &&
                        (etInput2.getText() != null && etInput2.getText().length() > 0)){
                    if(Double.parseDouble(etInput2.getText().toString()) != 0.0)
                        etResult.setText(calc.divide(Double.parseDouble(etInput1.getText().toString()),
                            Double.parseDouble(etInput2.getText().toString())));
                    else
                        Toast.makeText(this, "Divide By Zero Error", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "Input Two Values", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnSin:
                if((etInput1.getText() != null && etInput1.getText().length() > 0)){
                    etResult.setText(calc.sine(Double.parseDouble(etInput1.getText().toString())));
                }
                else{
                    Toast.makeText(this, "Enter Value(Degree)", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnCos:
                if((etInput1.getText() != null && etInput1.getText().length() > 0)){
                    etResult.setText(calc.cos(Double.parseDouble(etInput1.getText().toString())));
                }
                else{
                    Toast.makeText(this, "Enter Value(Degree)", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnTan:
                if((etInput1.getText() != null && etInput1.getText().length() > 0)){
                    etResult.setText(calc.tan(Double.parseDouble(etInput1.getText().toString())));
                }
                else{
                    Toast.makeText(this, "Enter Value(Degree)", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnClr:
                etInput1.setText("");
                etInput2.setText("");
                etResult.setText("");
                break;
        }
    }
}
