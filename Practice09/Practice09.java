package semester1.practice09;

import java.util.Arrays;

// головний клас
public class Practice09 {
    public static void main(String[] args) {

        // ===== Завдання 1 =====
        ImmutableGeoPoint kyiv = new ImmutableGeoPoint(50.45, 30.52);
        ImmutableGeoPoint moved = kyiv.shift(1.5, -2.0);
        ImmutableGeoPoint wrong = new ImmutableGeoPoint(120, -500);
        System.out.println(kyiv);
        System.out.println(moved);
        System.out.println(wrong);
        System.out.println("Старий об'єкт не змінився: " + kyiv);

        // ===== Завдання 2 =====
        double[] raw = {1.25, 1.31, 1.28, 1.40};
        LabMeasurement lab = new LabMeasurement("Опір дроту", raw);
        raw[0] = 999;
        double[] got = lab.getSamples();
        got[1] = -1;
        System.out.println("Зовнішній масив: " + Arrays.toString(raw));
        System.out.println("Масив з геттера: " + Arrays.toString(got));
        System.out.println("Всередині об'єкта: " + Arrays.toString(lab.getSamples()));

        // ===== Завдання 3 =====
        CryptoVault vault = new CryptoVault("bc1qxy2kgdygjrsqtzq2n0yrf2493p83kkfjhx0wlh", "apple river moon stone", 0.75);
        System.out.println(vault);
        System.out.println("Відправка в заблокованому стані: " + vault.sendBtc(0.1, "bc1qdest"));
        System.out.println("Unlock з неправильною фразою: " + vault.unlock("wrong words"));
        System.out.println("Unlock: " + vault.unlock("apple river moon stone"));
        System.out.println("Відправка 0.1: " + vault.sendBtc(0.1, "bc1qdest"));
        System.out.println("Відправка 5: " + vault.sendBtc(5, "bc1qdest"));
        vault.lock();
        System.out.println(vault);

        // ===== Завдання 4 =====
        ClosedInterval i1 = new ClosedInterval(10, 2);
        ClosedInterval i2 = new ClosedInterval(8, 15);
        ClosedInterval i3 = new ClosedInterval(20, 25);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println("i1 і i2 перетинаються: " + i1.overlaps(i2));
        System.out.println("i1 і i3 перетинаються: " + i1.overlaps(i3));
        i3.resize(30, -5);
        System.out.println("i3 після resize: " + i3);

        // ===== Завдання 5 =====
        RgbColor orange = new RgbColor(255, 140, 0);
        RgbColor blue = new RgbColor(0, 87, 300);
        System.out.println(orange);
        System.out.println(blue);
        System.out.println("Інверсія помаранчевого: " + orange.invert());
        System.out.println("Змішування: " + orange.mixWith(blue));

        // ===== Завдання 6 =====
        HighSecuritySafe safe = new HighSecuritySafe(4321, 5000);
        System.out.println("Покласти 1000 (вірний PIN): " + safe.putCash(4321, 1000));
        System.out.println("Взяти 2000 (вірний PIN): " + safe.takeCash(4321, 2000));
        System.out.println("Спроба 1111: " + safe.takeCash(1111, 100));
        System.out.println("Спроба 2222: " + safe.takeCash(2222, 100));
        System.out.println("Спроба 3333: " + safe.takeCash(3333, 100));
        System.out.println("Тепер навіть вірний PIN: " + safe.takeCash(4321, 100));
        System.out.println(safe);

        // ===== Завдання 7 =====
        double[] c = {1, -3, 0, 2};
        EncapsulatedPolynomial poly = new EncapsulatedPolynomial(c);
        c[3] = 100;
        System.out.println(poly);
        System.out.println("Степінь: " + poly.getDegree());
        System.out.println("Коеф. при x^1: " + poly.getCoefficient(1) + ", при x^10: " + poly.getCoefficient(10));
        System.out.println("P(2) = " + poly.evaluate(2));

        // ===== Завдання 8 =====
        String[] allergies = {"Пеніцилін", "Пилок"};
        MedicalRecord rec = new MedicalRecord("PT-00731", "Савчук Ірина", 2, true, allergies);
        allergies[0] = "Нічого";
        System.out.println(rec);
        System.out.println("Алергія на пеніцилін: " + rec.hasAllergyTo("пеніцилін"));
        System.out.println("Алергія на лактозу: " + rec.hasAllergyTo("лактоза"));

        // ===== Завдання 9 =====
        CompositeCircle circle = new CompositeCircle(0, 0, 5);
        System.out.println(circle);
        System.out.println("(3; 4) всередині: " + circle.containsPoint(new Point2D(3, 4)));
        System.out.println("(4; 4) всередині: " + circle.containsPoint(new Point2D(4, 4)));

        // ===== Завдання 10 =====
        Automobile auto = new Automobile("Mazda 3", new Engine("Бензин", 1998));
        auto.accelerate(40);
        auto.startEngine();
        auto.accelerate(40);
        auto.accelerate(60);
        System.out.println(auto);

        // ===== Завдання 11 =====
        SmartDevice phone = new SmartDevice("Pixel 8", new Battery(4500, 30), new Display(6.2, 90));
        System.out.println(phone);
        phone.watchVideo(60);
        System.out.println(phone);
        phone.setBrightness(40);
        phone.watchVideo(300);
        System.out.println(phone);

        // ===== Завдання 12 =====
        Point2D a = new Point2D(1, 2);
        Point2D b = new Point2D(7, 10);
        LineSegment segment = new LineSegment(a, b);
        a.move(100, 100);
        System.out.println(segment);
        System.out.println("Середина: " + segment.getMidpoint());

        // ===== Завдання 13 =====
        BankAccount family = new BankAccount("UA213223130000026007233566001", 15000);
        PlasticCard dadCard = new PlasticCard("5375 4141 0000 1111", "09/28", family);
        PlasticCard sonCard = new PlasticCard("5375 4141 0000 2222", "09/28", family);
        System.out.println("Тато платить 4000: " + dadCard.payAtTerminal(4000));
        System.out.println("Син платить 2500: " + sonCard.payAtTerminal(2500));
        sonCard.block();
        System.out.println("Син (картку заблоковано) платить 100: " + sonCard.payAtTerminal(100));
        System.out.println(family);

        // ===== Завдання 14 =====
        HeroCharacter hero = new HeroCharacter("Ведмідь", 20);
        System.out.println("Удар без зброї: " + hero.attack());
        hero.equip(new WeaponItem("Бойова сокира", 15, 30));
        for (int i = 0; i < 4; i++) System.out.println("Удар із сокирою: " + hero.attack());
        hero.unequip();
        System.out.println(hero);

        // ===== Завдання 15 =====
        ParcelOrder po = new ParcelOrder("ORD-7781", 2.4, new DeliveryAddress("Львів", "вул. Городоцька, 12", 5));
        System.out.println(po);
        System.out.println("Зміна адреси: " + po.changeDestination(new DeliveryAddress("Київ", "вул. Хрещатик, 1", 1)));
        po.markAsShipped();
        System.out.println("Зміна адреси після відправки: " + po.changeDestination(new DeliveryAddress("Одеса", "вул. Дерибасівська, 3", 2)));
        System.out.println(po);

        // ===== Завдання 16 =====
        TemperatureSensor sensorT = new TemperatureSensor(18.0);
        ClimateController climate = new ClimateController(sensorT, new HeatingUnit(2.0), 21.0);
        climate.regulate();
        System.out.println(climate);
        sensorT.setCurrentTemp(20.8);
        climate.regulate();
        System.out.println(climate);
        sensorT.setCurrentTemp(21.3);
        climate.regulate();
        System.out.println(climate);

        // ===== Завдання 17 =====
        Polyline line = new Polyline(10);
        line.addVertex(0, 0);
        line.addVertex(3, 0);
        line.addVertex(3, 4);
        System.out.println("Довжина ламаної: " + line.getTotalLength());
        System.out.println("Периметр замкненої: " + line.getClosedPerimeter());

        // ===== Завдання 18 =====
        ShoppingOrder cart = new ShoppingOrder();
        cart.addItem("Хліб", 32.50, 2);
        cart.addItem("Молоко 2.5%", 41.90, 1);
        cart.addItem("Сир твердий", 189.00, 1);
        cart.addItem("Хліб", 32.50, 1);
        System.out.println(cart);

        // ===== Завдання 19 =====
        Bookshelf shelf = new Bookshelf("Українська класика", 3);
        shelf.putBook(new BookItem("Тигролови", "Іван Багряний", 304));
        shelf.putBook(new BookItem("Місто", "Валер'ян Підмогильний", 416));
        shelf.putBook(new BookItem("Intermezzo", "Михайло Коцюбинський", 32));
        System.out.println("Ще одна книга: " + shelf.putBook(new BookItem("Зачарована Десна", "Олександр Довженко", 96)));
        System.out.println("null: " + shelf.putBook(null));
        System.out.println("Найтовстіша: " + shelf.findLongestBook());
        System.out.println("Всього сторінок: " + shelf.getTotalPagesOnShelf());

        // ===== Завдання 20 =====
        Playlist pl = new Playlist("Для дороги", 10);
        pl.addTrack(new AudioTrack("Обійми", "Океан Ельзи", 245));
        pl.addTrack(new AudioTrack("Стефанія", "Kalush Orchestra", 177));
        pl.addTrack(new AudioTrack("Шум", "Go_A", 182));
        System.out.println(pl);

        // ===== Завдання 21 =====
        DataCenterCluster cluster = new DataCenterCluster("Київ-DC1", 5);
        cluster.addNode(new ServerNode("10.0.0.1", 32, 28));
        ServerNode offlineNode = new ServerNode("10.0.0.2", 64, 0);
        offlineNode.setOnline(false);
        cluster.addNode(offlineNode);
        cluster.addNode(new ServerNode("10.0.0.3", 64, 16));
        System.out.println("Контейнер 8GB: " + cluster.deployContainer(8));
        System.out.println("Контейнер 40GB: " + cluster.deployContainer(40));
        System.out.println("Контейнер 16GB: " + cluster.deployContainer(16));
        System.out.println(cluster);

        // ===== Завдання 22 =====
        UniversityCourse course = new UniversityCourse("Об'єктно-орієнтоване програмування", 5);
        course.addModule(new CourseModule("Класи та об'єкти", 16, 16, 30));
        course.addModule(new CourseModule("Наслідування", 14, 16, 35));
        course.addModule(new CourseModule("Абстракція та композиція", 14, 14, 35));
        System.out.println(course);

        // ===== Завдання 23 =====
        PassengerTrain train = new PassengerTrain("Київ - Ужгород", 10);
        train.attachCarriage(new TrainCarriage(1, "Інтерсіті", 60));
        train.attachCarriage(new TrainCarriage(2, "Купе", 36));
        train.attachCarriage(new TrainCarriage(3, "Плацкарт", 54));
        System.out.println("Вільних місць: " + train.getTotalFreeSeats());
        System.out.println("Бронь 4 місць у вагоні 2: " + train.bookTicketsInCarriage(2, 4));
        System.out.println("Бронь 40 місць у вагоні 2: " + train.bookTicketsInCarriage(2, 40));
        System.out.println("Бронь у вагоні 9: " + train.bookTicketsInCarriage(9, 1));
        System.out.println("Вільних місць: " + train.getTotalFreeSeats());

        // ===== Завдання 24 =====
        EquationSystem sys = new EquationSystem(3);
        sys.addEquation(new LinearEquation(2, 3, 13));
        sys.addEquation(new LinearEquation(1, -1, -1));
        System.out.println(sys);
        System.out.println("(2; 3) розв'язок: " + sys.checkSolution(2, 3));
        System.out.println("(5; 1) розв'язок: " + sys.checkSolution(5, 1));

        // ===== Завдання 25 =====
        AbstractShape sh1 = new CircleShape("Червоний", 3);
        AbstractShape sh2 = new RectangleShape("Синій", 4, 6);
        System.out.println(sh1);
        System.out.println(sh2);

        // ===== Завдання 26 =====
        AbstractPowerPlant solar = new SolarPowerPlant("СЕС Нікопольська", 200, 0.65);
        AbstractPowerPlant wind = new WindPowerPlant("ВЕС Ботієвська", 200, 9);
        AbstractPowerPlant storm = new WindPowerPlant("ВЕС Приморська", 200, 28);
        double tariff = 4500;
        System.out.println(solar + String.format(" | прибуток за добу: %.0f грн", solar.calculateDailyProfit(tariff)));
        System.out.println(wind + String.format(" | прибуток за добу: %.0f грн", wind.calculateDailyProfit(tariff)));
        System.out.println(storm + String.format(" | прибуток за добу: %.0f грн", storm.calculateDailyProfit(tariff)));

        // ===== Завдання 27 =====
        AbstractEmployee e1 = new SalariedEmployee(1, "Гнатюк Олена", 42000, 5000);
        AbstractEmployee e2 = new HourlyContractor(2, "Литвиненко Богдан", 180, 300);
        System.out.println(e1);
        System.out.println(e2);

        // ===== Завдання 28 =====
        AbstractSequence harm = new HarmonicSequence();
        AbstractSequence squares = new SquareNumbersSequence();
        System.out.printf("%s: S10 = %.4f%n", harm.getTitle(), harm.sumFirstN(10));
        System.out.printf("%s: S10 = %.0f (за формулою n(n+1)(2n+1)/6 = %d)%n", squares.getTitle(), squares.sumFirstN(10), 10 * 11 * 21 / 6);

        // ===== Завдання 29 =====
        AbstractTransaction tx1 = new DomesticTransfer("TX-001", 500);
        AbstractTransaction tx2 = new DomesticTransfer("TX-002", 20000);
        AbstractTransaction tx3 = new CryptoTransfer("TX-003", 20000, 37.5);
        System.out.println(tx1);
        System.out.println(tx2);
        System.out.println(tx3);

        // ===== Завдання 30 =====
        Solid3D goldBall = new Sphere3D("Золото", 19300, 0.05);
        Solid3D steelPipe = new Cylinder3D("Сталь", 7850, 0.1, 2.0);
        System.out.println(goldBall);
        System.out.println(steelPipe);

        // ===== Завдання 31 =====
        PressureSensor boiler = new PressureSensor("Котельня", 1.0, 3.0, 2.4, 1.05);
        RadiationSensor reactorHall = new RadiationSensor("Реакторний зал", 0.0, 0.3, 0.12);
        System.out.println(boiler);
        System.out.println(reactorHall);
        boiler.setRawPressure(3.1);
        System.out.println(boiler);

        // ===== Завдання 32 =====
        AbstractCompressor zip = new ZipCompressor();
        AbstractCompressor lzma = new UltraLzmaCompressor();
        int[] sizes = {200, 10_000, 5_000_000};
        for (int size : sizes) {
            System.out.printf("%d байт -> %s: %d (%.1f%%), %s: %d (%.1f%%)%n", size,
                    zip.getAlgorithmName(), zip.estimateCompressedSize(size), zip.getCompressionRatio(size),
                    lzma.getAlgorithmName(), lzma.estimateCompressedSize(size), lzma.getCompressionRatio(size));
        }

        // ===== Завдання 33 =====
        DesktopPC pc = new DesktopPC("Ігрова збірка", 650, 6);
        pc.installPart(new ProcessorPart("Ryzen 7 7700", 12500, 8, 105));
        pc.installPart(new VideoCardPart("RTX 4070", 26000, 12, 200));
        System.out.println(pc);
        pc.installPart(new VideoCardPart("RTX 4070 (друга)", 26000, 12, 200));
        System.out.println(pc);

        // ===== Завдання 34 =====
        Spacecraft ship = new Spacecraft("Дніпро-1", 12.5, 4);
        ship.addThruster(new ChemicalThruster("CH-A", 120, 38));
        ship.addThruster(new ChemicalThruster("CH-B", 120, 38));
        ship.addThruster(new IonThruster("ION-1", 7.5));
        System.out.println(ship);

        // ===== Завдання 35 =====
        LandPlot plot = new LandPlot(600, 10);
        System.out.println("Будинок 10x12: " + plot.addStructure(new RectangleShape("Сірий", 10, 12)));
        System.out.println("Клумба r=3: " + plot.addStructure(new CircleShape("Зелений", 3)));
        System.out.println("Гараж 6x8: " + plot.addStructure(new RectangleShape("Білий", 6, 8)));
        System.out.println("Басейн 20x10: " + plot.addStructure(new RectangleShape("Блакитний", 20, 10)));
        System.out.println(plot);

        // ===== Завдання 36 =====
        InvestmentPortfolio portfolio = new InvestmentPortfolio("Тарас Б.", 5);
        portfolio.addAsset(new GovernmentBond("ОВДП-UA4000227045", 100000, 15.5));
        portfolio.addAsset(new DividendStock("AAPL", 60000, 8.0, 0.5));
        portfolio.addAsset(new DividendStock("KO", 40000, 3.0, 3.1));
        System.out.println(portfolio);

        // ===== Завдання 37 =====
        RaidParty party = new RaidParty("Козаки Вальгалли", 5);
        party.addMember(new ArcaneMage("Мольфар", 80, 45, 60));
        party.addMember(new ArcaneMage("Відьма", 70, 40, 75));
        System.out.println(party);
        System.out.println("Готові до підземелля 300: " + party.isReadyForRaid(300));
        party.addMember(new TankWarrior("Богатир", 900, 35));
        System.out.println(party);
        System.out.println("Готові до підземелля 300: " + party.isReadyForRaid(300));
        System.out.println("Готові до підземелля 1000: " + party.isReadyForRaid(1000));

        // ===== Завдання 38 =====
        SmartLab smartLab = new SmartLab("Лабораторія №4", 5);
        PressureSensor chamber = new PressureSensor("Барокамера", 0.8, 1.5, 1.1, 1.0);
        RadiationSensor storage = new RadiationSensor("Сховище зразків", 0.0, 0.5, 0.2);
        smartLab.addSensor(chamber);
        smartLab.addSensor(storage);
        smartLab.runDiagnostics();
        storage.setLevel(2.7);
        smartLab.runDiagnostics();

        // ===== Завдання 39 =====
        double[] signal = {0.2, -0.5, 1.1, -1.8, 0.9, 0.05};
        SignalProcessor dsp = new SignalProcessor(3);
        dsp.addFilter(new AmplifierFilter(2.0));
        dsp.addFilter(new ClippingFilter(2.5));
        double[] result = dsp.process(signal);
        System.out.println(dsp);
        System.out.println("Вхід:  " + Arrays.toString(signal));
        System.out.println("Вихід: " + Arrays.toString(result));
    }
}

