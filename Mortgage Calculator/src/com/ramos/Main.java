package com.ramos;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float annualInterest = 0, monthlyInterest = 0;
        byte year = 0;
        short numberOfPayment = 0;

        Scanner in = new Scanner(System.in);

        while(true){
            System.out.print("Principal: ");
            principal = in.nextInt();
            if(principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000.");
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            annualInterest = in.nextFloat();
            if(annualInterest >= 1 && annualInterest <= 30) {
                monthlyInterest = (annualInterest / PERCENT) / MONTH_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        while (true) {
            System.out.print("Period (years): ");
            year = in.nextByte();
            if(year >= 1 && year <= 30) {
                numberOfPayment = (short) (year * MONTH_IN_YEAR);
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        double mortgage = principal
                * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1)));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
