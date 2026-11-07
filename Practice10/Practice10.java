package semester1.practice10;

import java.util.Arrays;

// головний клас
public class Practice10 {
    public static void main(String[] args) {

        // ===== Завдання 1 =====
        PaymentInstrument[] payments = {
                new BankCardInstrument("Іван"),
                new CryptoTokenInstrument("Олег", 42.0),
                new IbanDirectInstrument("ТОВ Ромашка")
        };
        double totalSpent = 0;
        for (PaymentInstrument p : payments) {
            double paid = p.processPayment(10000);
            totalSpent += paid;
            System.out.printf("%s (%s): комісія %.2f, разом %.2f грн%n",
                    p.getPayerName(), p.getClass().getSimpleName(), p.calculateFee(10000), paid);
        }
        System.out.printf("Сумарно по всіх інструментах: %.2f грн%n", totalSpent);

        // ===== Завдання 2 =====
        Shape2D[] shapes = {
                new CircleShape(3),
                new RectangleShape(4, 6),
                new EquilateralTriangleShape(8),
                new RectangleShape(5, 5)
        };
        for (Shape2D s : shapes) System.out.println(s);
        System.out.println("Найбільша площа: " + findMaxAreaShape(shapes));

        // ===== Завдання 3 =====
        VectorMathOverload vm = new VectorMathOverload();
        System.out.println("norm(-7) = " + vm.norm(-7));
        System.out.println("norm(3, 4) = " + vm.norm(3, 4));
        System.out.println("norm({1, 2, 2}) = " + vm.norm(new double[]{1, 2, 2}));
        BinaryOperation[] ops = {new AddOp(), new MultiplyOp(), new HypotenuseOp()};
        for (BinaryOperation op : ops) {
            System.out.println(op.getClass().getSimpleName() + ".apply(3.0, 4.0) = " + op.apply(3.0, 4.0));
        }

        // ===== Завдання 4 =====
        NotificationSender[] senders = {
                new EmailSender("admin@factory.ua"),
                new SmsSender("+380671234567"),
                new TelegramBotSender("@duty_engineer")
        };
        broadcastAlert(senders, "Температура в серверній перевищила 35°C. Терміново перевірте кондиціонер у стійці B2!");

        // ===== Завдання 5 =====
        ShippingTariff[] tariffs = {new RoadTruckTariff(), new AirCargoTariff(), new RailFreightTariff()};
        ShippingTariff best = tariffs[0];
        for (ShippingTariff t : tariffs) {
            double cost = t.calculateCost(250, 600);
            System.out.printf("%s: %.2f грн%n", t.getClass().getSimpleName(), cost);
            if (cost < best.calculateCost(250, 600)) best = t;
        }
        System.out.println("Найвигідніше: " + best.getClass().getSimpleName());

        // ===== Завдання 6 =====
        DifferentiableFunction[] funcs = {
                new QuadraticParabola(1, -3, 2),
                new NaturalLogFunction(2),
                new ExponentialGrowth(1, 0.5)
        };
        System.out.println("Функція                 f(2)       f'(2)");
        for (DifferentiableFunction fn : funcs) {
            System.out.printf("%-22s %9.5f %10.5f%n", fn, fn.f(2.0), fn.derivativeAt(2.0));
        }

        // ===== Завдання 7 =====
        UiWidget[] page = {
                new TextInputWidget("login", 300, 32, "Введіть логін"),
                new ButtonWidget("submit", 120, 40, "Увійти"),
                new ProgressBarWidget("upload", 300, 16, 140) // 140 --> 100
        };
        System.out.println(buildHtmlPage("Вхід", page));

        // ===== Завдання 8 =====
        IndustrialAsset[] workshop = {
                new LinearDepreciationAsset("Токарний верстат", 480000, 10),
                new LinearDepreciationAsset("Мостовий кран", 1200000, 20),
                new DecliningBalanceAsset("Сервер ЧПУ", 250000, 5, 0.3)
        };
        double totalBook = 0;
        for (IndustrialAsset asset : workshop) {
            double v = asset.getBookValueAfterYears(3);
            totalBook += v;
            System.out.printf("%s: було %.0f, через 3 роки %.2f%n", asset.getName(), asset.initialCost, v);
        }
        System.out.printf("Залишкова вартість цеху: %.2f грн%n", totalBook);

        // ===== Завдання 9 =====
        Measurable[] things = {new BankVault(1250), new HighwayRoute("М-06 Київ-Чоп", 890), new CpuCore(4.7)};
        System.out.println("Середнє (кг, км і ГГц разом, сенсу мало, але працює): " + computeAverage(things));
        Measurable[] cpus = {new CpuCore(3.2), new CpuCore(4.0), new CpuCore(5.1)};
        System.out.printf("Середня частота ядер: %.2f ГГц%n", computeAverage(cpus));

        // ===== Завдання 10 =====
        EnergyConvertible[] energies = {new KineticBody(1500, 27.8), new BatteryCell(75000)};
        for (EnergyConvertible e : energies) {
            System.out.printf("%s: %.0f Дж = %.3f кВт*год%n", e, e.getEnergyJoules(), e.getEnergyKwh());
        }
        System.out.println("c = " + EnergyConvertible.SPEED_OF_LIGHT + " м/с");

        // ===== Завдання 11 =====
        AmphibiousRescueDrone drone = new AmphibiousRescueDrone("RD-07");
        testFlight(drone);
        testDiving(drone);
        logPosition(drone);

        // ===== Завдання 12 =====
        DataValidator email = new EmailValidator();
        DataValidator positive = new PositiveNumberValidator();
        System.out.println(email.validateOrDefault("student@univ.edu.ua", "немає"));
        System.out.println(email.validateOrDefault("student-univ", "немає"));
        System.out.println(positive.validateOrDefault("42.5", "0"));
        System.out.println(positive.validateOrDefault("-3", "0"));
        System.out.println(positive.validateOrDefault("abc", "0"));
        System.out.println("isNotNullOrBlank(\"   \"): " + DataValidator.isNotNullOrBlank("   "));

        // ===== Завдання 13 =====
        EmergencyBeacon beacon = new EmergencyBeacon();
        System.out.println(beacon.emitAlert());

        // ===== Завдання 14 =====
        EscrowSmartContract escrow = new EscrowSmartContract("0xA1B2", 2500.0, 21000);
        System.out.println("Підпис 'wrong': " + escrow.verifySignature("wrong"));
        System.out.println("Виконати з gas 15000: " + escrow.executeContract(15000));
        System.out.println("Підпис '0xA1B2': " + escrow.verifySignature("0xA1B2"));
        System.out.println("Виконати з gas 30000: " + escrow.executeContract(30000));
        System.out.println(escrow.getAuditTrail());

        // ===== Завдання 15 =====
        Transformable2D[] scene = {new BoundingBox(0, 0, 10, 5), new CircleRegion(3, 3, 2)};
        applyGlobalTransform(scene, 2, -1, 1.5);
        for (Transformable2D t : scene) System.out.println(t);

        // ===== Завдання 16 =====
        DataExportable[] records = {
                new StudentGradeRecord("Бондар Максим", 11, 87.4),
                new StudentGradeRecord("Коваль Анна", 12, 93.1),
                new WeatherObservation("Харків", 6.5, 81),
                new WeatherObservation("Одеса", 11.2, 74)
        };
        System.out.println("JSON:");
        System.out.print("[");
        for (int i = 0; i < records.length; i++) {
            System.out.print((i == 0 ? "\n  " : ",\n  ") + records[i].toJson());
        }
        System.out.println("\n]");
        System.out.println("CSV:");
        for (DataExportable r : records) System.out.println(r.toCsvRow());

        // ===== Завдання 17 =====
        Falcon falcon = new Falcon(1.1);
        EmperorPenguin penguin = new EmperorPenguin(32);
        CargoPlane plane = new CargoPlane("Ан-124 Руслан");
        AbstractBird[] birds = {falcon, penguin};
        for (AbstractBird bird : birds) System.out.println(bird.getSpecies() + ": " + bird.makeSound());
        FlyableUnit[] flyers = {falcon, plane}; // тут без пингвина
        for (FlyableUnit f : flyers) System.out.println(f + " летить " + f.getFlightSpeedKmh() + " км/год");
        System.out.println("Пінгвін пірнає на " + penguin.getDiveDepthMeters() + " м");

        // ===== Завдання 18 =====
        SmartLedChandelier chandelier = new SmartLedChandelier("Вітальня", "Xiaomi Yeelight", 60);
        SmartUnderfloorHeating floor = new SmartUnderfloorHeating("Ванна", "Warmstad WSS", 1200);
        chandelier.turnOn();
        chandelier.setBrightness(40);
        floor.turnOn();
        floor.setTargetTemperature(26);
        AbstractSmartAppliance[] house = {chandelier, floor};
        double watts = 0;
        for (AbstractSmartAppliance ap : house) {
            System.out.println(ap);
            watts += ap.getCurrentWatts();
        }
        System.out.println("Будинок споживає: " + watts + " Вт");

        // ===== Завдання 19 =====
        TechGrowthStock nvda = new TechGrowthStock("NVDA", 10, 5800);
        BlueChipStock ko = new BlueChipStock("KO", 40, 2900, 80);
        FixedTermDeposit dep = new FixedTermDeposit("ДЕП-12М", 100000, 14.5);
        nvda.buy(5);
        System.out.println("Продати 100 KO: " + ko.sell(100));
        ko.sell(10);
        AbstractFinancialInstrument[] portfolio = {nvda, ko, dep};
        double value = 0;
        for (AbstractFinancialInstrument fi : portfolio) {
            System.out.println(fi);
            value += fi.getMarketValueUah();
        }
        System.out.printf("Вартість портфеля: %.2f грн%n", value);
        DividendPaying[] income = {ko, dep};
        for (DividendPaying d : income) System.out.printf("Пасивний дохід: %.2f грн/рік%n", d.calculateAnnualDividend());

        // ===== Завдання 20 =====
        Vec2D v = new Vec2D(3, 4);
        Rotation2DOperator rot = new Rotation2DOperator(90);
        ProjectionXOperator proj = new ProjectionXOperator();
        Vec2D rotated = rot.transform(v);
        System.out.println(v + " -> поворот 90° -> " + rotated + " -> назад -> " + rot.inverseTransform(rotated));
        System.out.println(v + " -> проєкція на OX -> " + proj.transform(v) + " (y втрачено, зворотного немає)");
        AbstractVectorOperator[] operators = {rot, proj};
        for (AbstractVectorOperator op : operators) {
            System.out.println(op.getName() + " зворотний: " + (op instanceof InvertibleOperator));
        }

        // ===== Завдання 21 =====
        AbstractVehicle[] fleet = {
                new ElectricCityBus("AA1234EB", 88, 350),
                new DieselDumpTruck("BC7788CT", 25),
                new CargoPassengerVan("KA0011IX", 1.2, 8)
        };
        for (AbstractVehicle veh : fleet) System.out.println(veh);

        // ===== Завдання 22 =====
        HeavySniper sniper = new HeavySniper("Сокіл");
        CombatMedic medic = new CombatMedic("Ліра");
        PaladinCaptain captain = new PaladinCaptain("Тур");
        RangedAttacker[] shooters = {sniper, captain};
        for (RangedAttacker r : shooters) System.out.println("Постріл на " + r.getAttackRange() + " м: " + r.fireShot() + " шкоди");
        FieldHealer[] healers = {medic, captain};
        for (FieldHealer h : healers) System.out.println("Лікування: +" + h.healAlly() + " HP");
        AbstractMilitaryUnit[] squad = {sniper, medic, captain};
        for (AbstractMilitaryUnit u : squad) System.out.println(u);

        // ===== Завдання 23 =====
        ElectronicScale scale = new ElectronicScale("LAB-SC-01", 100.37);
        GlassThermometer thermo = new GlassThermometer("LAB-TH-14", 22.5);
        AbstractLabDevice[] devices = {scale, thermo};
        for (AbstractLabDevice d : devices) d.performMeasurement();
        System.out.println("Самоперевірка ваг: " + scale.runSelfCheck());
        scale.calibrate(100.0);
        scale.performMeasurement();

        // ===== Завдання 24 =====
        CaesarCipherProcessor caesar = new CaesarCipherProcessor(3);
        TextProcessor[] pipeline = {new WhitespaceTrimmerProcessor(), caesar};
        String text = "   Hello    Java   world  ";
        String processed = text;
        for (TextProcessor tp : pipeline) processed = tp.process(processed);
        System.out.println("'" + text + "' -> '" + processed + "'");
        System.out.println("Розшифровка: '" + caesar.reverseProcess(processed) + "'");

        // ===== Завдання 25 =====
        Shape2D[] figures = {new CircleShape(2.5), new RectangleShape(3, 4), new RectangleShape(6, 6), new EquilateralTriangleShape(3)};
        for (Shape2D s : figures) {
            if (s instanceof CircleShape c) {
                System.out.println("Коло: діаметр " + c.getDiameter());
            } else if (s instanceof RectangleShape r) {
                System.out.println("Прямокутник: діагональ " + r.getDiagonal() + ", квадрат: " + r.isSquare());
            } else {
                System.out.println("Інша фігура: " + s);
            }
        }
        Shape2D nothing = null;
        System.out.println("null instanceof Shape2D: " + (nothing instanceof Shape2D));

        // ===== Завдання 26 =====
        Object[] warehouse = {
                new Laptop("Lenovo ThinkPad", 35),
                new DesktopMonitor("Dell U2723QE"),
                new ElectricScooter("Xiaomi Pro 2", 100), // фулл зарядка
                new WiredPrinter("Canon LBP"),
                new SmartWatch("Garmin Fenix", 8)
        };
        System.out.println("Заряджено пристроїв: " + chargeAllPossible(warehouse));

        // ===== Завдання 27 =====
        AbstractWorker[] staff = {
                new FullTimeDeveloper("Андрій", 72000),
                new FullTimeDeveloper("Марта", 65000),
                new FopContractor("Віталій ФОП", 54000),
                new InternStudent("Петро", 12000)
        };
        auditStaff(staff);

        // ===== Завдання 28 =====
        ShipModule[] modules = {
                new ShieldGenerator("Щит-А", false, 40),
                new WarpDrive("Варп-ядро", false, 0.997),
                new LifeSupportModule("Життєзабезпечення", true, 18.4),
                new WarpDrive("Резервний варп", true, 0.81)
        };
        runShipInspection(modules);

        // ===== Завдання 29 =====
        MediaItem[] library = {
                new VideoFile("Дюна 2", 18500, 2160, 9960),
                new VideoFile("Влог з Карпат", 1400, 1080, 900),
                new AudioFile("Pink Floyd - Time.flac", 48.2, 1411),
                new AudioFile("Подкаст.mp3", 62.0, 128),
                new EBookFile("Clean Code.pdf", 4.1, 464)
        };
        double premiumMb = 0;
        for (MediaItem m : library) {
            if (m instanceof VideoFile vf && vf.is4K()) {
                System.out.println("4K: " + vf.getTitle());
                premiumMb += vf.getSizeMb();
            } else if (m instanceof AudioFile af && af.isLossless()) {
                System.out.println("Lossless: " + af.getTitle());
                premiumMb += af.getSizeMb();
            }
        }
        System.out.println("Обсяг 4K + Lossless: " + premiumMb + " МБ");

        // ===== Завдання 30 =====
        AbstractCustomer[] customers = {new RegularCustomer("Ольга"), new StudentCustomer("Денис"), new VipCustomer("Пан Сергій")};
        for (AbstractCustomer cust : customers) {
            System.out.printf("%s (знижка %.0f%%): 2000 грн -> %.2f грн%n", cust.getName(), cust.getDiscountPercent(), calculatePrice(2000, cust));
        }

        // ===== Завдання 31 =====
        Matrix2x2[] matrices = {new RotationMatrix2x2(30), new SingularMatrix2x2(1, 2, 2, 4), new Matrix2x2(2, 1, 1, 3)};
        for (Matrix2x2 m : matrices) {
            System.out.printf("%s det=%.3f%n", m, m.determinant());
            if (m instanceof InvertibleMatrix inv) {
                System.out.println("   обернена: " + inv.inverse());
            } else {
                System.out.println("   обернену не шукаємо (інтерфейс не реалізовано)");
            }
            if (m instanceof OrthogonalMatrix orth) System.out.println("   ортогональна: " + orth.checkOrthogonality());
        }

        // ===== Завдання 32 =====
        CargoContainer[] containers = {
                new CargoContainer("MSKU-100", "Ноутбуки", 4.2),
                new ChemicalContainer("TGHU-201", "Ацетон", 18.0, 3),
                new FrozenFoodContainer("CRXU-305", "Морозиво", 12.5, -22),
                new FrozenFoodContainer("CRXU-306", "Риба", 15.0, -18)
        };
        customsTerminal(containers);

        // ===== Завдання 33 =====
        double[] coef = {1.002, 0.998, 1.010};
        FinalCalibrationTable table = new FinalCalibrationTable("SN-55-AX", coef);
        // table.sensorSerial = "SN-HACK"; // ошибка: cannot assign a value to final variable
        coef[0] = 777; // меняем внешний массив
        double[] fromGetter = table.getCoefficients();
        fromGetter[1] = -1; // і через геттер тоже не получится
        System.out.println(table);
        System.out.println("g = " + FinalCalibrationTable.GRAVITY_G);
        final double[] localArr = {1, 2, 3};
        localArr[0] = 100; // final только ссылка
        // localArr = new double[5]; // тут ошибка
        System.out.println("final масив, але елемент змінився: " + Arrays.toString(localArr));

        // ===== Завдання 34 =====
        AbstractSecurityProtocol[] protocols = {new JwtSecurityProtocol(), new ApiKeySecurityProtocol("k-7f3a9")};
        System.out.println(protocols[0].runSecureCommand("eyJhbGciOi.eyJzdWIiOi.c2lnbmF0", "restart nginx"));
        System.out.println(protocols[0].runSecureCommand("random-token", "restart nginx"));
        System.out.println(protocols[1].runSecureCommand("k-7f3a9", "backup db"));
        System.out.println(protocols[1].runSecureCommand(null, "backup db"));

        // ===== Завдання 35 =====
        MetricSpaceElement[] points = {new ImmutableVector3D(1, 2, 2), new ImmutableVector3D(4, 6, 2), new ScalarValue(-5)};
        for (MetricSpaceElement p : points) System.out.println(p + ", норма " + p.getNorm());
        System.out.println("Відстань між векторами: " + points[0].distanceTo(points[1]));
        System.out.println("Відстань вектор - скаляр: " + points[0].distanceTo(points[2]));
        // class HackedVector extends ImmutableVector3D {} // ошибка: cannot inherit from final

        // ===== Завдання 36 =====
        PrintableDocument[] docs = {
                new FiscalReceipt("ФН-3000123456", 1440.00),
                new WarehouseReport("Склад №2", 340, 12),
                new FiscalReceipt("ФН-3000123457", 99.90)
        };
        for (PrintableDocument d : docs) {
            System.out.println(d.formatForPrinter());
            System.out.println();
        }

        // ===== Завдання 37 =====
        PowerProducer[] grid = {
                new NuclearStation("ЗАЕС-блок1", 1000),
                new SolarFarmStation("СЕС Херсонська", 120),
                new HydroDamStation("Дніпровська ГЕС", 1500)
        };
        SmartGridController controller = new SmartGridController(grid);
        controller.updateAndReport(0.8);
        controller.updateAndReport(0.2);

        // ===== Завдання 38 =====
        CubicFunction cubic = new CubicFunction();
        System.out.printf("Інтеграл %s на [0; 3] (n=1000): %.6f%n", cubic, cubic.integrateTrapezoid(0, 3, 1000));
        System.out.println("Точно: x^4/4 - x^2 - 5x = -3.75");
        double root = cubic.findRootBisection(2.0, 3.0, 1e-6);
        System.out.printf("Корінь на [2; 3]: %.6f, f(корінь) = %.2e%n", root, cubic.evaluate(root));

        // ===== Завдання 39 =====
        AbstractCombatUnit[] arena = {
                new BerserkerAssasin("Берсерк Рагнар"),
                new TrollWarlord("Троль Гронк"),
                new RoyalPaladin("Паладин Артур")
        };
        runBattle(arena);
    }