// класи завдань

class ImmutableGeoPoint {
    private final double latitude;
    private final double longitude;

    public ImmutableGeoPoint(double latitude, double longitude) {
        this.latitude = Math.max(-90.0, Math.min(90.0, latitude));
        this.longitude = Math.max(-180.0, Math.min(180.0, longitude));
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    public ImmutableGeoPoint shift(double dLat, double dLon) {
        return new ImmutableGeoPoint(latitude + dLat, longitude + dLon);
    }

    @Override
    public String toString() {
        return String.format("GeoPoint(%.4f; %.4f)", latitude, longitude);
    }
}

class LabMeasurement {
    private final String experimentName;
    private final double[] samples;

    public LabMeasurement(String experimentName, double[] samples) {
        this.experimentName = experimentName;
        this.samples = samples == null ? new double[0] : Arrays.copyOf(samples, samples.length);
    }

    public String getExperimentName() { return experimentName; }

    public double[] getSamples() {
        return Arrays.copyOf(samples, samples.length);
    }

    @Override
    public String toString() {
        return experimentName + ": " + Arrays.toString(samples);
    }
}

class CryptoVault {
    private final String walletAddress;
    private String secretRecoveryPhrase; // без геттера
    private double btcBalance;           // без сеттера
    private boolean locked;

