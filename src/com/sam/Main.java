package com.sam;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        float principal = (float) readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println();
        printTitle("MORTGAGE");
        System.out.println("Monthly Payments: " + mortgageFormatted);

        System.out.println();
        printTitle("PAYMENT SCHEDULE");
        double[] payments = calculatePayments(principal, annualInterest, years);
        for (double payment: payments){
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(payment);
            System.out.println(balanceFormatted);
        }
    }
    public static void printTitle(String prompt){
        System.out.println(prompt.toUpperCase());
        System.out.println("_".repeat(prompt.length()));
    }

    public static double[] calculatePayments(float principal, float annualInterest, byte years) {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);
        double[] payments = new double[numberOfPayments];
        //B Loan Balance
        //L Loan ammount or principal
        //c monthly interest
        //n number of payments
        //p payments we have made
        //B= L[(1+c)^n-(1+c)^p]/[((1+c)^n)-1]
        for(int paymentIndex = 0 ; paymentIndex < payments.length; paymentIndex++) {
            int numberOfPaymentsMade = paymentIndex+1;
            payments[paymentIndex] = principal
                    * ((Math.pow(1+monthlyInterest,numberOfPayments) - Math.pow(1+monthlyInterest,numberOfPaymentsMade))
                    / ((Math.pow(1+monthlyInterest,numberOfPayments)) - 1));
        }
        return payments;
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max ) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(float principal, float annualInterest, byte years) {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        return principal
                * (monthlyInterest * Math.pow(1+monthlyInterest,numberOfPayments)
                / (Math.pow(1+monthlyInterest,numberOfPayments) - 1));
    }
}
