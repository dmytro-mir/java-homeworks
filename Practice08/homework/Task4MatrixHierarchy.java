package semester1.practice08.homework;

import java.util.Arrays;
import java.util.Locale;

public class Task4MatrixHierarchy {
    public static void main(String[] args) {
        System.out.println("================ ІЄРАРХІЯ МАТРИЦЬ ТА СЛАР ================");

        System.out.println("--- 1. Квадратна матриця 3x3 (SquareMatrix) ---");
        SquareMatrix square = new SquareMatrix(new double[][]{
                {2, 1, 0},
                {1, 3, 1},
                {0, 1, 2}
        });
        System.out.println(square);
        System.out.println();

        System.out.println("--- 2. Розв'язувач системи Крамера (CramerMatrixSolver 2x2) ---");
        CramerMatrixSolver system2 = new CramerMatrixSolver(new double[][]{
                {2, 3},
                {4, -1}
        }, new double[]{8, 2});
        System.out.println(system2);
        System.out.println("Слід матриці A = " + String.format(Locale.US, "%.2f", system2.getTrace()));
        System.out.println();

        System.out.println("--- 3. Система 3x3 (CramerMatrixSolver 3x3) ---");
        CramerMatrixSolver system3 = new CramerMatrixSolver(new double[][]{
                {1, 1, 1},
                {2, -1, 1},
                {1, 2, -1}
        }, new double[]{6, 3, 2});
        System.out.println(system3);
        System.out.println();

        System.out.println("--- 4. Вироджена система (det = 0) ---");
        CramerMatrixSolver singular = new CramerMatrixSolver(new double[][]{
                {1, 2},
                {2, 4}
        }, new double[]{3, 6});
        double[] roots = singular.solve();
        System.out.println("Кількість знайдених коренів: " + roots.length);
        System.out.println();

        System.out.println("--- 5. Прямокутна матриця 2x3 (Matrix2D) ---");
        double[][] source = {
                {1.5, -2, 7},
                {4, 0.25, 3}
        };
        Matrix2D rect = new Matrix2D(source);
        source[0][0] = 999;
        System.out.print(rect);
        System.out.println("Розмір: " + rect.getRows() + "x" + rect.getCols()
                + " | Сума = " + String.format(Locale.US, "%.2f", rect.getSum())
                + " | Максимум = " + String.format(Locale.US, "%.2f", rect.getMaxElement()));
        System.out.println("Елемент [0][0] після зміни зовнішнього масиву: " + rect.getElement(0, 0));
        rect.setElement(5, 5, 1.0);
        System.out.println("==========================================================");
    }
}

class Matrix2D {
    protected double[][] data;
    private int rows;
    private int cols;

