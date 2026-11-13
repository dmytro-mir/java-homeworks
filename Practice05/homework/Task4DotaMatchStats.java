package semester1.practice05.homework;

import java.util.Locale;

public class Task4DotaMatchStats {
    public static void main(String[] args) {
        String[] heroes = {"Pudge", "Invoker", "Juggernaut", "Crystal Maiden", "Earthshaker"};
        int[] kills = {8, 12, 10, 2, 4};
        int[] deaths = {6, 3, 2, 9, 5};
        int[] assists = {14, 9, 8, 18, 16};
        int[] netWorth = {14500, 21200, 24800, 9800, 12300};

        double[] kdaRatios = new double[heroes.length];
        int totalKills = 0;
        int totalNetWorth = 0;
        for (int i = 0; i < heroes.length; i++) {
            kdaRatios[i] = (double) (kills[i] + assists[i]) / Math.max(1, deaths[i]);
            totalKills += kills[i];
            totalNetWorth += netWorth[i];
        }

        double[] killParticipation = new double[heroes.length];
        for (int i = 0; i < heroes.length; i++) {
            if (totalKills > 0) {
                killParticipation[i] = (double) (kills[i] + assists[i]) / totalKills * 100;
            }
        }

        int mvpIndex = 0;
        for (int i = 1; i < heroes.length; i++) {
            if (kdaRatios[i] > kdaRatios[mvpIndex]) {
                mvpIndex = i;
            }
        }

        System.out.println("========================================================================");
        System.out.println("                       🏆 DOTA 2: POST-MATCH REPORT");
        System.out.println("========================================================================");
        System.out.println("Герой            | K / D / A  | Net Worth | KDA Ratio | Kill Participation");
        System.out.println("------------------------------------------------------------------------");
        for (int i = 0; i < heroes.length; i++) {
            String kda = kills[i] + " / " + deaths[i] + " / " + assists[i];
            System.out.println(String.format(Locale.US, "%-16s | %-10s | %-9s | %-9.2f | %.2f%%",
                    heroes[i], kda, String.format(Locale.US, "%,d", netWorth[i]), kdaRatios[i], killParticipation[i]));
        }
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Загальна кількість вбивств команди: " + totalKills);
        System.out.println("Сумарний Net Worth команди:          " + String.format(Locale.US, "%,d", totalNetWorth) + " золота");
        System.out.println("⭐ НАЙКРАЩИЙ ГРАВЕЦЬ МАТЧУ (MVP):    " + heroes[mvpIndex]
                + " (KDA: " + String.format(Locale.US, "%.2f", kdaRatios[mvpIndex]) + ")");
        System.out.println("========================================================================");
    }
}
