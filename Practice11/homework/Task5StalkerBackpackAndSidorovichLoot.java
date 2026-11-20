package semester1.practice11.homework;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Task5StalkerBackpackAndSidorovichLoot {
    public static final double MAX_SAFE_RADIATION = 50.0;
    public static final int LEAD_CONTAINER_MIN_COST = 15000;
    private static final String LINE = "---------------------------------------------------------------------------------------------------";

    public static void main(String[] args) {
        System.out.println("================ ☢️ S.T.A.L.K.E.R. 2: РЕЙД ДИКИМ СХОДОМ ЗОНИ ТА ЛАВКА СИДОРОВИЧА ☢️ ================");
        System.out.println("Сталкер: Скіф | Маршрут: Дикий Схід Зони -> Бункер Сидоровича | Допустима норма радіації: "
                + MAX_SAFE_RADIATION + " мкЗв/год");
        System.out.println();

        var backpack = new ArrayList<Artifact>();
        backpack.add(new Artifact("Бенгальський вогонь", 9500, 14.5));
        backpack.add(new Artifact("Фоняча Пустушка", 0, 92.0));
        backpack.add(new Artifact("Крівник", 18500, 26.0));
        backpack.add(new Artifact("Аномальний Шлак", 1200, 135.4));
        backpack.add(new Artifact("Виверт", 11000, 18.0));
        backpack.add(new Artifact("Іржава Пустушка", 500, 78.5));
        backpack.add(new Artifact("Компас", 45000, 32.0));

        System.out.println("[1. ВМІСТ РЮКЗАКА ПІСЛЯ ВИЛАЗКИ (ДО ЧИСТКИ — " + backpack.size() + " об'єктів у ArrayList)]:");
        for (int i = 0; i < backpack.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + backpack.get(i));
        }
        System.out.println(LINE);
        System.out.println("Всього знахідок у рюкзаку: " + backpack.size() + " шт. | Сумарний фон рюкзака: "
                + String.format(Locale.US, "%.1f", getTotalRadiation(backpack)) + " мкЗв/год"
                + (hasDangerousArtifacts(backpack) ? " (⚠️ НЕБЕЗПЕЧНИЙ РІВЕНЬ!)" : " (у нормі)"));
        System.out.println();

        System.out.println("[2. ДЕЗАКТИВАЦІЯ ТА ВІДСІЮВАННЯ ПУСТУШОК ЧЕРЕЗ ITERATOR]:");
        demonstrateFailFastOnBackpack(backpack);
        System.out.println("  -> Запускаємо безпечне очищення рюкзака через Iterator<Artifact> та iterator.remove()...");
        int removed = purgeRadioactiveDudsWithIterator(backpack, MAX_SAFE_RADIATION);
        System.out.println("  ✅ Очищення завершено! Вилучено радіоактивних пустушок: " + removed + " шт.");
        System.out.println("  Залишилося чистих артефактів у рюкзаку: " + backpack.size() + " шт. | Безпечний фон: "
                + String.format(Locale.US, "%.1f", getTotalRadiation(backpack)) + " мкЗв/год");
        System.out.println();

        System.out.println("[3. КОНТЕЙНЕРИ АРТЕФАКТІВ ТА РАНЖУВАННЯ ЗНАХІДОК ДЛЯ СИДОРОВИЧА]:");
        ArrayList<Artifact> leadSpecialContainer = new ArrayList<>();
        ArrayList<Artifact> standardBeltContainer = new ArrayList<>();
        distributeAndRankForSidorovich(backpack, leadSpecialContainer, standardBeltContainer);
        System.out.println("  🛡️ Свинцевий спецконтейнер (>= " + formatKarb(LEAD_CONTAINER_MIN_COST) + " крб, "
                + leadSpecialContainer.size() + " шт.): " + shortList(leadSpecialContainer));
        System.out.println("  🎒 Стандартний контейнер   (<  " + formatKarb(LEAD_CONTAINER_MIN_COST) + " крб, "
                + standardBeltContainer.size() + " шт.): " + shortList(standardBeltContainer));
        System.out.println();

        findTopArtifactAndPrintReceipt(backpack);
        System.out.println("===================================================================================================");
    }

    public static void demonstrateFailFastOnBackpack(List<Artifact> backpack) {
        List<Artifact> testCopy = new ArrayList<>(backpack);
        try {
            for (Artifact artifact : testCopy) {
                if (artifact.isRadioactiveDud(MAX_SAFE_RADIATION)) {
                    testCopy.remove(artifact);
                }
            }
            System.out.println("  [Перевірка КПК]: виняток не виник (пустушка була передостанньою в списку)");
        } catch (ConcurrentModificationException e) {
            System.out.println("  ⚡ [Перевірка КПК]: Спроба прямого backpack.remove() у циклі for-each перехоплена -> ConcurrentModificationException!");
        }
    }

    public static int purgeRadioactiveDudsWithIterator(List<Artifact> backpack, double maxSafeRadiation) {
        Iterator<Artifact> iterator = backpack.iterator();
        int removedDuds = 0;
        while (iterator.hasNext()) {
            Artifact current = iterator.next();
            if (current.getRadiationLevel() > maxSafeRadiation || current.getCostKarbovanets() <= 0) {
                String reason = current.getRadiationLevel() > maxSafeRadiation
                        ? "Радіація: " + current.getRadiationLevel() + " мкЗв/год > " + maxSafeRadiation
                        : "Ціна: " + current.getCostKarbovanets() + " крб";
                System.out.println("  ☢️ [Iterator.remove] Викинуто небезпечну пустушку: '" + current.getName() + "' (" + reason + ")");
                iterator.remove();
                removedDuds++;
            }
        }
        return removedDuds;
    }

    public static void distributeAndRankForSidorovich(List<Artifact> cleanLoot, List<Artifact> leadContainer, List<Artifact> standardPouch) {
        for (int i = 0; i < cleanLoot.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < cleanLoot.size(); j++) {
                if (cleanLoot.get(j).getCostKarbovanets() > cleanLoot.get(maxIndex).getCostKarbovanets()) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                Artifact temp = cleanLoot.get(i);
                cleanLoot.set(i, cleanLoot.get(maxIndex));
                cleanLoot.set(maxIndex, temp);
            }
        }

        for (int i = 0; i < cleanLoot.size(); i++) {
            Artifact artifact = cleanLoot.get(i);
            if (artifact.getCostKarbovanets() >= LEAD_CONTAINER_MIN_COST) {
                leadContainer.add(artifact);
            } else {
                standardPouch.add(artifact);
            }
        }
    }

    public static void findTopArtifactAndPrintReceipt(List<Artifact> cleanLoot) {
        if (cleanLoot.isEmpty()) {
            System.out.println("  💬 Сидорович: «Порожній рюкзак? Ну й чого ти прийшов, Скіфе?»");
            return;
        }

        int maxCost = Integer.MIN_VALUE;
        Artifact top = null;
        int total = 0;
        String[] medals = {"🥇", "🥈", "🥉"};

        System.out.println("  📋 Фінальний чек та ранжований список хабару у Сидоровича:");
        for (int i = 0; i < cleanLoot.size(); i++) {
            Artifact a = cleanLoot.get(i);
            String medal = i < medals.length ? medals[i] : "  ";
            System.out.println(String.format(Locale.US, "    %s #%d. %-21s — %6s крб (Фон: %.1f мкЗв/год)",
                    medal, i + 1, "'" + a.getName() + "'", formatKarb(a.getCostKarbovanets()), a.getRadiationLevel()));
            total += a.getCostKarbovanets();
            if (a.getCostKarbovanets() > maxCost) {
                maxCost = a.getCostKarbovanets();
                top = a;
            }
        }
        System.out.println(LINE);
        System.out.println("  👑 Найдорожчий артефакт рейду: '" + top.getName() + "' (" + formatKarb(maxCost) + " крб)");
        System.out.println("  💰 ПІДСУМКОВА ВАРТІСТЬ ЧИСТОГО ХАБАРУ: " + formatKarb(total) + " крб");
        System.out.println("  💬 Сидорович: «Непоганий улов із Дикого Сходу, Скіфе! Добре, що радіоактивні пустушки відсіяв — тримай свої "
                + formatKarb(total) + " карбованців!»");
    }

    private static double getTotalRadiation(List<Artifact> items) {
        double sum = 0;
        for (Artifact a : items) {
            sum += a.getRadiationLevel();
        }
        return sum;
    }

    private static boolean hasDangerousArtifacts(List<Artifact> items) {
        for (Artifact a : items) {
            if (a.isRadioactiveDud(MAX_SAFE_RADIATION)) {
                return true;
            }
        }
        return false;
    }

    private static String shortList(List<Artifact> items) {
        String s = "[";
        for (int i = 0; i < items.size(); i++) {
            Artifact a = items.get(i);
            s += (i == 0 ? "" : ", ") + "'" + a.getName() + "' (" + formatKarb(a.getCostKarbovanets()) + " крб)";
        }
        return s + "]";
    }

    static String formatKarb(int value) {
        return String.format(Locale.US, "%,d", value).replace(',', ' ');
    }
}

class Artifact {
    private String name;
    private int costKarbovanets;
    private double radiationLevel;

    public Artifact(String name, int costKarbovanets, double radiationLevel) {
        this.name = (name == null || name.isBlank()) ? "Невідомий артефакт" : name;
        this.costKarbovanets = Math.max(0, costKarbovanets);
        this.radiationLevel = Math.max(0.0, radiationLevel);
    }

    public String getName() {
        return name;
    }

    public int getCostKarbovanets() {
        return costKarbovanets;
    }

    public double getRadiationLevel() {
        return radiationLevel;
    }

    public boolean isRadioactiveDud(double maxSafeRadiation) {
        return radiationLevel > maxSafeRadiation || costKarbovanets <= 0;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "[Артефакт: %-21s | Ціна: %6s крб | Радіація: %5.1f мкЗв/год]",
                "'" + name + "'", Task5StalkerBackpackAndSidorovichLoot.formatKarb(costKarbovanets), radiationLevel);
    }
}
