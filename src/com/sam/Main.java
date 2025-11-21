package com.sam;

public class Main {

    public static void main(String[] args) {
        float principal = (float) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);
        var calculator = new MortgageCalculator(principal, annualInterest, years);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

    public static void printTitle(String prompt){
        System.out.println();
        System.out.println(prompt.toUpperCase());
        System.out.println("_".repeat(prompt.length()));
    }

}
