public class Rectangle {

  public int x1;
  public int y1;
  public int x2;
  public int y2;

  public Rectangle(int x1, int y1, int x2, int y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  /**
   * @param r2 another Rectangle
   * @return the intersection of the rectangle
   */
  public Rectangle intersection(Rectangle r2) {
    int left = Math.max(this.x1, r2.x1);
    int right = Math.min(this.x2, r2.x2);
    int top = Math.min(this.y2, r2.y2);
    int bottom = Math.max(this.y1, r2.y1);

    if (right > left && top > bottom) {
      return new Rectangle(left, bottom, right, top);
    }
    return null;
  }

  public Rectangle intersection(Rectangle r2, Rectangle r3) {
    Rectangle firstIntersection =  this.intersection(r2);
    if (firstIntersection == null) return null;
    return firstIntersection.intersection(r3);
  }

  public int area() {
    return Math.abs(this.x1 - this.x2) * Math.abs(this.y1 - this.y2);
  }

  /**
   * @param r2 another Rectangle
   * @return true if this is instersected with r2, false otherwise
   */
  public boolean isIntersected(Rectangle r2) {
    Rectangle r = this.intersection(r2);

    if (r != null) {
      return true;
    }
    return false;
  }

  /**
   * @param r2 another Rectangle
   * @return the area of the intersection.
   */
  public int intersectionArea(Rectangle r2) {
    Rectangle r = this.intersection(r2);

    if (r != null) {
      return r.area();
    }
    return 0;
  }

  @Override
  public boolean equals(Object anObject) {
    boolean equalObjects = false;

    if (anObject != null && this.getClass() == anObject.getClass()) {
      Rectangle typedObject = (Rectangle) anObject;
      equalObjects =
          this.x1 == typedObject.x1 &&
              this.y1 == typedObject.y1 &&
              this.x2 == typedObject.x2 &&
              this.y2 == typedObject.y2;
    }
    return equalObjects;
  }
}
