package first.pack;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);
    System.out.println("Square with side length " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Square with side length " + r.a + " and " + r.b + " = " + r.area());

    Point p1 = new Point(-2.3,4);
    Point p2 = new Point(0, 8.5);
    System.out.println("Distance between p1 and p2 = " + p1.distance(p2));
  }

  public static void hello(String somebody){
    System.out.println("Hello," + somebody + "!");
  }
}