package semester1.practice08;

// головний клас
public class Practice08 {
    public static void main(String[] args) {

        // ===== Завдання 1 =====
        Student student = new Student("Денис", 2, 87.5);
        System.out.println(student);
        student.setCourse(10);
        student.setGpa(-4);
        System.out.println(student);

        // ===== Завдання 2 =====
        Product p1 = new Product("A-101", "Монітор", 6499.50, 4);
        Product p2 = new Product("B-205", "Клавіатура", 1299, 12);
        Product p3 = new Product("C-007", "Кабель HDMI", -50, -3);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // ===== Завдання 3 =====
        Circle c = new Circle(-5);
        System.out.println(c);
        c.setRadius(3);
        System.out.println(c);
        c.setRadius(0);
        System.out.println(c);

        // ===== Завдання 4 =====
        CardWallet wallet = new CardWallet("4149629317854589", "1234", 12500);
        System.out.println(wallet);
        System.out.println("Зміна PIN (неправильний старий): " + wallet.changePin("0000", "4321"));
        System.out.println("Зміна PIN: " + wallet.changePin("1234", "4321"));

        // ===== Завдання 5 =====
        SensorNode sensor = new SensorNode("TEMP-01", 21.4, -0.6);
        System.out.println(sensor);
        sensor.calibrationOffset = 0.3;
        System.out.println(sensor);

        // ===== Завдання 6 =====
        double[] temps = {12.5, 14.0, 17.3, 21.8, 19.1, 15.6};
        WeatherDay day = new WeatherDay("27.10.2026", temps);
        temps[0] = 100;
        System.out.println(day);
        System.out.println("Мін: " + day.getMinTemp() + ", макс: " + day.getMaxTemp());

        // ===== Завдання 7 =====
        IntRange range = new IntRange(20, 5);
        System.out.println(range);
        System.out.println("contains(10): " + range.contains(10));
        System.out.println("contains(25): " + range.contains(25));
        range.update(100, -10);
        System.out.println(range);

        // ===== Завдання 8 =====
        InvoiceItem item = new InvoiceItem("Миша бездротова", 3, 450, 10);
        InvoiceItem item2 = new InvoiceItem("Флешка 64GB", 2, 320, 80);
        System.out.println("Позиція чека: " + item);
        System.out.println("Позиція чека: " + item2);

        // ===== Завдання 9 =====
        Employee e = new Employee("Ольга", 30000);
        Developer dev = new Developer("Максим", 65000, "Java");
        System.out.println(e);
        System.out.println(dev);

        // ===== Завдання 10 =====
        Dog dog = new Dog("Рекс", 4, 28.5, "Німецька вівчарка");
        Cat cat = new Cat("Мурка", 2, 3.8, true);
        System.out.println(dog);
        System.out.println(dog.fetchStick());
        System.out.println(cat);
        System.out.println(cat.purr());

        // ===== Завдання 11 =====
        PassengerCar pc = new PassengerCar("Toyota", 210, 55, 5);
        CargoTruck truck = new CargoTruck("MAN", 120, 400, 18);
        System.out.println(pc);
        System.out.println(truck);
        System.out.println("Витрата при повному завантаженні: " + truck.getFullLoadConsumption() + " л/100км");

        // ===== Завдання 12 =====
        Rectangle rect = new Rectangle(4, 5);
        Box3D box = new Box3D(4, 5, 3);
        System.out.println(rect);
        System.out.println(box);

        // ===== Завдання 13 =====
        UniversityStudent us = new UniversityStudent("Іваненко Петро", 2006, "ST-1123", "Комп'ютерні науки", 2500);
        Professor prof = new Professor("Шевчук Анна Миколаївна", 1975, "доцент", 47);
        System.out.println(us + ", вік: " + us.getAge(2026));
        System.out.println(prof + ", вік: " + prof.getAge(2026));

        // ===== Завдання 14 =====
        Smartphone s1 = new Smartphone("Samsung", 32000, 256, true);
        Smartphone s2 = new Smartphone("Xiaomi", 14500, 128);
        Smartphone s3 = new Smartphone("Nokia");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // ===== Завдання 15 =====
        PrintedBook pb = new PrintedBook("Тигролови", "Іван Багряний", 1944, 304, "тверда");
        AudioBook ab = new AudioBook("Місто", "Валер'ян Підмогильний", 1928, 543, "Олексій Богданович");
        System.out.println(pb);
        System.out.println(ab);

        // ===== Завдання 16 =====
        Gamer casual = new Gamer("noob_228", 340);
        ProEsportsPlayer pro = new ProEsportsPlayer("s1mple", 25000, "NAVI", 2500000, 21);
        ProEsportsPlayer newbie = new ProEsportsPlayer("rookie", 1200, "NoName", 0, 0);
        System.out.println(casual);
        System.out.println(pro);
        System.out.println(newbie);

        // ===== Завдання 17 =====
        StaffMember sm = new StaffMember("Оксана", 22000);
        Manager mgr = new Manager("Віктор", 40000, 8000);
        SalesPerson sp = new SalesPerson("Ігор", 18000, 350000, 3);
        System.out.println(sm);
        System.out.println(mgr);
        System.out.println(sp);

        // ===== Завдання 18 =====
        StandardTransfer st = new StandardTransfer(5000);
        InternationalTransfer it = new InternationalTransfer(5000, "PL");
        System.out.println(st);
        System.out.println(it);

        // ===== Завдання 19 =====
        Ticket t1 = new Ticket("Концерт Океан Ельзи", 1200);
        StudentTicket t2 = new StudentTicket("Концерт Океан Ельзи", 1200, "КВ12345678");
        VipTicket t3 = new VipTicket("Концерт Океан Ельзи", 1200, true, 1500);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        // ===== Завдання 20 =====
        Weapon axe = new Weapon("Сокира", 35);
        EnchantedSword sword = new EnchantedSword("Меч Полум'я", 40, "Вогонь", 12, 3);
        System.out.println(axe);
        System.out.println(sword);

        // ===== Завдання 21 =====
        Parcel parcel = new Parcel("NP-20450001", 3.2);
        FragileParcel fragile = new FragileParcel("NP-20450002", 3.2, true, 8000);
        System.out.println(parcel);
        System.out.println(fragile);

        // ===== Завдання 22 =====
        Appliance kettle = new Appliance("Чайник Bosch", 2200);
        EcoHeater heater = new EcoHeater("Обігрівач Ecoflex", 2000, true);
        AirConditioner ac = new AirConditioner("Кондиціонер Gree", 2600, false);
        System.out.println(kettle + " -> за 1 год: " + kettle.getDailyConsumptionKWh(1) + " кВт*год");
        System.out.println(heater + " -> за 8 год: " + heater.getDailyConsumptionKWh(8) + " кВт*год");
        heater.setEcoModeActive(false);
        System.out.println(heater + " -> за 8 год: " + heater.getDailyConsumptionKWh(8) + " кВт*год");
        System.out.println(ac + " -> за 6 год: " + ac.getDailyConsumptionKWh(6) + " кВт*год");

        // ===== Завдання 23 =====
        Point2D pt2 = new Point2D(3, 4);
        Point3D pt3 = new Point3D(3, 4, 12);
        System.out.println(pt2 + " -> до O: " + pt2.distanceToOrigin());
        System.out.println(pt3 + " -> до O: " + pt3.distanceToOrigin());

        // ===== Завдання 24 =====
        Coffee americano = new Coffee("Арабіка, середнє", 250, 55);
        LatteWithAddons latte = new LatteWithAddons("Арабіка, темне", 350, 70, "вівсяне", 2);
        System.out.println(americano);
        System.out.println(latte);

        // ===== Завдання 25 =====
        DotaHero baseHero = new DotaHero("Crystal Maiden", "Intelligence", 120);
        StrengthHero pudge = new StrengthHero("Pudge", "Strength", 120, 25);
        AlchemistHero alch = new AlchemistHero("Alchemist", 120, 25, 6);
        System.out.println(baseHero);
        System.out.println(pudge);
        System.out.println(alch);
        alch.chemicalRage();

        // ===== Завдання 26 =====
        ElectricCar tesla = new ElectricCar("Tesla Model 3", 2023, 283, 4, 60.0, 491);
        System.out.println(tesla);

        // ===== Завдання 27 =====
        CashbackPlatinumCard card = new CashbackPlatinumCard("Олена К.", 20000, 5000, 2.5);
        System.out.println("Оплата 1200: " + card.pay(1200));
        System.out.println("Оплата 7000: " + card.pay(7000));
        System.out.println("Оплата 3000: " + card.pay(3000));
        System.out.println(card);

        // ===== Завдання 28 =====
        SecurityTerminal term = new SecurityTerminal();
        CustomTerminal custom = new CustomTerminal("Каса №3");
        System.out.println(term.getWelcomeBanner() + " " + term.generateAuthHash("admin"));
        System.out.println(custom.getWelcomeBanner() + " " + custom.generateAuthHash("kassir"));

        // ===== Завдання 29 =====
        ImmutableServerCredentials creds = new ImmutableServerCredentials("api.myshop.ua", 443, "sk_9f8a7b6c5d");
        System.out.println(creds);
        System.out.println("host=" + creds.getHost() + ", port=" + creds.getPort());

        // ===== Завдання 30 =====
        Segment1D seg = new Segment1D(3);
        Square2D sq = new Square2D(3);
        Cube3D cube = new Cube3D(3);
        System.out.println(seg);
        System.out.println(sq);
        System.out.println(cube);

        // ===== Завдання 31 =====
        PostgraduateStudent pg1 = new PostgraduateStudent(501, "koval@univ.ua", "ПЗ-91а", 91.2,
                "Методи машинного навчання в медицині", "проф. Ткаченко В.М.");
        PostgraduateStudent pg2 = new PostgraduateStudent(502, "bondar@univ.ua", "ПЗ-91а", 78.0,
                "", "доц. Литвин О.С.");
        System.out.println(pg1);
        System.out.println(pg2);

        // ===== Завдання 32 =====
        Medicine aspirin = new Medicine("Аспірин", 85, false);
        PrescriptionMedicine antibiotic = new PrescriptionMedicine("Амоксицилін", 210, false, "LIC-4471");
        ControlledSubstance strong = new ControlledSubstance("Трамадол", 540, false, "LIC-9902", 16);
        System.out.println(aspirin);
        System.out.println(antibiotic);
        System.out.println("  з рецептом: " + antibiotic.canSell(true) + ", без рецепта: " + antibiotic.canSell(false));
        System.out.println(strong);
        System.out.println("  з рецептом (16 років): " + strong.canSell(true));
        strong.setPatientAge(35);
        System.out.println("  з рецептом (35 років): " + strong.canSell(true));
        ControlledSubstance expired = new ControlledSubstance("Морфін", 900, true, "LIC-0001", 40);
        System.out.println("  прострочений: " + expired.canSell(true));

        // ===== Завдання 33 =====
        ArithmeticProgression ap = new ArithmeticProgression(2, 3);
        GeometricProgression gp = new GeometricProgression(3, 2);
        System.out.println(ap);
        System.out.println(gp);
        System.out.println("a10 = " + ap.getTerm(10) + ", b10 = " + gp.getTerm(10));

        // ===== Завдання 34 =====
        int[] grades = {95, 70, 88, 60};
        GradeSheet gs = new GradeSheet("Денис", grades);
        WeightedGradeSheet wgs = new WeightedGradeSheet("Денис", grades, new double[]{0.4, 0.1, 0.4, 0.1});
        System.out.println(gs);
        System.out.println(wgs);

        // ===== Завдання 35 =====
        LinearFunction lf = new LinearFunction(2, -3);
        QuadraticFunction qf = new QuadraticFunction(1, -4, 3);
        System.out.println(lf + ",  f(5) = " + lf.evaluate(5));
        System.out.println(qf + ",  f(5) = " + qf.evaluate(5));
        System.out.println("Вершина параболи x0 = " + qf.getVertexX() + ", y0 = " + qf.evaluate(qf.getVertexX()));

        // ===== Завдання 36 =====
        WarehouseItem wi = new WarehouseItem("Чайник електричний", 40, new double[]{620, 640, 610, 655});
        DiscountedWarehouseItem dwi = new DiscountedWarehouseItem("Праска Tefal", 12, new double[]{1100, 1180, 1150},
                "пошкоджена упаковка", 25);
        System.out.println(wi);
        System.out.println(dwi);

        // ===== Завдання 37 =====
        CinemaHall hall = new CinemaHall("Зал 1", 4, 6, 150);
        hall.bookSeat(0, 2); hall.bookSeat(1, 3); hall.bookSeat(2, 2); hall.bookSeat(3, 0);
        hall.bookSeat(1, 3); // вже зайнято
        System.out.println(hall);

        VipCinemaHall vip = new VipCinemaHall("VIP зал", 3, 4, 400, 120);
        vip.bookSeat(0, 0); vip.bookSeat(2, 1); vip.bookSeat(2, 2); vip.bookSeat(5, 5); // останнє - неіснуюче
        System.out.println(vip);

        // ===== Завдання 38 =====
        TeamLead lead = new TeamLead("Андрій", 95000, "Java", 5);
        lead.addTeamMember(dev);
        lead.addTeamMember(new Developer("Софія", 58000, "Kotlin"));
        lead.addTeamMember(new Developer("Тарас", 42000, "JavaScript"));
        System.out.println(lead);

        // ===== Завдання 39 =====
        CharacterUnit goblin = new CharacterUnit("Гоблін", 60, 2);
        ShieldedPaladin paladin = new ShieldedPaladin("Паладин", 120, 5, 40);
        System.out.println(goblin);
        goblin.takeDamage(25);
        System.out.println(goblin);
        System.out.println(paladin);
        paladin.takeDamage(30);
        System.out.println(paladin);
        paladin.takeDamage(30);
        System.out.println(paladin);
        paladin.takeDamage(50);
        System.out.println(paladin);
    }
}

