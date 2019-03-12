package com.example.interestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    /**
     * Holds amount edit text  view instance
     */
    private EditText mAmountView;
    /**
     * Holds no of years edit text  view instance
     */
    private EditText mNoOfYearsView;
    /**
     * Holds calculated interest edit text  view instance
     */
    private EditText mInterestView;
    /**
     * Holds rate of interest edit text  view instance
     */
    private EditText mRateOfInterestView;
    /**
     * Holds simple interest button view instance
     */
    private Button mSimpleInterestButton;
    /**
     * Holds compound interest button view instance
     */
    private Button mCompoundInterestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }


    /**
     * Simple Interest calculation
     */
    private void calculateSimpleInterest() {
        String amount = mAmountView.getText().toString();
        String year = mNoOfYearsView.getText().toString();
        String rate = mRateOfInterestView.getText().toString();
        if (viewValidation(amount, year, rate)) {
            DecimalFormat format = new DecimalFormat("##.##");
            SimpleInterestCalculator simpleInterestCalculator = new SimpleInterestCalculator();
            Double simpleInterest = simpleInterestCalculator.calculateInterest(Double.parseDouble(amount), Double.parseDouble(year), Double.parseDouble(rate));
            mInterestView.setText(format.format(simpleInterest).toString());
        }
    }

    /**
     * Compound Interest calculation
     */
    private void calculateCompoundInterest() {
        String amount = mAmountView.getText().toString();
        String year = mNoOfYearsView.getText().toString();
        String rate = mRateOfInterestView.getText().toString();
        if (viewValidation(amount, year, rate)) {
            DecimalFormat format = new DecimalFormat("##.##");
            CompoundInterestCalculator compoundInterestCalculator = new CompoundInterestCalculator();
            Double compoundInterest = compoundInterestCalculator.calculateInterest(
                    Double.parseDouble(amount), Double.parseDouble(year), Double.parseDouble(rate));
            mInterestView.setText(format.format(compoundInterest));

        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnSimpleInterest:
                    calculateSimpleInterest();
                    break;
                case R.id.btnCompoundInterest:
                    calculateCompoundInterest();
                    break;
            }
        }
    };

    /**
     * Initialise view components
     */
    private void initComponents() {
        mNoOfYearsView = (EditText) findViewById(R.id.etYears);
        mInterestView = (EditText) findViewById(R.id.etInterest);
        mRateOfInterestView = (EditText) findViewById(R.id.etRate);
        mSimpleInterestButton = (Button) findViewById(R.id.btnSimpleInterest);
        mCompoundInterestButton = (Button) findViewById(R.id.btnCompoundInterest);
        mSimpleInterestButton.setOnClickListener(listener);
        mCompoundInterestButton.setOnClickListener(listener);
    }

    /**
     * @param amount
     * @param year
     * @param rate
     * @return
     */
    private boolean viewValidation(String amount, String year, String rate) {
        if (TextUtils.isEmpty(amount)) {
            mAmountView.setError("Please Enter Amount");
            mAmountView.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(year)) {
            mNoOfYearsView.setError("Please Enter No. Of Years");
            mNoOfYearsView.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(rate)) {
            mRateOfInterestView.setError("Please Enter Rate Of Interest");
            mRateOfInterestView.requestFocus();
            return false;
        }
        return true;
    }
}