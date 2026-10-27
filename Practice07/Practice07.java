package semester1.practice07;

// головний клас
public class Practice07 {
    public static void main(String[] args) {

        // ===== Завдання 1 =====
        Book b1 = new Book();
        Book b2 = new Book("Кобзар", "Тарас Шевченко", 1840, 350.0);
        Book b3 = new Book("Тест", "Хтось", -5, -10); // некоректні дані
        b1.printInfo();
        b2.printInfo();
        b3.printInfo();

        // ===== Завдання 2 =====
        Student st1 = new Student("Денис", 19, 4.8);
        Student st2 = new Student("Андрій", 10, 7.2);
        st1.printStudent();
        st2.printStudent();

        // ===== Завдання 3 =====
        BankAccount ba = new BankAccount("UA001", "Олена", 1500);
        ba.deposit(500);
        ba.printAccount();
        System.out.println("Зняти 5000: " + ba.withdraw(5000));
        System.out.println("Зняти 700: " + ba.withdraw(700));
        ba.printAccount();

        // ===== Завдання 4 =====
        Point2D p0 = new Point2D();
        Point2D p1 = new Point2D(3, 4);
        Point2D p2 = new Point2D(-1, 7);
        p0.printPoint(); p1.printPoint(); p2.printPoint();
        System.out.println("p1 до початку координат: " + p1.distanceToOrigin());
        System.out.printf("p1 -> p2: %.3f%n", p1.distanceTo(-1, 7));

        // ===== Завдання 5 =====
        Product pr = new Product("Навушники", 1200, 15, "Електроніка");
        pr.printProduct();
        pr.applyDiscount(20);
        System.out.println("Після знижки 20%:");
        pr.printProduct();

        // ===== Завдання 6 =====
        Time t = new Time(23, 59, 58);
        for (int i = 0; i < 3; i++) {
            System.out.println(t.toUniversalString() + "  |  " + t.toStandardString());
            t.tick();
        }
        Time bad = new Time(25, 70, -1);
        System.out.println("Некоректний час: " + bad.toUniversalString());

        // ===== Завдання 7 =====
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(4);
        Rectangle r3 = new Rectangle(3, 6);
        System.out.println("r1: S=" + r1.getArea() + ", P=" + r1.getPerimeter() + ", квадрат: " + r1.isSquare());
        System.out.println("r2: S=" + r2.getArea() + ", P=" + r2.getPerimeter() + ", квадрат: " + r2.isSquare());
        System.out.println("r3: S=" + r3.getArea() + ", P=" + r3.getPerimeter() + ", квадрат: " + r3.isSquare());
        System.out.println("Площа квадрата більша: " + (r2.getArea() > r3.getArea()));

        // ===== Завдання 8 =====
        Employee emp = new Employee(1, "Коваленко Олег", "Тестувальник", 28000);
        emp.printBadge();
        emp.raiseSalary(15);
        emp.printBadge();
        System.out.println("Річна зарплата: " + emp.getAnnualSalary());

        // ===== Завдання 9 =====
        User u1 = new User("admin", "admin@site.ua", "ADMIN", true);
        User u2 = new User("olena", "olena@gmail.com");
        User u3 = new User("max");
        User u4 = new User();
        u1.printProfile(); u2.printProfile(); u3.printProfile(); u4.printProfile();

        // ===== Завдання 10 =====
        Fraction f1 = new Fraction(6, -8);
        Fraction f2 = new Fraction(5);
        Fraction f3 = new Fraction();
        Fraction f4 = new Fraction(3, 0);
        f1.print(); f2.print(); f3.print(); f4.print();
        System.out.println("6/-8 = " + f1.toDouble());

        // ===== Завдання 11 =====
        Car car = new Car("Skoda", "Octavia", 2024);
        car.drive(150);
        car.startEngine();
        car.drive(150);
        car.stopEngine();
        car.printInfo();
        new Car().printInfo();

        // ===== Завдання 12 =====
        SmartBulb sb1 = new SmartBulb(120, 1000, false);
        SmartBulb sb2 = new SmartBulb(75);
        SmartBulb sb3 = new SmartBulb();
        sb1.printStatus(); sb2.printStatus(); sb3.printStatus();

        // ===== Завдання 13 =====
        String sql = new QueryBuilder("users").select("id, name, email").where("age >= 18").build();
        System.out.println(sql);
        System.out.println(new QueryBuilder("orders").build());

        // ===== Завдання 14 =====
        new CoffeeOrder("Лате", "Large", 2, true).printReceipt();
        new CoffeeOrder("Еспресо", "Small").printReceipt();
        new CoffeeOrder("Капучино").printReceipt();

        // ===== Завдання 15 =====
        Box cube = new Box(2.5, "картон");
        Box copy = new Box(cube);
        cube.printBox();
        copy.printBox();
        System.out.println("Об'єми рівні: " + (cube.getVolume() == copy.getVolume()));
        System.out.println("Це один об'єкт: " + (cube == copy));

        // ===== Завдання 16 =====
        FlightTicket ticket = new FlightTicket("TK-5521", "Петренко Іван", "PS101", "Київ", "Варшава");
        ticket.printBoardingPass();
        ticket.assignSeat("14C");
        ticket.printBoardingPass();

        // ===== Завдання 17 =====
        MathOperations mo = new MathOperations();
        System.out.println(mo.add(2, 3));
        System.out.println(mo.add(2.5, 3.1));
        System.out.println(mo.add(1, 2, 3));
        System.out.println(mo.add("Hello", "World"));
        System.out.println(mo.multiply(4, 5));
        System.out.println(mo.multiply(1.5, 2.0));
        System.out.println(mo.multiply("ab", 3));

        // ===== Завдання 18 =====
        DocumentPrinter dp = new DocumentPrinter();
        dp.print("Звичайний рядок");
        dp.print(123);
        dp.print(Math.PI, 3);
        dp.print(new String[]{"Перший", "Другий", "Третій"});
        dp.print("тихий текст", true);

        // ===== Завдання 19 =====
        AreaCalculator ac = new AreaCalculator();
        System.out.println("Квадрат: " + ac.calculateArea(5));
        System.out.printf("Коло: %.2f%n", ac.calculateArea(3, true));
        System.out.println("Прямокутник: " + ac.calculateArea(4, 6));
        System.out.println("Трикутник: " + ac.calculateArea(3, 4, 5));
        System.out.println("Трапеція: " + ac.calculateTrapezoidArea(4, 8, 5));

        // ===== Завдання 20 =====
        Logger log = new Logger();
        log.log("Програма запущена");
        log.log("WARN", "Мало пам'яті");
        log.log("ERROR", 404, "Файл не знайдено");
        log.log("DEBUG", "Перевірка часу", true);

        // ===== Завдання 21 =====
        ArraySearcher srch = new ArraySearcher();
        int[] nums = {4, 8, 15, 16, 23, 42, 15};
        String[] words = {"Java", "Python", "kotlin", "C++"};
        System.out.println("find(15): " + srch.find(nums, 15));
        System.out.println("find(15, з 3): " + srch.find(nums, 15, 3));
        System.out.println("find(100): " + srch.find(nums, 100));
        System.out.println("find(\"Kotlin\"): " + srch.find(words, "Kotlin"));
        System.out.println("find(\"Kotlin\", ignoreCase): " + srch.find(words, "Kotlin", true));

        // ===== Завдання 22 =====
        DateService ds = new DateService(15, 3, 2024);
        ds.printDate();
        ds.add(20);
        ds.printDate();
        ds.add(0, 3);
        ds.printDate();
        ds.add(10, 10, 1);
        ds.printDate();

        // ===== Завдання 23 =====
        SalaryCalculator sc = new SalaryCalculator();
        System.out.println("Тільки ставка: " + sc.calculate(25000));
        System.out.println("Ставка + премія: " + sc.calculate(25000, 3000));
        System.out.printf("Бонус 10%% з податком: %.2f%n", sc.calculate(25000, 10, true));
        System.out.println("Бонус 10% без податку: " + sc.calculate(25000, 10, false));
        System.out.println("Понаднормові 12 год: " + sc.calculate(25000, 12, 250.0));

        // ===== Завдання 24 =====
        ArrayFilter af = new ArrayFilter();
        int[] data = {12, 5, 8, 19, 24, 3, 16};
        printArray("> 10", af.filter(data, 10));
        printArray("[5; 16]", af.filter(data, 5, 16));
        printArray("парні", af.filter(data, true));
        printArray("непарні", af.filter(data, false));

        // ===== Завдання 25 =====
        UserAccount ua1 = new UserAccount("ivan", "ivan@ukr.net");
        UserAccount ua2 = new UserAccount("petro", "petro@ukr.net");
        UserAccount ua3 = new UserAccount("olga", "olga@ukr.net");
        ua1.printInfo(); ua2.printInfo(); ua3.printInfo();
        System.out.println("Наступний ID: " + UserAccount.getNextAvailableId());
        UserAccount.resetIdSequence(5000);
        new UserAccount("new", "new@ukr.net").printInfo();

        // ===== Завдання 26 =====
        for (int i = 1; i <= 6; i++) {
            if (ServerConfig.connect()) System.out.println("Користувач " + i + " підключився");
            else System.out.println("Користувач " + i + ": відмова, ліміт вичерпано");
        }
        ServerConfig.printServerStatus();
        ServerConfig.disconnect();
        ServerConfig.printServerStatus();

        // ===== Завдання 27 =====
        // MathUtils m = new MathUtils(); // не скомпілюється, конструктор private
        System.out.println("10! = " + MathUtils.factorial(10));
        System.out.println("2^10 = " + MathUtils.power(2, 10));
        System.out.println("2^-2 = " + MathUtils.power(2, -2));
        System.out.println("НСД(48, 18) = " + MathUtils.gcd(48, 18));
        System.out.println("clamp(150, 0, 100) = " + MathUtils.clamp(150, 0, 100));
        System.out.println("PI = " + MathUtils.PI + ", E = " + MathUtils.E);

        // ===== Завдання 28 =====
        System.out.printf("1000 грн = %.2f USD%n", CurrencyExchange.uahToUsd(1000));
        System.out.println("100 USD = " + CurrencyExchange.usdToUah(100) + " грн");
        System.out.println("100 EUR = " + CurrencyExchange.eurToUah(100) + " грн");
        CurrencyExchange.updateRates(42.0, 48.5);
        System.out.println("-- новий курс --");
        System.out.println("100 USD = " + CurrencyExchange.usdToUah(100) + " грн");
        System.out.println("100 EUR = " + CurrencyExchange.eurToUah(100) + " грн");

        // ===== Завдання 29 =====
        FleetCar fc1 = new FleetCar("WVW111", 12000);
        FleetCar fc2 = new FleetCar("TMB222", 5000);
        FleetCar fc3 = new FleetCar("VF1333", 0);
        fc1.addTrip(350);
        fc2.addTrip(120.5);
        fc3.addTrip(80);
        FleetCar.printFleetSummary();

        // ===== Завдання 30 =====
        System.out.println("Паліндром 'А роза упала на лапу Азора': " + StringUtils.isPalindrome("А роза упала на лапу Азора"));
        System.out.println("Паліндром 'Java': " + StringUtils.isPalindrome("Java"));
        System.out.println("reverse: " + StringUtils.reverse("Програмування"));
        System.out.println("Голосних: " + StringUtils.countVowels("Програмування"));
        System.out.println(StringUtils.maskCardNumber("4149 6293 1785 1234"));

        // ===== Завдання 31 =====
        GameSession[] sessions = new GameSession[4];
        String[] hosts = {"Nagibator", "Kostya", "Lena", "Dima"};
        for (int i = 0; i < 4; i++) {
            sessions[i] = GameSession.createSession(hosts[i]);
            System.out.println("Сесія " + (i + 1) + ": " + (sessions[i] == null ? "null" : sessions[i].getSessionToken()));
        }
        sessions[0].terminate();
        GameSession again = GameSession.createSession("Dima");
        System.out.println("Після звільнення місця: " + again.getSessionToken());

        // ===== Завдання 32 =====
        System.out.println("Енергія спокою 1 г: " + PhysicsEngine.restEnergy(0.001) + " Дж");
        System.out.println("Падіння за 5 с: " + PhysicsEngine.freeFallDistance(5) + " м");
        System.out.println("Кінетична енергія (70 кг, 10 м/с): " + PhysicsEngine.kineticEnergy(70, 10) + " Дж");

        // ===== Завдання 33 =====
        LineSegment seg = new LineSegment(new Point(1, 1), new Point(7, 9));
        seg.printSegment();
        Point mid = seg.getMidPoint();
        System.out.println("Середина: (" + mid.getX() + "; " + mid.getY() + ")");
        new LineSegment(0, 0, 3, 4).printSegment();

        // ===== Завдання 34 =====
        ClientAccount ivan = new ClientAccount("UA11", "Іван", 10000);
        ClientAccount maria = new ClientAccount("UA22", "Марія", 2000);
        System.out.println("Переказ 3500: " + ivan.transferTo(maria, 3500));
        System.out.println("Переказ собі: " + ivan.transferTo(ivan, 100));
        System.out.println("Переказ 50000: " + ivan.transferTo(maria, 50000));
        ivan.printAccount();
        maria.printAccount();

        // ===== Завдання 35 =====
        Engine eng = new Engine("V8-0042", 420);
        CarWithEngine mustang = new CarWithEngine("Ford", "Mustang", eng);
        mustang.printSpecs();
        mustang.startCar();
        System.out.println("Двигун працює: " + eng.isRunning());
        mustang.turnOff();
        System.out.println("Двигун працює: " + eng.isRunning());

        // ===== Завдання 36 =====
        Computer pc = new Computer("Ігровий ПК", new Processor("Ryzen 5 7600", 3.8, 8500),
                new Memory(16, 5200, 2400), 3000);
        pc.printSpecs();
        pc.upgradeMemory(new Memory(32, 6000, 4300));
        pc.printSpecs();

        // ===== Завдання 37 =====
        Hero knight = new Hero("Лицар", 120, 18, 8);
        Hero orc = new Hero("Орк", 150, 22, 4);
        int round = 1;
        while (knight.isAlive() && orc.isAlive()) {
            System.out.print("Раунд " + round + ": ");
            knight.attack(orc);
            if (orc.isAlive()) {
                System.out.print("Раунд " + round + ": ");
                orc.attack(knight);
            }
            round++;
        }
        System.out.println("Переможець: " + (knight.isAlive() ? knight.getName() : orc.getName()));

        // ===== Завдання 38 =====
        OrderProduct op1 = new OrderProduct(1, "Клавіатура", 1500);
        OrderProduct op2 = new OrderProduct(2, "Мишка", 700);
        OrderProduct op3 = new OrderProduct(3, "Монітор", 7200);

        Customer rich = new Customer("Олексій", 12000);
        Order order1 = new Order(rich, 5);
        order1.addProduct(op1); order1.addProduct(op2); order1.addProduct(op3);
        order1.checkout();

        Customer poor = new Customer("Василь", 1000);
        Order order2 = new Order(poor, 5);
        order2.addProduct(op1); order2.addProduct(op2);
        order2.checkout();

        // ===== Завдання 39 =====
        Vector3D vx = new Vector3D(1, 0, 0);
        Vector3D vy = new Vector3D(0, 1, 0);
        Vector3D sum = vx.add(vy);
        sum.print();
        System.out.println("Скалярний добуток: " + vx.dotProduct(vy));
        vx.crossProduct(vy).print();
        System.out.println("Ортогональні: " + vx.isOrthogonalTo(vy));
        System.out.println("Рівні (1,1,0): " + sum.isEqualTo(new Vector3D(1, 1, 0)));
        new Vector3D().print();

        // ===== Завдання 40 =====
        LibraryCatalog lib = new LibraryCatalog(5);
        lib.addBook(new BookItem("978-1", "Тигролови", "Іван Багряний"));
        lib.addBook(new BookItem("978-2", "Захар Беркут", "Іван Франко"));
        lib.addBook(new BookItem("978-3", "Лісова пісня", "Леся Українка"));
        lib.printCatalog();
        System.out.println("Взяти 'Тигролови': " + lib.borrowBook("Тигролови"));
        lib.printCatalog();
        System.out.println("Взяти 'Тигролови' ще раз: " + lib.borrowBook("Тигролови"));
        System.out.println("Взяти 'Кайдашева сім'я': " + lib.borrowBook("Кайдашева сім'я"));
    }