    public CryptoVault(String walletAddress, String secretRecoveryPhrase, double startBalance) {
        this.walletAddress = walletAddress;
        this.secretRecoveryPhrase = secretRecoveryPhrase;
        this.btcBalance = Math.max(0, startBalance);
        this.locked = true;
    }

    public boolean unlock(String phrase) {
        if (phrase != null && phrase.equals(secretRecoveryPhrase)) {
            locked = false;
            return true;
        }
        return false;
    }

    public void lock() {
        locked = true;
    }

    public boolean sendBtc(double amount, String destination) {
        if (locked || amount <= 0 || btcBalance < amount) return false;
        if (destination == null || destination.isBlank()) return false;
        btcBalance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("CryptoVault{address='%s...', %s, balance=%.4f BTC}",
                walletAddress.substring(0, 10), locked ? "LOCKED" : "UNLOCKED", btcBalance);
    }
}

class ClosedInterval {
    private double start;
    private double end;

    public ClosedInterval(double start, double end) {
        resize(start, end);
    }

    public void resize(double newStart, double newEnd) {
        if (newStart > newEnd) {
            double tmp = newStart;
            newStart = newEnd;
            newEnd = tmp;
        }
        start = newStart;
        end = newEnd;
    }

    public double getLength()   { return end - start; }
    public double getMidpoint() { return (start + end) / 2; }

    public boolean overlaps(ClosedInterval other) {
        if (other == null) return false;
        return start <= other.end && other.start <= end;
    }

    @Override
    public String toString() {
        return "[" + start + "; " + end + "] (центр: " + getMidpoint() + ", довжина: " + getLength() + ")";
    }
}

class RgbColor {
    private final int red;
    private final int green;
    private final int blue;

    public RgbColor(int red, int green, int blue) {
        this.red = clamp(red);
        this.green = clamp(green);
        this.blue = clamp(blue);
    }

    private static int clamp(int val) {
        return Math.max(0, Math.min(255, val));
    }

    public String toHex() {
        return String.format("#%02X%02X%02X", red, green, blue);
    }

    public RgbColor invert() {
        return new RgbColor(255 - red, 255 - green, 255 - blue);
    }

    // середнє арифметичне по кожному каналу
    public RgbColor mixWith(RgbColor other) {
        return new RgbColor((red + other.red) / 2, (green + other.green) / 2, (blue + other.blue) / 2);
    }

    @Override
    public String toString() {
        return "RGB(" + red + ", " + green + ", " + blue + ") " + toHex();
    }
}

class HighSecuritySafe {
    private int pinCode;
    private double storedCash;
    private int failedAttempts;
    private boolean permanentlyBlocked;

    public HighSecuritySafe(int pinCode, double storedCash) {
        this.pinCode = pinCode;
        this.storedCash = Math.max(0, storedCash);
    }

    private boolean checkAccess(int enteredPin) {
        if (permanentlyBlocked) return false;
        if (enteredPin != pinCode) {
            failedAttempts++;
            if (failedAttempts >= 3) {
                permanentlyBlocked = true;
                System.out.println("!!! Сейф заблоковано назавжди");
            }
            return false;
        }
        failedAttempts = 0;
        return true;
    }

    public boolean putCash(int pin, double amount) {
        if (!checkAccess(pin) || amount <= 0) return false;
        storedCash += amount;
        return true;
    }

    public boolean takeCash(int pin, double amount) {
        if (!checkAccess(pin) || amount <= 0 || amount > storedCash) return false;
        storedCash -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Safe{cash=" + storedCash + ", помилок=" + failedAttempts + ", blocked=" + permanentlyBlocked + "}";
    }
}

class EncapsulatedPolynomial {
    private final double[] coeffs; // coeffs[i] - коефіцієнт при x^i

    public EncapsulatedPolynomial(double[] coeffs) {
        if (coeffs == null || coeffs.length == 0) this.coeffs = new double[]{0};
        else this.coeffs = Arrays.copyOf(coeffs, coeffs.length);
    }

    public int getDegree() {
        for (int i = coeffs.length - 1; i > 0; i--) {
            if (coeffs[i] != 0) return i;
        }
        return 0;
    }

    public double getCoefficient(int power) {
        if (power < 0 || power >= coeffs.length) return 0;
        return coeffs[power];
    }

    public double evaluate(double x) {
        double res = 0;
        for (int i = coeffs.length - 1; i >= 0; i--) {
            res = res * x + coeffs[i];
        }
        return res;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = getDegree(); i >= 0; i--) {
            double k = coeffs[i];
            if (k == 0 && getDegree() != 0) continue;
            if (s.isEmpty()) s += (k < 0 ? "-" : "");
            else s += (k < 0 ? " - " : " + ");
            double abs = Math.abs(k);
            if (i == 0) s += abs;
            else if (abs != 1) s += abs;
            if (i == 1) s += "x";
            else if (i > 1) s += "x^" + i;
        }
        return "P(x) = " + s;
    }
}

class MedicalRecord {
    private final String patientId;
    private String fullName;
    private int bloodGroup;
    private boolean rhPositive;
    private String[] allergies;