// класи завдань

class Student {
    private String name;
    private int course;
    private double gpa;

    public Student(String name, int course, double gpa) {
        this.name = name;
        setCourse(course);
        setGpa(gpa);
    }

    public String getName() { return name; }
    public int getCourse() { return course; }
    public double getGpa() { return gpa; }

    public void setName(String name) { this.name = name; }

    public void setCourse(int course) {
        this.course = (course >= 1 && course <= 6) ? course : 1;
    }

    public void setGpa(double gpa) {
        this.gpa = (gpa >= 0.0 && gpa <= 100.0) ? gpa : 60.0;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', course=" + course + ", gpa=" + gpa + "}";
    }
}

class Product {
    private String sku;
    private String title;
    private double price;
    private int stock;

    public Product(String sku, String title, double price, int stock) {
        this.sku = sku;
        this.title = title;
        setPrice(price);
        setStock(stock);
    }

    public void setPrice(double price) { this.price = price < 0 ? 0.0 : price; }
    public void setStock(int stock)    { this.stock = stock < 0 ? 0 : stock; }
    public double getPrice() { return price; }
    public int getStock()    { return stock; }

    public double getTotalCost() {
        return price * stock;
    }

    @Override
    public String toString() {
        return String.format("[SKU: %s] %s | Ціна: %.2f грн | Залишок: %d шт. | Разом: %.2f грн",
                sku, title, price, stock, getTotalCost());
    }
}

