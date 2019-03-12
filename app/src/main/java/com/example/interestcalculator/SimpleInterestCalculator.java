package com.example.interestcalculator;

import android.util.Log;

public class SimpleInterestCalculator implements  InterestCalculatorInterface {

    private static final String TAG = SimpleInterestCalculator.class.getSimpleName();

    /**
     *
     * @param amount
     * @param years
     * @param rate
     * @return calculated interest
     */
    @Override
    public double calculateInterest(double amount, double years, double rate) {
        Log.d(TAG, "Amount: "+String.valueOf(amount));
        Log.d(TAG, "Years: "+ String.valueOf(years));
        Log.d(TAG, "Rate Of Interest: " + String.valueOf(rate));
        double simpleInterest = 0;
        try {
            simpleInterest = (amount * years * rate) / 100;
        } catch (ArithmeticException ex) {
            Log.e("Exception::", ex.getMessage());
        }
        Log.d("Simple Interest", String.valueOf(simpleInterest));
        return simpleInterest;
    }
}