    public MedicalRecord(String patientId, String fullName, int bloodGroup, boolean rhPositive, String[] allergies) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.bloodGroup = (bloodGroup >= 1 && bloodGroup <= 4) ? bloodGroup : 1;
        this.rhPositive = rhPositive;
        this.allergies = allergies == null ? new String[0] : Arrays.copyOf(allergies, allergies.length);
    }

    public String[] getAllergies() {
        return Arrays.copyOf(allergies, allergies.length);
    }

    public boolean hasAllergyTo(String substance) {
        for (String a : allergies) {
            if (a != null && a.equalsIgnoreCase(substance)) return true;
        }
        return false;
    }

    private String bloodGroupText() {
        String[] names = {"I (0)", "II (A)", "III (B)", "IV (AB)"};
        return names[bloodGroup - 1] + (rhPositive ? " Rh+" : " Rh-");
    }

    @Override
    public String toString() {
        return "Картка " + patientId + ": " + fullName + ", група крові " + bloodGroupText()
                + ", алергії: " + (allergies.length == 0 ? "немає" : String.join(", ", allergies));
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

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public double distanceTo(Point2D other) {
        double dx = other.x - x;
        double dy = other.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}

class CompositeCircle {
    private double radius;
    private final Point2D center;

    public CompositeCircle(double centerX, double centerY, double radius) {
        this.center = new Point2D(centerX, centerY);
        this.radius = radius > 0 ? radius : 1.0;
    }

    public boolean containsPoint(Point2D p) {
        if (p == null) return false;
        return center.distanceTo(p) <= radius;
    }

    @Override
    public String toString() {
        return "Коло з центром " + center + ", r = " + radius;
    }
}

class Engine {
    private final String fuelType;
    private final int volumeCc;
    private int rpm;
    private boolean started;

    public Engine(String fuelType, int volumeCc) {
        this.fuelType = fuelType;
        this.volumeCc = volumeCc;
    }

    public void start() {
        started = true;
        rpm = 800; // холості
    }

    public void stop() {
        started = false;
        rpm = 0;
    }

    public void setRpm(int rpm) {
        if (!started) return;
        this.rpm = Math.max(800, Math.min(7000, rpm));
    }

    public boolean isStarted() { return started; }

    @Override
    public String toString() {
        return "Engine[" + fuelType + ", " + volumeCc + " см3, " + rpm + " об/хв, " + (started ? "працює" : "заглушений") + "]";
    }
}

class Automobile {
    private final String model;
    private double speed;
    private final Engine engine;

    public Automobile(String model, Engine engine) {
        if (engine == null) throw new IllegalArgumentException("Авто без двигуна!");
        this.model = model;
        this.engine = engine;
    }

    public void startEngine() {
        engine.start();
    }

    public void accelerate(double deltaSpeed) {
        if (!engine.isStarted()) {
            System.out.println(model + ": спершу заведіть двигун!");
            return;
        }
        speed = Math.max(0, speed + deltaSpeed);
        engine.setRpm((int) (800 + speed * 30));
        System.out.println(model + " розганяється до " + speed + " км/год");
    }

    @Override
    public String toString() {
        return "Automobile{" + model + ", " + speed + " км/год, " + engine + "}";
    }
}

class Battery {
    private int capacityMah;
    private int chargePercent;

    public Battery(int capacityMah, int chargePercent) {
        this.capacityMah = capacityMah;
        this.chargePercent = Math.max(0, Math.min(100, chargePercent));
    }

    public void drain(int percent) {
        if (percent > 0) chargePercent = Math.max(0, chargePercent - percent);
    }

    public void charge(int percent) {
        if (percent > 0) chargePercent = Math.min(100, chargePercent + percent);
    }

    public int getChargePercent() { return chargePercent; }

    @Override
    public String toString() {
        return capacityMah + " мАг, " + chargePercent + "%";
    }
}

class Display {
    private double diagonalInches;
    private int brightnessPercent;

    public Display(double diagonalInches, int brightnessPercent) {
        this.diagonalInches = diagonalInches;
        setBrightness(brightnessPercent);
    }

    public void setBrightness(int percent) {
        brightnessPercent = Math.max(10, Math.min(100, percent));
    }

    public int getBrightnessPercent() { return brightnessPercent; }

    @Override
    public String toString() {
        return diagonalInches + "\", яскравість " + brightnessPercent + "%";
    }
}

class SmartDevice {
    private final String name;
    private final Battery battery;
    private final Display display;
    private boolean poweredOn = true;

    public SmartDevice(String name, Battery battery, Display display) {
        this.name = name;
        this.battery = battery;
        this.display = display;
    }

    public void setBrightness(int percent) {
        display.setBrightness(percent);
    }

    public void watchVideo(int minutes) {
        if (!poweredOn) {
            System.out.println(name + " вимкнений");
            return;
        }
        int perTen = display.getBrightnessPercent() > 70 ? 2 : 1;
        int watched = 0;
        while (watched < minutes) {
            battery.drain(perTen);
            watched += 10;
            if (battery.getChargePercent() == 0) {
                poweredOn = false;
                System.out.println(name + " розрядився і вимкнувся через " + watched + " хв");
                return;
            }
        }
        System.out.println(name + ": переглянуто " + minutes + " хв відео");
    }

    @Override
    public String toString() {
        return name + " [батарея " + battery + "; екран " + display + "; " + (poweredOn ? "увімкнений" : "вимкнений") + "]";
    }
}

class LineSegment {
    private final Point2D start;
    private final Point2D end;

    public LineSegment(Point2D start, Point2D end) {
        this.start = new Point2D(start.getX(), start.getY());
        this.end = new Point2D(end.getX(), end.getY());
    }

    public double getLength() {
        return start.distanceTo(end);
    }

    public Point2D getMidpoint() {
        return new Point2D((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    @Override
    public String toString() {
        return "Відрізок " + start + " - " + end + ", довжина " + getLength();
    }
}

class BankAccount {
    private final String iban;
    private double balance;

    public BankAccount(String iban, double balance) {
        this.iban = iban;
        this.balance = Math.max(0, balance);
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) return false;
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "Рахунок " + iban + ": " + balance + " грн";
    }
}

class PlasticCard {
    private final String cardNumber;
    private final String expiryDate;
    private boolean blocked;
    private final BankAccount linkedAccount;

    public PlasticCard(String cardNumber, String expiryDate, BankAccount linkedAccount) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.linkedAccount = linkedAccount;
    }

    public void block() { blocked = true; }
    public void unblock() { blocked = false; }

    public boolean payAtTerminal(double amount) {
        if (blocked) return false;
        return linkedAccount.withdraw(amount);
    }

    @Override
    public String toString() {
        return "Картка **** " + cardNumber.substring(cardNumber.length() - 4) + " до " + expiryDate + (blocked ? " (заблокована)" : "");
    }
}

class WeaponItem {
    private final String name;
    private final int bonusDamage;
    private int durability;

    public WeaponItem(String name, int bonusDamage, int durability) {
        this.name = name;
        this.bonusDamage = bonusDamage;
        this.durability = Math.max(0, Math.min(100, durability));
    }

    public int useWeapon() {
        if (durability == 0) return 0;
        durability = Math.max(0, durability - 10);
        return bonusDamage;
    }

    @Override
    public String toString() {
        return name + " (+" + bonusDamage + ", міцність " + durability + ")";
    }
}

class HeroCharacter {
    private final String nickname;
    private int baseStrength;
    private WeaponItem equippedWeapon;

    public HeroCharacter(String nickname, int baseStrength) {
        this.nickname = nickname;
        this.baseStrength = baseStrength;
    }

    public void equip(WeaponItem newWeapon) {
        equippedWeapon = newWeapon;
    }

    public void unequip() {
        equippedWeapon = null;
    }

    public int attack() {
        int dmg = baseStrength;
        if (equippedWeapon != null) dmg += equippedWeapon.useWeapon();
        return dmg;
    }

    @Override
    public String toString() {
        return nickname + ", сила " + baseStrength + ", зброя: " + (equippedWeapon == null ? "немає" : equippedWeapon);
    }
}

class DeliveryAddress {
    private String city;
    private String street;
    private int postOfficeNumber;

    public DeliveryAddress(String city, String street, int postOfficeNumber) {
        this.city = city;
        this.street = street;
        this.postOfficeNumber = postOfficeNumber;
    }

    public boolean isValid() {
        return city != null && !city.isBlank() && street != null && !street.isBlank() && postOfficeNumber > 0;
    }

    @Override
    public String toString() {
        return city + ", " + street + ", відділення №" + postOfficeNumber;
    }
}

class ParcelOrder {
    private final String orderId;
    private double weightKg;
    private DeliveryAddress destination;
    private boolean shipped;

    public ParcelOrder(String orderId, double weightKg, DeliveryAddress destination) {
        this.orderId = orderId;
        this.weightKg = weightKg;
        this.destination = destination;
    }

    public boolean changeDestination(DeliveryAddress newAddress) {
        if (shipped || newAddress == null || !newAddress.isValid()) return false;
        destination = newAddress;
        return true;
    }

    public void markAsShipped() {
        shipped = true;
    }

    @Override
    public String toString() {
        return "Замовлення " + orderId + " (" + weightKg + " кг) -> " + destination + (shipped ? " [відправлено]" : " [готується]");
    }
}

class TemperatureSensor {
    private double currentTemp;

    public TemperatureSensor(double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public double getCurrentTemp() { return currentTemp; }

    // для симуляції зміни температури
    public void setCurrentTemp(double currentTemp) {
        this.currentTemp = currentTemp;
    }
}

class HeatingUnit {
    private boolean heatingOn;
    private double powerKw;

    public HeatingUnit(double powerKw) {
        this.powerKw = powerKw;
    }

    public void turnOn()  { heatingOn = true; }
    public void turnOff() { heatingOn = false; }
    public boolean isHeatingOn() { return heatingOn; }

    @Override
    public String toString() {
        return "обігрівач " + powerKw + " кВт " + (heatingOn ? "УВІМК" : "вимк");
    }
}

class ClimateController {
    private final TemperatureSensor sensor;
    private final HeatingUnit heatingUnit;
    private double targetTemp;

    public ClimateController(TemperatureSensor sensor, HeatingUnit heatingUnit, double targetTemp) {
        this.sensor = sensor;
        this.heatingUnit = heatingUnit;
        this.targetTemp = targetTemp;
    }

    public void regulate() {
        double t = sensor.getCurrentTemp();
        if (t < targetTemp - 0.5) heatingUnit.turnOn();
        else if (t >= targetTemp) heatingUnit.turnOff();
    }

    @Override
    public String toString() {
        return "Клімат: зараз " + sensor.getCurrentTemp() + "°C, ціль " + targetTemp + "°C, " + heatingUnit;
    }
}

class Polyline {
    private final Point2D[] vertices;
    private int count;

    public Polyline(int maxVertices) {
        vertices = new Point2D[maxVertices];
    }

    public void addVertex(double x, double y) {
        if (count >= vertices.length) {
            System.out.println("Більше вершин додати не можна");
            return;
        }
        vertices[count++] = new Point2D(x, y);
    }

    public double getTotalLength() {
        double len = 0;
        for (int i = 1; i < count; i++) {
            len += vertices[i - 1].distanceTo(vertices[i]);
        }
        return len;
    }

    public double getClosedPerimeter() {
        if (count < 3) return getTotalLength();
        return getTotalLength() + vertices[count - 1].distanceTo(vertices[0]);
    }
}

class OrderItem {
    private final String productName;
    private final double unitPrice;
    private int quantity;

    public OrderItem(String productName, double unitPrice, int quantity) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getProductName() { return productName; }
    public double getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }

    public void addQuantity(int qty) {
        if (qty > 0) quantity += qty;
    }

    public double getItemTotal() {
        return unitPrice * quantity;
    }
}

class ShoppingOrder {
    private final OrderItem[] items = new OrderItem[10];
    private int itemCount;

    public void addItem(String name, double price, int qty) {
        if (qty <= 0 || price < 0) return;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProductName().equalsIgnoreCase(name)) {
                items[i].addQuantity(qty);
                return;
            }
        }
        if (itemCount == items.length) {
            System.out.println("Кошик повний!");
            return;
        }
        items[itemCount++] = new OrderItem(name, price, qty);
    }

    public double calculateGrandTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) total += items[i].getItemTotal();
        return total;
    }

    @Override
    public String toString() {
        String s = "======== ФІСКАЛЬНИЙ ЧЕК ========\n";
        for (int i = 0; i < itemCount; i++) {
            OrderItem it = items[i];
            s += String.format("%-16s %2d x %7.2f = %8.2f%n", it.getProductName(), it.getQuantity(), it.getUnitPrice(), it.getItemTotal());
        }
        s += "--------------------------------\n";
        s += String.format("СУМА:%27.2f%n", calculateGrandTotal());
        s += "================================";
        return s;
    }
}

