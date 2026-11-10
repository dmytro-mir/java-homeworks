import java.util.Scanner;

public class Practice04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Завдання 1
        {
            for (int i = 0; i < 7; i++) {
                System.out.println("Java - надійна та кросплатформна мова!");
            }
        }

        // Завдання 2
        {
            System.out.print("Введіть текст: ");
            String text = scanner.nextLine();
            System.out.print("Скільки разів (N): ");
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.println("[" + i + "] " + text);
            }
        }

        // Завдання 3
        {
            int balance = 0;
            for (int month = 1; month <= 12; month++) {
                balance += 500;
                System.out.println("Місяць " + month + ": " + balance + " грн");
            }
        }

        // Завдання 4
        {
            System.out.print("Курс євро: ");
            double rate = scanner.nextDouble();
            for (int euro = 10; euro <= 100; euro += 10) {
                System.out.println(euro + " EUR = " + (euro * rate) + " грн");
            }
        }

        // Завдання 5
        {
            System.out.print("Ширина рамки: ");
            int w = scanner.nextInt();
            for (int i = 0; i < w; i++) {
                System.out.print("=");
            }
            System.out.println();
        }

        // Завдання 6
        {
            int i = 10;
            while (i >= 1) {
                System.out.println(i);
                i--;
            }
            System.out.println("Поїхали! Ракета запущена!");
        }

        // Завдання 7
        {
            int sum = 0;
            System.out.print("Введіть число (0 - кінець): ");
            int number = scanner.nextInt();
            while (number != 0) {
                sum += number;
                System.out.print("Введіть число (0 - кінець): ");
                number = scanner.nextInt();
            }
            System.out.println("Сума: " + sum);
        }

        // Завдання 8
        {
            System.out.print("M: ");
            int m = scanner.nextInt();
            int power = 1;
            while (power <= m) {
                System.out.print(power + " ");
                power *= 2;
            }
            System.out.println();
        }

        // Завдання 9
        {
            System.out.print("Число N: ");
            int n = scanner.nextInt();
            int count = 0;
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                count++;
                n /= 10;
            }
            System.out.println("Кількість цифр: " + count);
            System.out.println("Сума цифр: " + sum);
        }

        // Завдання 10
        {
            System.out.print("Число: ");
            int n = scanner.nextInt();
            int reversed = 0;
            while (n > 0) {
                reversed = reversed * 10 + n % 10;
                n /= 10;
            }
            System.out.println("Реверс: " + reversed);
        }

        // Завдання 11
        {
            System.out.print("Сума S: ");
            double s = scanner.nextDouble();
            System.out.print("Ставка P (%): ");
            double p = scanner.nextDouble();
            double current = s;
            int years = 0;
            while (current < s * 2) {
                current = current * (1 + p / 100);
                years++;
            }
            System.out.println("Сума подвоїться через " + years + " років");
        }

        // Завдання 12
        {
            System.out.print("Число N (> 1): ");
            int n = scanner.nextInt();
            int divisor = 2;
            while (n % divisor != 0) {
                divisor++;
            }
            System.out.println("Найменший дільник: " + divisor);
        }

        // Завдання 13
        {
            int secret = (int) (Math.random() * 100) + 1;
            int attempts = 0;
            int guess = 0;
            while (guess != secret) {
                System.out.print("Ваша здогадка (1-100): ");
                guess = scanner.nextInt();
                attempts++;
                if (guess < secret) {
                    System.out.println("Більше!");
                } else if (guess > secret) {
                    System.out.println("Менше!");
                }
            }
            System.out.println("Вгадали за " + attempts + " спроб");
        }

        // Завдання 14
        {
            int choice;
            do {
                System.out.println("1. Розпочати нову гру");
                System.out.println("2. Завантажити збереження");
                System.out.println("3. Налаштування");
                System.out.println("0. Вихід");
                System.out.print("Ваш вибір: ");
                choice = scanner.nextInt();
                if (choice == 1) {
                    System.out.println("Нова гра розпочата");
                } else if (choice == 2) {
                    System.out.println("Збереження завантажено");
                } else if (choice == 3) {
                    System.out.println("Налаштування");
                } else if (choice != 0) {
                    System.out.println("Невідомий пункт");
                }
            } while (choice != 0);
        }

        // Завдання 15
        {
            int age;
            do {
                System.out.print("Введіть вік (1-120): ");
                age = scanner.nextInt();
            } while (age < 1 || age > 120);
            System.out.println("Вік підтверджено: " + age);
        }

        // Завдання 16
        {
            int attempts = 0;
            int pin;
            do {
                System.out.print("Введіть PIN: ");
                pin = scanner.nextInt();
                attempts++;
            } while (pin != 1234 && attempts < 3);
            if (pin == 1234) {
                System.out.println("Доступ надано");
            } else {
                System.out.println("Карту заблоковано!");
            }
        }

        // Завдання 17
        {
            char answer;
            do {
                System.out.print("Число a: ");
                int a = scanner.nextInt();
                System.out.print("Число b: ");
                int b = scanner.nextInt();
                System.out.println("Сума: " + (a + b));
                System.out.print("Бажаєте продовжити? (y/n): ");
                answer = scanner.next().charAt(0);
            } while (answer == 'y');
        }

        // Завдання 18
        {
            int die1;
            int die2;
            int attempts = 0;
            do {
                die1 = (int) (Math.random() * 6) + 1;
                die2 = (int) (Math.random() * 6) + 1;
                attempts++;
                System.out.println("Кидок " + attempts + ": " + die1 + " і " + die2);
            } while (die1 != die2);
            System.out.println("Дубль випав за " + attempts + " спроб");
        }

        // Завдання 19
        {
            System.out.print("Чисельник: ");
            int numerator = scanner.nextInt();
            int denominator;
            do {
                System.out.print("Знаменник (не 0): ");
                denominator = scanner.nextInt();
            } while (denominator == 0);
            System.out.println("Результат: " + ((double) numerator / denominator));
        }

        // Завдання 20
        {
            int sum = 0;
            int count = 0;
            int score;
            do {
                System.out.print("Бал (0-100, від'ємне - кінець): ");
                score = scanner.nextInt();
                if (score > 100) {
                    System.out.println("Некоректний бал, ще раз");
                } else if (score >= 0) {
                    sum += score;
                    count++;
                }
            } while (score >= 0);
            if (count > 0) {
                System.out.println("Середній бал: " + ((double) sum / count));
            } else {
                System.out.println("Балів не введено");
            }
        }

        // Завдання 21
        {
            System.out.print("A: ");
            int a = scanner.nextInt();
            System.out.print("B: ");
            int b = scanner.nextInt();
            for (int i = a; i <= b; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }

        // Завдання 22
        {
            System.out.print("N (0-20): ");
            int n = scanner.nextInt();
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println(n + "! = " + factorial);
        }

        // Завдання 23
        {
            System.out.println("Число | Квадрат | Куб");
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + "\t|\t" + (i * i) + "\t|\t" + (i * i * i));
            }
        }

        // Завдання 24
        {
            for (int i = 1; i <= 50; i++) {
                if (i % 3 == 0 || i % 5 == 0) {
                    continue;
                }
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // Завдання 25
        {
            for (int i = 100; i <= 200; i++) {
                if (i % 13 == 0 && i % 7 == 0) {
                    System.out.println("Перше число: " + i);
                    break;
                }
            }
        }

        // Завдання 26
        {
            for (char c = 'A'; c <= 'Z'; c++) {
                System.out.println(c + " = " + (int) c);
            }
        }

        // Завдання 27
        {
            System.out.print("N: ");
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 1) {
                    sum += i;
                } else {
                    sum -= i;
                }
            }
            System.out.println("S = " + sum);
        }

        // Завдання 28
        {
            System.out.print("Перший член a1: ");
            double a1 = scanner.nextDouble();
            System.out.print("Різниця d: ");
            double d = scanner.nextDouble();
            System.out.print("Кількість n: ");
            int n = scanner.nextInt();
            double term = a1;
            double sum = 0;
            for (int i = 1; i <= n; i++) {
                System.out.print(term + " ");
                sum += term;
                term += d;
            }
            System.out.println();
            System.out.println("Сума: " + sum);
        }

        // Завдання 29
        {
            byte b = 125;
            for (int i = 1; i <= 6; i++) {
                b = (byte) (b + 1);
                System.out.println(b);
            }
            // Після 127 відбувається переповнення byte і значення переходить у -128
        }

        // Завдання 30
        {
            System.out.print("Скільки чисел: ");
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                System.out.print("Число " + i + ": ");
                sum += scanner.nextInt();
            }
            System.out.println("Без приведення: " + (sum / n));
            System.out.println("З приведенням: " + ((double) sum / n));
        }

        // Завдання 31
        {
            scanner.nextLine();
            System.out.print("Введіть слово з 5 символів: ");
            String word = scanner.nextLine();
            String encrypted = "";
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                encrypted = encrypted + (char) (ch + 1);
            }
            System.out.println("Зашифровано: " + encrypted);
        }

        // Завдання 32
        {
            double p1 = 19.99, p2 = 45.50, p3 = 12.10, p4 = 99.95, p5 = 3.40;
            int whole = (int) p1 + (int) p2 + (int) p3 + (int) p4 + (int) p5;
            double pennies = (p1 + p2 + p3 + p4 + p5) - whole;
            System.out.println("Сума цілих гривень: " + whole);
            System.out.println("Сума копійок: " + pennies);
        }

        // Завдання 33
        {
            for (int i = 1; i <= 50; i++) {
                int percent = (int) (((double) i / 50) * 100);
                System.out.println("Завантажено: " + percent + "%");
            }
        }

        // Завдання 34
        {
            long bigNumber = 3_000_000_000L;
            int small = (int) bigNumber;
            System.out.println(bigNumber);
            System.out.println(small);
            // Число більше за максимум int (2147483647), тому відкинулись старші біти
            // і вийшло від'ємне значення.
        }

        // Завдання 35
        {
            for (double d = 0.0; d <= 1.0; d += 0.1) {
                System.out.println(d);
            }
            System.out.println("Через int-лічильник:");
            for (int i = 0; i <= 10; i++) {
                double val = i / 10.0;
                System.out.println(val);
            }
            // double не зберігає 0.1 точно, похибка накопичується, тому краще брати int
        }

        // Завдання 36
        {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.print(i * j + "\t");
                }
                System.out.println();
            }
        }

        // Завдання 37
        {
            System.out.print("Висота H: ");
            int h = scanner.nextInt();
            System.out.print("Ширина W: ");
            int w = scanner.nextInt();
            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (i == 1 || i == h || j == 1 || j == w) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }

        // Завдання 38
        {
            System.out.print("Висота N: ");
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

        // Завдання 39
        {
            System.out.print("N: ");
            int n = scanner.nextInt();
            for (int number = 2; number <= n; number++) {
                boolean isPrime = true;
                for (int d = 2; d < number; d++) {
                    if (number % d == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    System.out.print(number + " ");
                }
            }
            System.out.println();
        }

        // Завдання 40
        {
            System.out.print("Розмір дошки N: ");
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i + j) % 2 == 0) {
                        System.out.print("# ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
