package first.pack;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);
    System.out.println("Square with side length " + s.l + " = " + area(s));

    Rectangle r = new Rectangle(4,6);
    System.out.println("Square with side length " + r.a + " and " + r.b + " = " + area(r));
  }

  public static void hello(String somebody){
    System.out.println("Hello," + somebody + "!");
  }

  public static double area(Square s) {
    return s.l*s.l;
  }

  public static double area (Rectangle r) {
    return r.a*r.b;
  }

}