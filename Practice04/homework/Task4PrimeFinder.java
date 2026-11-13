package semester1.practice04.homework;

import java.util.Locale;
import java.util.Scanner;

public class Task4PrimeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ДЕТЕКТОР ПРОСТИХ ЧИСЕЛ ===");
        int n;
        do {
            System.out.print("Введіть верхню межу N: ");
            n = scanner.nextInt();
            if (n < 2) {
                System.out.println("Помилка: N має бути не меншим за 2!");
            }
        } while (n < 2);

        System.out.println();
        System.out.println("Знайдені прості числа у проміжку від 2 до " + n + ":");

        int primeCount = 0;
        long primeSum = 0;
        for (int number = 2; number <= n; number++) {
            boolean isPrime = true;
            for (int d = 2; d <= Math.sqrt(number); d++) {
                if (number % d == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                if (primeCount > 0) {
                    System.out.print(", ");
                }
                System.out.print(number);
                primeCount++;
                primeSum += number;
            }
        }
        System.out.println();

        int totalNumbers = n - 1;
        double percent = (double) primeCount / totalNumbers * 100;

        System.out.println();
        System.out.println("--- СТАТИСТИКА ---");
        System.out.println("Усього чисел у діапазоні:    " + totalNumbers);
        System.out.println("Знайдено простих чисел:      " + primeCount + " шт.");
        System.out.println("Сума всіх простих чисел:     " + primeSum);
        System.out.println("Частка простих чисел:        " + String.format(Locale.US, "%.2f", percent) + "%");
        System.out.println("==============================");

        scanner.close();
    }
}