class Circle {
    private double radius;

    public Circle(double radius) {
        setRadius(radius);
    }

    public void setRadius(double radius) {
        this.radius = radius > 0 ? radius : 1.0;
    }

    public double getRadius() { return radius; }

    public double getArea()          { return Math.PI * radius * radius; }
    public double getCircumference() { return 2 * Math.PI * radius; }

    @Override
    public String toString() {
        return String.format("Circle{r=%.2f, S=%.2f, L=%.2f}", radius, getArea(), getCircumference());
    }
}

class CardWallet {
    private String cardNumber;
    private String pinCode; // без геттера!
    private double balance;

    public CardWallet(String cardNumber, String pinCode, double balance) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = balance < 0 ? 0 : balance;
    }

    public boolean changePin(String oldPin, String newPin) {
        if (!pinCode.equals(oldPin)) return false;
        if (newPin == null || newPin.length() != 4) return false;
        pinCode = newPin;
        return true;
    }

    @Override
    public String toString() {
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        return String.format("CardWallet{card='**** **** **** %s', balance=%.2f UAH}", last4, balance);
    }
}

class SensorNode {
    private String sensorId;
    protected double calibrationOffset;
    private double rawValue;

    public SensorNode(String sensorId, double rawValue, double calibrationOffset) {
        this.sensorId = sensorId;
        this.rawValue = rawValue;
        this.calibrationOffset = calibrationOffset;
    }

    public String getSensorId() { return sensorId; }

    public double getCalibratedValue() {
        return rawValue + calibrationOffset;
    }

    @Override
    public String toString() {
        return String.format("Датчик %s: сирий=%.2f, відкалібрований=%.2f (offset %.2f)",
                sensorId, rawValue, getCalibratedValue(), calibrationOffset);
    }
}

class WeatherDay {
    private String date;
    private double[] hourlyTemps;

    public WeatherDay(String date, double[] temps) {
        this.date = date;
        // зберігаємо копію, а не посилання
        hourlyTemps = new double[temps.length];
        for (int i = 0; i < temps.length; i++) {
            hourlyTemps[i] = temps[i];
        }
    }

    public double getMinTemp() {
        double min = hourlyTemps[0];
        for (double t : hourlyTemps) if (t < min) min = t;
        return min;
    }

    public double getMaxTemp() {
        double max = hourlyTemps[0];
        for (double t : hourlyTemps) if (t > max) max = t;
        return max;
    }

    public double getAverageTemp() {
        double sum = 0;
        for (double t : hourlyTemps) sum += t;
        return sum / hourlyTemps.length;
    }

    @Override
    public String toString() {
        String s = date + ": [";
        for (int i = 0; i < hourlyTemps.length; i++) {
            s += hourlyTemps[i];
            if (i < hourlyTemps.length - 1) s += ", ";
        }
        return s + String.format("], середня %.2f°C", getAverageTemp());
    }
}

class IntRange {
    private int min;
    private int max;

    public IntRange(int min, int max) {
        update(min, max);
    }

    public void update(int min, int max) {
        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }
        this.min = min;
        this.max = max;
    }

    public boolean contains(int value) {
        return value >= min && value <= max;
    }

    public int getLength() {
        return max - min;
    }

    @Override
    public String toString() {
        return "[" + min + " .. " + max + "] (довжина: " + getLength() + ")";
    }
}

class InvoiceItem {
    private String description;
    private int quantity;
    private double unitPrice;
    private double discountPercent;

    public InvoiceItem(String description, int quantity, double unitPrice, double discountPercent) {
        this.description = description;
        this.quantity = quantity < 0 ? 0 : quantity;
        this.unitPrice = unitPrice < 0 ? 0 : unitPrice;
        if (discountPercent < 0) discountPercent = 0;
        if (discountPercent > 50) discountPercent = 50;
        this.discountPercent = discountPercent;
    }

    public double getFinalAmount() {
        double sum = quantity * unitPrice;
        return sum - sum * discountPercent / 100;
    }

    @Override
    public String toString() {
        return String.format("%s x%d по %.2f грн, знижка %.0f%% = %.2f грн",
                description, quantity, unitPrice, discountPercent, getFinalAmount());
    }
}

class Employee {
    private String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() { return programmingLanguage; }

    @Override
    public String toString() {
        return "Developer{name='" + getName() + "', salary=" + salary + ", lang=" + programmingLanguage + "}";
    }
}

class Animal {
    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + ", " + age + " р., " + weight + " кг";
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, double weight, String breed) {
        super(name, age, weight);
        this.breed = breed;
    }

    public String fetchStick() {
        return getName() + " приніс палицю!";
    }

    @Override
    public String toString() {
        return "Пес " + super.toString() + ", порода: " + breed;
    }
}

class Cat extends Animal {
    private boolean isIndoor;

    public Cat(String name, int age, double weight, boolean isIndoor) {
        super(name, age, weight);
        this.isIndoor = isIndoor;
    }

    public String purr() {
        return getName() + ": мррр-мррр";
    }

    @Override
    public String toString() {
        return "Кіт " + super.toString() + ", " + (isIndoor ? "хатній" : "вуличний");
    }
}