    // допоміжний метод для виводу масиву (завд. 24)
    static void printArray(String label, int[] arr) {
        System.out.print(label + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

// класи завдань

class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book() {
        title = "Невідомо";
        author = "Невідомий";
        year = 2000;
        price = 0.0;
    }

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year < 0 ? 2000 : year;
        this.price = price < 0 ? 0.0 : price;
    }

    public void printInfo() {
        System.out.println("\"" + title + "\" - " + author + ", " + year + " р., " + price + " грн");
    }
}

class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        if (age < 15 || age > 80) age = 18;
        if (gpa < 0.0 || gpa > 5.0) gpa = 0.0;
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public boolean isHonorStudent() {
        return gpa >= 4.5;
    }

    public void printStudent() {
        System.out.println(name + ", " + age + " р., бал " + gpa + " - " + (isHonorStudent() ? "Відмінник" : "Звичайний студент"));
    }
}

class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance < 0 ? 0.0 : initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            System.out.println("Операцію відхилено");
            return false;
        }
        balance -= amount;
        return true;
    }

    public void printAccount() {
        System.out.println("Рахунок " + accountNumber + " (" + ownerName + "): " + balance + " грн");
    }
}

class Point2D {
    private double x;
    private double y;

    public Point2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public double distanceTo(double targetX, double targetY) {
        double dx = targetX - x;
        double dy = targetY - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void printPoint() {
        System.out.println("Point(" + x + "; " + y + ")");
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public Product(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price < 0 ? 0 : price;
        this.quantity = quantity < 0 ? 0 : quantity;
        this.category = category;
    }

    public double getTotalValue() {
        return price * quantity;
    }

    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Некоректний відсоток знижки");
            return;
        }
        price = price - price * percent / 100;
    }

