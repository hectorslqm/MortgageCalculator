package com.sam;

public class MortgageCalculator {
    private final static byte PERCENT = 100;
    private final static byte MONTHS_IN_YEAR = 12;

    private float principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(float principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double[] getRemainingBalance() {
        double[] balances = new double[getNumberOfPayments()];

        for (short month = 1; month <= getNumberOfPayments(); month++)
            balances[month-1] = calculateBalance(month);
        return balances;
    }

    private double calculateBalance(int numberOfPaymentsMade) {
        //B Loan Balance
        //L Loan a mount or principal
        //c monthly interest
        //n number of payments
        //p payments we have made
        //B= L[(1+c)^n-(1+c)^p]/[((1+c)^n)-1]
        return principal
                * ((Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - Math.pow(1 + getMonthlyInterest(), numberOfPaymentsMade))
                / ((Math.pow(1 + getMonthlyInterest(), getNumberOfPayments())) - 1));
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    private float getMonthlyInterest() {
        return annualInterest / MONTHS_IN_YEAR / PERCENT;
    }
}
