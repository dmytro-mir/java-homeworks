package semester1.practice06;

// головний клас
public class Practice06 {
    public static void main(String[] args) {

        // ===== Завдання 1 =====
        Student s1 = new Student();
        s1.name = "Денис"; s1.age = 19; s1.gpa = 4.75;
        System.out.println(s1.name + ", " + s1.age + ", " + s1.gpa);

        // ===== Завдання 2 =====
        Car c1 = new Car();
        c1.brand = "Toyota"; c1.model = "Camry"; c1.year = 2021; c1.speed = 180;
        Car c2 = new Car();
        c2.brand = "BMW"; c2.model = "M5"; c2.year = 2023; c2.speed = 250;
        System.out.println(c1.brand + " " + c1.model + " " + c1.year);
        System.out.println(c2.brand + " " + c2.model + " " + c2.year);
        System.out.println("Новіший: " + (c1.year > c2.year ? c1.brand : c2.brand));

        // ===== Завдання 3 =====
        Book eb = new Book();
        System.out.println("title=" + eb.title + ", author=" + eb.author + ", pages=" + eb.pages + ", isRead=" + eb.isRead);

        // ===== Завдання 4 =====
        Rectangle r = new Rectangle(); r.width = 7.5; r.height = 4.0;
        System.out.println("Площа: " + (r.width * r.height));
        System.out.println("Периметр: " + (2 * (r.width + r.height)));

        // ===== Завдання 5 =====
        Product p = new Product();
        p.name = "Монітор"; p.price = 6500.0; p.quantity = 8;
        System.out.println("Вартість партії: " + (p.price * p.quantity) + " грн");

        // ===== Завдання 6 =====
        Smartphone ph = new Smartphone();
        ph.model = "Samsung S23"; ph.batteryLevel = 100; ph.isTurnedOn = true;
        ph.batteryLevel -= 35;
        if (ph.batteryLevel <= 0) ph.isTurnedOn = false;
        System.out.println(ph.model + ", заряд: " + ph.batteryLevel + "%, увімкнено: " + ph.isTurnedOn);

        // ===== Завдання 7 =====
        Point2D A = new Point2D(); A.x = 0; A.y = 0;
        Point2D B = new Point2D(); B.x = 3; B.y = 4;
        double dist = Math.sqrt(Math.pow(B.x - A.x, 2) + Math.pow(B.y - A.y, 2));
        System.out.println("Відстань: " + dist);

        // ===== Завдання 8 =====
        Student first = new Student(); first.name = "Іван";
        Student second = first;
        second.name = "Петро";
        System.out.println("first.name = " + first.name);

        // ===== Завдання 9 =====
        Greeter g = new Greeter();
        g.sayHello(); g.sayHelloTo("Олена");

        // ===== Завдання 10 =====
        Animal cat = new Animal(); cat.species = "Кіт"; cat.name = "Мурчик";
        Animal dog = new Animal(); dog.species = "Пес"; dog.name = "Рекс";
        cat.makeSound(); cat.printInfo();
        dog.makeSound(); dog.printInfo();

        // ===== Завдання 11 =====
        Counter cnt = new Counter();
        cnt.increment(); cnt.increment(); cnt.increment(); cnt.decrement();
        cnt.printCount();

        // ===== Завдання 12 =====
        TrafficLight tl = new TrafficLight();
        tl.changeColor("Червоний"); tl.showSignal();
        tl.changeColor("Жовтий");   tl.showSignal();
        tl.changeColor("Зелений");  tl.showSignal();

        // ===== Завдання 13 =====
        Player pl = new Player(); pl.nickname = "Герой";
        pl.takeDamage(30);
        System.out.println("Здоров'я: " + pl.health);
        pl.heal(15);
        System.out.println("Після лікування: " + pl.health);
        pl.takeDamage(200); // смерть

        // ===== Завдання 14 =====
        Lamp lamp = new Lamp();
        lamp.turnOn(); lamp.status();
        lamp.toggle(); lamp.status();
        lamp.toggle(); lamp.status();

        // ===== Завдання 15 =====
        Stopwatch sw = new Stopwatch();
        sw.addSeconds(125); sw.displayTime();

        // ===== Завдання 16 =====
        Printer pr = new Printer(); pr.model = "HP LaserJet"; pr.paperCount = 5;
        pr.printDocument("Звіт", 3);
        pr.printDocument("Великий документ", 10);

        // ===== Завдання 17 =====
        SimpleCalculator sc = new SimpleCalculator();
        System.out.println("10+5=" + sc.add(10, 5));
        System.out.println("10-5=" + sc.subtract(10, 5));
        System.out.println("10*5=" + sc.multiply(10, 5));
        System.out.println("10/4=" + sc.divide(10, 4));
        System.out.println("10/0=" + sc.divide(10, 0));

        // ===== Завдання 18 =====
        Circle cir = new Circle(); cir.radius = 5.0;
        System.out.println("Площа: " + cir.getArea());
        System.out.println("Довжина: " + cir.getCircumference());

        // ===== Завдання 19 =====
        TemperatureConverter tconv = new TemperatureConverter();
        double f = tconv.celsiusToFahrenheit(25);
        System.out.println("25°C = " + f + "°F");
        System.out.println(f + "°F = " + tconv.fahrenheitToCelsius(f) + "°C");

        // ===== Завдання 20 =====
        NumberChecker nc = new NumberChecker();
        for (int n : new int[]{7, 12, -5}) {
            System.out.println(n + ": парне=" + nc.isEven(n) + ", додатнє=" + nc.isPositive(n) + ", просте=" + nc.isPrime(n));
        }

        // ===== Завдання 21 =====
        CurrencyExchange ce = new CurrencyExchange(); ce.usdRate = 41.5;
        System.out.printf("10000 грн = %.2f USD%n", ce.toUSD(10000));

        // ===== Завдання 22 =====
        Employee emp = new Employee();
        emp.name = "Олег"; emp.baseSalary = 30000; emp.bonusPercentage = 15;
        System.out.printf("Зарплата: %.2f грн%n", emp.calculateTotalSalary());
        System.out.printf("Податок: %.2f грн%n", emp.calculateTax());

        // ===== Завдання 23 =====
        TextFormatter tf = new TextFormatter();
        System.out.println(tf.formatTitle("Привіт"));
        System.out.println("Голосних у 'Програмування': " + tf.countVowels("Програмування"));

        // ===== Завдання 24 =====
        Triangle tri = new Triangle(); tri.a = 3; tri.b = 4; tri.c = 5;
        System.out.println("Валідний: " + tri.isValid());
        System.out.println("Периметр: " + tri.getPerimeter());
        System.out.println("Площа: " + tri.getArea());

        // ===== Завдання 25 =====
        SecretVault vault = new SecretVault();
        // vault.secretCode = "hacked"; // помилка компіляції: private access
        System.out.println("'Pass123': " + vault.verifyCode("Pass123"));
        System.out.println("'wrong':  " + vault.verifyCode("wrong"));

        // ===== Завдання 26 =====
        UserAccount ua = new UserAccount();
        ua.setCredentials("admin", "qwerty");
        System.out.println("login(admin/qwerty): " + ua.login("admin", "qwerty"));
        System.out.println("login(admin/wrong):  " + ua.login("admin", "wrong"));
        ua.changePassword("qwerty", "newpass");
        System.out.println("login(admin/newpass): " + ua.login("admin", "newpass"));

        // ===== Завдання 27 =====
        BankAccount acc = new BankAccount(); acc.setAccountNumber("UA123");
        acc.deposit(1000);
        System.out.println("Зняти 500: " + acc.withdraw(500));
        System.out.println("Зняти 1000: " + acc.withdraw(1000));
        System.out.println("Баланс: " + acc.getBalance());

        // ===== Завдання 28 =====
        Thermometer th = new Thermometer();
        th.setTemperature(25);
        System.out.println("t = " + th.getTemperature());
        th.setTemperature(-300);
        System.out.println("t = " + th.getTemperature());

        // ===== Завдання 29 =====
        CarSpeedometer sp = new CarSpeedometer();
        sp.accelerate(100); System.out.println("Швидкість: " + sp.getSpeed());
        sp.accelerate(200); System.out.println("Швидкість: " + sp.getSpeed());
        sp.brake(300);      System.out.println("Швидкість: " + sp.getSpeed());

        // ===== Завдання 30 =====
        Person per1 = new Person();
        per1.setName("Анна"); per1.setAge(25); per1.printSummary();
        Person per2 = new Person();
        per2.setName("Богдан"); per2.setAge(150); per2.printSummary();

        // ===== Завдання 31 =====
        DiscountCard dc = new DiscountCard();
        dc.setOwnerName("Марія");
        dc.addPurchase(3000); dc.printCardInfo();
        dc.addPurchase(4000); dc.printCardInfo();
        dc.addPurchase(4000); dc.printCardInfo();

        // ===== Завдання 32 =====
        SmartDoorLock lock = new SmartDoorLock();
        lock.enterPin(1111);
        lock.enterPin(2222);
        lock.enterPin(3333);
        lock.enterPin(1234);

        // ===== Завдання 33 =====
        GradeBook gb = new GradeBook();
        gb.setData("Денис", new int[]{85, 92, 78, 96, 65});
        System.out.printf("Середній: %.2f%n", gb.getAverage());
        System.out.println("Макс: " + gb.getHighestGrade());
        System.out.println("Мін:  " + gb.getLowestGrade());

        // ===== Завдання 34 =====
        ArrayStats stt = new ArrayStats();
        stt.setNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println("Парних: " + stt.countEvens());
        System.out.println("Непарних: " + stt.countOdds());
        System.out.println("Сума: " + stt.calculateSum());

        // ===== Завдання 35 =====
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(100); cart.addItem(250); cart.addItem(80);
        cart.printReceipt();
        cart.applyDiscount(15);
        System.out.println(">> Після знижки 15%:");
        cart.printReceipt();

        // ===== Завдання 36 =====
        TemperatureTracker tt = new TemperatureTracker();
        tt.setTemps(new double[]{20, 22, 25, 19, 28, 30, 24});
        System.out.println("Днів > 24°C: " + tt.countDaysAbove(24));
        tt.printWeeklyReport();

        // ===== Завдання 37 =====
        ArraySearcher as = new ArraySearcher();
        as.setData(new int[]{10, 20, 30, 40, 50});
        System.out.println("contains(30): " + as.contains(30));
        System.out.println("contains(99): " + as.contains(99));
        System.out.println("indexOf(30):  " + as.findIndex(30));
        System.out.println("indexOf(99):  " + as.findIndex(99));

        // ===== Завдання 38 =====
        Vector3D v = new Vector3D();
        v.setCoords(2, 3, 6);
        System.out.println("|v| = " + v.getMagnitude());
        v.multiplyByScalar(2);
        v.printVector();

        // ===== Завдання 39 =====
        Matrix2D m = new Matrix2D();
        m.setGrid(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        m.printMatrix();
        System.out.println("Загальна сума: " + m.getTotalSum());
        System.out.println("Сума рядка 1: " + m.getRowSum(1));

        // ===== Завдання 40 =====
        MatrixDiagonals md = new MatrixDiagonals();
        md.setMatrix(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        System.out.println("Головна: " + md.getMainDiagonalSum());
        System.out.println("Побічна: " + md.getAntiDiagonalSum());
        System.out.println("Симетричні: " + md.isDiagonalSymmetric());
    }
}

// класи завдань

class Student {
    public String name;
    public int age;
    public double gpa;
}

class Car {
    public String brand;
    public String model;
    public int year;
    public int speed;
}

class Book {
    public String title;
    public String author;
    public int pages;
    public boolean isRead;
}

class Rectangle {
    public double width;
    public double height;
}

class Product {
    public String name;
    public double price;
    public int quantity;
}

class Smartphone {
    public String model;
    public int batteryLevel;
    public boolean isTurnedOn;
}

class Point2D {
    public double x;
    public double y;
}

class Greeter {
    public void sayHello() {
        System.out.println("Привіт усім!");
    }
    public void sayHelloTo(String name) {
        System.out.println("Привіт, " + name + "! Раді тебе бачити.");
    }
}

class Animal {
    public String species;
    public String name;
    public void makeSound() { System.out.println(name + " видає звук!"); }
    public void printInfo() { System.out.println("Вид: " + species + ", кличка: " + name); }
}

class Counter {
    public int count;
    public void increment() { count++; }
    public void decrement() { count--; }
    public void reset()     { count = 0; }
    public void printCount(){ System.out.println("Лічильник: " + count); }
}

class TrafficLight {
    public String currentColor;
    public void changeColor(String newColor) { this.currentColor = newColor; }
    public void showSignal() {
        if ("Червоний".equals(currentColor)) System.out.println("Стій!");
        else if ("Жовтий".equals(currentColor)) System.out.println("Увага!");
        else if ("Зелений".equals(currentColor)) System.out.println("Їдь!");
        else System.out.println("Невідомий сигнал");
    }
}

class Player {
    public String nickname;
    public int health = 100;
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) { health = 0; System.out.println(nickname + " загинув!"); }
    }
    public void heal(int amount) {
        health += amount;
        if (health > 100) health = 100;
    }
}

