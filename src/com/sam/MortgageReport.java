package com.sam;

import java.text.NumberFormat;

public class MortgageReport {
    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);

        Main.printTitle("MORTGAGE");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
    public void printPaymentSchedule() {
        Main.printTitle("PAYMENT SCHEDULE");

        for (double balance : calculator.getRemainingBalance()) {
            System.out.println(currency.format(balance));
        }
    }
}