    // ---------- вспомогитальные статичные методы ----------

    // ко второму заданию
    public static Shape2D findMaxAreaShape(Shape2D[] shapes) {
        if (shapes == null || shapes.length == 0) return null;
        Shape2D max = shapes[0];
        for (Shape2D s : shapes) {
            if (s.getArea() > max.getArea()) max = s;
        }
        return max;
    }

    // к четвёртому заданию
    public static void broadcastAlert(NotificationSender[] senders, String alertText) {
        for (NotificationSender s : senders) {
            System.out.println(s.send(alertText));
        }
    }

    // к седьмому заданию
    public static String buildHtmlPage(String title, UiWidget[] pageElements) {
        String html = "<html>\n<head><title>" + title + "</title></head>\n<body>\n";
        for (UiWidget w : pageElements) html += "  " + w.renderHtml() + "\n";
        return html + "</body>\n</html>";
    }

    // к девятому заданию
    public static double computeAverage(Measurable[] items) {
        if (items == null || items.length == 0) return 0;
        double sum = 0;
        for (Measurable m : items) sum += m.getMeasure();
        return sum / items.length;
    }

    // к 21 заданию
    public static void testFlight(Flyable f) {
        f.takeOff();
        System.out.println("  макс. висота: " + f.getMaxAltitude() + " м");
    }