    public void printProduct() {
        System.out.println("[" + category + "] " + name + " | ціна: " + price + " | к-сть: " + quantity + " | сума: " + getTotalValue());
    }
}

class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = (hours >= 0 && hours <= 23) ? hours : 0;
        this.minutes = (minutes >= 0 && minutes <= 59) ? minutes : 0;
        this.seconds = (seconds >= 0 && seconds <= 59) ? seconds : 0;
    }

    public void tick() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) hours = 0;
            }
        }
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public String toStandardString() {
        int h = hours % 12;
        if (h == 0) h = 12;
        return String.format("%d:%02d:%02d %s", h, minutes, seconds, hours < 12 ? "AM" : "PM");
    }
}

class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        width = 1.0;
        height = 1.0;
    }

    public Rectangle(double size) {
        width = size;
        height = size;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea()      { return width * height; }
    public double getPerimeter() { return 2 * (width + height); }
    public boolean isSquare()    { return width == height; }
}

class Employee {
    private int id;
    private String fullName;
    private String position;
    private double monthlySalary;

    public Employee(int id, String fullName, String position, double monthlySalary) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.monthlySalary = monthlySalary;
    }

    public void raiseSalary(double percent) {
        if (percent > 0) monthlySalary += monthlySalary * percent / 100;
    }

    public double getAnnualSalary() {
        return 12 * monthlySalary;
    }

    public void printBadge() {
        System.out.println("#" + id + " | " + fullName + " | " + position + " | " + monthlySalary + " грн/міс");
    }
}

