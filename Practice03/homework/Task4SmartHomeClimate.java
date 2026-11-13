package semester1.practice03.homework;

import java.util.Locale;
import java.util.Scanner;

public class Task4SmartHomeClimate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("=== ПАНЕЛЬ КЛІМАТ-КОНТРОЛЮ SMART HOME ===");
        System.out.print("Поточна температура (°C): ");
        double currentTemp = scanner.nextDouble();
        System.out.print("Бажана температура (°C): ");
        double desiredTemp = scanner.nextDouble();
        System.out.print("Вологість повітря (%): ");
        int humidity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Сезон (зима/літо/міжсезоння): ");
        String season = scanner.nextLine().trim();
        System.out.print("Режим будинку (1-Standby, 2-Eco, 3-Party, 4-Night, 5-Vacation): ");
        int mode = scanner.nextInt();
        System.out.print("Чи відчинені вікна? (true/false): ");
        boolean isWindowOpen = scanner.nextBoolean();

        String modeName = switch (mode) {
            case 1 -> "Standby (Звичайний)";
            case 2 -> "Eco (Енергозбереження)";
            case 3 -> "Party (Гості)";
            case 4 -> "Night (Ніч)";
            case 5 -> "Vacation (Відпустка)";
            default -> "Невідомий режим (працює як Standby)";
        };

        double effectiveTargetTemp = switch (mode) {
            case 1 -> desiredTemp;
            case 2 -> {
                double delta = 0.0;
                if (season.equalsIgnoreCase("зима")) {
                    delta = -2.0;
                } else if (season.equalsIgnoreCase("літо")) {
                    delta = 2.0;
                }
                yield desiredTemp + delta;
            }
            case 3 -> desiredTemp - 1.5;
            case 4 -> 19.0;
            case 5 -> {
                if (season.equalsIgnoreCase("зима")) {
                    yield 12.0;
                }
                yield 28.0;
            }
            default -> desiredTemp;
        };

        String seasonForm = switch (season.toLowerCase()) {
            case "зима" -> "зими";
            case "літо" -> "літа";
            default -> "міжсезоння";
        };
        String reason = (mode == 2 || mode == 5) ? "для " + seasonForm : "через режим";
        String targetNote = (effectiveTargetTemp != desiredTemp)
                ? " (скориговано з " + desiredTemp + "°C " + reason + ")"
                : " (без корекції)";

        boolean isBlocked = isWindowOpen && (mode != 5);

        String climateState;
        if (isBlocked) {
            climateState = "ЗАБЛОКОВАНО (відчинені вікна)";
        } else if (currentTemp - effectiveTargetTemp > 0.5) {
            climateState = "Кондиціонер УВІМКНЕНО (Охолодження)";
        } else if (effectiveTargetTemp - currentTemp > 0.5) {
            climateState = "Опалення УВІМКНЕНО (Обігрів)";
        } else {
            climateState = "Температура в зоні комфорту (Кліматичні прилади в очікуванні)";
        }

        String humidityState = (humidity < 40)
                ? "Зволожувач УВІМКНЕНО (вологість " + humidity + "% < 40%)"
                : (humidity > 65)
                ? "Осушувач УВІМКНЕНО (вологість " + humidity + "% > 65%)"
                : "Вологість оптимальна (" + humidity + "%)";

        String energyState = switch (mode) {
            case 2, 4, 5 -> "Оптимізоване";
            case 3 -> "Підвищене";
            default -> "Звичайне";
        };

        System.out.println();
        if (isBlocked) {
            System.out.println("ПОПЕРЕДЖЕННЯ: Відчинені вікна! Обігрів та кондиціонування примусово заблоковано!");
        }
        System.out.println("------------- СТАТУС СИСТЕМИ -------------");
        System.out.println("Режим роботи:              " + modeName);
        System.out.println("Цільова температура:       " + String.format(Locale.US, "%.2f", effectiveTargetTemp) + "°C" + targetNote);
        System.out.println("Поточна температура:       " + String.format(Locale.US, "%.2f", currentTemp) + "°C");
        System.out.println("Стан терморегуляції:       " + climateState);
        System.out.println("Стан мікроклімату:         " + humidityState);
        System.out.println("Енергоспоживання:          " + (isBlocked ? "Мінімальне (прилади вимкнено)" : energyState));
        System.out.println("==========================================");

        scanner.close();
    }
}
