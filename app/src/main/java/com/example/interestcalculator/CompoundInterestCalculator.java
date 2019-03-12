package com.example.interestcalculator;

import android.util.Log;

public class CompoundInterestCalculator implements InterestCalculatorInterface {

    private static final String TAG = CompoundInterestCalculator.class.getSimpleName();

    /**
     *
     * @param amount
     * @param years
     * @param rate
     * @return calculated compound interst
     */
    @Override
    public double calculateInterest(double amount, double years, double rate) {
        Log.d(TAG , "Amount: " +String.valueOf(amount));
        Log.d(TAG,"Years: "+ String.valueOf(years));
        Log.d(TAG,"Rate Of Interest: "+ String.valueOf(rate));
        double compoundInterest = 0;
        try {
            compoundInterest =  amount *
                    (Math.pow((1 + rate / 100), years));
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        Log.d("Compound Interest", String.valueOf(compoundInterest));
        return compoundInterest;
    }
}