class User {
    private String login;
    private String email;
    private String role;
    private boolean isActive;

    public User(String login, String email, String role, boolean isActive) {
        this.login = login;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }

    public User(String login, String email) {
        this(login, email, "USER", true);
    }

    public User(String login) {
        this(login, login + "@domain.com");
    }

    public User() {
        this("guest");
    }

    public void printProfile() {
        System.out.println(login + " <" + email + "> роль: " + role + ", активний: " + isActive);
    }
}

class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Помилка: знаменник не може бути 0, ставимо 1");
            denominator = 1;
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int g = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    public Fraction(int wholeNumber) {
        this(wholeNumber, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a == 0 ? 1 : a;
    }

    public void print() {
        if (denominator == 1) System.out.println(numerator);
        else System.out.println(numerator + "/" + denominator);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }
}

class Car {
    private String brand;
    private String model;
    private int year;
    private double mileage;
    private boolean engineStarted;

    public Car(String brand, String model, int year, double mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public Car(String brand, String model, int year) {
        this(brand, model, year, 0.0);
    }

    public Car() {
        this("Unknown", "Standard", 2024);
    }

    public void startEngine() {
        engineStarted = true;
        System.out.println("Двигун " + brand + " заведено");
    }

    public void stopEngine() {
        engineStarted = false;
        System.out.println("Двигун " + brand + " заглушено");
    }

    public void drive(double distance) {
        if (!engineStarted) {
            System.out.println("Спершу заведіть двигун!");
            return;
        }
        mileage += distance;
        System.out.println("Проїхали " + distance + " км");
    }

    public void printInfo() {
        System.out.println(brand + " " + model + " (" + year + "), пробіг: " + mileage + " км");
    }
}

class SmartBulb {
    private int brightness;
    private int colorTemp;
    private boolean isOn;