class Vehicle {
    protected String brand;
    protected int maxSpeed;
    protected double fuelTankCapacity;

    public Vehicle(String brand, int maxSpeed, double fuelTankCapacity) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public String toString() {
        return brand + " (до " + maxSpeed + " км/год, бак " + fuelTankCapacity + " л)";
    }
}

class PassengerCar extends Vehicle {
    private int passengerSeats;

    public PassengerCar(String brand, int maxSpeed, double fuelTankCapacity, int passengerSeats) {
        super(brand, maxSpeed, fuelTankCapacity);
        this.passengerSeats = passengerSeats;
    }

    @Override
    public String toString() {
        return "Легковик " + super.toString() + ", місць: " + passengerSeats;
    }
}

class CargoTruck extends Vehicle {
    private double maxLoadTons;

    public CargoTruck(String brand, int maxSpeed, double fuelTankCapacity, double maxLoadTons) {
        super(brand, maxSpeed, fuelTankCapacity);
        this.maxLoadTons = maxLoadTons;
    }

    // базово 22 л/100км + 1.5 л за кожну тонну вантажу
    public double getFullLoadConsumption() {
        return 22 + maxLoadTons * 1.5;
    }

    @Override
    public String toString() {
        return "Вантажівка " + super.toString() + ", вантажопідйомність: " + maxLoadTons + " т";
    }
}

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() { return width; }
    public double getHeight() { return height; }

    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle " + width + "x" + height + ", S=" + getArea();
    }
}

class Box3D extends Rectangle {
    private double depth;

    public Box3D(double width, double height, double depth) {
        super(width, height);
        this.depth = depth;
    }

    public double getVolume() {
        return super.getArea() * depth;
    }

    @Override
    public String toString() {
        return "Box3D " + getWidth() + "x" + getHeight() + "x" + depth + ", V=" + getVolume();
    }
}

class Person {
    private String fullName;
    private int birthYear;

    public Person(String fullName, int birthYear) {
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public String getFullName() { return fullName; }

    public int getAge(int currentYear) {
        return currentYear - birthYear;
    }

    @Override
    public String toString() {
        return fullName + " (" + birthYear + ")";
    }
}

class UniversityStudent extends Person {
    private String studentId;
    private String major;
    private int scholarship;

    public UniversityStudent(String fullName, int birthYear, String studentId, String major, int scholarship) {
        super(fullName, birthYear);
        this.studentId = studentId;
        this.major = major;
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return "Студент " + super.toString() + ", " + studentId + ", " + major + ", стипендія " + scholarship;
    }
}

class Professor extends Person {
    private String academicTitle;
    private int publicationsCount;

    public Professor(String fullName, int birthYear, String academicTitle, int publicationsCount) {
        super(fullName, birthYear);
        this.academicTitle = academicTitle;
        this.publicationsCount = publicationsCount;
    }

    @Override
    public String toString() {
        return "Викладач " + super.toString() + ", " + academicTitle + ", публікацій: " + publicationsCount;
    }
}

class Gadget {
    private String brand;
    private double price;

    public Gadget(String brand, double price) {
        this.brand = brand;
        this.price = price < 0 ? 0 : price;
    }

    public String getBrand() { return brand; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return brand + ", " + price + " грн";
    }
}

class Smartphone extends Gadget {
    private int memoryGb;
    private boolean has5G;

    public Smartphone(String brand, double price, int memoryGb, boolean has5G) {
        super(brand, price);
        this.memoryGb = memoryGb;
        this.has5G = has5G;
    }

    public Smartphone(String brand, double price, int memoryGb) {
        this(brand, price, memoryGb, true);
    }

    public Smartphone(String brand) {
        this(brand, 9999.0, 128, false);
    }

    @Override
    public String toString() {
        return "Smartphone{" + super.toString() + ", " + memoryGb + "GB, 5G: " + (has5G ? "так" : "ні") + "}";
    }
}

class Publication {
    private String title;
    private String author;
    private int releaseYear;

    public Publication(String title, String author, int releaseYear) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" - " + author + " (" + releaseYear + ")";
    }
}

class PrintedBook extends Publication {
    private int pageCount;
    private String coverType;

    public PrintedBook(String title, String author, int releaseYear, int pageCount, String coverType) {
        super(title, author, releaseYear);
        this.pageCount = pageCount;
        this.coverType = coverType;
    }

    @Override
    public String toString() {
        return "Книга " + super.toString() + ", " + pageCount + " стор., обкладинка " + coverType;
    }
}

class AudioBook extends Publication {
    private int durationMinutes;
    private String narrator;

    public AudioBook(String title, String author, int releaseYear, int durationMinutes, String narrator) {
        super(title, author, releaseYear);
        this.durationMinutes = durationMinutes;
        this.narrator = narrator;
    }

    public String getFormattedDuration() {
        return (durationMinutes / 60) + " год " + (durationMinutes % 60) + " хв";
    }

    @Override
    public String toString() {
        return "Аудіокнига " + super.toString() + ", " + getFormattedDuration() + ", читає " + narrator;
    }
}

class Gamer {
    private String nickname;
    private int hoursPlayed;

    public Gamer(String nickname, int hoursPlayed) {
        this.nickname = nickname;
        this.hoursPlayed = hoursPlayed;
    }

    @Override
    public String toString() {
        return "Gamer{" + nickname + ", " + hoursPlayed + " год}";
    }
}

class ProEsportsPlayer extends Gamer {
    private String teamName;
    private double prizeMoneyUSD;
    private int tournamentsWon;

    public ProEsportsPlayer(String nickname, int hoursPlayed, String teamName, double prizeMoneyUSD, int tournamentsWon) {
        super(nickname, hoursPlayed);
        this.teamName = teamName;
        this.prizeMoneyUSD = prizeMoneyUSD;
        this.tournamentsWon = tournamentsWon;
    }

    public double getAveragePrizePerWin() {
        if (tournamentsWon == 0) return 0;
        return prizeMoneyUSD / tournamentsWon;
    }

    @Override
    public String toString() {
        return String.format("Pro%s, команда %s, призові $%.0f, перемог %d, в середньому $%.2f за перемогу",
                super.toString(), teamName, prizeMoneyUSD, tournamentsWon, getAveragePrizePerWin());
    }
}

class StaffMember {
    private String name;
    private double baseSalary;

    public StaffMember(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public double calculateMonthlyPay() {
        return baseSalary;
    }

    @Override
    public String toString() {
        return String.format("%s: ставка %.2f, до виплати %.2f", name, baseSalary, calculateMonthlyPay());
    }
}

class Manager extends StaffMember {
    private double teamBonus;

    public Manager(String name, double baseSalary, double teamBonus) {
        super(name, baseSalary);
        this.teamBonus = teamBonus;
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + teamBonus;
    }

