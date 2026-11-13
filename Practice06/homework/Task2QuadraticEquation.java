package semester1.practice06.homework;

import java.util.Locale;

public class Task2QuadraticEquation {
    public static void main(String[] args) {
        System.out.println("=== РОЗВ'ЯЗУВАЧ КВАДРАТНИХ РІВНЯНЬ ===");

        QuadraticEquation eq1 = new QuadraticEquation();
        eq1.setCoefficients(1, -5, 6);
        System.out.println("Тест 1:");
        eq1.printSolution();
        System.out.println("--------------------------------------");

        QuadraticEquation eq2 = new QuadraticEquation();
        eq2.setCoefficients(1, -4, 4);
        System.out.println("Тест 2:");
        eq2.printSolution();
        System.out.println("--------------------------------------");

        QuadraticEquation eq3 = new QuadraticEquation();
        eq3.setCoefficients(1, 2, 5);
        System.out.println("Тест 3:");
        eq3.printSolution();
        System.out.println("======================================");
    }
}

class QuadraticEquation {
    private double a = 1.0;
    private double b;
    private double c;

    public void setCoefficients(double a, double b, double c) {
        if (a == 0) {
            System.out.println("Увага: коефіцієнт 'a' не може дорівнювати 0 (це лінійне рівняння)!");
            a = 1.0;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public boolean hasRealRoots() {
        return getDiscriminant() >= 0;
    }

    public double getRoot1() {
        double d = getDiscriminant();
        if (d < 0) {
            return Double.NaN;
        }
        return (-b + Math.sqrt(d)) / (2 * a);
    }

    public double getRoot2() {
        double d = getDiscriminant();
        if (d < 0) {
            return Double.NaN;
        }
        return (-b - Math.sqrt(d)) / (2 * a);
    }

    private String coef(double value) {
        if (value < 0) {
            return "(" + value + ")";
        }
        return String.valueOf(value);
    }

    public void printSolution() {
        double d = getDiscriminant();
        System.out.println("Рівняння: " + coef(a) + "*x^2 + " + coef(b) + "*x + " + coef(c) + " = 0");
        System.out.println("Дискримінант D = " + String.format(Locale.US, "%.2f", d));

        if (d > 0) {
            System.out.println("Рівняння має 2 дійсні корені:");
            System.out.println("  x1 = " + String.format(Locale.US, "%.2f", getRoot1()));
            System.out.println("  x2 = " + String.format(Locale.US, "%.2f", getRoot2()));
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println("Рівняння має один дійсний корінь:");
            System.out.println("  x = " + String.format(Locale.US, "%.2f", x));
        } else {
            System.out.println("Рівняння не має дійсних коренів у множині R.");
        }
    }
}
