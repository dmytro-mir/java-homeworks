package semester1.practice10.homework;

import java.util.Arrays;
import java.util.Locale;

public class Task4PolymorphicMatrixSpectralEngine {
    public static void main(String[] args) {
        System.out.println("================ СПЕКТРАЛЬНИЙ КОНВЕЄР МАТРИЧНИХ ОПЕРАТОРІВ ================");

        double[][] source = {
                {3.0, 4.0},
                {0.0, 5.0}
        };
        ImmutableMatrix2D x0 = new ImmutableMatrix2D(source);
        source[0][0] = 100;

        System.out.println("[ПОЧАТКОВА МАТРИЦЯ X0 " + x0.getSummary() + "]:");
        System.out.println(x0);

        AbstractMatrixOperator[] pipeline = {
                new NonZeroScaleOperator(2.0),
                new TransposeOperator(),
                new GivensRotationOperator(60.0)
        };

        System.out.println();
        System.out.println("--- ПРЯМИЙ ХІД КОНВЕЄРА (Forward Pass через final execute()) ---");
        ImmutableMatrix2D current = x0;
        for (int i = 0; i < pipeline.length; i++) {
            AbstractMatrixOperator op = pipeline[i];
            System.out.print((i + 1) + ". Оператор '" + op.getOperatorName() + "'");
            current = op.execute(current);
            if (op instanceof OrthogonalOperator) {
                System.out.println(" -> det: " + String.format(Locale.US, "%.2f", current.getDeterminant()));
            } else {
                System.out.println(" -> Норма: " + String.format(Locale.US, "%.4f", current.getFrobeniusNorm())
                        + " | det: " + String.format(Locale.US, "%.2f", current.getDeterminant()));
            }
        }
        ImmutableMatrix2D encrypted = current;
        System.out.println("[ЗАШИФРОВАНА МАТРИЦЯ Y ПІСЛЯ " + pipeline.length + " ЕТАПІВ]:");
        System.out.println(encrypted);

        System.out.println();
        System.out.println("--- ЗВОРОТНИЙ ХІД ВІДНОВЛЕННЯ (Inverse Pass через instanceof InvertibleOperator) ---");
        for (int i = pipeline.length - 1; i >= 0; i--) {
            if (pipeline[i] instanceof InvertibleOperator inv) {
                current = inv.applyInverse(current);
                System.out.println("<- Декодування '" + inv.getInverseName() + "' виконано...");
            } else {
                System.out.println("<- Оператор '" + pipeline[i].getOperatorName() + "' необоротний, відновлення неможливе!");
            }
        }

        System.out.println();
        System.out.println("[ВІДНОВЛЕНА МАТРИЦЯ X_restored]:");
        System.out.println(current);
        double error = x0.maxAbsDifference(current);
        System.out.println("Максимальна похибка відновлення |X0 - X_restored|: " + String.format(Locale.US, "%.2e", error)
                + (error < 1e-9 ? " (БЕЗВТРАТНА ОБОРОТНІСТЬ ДОТРИМАНА!)" : " (ВІДНОВЛЕННЯ З ВТРАТАМИ!)"));

        System.out.println();
        System.out.println("--- НЕОБОРОТНИЙ ОПЕРАТОР (UpperTriangularProjection) ---");
        AbstractMatrixOperator projection = new UpperTriangularProjection();
        System.out.print("Оператор '" + projection.getOperatorName() + "'");
        ImmutableMatrix2D projected = projection.execute(encrypted);
        System.out.println(" -> Норма: " + String.format(Locale.US, "%.4f", projected.getFrobeniusNorm()));
        System.out.println(projected);
        System.out.println("Реалізує InvertibleOperator: " + (projection instanceof InvertibleOperator)
                + " -> елемент під діагоналлю (" + String.format(Locale.US, "%.4f", encrypted.get(1, 0)) + ") втрачено назавжди");

        System.out.println();
        System.out.println("--- ПЕРЕВІРКА НЕЗМІННОСТІ ImmutableMatrix2D ---");
        double[][] copy = x0.getDataCopy();
        copy[1][1] = -999;
        System.out.println("Зовнішній масив source[0][0] = " + source[0][0] + ", копія copy[1][1] = " + copy[1][1]);
        System.out.println("А X0 не змінилась: " + Arrays.deepToString(x0.getDataCopy()));
        new GivensRotationOperator(30).execute(new ImmutableMatrix2D(new double[][]{{1, 2, 3}}));
        System.out.println("===========================================================================");
    }
}

final class ImmutableMatrix2D {
    private final int rows;
    private final int cols;
    private final double[][] data;