    @Override
    public String toString() {
        return "Менеджер " + super.toString() + " (бонус " + teamBonus + ")";
    }
}

class SalesPerson extends StaffMember {
    private double salesVolume;
    private double commissionRate;

    public SalesPerson(String name, double baseSalary, double salesVolume, double commissionRate) {
        super(name, baseSalary);
        this.salesVolume = salesVolume;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculateMonthlyPay() {
        return super.calculateMonthlyPay() + salesVolume * (commissionRate / 100.0);
    }

    @Override
    public String toString() {
        return "Продавець " + super.toString() + " (продажі " + salesVolume + ", " + commissionRate + "%)";
    }
}

class StandardTransfer {
    protected double amount;

    public StandardTransfer(double amount) {
        this.amount = amount;
    }

    public double getFee() {
        return amount * 0.01;
    }

    public double getTotalWithFee() {
        return amount + getFee();
    }

    @Override
    public String toString() {
        return String.format("Переказ %.2f, комісія %.2f, разом %.2f", amount, getFee(), getTotalWithFee());
    }
}

class InternationalTransfer extends StandardTransfer {
    private static final double SWIFT_FEE = 15.0;
    private String countryCode;

    public InternationalTransfer(double amount, String countryCode) {
        super(amount);
        this.countryCode = countryCode;
    }

    @Override
    public double getFee() {
        return super.getFee() * 2 + SWIFT_FEE;
    }

    @Override
    public String toString() {
        return "Міжнародний [" + countryCode + "] " + super.toString();
    }
}

class Ticket {
    private String eventName;
    private double basePrice;

    public Ticket(String eventName, double basePrice) {
        this.eventName = eventName;
        this.basePrice = basePrice;
    }

    public double getFinalPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return String.format("Квиток на \"%s\": база %.2f, до сплати %.2f", eventName, basePrice, getFinalPrice());
    }
}

class StudentTicket extends Ticket {
    private String studentCardNumber;

    public StudentTicket(String eventName, double basePrice, String studentCardNumber) {
        super(eventName, basePrice);
        this.studentCardNumber = studentCardNumber;
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() * 0.5;
    }

    @Override
    public String toString() {
        return "[СТУДЕНТ " + studentCardNumber + "] " + super.toString();
    }
}

class VipTicket extends Ticket {
    private boolean includesBackstage;
    private double loungeFee;

    public VipTicket(String eventName, double basePrice, boolean includesBackstage, double loungeFee) {
        super(eventName, basePrice);
        this.includesBackstage = includesBackstage;
        this.loungeFee = loungeFee;
    }

    @Override
    public double getFinalPrice() {
        return super.getFinalPrice() + loungeFee;
    }

    @Override
    public String toString() {
        return "[VIP" + (includesBackstage ? " + backstage" : "") + "] " + super.toString();
    }
}

class Weapon {
    private String title;
    private int baseDamage;

    public Weapon(String title, int baseDamage) {
        this.title = title;
        this.baseDamage = baseDamage;
    }

    public String getTitle() { return title; }

    public int calculateDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return title + ": шкода " + calculateDamage();
    }
}

class EnchantedSword extends Weapon {
    private String element;
    private int magicPower;
    private int enchantmentLevel;

    public EnchantedSword(String title, int baseDamage, String element, int magicPower, int enchantmentLevel) {
        super(title, baseDamage);
        this.element = element;
        this.magicPower = magicPower;
        this.enchantmentLevel = enchantmentLevel;
    }

    @Override
    public int calculateDamage() {
        return super.calculateDamage() + magicPower * enchantmentLevel;
    }

    @Override
    public String toString() {
        int physical = super.calculateDamage();
        int magic = magicPower * enchantmentLevel;
        return getTitle() + " [" + element + ", рівень " + enchantmentLevel + "]: фізична " + physical
                + " + магічна " + magic + " (" + magicPower + "x" + enchantmentLevel + ") = " + calculateDamage();
    }
}

class Parcel {
    private String trackingCode;
    private double weightKg;

    public Parcel(String trackingCode, double weightKg) {
        this.trackingCode = trackingCode;
        this.weightKg = weightKg;
    }

    public double calculateShippingCost() {
        return 50.0 + weightKg * 12.0;
    }

    @Override
    public String toString() {
        return String.format("Посилка %s, %.1f кг, доставка %.2f грн", trackingCode, weightKg, calculateShippingCost());
    }
}

class FragileParcel extends Parcel {
    private boolean requiresWoodenBox;
    private double insuranceValue;

    public FragileParcel(String trackingCode, double weightKg, boolean requiresWoodenBox, double insuranceValue) {
        super(trackingCode, weightKg);
        this.requiresWoodenBox = requiresWoodenBox;
        this.insuranceValue = insuranceValue;
    }

    @Override
    public double calculateShippingCost() {
        double cost = super.calculateShippingCost();
        cost += insuranceValue * 0.015;
        if (requiresWoodenBox) cost += 120.0;
        return cost;
    }

    @Override
    public String toString() {
        return "КРИХКЕ! " + super.toString() + " (страховка " + insuranceValue
                + (requiresWoodenBox ? ", обрешітка" : "") + ")";
    }
}

class Appliance {
    private String model;
    private double powerWatts;

    public Appliance(String model, double powerWatts) {
        this.model = model;
        this.powerWatts = powerWatts;
    }

    public double getDailyConsumptionKWh(int hours) {
        return (powerWatts * hours) / 1000.0;
    }

    @Override
    public String toString() {
        return model + " (" + powerWatts + " Вт)";
    }
}

class EcoHeater extends Appliance {
    private boolean ecoModeActive;

    public EcoHeater(String model, double powerWatts, boolean ecoModeActive) {
        super(model, powerWatts);
        this.ecoModeActive = ecoModeActive;
    }

    public void setEcoModeActive(boolean ecoModeActive) {
        this.ecoModeActive = ecoModeActive;
    }

    @Override
    public double getDailyConsumptionKWh(int hours) {
        double base = super.getDailyConsumptionKWh(hours);
        return ecoModeActive ? base * 0.75 : base;
    }

    @Override
    public String toString() {
        return super.toString() + ", еко-режим: " + (ecoModeActive ? "увімк (-25%)" : "вимк");
    }
}

class AirConditioner extends Appliance {
    private boolean inverter;

    public AirConditioner(String model, double powerWatts, boolean inverter) {
        super(model, powerWatts);
        this.inverter = inverter;
    }

    // інверторний економить ~30%
    @Override
    public double getDailyConsumptionKWh(int hours) {
        double base = super.getDailyConsumptionKWh(hours);
        return inverter ? base * 0.7 : base;
    }

    @Override
    public String toString() {
        return super.toString() + (inverter ? ", інверторний" : ", звичайний");
    }
}

class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}

class Point3D extends Point2D {
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double distanceToOrigin() {
        return Math.sqrt(Math.pow(super.distanceToOrigin(), 2) + z * z);
    }

