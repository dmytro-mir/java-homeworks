import java.util.Arrays;
import java.util.Scanner;

public class Practice05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Завдання 1
        System.out.println("Завдання 1");
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        numbers[0] = 10;
        numbers[2] = 30;
        numbers[numbers.length - 1] = 50;
        System.out.println(Arrays.toString(numbers));

        // Завдання 2
        System.out.println("\nЗавдання 2");
        String[] days = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя"};
        System.out.println("Кількість днів: " + days.length);
        System.out.println("Перший день: " + days[0]);
        System.out.println("Останній день: " + days[days.length - 1]);
        days[5] = "Вихідний (Сб)";
        days[6] = "Вихідний (Нд)";
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i]);
        }

        // Завдання 3
        System.out.println("\nЗавдання 3");
        double[] prices = {120.50, 45.00, 890.99, 15.30, 420.00};
        System.out.println(Arrays.toString(prices));
        prices[2] = prices[2] * 0.8;
        System.out.println(Arrays.toString(prices));

        // Завдання 4
        System.out.println("\nЗавдання 4");
        System.out.print("Введіть N: ");
        int n = sc.nextInt();
        int[] arr4 = new int[n];
        for (int i = 0; i < n; i++) {
            arr4[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr4));

        // Завдання 5
        System.out.println("\nЗавдання 5");
        int[] arr5 = {4, 8, 15, 16, 23, 42};
        for (int i = arr5.length - 1; i >= 0; i--) {
            System.out.print(arr5[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Завдання 6
        System.out.println("\nЗавдання 6");
        int[] pow = new int[10];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 2;
        }
        System.out.println(Arrays.toString(pow));

        // Завдання 7
        System.out.println("\nЗавдання 7");
        int[] original = {3, 7, 1, 9, 4};
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        copy[0] = 999;
        System.out.println("original: " + Arrays.toString(original));
        System.out.println("copy: " + Arrays.toString(copy));

        // Завдання 8
        System.out.println("\nЗавдання 8");
        int[] grades = {95, 84, 70, 99, 65, 88, 92};
        int sum8 = 0;
        for (int i = 0; i < grades.length; i++) {
            sum8 += grades[i];
        }
        double avg8 = (double) sum8 / grades.length;
        System.out.println("Сума: " + sum8 + ", Середній бал: " + avg8);

        // Завдання 9
        System.out.println("\nЗавдання 9");
        int[] temps = {18, 21, 15, 24, 13, 27, 20};
        int min9 = temps[0];
        int max9 = temps[0];
        int minDay = 0;
        int maxDay = 0;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] < min9) {
                min9 = temps[i];
                minDay = i;
            }
            if (temps[i] > max9) {
                max9 = temps[i];
                maxDay = i;
            }
        }
        System.out.println("Мінімальна: " + min9 + " (день " + minDay + ")");
        System.out.println("Максимальна: " + max9 + " (день " + maxDay + ")");

        // Завдання 10
        System.out.println("\nЗавдання 10");
        int[] data = {12, -5, 0, 43, -19, 0, -2, 8, 0, 15};
        int plus = 0;
        int minus = 0;
        int zero = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > 0) {
                plus++;
            } else if (data[i] < 0) {
                minus++;
            } else {
                zero++;
            }
        }
        System.out.println("Додатних: " + plus);
        System.out.println("Від'ємних: " + minus);
        System.out.println("Нулів: " + zero);

        // Завдання 11
        System.out.println("\nЗавдання 11");
        int[] arr11 = {7, 12, 5, 8, 21, 14, 3, 10, 9, 6};
        int even = 0;
        int oddSum = 0;
        for (int i = 0; i < arr11.length; i++) {
            if (arr11[i] % 2 == 0) {
                even++;
            } else {
                oddSum += arr11[i];
            }
        }
        System.out.println("Парних: " + even);
        System.out.println("Сума непарних: " + oddSum);

        // Завдання 12
        System.out.println("\nЗавдання 12");
        int[] students = {1042, 2031, 3055, 4018, 5099};
        System.out.print("Введіть номер залікової: ");
        int num = sc.nextInt();
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == num) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            System.out.println("Знайдено, позиція " + index);
        } else {
            System.out.println("Студента з таким номером не знайдено");
        }

        // Завдання 13
        System.out.println("\nЗавдання 13");
        int[] rolls = {3, 6, 2, 6, 1, 4, 6, 5, 2, 6};
        System.out.print("Введіть число від 1 до 6: ");
        int x = sc.nextInt();
        int count13 = 0;
        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i] == x) {
                count13++;
            }
        }
        System.out.println("Випало " + count13 + " раз");

        // Завдання 14
        System.out.println("\nЗавдання 14");
        int[] zp = {18000, 25000, 32000, 15000, 41000, 29000};
        int sum14 = 0;
        for (int i = 0; i < zp.length; i++) {
            sum14 += zp[i];
        }
        double avg14 = (double) sum14 / zp.length;
        System.out.println("Середня зарплата: " + avg14);
        for (int i = 0; i < zp.length; i++) {
            if (zp[i] > avg14) {
                System.out.println(zp[i]);
            }
        }

        // Завдання 15
        System.out.println("\nЗавдання 15");
        double[] akcii = {42.5, 41.8, 44.1, 40.9, 43.6, 45.0};
        double min15 = akcii[0];
        double max15 = akcii[0];
        for (int i = 1; i < akcii.length; i++) {
            if (akcii[i] < min15) {
                min15 = akcii[i];
            }
            if (akcii[i] > max15) {
                max15 = akcii[i];
            }
        }
        System.out.printf("Розмах: %.2f\n", max15 - min15);

        // Завдання 16
        System.out.println("\nЗавдання 16");
        String[] cities = {"Київ", "Львів", "Харків", "Одеса", "Дніпро"};
        for (String city : cities) {
            System.out.println("Ласкаво просимо до міста " + city + "!");
        }

        // Завдання 17
        System.out.println("\nЗавдання 17");
        double[] salaries = {20000.0, 25000.0, 18000.0, 30000.0};
        for (int i = 0; i < salaries.length; i++) {
            salaries[i] *= 1.10;
        }
        System.out.println(Arrays.toString(salaries));

        // Завдання 18
        System.out.println("\nЗавдання 18");
        int[] arr18 = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < arr18.length / 2; i++) {
            int temp = arr18[i];
            arr18[i] = arr18[arr18.length - 1 - i];
            arr18[arr18.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr18));

        // Завдання 19
        System.out.println("\nЗавдання 19");
        int[] base = {2, 4, 6, 8, 10};
        int[] squares = new int[base.length];
        for (int i = 0; i < base.length; i++) {
            squares[i] = base[i] * base[i];
        }
        System.out.println(Arrays.toString(base));
        System.out.println(Arrays.toString(squares));

        // Завдання 20
        System.out.println("\nЗавдання 20");
        int[] arr20 = {1, 3, 5, 7, 6, 10};
        boolean isSorted = true;
        for (int i = 0; i < arr20.length - 1; i++) {
            if (arr20[i] > arr20[i + 1]) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            System.out.println("Масив відсортований");
        } else {
            System.out.println("Масив не відсортований");
        }

        // Завдання 21
        System.out.println("\nЗавдання 21");
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6, 7};
        int[] c = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        System.out.println(Arrays.toString(c));

        // Завдання 22
        System.out.println("\nЗавдання 22");
        int[] test = {45, 12, 89, 3, 27};
        System.out.println(Arrays.toString(test));
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
        Arrays.fill(test, -1);
        System.out.println(Arrays.toString(test));

        // Завдання 23
        System.out.println("\nЗавдання 23");
        int[][] table = new int[3][3];
        table[0][0] = 5;
        table[0][1] = 3;
        table[0][2] = 8;
        table[1][0] = 1;
        table[1][1] = 9;
        table[1][2] = 4;
        table[2][0] = 7;
        table[2][1] = 2;
        table[2][2] = 6;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }

        // Завдання 24
        System.out.println("\nЗавдання 24");
        int[][] matrix = {
                {10, 20, 30, 40},
                {50, 60, 70, 80}
        };
        System.out.println("Рядків: " + matrix.length);
        System.out.println("Стовпчиків: " + matrix[0].length);
        System.out.println("Лівий верхній: " + matrix[0][0]);
        System.out.println("Правий верхній: " + matrix[0][3]);
        System.out.println("Лівий нижній: " + matrix[1][0]);
        System.out.println("Правий нижній: " + matrix[1][3]);

        // Завдання 25
        System.out.println("\nЗавдання 25");
        int[][] grid = new int[3][4];
        int counter = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = counter;
                counter++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }

        // Завдання 26
        System.out.println("\nЗавдання 26");
        int[][] randomGrid = new int[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                randomGrid[i][j] = (int) (Math.random() * 90) + 10;
            }
        }
        System.out.println(Arrays.deepToString(randomGrid));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(randomGrid[i][j] + "\t");
            }
            System.out.println();
        }

        // Завдання 27
        System.out.println("\nЗавдання 27");
        int[][] multTable = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                multTable[i][j] = (i + 1) * (j + 1);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("%4d", multTable[i][j]);
            }
            System.out.println();
        }

        // Завдання 28
        System.out.println("\nЗавдання 28");
        int[][] ed = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    ed[i][j] = 1;
                } else {
                    ed[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(ed[i][j] + " ");
            }
            System.out.println();
        }

        // Завдання 29
        System.out.println("\nЗавдання 29");
        int[][] m29 = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m29[i][j] = 1;
            }
        }
        for (int j = 0; j < 4; j++) {
            m29[1][j] = 0;
        }
        for (int i = 0; i < 4; i++) {
            m29[i][2] = 7;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(m29[i][j] + " ");
            }
            System.out.println();
        }

        // Завдання 30
        System.out.println("\nЗавдання 30");
        int[][] m30 = {
                {4, 7, 2},
                {9, 1, 5},
                {3, 8, 6}
        };
        int sum30 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum30 += m30[i][j];
            }
        }
        int kol = 3 * 3;
        double avg30 = (double) sum30 / kol;
        System.out.println("Сума: " + sum30);
        System.out.println("Кількість: " + kol);
        System.out.println("Середнє: " + avg30);

        // Завдання 31
        System.out.println("\nЗавдання 31");
        int[][] m31 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int[] rowSums = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                rowSums[i] += m31[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Рядок " + i + ": сума = " + rowSums[i]);
        }

        // Завдання 32
        System.out.println("\nЗавдання 32");
        int[][] m32 = {
                {3, 5, 1},
                {7, 2, 8},
                {4, 6, 9}
        };
        int[] colSums = new int[3];
        for (int col = 0; col < 3; col++) {
            for (int row = 0; row < 3; row++) {
                colSums[col] += m32[row][col];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m32[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Суми:");
        for (int i = 0; i < 3; i++) {
            System.out.print(colSums[i] + "\t");
        }
        System.out.println();

        // Завдання 33
        System.out.println("\nЗавдання 33");
        int[][] m33 = {
                {12, -4, 7, 0},
                {-15, 23, 5, -8},
                {9, 3, -1, 18}
        };
        int max33 = m33[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (m33[i][j] > max33) {
                    max33 = m33[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("Максимум: " + max33 + " у комірці [" + maxRow + ", " + maxCol + "]");

        // Завдання 34
        System.out.println("\nЗавдання 34");
        int[][] m34 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 17}
        };
        int glavna = 0;
        int pobichna = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    glavna += m34[i][j];
                }
                if (i + j == m34.length - 1) {
                    pobichna += m34[i][j];
                }
            }
        }
        System.out.println("Головна діагональ: " + glavna);
        System.out.println("Побічна діагональ: " + pobichna);
        if (glavna > pobichna) {
            System.out.println("Головна більша");
        } else if (glavna < pobichna) {
            System.out.println("Побічна більша");
        } else {
            System.out.println("Вони рівні");
        }

        // Завдання 35
        System.out.println("\nЗавдання 35");
        int[][] m35 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] transposed = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transposed[j][i] = m35[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m35[i][j] + " ");
            }
            System.out.print("   ");
            for (int j = 0; j < 3; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }

        // Завдання 36
        System.out.println("\nЗавдання 36");
        int[][] ladder = new int[4][];
        ladder[0] = new int[1];
        ladder[1] = new int[2];
        ladder[2] = new int[3];
        ladder[3] = new int[4];
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                ladder[i][j] = i;
            }
        }
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                System.out.print(ladder[i][j] + " ");
            }
            System.out.println();
        }

        // Завдання 37
        System.out.println("\nЗавдання 37");
        String[][] weekSchedule = new String[5][];
        weekSchedule[0] = new String[]{"Вища математика", "Основи програмування", "Фізика"};
        weekSchedule[1] = new String[]{"Англійська мова", "Історія України"};
        weekSchedule[2] = new String[]{"Основи програмування", "Основи програмування", "Бази даних", "Фізвиховання"};
        weekSchedule[3] = new String[]{"Дискретна математика"};
        weekSchedule[4] = new String[]{"Філософія", "Основи алгоритмізації", "Практикум"};
        String[] dni = {"Понеділок", "Вівторок", "Середа", "Четвер", "П'ятниця"};
        for (int i = 0; i < weekSchedule.length; i++) {
            System.out.println(dni[i] + " - " + weekSchedule[i].length + " пар:");
            for (int j = 0; j < weekSchedule[i].length; j++) {
                System.out.println("  " + weekSchedule[i][j]);
            }
        }

        // Завдання 38
        System.out.println("\nЗавдання 38");
        int[][] pascal = new int[5][];
        for (int i = 0; i < 5; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
        }

        // Завдання 39
        System.out.println("\nЗавдання 39");
        int[][][] cube = new int[3][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = i + j + k;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("--- Шар " + i + " ---");
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(cube[i][j][k] + " ");
                }
                System.out.println();
            }
        }

        // Завдання 40
        System.out.println("\nЗавдання 40");
        // [місто][день][0 - день, 1 - ніч]
        double[][][] weather = {
                {{12.5, 4.0}, {14.0, 5.5}, {11.2, 3.1}, {9.8, 1.5}, {13.4, 6.0}, {15.1, 7.2}, {12.0, 4.8}},
                {{10.3, 2.5}, {11.8, 3.0}, {9.5, 0.4}, {8.7, -1.2}, {12.1, 4.1}, {13.0, 5.0}, {10.9, 2.2}},
                {{16.2, 9.5}, {17.5, 10.1}, {15.0, 8.3}, {14.4, 7.0}, {16.8, 9.9}, {18.0, 11.2}, {15.7, 8.8}}
        };
        String[] mista = {"Київ", "Львів", "Одеса"};
        for (int i = 0; i < 3; i++) {
            double s = 0;
            for (int j = 0; j < 7; j++) {
                s += weather[i][j][0];
            }
            System.out.printf("%s: середня денна %.2f\n", mista[i], s / 7);
        }
        double coldNight = weather[0][0][1];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (weather[i][j][1] < coldNight) {
                    coldNight = weather[i][j][1];
                }
            }
        }
        System.out.println("Найхолодніша ніч: " + coldNight);
    }
}