    public static void testDiving(Swimmable s) {
        s.dive(25);
        s.dive(500);
        System.out.println("  макс. глибина: " + s.getMaxDepth() + " м");
    }

    public static void logPosition(GpsTrackable g) {
        System.out.println("  GPS: " + g.getCoordinates());
    }

    // к 15 заданию
    public static void applyGlobalTransform(Transformable2D[] objects, double dx, double dy, double scaleFactor) {
        for (Transformable2D t : objects) {
            t.translate(dx, dy);
            t.scale(scaleFactor);
        }
    }

    // к 26 заданию
    public static int chargeAllPossible(Object[] items) {
        int charged = 0;
        for (Object item : items) {
            if (item instanceof Rechargeable r) {
                if (r.chargeToFull()) charged++;
            } else {
                System.out.println("  " + item + " - дротовий, пропускаємо");
            }
        }
        return charged;
    }

    // к 27 заданию
    public static void auditStaff(AbstractWorker[] staff) {
        double payroll = 0, bonuses = 0;
        int insured = 0;
        for (AbstractWorker w : staff) {
            payroll += w.getMonthlyPay();
            if (w instanceof BonusEligible b) bonuses += b.calculateQuarterBonus();
            if (w instanceof MedicalInsured) insured++;
        }
        System.out.printf("Фонд оплати праці: %.2f, квартальні премії: %.2f, застраховано: %d з %d%n",
                payroll, bonuses, insured, staff.length);
    }

    // к 28 заданию
    public static void runShipInspection(ShipModule[] modules) {
        for (ShipModule m : modules) {
            System.out.print(m.getName() + (m.isDamaged() ? " [ПОШКОДЖЕНО]" : "") + ": ");
            if (m instanceof ShieldGenerator sg) {
                sg.rechargeShields(60);
            } else if (m instanceof WarpDrive wd) {
                System.out.println(wd.checkAntimatterContainment() ? "антиматерія стабільна" : "РИЗИК ПРОРИВУ КОНТЕЙНМЕНТУ!");
            } else if (m instanceof LifeSupportModule ls) {
                double o2 = ls.getOxygenPercent();
                System.out.println("кисень " + o2 + "%" + (o2 < 19.5 ? " - нижче норми!" : ""));
            }
        }
    }

    // к 30 заданию
    // было так:
    // double calculateDiscount(Customer c) {
    //     if (c instanceof VipCustomer) return 20;
    //     else if (c instanceof StudentCustomer) return 10;
    //     else return 0;
    // }
    // каждый новый тип клиента = ещё один else if. стало так:
    public static double calculatePrice(double price, AbstractCustomer customer) {
        return price * (1.0 - customer.getDiscountPercent() / 100.0);
    }

    // к 32 заданию
    public static void customsTerminal(CargoContainer[] containers) {
        for (CargoContainer c : containers) {
            System.out.print(c + " -> ");
            if (c instanceof HazardousCargo hz) {
                System.out.println("спецбокс для небезпечних вантажів, клас " + hz.getHazardClass());
            } else if (c instanceof RefrigeratedCargo rf) {
                System.out.println("підключено до живлення, тримати " + rf.getRequiredTempC() + "°C");
            } else {
                System.out.println("звичайний огляд");
            }
        }
    }

    // к 39 заданию
    public static void runBattle(AbstractCombatUnit[] units) {
        for (int round = 1; round <= 15; round++) {
            int alive = 0;
            for (AbstractCombatUnit u : units) if (u.isAlive()) alive++;
            if (alive <= 1) break;
            System.out.println("--- Раунд " + round + " ---");
            for (int i = 0; i < units.length; i++) {
                AbstractCombatUnit attacker = units[i];
                if (!attacker.isAlive()) continue;
                if (attacker instanceof SelfRegenerating reg) {
                    int healed = reg.regenerateHp();
                    if (healed > 0) System.out.println(attacker.getName() + " регенерує +" + healed);
                }
                AbstractCombatUnit defender = null;
                for (int j = 1; j < units.length; j++) {
                    AbstractCombatUnit cand = units[(i + j) % units.length];
                    if (cand.isAlive()) {
                        defender = cand;
                        break;
                    }
                }
                if (defender == null) break;
                int dmg = attacker.calculateDamage();
                if (attacker instanceof CriticalStriker crit && round % 2 == 0) {
                    dmg = (int) (dmg * crit.getCritMultiplier());
                    System.out.print("КРИТ! ");
                }
                if (defender instanceof ShieldBearer shield) {
                    dmg = shield.absorbDamage(dmg);
                }
                defender.receiveDamage(dmg);
                System.out.println(attacker.getName() + " -> " + defender.getName() + ": " + dmg + " (лишилось " + defender.getHp() + " HP)");
            }
        }
        AbstractCombatUnit winner = units[0];
        for (AbstractCombatUnit u : units) if (u.getHp() > winner.getHp()) winner = u;
        System.out.println("Переможець: " + winner.getName() + " з " + winner.getHp() + " HP");
    }
}

// класи завдань

abstract class PaymentInstrument {
    private final String payerName;

    public PaymentInstrument(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerName() { return payerName; }

    public abstract double calculateFee(double amount);

    public double processPayment(double amount) {
        return amount + calculateFee(amount);
    }
}

class BankCardInstrument extends PaymentInstrument {
    public BankCardInstrument(String payerName) {
        super(payerName);
    }

    @Override
    public double calculateFee(double amount) {
        return amount * 0.015 + 5.0;
    }
}

class CryptoTokenInstrument extends PaymentInstrument {
    private final double gasFeeUah;

    public CryptoTokenInstrument(String payerName, double gasFeeUah) {
        super(payerName);
        this.gasFeeUah = gasFeeUah;
    }

    @Override
    public double calculateFee(double amount) {
        return gasFeeUah;
    }
}

class IbanDirectInstrument extends PaymentInstrument {
    public IbanDirectInstrument(String payerName) {
        super(payerName);
    }

    @Override
    public double calculateFee(double amount) {
        return amount <= 50000 ? 0 : amount * 0.005;
    }
}

abstract class Shape2D {
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return String.format("%s S=%.2f P=%.2f", getClass().getSimpleName(), getArea(), getPerimeter());
    }
}