    public ImmutableMatrix2D(double[][] source) {
        if (source == null || source.length == 0 || source[0] == null) {
            rows = 0;
            cols = 0;
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

    public boolean isSquare() {
        return rows == cols;
    }

    public double[][] getDataCopy() {
        double[][] copy = new double[rows][];
        for (int i = 0; i < rows; i++) {
            copy[i] = Arrays.copyOf(data[i], cols);
        }
        return copy;
    }

    public double get(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            System.out.println("Помилка: індекс [" + r + "][" + c + "] поза межами матриці!");
            return Double.NaN;
        }
        return data[r][c];
    }

    public double getTrace() {
        double trace = 0;
        for (int i = 0; i < Math.min(rows, cols); i++) {
            trace += data[i][i];
        }
        return trace;
    }

    public double getFrobeniusNorm() {
        double sum = 0;
        for (double[] row : data) {
            for (double v : row) {
                sum += v * v;
            }
        }
        return Math.sqrt(sum);
    }

    public double getDeterminant() {
        if (!isSquare()) {
            return Double.NaN;
        }
        if (rows == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        }
        if (rows == 3) {
            double[][] d = data;
            return d[0][0] * d[1][1] * d[2][2] + d[0][1] * d[1][2] * d[2][0] + d[0][2] * d[1][0] * d[2][1]
                    - d[0][2] * d[1][1] * d[2][0] - d[0][0] * d[1][2] * d[2][1] - d[0][1] * d[1][0] * d[2][2];
        }
        return Double.NaN;
    }

    public double maxAbsDifference(ImmutableMatrix2D other) {
        if (other == null || other.rows != rows || other.cols != cols) {
            return Double.POSITIVE_INFINITY;
        }
        double max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, Math.abs(data[i][j] - other.data[i][j]));
            }
        }
        return max;
    }

    public String getSummary() {
        return String.format(Locale.US, "(%dx%d | Норма: %.4f | Слід: %.2f | det: %.2f)",
                rows, cols, getFrobeniusNorm(), getTrace(), getDeterminant());
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < rows; i++) {
            s += (i == 0 ? "" : "\n") + "  [";
            for (int j = 0; j < cols; j++) {
                s += (j == 0 ? "" : " ") + String.format(Locale.US, "%9.4f", data[i][j] + 0.0);
            }
            s += " ]";
        }
        return s;
    }
}

interface InvertibleOperator {
    ImmutableMatrix2D applyInverse(ImmutableMatrix2D transformed);

    String getInverseName();
}

interface OrthogonalOperator extends InvertibleOperator {
    default boolean verifyNormInvariance(ImmutableMatrix2D before, ImmutableMatrix2D after) {
        return Math.abs(before.getFrobeniusNorm() - after.getFrobeniusNorm()) < 1e-6;
    }
}

abstract class AbstractMatrixOperator {
    private final String operatorName;

    public AbstractMatrixOperator(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public abstract boolean canApply(ImmutableMatrix2D m);

    protected abstract ImmutableMatrix2D transform(ImmutableMatrix2D m);

    public final ImmutableMatrix2D execute(ImmutableMatrix2D m) {
        if (m == null || !canApply(m)) {
            System.out.println("⚠️ Оператор '" + operatorName + "' не можна застосувати до цієї матриці, вона лишається без змін");
            return m;
        }
        ImmutableMatrix2D result = transform(m);
        if (this instanceof OrthogonalOperator ort) {
            boolean preserved = ort.verifyNormInvariance(m, result);
            System.out.print(String.format(Locale.US, " [Orthogonal: Норма %.4f %s]",
                    result.getFrobeniusNorm(), preserved ? "збережена ✅" : "НЕ збережена ❌"));
        }
        return result;
    }
}

class NonZeroScaleOperator extends AbstractMatrixOperator implements InvertibleOperator {
    private final double factor;

    public NonZeroScaleOperator(double factor) {
        super("Scale(x" + (factor != 0 ? factor : 1.0) + ")");
        this.factor = (factor != 0) ? factor : 1.0;
    }

    private ImmutableMatrix2D multiply(ImmutableMatrix2D m, double k) {
        double[][] d = m.getDataCopy();
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                d[i][j] *= k;
            }
        }
        return new ImmutableMatrix2D(d);
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
        return m.getRows() > 0;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
        return multiply(m, factor);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D transformed) {
        return multiply(transformed, 1.0 / factor);
    }

    @Override
    public String getInverseName() {
        return "Scale(x" + (1.0 / factor) + ")";
    }
}

class TransposeOperator extends AbstractMatrixOperator implements OrthogonalOperator {
    public TransposeOperator() {
        super("Transpose(A^T)");
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
        return m.getRows() > 0;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
        double[][] d = m.getDataCopy();
        double[][] t = new double[m.getCols()][m.getRows()];
        for (int i = 0; i < m.getRows(); i++) {
            for (int j = 0; j < m.getCols(); j++) {
                t[j][i] = d[i][j];
            }
        }
        return new ImmutableMatrix2D(t);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D transformed) {
        return transform(transformed);
    }

    @Override
    public String getInverseName() {
        return "Transpose((A^T)^T)";
    }
}

class GivensRotationOperator extends AbstractMatrixOperator implements OrthogonalOperator {
    private final double angleDegrees;

    public GivensRotationOperator(double angleDegrees) {
        super("GivensRotation(" + angleDegrees + "°)");
        this.angleDegrees = angleDegrees;
    }

    private ImmutableMatrix2D rotate(ImmutableMatrix2D m, double degrees) {
        double theta = Math.toRadians(degrees);
        double cos = Math.cos(theta);
        double sin = Math.sin(theta);
        double[][] d = m.getDataCopy();
        for (int j = 0; j < m.getCols(); j++) {
            double top = d[0][j];
            double bottom = d[1][j];
            d[0][j] = cos * top - sin * bottom;
            d[1][j] = sin * top + cos * bottom;
        }
        return new ImmutableMatrix2D(d);
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
        return m.getRows() >= 2;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
        return rotate(m, angleDegrees);
    }

    @Override
    public ImmutableMatrix2D applyInverse(ImmutableMatrix2D transformed) {
        return rotate(transformed, -angleDegrees);
    }

    @Override
    public String getInverseName() {
        return "GivensRotation(" + (-angleDegrees) + "°)";
    }
}

class UpperTriangularProjection extends AbstractMatrixOperator {
    public UpperTriangularProjection() {
        super("UpperTriangularProjection");
    }

    @Override
    public boolean canApply(ImmutableMatrix2D m) {
        return m.getRows() > 0;
    }

    @Override
    protected ImmutableMatrix2D transform(ImmutableMatrix2D m) {
        double[][] d = m.getDataCopy();
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < i && j < d[i].length; j++) {
                d[i][j] = 0.0;
            }
        }
        return new ImmutableMatrix2D(d);
    }
}
