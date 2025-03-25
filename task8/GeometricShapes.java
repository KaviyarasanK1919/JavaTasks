package task8;

class Shape
{
	public double area()
	{
		System.out.println("This Shape cannot have a Area.");
		return 0.0;
	}
	public double perimeter()
	{
		System.out.println("This Shape cannot have a Perimeter.");
		return 0.0;
	}
	public void display()
	{
		System.out.println("Shape : "+ this.getClass().getSimpleName());
		System.out.println("Area : "+ area());
		System.out.println("Perimeter : " + perimeter());
		System.out.println("              --------------------------                  ");
	}
}
class Rectangle extends Shape
{
	private double length;
	private double breadth;
	public Rectangle(double length, double breadth)
	{
		this.breadth = breadth;
		this.length = length;
	}
	@Override
	public double area()
	{
		return length * breadth;
	}
	@Override
	public double perimeter()
	{
		return 2 * (length + breadth);
	}
}
class Circle extends Shape
{
	private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
class Square extends Shape
{
	private double side;
	public Square(double side)
	{
		this.side = side;
	}
	@Override
	public double area()
	{
		return side * side;
	}
	@Override
	public double perimeter()
	{
		return 4 * side;
	}
}

public class GeometricShapes {

	public static void main(String[] args) {
		Shape rectangle = new Rectangle(5, 10);
		rectangle.display();
		
		Square square = new Square(10);
		square.display();
		
		Shape circle = new Circle(2);
		circle.display();
	}
}