    @Override
    public String toString() {
        return "(" + getX() + "; " + getY() + "; " + z + ")";
    }
}

class Coffee {
    private String roastType;
    private int volumeMl;
    private double basePrice;

    public Coffee(String roastType, int volumeMl, double basePrice) {
        this.roastType = roastType;
        this.volumeMl = volumeMl;
        this.basePrice = basePrice;
    }

    public int getVolumeMl() { return volumeMl; }
    public String getRoastType() { return roastType; }

    // чорна кава ~2 ккал на 100 мл
    public double getCalories() {
        return volumeMl * 0.02;
    }

    public double getPrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return String.format("Кава (%s), %d мл | %.0f ккал | %.2f грн", roastType, volumeMl, getCalories(), getPrice());
    }
}

class LatteWithAddons extends Coffee {
    private String milkType;
    private int syrupPumps;

    public LatteWithAddons(String roastType, int volumeMl, double basePrice, String milkType, int syrupPumps) {
        super(roastType, volumeMl, basePrice);
        this.milkType = milkType;
        this.syrupPumps = syrupPumps;
    }

    private boolean isPlantMilk() {
        return !milkType.equalsIgnoreCase("коров'яче");
    }

    @Override
    public double getCalories() {
        double milkMl = getVolumeMl() * 0.7; // в латте ~70% молока
        double milkKcal = isPlantMilk() ? 0.45 : 0.6;
        return super.getCalories() + milkMl * milkKcal + syrupPumps * 20;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();
        if (isPlantMilk()) price += 20;
        price += syrupPumps * 12;
        return price;
    }

    @Override
    public String toString() {
        String s = "======= ЧЕК =======\n";
        s += "Лате " + getVolumeMl() + " мл (" + getRoastType() + ")\n";
        s += "  молоко: " + milkType + (isPlantMilk() ? " +20 грн" : "") + "\n";
        s += "  сироп: " + syrupPumps + " x 12 грн\n";
        s += String.format("Калорії: %.0f ккал%nДО СПЛАТИ: %.2f грн%n", getCalories(), getPrice());
        s += "===================";
        return s;
    }
}

class DotaHero {
    private String name;
    private String primaryAttribute;
    private int baseHp;

    public DotaHero(String name, String primaryAttribute, int baseHp) {
        this.name = name;
        this.primaryAttribute = primaryAttribute;
        this.baseHp = baseHp;
    }

    public String getName() { return name; }
    public int getBaseHp() { return baseHp; }

    public int getMaxHp() {
        return baseHp;
    }

    @Override
    public String toString() {
        return name + " [" + primaryAttribute + "] HP: " + getMaxHp();
    }
}

class StrengthHero extends DotaHero {
    private int strength;

    public StrengthHero(String name, String primaryAttribute, int baseHp, int strength) {
        super(name, primaryAttribute, baseHp);
        this.strength = strength;
    }

    @Override
    public int getMaxHp() {
        return super.getMaxHp() + strength * 22;
    }

    @Override
    public String toString() {
        return super.toString() + ", сила: " + strength;
    }
}

class AlchemistHero extends StrengthHero {
    private int greevilsGreedBonusGold;

    public AlchemistHero(String name, int baseHp, int strength, int greevilsGreedBonusGold) {
        super(name, "Strength", baseHp, strength);
        this.greevilsGreedBonusGold = greevilsGreedBonusGold;
    }

    public void chemicalRage() {
        System.out.println(getName() + " використовує Chemical Rage! Регенерація та швидкість атаки зросли!");
    }

    @Override
    public String toString() {
        return super.toString() + ", Greevil's Greed: +" + greevilsGreedBonusGold + " золота";
    }
}

class BaseVehicle {
    private String brand;
    private int year;

    public BaseVehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    @Override
    public String toString() {
        return brand + " " + year;
    }
}

class MotorCar extends BaseVehicle {
    private int horsePower;
    private int doorsCount;

    public MotorCar(String brand, int year, int horsePower, int doorsCount) {
        super(brand, year);
        this.horsePower = horsePower;
        this.doorsCount = doorsCount;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + horsePower + " к.с., дверей: " + doorsCount;
    }
}

class ElectricCar extends MotorCar {
    private double batteryCapacityKWh;
    private int rangeKm;

    public ElectricCar(String brand, int year, int horsePower, int doorsCount, double batteryCapacityKWh, int rangeKm) {
        super(brand, year, horsePower, doorsCount);
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.rangeKm = rangeKm;
    }

    @Override
    public String toString() {
        return "Електро: " + super.toString() + ", батарея " + batteryCapacityKWh + " кВт*год, запас ходу " + rangeKm + " км";
    }
}

class PaymentCard {
    private String cardHolder;
    protected double balance;

    public PaymentCard(String cardHolder, double balance) {
        this.cardHolder = cardHolder;
        this.balance = balance;
    }

    public String getCardHolder() { return cardHolder; }

    public boolean pay(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Картка %s, баланс %.2f", cardHolder, balance);
    }
}

class DebitCard extends PaymentCard {
    private double dailyLimit;

    public DebitCard(String cardHolder, double balance, double dailyLimit) {
        super(cardHolder, balance);
        this.dailyLimit = dailyLimit;
    }

    @Override
    public boolean pay(double amount) {
        if (amount > dailyLimit) {
            System.out.println("  перевищено денний ліміт " + dailyLimit);
            return false;
        }
        return super.pay(amount);
    }

    @Override
    public String toString() {
        return super.toString() + ", ліміт " + dailyLimit;
    }
}

class CashbackPlatinumCard extends DebitCard {
    private double cashbackPercent;
    private double accumulatedCashback;

    public CashbackPlatinumCard(String cardHolder, double balance, double dailyLimit, double cashbackPercent) {
        super(cardHolder, balance, dailyLimit);
        this.cashbackPercent = cashbackPercent;
    }

    @Override
    public boolean pay(double amount) {
        boolean ok = super.pay(amount);
        if (ok) accumulatedCashback += amount * cashbackPercent / 100;
        return ok;
    }

    @Override
    public String toString() {
        return "Platinum " + super.toString() + String.format(", кешбек %.1f%% (накопичено %.2f)", cashbackPercent, accumulatedCashback);
    }
}

class SecurityTerminal {
    public final String generateAuthHash(String user) {
        return "AUTH-SHA-" + user.toUpperCase();
    }

    public String getWelcomeBanner() {
        return "Ласкаво просимо до терміналу.";
    }
}

class CustomTerminal extends SecurityTerminal {
    private String terminalName;

    public CustomTerminal(String terminalName) {
        this.terminalName = terminalName;
    }

    @Override
    public String getWelcomeBanner() {
        return "*** " + terminalName + " *** Вітаємо!";
    }