class CircleShape extends Shape2D {
    private final double r;

    public CircleShape(double r) {
        this.r = r > 0 ? r : 1;
    }

    @Override
    public double getArea() { return Math.PI * r * r; }

    @Override
    public double getPerimeter() { return 2 * Math.PI * r; }

    // завд. 25
    public double getDiameter() { return 2 * r; }
}

class RectangleShape extends Shape2D {
    private final double a;
    private final double b;

    public RectangleShape(double a, double b) {
        this.a = a > 0 ? a : 1;
        this.b = b > 0 ? b : 1;
    }

    @Override
    public double getArea() { return a * b; }

    @Override
    public double getPerimeter() { return 2 * (a + b); }

    // завд. 25
    public double getDiagonal() { return Math.sqrt(a * a + b * b); }
    public boolean isSquare() { return a == b; }
}

class EquilateralTriangleShape extends Shape2D {
    private final double a;

    public EquilateralTriangleShape(double a) {
        this.a = a > 0 ? a : 1;
    }

    @Override
    public double getArea() { return Math.sqrt(3) / 4 * a * a; }

    @Override
    public double getPerimeter() { return 3 * a; }
}

// статический полиморфизм
class VectorMathOverload {
    public double norm(double x) {
        return Math.abs(x);
    }

    public double norm(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    public double norm(double[] v) {
        double sum = 0;
        for (double d : v) sum += d * d;
        return Math.sqrt(sum);
    }
}

// динамический полиморфизм
abstract class BinaryOperation {
    public abstract double apply(double a, double b);
}

class AddOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) { return a + b; }
}

class MultiplyOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) { return a * b; }
}

class HypotenuseOp extends BinaryOperation {
    @Override
    public double apply(double a, double b) { return Math.sqrt(a * a + b * b); }
}

class NotificationSender {
    private final String recipient;

    public NotificationSender(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() { return recipient; }

    public String send(String message) {
        return "-> " + recipient + ": " + message;
    }
}

class EmailSender extends NotificationSender {
    public EmailSender(String recipient) {
        super(recipient);
    }

    @Override
    public String send(String message) {
        return "[EMAIL] To: " + getRecipient() + "\n        Subject: Тривога системи моніторингу\n        " + message;
    }
}

class SmsSender extends NotificationSender {
    private static final int MAX_LEN = 70;

    public SmsSender(String recipient) {
        super(recipient);
    }

    @Override
    public String send(String message) {
        if (message.length() > MAX_LEN) message = message.substring(0, MAX_LEN - 3) + "...";
        return "[SMS] " + super.send(message);
    }
}

class TelegramBotSender extends NotificationSender {
    public TelegramBotSender(String recipient) {
        super(recipient);
    }

    @Override
    public String send(String message) {
        return "[TG] " + getRecipient() + ": ⚠️ *ТРИВОГА* ⚠️\n     _" + message + "_";
    }
}

abstract class ShippingTariff {
    public abstract double calculateCost(double weightKg, double distanceKm);
}

class RoadTruckTariff extends ShippingTariff {
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 15.0 * distanceKm + 2.5 * weightKg;
    }
}

class AirCargoTariff extends ShippingTariff {
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 45.0 * distanceKm + 18.0 * weightKg + 500.0;
    }
}

class RailFreightTariff extends ShippingTariff {
    @Override
    public double calculateCost(double weightKg, double distanceKm) {
        return 1200.0 + 4.0 * distanceKm + 0.8 * weightKg;
    }
}

abstract class DifferentiableFunction {
    private static final double H = 1e-5;

    public abstract double f(double x);

    public double derivativeAt(double x) {
        return (f(x + H) - f(x - H)) / (2 * H);
    }
}

class QuadraticParabola extends DifferentiableFunction {
    private final double a, b, c;

    public QuadraticParabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double f(double x) { return a * x * x + b * x + c; }

    @Override
    public String toString() { return a + "x^2 + " + b + "x + " + c; }
}

class NaturalLogFunction extends DifferentiableFunction {
    private final double k;

    public NaturalLogFunction(double k) {
        this.k = k;
    }

    @Override
    public double f(double x) {
        if (x <= 0) return Double.NaN; // ln не визначений
        return k * Math.log(x);
    }

    @Override
    public String toString() { return k + "*ln(x)"; }
}

class ExponentialGrowth extends DifferentiableFunction {
    private final double amplitude;
    private final double lambda;

    public ExponentialGrowth(double amplitude, double lambda) {
        this.amplitude = amplitude;
        this.lambda = lambda;
    }

    @Override
    public double f(double x) { return amplitude * Math.exp(lambda * x); }

    @Override
    public String toString() { return amplitude + "*e^(" + lambda + "x)"; }
}

abstract class UiWidget {
    protected String id;
    protected int width;
    protected int height;

    public UiWidget(String id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    protected String style() {
        return "style=\"width:" + width + "px;height:" + height + "px\"";
    }

    public abstract String renderHtml();
}

class ButtonWidget extends UiWidget {
    private String label;

    public ButtonWidget(String id, int width, int height, String label) {
        super(id, width, height);
        this.label = label;
    }

    @Override
    public String renderHtml() {
        return "<button id=\"" + id + "\" " + style() + ">" + label + "</button>";
    }
}

class TextInputWidget extends UiWidget {
    private String placeholder;

    public TextInputWidget(String id, int width, int height, String placeholder) {
        super(id, width, height);
        this.placeholder = placeholder;
    }

    @Override
    public String renderHtml() {
        return "<input type=\"text\" id=\"" + id + "\" placeholder=\"" + placeholder + "\" " + style() + ">";
    }
}

class ProgressBarWidget extends UiWidget {
    private int progressPercent;

    public ProgressBarWidget(String id, int width, int height, int progressPercent) {
        super(id, width, height);
        this.progressPercent = Math.max(0, Math.min(100, progressPercent));
    }

    @Override
    public String renderHtml() {
        return "<progress id=\"" + id + "\" value=\"" + progressPercent + "\" max=\"100\" " + style() + "></progress>";
    }
}

abstract class IndustrialAsset {
    private final String name;
    protected final double initialCost;
    protected final int usefulLifeYears;

    public IndustrialAsset(String name, double initialCost, int usefulLifeYears) {
        this.name = name;
        this.initialCost = initialCost;
        this.usefulLifeYears = Math.max(1, usefulLifeYears);
    }

    public String getName() { return name; }

    public abstract double getBookValueAfterYears(int years);
}

class LinearDepreciationAsset extends IndustrialAsset {
    public LinearDepreciationAsset(String name, double initialCost, int usefulLifeYears) {
        super(name, initialCost, usefulLifeYears);
    }

    @Override
    public double getBookValueAfterYears(int years) {
        if (years >= usefulLifeYears) return 0;
        return initialCost * (1 - (double) years / usefulLifeYears);
    }
}

class DecliningBalanceAsset extends IndustrialAsset {
    private final double rate;

    public DecliningBalanceAsset(String name, double initialCost, int usefulLifeYears, double rate) {
        super(name, initialCost, usefulLifeYears);
        this.rate = rate;
    }

    @Override
    public double getBookValueAfterYears(int years) {
        return initialCost * Math.pow(1 - rate, years);
    }
}

interface Measurable {
    double getMeasure();
}

class BankVault implements Measurable {
    private final double goldKg;

    public BankVault(double goldKg) {
        this.goldKg = goldKg;
    }

    @Override
    public double getMeasure() { return goldKg; }
}

class HighwayRoute implements Measurable {
    private final String name;
    private final double lengthKm;

    public HighwayRoute(String name, double lengthKm) {
        this.name = name;
        this.lengthKm = lengthKm;
    }

    @Override
    public double getMeasure() { return lengthKm; }
}

class CpuCore implements Measurable {
    private final double frequencyGhz;

    public CpuCore(double frequencyGhz) {
        this.frequencyGhz = frequencyGhz;
    }

    @Override
    public double getMeasure() { return frequencyGhz; }
}

interface EnergyConvertible {
    double SPEED_OF_LIGHT = 299_792_458.0;   // м/с
    double JOULES_PER_KWH = 3_600_000.0;

    double getEnergyJoules();

    default double getEnergyKwh() {
        return getEnergyJoules() / JOULES_PER_KWH;
    }
}

class KineticBody implements EnergyConvertible {
    private final double massKg;
    private final double velocityMs;

    public KineticBody(double massKg, double velocityMs) {
        this.massKg = massKg;
        this.velocityMs = velocityMs;
    }

    @Override
    public double getEnergyJoules() {
        return 0.5 * massKg * velocityMs * velocityMs;
    }

    @Override
    public String toString() {
        return "Тіло " + massKg + " кг на " + velocityMs + " м/с";
    }
}

class BatteryCell implements EnergyConvertible {
    private final double capacityWh;

    public BatteryCell(double capacityWh) {
        this.capacityWh = capacityWh;
    }

    @Override
    public double getEnergyJoules() {
        return capacityWh * 3600; // 1 Вт*год = 3600 Дж
    }