    public Matrix2D(double[][] source) {
        if (source == null || source.length == 0 || source[0] == null) {
            data = new double[0][0];
            return;
        }
        rows = source.length;
        cols = source[0].length;
        data = new double[rows][];
        for (int i = 0; i < rows; i++) {
            data[i] = Arrays.copyOf(source[i], cols);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    private boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public double getElement(int r, int c) {
        if (!inBounds(r, c)) {
            System.out.println("Помилка: індекс [" + r + "][" + c + "] поза межами матриці!");
            return Double.NaN;
        }
        return data[r][c];
    }

    public void setElement(int r, int c, double val) {
        if (!inBounds(r, c)) {
            System.out.println("Помилка: індекс [" + r + "][" + c + "] поза межами матриці!");
            return;
        }
        data[r][c] = val;
    }

    public double getSum() {
        double sum = 0;
        for (double[] row : data) {
            for (double v : row) {
                sum += v;
            }
        }
        return sum;
    }

    public double getMaxElement() {
        if (rows == 0 || cols == 0) {
            return Double.NaN;
        }
        double max = data[0][0];
        for (double[] row : data) {
            for (double v : row) {
                if (v > max) {
                    max = v;
                }
            }
        }
        return max;
    }

    protected String formatRow(double[] row) {
        String s = "[";
        for (int j = 0; j < row.length; j++) {
            s += (j == 0 ? "" : " ") + String.format(Locale.US, "%7.2f", row[j]);
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for (double[] row : data) {
            s += formatRow(row) + " ]\n";
        }
        return s;
    }
}

class SquareMatrix extends Matrix2D {
    public SquareMatrix(double[][] source) {
        super(source);
        if (getRows() != getCols()) {
            System.out.println("Попередження: матриця " + getRows() + "x" + getCols() + " не є квадратною!");
        }
    }

    public int getDimension() {
        return getRows();
    }

    public double getTrace() {
        double trace = 0;
        int n = Math.min(getRows(), getCols());
        for (int i = 0; i < n; i++) {
            trace += data[i][i];
        }
        return trace;
    }

    public boolean isSymmetric() {
        if (getRows() != getCols()) {
            return false;
        }
        for (int i = 0; i < getRows(); i++) {
            for (int j = i + 1; j < getCols(); j++) {
                if (data[i][j] != data[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public double getDeterminant() {
        if (getRows() != getCols()) {
            return 0.0;
        }
        if (getDimension() == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        }
        if (getDimension() == 3) {
            double[][] d = data;
            return d[0][0] * d[1][1] * d[2][2] + d[0][1] * d[1][2] * d[2][0] + d[0][2] * d[1][0] * d[2][1]
                    - d[0][2] * d[1][1] * d[2][0] - d[0][0] * d[1][2] * d[2][1] - d[0][1] * d[1][0] * d[2][2];
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(Locale.US,
                "Характеристики SquareMatrix: Розмір = %dx%d | Слід (Trace) = %.2f | Симетрична = %b | det(A) = %.2f",
                getRows(), getCols(), getTrace(), isSymmetric(), getDeterminant());
    }
}

class CramerMatrixSolver extends SquareMatrix {
    private double[] freeTerms;

    public CramerMatrixSolver(double[][] coefficients, double[] freeTerms) {
        super(coefficients);
        if (freeTerms == null || freeTerms.length != getRows()) {
            System.out.println("Попередження: кількість вільних членів не збігається з кількістю рівнянь!");
            this.freeTerms = new double[getRows()];
        } else {
            this.freeTerms = Arrays.copyOf(freeTerms, freeTerms.length);
        }
    }

    private double[] findRoots() {
        double det = getDeterminant();
        if (Math.abs(det) < 1e-9) {
            return new double[0];
        }
        int n = getDimension();
        double[] roots = new double[n];
        for (int col = 0; col < n; col++) {
            double[][] replaced = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    replaced[i][j] = (j == col) ? freeTerms[i] : data[i][j];
                }
            }
            roots[col] = new SquareMatrix(replaced).getDeterminant() / det;
        }
        return roots;
    }

    public double[] solve() {
        double[] roots = findRoots();
        if (roots.length == 0) {
            System.out.println("Система не має єдиного розв'язку (det(A) = 0)!");
        }
        return roots;
    }

    private boolean checkRoots(double[] roots) {
        for (int i = 0; i < getRows(); i++) {
            double left = 0;
            for (int j = 0; j < getCols(); j++) {
                left += data[i][j] * roots[j];
            }
            if (Math.abs(left - freeTerms[i]) > 1e-9) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "Розширена матриця системи [A | B]:\n";
        for (int i = 0; i < getRows(); i++) {
            s += formatRow(data[i]) + "  |" + String.format(Locale.US, "%7.2f", freeTerms[i]) + " ]\n";
        }
        s += String.format(Locale.US, "Головний визначник det(A) = %.2f%n", getDeterminant());

        double[] roots = findRoots();
        if (roots.length == 0) {
            return s + "Єдиного розв'язку немає (det(A) = 0)";
        }
        s += "Розв'язок системи: ";
        for (int i = 0; i < roots.length; i++) {
            s += (i == 0 ? "" : ", ") + String.format(Locale.US, "x%d = %.2f", i + 1, roots[i]);
        }
        return s + (checkRoots(roots) ? " (Перевірка пройдена!)" : " (Перевірка НЕ пройдена!)");
    }
}
