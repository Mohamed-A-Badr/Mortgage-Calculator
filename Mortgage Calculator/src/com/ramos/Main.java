package com.ramos;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner input = new Scanner(System.in);
        System.out.print("Principle: ");
        int principal = input.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualRate = input.nextFloat();
        float monthRate = (annualRate / PERCENT) / MONTH_IN_YEAR;

        System.out.print("Period (Years): ");
        float periodYear = input.nextFloat();
        float periodMonth = periodYear * MONTH_IN_YEAR;

        double mortgageResult = principal
                * ((monthRate * Math.pow(1 + monthRate, periodMonth)
                / (Math.pow(1 + monthRate, periodMonth) - 1)));
        String Mortgage = NumberFormat.getCurrencyInstance().format(mortgageResult);
        System.out.println("Mortgage: " + Mortgage);
    }
}
