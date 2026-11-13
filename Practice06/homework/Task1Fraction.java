package semester1.practice06.homework;

import java.util.Locale;

public class Task1Fraction {
    public static void main(String[] args) {
        System.out.println("=== КАЛЬКУЛЯТОР ЗВИЧАЙНИХ ДРОБІВ ===");

        Fraction f1 = new Fraction();
        f1.setValues(8, 12);
        System.out.print("Дріб 1: ");
        f1.printFraction();
        System.out.println();

        f1.simplify();
        System.out.print("Після скорочення: ");
        f1.printFraction();
        System.out.println(" (десятковий вигляд: " + String.format(Locale.US, "%.4f", f1.toDecimal()) + ")");
        System.out.println();

        int otherNum = 3;
        int otherDen = 4;
        int a = f1.getNumerator();
        int b = f1.getDenominator();
        System.out.println("Додаємо дріб " + otherNum + "/" + otherDen + " до " + a + "/" + b + "...");
        System.out.println("Формула: " + a + "/" + b + " + " + otherNum + "/" + otherDen
                + " = (" + a + "*" + otherDen + " + " + otherNum + "*" + b + ") / (" + b + "*" + otherDen + ") = "
                + (a * otherDen + otherNum * b) + "/" + (b * otherDen));
        f1.add(otherNum, otherDen);
        System.out.print("Результат додавання: ");
        f1.printFraction();
        System.out.println(" (десятковий вигляд: " + String.format(Locale.US, "%.4f", f1.toDecimal()) + ")");
        System.out.println();

        Fraction f2 = new Fraction();
        f2.setValues(5, -10);
        System.out.print("Дріб 2 (5/-10): ");
        f2.printFraction();
        f2.simplify();
        System.out.print(" -> після скорочення: ");
        f2.printFraction();
        System.out.println();

        f2.add(1, 2);
        System.out.print("-1/2 + 1/2 = ");
        f2.printFraction();
        System.out.println();

        Fraction f3 = new Fraction();
        f3.setValues(7, 0);
        System.out.print("Дріб 3 (7/0): ");
        f3.printFraction();
        System.out.println();
        System.out.println("=====================================");
    }
}

class Fraction {
    private int numerator;
    private int denominator = 1;

    public void setValues(int num, int den) {
        if (den == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            den = 1;
        }
        if (den < 0) {
            num = -num;
            den = -den;
        }
        numerator = num;
        denominator = den;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void simplify() {
        int g = gcd(numerator, denominator);
        if (g != 0) {
            numerator /= g;
            denominator /= g;
        }
    }

    public double toDecimal() {
        return (double) numerator / denominator;
    }

    public void add(int otherNum, int otherDen) {
        if (otherDen == 0) {
            System.out.println("Помилка: знаменник не може дорівнювати 0!");
            return;
        }
        int newNum = numerator * otherDen + otherNum * denominator;
        int newDen = denominator * otherDen;
        setValues(newNum, newDen);
        simplify();
    }

    public void printFraction() {
        if (denominator == 1) {
            System.out.print(numerator);
        } else {
            System.out.print(numerator + "/" + denominator);
        }
    }
}