class BookItem {
    private final String title;
    private final String author;
    private final int pages;

    public BookItem(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = Math.max(1, pages);
    }

    public int getPages() { return pages; }

    @Override
    public String toString() {
        return "\"" + title + "\" (" + author + ", " + pages + " стор.)";
    }
}

class Bookshelf {
    private final String genre;
    private final BookItem[] books;
    private int bookCount;

    public Bookshelf(String genre, int capacity) {
        this.genre = genre;
        this.books = new BookItem[capacity];
    }

    public boolean putBook(BookItem book) {
        if (book == null || bookCount >= books.length) return false;
        books[bookCount++] = book;
        return true;
    }

    public BookItem findLongestBook() {
        if (bookCount == 0) return null;
        BookItem max = books[0];
        for (int i = 1; i < bookCount; i++) {
            if (books[i].getPages() > max.getPages()) max = books[i];
        }
        return max;
    }

    public int getTotalPagesOnShelf() {
        int sum = 0;
        for (int i = 0; i < bookCount; i++) sum += books[i].getPages();
        return sum;
    }

    public String getGenre() { return genre; }
}

class AudioTrack {
    private final String title;
    private final String artist;
    private final int durationSeconds;

    public AudioTrack(String title, String artist, int durationSeconds) {
        this.title = title;
        this.artist = artist;
        this.durationSeconds = Math.max(0, durationSeconds);
    }

    public int getDurationSeconds() { return durationSeconds; }

    public String getFormattedTime() {
        return String.format("%02d:%02d", durationSeconds / 60, durationSeconds % 60);
    }

    @Override
    public String toString() {
        return artist + " - " + title + " [" + getFormattedTime() + "]";
    }
}

class Playlist {
    private String name;
    private final AudioTrack[] tracks;
    private int trackCount;

    public Playlist(String name, int maxTracks) {
        this.name = name;
        this.tracks = new AudioTrack[maxTracks];
    }

    public void addTrack(AudioTrack track) {
        if (track != null && trackCount < tracks.length) tracks[trackCount++] = track;
    }

    public int getTotalDurationSeconds() {
        int sum = 0;
        for (int i = 0; i < trackCount; i++) sum += tracks[i].getDurationSeconds();
        return sum;
    }

    @Override
    public String toString() {
        String s = "Плейлист \"" + name + "\":\n";
        for (int i = 0; i < trackCount; i++) {
            s += "  " + (i + 1) + ". " + tracks[i] + "\n";
        }
        int total = getTotalDurationSeconds();
        s += "Загалом: " + (total / 60) + " хв " + (total % 60) + " сек";
        return s;
    }
}

class ServerNode {
    private final String ipAddress;
    private final int totalRamGb;
    private int usedRamGb;
    private boolean online = true;

    public ServerNode(String ipAddress, int totalRamGb, int usedRamGb) {
        this.ipAddress = ipAddress;
        this.totalRamGb = totalRamGb;
        this.usedRamGb = Math.max(0, Math.min(totalRamGb, usedRamGb));
    }

    public int getFreeRamGb() { return totalRamGb - usedRamGb; }
    public boolean isOnline() { return online; }
    public void setOnline(boolean online) { this.online = online; }
    public String getIpAddress() { return ipAddress; }

    public boolean allocate(int gb) {
        if (!online || gb <= 0 || gb > getFreeRamGb()) return false;
        usedRamGb += gb;
        return true;
    }

    @Override
    public String toString() {
        return ipAddress + " " + usedRamGb + "/" + totalRamGb + " GB" + (online ? "" : " (OFFLINE)");
    }
}

class DataCenterCluster {
    private final String clusterLocation;
    private final ServerNode[] nodes;
    private int nodeCount;

    public DataCenterCluster(String clusterLocation, int maxNodes) {
        this.clusterLocation = clusterLocation;
        this.nodes = new ServerNode[maxNodes];
    }

    public void addNode(ServerNode node) {
        if (node != null && nodeCount < nodes.length) nodes[nodeCount++] = node;
    }

