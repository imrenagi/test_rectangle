import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RectangleTest {

  @Test
  public void shouldCreateRectangle() {
    Rectangle r = new Rectangle(0, 1, 2, 3);
    assertThat(r.x1, is(0));
    assertThat(r.y1, is(1));
    assertThat(r.x2, is(2));
    assertThat(r.y2, is(3));
  }

  @Test
  public void shouldReturnTrueIfTwoRectangleAreIntersected() {
    Rectangle r1 = new Rectangle(0, 0, 4, 4);
    Rectangle r2 = new Rectangle(3, 0, 5, 5);

    boolean isIntersected = r1.isIntersected(r2);

    assertThat(isIntersected, is(true));
  }

  @Test
  public void shouldReturnFalseIfTwoRectangleAreNotIntersected() {
    Rectangle r1 = new Rectangle(0, 0, 4, 4);
    Rectangle r2 = new Rectangle(7, 0, 9, 5);

    boolean isIntersected = r1.isIntersected(r2);

    assertFalse(isIntersected);
  }

  @Test
  public void shouldReturnIntersectedRectangle() {
    Rectangle r1 = new Rectangle(0, 0, 4, 4);
    Rectangle r2 = new Rectangle(3, 0, 5, 5);

    Rectangle intersection = r1.intersection(r2);

    assertThat(intersection, equalTo(new Rectangle(3, 0, 4, 4)));
  }

  @Test
  public void shouldReturnNullIfThereIsNoIntersection() {
    Rectangle r1 = new Rectangle(0, 0, 4, 4);
    Rectangle r2 = new Rectangle(7, 0, 9, 5);

    Rectangle intersection = r1.intersection(r2);

    assertNull(intersection);
  }

  @Test
  public void shouldReturnCorrectIntersectionArea() {
    Rectangle r1 = new Rectangle(0, 0, 4, 4);
    Rectangle r2 = new Rectangle(7, 0, 9, 5);

    int intersectionArea = r1.intersectionArea(r2);

    assertThat(intersectionArea, is(0));
  }

  @Test
  public void shouldReturnCorrectIntersectionOfThreeRectangles() {
    Rectangle r1 = new Rectangle(0, 0, 8, 4);
    Rectangle r2 = new Rectangle(4, 0, 10, 5);
    Rectangle r3 = new Rectangle(5, 1, 9, 3);

    Rectangle intersection = r1.intersection(r2, r3);

    assertThat(intersection, equalTo(new Rectangle(5, 1, 8, 3)));
  }

  @Test
  public void shouldReturnCorrectIntersectionAreaOfThreeRectangles() {
    Rectangle r1 = new Rectangle(0, 0, 8, 4);
    Rectangle r2 = new Rectangle(4, 0, 10, 5);
    Rectangle r3 = new Rectangle(5, 1, 9, 3);

    Rectangle intersection = r1.intersection(r2, r3);

    assertThat(intersection.area(), is(6));
  }

  @Test
  public void shouldReturnNullIfOnlyTwoRectanglesAreIntersectedOutOfThreeRectangles_case1() {
    Rectangle r1 = new Rectangle(0, 0, 8, 4);
    Rectangle r2 = new Rectangle(4, 0, 10, 5);
    Rectangle r3 = new Rectangle(10, 1, 15, 3);

    Rectangle intersection = r1.intersection(r2, r3);

    assertThat(intersection, is(nullValue()));
  }

  @Test
  public void shouldReturnNullIfOnlyTwoRectanglesAreIntersectedOutOfThreeRectangles_case2() {
    Rectangle r1 = new Rectangle(0, 0, 8, 4);
    Rectangle r2 = new Rectangle(10, 1, 15, 3);
    Rectangle r3 = new Rectangle(4, 0, 10, 5);

    Rectangle intersection = r1.intersection(r2, r3);

    assertThat(intersection, is(nullValue()));
  }

  @Test
  public void shouldReturnCorrectArea() {
    Rectangle r1 = new Rectangle(0, 0, 8, 4);

    assertThat(r1.area(), is(32));
  }
}