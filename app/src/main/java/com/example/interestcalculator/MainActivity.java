package com.example.interestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    EditText tfAmount ,tfYear ,tfInterest ,tfRoI ;
    Button btnSimpelInterest,btnCompoundInterest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void calculateInterest(View view )
    {
        if (view.getId() == R.id.btnSimpleInterest) {
            calculateSI();
        } else if (view.getId() == R.id.btnCompoundInterest) {
            calculateCI();
        }
    }

    private void calculateSI() {
        String amount = tfAmount.getText().toString();
        String year = tfYear.getText().toString();
        String rate = tfRoI.getText().toString();
        if (validateEmptyFields(amount, year , rate)) {
            DecimalFormat format = new DecimalFormat("##.##");
            SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator();
            Double simpleInterest = simpleInterestCalculator.calculateInterest(Double.parseDouble(amount) ,Double.parseDouble(year) ,Double.parseDouble(rate));
            tfInterest.setText(format.format(simpleInterest).toString());
        }
    }
    private void calculateCI() {
        String amount = tfAmount.getText().toString();
        String year = tfYear.getText().toString();
        String rate = tfRoI.getText().toString();
        if (validateEmptyFields(amount, year , rate)) {
            DecimalFormat format = new DecimalFormat("##.##");
            CompoundInterestCalculator compoundInterestCalculator = new CompoundInterestCalculator();
            Double compoundInterest =compoundInterestCalculator.calculateInterest(Double.parseDouble(amount) ,Double.parseDouble(year) ,Double.parseDouble(rate));
            tfInterest.setText(format.format(compoundInterest).toString());

        }
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnSimpleInterest) {
                calculateSI();
            } else if (view.getId() == R.id.btnCompoundInterest) {
                calculateCI();
            }
        }
    };

    private void initComponents() {
//        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.rl);
//        View v = getLayoutInflater().inflate(R.layout.activity_main, mainLayout, false);
        tfAmount = (EditText) findViewById(R.id.etAmount);
        tfYear = (EditText) findViewById(R.id.etYears);
        tfInterest = (EditText) findViewById(R.id.etInterest);
        tfRoI = (EditText) findViewById(R.id.etRate);
        btnSimpelInterest = (Button)findViewById(R.id.btnSimpleInterest);
        btnCompoundInterest = (Button)findViewById(R.id.btnCompoundInterest);
        btnSimpelInterest.setOnClickListener(listener);
        btnCompoundInterest.setOnClickListener(listener);
//        calculateInterest(v);
    }

    private boolean validateEmptyFields(String amount, String year, String rate) {
        if (TextUtils.isEmpty(amount)) {
            Toast.makeText(getApplicationContext(), "Please Enter Amount", Toast.LENGTH_SHORT).show();
            tfAmount.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(year)) {
            Toast.makeText(getApplicationContext(), "Please Enter No. Of Years",  Toast.LENGTH_SHORT).show();
            tfYear.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(rate)) {
            Toast.makeText(getApplicationContext(), "Please Enter Rate Of Interest",  Toast.LENGTH_SHORT).show();
            tfRoI.requestFocus();
            return false;
        }
        return true;
    }
}

