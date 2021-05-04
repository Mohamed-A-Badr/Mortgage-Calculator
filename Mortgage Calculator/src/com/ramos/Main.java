package com.ramos;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int principal = (int) readNumber("Principal", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Anuual Interest", 1, 30);
        byte year = (byte) readNumber("Period (year)", 1, 30);

        double mortgage = calculateMortage(principal, annualInterest, year);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max){
        Scanner in = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt + ": ");
            value = in.nextFloat();
            if(value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max +".");
        }
        return value;
    }

    public static double calculateMortage (int principal, float annualInterest, byte years) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = (annualInterest / PERCENT) / MONTH_IN_YEAR;
        short numberOfPayment = (short) (years * MONTH_IN_YEAR);

        double mortgage = principal
                * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1)));

        return mortgage;
    }


}
