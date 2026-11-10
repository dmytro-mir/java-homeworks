import java.util.Scanner;

public class Practice03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Завдання 1
        {
            System.out.print("Ім'я: ");
            String firstName = scanner.nextLine();
            System.out.print("Прізвище: ");
            String lastName = scanner.nextLine();
            System.out.print("Вік: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Місто: ");
            String city = scanner.nextLine();
            System.out.println("=== ВХІДНІ ДАНІ ===");
            System.out.println("Ім'я: " + firstName);
            System.out.println("Прізвище: " + lastName);
            System.out.println("Вік: " + age);
            System.out.println("Місто: " + city);
            System.out.println("-------------------");
            System.out.println("Привіт, " + firstName + " " + lastName + " з міста " + city + "! Твій вік: " + age + " р.");
        }

        // Завдання 2
        {
            System.out.print("Введіть перше число: ");
            int a = scanner.nextInt();
            System.out.print("Введіть друге число: ");
            int b = scanner.nextInt();
            System.out.println("Сума: " + (a + b));
            System.out.println("Різниця: " + (a - b));
            System.out.println("Добуток: " + (a * b));
            System.out.println("Остача від ділення: " + (a % b));
        }

        // Завдання 3
        {
            System.out.print("Введіть суму в гривнях (UAH): ");
            double uah = scanner.nextDouble();
            System.out.print("Введіть курс USD: ");
            double rate = scanner.nextDouble();
            double usd = uah / rate;
            System.out.printf("Сума до видачі: %.2f USD\n", usd);
        }

        // Завдання 4
        {
            System.out.print("Введіть номер квитка: ");
            int ticket = scanner.nextInt();
            scanner.nextLine(); // очищаємо буфер від залишкового \n
            System.out.print("Введіть повне ім'я студента: ");
            String fullName = scanner.nextLine();
            System.out.print("Введіть спеціальність: ");
            String speciality = scanner.nextLine();
            System.out.println("Студент: " + fullName + ", квиток №" + ticket + ", спеціальність: " + speciality);
        }

        // Завдання 5
        {
            System.out.print("Ваш зріст (м): ");
            double height = scanner.nextDouble();
            System.out.print("Ваша вага (кг): ");
            double weight = scanner.nextDouble();
            double bmi = weight / (height * height);
            System.out.printf("Розрахований BMI: %.2f\n", bmi);
        }

        // Завдання 6
        {
            System.out.print("Введіть символ: ");
            char ch = scanner.next().charAt(0);
            System.out.println("Символ: " + ch + " | Код символу: " + (int) ch);
        }

        // Завдання 7
        {
            System.out.print("Катет A: ");
            double a = scanner.nextDouble();
            System.out.print("Катет B: ");
            double b = scanner.nextDouble();
            double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
            System.out.println("Гіпотенуза: " + c);
            System.out.println("Периметр: " + (a + b + c));
            System.out.println("Площа: " + (a * b / 2));
        }

        // Завдання 8
        {
            scanner.nextLine();
            System.out.print("Товар: ");
            String product = scanner.nextLine();
            System.out.print("Ціна: ");
            double price = scanner.nextDouble();
            System.out.print("Кількість: ");
            int quantity = scanner.nextInt();
            double total = price * quantity;
            double vat = total * 0.2;
            System.out.println("Товар: " + product);
            System.out.println("Загальна сума: " + total + " грн (з них ПДВ 20%: " + vat + " грн)");
        }

        // Завдання 9
        {
            System.out.print("Введіть число: ");
            int n = scanner.nextInt();
            if (n > 0) {
                System.out.println("Число додатне.");
            } else if (n < 0) {
                System.out.println("Число від'ємне.");
            } else {
                System.out.println("Число дорівнює нулю.");
            }
        }

        // Завдання 10
        {
            System.out.print("Введіть число: ");
            int number = scanner.nextInt();
            if (number == 0) {
                System.out.println("Число є нулем");
            } else if (number % 2 == 0) {
                System.out.println("Число " + number + " є парним.");
            } else {
                System.out.println("Число " + number + " є непарним.");
            }
        }

        // Завдання 11
        {
            System.out.print("Введіть вік: ");
            int age = scanner.nextInt();
            if (age < 0 || age > 120) {
                System.out.println("Некоректний вік");
            } else if (age <= 12) {
                System.out.println("Дитина");
            } else if (age <= 17) {
                System.out.println("Підліток");
            } else if (age <= 64) {
                System.out.println("Дорослий");
            } else {
                System.out.println("Пенсіонер");
            }
        }

        // Завдання 12
        {
            System.out.print("Введіть бал (0-100): ");
            int score = scanner.nextInt();
            if (score < 0 || score > 100) {
                System.out.println("Помилка: некоректний бал!");
            } else if (score >= 90) {
                System.out.println("Відмінно (A)");
            } else if (score >= 82) {
                System.out.println("Дуже добре (B)");
            } else if (score >= 74) {
                System.out.println("Добре (C)");
            } else if (score >= 64) {
                System.out.println("Задовільно (D)");
            } else if (score >= 60) {
                System.out.println("Достатньо (E)");
            } else {
                System.out.println("Незадовільно (F)");
            }
        }

        // Завдання 13
        {
            System.out.print("Введіть 3 числа: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int max = a;
            if (b > max) {
                max = b;
            }
            if (c > max) {
                max = c;
            }
            int min = a;
            if (b < min) {
                min = b;
            }
            if (c < min) {
                min = c;
            }
            System.out.println("Максимум: " + max);
            System.out.println("Мінімум: " + min);
        }

        // Завдання 14
        {
            System.out.print("Введіть X: ");
            double x = scanner.nextDouble();
            System.out.print("Введіть Y: ");
            double y = scanner.nextDouble();
            if (x == 0 && y == 0) {
                System.out.println("Точка в початку координат.");
            } else if (x == 0 || y == 0) {
                System.out.println("Точка лежить на осі координат.");
            } else if (x > 0 && y > 0) {
                System.out.println("Точка (" + x + "; " + y + ") знаходиться у I чверті.");
            } else if (x < 0 && y > 0) {
                System.out.println("Точка (" + x + "; " + y + ") знаходиться у II чверті.");
            } else if (x < 0 && y < 0) {
                System.out.println("Точка (" + x + "; " + y + ") знаходиться у III чверті.");
            } else {
                System.out.println("Точка (" + x + "; " + y + ") знаходиться у IV чверті.");
            }
        }

        // Завдання 15
        {
            int x = 5;
            int y = 20;
            // Без дужок else прив'язується до найближчого if (y > 10), а не до if (x > 10):
            // if (x > 10)
            //     if (y > 10)
            //         System.out.println("x > 10 та y > 10");
            // else
            //     System.out.println("else");

            // З дужками else належить зовнішньому if:
            if (x > 10) {
                if (y > 10) {
                    System.out.println("x > 10 та y > 10");
                }
            } else {
                System.out.println("x не більше 10");
            }
        }

        // Завдання 16
        {
            System.out.print("Спожито (кВт·год): ");
            int kwh = scanner.nextInt();
            double sum;
            if (kwh <= 100) {
                sum = kwh * 2.64;
            } else {
                sum = 100 * 2.64 + (kwh - 100) * 4.32;
            }
            System.out.println("Сума до сплати: " + sum + " грн");
        }

        // Завдання 17
        {
            System.out.print("x: ");
            int x = scanner.nextInt();
            System.out.print("y: ");
            int y = scanner.nextInt();
            int max = (x > y) ? x : y;
            System.out.println("Більше число: " + max);
        }

        // Завдання 18
        {
            System.out.print("n: ");
            int n = scanner.nextInt();
            int abs = (n < 0) ? -n : n;
            System.out.println("Модуль: " + abs);
        }

        // Завдання 19
        {
            System.out.print("Число: ");
            int number = scanner.nextInt();
            String result = (number % 2 == 0) ? "Парне" : "Непарне";
            System.out.println(result);
        }

        // Завдання 20
        {
            System.out.print("Введіть бал: ");
            int score = scanner.nextInt();
            System.out.println("Результат: " + (score >= 60 ? "Зараховано" : "Незараховано"));
        }

        // Завдання 21
        {
            System.out.print("n: ");
            int n = scanner.nextInt();
            String status = (n > 0) ? "Додатне" : (n < 0) ? "Від'ємне" : "Нуль";
            System.out.println(status);
        }

        // Завдання 22
        {
            System.out.print("Сума покупки: ");
            double sum = scanner.nextDouble();
            double finalSum = (sum > 1000) ? sum * 0.9 : sum * 0.98;
            System.out.println("До сплати зі знижкою: " + finalSum + " грн");
        }

        // Завдання 23
        {
            System.out.print("Ділене a: ");
            int a = scanner.nextInt();
            System.out.print("Дільник b: ");
            int b = scanner.nextInt();
            String result = (b != 0) ? "Результат: " + ((double) a / b) : "Помилка: ділення на нуль неможливе!";
            System.out.println(result);
        }

        // Завдання 24
        {
            System.out.print("Кількість помилок: ");
            int count = scanner.nextInt();
            String text = (count == 1) ? "Знайдено 1 помилку" : "Знайдено " + count + " помилок";
            System.out.println(text);
        }

        // Завдання 25
        {
            int x = 10;
            int divisor = 0;
            if (divisor != 0 && (x / divisor > 1)) {
                System.out.println("Успішне ділення");
            } else {
                System.out.println("Ділення безпечно пропущено завдяки short-circuit!");
            }
            // Оператор && лінивий: якщо ліворуч false, то праворуч не обчислюється,
            // тому ділення на нуль не виконується і помилки немає.
        }

        // Завдання 26
        {
            int counter1 = 0;
            int counter2 = 0;
            boolean b1 = false && (++counter1 > 0);
            boolean b2 = false & (++counter2 > 0);
            System.out.println("counter1 = " + counter1);
            System.out.println("counter2 = " + counter2);
            // && пропустив праву частину, тому counter1 = 0.
            // & завжди обчислює обидві частини, тому counter2 = 1.
        }

        // Завдання 27
        {
            int number = 5;
            if (number > 0 || (10 / 0 == 0)) {
                System.out.println("Умова виконана, аварійне ділення не викликалося!");
            }
            // Для || якщо ліва частина true, права вже не потрібна і не обчислюється.
        }

        // Завдання 28
        {
            int counterA = 0;
            int counterB = 0;
            boolean test1 = true || (++counterA > 0);
            boolean test2 = true | (++counterB > 0);
            System.out.println("counterA = " + counterA);
            System.out.println("counterB = " + counterB);
            // | не лінивий, тому обчислює праву частину завжди (counterB = 1).
        }

        // Завдання 29
        {
            System.out.print("Години (0-23): ");
            int hours = scanner.nextInt();
            System.out.print("Хвилини (0-59): ");
            int minutes = scanner.nextInt();
            boolean isValidTime = (hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59);
            if (isValidTime) {
                System.out.printf("%02d:%02d\n", hours, minutes);
            } else {
                System.out.println("Помилка: некоректний час!");
            }
        }

        // Завдання 30
        {
            System.out.print("Сторона a: ");
            double a = scanner.nextDouble();
            System.out.print("Сторона b: ");
            double b = scanner.nextDouble();
            System.out.print("Сторона c: ");
            double c = scanner.nextDouble();
            boolean exists = (a + b > c) && (a + c > b) && (b + c > a);
            System.out.println("Трикутник існує: " + exists);
        }

        // Завдання 31
        {
            System.out.print("n: ");
            int n = scanner.nextInt();
            boolean isEvenBitwise = (n & 1) == 0;
            boolean isEvenMod = n % 2 == 0;
            System.out.println("(n & 1) == 0: " + isEvenBitwise);
            System.out.println("n % 2 == 0: " + isEvenMod);
            // n & 1 залишає тільки останній біт числа: 0 - парне, 1 - непарне
        }

        // Завдання 32
        {
            boolean isPinCorrect = true;
            boolean isCardActive = true;
            double balance = 3000;
            double amount = 1000;
            boolean hasSufficientBalance = balance >= amount;
            boolean isDailyLimitExceeded = false;
            boolean allowed = isPinCorrect && isCardActive && hasSufficientBalance && !isDailyLimitExceeded;
            System.out.println("Транзакція дозволена: " + allowed);
        }

        // Завдання 33
        {
            System.out.print("Номер дня (1-7): ");
            int day = scanner.nextInt();
            switch (day) {
                case 1:
                    System.out.println("Понеділок");
                    break;
                case 2:
                    System.out.println("Вівторок");
                    break;
                case 3:
                    System.out.println("Середа");
                    break;
                case 4:
                    System.out.println("Четвер");
                    break;
                case 5:
                    System.out.println("П'ятниця");
                    break;
                case 6:
                    System.out.println("Субота");
                    break;
                case 7:
                    System.out.println("Неділя");
                    break;
                default:
                    System.out.println("Некоректний номер дня");
                    break;
            }
        }

        // Завдання 34
        {
            System.out.print("Номер дня (1-7): ");
            int day = scanner.nextInt();
            switch (day) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Будній (робочий) день");
                    break;
                case 6:
                case 7:
                    System.out.println("Вихідний день");
                    break;
                default:
                    System.out.println("Некоректний номер дня");
                    break;
            }
        }

        // Завдання 35
        {
            System.out.print("Номер місяця (1-12): ");
            int month = scanner.nextInt();
            int days = switch (month) {
                case 1, 3, 5, 7, 8, 10, 12 -> 31;
                case 4, 6, 9, 11 -> 30;
                case 2 -> 28;
                default -> 0;
            };
            if (days == 0) {
                System.out.println("Такого місяця не існує");
            } else {
                System.out.println("Днів у місяці: " + days);
            }
        }

        // Завдання 36
        {
            scanner.nextLine();
            System.out.print("Введіть місяць: ");
            String month = scanner.nextLine();
            String season = switch (month) {
                case "грудень", "січень", "лютий" -> "Зима";
                case "березень", "квітень", "травень" -> "Весна";
                case "червень", "липень", "серпень" -> "Літо";
                case "вересень", "жовтень", "листопад" -> "Осінь";
                default -> "Невідомий місяць";
            };
            System.out.println("Пора року: " + season);
        }

        // Завдання 37
        {
            System.out.print("Доставка (1 - Самовивіз, 2 - Кур'єр, 3 - Поштомат): ");
            int choice = scanner.nextInt();
            System.out.print("Вага товару (кг): ");
            double weight = scanner.nextDouble();
            int cost = switch (choice) {
                case 1 -> 0;
                case 2 -> {
                    if (weight > 5) {
                        yield 150;
                    } else {
                        yield 90;
                    }
                }
                case 3 -> 60;
                default -> -1;
            };
            System.out.println("Вартість доставки: " + cost + " грн");
        }

        // Завдання 38
        {
            System.out.print("Число 1: ");
            double a = scanner.nextDouble();
            System.out.print("Оберіть операцію (+, -, *, /): ");
            char op = scanner.next().charAt(0);
            System.out.print("Число 2: ");
            double b = scanner.nextDouble();
            String result = switch (op) {
                case '+' -> "" + (a + b);
                case '-' -> "" + (a - b);
                case '*' -> "" + (a * b);
                case '/' -> {
                    if (b == 0) {
                        yield "Помилка: ділення на нуль!";
                    } else {
                        yield "" + (a / b);
                    }
                }
                default -> "Невідома операція";
            };
            System.out.println("Результат: " + result);
        }

        // Завдання 39
        {
            scanner.nextLine();
            System.out.print("Введіть команду (start, pause, stop, exit): ");
            String command = scanner.nextLine();
            // command == "start" дасть false, бо == порівнює посилання на об'єкти,
            // а не текст. Рядок зі Scanner - це новий об'єкт, не той самий, що літерал.
            System.out.println(command == "start");
            System.out.println(command.equalsIgnoreCase("start"));
            switch (command.toLowerCase()) {
                case "start" -> System.out.println("Система успішно запущена!");
                case "pause" -> System.out.println("Систему призупинено.");
                case "stop" -> System.out.println("Систему зупинено.");
                case "exit" -> System.out.println("Вихід із програми.");
                default -> System.out.println("Невідома команда!");
            }
        }

        // Завдання 40
        {
            System.out.println("================ БАНКОМАТ ================");
            System.out.print("Введіть PIN: ");
            int pin = scanner.nextInt();
            if (pin == 1234) {
                System.out.println("Авторизація успішна!");
                double balance = 5000.0;
                System.out.print("Оберіть дію (1 - Баланс, 2 - Поповнення, 3 - Зняття, 4 - Вихід): ");
                int action = scanner.nextInt();
                switch (action) {
                    case 1 -> System.out.println("Баланс: " + balance + " грн");
                    case 2 -> {
                        System.out.print("Введіть суму поповнення: ");
                        double amount = scanner.nextDouble();
                        balance = balance + amount;
                        System.out.println("Баланс: " + balance + " грн");
                    }
                    case 3 -> {
                        System.out.print("Введіть суму зняття: ");
                        double amount = scanner.nextDouble();
                        double fee = (amount > 1000) ? amount * 0.01 : 0;
                        if (amount > 0 && amount + fee <= balance) {
                            balance = balance - amount - fee;
                            System.out.println("Комісія операції: " + fee + " грн");
                            System.out.println("Видано: " + amount + " грн. Залишок на рахунку: " + balance + " грн");
                        } else {
                            System.out.println("Недостатньо коштів або некоректна сума.");
                        }
                    }
                    case 4 -> System.out.println("Вихід.");
                    default -> System.out.println("Невідома дія.");
                }
            } else {
                System.out.println("Невірний PIN.");
            }
            System.out.println("==========================================");
        }

        scanner.close();
    }
}