    // @Override
    // public String generateAuthHash(String user) { return "hacked"; }
    // ^ не скомпілюється: метод у батьківському класі оголошений як final,
    // а final-методи заборонено перевизначати (cannot override; overridden method is final).
    // Так захищається логіка безпеки - нащадок не може підмінити алгоритм хешу.
}

// public тут не можна, бо в одному файлі лише один public клас (Practice08)
final class ImmutableServerCredentials {
    private final String host;
    private final int port;
    private final String apiKey;

    public ImmutableServerCredentials(String host, int port, String apiKey) {
        this.host = host;
        this.port = port;
        this.apiKey = apiKey;
    }

    public String getHost() { return host; }
    public int getPort() { return port; }
    public String getApiKey() { return apiKey; }

    @Override
    public String toString() {
        return "Credentials{host='" + host + "', port=" + port + ", apiKey='***SECRET***'}";
    }
}

// class HackedCredentials extends ImmutableServerCredentials {}
// -> помилка: cannot inherit from final ImmutableServerCredentials

class Segment1D {
    protected double length;

    public Segment1D(double length) {
        this.length = length > 0 ? length : 1;
    }

    @Override
    public String toString() {
        return "Відрізок довжиною " + length;
    }
}

class Square2D extends Segment1D {
    public Square2D(double side) {
        super(side);
    }

    public double getPerimeter() {
        return 4 * length;
    }

    public double getArea() {
        return length * length;
    }

    @Override
    public String toString() {
        return "Квадрат зі стороною " + length + ": P=" + getPerimeter() + ", S=" + getArea();
    }
}

class Cube3D extends Square2D {
    public Cube3D(double side) {
        super(side);
    }

    // площа повної поверхні
    @Override
    public double getArea() {
        return 6 * super.getArea();
    }

    public double getVolume() {
        return length * length * length;
    }

    @Override
    public String toString() {
        return "Куб з ребром " + length + ": S повн=" + getArea() + ", V=" + getVolume();
    }
}

class User {
    private int id;
    private String email;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "#" + id + " " + email;
    }
}

class StudentUser extends User {
    private String groupCode;
    private double gpa;

    public StudentUser(int id, String email, String groupCode, double gpa) {
        super(id, email);
        this.groupCode = groupCode;
        this.gpa = gpa;
    }

    public double getGpa() { return gpa; }

    @Override
    public String toString() {
        return super.toString() + ", група " + groupCode + ", бал " + gpa;
    }
}

class PostgraduateStudent extends StudentUser {
    private String thesisTopic;
    private String supervisorName;

    public PostgraduateStudent(int id, String email, String groupCode, double gpa, String thesisTopic, String supervisorName) {
        super(id, email, groupCode, gpa);
        this.thesisTopic = thesisTopic;
        this.supervisorName = supervisorName;
    }

    public boolean isAdmittedToDefense() {
        return getGpa() >= 85.0 && thesisTopic != null && !thesisTopic.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "Аспірант " + super.toString()
                + "\n   тема: " + (thesisTopic.isEmpty() ? "(не обрано)" : thesisTopic)
                + "\n   керівник: " + supervisorName
                + "\n   допуск до захисту: " + (isAdmittedToDefense() ? "ТАК" : "НІ");
    }
}

class Medicine {
    private String name;
    private double price;
    private boolean isExpired;

    public Medicine(String name, double price, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.isExpired = isExpired;
    }

    public boolean isExpired() { return isExpired; }

    @Override
    public String toString() {
        return name + ", " + price + " грн" + (isExpired ? " (ПРОСТРОЧЕНО)" : "");
    }
}

class PrescriptionMedicine extends Medicine {
    private String doctorLicense;

    public PrescriptionMedicine(String name, double price, boolean isExpired, String doctorLicense) {
        super(name, price, isExpired);
        this.doctorLicense = doctorLicense;
    }

    public boolean canSell(boolean hasPrescription) {
        return !isExpired() && hasPrescription;
    }

    @Override
    public String toString() {
        return super.toString() + ", за рецептом (ліцензія " + doctorLicense + ")";
    }
}

class ControlledSubstance extends PrescriptionMedicine {
    private int patientAge;

    public ControlledSubstance(String name, double price, boolean isExpired, String doctorLicense, int patientAge) {
        super(name, price, isExpired, doctorLicense);
        this.patientAge = patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    @Override
    public boolean canSell(boolean hasPrescription) {
        return super.canSell(hasPrescription) && patientAge >= 18;
    }

    @Override
    public String toString() {
        return super.toString() + ", контрольована речовина, вік пацієнта " + patientAge;
    }
}

class Progression {
    protected double firstTerm;
    protected double step;

    public Progression(double firstTerm, double step) {
        this.firstTerm = firstTerm;
        this.step = step;
    }

    // в базовому класі просто повертаємо перший член, нащадки перевизначають
    public double getTerm(int index) {
        return firstTerm;
    }

    public double[] generateFirstN(int n) {
        double[] res = new double[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = getTerm(i);
        }
        return res;
    }

    protected String firstFiveAsString() {
        double[] arr = generateFirstN(5);
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            if (i < arr.length - 1) s += ", ";
        }
        return s;
    }

    @Override
    public String toString() {
        return "Прогресія: " + firstFiveAsString();
    }
}

class ArithmeticProgression extends Progression {
    public ArithmeticProgression(double a1, double d) {
        super(a1, d);
    }

    @Override
    public double getTerm(int n) {
        return firstTerm + (n - 1) * step;
    }

    @Override
    public String toString() {
        return "Арифметична: a_n = " + firstTerm + " + (n-1)*" + step + " -> " + firstFiveAsString() + ", ...";
    }
}

class GeometricProgression extends Progression {
    public GeometricProgression(double b1, double q) {
        super(b1, q);
    }

    @Override
    public double getTerm(int n) {
        return firstTerm * Math.pow(step, n - 1);
    }

    @Override
    public String toString() {
        return "Геометрична: b_n = " + firstTerm + " * " + step + "^(n-1) -> " + firstFiveAsString() + ", ...";
    }
}

class GradeSheet {
    private String studentName;
    protected int[] grades;

    public GradeSheet(String studentName, int[] grades) {
        this.studentName = studentName;
        this.grades = grades;
    }

    public double calculateScore() {
        if (grades.length == 0) return 0;
        double sum = 0;
        for (int g : grades) sum += g;
        return sum / grades.length;
    }

    @Override
    public String toString() {
        return String.format("%s: середній бал %.2f", studentName, calculateScore());
    }
}

class WeightedGradeSheet extends GradeSheet {
    private double[] weights;

    public WeightedGradeSheet(String studentName, int[] grades, double[] weights) {
        super(studentName, grades);
        if (weights.length != grades.length) {
            System.out.println("Кількість ваг не збігається з кількістю оцінок, ставлю всі ваги = 1");
            weights = new double[grades.length];
            for (int i = 0; i < weights.length; i++) weights[i] = 1;
        }
        this.weights = weights;
    }