    public boolean deployContainer(int requiredRamGb) {
        for (int i = 0; i < nodeCount; i++) {
            if (nodes[i].isOnline() && nodes[i].getFreeRamGb() >= requiredRamGb) {
                nodes[i].allocate(requiredRamGb);
                System.out.println("  -> розгорнуто на " + nodes[i].getIpAddress());
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "Кластер " + clusterLocation + ":";
        for (int i = 0; i < nodeCount; i++) s += "\n  " + nodes[i];
        return s;
    }
}

class CourseModule {
    private final String topic;
    private final int lectureHours;
    private final int practiceHours;
    private double maxScore;

    public CourseModule(String topic, int lectureHours, int practiceHours, double maxScore) {
        this.topic = topic;
        this.lectureHours = lectureHours;
        this.practiceHours = practiceHours;
        this.maxScore = Math.max(0, maxScore);
    }

    public int getTotalHours() { return lectureHours + practiceHours; }
    public double getMaxScore() { return maxScore; }
    public String getTopic() { return topic; }
}

class UniversityCourse {
    private final String courseTitle;
    private final CourseModule[] modules;
    private int moduleCount;

    public UniversityCourse(String courseTitle, int maxModules) {
        this.courseTitle = courseTitle;
        this.modules = new CourseModule[maxModules];
    }

    public void addModule(CourseModule m) {
        if (m != null && moduleCount < modules.length) modules[moduleCount++] = m;
    }

    public double getEctsCredits() {
        int hours = 0;
        for (int i = 0; i < moduleCount; i++) hours += modules[i].getTotalHours();
        return hours / 30.0;
    }

    public boolean isScoreBalanced() {
        double sum = 0;
        for (int i = 0; i < moduleCount; i++) sum += modules[i].getMaxScore();
        return Math.abs(sum - 100.0) < 1e-9;
    }

    @Override
    public String toString() {
        String s = "Курс \"" + courseTitle + "\":\n";
        for (int i = 0; i < moduleCount; i++) {
            s += "  " + modules[i].getTopic() + " - " + modules[i].getTotalHours() + " год, " + modules[i].getMaxScore() + " балів\n";
        }
        s += String.format("ЄКТС: %.2f, сума балів = 100: %s", getEctsCredits(), isScoreBalanced() ? "так" : "ні");
        return s;
    }
}

class TrainCarriage {
    private final int carriageNumber;
    private final String type;
    private final int totalSeats;
    private int occupiedSeats;

    public TrainCarriage(int carriageNumber, String type, int totalSeats) {
        this.carriageNumber = carriageNumber;
        this.type = type;
        this.totalSeats = totalSeats;
    }

    public int getCarriageNumber() { return carriageNumber; }
    public int getFreeSeats() { return totalSeats - occupiedSeats; }

    public boolean book(int seats) {
        if (seats <= 0 || seats > getFreeSeats()) return false;
        occupiedSeats += seats;
        return true;
    }

    @Override
    public String toString() {
        return "Вагон " + carriageNumber + " (" + type + "): " + occupiedSeats + "/" + totalSeats;
    }
}

class PassengerTrain {
    private final String route;
    private final TrainCarriage[] carriages;
    private int carriageCount;

    public PassengerTrain(String route, int maxCarriages) {
        this.route = route;
        this.carriages = new TrainCarriage[maxCarriages];
    }

    public void attachCarriage(TrainCarriage c) {
        if (c != null && carriageCount < carriages.length) carriages[carriageCount++] = c;
    }

    public int getTotalFreeSeats() {
        int free = 0;
        for (int i = 0; i < carriageCount; i++) free += carriages[i].getFreeSeats();
        return free;
    }

    public boolean bookTicketsInCarriage(int carriageNumber, int seatsToBook) {
        for (int i = 0; i < carriageCount; i++) {
            if (carriages[i].getCarriageNumber() == carriageNumber) {
                return carriages[i].book(seatsToBook);
            }
        }
        return false;
    }

    public String getRoute() { return route; }
}

class LinearEquation {
    private final double a, b, c;

    public LinearEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isSatisfiedBy(double x, double y) {
        return Math.abs(a * x + b * y - c) < 1e-6;
    }

    @Override
    public String toString() {
        return a + "x + " + b + "y = " + c;
    }
}

class EquationSystem {
    private final LinearEquation[] equations;
    private int count;

    public EquationSystem(int maxEquations) {
        equations = new LinearEquation[maxEquations];
    }

    public void addEquation(LinearEquation eq) {
        if (eq != null && count < equations.length) equations[count++] = eq;
    }

    public boolean checkSolution(double x, double y) {
        if (count == 0) return false;
        for (int i = 0; i < count; i++) {
            if (!equations[i].isSatisfiedBy(x, y)) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "Система:";
        for (int i = 0; i < count; i++) s += "\n  { " + equations[i];
        return s;
    }
}

abstract class AbstractShape {
    private String color;

    public AbstractShape(String color) {
        this.color = (color == null || color.isBlank()) ? "Білий" : color;
    }

    public String getColor() { return color; }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return String.format("%s [%s] S=%.2f, P=%.2f", getClass().getSimpleName(), color, getArea(), getPerimeter());
    }
}

class CircleShape extends AbstractShape {
    private final double r;

    public CircleShape(String color, double r) {
        super(color);
        this.r = r > 0 ? r : 1.0;
    }

    @Override
    public double getArea() { return Math.PI * r * r; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * r; }
}

class RectangleShape extends AbstractShape {
    private final double w;
    private final double h;

    public RectangleShape(String color, double w, double h) {
        super(color);
        this.w = w > 0 ? w : 1.0;
        this.h = h > 0 ? h : 1.0;
    }

    @Override
    public double getArea() { return w * h; }

    @Override
    public double getPerimeter() { return 2 * (w + h); }
}

abstract class AbstractPowerPlant {
    private final String stationName;
    protected double baseCapacityMw;

    public AbstractPowerPlant(String stationName, double baseCapacityMw) {
        this.stationName = stationName;
        this.baseCapacityMw = Math.max(0, baseCapacityMw);
    }

    public String getStationName() { return stationName; }

    public abstract double generateMegawatts();

    public double calculateDailyProfit(double tariffPerMwh) {
        return generateMegawatts() * 24 * tariffPerMwh;
    }

    @Override
    public String toString() {
        return String.format("%s: %.1f з %.0f МВт", stationName, generateMegawatts(), baseCapacityMw);
    }
}

class SolarPowerPlant extends AbstractPowerPlant {
    private double sunIntensityFactor;

    public SolarPowerPlant(String stationName, double baseCapacityMw, double sunIntensityFactor) {
        super(stationName, baseCapacityMw);
        this.sunIntensityFactor = Math.max(0.0, Math.min(1.0, sunIntensityFactor));
    }

    @Override
    public double generateMegawatts() {
        return baseCapacityMw * sunIntensityFactor;
    }
}

class WindPowerPlant extends AbstractPowerPlant {
    private double windSpeedMs;

    public WindPowerPlant(String stationName, double baseCapacityMw, double windSpeedMs) {
        super(stationName, baseCapacityMw);
        this.windSpeedMs = windSpeedMs;
    }

    @Override
    public double generateMegawatts() {
        if (windSpeedMs < 3 || windSpeedMs > 25) return 0;
        return baseCapacityMw * Math.min(1.0, windSpeedMs / 12.0);
    }

    @Override
    public String toString() {
        return super.toString() + " (вітер " + windSpeedMs + " м/с" + (generateMegawatts() == 0 ? ", турбіни стоять" : "") + ")";
    }
}

abstract class AbstractEmployee {
    private final int id;
    private final String name;
    protected double taxRate = 0.195;

    public AbstractEmployee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract double calculateGrossSalary();

    public final double calculateNetSalary() {
        return calculateGrossSalary() * (1.0 - taxRate);
    }

    @Override
    public String toString() {
        return String.format("#%d %s: брутто %.2f, нетто %.2f", id, name, calculateGrossSalary(), calculateNetSalary());
    }
}

class SalariedEmployee extends AbstractEmployee {
    private double monthlySalary;
    private double bonus;

    public SalariedEmployee(int id, String name, double monthlySalary, double bonus) {
        super(id, name);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateGrossSalary() {
        return monthlySalary + bonus;
    }
}

class HourlyContractor extends AbstractEmployee {
    private int hoursWorked;
    private double hourlyRate;

    public HourlyContractor(int id, String name, int hoursWorked, double hourlyRate) {
        super(id, name);
        this.hoursWorked = Math.max(0, hoursWorked);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateGrossSalary() {
        if (hoursWorked <= 160) return hoursWorked * hourlyRate;
        return 160 * hourlyRate + (hoursWorked - 160) * hourlyRate * 1.5;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + hoursWorked + " год)";
    }
}

abstract class AbstractSequence {
    private final String title;

    public AbstractSequence(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    public abstract double getTerm(int index);

    public double sumFirstN(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) sum += getTerm(i);
        return sum;
    }
}

class HarmonicSequence extends AbstractSequence {
    public HarmonicSequence() {
        super("Гармонічний ряд 1/n");
    }

    @Override
    public double getTerm(int index) {
        return 1.0 / index;
    }
}

class SquareNumbersSequence extends AbstractSequence {
    public SquareNumbersSequence() {
        super("Квадрати n^2");
    }

    @Override
    public double getTerm(int index) {
        return (double) index * index;
    }
}

abstract class AbstractTransaction {
    private final String txId;
    protected final double amount;

    public AbstractTransaction(String txId, double amount) {
        this.txId = txId;
        this.amount = Math.max(0, amount);
    }

    public abstract double calculateCommission();

    public final double getTotalDebit() {
        return amount + calculateCommission();
    }

    @Override
    public String toString() {
        return String.format("%s (%s): сума %.2f, комісія %.2f, спишеться %.2f",
                txId, getClass().getSimpleName(), amount, calculateCommission(), getTotalDebit());
    }
}

class DomesticTransfer extends AbstractTransaction {
    public DomesticTransfer(String txId, double amount) {
        super(txId, amount);
    }

    @Override
    public double calculateCommission() {
        return Math.max(5.0, amount * 0.005);
    }
}

class CryptoTransfer extends AbstractTransaction {
    private final double networkGasFee;

    public CryptoTransfer(String txId, double amount, double networkGasFee) {
        super(txId, amount);
        this.networkGasFee = networkGasFee;
    }

    @Override
    public double calculateCommission() {
        return networkGasFee;
    }
}

abstract class Solid3D {
    private final String materialName;
    private final double densityKgPerM3;

    public Solid3D(String materialName, double densityKgPerM3) {
        this.materialName = materialName;
        this.densityKgPerM3 = densityKgPerM3;
    }

    public abstract double getVolume();
    public abstract double getSurfaceArea();

    public final double getMassKg() {
        return densityKgPerM3 * getVolume();
    }

    @Override
    public String toString() {
        return String.format("%s (%s): V=%.6f м3, S=%.4f м2, m=%.3f кг",
                getClass().getSimpleName(), materialName, getVolume(), getSurfaceArea(), getMassKg());
    }
}

class Sphere3D extends Solid3D {
    private final double r;

    public Sphere3D(String material, double density, double r) {
        super(material, density);
        this.r = r;
    }

    @Override
    public double getVolume() { return 4.0 / 3.0 * Math.PI * r * r * r; }

    @Override
    public double getSurfaceArea() { return 4 * Math.PI * r * r; }
}

class Cylinder3D extends Solid3D {
    private final double r;
    private final double h;

    public Cylinder3D(String material, double density, double r, double h) {
        super(material, density);
        this.r = r;
        this.h = h;
    }

    @Override
    public double getVolume() { return Math.PI * r * r * h; }

    @Override
    public double getSurfaceArea() { return 2 * Math.PI * r * (r + h); }
}

abstract class AbstractSensor {
    private final String location;
    private final double minSafe;
    private final double maxSafe;

    public AbstractSensor(String location, double minSafe, double maxSafe) {
        this.location = location;
        this.minSafe = Math.min(minSafe, maxSafe);
        this.maxSafe = Math.max(minSafe, maxSafe);
    }

    public String getLocation() { return location; }

    public abstract double readValue();
    public abstract String getUnit();

    public final boolean isAlarmTriggered() {
        double v = readValue();
        return v < minSafe || v > maxSafe;
    }

    @Override
    public String toString() {
        return String.format("%s: %.3f %s (норма %.2f..%.2f)%s", location, readValue(), getUnit(), minSafe, maxSafe,
                isAlarmTriggered() ? " ТРИВОГА!" : "");
    }
}

class PressureSensor extends AbstractSensor {
    private double rawPressure;
    private final double calibrationFactor;

    public PressureSensor(String location, double minSafe, double maxSafe, double rawPressure, double calibrationFactor) {
        super(location, minSafe, maxSafe);
        this.rawPressure = rawPressure;
        this.calibrationFactor = calibrationFactor;
    }

    public void setRawPressure(double rawPressure) {
        this.rawPressure = rawPressure;
    }

    @Override
    public double readValue() { return rawPressure * calibrationFactor; }

    @Override
    public String getUnit() { return "бар"; }
}

class RadiationSensor extends AbstractSensor {
    private double level;

    public RadiationSensor(String location, double minSafe, double maxSafe, double level) {
        super(location, minSafe, maxSafe);
        this.level = level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    @Override
    public double readValue() { return level; }

    @Override
    public String getUnit() { return "мкЗв/год"; }
}

abstract class AbstractCompressor {
    private final String algorithmName;

    public AbstractCompressor(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public String getAlgorithmName() { return algorithmName; }

    public abstract int estimateCompressedSize(int originalSizeBytes);

    public double getCompressionRatio(int originalSizeBytes) {
        if (originalSizeBytes <= 0) return 0;
        return (1.0 - (double) estimateCompressedSize(originalSizeBytes) / originalSizeBytes) * 100;
    }
}

class ZipCompressor extends AbstractCompressor {
    public ZipCompressor() {
        super("ZIP");
    }

    @Override
    public int estimateCompressedSize(int originalSizeBytes) {
        return (int) Math.round(originalSizeBytes * 0.55);
    }
}

class UltraLzmaCompressor extends AbstractCompressor {
    private static final int HEADER_BYTES = 128;

    public UltraLzmaCompressor() {
        super("LZMA");
    }

    @Override
    public int estimateCompressedSize(int originalSizeBytes) {
        return (int) Math.round(originalSizeBytes * 0.30) + HEADER_BYTES;
    }
}

abstract class AbstractPcPart {
    private final String model;
    private final double priceUah;

    public AbstractPcPart(String model, double priceUah) {
        this.model = model;
        this.priceUah = priceUah;
    }

    public String getModel() { return model; }
    public double getPriceUah() { return priceUah; }

    public abstract int getPowerConsumptionWatts();

    @Override
    public String toString() {
        return model + " (" + getPowerConsumptionWatts() + " Вт, " + priceUah + " грн)";
    }
}

class ProcessorPart extends AbstractPcPart {
    private final int cores;
    private final int watts;

    public ProcessorPart(String model, double priceUah, int cores, int watts) {
        super(model, priceUah);
        this.cores = cores;
        this.watts = watts;
    }

    @Override
    public int getPowerConsumptionWatts() { return watts; }

    @Override
    public String toString() {
        return "CPU " + super.toString() + ", ядер: " + cores;
    }
}

class VideoCardPart extends AbstractPcPart {
    private final int vramGb;
    private final int watts;

    public VideoCardPart(String model, double priceUah, int vramGb, int watts) {
        super(model, priceUah);
        this.vramGb = vramGb;
        this.watts = watts;
    }

    @Override
    public int getPowerConsumptionWatts() { return watts; }

    @Override
    public String toString() {
        return "GPU " + super.toString() + ", " + vramGb + "GB";
    }
}

class DesktopPC {
    private final String name;
    private final int psuMaxWatts;
    private final AbstractPcPart[] parts;
    private int partCount;

    public DesktopPC(String name, int psuMaxWatts, int slots) {
        this.name = name;
        this.psuMaxWatts = psuMaxWatts;
        this.parts = new AbstractPcPart[slots];
    }

    public void installPart(AbstractPcPart part) {
        if (part != null && partCount < parts.length) parts[partCount++] = part;
    }

    public int getTotalConsumption() {
        int sum = 0;
        for (int i = 0; i < partCount; i++) sum += parts[i].getPowerConsumptionWatts();
        return sum;
    }

    public boolean isPowerSupplyStable() {
        return getTotalConsumption() * 1.2 <= psuMaxWatts;
    }

    public double getTotalPrice() {
        double sum = 0;
        for (int i = 0; i < partCount; i++) sum += parts[i].getPriceUah();
        return sum;
    }

    @Override
    public String toString() {
        String s = name + " (БЖ " + psuMaxWatts + " Вт):\n";
        for (int i = 0; i < partCount; i++) s += "  " + parts[i] + "\n";
        s += String.format("Споживання %d Вт, з запасом %.0f Вт -> %s, ціна %.0f грн",
                getTotalConsumption(), getTotalConsumption() * 1.2, isPowerSupplyStable() ? "стабільно" : "БЖ НЕ ВИТЯГНЕ", getTotalPrice());
        return s;
    }
}

abstract class AbstractThruster {
    private final String thrusterId;

    public AbstractThruster(String thrusterId) {
        this.thrusterId = thrusterId;
    }

    public String getThrusterId() { return thrusterId; }

    public abstract double getThrustKn();
    public abstract double getFuelBurnRate(); // кг/с
}

class ChemicalThruster extends AbstractThruster {
    private final double thrustKn;
    private final double burnRate;

    public ChemicalThruster(String id, double thrustKn, double burnRate) {
        super(id);
        this.thrustKn = thrustKn;
        this.burnRate = burnRate;
    }

    @Override
    public double getThrustKn() { return thrustKn; }

    @Override
    public double getFuelBurnRate() { return burnRate; }
}

class IonThruster extends AbstractThruster {
    private final double powerKw;

    public IonThruster(String id, double powerKw) {
        super(id);
        this.powerKw = powerKw;
    }

    @Override
    public double getThrustKn() { return powerKw * 0.04 / 1000.0; }

    @Override
    public double getFuelBurnRate() { return powerKw * 0.000002; }
}

class Spacecraft {
    private final String shipName;
    private final double dryMassTons;
    private final AbstractThruster[] thrusters;
    private int count;

    public Spacecraft(String shipName, double dryMassTons, int maxThrusters) {
        this.shipName = shipName;
        this.dryMassTons = dryMassTons;
        this.thrusters = new AbstractThruster[maxThrusters];
    }

    public void addThruster(AbstractThruster t) {
        if (t != null && count < thrusters.length) thrusters[count++] = t;
    }

    public double getTotalThrustKn() {
        double sum = 0;
        for (int i = 0; i < count; i++) sum += thrusters[i].getThrustKn();
        return sum;
    }

    public double getTotalFuelBurnRate() {
        double sum = 0;
        for (int i = 0; i < count; i++) sum += thrusters[i].getFuelBurnRate();
        return sum;
    }

    public double getInitialAcceleration() {
        return getTotalThrustKn() / dryMassTons;
    }

    @Override
    public String toString() {
        return String.format("Корабель %s (%.1f т, двигунів %d): тяга %.4f кН, витрата %.2f кг/с, прискорення %.3f м/с2",
                shipName, dryMassTons, count, getTotalThrustKn(), getTotalFuelBurnRate(), getInitialAcceleration());
    }
}

class LandPlot {
    private final double totalPlotAreaM2;
    private final AbstractShape[] structures;
    private int count;

    public LandPlot(double totalPlotAreaM2, int maxStructures) {
        this.totalPlotAreaM2 = totalPlotAreaM2;
        this.structures = new AbstractShape[maxStructures];
    }

    public double getBuiltArea() {
        double sum = 0;
        for (int i = 0; i < count; i++) sum += structures[i].getArea();
        return sum;
    }

    public boolean addStructure(AbstractShape s) {
        if (s == null || count >= structures.length) return false;
        if (getBuiltArea() + s.getArea() > totalPlotAreaM2 * 0.6) return false;
        structures[count++] = s;
        return true;
    }

    public double getFreeGreenArea() {
        return totalPlotAreaM2 - getBuiltArea();
    }

    @Override
    public String toString() {
        return String.format("Ділянка %.0f м2: забудовано %.2f м2 (%.1f%%), газон %.2f м2",
                totalPlotAreaM2, getBuiltArea(), getBuiltArea() / totalPlotAreaM2 * 100, getFreeGreenArea());
    }
}

abstract class AbstractAsset {
    private final String ticker;
    protected double investedAmount;

    public AbstractAsset(String ticker, double investedAmount) {
        this.ticker = ticker;
        this.investedAmount = Math.max(0, investedAmount);
    }

    public String getTicker() { return ticker; }
    public double getInvestedAmount() { return investedAmount; }

    public abstract double calculateAnnualReturn();
}

class GovernmentBond extends AbstractAsset {
    private final double couponPercent;

    public GovernmentBond(String ticker, double investedAmount, double couponPercent) {
        super(ticker, investedAmount);
        this.couponPercent = couponPercent;
    }

    @Override
    public double calculateAnnualReturn() {
        return investedAmount * couponPercent / 100;
    }
}

class DividendStock extends AbstractAsset {
    private static final double DIVIDEND_TAX = 0.09;
    private final double expectedGrowthPercent;
    private final double dividendYieldPercent;

    public DividendStock(String ticker, double investedAmount, double expectedGrowthPercent, double dividendYieldPercent) {
        super(ticker, investedAmount);
        this.expectedGrowthPercent = expectedGrowthPercent;
        this.dividendYieldPercent = dividendYieldPercent;
    }

    @Override
    public double calculateAnnualReturn() {
        double growth = investedAmount * expectedGrowthPercent / 100;
        double dividends = investedAmount * dividendYieldPercent / 100 * (1 - DIVIDEND_TAX);
        return growth + dividends;
    }
}

class InvestmentPortfolio {
    private final String investorName;
    private final AbstractAsset[] assets;
    private int count;

    public InvestmentPortfolio(String investorName, int maxAssets) {
        this.investorName = investorName;
        this.assets = new AbstractAsset[maxAssets];
    }

    public void addAsset(AbstractAsset a) {
        if (a != null && count < assets.length) assets[count++] = a;
    }

    public double getTotalValue() {
        double sum = 0;
        for (int i = 0; i < count; i++) sum += assets[i].getInvestedAmount();
        return sum;
    }

    public double getExpectedAnnualProfit() {
        double sum = 0;
        for (int i = 0; i < count; i++) sum += assets[i].calculateAnnualReturn();
        return sum;
    }

    @Override
    public String toString() {
        String s = "Портфель " + investorName + ":\n";
        for (int i = 0; i < count; i++) {
            s += String.format("  %-18s %10.2f -> +%.2f/рік%n", assets[i].getTicker(), assets[i].getInvestedAmount(), assets[i].calculateAnnualReturn());
        }
        s += String.format("Вартість: %.2f, очікуваний прибуток: %.2f (%.2f%%)",
                getTotalValue(), getExpectedAnnualProfit(), getExpectedAnnualProfit() / getTotalValue() * 100);
        return s;
    }
}

abstract class AbstractHeroUnit {
    private final String name;
    protected int hp;

    public AbstractHeroUnit(String name, int hp) {
        this.name = name;
        this.hp = Math.max(1, hp);
    }

    public String getName() { return name; }

    public abstract int getCombatPower();
    public abstract String getRole();

    @Override
    public String toString() {
        return name + " [" + getRole() + "] HP " + hp + ", сила " + getCombatPower();
    }
}

class TankWarrior extends AbstractHeroUnit {
    private final int armor;

    public TankWarrior(String name, int hp, int armor) {
        super(name, hp);
        this.armor = armor;
    }

    @Override
    public int getCombatPower() { return hp / 5 + armor * 3; }

    @Override
    public String getRole() { return "Tank"; }
}

class ArcaneMage extends AbstractHeroUnit {
    private final int intellect;
    private final int spellPower;

    public ArcaneMage(String name, int hp, int intellect, int spellPower) {
        super(name, hp);
        this.intellect = intellect;
        this.spellPower = spellPower;
    }

    @Override
    public int getCombatPower() { return intellect * 2 + spellPower; }

    @Override
    public String getRole() { return "Mage"; }
}

class RaidParty {
    private final String guildName;
    private final AbstractHeroUnit[] members;
    private int memberCount;

    public RaidParty(String guildName, int maxMembers) {
        this.guildName = guildName;
        this.members = new AbstractHeroUnit[maxMembers];
    }

    public void addMember(AbstractHeroUnit hero) {
        if (hero != null && memberCount < members.length) members[memberCount++] = hero;
    }

    public int getTotalPower() {
        int sum = 0;
        for (int i = 0; i < memberCount; i++) sum += members[i].getCombatPower();
        return sum;
    }

    public boolean isReadyForRaid(int dungeonDifficulty) {
        boolean hasTank = false;
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getRole().equals("Tank")) {
                hasTank = true;
                break;
            }
        }
        return hasTank && getTotalPower() > dungeonDifficulty;
    }

    @Override
    public String toString() {
        String s = "Гільдія \"" + guildName + "\":";
        for (int i = 0; i < memberCount; i++) s += "\n  " + members[i];
        return s + "\nСумарна сила: " + getTotalPower();
    }
}

class EmergencySiren {
    private boolean sounding;

    public void activate() {
        sounding = true;
        System.out.println("  *** УВАГА! СИРЕНА! ***");
    }

    public void reset() { sounding = false; }
    public boolean isSounding() { return sounding; }
}

class SmartLab {
    private final String labName;
    private final EmergencySiren siren = new EmergencySiren();
    private final AbstractSensor[] sensors;
    private int count;

    public SmartLab(String labName, int maxSensors) {
        this.labName = labName;
        this.sensors = new AbstractSensor[maxSensors];
    }

    public void addSensor(AbstractSensor s) {
        if (s != null && count < sensors.length) sensors[count++] = s;
    }

    public void runDiagnostics() {
        System.out.println("Діагностика: " + labName);
        int alarms = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("  " + sensors[i]);
            if (sensors[i].isAlarmTriggered()) alarms++;
        }
        if (alarms > 0) {
            siren.activate();
            System.out.println("  Тривог: " + alarms);
        } else {
            siren.reset();
            System.out.println("  Все в нормі");
        }
    }
}

abstract class AbstractFilter {
    private final String filterName;

    public AbstractFilter(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterName() { return filterName; }

    public abstract double processSample(double x);
}

class AmplifierFilter extends AbstractFilter {
    private final double gain;

    public AmplifierFilter(double gain) {
        super("Підсилювач x" + gain);
        this.gain = gain;
    }

    @Override
    public double processSample(double x) { return x * gain; }
}

class ClippingFilter extends AbstractFilter {
    private final double threshold;

    public ClippingFilter(double threshold) {
        super("Обмежувач ±" + threshold);
        this.threshold = Math.abs(threshold);
    }

    @Override
    public double processSample(double x) {
        return Math.max(-threshold, Math.min(threshold, x));
    }
}

class SignalProcessor {
    private final AbstractFilter[] pipeline;
    private int count;

    public SignalProcessor(int maxFilters) {
        pipeline = new AbstractFilter[maxFilters];
    }

    public void addFilter(AbstractFilter f) {
        if (f != null && count < pipeline.length) pipeline[count++] = f;
    }

    public double[] process(double[] signal) {
        if (signal == null) return new double[0];
        double[] out = Arrays.copyOf(signal, signal.length);
        for (int f = 0; f < count; f++) {
            for (int i = 0; i < out.length; i++) {
                out[i] = pipeline[f].processSample(out[i]);
            }
        }
        return out;
    }

    @Override
    public String toString() {
        String s = "Конвеєр: вхід";
        for (int i = 0; i < count; i++) s += " -> " + pipeline[i].getFilterName();
        return s + " -> вихід";
    }
}