    @Override
    public String toString() {
        return "Батарея " + capacityWh + " Вт*год";
    }
}

interface Flyable {
    void takeOff();
    double getMaxAltitude();
}

interface Swimmable {
    void dive(double depthMeters);
    double getMaxDepth();
}

interface GpsTrackable {
    String getCoordinates();
}

class AmphibiousRescueDrone implements Flyable, Swimmable, GpsTrackable {
    private final String serial;
    private double altitude;
    private double depth;
    private double lat = 46.4825;
    private double lon = 30.7233;

    public AmphibiousRescueDrone(String serial) {
        this.serial = serial;
    }

    @Override
    public void takeOff() {
        altitude = 120;
        depth = 0;
        System.out.println(serial + " злетів на " + altitude + " м");
    }

    @Override
    public double getMaxAltitude() { return 3000; }

    @Override
    public void dive(double depthMeters) {
        if (depthMeters > getMaxDepth()) {
            System.out.println(serial + ": " + depthMeters + " м - занадто глибоко!");
            return;
        }
        altitude = 0;
        depth = depthMeters;
        System.out.println(serial + " пірнув на " + depth + " м");
    }

    @Override
    public double getMaxDepth() { return 60; }

    @Override
    public String getCoordinates() {
        return String.format("%.4f, %.4f (висота %.0f м, глибина %.0f м)", lat, lon, altitude, depth);
    }
}

interface DataValidator {
    boolean isValid(String input);

    default String validateOrDefault(String input, String fallback) {
        return isValid(input) ? input : fallback;
    }