    public SmartBulb(int brightness, int colorTemp, boolean isOn) {
        if (brightness < 0) brightness = 0;
        if (brightness > 100) brightness = 100;
        if (colorTemp < 2700) colorTemp = 2700;
        if (colorTemp > 6500) colorTemp = 6500;
        this.brightness = brightness;
        this.colorTemp = colorTemp;
        this.isOn = isOn;
    }

    public SmartBulb(int brightness) {
        this(brightness, 4000, true);
    }

    public SmartBulb() {
        this(50);
    }

    public void printStatus() {
        System.out.println("Лампа: " + (isOn ? "увімк" : "вимк") + ", яскравість " + brightness + "%, " + colorTemp + "K");
    }
}

class QueryBuilder {
    private String table;
    private String fields = "*";
    private String whereClause = "";

    public QueryBuilder(String table) {
        this.table = table;
    }

    public QueryBuilder select(String fields) {
        this.fields = fields;
        return this;
    }

    public QueryBuilder where(String condition) {
        this.whereClause = condition;
        return this;
    }

    public String build() {
        return "SELECT " + fields + " FROM " + table + (whereClause.isEmpty() ? "" : " WHERE " + whereClause) + ";";
    }
}

class CoffeeOrder {
    private String type;
    private String size;
    private int sugarCount;
    private boolean withSyrup;
    private double finalPrice;

    public CoffeeOrder(String type, String size, int sugarCount, boolean withSyrup) {
        this.type = type;
        this.size = size;
        this.sugarCount = sugarCount;
        this.withSyrup = withSyrup;
        this.finalPrice = calculatePrice();
    }

    public CoffeeOrder(String type, String size) {
        this(type, size, 0, false);
    }

    public CoffeeOrder(String type) {
        this(type, "Medium");
    }

    private double calculatePrice() {
        double base;
        switch (type) {
            case "Еспресо": base = 40; break;
            case "Капучино": base = 55; break;
            case "Лате": base = 60; break;
            default: base = 40;
        }
        double k = 1.0;
        if (size.equals("Medium")) k = 1.3;
        else if (size.equals("Large")) k = 1.6;
        double price = base * k;
        if (withSyrup) price += 15;
        return price;
    }

    public void printReceipt() {
        System.out.println("--- Чек ---");
        System.out.println(type + " (" + size + "), цукор: " + sugarCount + ", сироп: " + (withSyrup ? "так" : "ні"));
        System.out.printf("До сплати: %.2f грн%n", finalPrice);
    }
}

class Box {
    private double width;
    private double height;
    private double depth;
    private String material;

    public Box(double width, double height, double depth, String material) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.material = material;
    }

    public Box(double size, String material) {
        this(size, size, size, material);
    }

    // конструктор копіювання
    public Box(Box other) {
        this(other.width, other.height, other.depth, other.material);
    }

    public double getVolume() {
        return width * height * depth;
    }

    public double getSurfaceArea() {
        return 2 * (width * height + width * depth + height * depth);
    }

    public void printBox() {
        System.out.println("Коробка " + width + "x" + height + "x" + depth + " (" + material + "), V=" + getVolume() + ", S=" + getSurfaceArea());
    }
}

class FlightTicket {
    private String ticketNumber;
    private String passengerName;
    private String flightNumber;
    private String departureCity;
    private String arrivalCity;
    private String seatNumber;
    private boolean hasBaggage;

    public FlightTicket(String ticketNumber, String passengerName, String flightNumber, String departureCity,
                        String arrivalCity, String seatNumber, boolean hasBaggage) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.seatNumber = seatNumber;
        this.hasBaggage = hasBaggage;
    }

    public FlightTicket(String ticketNumber, String passengerName, String flightNumber, String departureCity, String arrivalCity) {
        this(ticketNumber, passengerName, flightNumber, departureCity, arrivalCity, "UNASSIGNED", false);
    }

    public void assignSeat(String seat) {
        this.seatNumber = seat;
    }

    public void printBoardingPass() {
        System.out.println("=== BOARDING PASS " + ticketNumber + " ===");
        System.out.println("Пасажир: " + passengerName + ", рейс " + flightNumber);
        System.out.println(departureCity + " -> " + arrivalCity + ", місце: " + seatNumber + ", багаж: " + (hasBaggage ? "так" : "ні"));
    }
}

class MathOperations {
    public int add(int a, int b)           { return a + b; }
    public double add(double a, double b) { return a + b; }
    public int add(int a, int b, int c)    { return a + b + c; }
    public String add(String a, String b)  { return a + " " + b; }

    public int multiply(int a, int b)           { return a * b; }
    public double multiply(double a, double b)  { return a * b; }
    public String multiply(String text, int times) {
        String res = "";
        for (int i = 0; i < times; i++) res += text;
        return res;
    }
}

class DocumentPrinter {
    public void print(String message) {
        System.out.println(message);
    }

    public void print(int number) {
        System.out.println("[INT]: " + number);
    }

    public void print(double number, int decimals) {
        System.out.println(String.format("%." + decimals + "f", number));
    }

