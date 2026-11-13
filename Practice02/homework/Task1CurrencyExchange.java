package semester1.practice02.homework;

import java.util.Locale;

public class Task1CurrencyExchange {
    public static void main(String[] args) {
        double usdAmount = 250.0;
        final double EXCHANGE_RATE = 41.25;
        final double COMMISSION_PERCENT = 1.5;

        double totalUah = usdAmount * EXCHANGE_RATE;
        double commission = totalUah * COMMISSION_PERCENT / 100;
        double netAmount = totalUah - commission;
        long cashAmount = Math.round(netAmount);

        System.out.println("================ КВИТАНЦІЯ ОБМІНУ ================");
        System.out.println("Сума до обміну:             " + String.format(Locale.US, "%.2f", usdAmount) + " USD");
        System.out.println("Курс валют:                 " + EXCHANGE_RATE + " UAH/USD");
        System.out.println("Нараховано до комісії:      " + String.format(Locale.US, "%.2f", totalUah) + " UAH");
        System.out.println("Комісія банку (" + COMMISSION_PERCENT + "%):       " + String.format(Locale.US, "%.2f", commission) + " UAH");
        System.out.println("--------------------------------------------------");
        System.out.println("Чиста сума до видачі:       " + String.format(Locale.US, "%.2f", netAmount) + " UAH");
        System.out.println("До видачі готівкою:         " + cashAmount + " UAH");
        System.out.println("==================================================");
    }
}