    static boolean isNotNullOrBlank(String s) {
        return s != null && !s.isBlank();
    }
}

class EmailValidator implements DataValidator {
    @Override
    public boolean isValid(String input) {
        if (!DataValidator.isNotNullOrBlank(input)) return false;
        int at = input.indexOf('@');
        return at > 0 && input.indexOf('.', at) > at + 1;
    }
}

class PositiveNumberValidator implements DataValidator {
    @Override
    public boolean isValid(String input) {
        if (!DataValidator.isNotNullOrBlank(input)) return false;
        try {
            return Double.parseDouble(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

interface AcousticSignal {
    default String emitAlert() { return "🔊 Звукова сирена 110 дБ"; }
}

interface OpticalSignal {
    default String emitAlert() { return "🚨 Стробоскопічний маячок"; }
}

class EmergencyBeacon implements AcousticSignal, OpticalSignal {
    @Override
    public String emitAlert() {
        return AcousticSignal.super.emitAlert() + " + " + OpticalSignal.super.emitAlert();
    }
}

interface Authenticatable {
    boolean verifySignature(String key);
}

interface Auditable {
    String getAuditTrail();
}

interface BlockchainSmartContract extends Authenticatable, Auditable {
    boolean executeContract(double gasLimit);
}

class EscrowSmartContract implements BlockchainSmartContract {
    private final String ownerKey;
    private final double lockedAmount;
    private final double requiredGas;
    private boolean verified;
    private boolean executed;
    private String audit = "";

    public EscrowSmartContract(String ownerKey, double lockedAmount, double requiredGas) {
        this.ownerKey = ownerKey;
        this.lockedAmount = lockedAmount;
        this.requiredGas = requiredGas;
        log("створено, заблоковано " + lockedAmount + " USDT");
    }

    private void log(String event) {
        audit += "\n  #" + (audit.split("\n").length) + " " + event;
    }

    @Override
    public boolean verifySignature(String key) {
        verified = ownerKey.equals(key);
        log("перевірка підпису: " + (verified ? "OK" : "FAIL"));
        return verified;
    }

    @Override
    public boolean executeContract(double gasLimit) {
        if (!verified) {
            log("відмова: підпис не перевірено");
            return false;
        }
        if (gasLimit < requiredGas) {
            log("відмова: gas " + gasLimit + " < " + requiredGas);
            return false;
        }
        executed = true;
        log("виконано, " + lockedAmount + " USDT передано продавцю");
        return true;
    }

    @Override
    public String getAuditTrail() {
        return "Аудит escrow-контракту (виконано: " + executed + "):" + audit;
    }
}

interface Transformable2D {
    void translate(double dx, double dy);
    void scale(double factor);
}

class BoundingBox implements Transformable2D {
    private double x, y, w, h;

    public BoundingBox(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    // масштаб відносно лівого нижнього кута
    @Override
    public void scale(double factor) {
        if (factor <= 0) return;
        w *= factor;
        h *= factor;
    }

    @Override
    public String toString() {
        return "BoundingBox{(" + x + "; " + y + "), " + w + "x" + h + "}";
    }
}

class CircleRegion implements Transformable2D {
    private double x, y, r;

    public CircleRegion(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void scale(double factor) {
        if (factor > 0) r *= factor;
    }

    @Override
    public String toString() {
        return "CircleRegion{центр (" + x + "; " + y + "), r=" + r + "}";
    }
}

interface DataExportable {
    String toJson();
    String toCsvRow();
}

class StudentGradeRecord implements DataExportable {
    private final String name;
    private final int group;
    private final double gpa;

    public StudentGradeRecord(String name, int group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    @Override
    public String toJson() {
        return "{\"type\": \"student\", \"name\": \"" + name + "\", \"group\": " + group + ", \"gpa\": " + gpa + "}";
    }

    @Override
    public String toCsvRow() {
        return "student;" + name + ";" + group + ";" + gpa;
    }
}

class WeatherObservation implements DataExportable {
    private final String city;
    private final double tempC;
    private final int humidity;

    public WeatherObservation(String city, double tempC, int humidity) {
        this.city = city;
        this.tempC = tempC;
        this.humidity = humidity;
    }

    @Override
    public String toJson() {
        return "{\"type\": \"weather\", \"city\": \"" + city + "\", \"tempC\": " + tempC + ", \"humidity\": " + humidity + "}";
    }

    @Override
    public String toCsvRow() {
        return "weather;" + city + ";" + tempC + ";" + humidity;
    }
}

abstract class AbstractBird {
    protected final String species;
    protected double weightKg;

    public AbstractBird(String species, double weightKg) {
        this.species = species;
        this.weightKg = weightKg;
    }

    public String getSpecies() { return species; }

    public abstract String makeSound();
}

interface FlyableUnit {
    double getFlightSpeedKmh();
}

interface SwimmingUnit {
    double getDiveDepthMeters();
}

class Falcon extends AbstractBird implements FlyableUnit {
    public Falcon(double weightKg) {
        super("Сокіл-сапсан", weightKg);
    }

    @Override
    public String makeSound() { return "Кек-кек-кек!"; }

    @Override
    public double getFlightSpeedKmh() { return 320; } // у піке

    @Override
    public String toString() { return species; }
}

class EmperorPenguin extends AbstractBird implements SwimmingUnit {
    public EmperorPenguin(double weightKg) {
        super("Імператорський пінгвін", weightKg);
    }

    @Override
    public String makeSound() { return "Ааа-ааа (труби)"; }

    @Override
    public double getDiveDepthMeters() { return 535; }
}

class CargoPlane implements FlyableUnit {
    private final String model;

    public CargoPlane(String model) {
        this.model = model;
    }

    @Override
    public double getFlightSpeedKmh() { return 800; }

    @Override
    public String toString() { return "Літак " + model; }
}

abstract class AbstractSmartAppliance {
    private final String room;
    private final String model;
    protected boolean poweredOn;

    public AbstractSmartAppliance(String room, String model) {
        this.room = room;
        this.model = model;
    }

    public void turnOn()  { poweredOn = true; }
    public void turnOff() { poweredOn = false; }

    public abstract double getCurrentWatts();

    @Override
    public String toString() {
        return room + ": " + model + " (" + (poweredOn ? "увімк" : "вимк") + ") " + getCurrentWatts() + " Вт";
    }
}

interface Dimmable {
    void setBrightness(int percent);
}

interface HeatingCapable {
    void setTargetTemperature(double celsius);
}

class SmartLedChandelier extends AbstractSmartAppliance implements Dimmable {
    private final double maxWatts;
    private int brightness = 100;

    public SmartLedChandelier(String room, String model, double maxWatts) {
        super(room, model);
        this.maxWatts = maxWatts;
    }

    @Override
    public void setBrightness(int percent) {
        brightness = Math.max(0, Math.min(100, percent));
    }

    @Override
    public double getCurrentWatts() {
        return poweredOn ? maxWatts * brightness / 100.0 : 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", яскравість " + brightness + "%";
    }
}

class SmartUnderfloorHeating extends AbstractSmartAppliance implements HeatingCapable {
    private final double maxWatts;
    private double targetTemp = 22;

    public SmartUnderfloorHeating(String room, String model, double maxWatts) {
        super(room, model);
        this.maxWatts = maxWatts;
    }

    @Override
    public void setTargetTemperature(double celsius) {
        targetTemp = Math.max(15, Math.min(35, celsius));
    }
    @Override
    public double getCurrentWatts() {
        if (!poweredOn) return 0;
        return maxWatts * (targetTemp - 15) / 20.0;
    }

    @Override
    public String toString() {
        return super.toString() + ", ціль " + targetTemp + "°C";
    }
}

abstract class AbstractFinancialInstrument {
    private final String ticker;
    protected int quantity;

    public AbstractFinancialInstrument(String ticker, int quantity) {
        this.ticker = ticker;
        this.quantity = Math.max(0, quantity);
    }

    public String getTicker() { return ticker; }

    public abstract double getMarketValueUah();

    @Override
    public String toString() {
        return String.format("%s x%d = %.2f грн", ticker, quantity, getMarketValueUah());
    }
}

interface Tradable {
    boolean buy(int qty);
    boolean sell(int qty);
}

interface DividendPaying {
    double calculateAnnualDividend();
}

class TechGrowthStock extends AbstractFinancialInstrument implements Tradable {
    private final double priceUah;

    public TechGrowthStock(String ticker, int quantity, double priceUah) {
        super(ticker, quantity);
        this.priceUah = priceUah;
    }

    @Override
    public boolean buy(int qty) {
        if (qty <= 0) return false;
        quantity += qty;
        return true;
    }

    @Override
    public boolean sell(int qty) {
        if (qty <= 0 || qty > quantity) return false;
        quantity -= qty;
        return true;
    }

    @Override
    public double getMarketValueUah() { return quantity * priceUah; }
}

class BlueChipStock extends AbstractFinancialInstrument implements Tradable, DividendPaying {
    private final double priceUah;
    private final double dividendPerShare;

    public BlueChipStock(String ticker, int quantity, double priceUah, double dividendPerShare) {
        super(ticker, quantity);
        this.priceUah = priceUah;
        this.dividendPerShare = dividendPerShare;
    }

    @Override
    public boolean buy(int qty) {
        if (qty <= 0) return false;
        quantity += qty;
        return true;
    }

    @Override
    public boolean sell(int qty) {
        if (qty <= 0 || qty > quantity) return false;
        quantity -= qty;
        return true;
    }

    @Override
    public double getMarketValueUah() { return quantity * priceUah; }

    @Override
    public double calculateAnnualDividend() { return quantity * dividendPerShare; }
}

class FixedTermDeposit extends AbstractFinancialInstrument implements DividendPaying {
    private final double principal;
    private final double ratePercent;

    public FixedTermDeposit(String ticker, double principal, double ratePercent) {
        super(ticker, 1);
        this.principal = principal;
        this.ratePercent = ratePercent;
    }

    @Override
    public double getMarketValueUah() { return principal; }

    @Override
    public double calculateAnnualDividend() { return principal * ratePercent / 100; }
}

class Vec2D {
    final double x, y;

    public Vec2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        // + 0.0 щоб не виводилось -0.00
        return String.format("(%.2f; %.2f)", x + 0.0, y + 0.0);
    }
}

abstract class AbstractVectorOperator {
    private final String name;

    public AbstractVectorOperator(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract Vec2D transform(Vec2D v);
}

interface InvertibleOperator {
    Vec2D inverseTransform(Vec2D v);
}

class Rotation2DOperator extends AbstractVectorOperator implements InvertibleOperator {
    private final double alphaRad;

    public Rotation2DOperator(double degrees) {
        super("Поворот на " + degrees + "°");
        this.alphaRad = Math.toRadians(degrees);
    }

    private Vec2D rotate(Vec2D v, double a) {
        return new Vec2D(v.x * Math.cos(a) - v.y * Math.sin(a), v.x * Math.sin(a) + v.y * Math.cos(a));
    }

    @Override
    public Vec2D transform(Vec2D v) { return rotate(v, alphaRad); }

    @Override
    public Vec2D inverseTransform(Vec2D v) { return rotate(v, -alphaRad); }
}

class ProjectionXOperator extends AbstractVectorOperator {
    public ProjectionXOperator() {
        super("Проєкція на OX");
    }

    @Override
    public Vec2D transform(Vec2D v) { return new Vec2D(v.x, 0); }
}

abstract class AbstractVehicle {
    private final String plateNumber;
    protected double mileageKm;

    public AbstractVehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() { return plateNumber; }
}

interface CargoCarrier {
    double getMaxPayloadTons();
}

interface PassengerCarrier {
    int getSeatCount();
}

interface ElectricPowered {
    double getBatteryCapacityKwh();
}

class ElectricCityBus extends AbstractVehicle implements PassengerCarrier, ElectricPowered {
    private final int seats;
    private final double batteryKwh;

    public ElectricCityBus(String plateNumber, int seats, double batteryKwh) {
        super(plateNumber);
        this.seats = seats;
        this.batteryKwh = batteryKwh;
    }

    @Override
    public int getSeatCount() { return seats; }

    @Override
    public double getBatteryCapacityKwh() { return batteryKwh; }

    @Override
    public String toString() {
        return "Електробус " + getPlateNumber() + ": " + seats + " місць, батарея " + batteryKwh + " кВт*год";
    }
}

class DieselDumpTruck extends AbstractVehicle implements CargoCarrier {
    private final double payload;

    public DieselDumpTruck(String plateNumber, double payload) {
        super(plateNumber);
        this.payload = payload;
    }

    @Override
    public double getMaxPayloadTons() { return payload; }

    @Override
    public String toString() {
        return "Самоскид " + getPlateNumber() + ": до " + payload + " т";
    }
}

class CargoPassengerVan extends AbstractVehicle implements CargoCarrier, PassengerCarrier {
    private final double payload;
    private final int seats;

    public CargoPassengerVan(String plateNumber, double payload, int seats) {
        super(plateNumber);
        this.payload = payload;
        this.seats = seats;
    }

    @Override
    public double getMaxPayloadTons() { return payload; }

    @Override
    public int getSeatCount() { return seats; }

    @Override
    public String toString() {
        return "Вантажопасажирський фургон " + getPlateNumber() + ": " + seats + " місць + " + payload + " т";
    }
}

abstract class AbstractMilitaryUnit {
    private final String unitName;
    protected int hp;

    public AbstractMilitaryUnit(String unitName, int hp) {
        this.unitName = unitName;
        this.hp = hp;
    }

    public String getUnitName() { return unitName; }

    public abstract int getMoveSpeed();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " \"" + unitName + "\": HP " + hp + ", швидкість " + getMoveSpeed();
    }
}

interface RangedAttacker {
    int getAttackRange();
    int fireShot();
}

interface FieldHealer {
    int healAlly();
}

class HeavySniper extends AbstractMilitaryUnit implements RangedAttacker {
    public HeavySniper(String name) {
        super(name, 80);
    }

    @Override
    public int getMoveSpeed() { return 3; }

    @Override
    public int getAttackRange() { return 1800; }

    @Override
    public int fireShot() { return 95; }
}

class CombatMedic extends AbstractMilitaryUnit implements FieldHealer {
    public CombatMedic(String name) {
        super(name, 90);
    }

    @Override
    public int getMoveSpeed() { return 6; }

    @Override
    public int healAlly() { return 40; }
}

class PaladinCaptain extends AbstractMilitaryUnit implements RangedAttacker, FieldHealer {
    public PaladinCaptain(String name) {
        super(name, 150);
    }

    @Override
    public int getMoveSpeed() { return 4; }

    @Override
    public int getAttackRange() { return 400; }

    @Override
    public int fireShot() { return 35; }

    @Override
    public int healAlly() { return 15; }
}

abstract class AbstractLabDevice {
    private final String inventoryCode;

    public AbstractLabDevice(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public String getInventoryCode() { return inventoryCode; }

    public abstract void performMeasurement();
}

interface Calibratable {
    void calibrate(double referenceValue);
}

interface SelfDiagnostic {
    boolean runSelfCheck();
}

class ElectronicScale extends AbstractLabDevice implements Calibratable, SelfDiagnostic {
    private final double rawReading; // що показує сенсор на еталоні
    private double offset;

    public ElectronicScale(String code, double rawReading) {
        super(code);
        this.rawReading = rawReading;
    }

    @Override
    public void performMeasurement() {
        System.out.printf("%s: %.2f г%n", getInventoryCode(), rawReading + offset);
    }

    @Override
    public void calibrate(double referenceValue) {
        offset = referenceValue - rawReading;
        System.out.printf("%s відкалібровано, зсув %.2f г%n", getInventoryCode(), offset);
    }
    @Override
    public boolean runSelfCheck() {
        return Math.abs(offset) < 0.1 && rawReading > 0;
    }
}
class GlassThermometer extends AbstractLabDevice {
    private final double temperature;

    public GlassThermometer(String code, double temperature) {
        super(code);
        this.temperature = temperature;
    }

    @Override
    public void performMeasurement() {
        System.out.println(getInventoryCode() + ": стовпчик ртуті на " + temperature + "°C");
    }
}

interface TextProcessor {
    String process(String text);
}

interface ReversibleProcessor extends TextProcessor {
    String reverseProcess(String text);
}

class CaesarCipherProcessor implements ReversibleProcessor {
    private final int k;

    public CaesarCipherProcessor(int k) {
        this.k = ((k % 26) + 26) % 26;
    }

    // зсуваємо тільки латинські літери, решту лишаємо
    private String shift(String text, int s) {
        String res = "";
        for (char ch : text.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') res += (char) ('a' + (ch - 'a' + s) % 26);
            else if (ch >= 'A' && ch <= 'Z') res += (char) ('A' + (ch - 'A' + s) % 26);
            else res += ch;
        }
        return res;
    }

    @Override
    public String process(String text) { return shift(text, k); }

    @Override
    public String reverseProcess(String text) { return shift(text, 26 - k); }
}

class WhitespaceTrimmerProcessor implements TextProcessor {
    @Override
    public String process(String text) {
        return text.trim().replaceAll("\\s+", " ");
    }
}

interface Rechargeable {
    boolean chargeToFull();
}

class Laptop implements Rechargeable {
    private final String model;
    private int battery;

    public Laptop(String model, int battery) {
        this.model = model;
        this.battery = battery;
    }

    @Override
    public boolean chargeToFull() {
        if (battery >= 100) return false;
        System.out.println("  " + model + ": " + battery + "% -> 100%");
        battery = 100;
        return true;
    }

    @Override
    public String toString() { return "Ноутбук " + model; }
}

class ElectricScooter implements Rechargeable {
    private final String model;
    private int battery;

    public ElectricScooter(String model, int battery) {
        this.model = model;
        this.battery = battery;
    }

    @Override
    public boolean chargeToFull() {
        if (battery >= 100) {
            System.out.println("  " + model + ": вже заряджений");
            return false;
        }
        System.out.println("  " + model + ": " + battery + "% -> 100%");
        battery = 100;
        return true;
    }

    @Override
    public String toString() { return "Самокат " + model; }
}

class SmartWatch implements Rechargeable {
    private final String model;
    private int battery;

    public SmartWatch(String model, int battery) {
        this.model = model;
        this.battery = battery;
    }

    @Override
    public boolean chargeToFull() {
        if (battery >= 100) return false;
        System.out.println("  " + model + ": " + battery + "% -> 100%");
        battery = 100;
        return true;
    }

    @Override
    public String toString() { return "Годинник " + model; }
}

class DesktopMonitor {
    private final String model;

    public DesktopMonitor(String model) {
        this.model = model;
    }

    @Override
    public String toString() { return "Монітор " + model; }
}

class WiredPrinter {
    private final String model;

    public WiredPrinter(String model) {
        this.model = model;
    }

    @Override
    public String toString() { return "Принтер " + model; }
}

abstract class AbstractWorker {
    private final String name;

    public AbstractWorker(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract double getMonthlyPay();
}

interface BonusEligible {
    double calculateQuarterBonus();
}

interface MedicalInsured {
    double getInsuranceCoverage();
}

class FullTimeDeveloper extends AbstractWorker implements BonusEligible, MedicalInsured {
    private final double salary;

    public FullTimeDeveloper(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double getMonthlyPay() { return salary; }

    @Override
    public double calculateQuarterBonus() { return salary * 0.5; }

    @Override
    public double getInsuranceCoverage() { return 250000; }
}

class FopContractor extends AbstractWorker implements BonusEligible {
    private final double contractSum;

    public FopContractor(String name, double contractSum) {
        super(name);
        this.contractSum = contractSum;
    }

    @Override
    public double getMonthlyPay() { return contractSum; }

    @Override
    public double calculateQuarterBonus() { return 5000; }
}

class InternStudent extends AbstractWorker {
    private final double stipend;

    public InternStudent(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double getMonthlyPay() { return stipend; }
}

abstract class ShipModule {
    private final String name;
    private final boolean damaged;

    public ShipModule(String name, boolean damaged) {
        this.name = name;
        this.damaged = damaged;
    }

    public String getName() { return name; }
    public boolean isDamaged() { return damaged; }
}

class ShieldGenerator extends ShipModule {
    private int chargeMj;

    public ShieldGenerator(String name, boolean damaged, int chargeMj) {
        super(name, damaged);
        this.chargeMj = chargeMj;
    }

    public void rechargeShields(int megajoules) {
        chargeMj = Math.min(100, chargeMj + megajoules);
        System.out.println("щит заряджено до " + chargeMj + " МДж");
    }
}

class WarpDrive extends ShipModule {
    private final double containmentIntegrity;

    public WarpDrive(String name, boolean damaged, double containmentIntegrity) {
        super(name, damaged);
        this.containmentIntegrity = containmentIntegrity;
    }

    public boolean checkAntimatterContainment() {
        return containmentIntegrity > 0.95 && !isDamaged();
    }
}

class LifeSupportModule extends ShipModule {
    private final double oxygen;

    public LifeSupportModule(String name, boolean damaged, double oxygen) {
        super(name, damaged);
        this.oxygen = oxygen;
    }

    public double getOxygenPercent() { return oxygen; }
}

class MediaItem {
    private final String title;
    private final double sizeMb;

    public MediaItem(String title, double sizeMb) {
        this.title = title;
        this.sizeMb = sizeMb;
    }

    public String getTitle() { return title; }
    public double getSizeMb() { return sizeMb; }
}

class VideoFile extends MediaItem {
    private final int resolutionHeight;
    private final int durationSec;

    public VideoFile(String title, double sizeMb, int resolutionHeight, int durationSec) {
        super(title, sizeMb);
        this.resolutionHeight = resolutionHeight;
        this.durationSec = durationSec;
    }

    public boolean is4K() { return resolutionHeight >= 2160; }
}

class AudioFile extends MediaItem {
    private final int bitrateKbps;

    public AudioFile(String title, double sizeMb, int bitrateKbps) {
        super(title, sizeMb);
        this.bitrateKbps = bitrateKbps;
    }

    public boolean isLossless() { return bitrateKbps >= 1000; }
}

class EBookFile extends MediaItem {
    private final int pageCount;

    public EBookFile(String title, double sizeMb, int pageCount) {
        super(title, sizeMb);
        this.pageCount = pageCount;
    }
}

abstract class AbstractCustomer {
    private final String name;

    public AbstractCustomer(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract double getDiscountPercent();
}

class RegularCustomer extends AbstractCustomer {
    public RegularCustomer(String name) { super(name); }

    @Override
    public double getDiscountPercent() { return 0; }
}

class StudentCustomer extends AbstractCustomer {
    public StudentCustomer(String name) { super(name); }

    @Override
    public double getDiscountPercent() { return 10; }
}

class VipCustomer extends AbstractCustomer {
    public VipCustomer(String name) { super(name); }

    @Override
    public double getDiscountPercent() { return 20; }
}

class Matrix2x2 {
    protected final double a11, a12, a21, a22;

    public Matrix2x2(double a11, double a12, double a21, double a22) {
        this.a11 = a11;
        this.a12 = a12;
        this.a21 = a21;
        this.a22 = a22;
    }

    public double determinant() {
        return a11 * a22 - a12 * a21;
    }

    @Override
    public String toString() {
        return String.format("%s[[%.3f, %.3f], [%.3f, %.3f]]", getClass().getSimpleName(), a11 + 0.0, a12 + 0.0, a21 + 0.0, a22 + 0.0);
    }
}

interface InvertibleMatrix {
    Matrix2x2 inverse();
}

interface OrthogonalMatrix {
    boolean checkOrthogonality();
}

class RotationMatrix2x2 extends Matrix2x2 implements InvertibleMatrix, OrthogonalMatrix {
    public RotationMatrix2x2(double degrees) {
        super(Math.cos(Math.toRadians(degrees)), -Math.sin(Math.toRadians(degrees)),
                Math.sin(Math.toRadians(degrees)), Math.cos(Math.toRadians(degrees)));
    }
    @Override
    public Matrix2x2 inverse() {
        return new Matrix2x2(a11, a21, a12, a22);
    }

    // перевіряємо A * A^T = E
    @Override
    public boolean checkOrthogonality() {
        double e11 = a11 * a11 + a12 * a12;
        double e12 = a11 * a21 + a12 * a22;
        double e22 = a21 * a21 + a22 * a22;
        return Math.abs(e11 - 1) < 1e-9 && Math.abs(e12) < 1e-9 && Math.abs(e22 - 1) < 1e-9;
    }
}

class SingularMatrix2x2 extends Matrix2x2 {
    public SingularMatrix2x2(double a11, double a12, double a21, double a22) {
        super(a11, a12, a21, a22);
        if (Math.abs(determinant()) > 1e-9) System.out.println("Увага: ця матриця насправді не вироджена");
    }
}

class CargoContainer {
    private final String code;
    private final String contents;
    private final double weightTons;

    public CargoContainer(String code, String contents, double weightTons) {
        this.code = code;
        this.contents = contents;
        this.weightTons = weightTons;
    }

    @Override
    public String toString() {
        return code + " (" + contents + ", " + weightTons + " т)";
    }
}

interface HazardousCargo {
    int getHazardClass();
}

interface RefrigeratedCargo {
    double getRequiredTempC();
}

class ChemicalContainer extends CargoContainer implements HazardousCargo {
    private final int hazardClass;

    public ChemicalContainer(String code, String contents, double weightTons, int hazardClass) {
        super(code, contents, weightTons);
        this.hazardClass = hazardClass;
    }

    @Override
    public int getHazardClass() { return hazardClass; }
}

class FrozenFoodContainer extends CargoContainer implements RefrigeratedCargo {
    private final double tempC;

    public FrozenFoodContainer(String code, String contents, double weightTons, double tempC) {
        super(code, contents, weightTons);
        this.tempC = tempC;
    }

    @Override
    public double getRequiredTempC() { return tempC; }
}

class FinalCalibrationTable {
    public static final double GRAVITY_G = 9.80665;
    private final String sensorSerial;
    private final double[] coefficients;

    public FinalCalibrationTable(String sensorSerial, double[] coefficients) {
        this.sensorSerial = sensorSerial;
        this.coefficients = Arrays.copyOf(coefficients, coefficients.length);
    }

    public String getSensorSerial() { return sensorSerial; }

    public double[] getCoefficients() {
        return Arrays.copyOf(coefficients, coefficients.length);
    }

    @Override
    public String toString() {
        return "Таблиця " + sensorSerial + ": " + Arrays.toString(coefficients);
    }
}

abstract class AbstractSecurityProtocol {
    protected abstract boolean authenticateUser(String token);
    protected abstract String executePayload(String command);
    public final String runSecureCommand(String token, String command) {
        if (token == null || !authenticateUser(token)) return "403 FORBIDDEN";
        return "[AUDITED] " + executePayload(command);
    }
}

class JwtSecurityProtocol extends AbstractSecurityProtocol {
    @Override
    protected boolean authenticateUser(String token) {
        return token.startsWith("eyJ") && token.split("\\.").length == 3;
    }

    @Override
    protected String executePayload(String command) {
        return "JWT-сесія виконала: " + command;
    }
}

class ApiKeySecurityProtocol extends AbstractSecurityProtocol {
    private final String validKey;

    public ApiKeySecurityProtocol(String validKey) {
        this.validKey = validKey;
    }

    @Override
    protected boolean authenticateUser(String token) {
        return validKey.equals(token);
    }

    @Override
    protected String executePayload(String command) {
        return "API-ключ виконав: " + command;
    }
}

interface MetricSpaceElement {
    double distanceTo(MetricSpaceElement other);
    double getNorm();
}

final class ImmutableVector3D implements MetricSpaceElement {
    private final double x, y, z;

    public ImmutableVector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public double getNorm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double distanceTo(MetricSpaceElement other) {
        if (other instanceof ImmutableVector3D v) {
            double dx = x - v.x, dy = y - v.y, dz = z - v.z;
            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        }
        return Math.abs(getNorm() - other.getNorm());
    }

    @Override
    public String toString() {
        return "Vector3D(" + x + ", " + y + ", " + z + ")";
    }
}

class ScalarValue implements MetricSpaceElement {
    private final double value;

    public ScalarValue(double value) {
        this.value = value;
    }

    @Override
    public double getNorm() { return Math.abs(value); }

    @Override
    public double distanceTo(MetricSpaceElement other) {
        return Math.abs(getNorm() - other.getNorm());
    }

    @Override
    public String toString() { return "Scalar(" + value + ")"; }
}

interface PrintableDocument {
    String formatForPrinter();
}

final class FiscalReceipt implements PrintableDocument {
    private final String fiscalNumber;
    private final double totalAmount;
    private final double vatAmount;

    public FiscalReceipt(String fiscalNumber, double totalAmount) {
        this.fiscalNumber = fiscalNumber;
        this.totalAmount = totalAmount;
        this.vatAmount = totalAmount * 20 / 120;
    }

    @Override
    public String formatForPrinter() {
        return String.format("****** ФІСКАЛЬНИЙ ЧЕК ******%n№ %s%nСУМА:        %10.2f грн%nв т.ч. ПДВ 20%%: %8.2f грн%n****************************",
                fiscalNumber, totalAmount, vatAmount);
    }
}

class WarehouseReport implements PrintableDocument {
    private final String warehouse;
    private final int itemsInStock;
    private final int itemsToReorder;

    public WarehouseReport(String warehouse, int itemsInStock, int itemsToReorder) {
        this.warehouse = warehouse;
        this.itemsInStock = itemsInStock;
        this.itemsToReorder = itemsToReorder;
    }

    @Override
    public String formatForPrinter() {
        return "=== Звіт: " + warehouse + " ===\nНа складі позицій: " + itemsInStock + "\nДо дозамовлення: " + itemsToReorder;
    }
}

interface PowerProducer {
    double produceMw();
}

interface WeatherDependent {
    void updateWeatherCondition(double factor);
}

abstract class AbstractPowerStation implements PowerProducer {
    private final String stationId;

    public AbstractPowerStation(String stationId) {
        this.stationId = stationId;
    }

    public String getStationId() { return stationId; }

    public final double getNetOutputMw() {
        return produceMw() * 0.95;
    }
}

class NuclearStation extends AbstractPowerStation {
    private final double capacityMw;

    public NuclearStation(String id, double capacityMw) {
        super(id);
        this.capacityMw = capacityMw;
    }

    @Override
    public double produceMw() { return capacityMw; }
}

class SolarFarmStation extends AbstractPowerStation implements WeatherDependent {
    private final double peakMw;
    private double sunFactor = 1.0;

    public SolarFarmStation(String id, double peakMw) {
        super(id);
        this.peakMw = peakMw;
    }

    @Override
    public void updateWeatherCondition(double factor) {
        sunFactor = Math.max(0, Math.min(1, factor));
    }

    @Override
    public double produceMw() { return peakMw * sunFactor; }
}

class HydroDamStation extends AbstractPowerStation implements WeatherDependent {
    private final double maxMw;
    private double waterLevel = 1.0;

    public HydroDamStation(String id, double maxMw) {
        super(id);
        this.maxMw = maxMw;
    }

    @Override
    public void updateWeatherCondition(double factor) {
        waterLevel = 0.6 + 0.4 * Math.max(0, Math.min(1, factor));
    }

    @Override
    public double produceMw() { return maxMw * waterLevel; }
}

class SmartGridController {
    private final PowerProducer[] producers;

    public SmartGridController(PowerProducer[] producers) {
        this.producers = Arrays.copyOf(producers, producers.length);
    }

    public void updateAndReport(double weatherFactor) {
        System.out.println("Погодний коефіцієнт " + weatherFactor + ":");
        double total = 0;
        for (PowerProducer p : producers) {
            if (p instanceof WeatherDependent wd) wd.updateWeatherCondition(weatherFactor);
            double out = (p instanceof AbstractPowerStation st) ? st.getNetOutputMw() : p.produceMw();
            String id = (p instanceof AbstractPowerStation st) ? st.getStationId() : p.toString();
            System.out.printf("  %-18s %8.2f МВт%n", id, out);
            total += out;
        }
        System.out.printf("  Мережа разом:      %8.2f МВт%n", total);
    }
}

interface Integrable1D {
    double evaluate(double x);

    default double integrateTrapezoid(double a, double b, int n) {
        if (n <= 0) n = 1;
        double h = (b - a) / n;
        double sum = (evaluate(a) + evaluate(b)) / 2;
        for (int i = 1; i < n; i++) sum += evaluate(a + i * h);
        return sum * h;
    }
}

interface RootFindable {
    double findRootBisection(double left, double right, double eps);
}

abstract class AbstractAnalyticFunction implements Integrable1D {
    private final String formula;

    public AbstractAnalyticFunction(String formula) {
        this.formula = formula;
    }

    @Override
    public String toString() { return "f(x) = " + formula; }
}

class CubicFunction extends AbstractAnalyticFunction implements RootFindable {
    public CubicFunction() {
        super("x^3 - 2x - 5");
    }

    @Override
    public double evaluate(double x) {
        return x * x * x - 2 * x - 5;
    }

    @Override
    public double findRootBisection(double left, double right, double eps) {
        if (evaluate(left) * evaluate(right) > 0) {
            System.out.println("На кінцях відрізка однаковий знак - кореня може не бути");
            return Double.NaN;
        }
        while (right - left > eps) {
            double mid = (left + right) / 2;
            if (evaluate(left) * evaluate(mid) <= 0) right = mid;
            else left = mid;
        }
        return (left + right) / 2;
    }
}

abstract class AbstractCombatUnit {
    private final String name;
    protected int hp;
    protected final int maxHp;

    public AbstractCombatUnit(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }

    public final boolean isAlive() {
        return hp > 0;
    }

    public final void receiveDamage(int dmg) {
        hp = Math.max(0, hp - Math.max(0, dmg));
    }

    public abstract int calculateDamage();
}

interface CriticalStriker {
    double getCritMultiplier();
}

interface SelfRegenerating {
    int regenerateHp();
}

interface ShieldBearer {
    int absorbDamage(int incoming);
}

class BerserkerAssasin extends AbstractCombatUnit implements CriticalStriker {
    public BerserkerAssasin(String name) {
        super(name, 95);
    }

    @Override
    public int calculateDamage() { return 24; }

    @Override
    public double getCritMultiplier() { return 2.0; }
}

class TrollWarlord extends AbstractCombatUnit implements CriticalStriker, SelfRegenerating {
    public TrollWarlord(String name) {
        super(name, 130);
    }

    @Override
    public int calculateDamage() { return 17; }

    @Override
    public double getCritMultiplier() { return 1.5; }

    @Override
    public int regenerateHp() {
        if (!isAlive() || hp == maxHp) return 0;
        int before = hp;
        hp = Math.min(maxHp, hp + 6);
        return hp - before;
    }
}

class RoyalPaladin extends AbstractCombatUnit implements ShieldBearer, SelfRegenerating {
    public RoyalPaladin(String name) {
        super(name, 115);
    }

    @Override
    public int calculateDamage() { return 14; }

    @Override
    public int absorbDamage(int incoming) {
        return incoming - incoming / 3;
    }

    @Override
    public int regenerateHp() {
        if (!isAlive() || hp == maxHp) return 0;
        int before = hp;
        hp = Math.min(maxHp, hp + 4);
        return hp - before;
    }
}
