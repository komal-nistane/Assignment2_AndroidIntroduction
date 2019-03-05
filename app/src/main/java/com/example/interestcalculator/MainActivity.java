package com.example.interestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tfAmount ,tfYear ,tfInterest ,tfRoI ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          tfAmount = (EditText) findViewById(R.id.etAmount);
          tfYear = (EditText) findViewById(R.id.etYears);
          tfInterest = (EditText) findViewById(R.id.etInterest);
          tfRoI = (EditText) findViewById(R.id.etRate);
        Button btnSimpelInterest = (Button)findViewById(R.id.btnSimpleInterest);
        Button btnCompoundInterest = (Button)findViewById(R.id.btnCompoundInterest);

        btnSimpelInterest.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           {
               String amount = tfAmount.getText().toString();
               String year = tfYear.getText().toString();
               String rate = tfRoI.getText().toString();
               if (validateEmptyFields(amount, year , rate)) {

                   SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator();
                   Double simpleInterest =simpleInterestCalculator.calculateInterest(Double.parseDouble(amount) ,Double.parseDouble(year) ,Double.parseDouble(rate));
                   tfInterest.setText(simpleInterest.toString());

               }
           }
       });
        btnCompoundInterest.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           {
               String amount = tfAmount.getText().toString();
               String year = tfYear.getText().toString();
               String rate = tfRoI.getText().toString();
               if (validateEmptyFields(amount, year , rate)) {

                   CompoundInterestCalculator compoundInterestCalculator = new CompoundInterestCalculator();
                   Double compoundInterest =compoundInterestCalculator.calculateInterest(Double.parseDouble(amount) ,Double.parseDouble(year) ,Double.parseDouble(rate));
                   tfInterest.setText(compoundInterest.toString());

               }

           }
       });


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

