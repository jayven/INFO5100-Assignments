public class Shape {
    public static void main(String args[]) {
        Shape s = new Shape();
        Rectangle r = new Rectangle(2.0, 3.0);
        Circle c = new Circle(4.0);
        Square sq = new Square(4.0);
        r.getArea(); // should print 6.0
        r.getPerimeter(); // should print 10.0
        c.getArea(); // should print 50.26
        c.getPerimeter(); // should print 25.13
        sq.getArea(); // should print 16.0
        sq.getPerimeter(); // should print 16.0
        r.draw(); // should print “Drawing rectangle ”
        c.draw(); // should print “Drawing Circle”
        s.draw(); // should print “Drawing Shape”
        sq.draw() ; // should print “Drawing Square”
    }

    String name;
    double perimeter;
    double area;

    public void draw() {
        System.out.println("Drawing" + " " + "Shape");
    }

    public void getArea() {

    }

    public void getPerimeter() {

    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    private double getRadius() {
        return this.radius;
    }

    public void draw() {
        System.out.println("Drawing" + " " + "Circle");
    }

    public void getArea() {
        double radius = getRadius();
        super.area = (radius * radius * Math.PI);
        System.out.println(String.format("%.2f",area));
    }

    public void getPerimeter() {
        double radius = getRadius();
        super.perimeter =  (radius * Math.PI * 2);
        System.out.println(String.format("%.2f",perimeter));
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    private double getWidth() {
        return this.width;
    }

    private double getHeight() {
        return this.height;
    }

    public void draw() {
        System.out.println("Drawing" + " " + "Rectangle");
    }

    public void getArea() {
        double width = getWidth();
        double height = getHeight();
        super.area = width * height;
        System.out.println(area);
    }

    public void getPerimeter() {
        double width = getWidth();
        double height = getHeight();
        super.perimeter = (width + height) * 2;
        System.out.println(perimeter);
    }
}

class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    private double getSide() {
        return this.side;
    }

    public void draw() {
        System.out.println("Drawing" + " " + "Square");
    }

    public void getArea() {
        double side = getSide();
        super.area = side * side;
        System.out.println(area);
    }

    public void getPerimeter() {
        double side = getSide();
        super.perimeter = side * 4;
        System.out.println(perimeter);
    }
}