    public void print(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            System.out.println((i + 1) + ". " + lines[i]);
        }
    }

    public void print(String message, boolean uppercase) {
        System.out.println(uppercase ? message.toUpperCase() : message);
    }
}

class AreaCalculator {
    public double calculateArea(double side) {
        return side * side;
    }

    public double calculateArea(double width, double height) {
        return width * height;
    }

    public double calculateArea(double radius, boolean isCircle) {
        if (!isCircle) return 0;
        return Math.PI * radius * radius;
    }

    // формула Герона
    public double calculateArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // calculateArea(double base1, double base2, double height) має таку ж сигнатуру (double, double, double)
    // як і Герон вище -> "already defined", тому трапецію довелось винести в окремий метод
    public double calculateTrapezoidArea(double base1, double base2, double height) {
        return (base1 + base2) / 2 * height;
    }
}

class Logger {
    public void log(String message) {
        System.out.println("[INFO] " + message);
    }

    public void log(String level, String message) {
        System.out.println("[" + level + "] " + message);
    }

    public void log(String level, int errorCode, String message) {
        System.out.println("[" + level + "] (Code: " + errorCode + "): " + message);
    }

    public void log(String tag, String message, boolean timestamp) {
        if (timestamp) System.out.println("[" + tag + "] " + message + " @" + System.currentTimeMillis());
        else System.out.println("[" + tag + "] " + message);
    }
}

class ArraySearcher {
    public int find(int[] arr, int target) {
        return find(arr, target, 0);
    }

