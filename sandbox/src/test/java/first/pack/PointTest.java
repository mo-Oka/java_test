package first.pack;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void  positive() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Assert.assertEquals(p1.distance(p2), 1.4142135623730951);
  }

  @Test
  public void  zero() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(-1, -1);
    Assert.assertEquals(p1.distance(p2), 1.4142135623730951);
  }

  @Test
  public void  negative() {
    Point p1 = new Point(-1, 0);
    Point p2 = new Point(1, -1);
    Assert.assertEquals(p1.distance(p2), 2.23606797749979);
  }

  @Test
  public void  point() {
    Point p1 = new Point(0, 1);
    Point p2 = new Point(0, 1);
    Assert.assertEquals(p1.distance(p2), 0.0);
  }
}
