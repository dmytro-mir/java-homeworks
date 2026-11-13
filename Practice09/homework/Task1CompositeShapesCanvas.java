package semester1.practice09.homework;

import java.util.Locale;

public class Task1CompositeShapesCanvas {
    public static void main(String[] args) {
        System.out.println("================ ГЕОМЕТРИЧНЕ ПОЛОТНО (КОМПОЗИЦІЯ + ABSTRACT) ================");

        Point2D circleCenter = new Point2D(0, 0);
        Circle2D circle = new Circle2D("Коло-А", circleCenter, 5);
        Rectangle2D plate = new Rectangle2D("Плита-Б", new Point2D(10, 5), 4, 6);
        RightTriangle2D wedge = new RightTriangle2D("Клин-В", new Point2D(-3, 2), 3, 4);

        GeometryCanvas canvas = new GeometryCanvas("Інженерне креслення №1", 5);
        canvas.addShape(circle);
        canvas.addShape(plate);
        canvas.addShape(wedge);
        canvas.addShape(null);

        circleCenter.translate(100, 100);
        circle.getAnchorPoint().translate(50, 50);

        System.out.println(canvas);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Сумарна площа креслення:    " + String.format(Locale.US, "%.2f", canvas.getTotalArea()) + " кв.од.");
        System.out.println("Сумарний периметр:          " + String.format(Locale.US, "%.2f", canvas.getTotalPerimeter()) + " од.");
        AbstractShape2D largest = canvas.findLargestShape();
        System.out.println("Найбільша фігура:           " + largest.getName()
                + " (S = " + String.format(Locale.US, "%.2f", largest.getArea()) + ")");
        System.out.println("Захисне копіювання: зовнішня точка зсунута на " + circleCenter
                + ", а центр 'Коло-А' лишився " + circle.getAnchorPoint());

        System.out.println("-> Переміщуємо всі фігури полотна на вектор (+5.0; -2.0)...");
        canvas.moveAllShapes(5.0, -2.0);
        System.out.println("Новий центр 'Коло-А': " + circle.getAnchorPoint());
        System.out.println("=============================================================================");
    }
}

class Point2D {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D(Point2D other) {
        this(other.x, other.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void translate(double dx, double dy) {
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
        return String.format(Locale.US, "(%.2f; %.2f)", x, y);
    }
}

abstract class AbstractShape2D {
    private final String name;
    private final Point2D anchorPoint;

    public AbstractShape2D(String name, Point2D anchorPoint) {
        this.name = (name == null || name.isBlank()) ? "Без назви" : name;
        this.anchorPoint = (anchorPoint != null) ? new Point2D(anchorPoint) : new Point2D(0, 0);
    }

    public String getName() {
        return name;
    }

    public Point2D getAnchorPoint() {
        return new Point2D(anchorPoint);
    }

    public void moveBy(double dx, double dy) {
        anchorPoint.translate(dx, dy);
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    protected String getDimensions() {
        return "";
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s[name='%s', center=%s, %s | S=%.2f, P=%.2f]",
                getClass().getSimpleName(), name, anchorPoint, getDimensions(), getArea(), getPerimeter());
    }
}

class Circle2D extends AbstractShape2D {
    private final double radius;

    public Circle2D(String name, Point2D center, double radius) {
        super(name, center);
        this.radius = radius > 0 ? radius : 1.0;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected String getDimensions() {
        return String.format(Locale.US, "r=%.2f", radius);
    }
}

class Rectangle2D extends AbstractShape2D {
    private final double width;
    private final double height;

    public Rectangle2D(String name, Point2D center, double width, double height) {
        super(name, center);
        this.width = width > 0 ? width : 1.0;
        this.height = height > 0 ? height : 1.0;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    protected String getDimensions() {
        return String.format(Locale.US, "%.2fx%.2f", width, height);
    }
}

class RightTriangle2D extends AbstractShape2D {
    private final double legA;
    private final double legB;

    public RightTriangle2D(String name, Point2D center, double legA, double legB) {
        super(name, center);
        this.legA = legA > 0 ? legA : 1.0;
        this.legB = legB > 0 ? legB : 1.0;
    }

    public double getHypotenuse() {
        return Math.sqrt(legA * legA + legB * legB);
    }

    @Override
    public double getArea() {
        return 0.5 * legA * legB;
    }

    @Override
    public double getPerimeter() {
        return legA + legB + getHypotenuse();
    }

    @Override
    protected String getDimensions() {
        return String.format(Locale.US, "a=%.2f, b=%.2f, c=%.2f", legA, legB, getHypotenuse());
    }
}

class GeometryCanvas {
    private final String title;
    private final AbstractShape2D[] shapes;
    private int count;

    public GeometryCanvas(String title, int capacity) {
        this.title = title;
        this.shapes = new AbstractShape2D[Math.max(1, capacity)];
    }

    public boolean addShape(AbstractShape2D shape) {
        if (shape == null) {
            System.out.println("Помилка: не можна додати порожню фігуру (null)!");
            return false;
        }
        if (count >= shapes.length) {
            System.out.println("Помилка: полотно заповнене!");
            return false;
        }
        shapes[count++] = shape;
        return true;
    }

    public double getTotalArea() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += shapes[i].getArea();
        }
        return sum;
    }

    public double getTotalPerimeter() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += shapes[i].getPerimeter();
        }
        return sum;
    }

    public AbstractShape2D findLargestShape() {
        if (count == 0) {
            return null;
        }
        AbstractShape2D largest = shapes[0];
        for (int i = 1; i < count; i++) {
            if (shapes[i].getArea() > largest.getArea()) {
                largest = shapes[i];
            }
        }
        return largest;
    }

    public void moveAllShapes(double dx, double dy) {
        for (int i = 0; i < count; i++) {
            shapes[i].moveBy(dx, dy);
        }
    }

    @Override
    public String toString() {
        String s = "Полотно: '" + title + "' (Фігур: " + count + "/" + shapes.length + ")";
        for (int i = 0; i < count; i++) {
            s += "\n  " + (i + 1) + ". " + shapes[i];
        }
        return s;
    }
}