class Lamp {
    public boolean isOn;
    public void turnOn()  { isOn = true;  }
    public void turnOff() { isOn = false; }
    public void toggle()  { isOn = !isOn; }
    public void status()  { System.out.println(isOn ? "Лампа світить" : "Лампа вимкнена"); }
}

class Stopwatch {
    public int seconds;
    public void tick()            { seconds++; }
    public void addSeconds(int s) { seconds += s; }
    public void displayTime() {
        int min = seconds / 60;
        int sec = seconds % 60;
        System.out.printf("%02d:%02d%n", min, sec);
    }
}

class Printer {
    public String model;
    public int paperCount;
    public void printDocument(String title, int pages) {
        if (paperCount >= pages) {
            paperCount -= pages;
            System.out.println("Надруковано: " + title + " (" + pages + " стор.). Залишилось паперу: " + paperCount);
        } else {
            System.out.println("Помилка: Недостатньо паперу в принтері " + model + "!");
        }
    }
}

class SimpleCalculator {
    public int add(int a, int b)      { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public double divide(int a, int b) {
        if (b == 0) { System.out.println("Помилка: ділення на нуль!"); return 0.0; }
        return (double) a / b;
    }
}

class Circle {
    public double radius;
    public double getArea()          { return Math.PI * radius * radius; }
    public double getCircumference() { return 2 * Math.PI * radius; }
}

class TemperatureConverter {
    public double celsiusToFahrenheit(double c) { return c * 1.8 + 32; }
    public double fahrenheitToCelsius(double f) { return (f - 32) / 1.8; }
}

class NumberChecker {
    public boolean isEven(int n)     { return n % 2 == 0; }
    public boolean isPositive(int n) { return n > 0; }
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

class CurrencyExchange {
    public double usdRate;
    public double toUSD(double uah) { return uah / usdRate; }
    public double toUAH(double usd) { return usd * usdRate; }
}

class Employee {
    public String name;
    public double baseSalary;
    public double bonusPercentage;
    public double calculateTotalSalary() { return baseSalary * (1 + bonusPercentage / 100); }
    public double calculateTax()         { return calculateTotalSalary() * 0.195; }
}

class TextFormatter {
    public String formatTitle(String text) {
        return "*** " + text.toUpperCase() + " ***";
    }
    public int countVowels(String text) {
        String vowels = "аоуеиіяюєїaeiouАОУЕИІЯЮЄЇAEIOU";
        int count = 0;
        for (char c : text.toCharArray()) {
            if (vowels.indexOf(c) >= 0) count++;
        }
        return count;
    }
}

class Triangle {
    public double a, b, c;
    public boolean isValid()     { return a + b > c && a + c > b && b + c > a; }
    public double getPerimeter() { return a + b + c; }
    public double getArea() {
        if (!isValid()) return 0.0;
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class SecretVault {
    private String secretCode = "Pass123";
    public boolean verifyCode(String attempt) { return secretCode.equals(attempt); }
}

class UserAccount {
    private String username;
    private String password;
    public void setCredentials(String u, String p) { this.username = u; this.password = p; }
    public boolean login(String enteredUser, String enteredPass) {
        return username != null && username.equals(enteredUser)
                && password != null && password.equals(enteredPass);
    }
    public void changePassword(String oldPass, String newPass) {
        if (oldPass != null && oldPass.equals(password)) {
            this.password = newPass;
            System.out.println("Пароль успішно змінено.");
        } else {
            System.out.println("Помилка: невірний старий пароль.");
        }
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;
    public void setAccountNumber(String acc) { this.accountNumber = acc; }
    public void deposit(double amount) {
        if (amount > 0) { balance += amount; System.out.println("Поповнено на " + amount + " грн. Баланс: " + balance); }
        else { System.out.println("Помилка: некоректна сума."); }
    }
    public boolean withdraw(double amount) {
        if (amount > balance) { System.out.println("Відмова: недостатньо коштів."); return false; }
        balance -= amount;
        System.out.println("Знято " + amount + " грн. Залишок: " + balance);
        return true;
    }
    public double getBalance() { return balance; }
}

class Thermometer {
    private double temperature;
    public void setTemperature(double t) {
        if (t < -273.15) System.out.println("Помилка: температура нижче абсолютного нуля.");
        else this.temperature = t;
    }
    public double getTemperature() { return temperature; }
}

class CarSpeedometer {
    private int speed = 0;
    public void accelerate(int delta) { speed += delta; if (speed > 240) speed = 240; }
    public void brake(int delta)      { speed -= delta; if (speed < 0)   speed = 0;   }
    public int getSpeed() { return speed; }
}

class Person {
    private String name;
    private int age;
    public void setName(String name) { this.name = name; }
    public void setAge(int age) {
        if (age >= 0 && age <= 120) this.age = age;
        else System.out.println("Помилка: вік " + age + " поза межами 0–120.");
    }
    public void printSummary() { System.out.println("Людина: " + name + ", вік: " + age); }
}

class DiscountCard {
    private String ownerName;
    private double totalSpent;
    private int discountPercent = 1;
    public void setOwnerName(String name) { this.ownerName = name; }
    public void addPurchase(double cost) {
        totalSpent += cost;
        if (totalSpent >= 10000)     discountPercent = 10;
        else if (totalSpent >= 5000) discountPercent = 5;
        else                         discountPercent = 1;
    }
    public void printCardInfo() {
        System.out.println("Власник: " + ownerName + " | Витрачено: " + totalSpent
                + " грн | Знижка: " + discountPercent + "%");
    }
}

class SmartDoorLock {
    private int pinCode = 1234;
    private boolean isLocked = true;
    private int failedAttempts = 0;
    public void enterPin(int enteredPin) {
        if (failedAttempts >= 3) { System.out.println("СИСТЕМА ЗАБЛОКОВАНА! Викличте охорону."); return; }
        if (enteredPin == pinCode) {
            isLocked = false; failedAttempts = 0;
            System.out.println("Замок відчинено.");
        } else {
            failedAttempts++;
            System.out.println("Невірний PIN. Спроба " + failedAttempts + "/3.");
        }
    }
}

class GradeBook {
    private String studentName;
    private int[] grades;
    public void setData(String name, int[] g) { this.studentName = name; this.grades = g; }
    public double getAverage() {
        if (grades == null || grades.length == 0) return 0.0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.length;
    }
    public int getHighestGrade() {
        if (grades == null || grades.length == 0) return 0;
        int max = grades[0];
        for (int g : grades) if (g > max) max = g;
        return max;
    }
    public int getLowestGrade() {
        if (grades == null || grades.length == 0) return 0;
        int min = grades[0];
        for (int g : grades) if (g < min) min = g;
        return min;
    }
}

class ArrayStats {
    private int[] numbers;
    public void setNumbers(int[] nums) { this.numbers = nums; }
    public int countEvens() {
        int c = 0; if (numbers == null) return 0;
        for (int n : numbers) if (n % 2 == 0) c++;
        return c;
    }
    public int countOdds() {
        int c = 0; if (numbers == null) return 0;
        for (int n : numbers) if (n % 2 != 0) c++;
        return c;
    }
    public int calculateSum() {
        int s = 0; if (numbers == null) return 0;
        for (int n : numbers) s += n;
        return s;
    }
}

class ShoppingCart {
    private double[] itemPrices = new double[10];
    private int count = 0;
    public void addItem(double price) {
        if (count < itemPrices.length) itemPrices[count++] = price;
        else System.out.println("Кошик заповнений!");
    }
    public double getTotalCost() {
        double total = 0;
        for (int i = 0; i < count; i++) total += itemPrices[i];
        return total;
    }
    public void applyDiscount(double percent) {
        for (int i = 0; i < count; i++) itemPrices[i] -= itemPrices[i] * percent / 100.0;
    }
    public void printReceipt() {
        System.out.println("--- Чек ---");
        for (int i = 0; i < count; i++) System.out.printf("Товар %d: %.2f грн%n", i + 1, itemPrices[i]);
        System.out.printf("Разом: %.2f грн%n", getTotalCost());
    }
}

class TemperatureTracker {
    private double[] dailyTemps;
    public void setTemps(double[] temps) { this.dailyTemps = temps; }
    public int countDaysAbove(double threshold) {
        int c = 0; if (dailyTemps == null) return 0;
        for (double t : dailyTemps) if (t > threshold) c++;
        return c;
    }
    public void printWeeklyReport() {
        if (dailyTemps == null) return;
        String[] days = {"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Нд"};
        int warmest = 0;
        System.out.println("--- Тижневий звіт ---");
        for (int i = 0; i < dailyTemps.length; i++) {
            System.out.printf("%s: %.1f°C%n", days[i], dailyTemps[i]);
            if (dailyTemps[i] > dailyTemps[warmest]) warmest = i;
        }
        System.out.println("Найтепліший день: " + days[warmest] + " (" + dailyTemps[warmest] + "°C)");
    }
}

class ArraySearcher {
    private int[] data;
    public void setData(int[] data) { this.data = data; }
    public boolean contains(int target) { return findIndex(target) != -1; }
    public int findIndex(int target) {
        if (data == null) return -1;
        for (int i = 0; i < data.length; i++) if (data[i] == target) return i;
        return -1;
    }
}

class Vector3D {
    private double[] coords = new double[3];
    public void setCoords(double x, double y, double z) {
        coords[0] = x; coords[1] = y; coords[2] = z;
    }
    public double getMagnitude() {
        return Math.sqrt(coords[0]*coords[0] + coords[1]*coords[1] + coords[2]*coords[2]);
    }
    public void multiplyByScalar(double scalar) {
        coords[0] *= scalar; coords[1] *= scalar; coords[2] *= scalar;
    }
    public void printVector() {
        System.out.printf("(%.1f, %.1f, %.1f)%n", coords[0], coords[1], coords[2]);
    }
}

class Matrix2D {
    private int[][] grid;
    public void setGrid(int[][] grid) { this.grid = grid; }
    public void printMatrix() {
        if (grid == null) return;
        for (int[] row : grid) {
            for (int val : row) System.out.printf("%4d", val);
            System.out.println();
        }
    }
    public int getTotalSum() {
        int sum = 0; if (grid == null) return 0;
        for (int[] row : grid) for (int val : row) sum += val;
        return sum;
    }
    public int getRowSum(int rowIndex) {
        if (grid == null || rowIndex < 0 || rowIndex >= grid.length) return 0;
        int sum = 0;
        for (int val : grid[rowIndex]) sum += val;
        return sum;
    }
}

class MatrixDiagonals {
    private int[][] matrix;
    public void setMatrix(int[][] matrix) { this.matrix = matrix; }
    public int getMainDiagonalSum() {
        if (matrix == null) return 0;
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) sum += matrix[i][i];
        return sum;
    }
    public int getAntiDiagonalSum() {
        if (matrix == null) return 0;
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) sum += matrix[i][n - 1 - i];
        return sum;
    }
    public boolean isDiagonalSymmetric() {
        return getMainDiagonalSum() == getAntiDiagonalSum();
    }
}