    @Override
    public double calculateScore() {
        double sum = 0, wSum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i] * weights[i];
            wSum += weights[i];
        }
        return wSum == 0 ? 0 : sum / wSum;
    }

    @Override
    public String toString() {
        return super.toString() + " (зважений)";
    }
}

class LinearFunction {
    protected double k;
    protected double b;

    public LinearFunction(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public double evaluate(double x) {
        return k * x + b;
    }

    @Override
    public String toString() {
        return "f(x) = " + k + "x + " + b;
    }
}

class QuadraticFunction extends LinearFunction {
    private double a;

    public QuadraticFunction(double a, double k, double b) {
        super(k, b);
        if (a == 0) {
            System.out.println("a = 0 - це вже не парабола, ставлю a = 1");
            a = 1;
        }
        this.a = a;
    }

    @Override
    public double evaluate(double x) {
        return a * x * x + super.evaluate(x);
    }

    public double getVertexX() {
        return -k / (2 * a);
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + k + "x + " + b;
    }
}

class WarehouseItem {
    private String name;
    private int quantity;
    private double[] priceHistory;

    public WarehouseItem(String name, int quantity, double[] priceHistory) {
        this.name = name;
        this.quantity = quantity;
        this.priceHistory = new double[priceHistory.length];
        for (int i = 0; i < priceHistory.length; i++) this.priceHistory[i] = priceHistory[i];
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    public double getAveragePurchasePrice() {
        if (priceHistory.length == 0) return 0;
        double sum = 0;
        for (double p : priceHistory) sum += p;
        return sum / priceHistory.length;
    }

    @Override
    public String toString() {
        return String.format("%s: %d шт., середня закупівельна %.2f грн", name, quantity, getAveragePurchasePrice());
    }
}

class DiscountedWarehouseItem extends WarehouseItem {
    private String markdownReason;
    private double discountPercent;

    public DiscountedWarehouseItem(String name, int quantity, double[] priceHistory, String markdownReason, double discountPercent) {
        super(name, quantity, priceHistory);
        this.markdownReason = markdownReason;
        this.discountPercent = discountPercent;
    }

    public double getSalePrice() {
        return getAveragePurchasePrice() * (1 - discountPercent / 100);
    }

    public double getTotalSaleValue() {
        return getSalePrice() * getQuantity();
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n   УЦІНКА -%.0f%% (%s): ціна %.2f, вся партія %.2f грн",
                discountPercent, markdownReason, getSalePrice(), getTotalSaleValue());
    }
}

class CinemaHall {
    private String hallName;
    protected boolean[][] seats;
    protected double baseTicketPrice;

    public CinemaHall(String hallName, int rows, int cols, double baseTicketPrice) {
        this.hallName = hallName;
        this.seats = new boolean[rows][cols];
        this.baseTicketPrice = baseTicketPrice;
    }

    public boolean bookSeat(int row, int col) {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            System.out.println("Місця " + (row + 1) + "-" + (col + 1) + " не існує");
            return false;
        }
        if (seats[row][col]) {
            System.out.println("Місце " + (row + 1) + "-" + (col + 1) + " вже зайняте");
            return false;
        }
        seats[row][col] = true;
        return true;
    }

    public int getOccupiedCount() {
        int count = 0;
        for (boolean[] row : seats)
            for (boolean s : row)
                if (s) count++;
        return count;
    }

    public double calculateRevenue() {
        return getOccupiedCount() * baseTicketPrice;
    }

    @Override
    public String toString() {
        String s = "=== " + hallName + " ===\n";
        for (int i = 0; i < seats.length; i++) {
            s += "Ряд " + (i + 1) + ": ";
            for (int j = 0; j < seats[i].length; j++) {
                s += seats[i][j] ? "[X]" : "[O]";
            }
            s += "\n";
        }
        s += "Зайнято: " + getOccupiedCount() + ", виручка: " + calculateRevenue() + " грн";
        return s;
    }
}

class VipCinemaHall extends CinemaHall {
    private double complimentaryBarCost;

    public VipCinemaHall(String hallName, int rows, int cols, double baseTicketPrice, double complimentaryBarCost) {
        super(hallName, rows, cols, baseTicketPrice);
        this.complimentaryBarCost = complimentaryBarCost;
    }

    @Override
    public double calculateRevenue() {
        double revenue = super.calculateRevenue();
        boolean[] lastRow = seats[seats.length - 1];
        for (boolean s : lastRow) {
            if (s) revenue += complimentaryBarCost;
        }
        return revenue;
    }
}

class TeamLead extends Developer {
    private Developer[] teamMembers;
    private int memberCount;

    public TeamLead(String name, double salary, String programmingLanguage, int maxTeamSize) {
        super(name, salary, programmingLanguage);
        teamMembers = new Developer[maxTeamSize];
    }

    public void addTeamMember(Developer dev) {
        if (memberCount >= teamMembers.length) {
            System.out.println("Команда вже повна!");
            return;
        }
        teamMembers[memberCount++] = dev;
    }

    public double getTotalTeamBudget() {
        double total = salary;
        for (int i = 0; i < memberCount; i++) total += teamMembers[i].getSalary();
        return total;
    }

    @Override
    public String toString() {
        String s = "TeamLead " + getName() + " (" + getProgrammingLanguage() + ", " + salary + ")\n";
        s += "Команда (" + memberCount + "):\n";
        for (int i = 0; i < memberCount; i++) {
            s += "  - " + teamMembers[i] + "\n";
        }
        s += "Бюджет команди: " + getTotalTeamBudget();
        return s;
    }
}

class CharacterUnit {
    private String name;
    protected int hp;
    protected int maxHp;
    protected int armor;

    public CharacterUnit(String name, int maxHp, int armor) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.armor = armor;
    }

    public void takeDamage(int rawDamage) {
        hp -= Math.max(1, rawDamage - armor);
        if (hp < 0) hp = 0;
    }

    protected String hpBar() {
        int filled = hp * 10 / maxHp;
        String bar = "[";
        for (int i = 0; i < 10; i++) bar += i < filled ? "█" : "░";
        return bar + "]";
    }

    @Override
    public String toString() {
        return name + " " + hpBar() + " " + hp + "/" + maxHp;
    }
}

class ShieldedPaladin extends CharacterUnit {
    private int shieldPoints;

    public ShieldedPaladin(String name, int maxHp, int armor, int shieldPoints) {
        super(name, maxHp, armor);
        this.shieldPoints = shieldPoints;
    }

    @Override
    public void takeDamage(int rawDamage) {
        if (shieldPoints > 0) {
            int absorbed = Math.min(shieldPoints, rawDamage);
            shieldPoints -= absorbed;
            rawDamage -= absorbed;
        }
        if (shieldPoints == 0 && rawDamage > 0) {
            super.takeDamage(rawDamage);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | щит: " + (shieldPoints > 0 ? shieldPoints : "пробито");
    }
}