    public int find(int[] arr, int target, int startIndex) {
        if (startIndex < 0) startIndex = 0;
        for (int i = startIndex; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public int find(String[] arr, String target) {
        return find(arr, target, false);
    }

    public int find(String[] arr, String target, boolean ignoreCase) {
        for (int i = 0; i < arr.length; i++) {
            if (ignoreCase ? arr[i].equalsIgnoreCase(target) : arr[i].equals(target)) return i;
        }
        return -1;
    }
}

class DateService {
    private int day;
    private int month;
    private int year;

    public DateService(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // спрощено: у кожному місяці 30 днів
    public void add(int days) {
        add(days, 0, 0);
    }

    public void add(int days, int months) {
        add(days, months, 0);
    }

    public void add(int days, int months, int years) {
        day += days;
        while (day > 30) {
            day -= 30;
            month++;
        }
        month += months;
        while (month > 12) {
            month -= 12;
            year++;
        }
        year += years;
    }

    public void printDate() {
        System.out.printf("%02d.%02d.%d%n", day, month, year);
    }
}

class SalaryCalculator {
    public double calculate(double baseRate) {
        return baseRate;
    }

    public double calculate(double baseRate, double fixedBonus) {
        return baseRate + fixedBonus;
    }

    public double calculate(double baseRate, double bonusPercent, boolean isTaxDeducted) {
        double total = baseRate + baseRate * bonusPercent / 100;
        if (isTaxDeducted) total -= total * 0.195;
        return total;
    }

    public double calculate(double baseRate, int overtimeHours, double overtimeHourlyRate) {
        return baseRate + overtimeHours * overtimeHourlyRate;
    }
}

class ArrayFilter {
    public int[] filter(int[] arr, int threshold) {
        int count = 0;
        for (int x : arr) if (x > threshold) count++;
        int[] res = new int[count];
        int j = 0;
        for (int x : arr) if (x > threshold) res[j++] = x;
        return res;
    }

    public int[] filter(int[] arr, int min, int max) {
        int count = 0;
        for (int x : arr) if (x >= min && x <= max) count++;
        int[] res = new int[count];
        int j = 0;
        for (int x : arr) if (x >= min && x <= max) res[j++] = x;
        return res;
    }

    public int[] filter(int[] arr, boolean keepEvens) {
        int count = 0;
        for (int x : arr) if ((x % 2 == 0) == keepEvens) count++;
        int[] res = new int[count];
        int j = 0;
        for (int x : arr) if ((x % 2 == 0) == keepEvens) res[j++] = x;
        return res;
    }
}

class UserAccount {
    private static int nextId = 1001;

    private int id;
    private String username;
    private String email;

    public UserAccount(String username, String email) {
        this.id = nextId++;
        this.username = username;
        this.email = email;
    }

    public static int getNextAvailableId() {
        return nextId;
    }

    public static void resetIdSequence(int startId) {
        nextId = startId;
    }

    public void printInfo() {
        System.out.println("ID " + id + ": " + username + " (" + email + ")");
    }
}

class ServerConfig {
    public static final String SERVER_NAME = "AlphaEnterprise";
    public static final int MAX_CONNECTIONS = 5;
    private static int activeConnections = 0;

    public static boolean connect() {
        if (activeConnections < MAX_CONNECTIONS) {
            activeConnections++;
            return true;
        }
        return false;
    }

    public static void disconnect() {
        if (activeConnections > 0) activeConnections--;
    }

    public static void printServerStatus() {
        System.out.println(SERVER_NAME + ": підключень " + activeConnections + ", вільно " + (MAX_CONNECTIONS - activeConnections));
    }
}

class MathUtils {
    public static final double PI = 3.1415926535;
    public static final double E = 2.7182818284;

    private MathUtils() {}

    public static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    public static double power(double base, int exp) {
        double res = 1;
        for (int i = 0; i < Math.abs(exp); i++) res *= base;
        return exp < 0 ? 1 / res : res;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    public static int clamp(int val, int min, int max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }
}

class CurrencyExchange {
    private static double usdToUahRate = 41.5;
    private static double eurToUahRate = 45.2;

    public static void updateRates(double newUsd, double newEur) {
        if (newUsd > 0) usdToUahRate = newUsd;
        if (newEur > 0) eurToUahRate = newEur;
    }

    public static double uahToUsd(double uah) { return uah / usdToUahRate; }
    public static double usdToUah(double usd) { return usd * usdToUahRate; }
    public static double eurToUah(double eur) { return eur * eurToUahRate; }
}

class FleetCar {
    private static int totalCars = 0;
    private static double totalCompanyMileage = 0.0;

    private String vinCode;
    private double currentMileage;

    public FleetCar(String vinCode, double initialMileage) {
        this.vinCode = vinCode;
        this.currentMileage = initialMileage;
        totalCars++;
        totalCompanyMileage += initialMileage;
    }

    public void addTrip(double km) {
        this.currentMileage += km;
        totalCompanyMileage += km;
        System.out.println(vinCode + ": +" + km + " км, всього " + currentMileage);
    }

    public static void printFleetSummary() {
        System.out.println("Авто в парку: " + totalCars + ", загальний пробіг: " + totalCompanyMileage + " км");
    }
}

class StringUtils {
    private StringUtils() {}

    public static boolean isPalindrome(String s) {
        String clean = s.replace(" ", "").toLowerCase();
        int i = 0, j = clean.length() - 1;
        while (i < j) {
            if (clean.charAt(i) != clean.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static String reverse(String s) {
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) res += s.charAt(i);
        return res;
    }

    public static int countVowels(String s) {
        String vowels = "аеєиіїоуюяaeiou";
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (vowels.indexOf(c) != -1) count++;
        }
        return count;
    }

    public static String maskCardNumber(String cardNumber) {
        String digits = cardNumber.replace(" ", "");
        String res = "";
        for (int i = 0; i < digits.length(); i++) {
            if (i > 0 && i % 4 == 0) res += " ";
            res += (i < digits.length() - 4) ? '*' : digits.charAt(i);
        }
        return res;
    }
}

class GameSession {
    private static int activeSessionsCount = 0;
    private static int tokenCounter = 0;
    public static final int MAX_SESSIONS = 3;

    private String sessionToken;
    private String hostPlayer;
    private boolean isActive;

    private GameSession(String host) {
        this.hostPlayer = host;
        this.sessionToken = "LOBBY-" + (++tokenCounter) + "-" + host.toUpperCase();
        this.isActive = true;
    }

    public static GameSession createSession(String host) {
        if (activeSessionsCount >= MAX_SESSIONS) {
            System.out.println("Помилка: усі сервера перевантажені!");
            return null;
        }
        activeSessionsCount++;
        return new GameSession(host);
    }

    public void terminate() {
        if (isActive) {
            isActive = false;
            activeSessionsCount--;
            System.out.println("Сесію " + sessionToken + " (" + hostPlayer + ") завершено");
        }
    }

    public String getSessionToken() {
        return sessionToken;
    }
}

class PhysicsEngine {
    public static final double G = 9.80665;
    public static final double SPEED_OF_LIGHT = 299792458.0;

    private PhysicsEngine() {}

    public static double freeFallDistance(double seconds) {
        return G * seconds * seconds / 2;
    }

    public static double kineticEnergy(double massKg, double velocityMs) {
        return massKg * velocityMs * velocityMs / 2;
    }

    public static double restEnergy(double massKg) {
        return massKg * SPEED_OF_LIGHT * SPEED_OF_LIGHT;
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }
}

class LineSegment {
    private Point start;
    private Point end;

    public LineSegment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public LineSegment(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public double getLength() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Point getMidPoint() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    public void printSegment() {
        System.out.println("Відрізок (" + start.getX() + "; " + start.getY() + ") - (" + end.getX() + "; " + end.getY() + "), довжина " + getLength());
    }
}

class ClientAccount {
    private String iban;
    private String owner;
    private double balance;

    public ClientAccount(String iban, String owner, double balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }

    public boolean transferTo(ClientAccount recipient, double amount) {
        if (recipient == null || recipient == this) return false;
        if (amount <= 0 || this.balance < amount) return false;
        this.balance -= amount;
        recipient.balance += amount;
        return true;
    }

    public void printAccount() {
        System.out.println(owner + " [" + iban + "]: " + balance + " грн");
    }
}

class Engine {
    private String serialNumber;
    private int horsePower;
    private boolean isRunning;

    public Engine(String serialNumber, int horsePower) {
        this.serialNumber = serialNumber;
        this.horsePower = horsePower;
    }

    public void start()        { isRunning = true; }
    public void stop()         { isRunning = false; }
    public boolean isRunning() { return isRunning; }
    public int getHorsePower() { return horsePower; }
    public String getSerialNumber() { return serialNumber; }
}

class CarWithEngine {
    private String brand;
    private String model;
    private Engine engine;

    public CarWithEngine(String brand, String model, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    public void startCar() {
        this.engine.start();
        System.out.println(brand + " готовий до руху!");
    }

    public void turnOff() {
        this.engine.stop();
        System.out.println(brand + " заглушено");
    }

    public void printSpecs() {
        System.out.println(brand + " " + model + ", двигун " + engine.getSerialNumber() + " - " + engine.getHorsePower() + " к.с.");
    }
}

class Processor {
    private String model;
    private double frequencyGHz;
    private double price;

    public Processor(String model, double frequencyGHz, double price) {
        this.model = model;
        this.frequencyGHz = frequencyGHz;
        this.price = price;
    }

    public String getModel() { return model; }
    public double getFrequencyGHz() { return frequencyGHz; }
    public double getPrice() { return price; }
}

class Memory {
    private int sizeGB;
    private int frequencyMHz;
    private double price;

    public Memory(int sizeGB, int frequencyMHz, double price) {
        this.sizeGB = sizeGB;
        this.frequencyMHz = frequencyMHz;
        this.price = price;
    }

    public int getSizeGB() { return sizeGB; }
    public int getFrequencyMHz() { return frequencyMHz; }
    public double getPrice() { return price; }
}

class Computer {
    private String title;
    private Processor cpu;
    private Memory ram;
    private double casePrice;

    public Computer(String title, Processor cpu, Memory ram, double casePrice) {
        this.title = title;
        this.cpu = cpu;
        this.ram = ram;
        this.casePrice = casePrice;
    }

    public double calculateTotalPrice() {
        return cpu.getPrice() + ram.getPrice() + casePrice;
    }

    public void upgradeMemory(Memory newRam) {
        System.out.println("Апгрейд RAM: " + ram.getSizeGB() + "GB -> " + newRam.getSizeGB() + "GB");
        this.ram = newRam;
    }

    public void printSpecs() {
        System.out.println(title + ": CPU " + cpu.getModel() + " " + cpu.getFrequencyGHz() + "GHz, RAM "
                + ram.getSizeGB() + "GB " + ram.getFrequencyMHz() + "MHz. Ціна: " + calculateTotalPrice() + " грн");
    }
}

class Hero {
    private String name;
    private int health;
    private int attackPower;
    private int defense;

    public Hero(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public void attack(Hero target) {
        int damage = this.attackPower - target.defense;
        if (damage <= 0) damage = 1;
        target.health -= damage;
        if (target.health < 0) target.health = 0;
        System.out.println(this.name + " б'є " + target.name + " на " + damage + ", у " + target.name + " лишилось " + target.health + " HP");
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return name;
    }
}

// назвав OrderProduct, бо Product вже є в завданні 5
class OrderProduct {
    private int id;
    private String title;
    private double price;

    public OrderProduct(int id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }
}

class Customer {
    private String name;
    private double walletBalance;

    public Customer(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
    }

    public boolean pay(double amount) {
        if (amount > walletBalance) return false;
        walletBalance -= amount;
        return true;
    }

    public String getName() { return name; }
    public double getWalletBalance() { return walletBalance; }
}

class Order {
    private Customer customer;
    private OrderProduct[] items;
    private int itemCount;

    public Order(Customer customer, int maxItems) {
        this.customer = customer;
        this.items = new OrderProduct[maxItems];
    }

    public void addProduct(OrderProduct p) {
        if (itemCount < items.length) items[itemCount++] = p;
        else System.out.println("Замовлення переповнене");
    }

    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) total += items[i].getPrice();
        return total;
    }

    public boolean checkout() {
        double total = calculateTotal();
        if (!this.customer.pay(total)) {
            System.out.println(customer.getName() + ": недостатньо коштів (потрібно " + total + ", є " + customer.getWalletBalance() + ")");
            return false;
        }
        System.out.println("=== Чек для " + customer.getName() + " ===");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].getId() + ". " + items[i].getTitle() + " - " + items[i].getPrice());
        }
        System.out.println("Разом: " + total + ", залишок на рахунку: " + customer.getWalletBalance());
        return true;
    }
}

class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D() {
        this(0, 0, 0);
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(x + other.x, y + other.y, z + other.z);
    }

    public double dotProduct(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vector3D crossProduct(Vector3D other) {
        return new Vector3D(y * other.z - z * other.y, z * other.x - x * other.z, x * other.y - y * other.x);
    }

    public boolean isOrthogonalTo(Vector3D other) {
        return dotProduct(other) == 0;
    }

    public boolean isEqualTo(Vector3D other) {
        return x == other.x && y == other.y && z == other.z;
    }

    public void print() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}

class BookItem {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    public BookItem(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void borrowBook() { isAvailable = false; }
    public void returnBook() { isAvailable = true; }
    public boolean isAvailable() { return isAvailable; }
    public String getTitle() { return title; }

    public void printBook() {
        System.out.println(isbn + " | " + title + " - " + author + " | " + (isAvailable ? "в наявності" : "видана"));
    }
}

class LibraryCatalog {
    private BookItem[] books;
    private int size;

    public LibraryCatalog(int capacity) {
        books = new BookItem[capacity];
    }

    public void addBook(BookItem book) {
        if (size < books.length) books[size++] = book;
        else System.out.println("Фонд заповнений!");
    }

    public BookItem findBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) return books[i];
        }
        return null;
    }

    public boolean borrowBook(String title) {
        BookItem book = findBookByTitle(title);
        if (book == null || !book.isAvailable()) return false;
        book.borrowBook();
        return true;
    }

    public void printCatalog() {
        System.out.println("--- Каталог (" + size + "/" + books.length + ") ---");
        for (int i = 0; i < size; i++) books[i].printBook();
    }
}
