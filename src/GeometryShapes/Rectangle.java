package GeometryShapes;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Rectangle.
 */
public class Rectangle {
    /**
     * The ZERONUMBER.
     */
    static final int ZERONUMBER = 0;

    // The upper left point of the rectangle
    private Point upperLeft;
    // The width of the rectangle.
    private double width;
    // The height of the rectangle.
    private double height;

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * Returns a list of intersection points between the rectangle and a given line.
     *
     * @param line the line to check intersection with.
     * @return the list of intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> listOfPoints =  new ArrayList<>();
        List<Line> listOfLines =  new ArrayList<>();
        listOfLines = allTheLinesInRectangle();
        for (int i = ZERONUMBER; i < listOfLines.size(); i++) {
            if (listOfLines.get(i).intersectionWith(line) != null) {
                listOfPoints.add(listOfLines.get(i).intersectionWith(line));
            }
        }
        if (listOfPoints.size() == ZERONUMBER) {
            return null;
        }
        return listOfPoints;
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Returns the upper left point of the rectangle.
     *
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Returns a list of all the lines in the rectangle.
     *
     * @return the list of all the lines in the rectangle.
     */
    public java.util.List<Line>  allTheLinesInRectangle() {
        List<Line> list =  new ArrayList<>();
        Point upperRight = new Point(this.getUpperLeft().getX() + this.width, this.getUpperLeft().getY());
        Point bottomLeft = new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.height);
        Point bottomRight = new Point(this.getUpperLeft().getX() + width, this.getUpperLeft().getY()
                + this.height);
        Line upperLeftToUpperRight = new Line(this.getUpperLeft(), upperRight);
        Line upperLeftToBottomLeft = new Line(this.getUpperLeft(), bottomLeft);
        Line bottomLeftToBottomRight = new Line(bottomLeft, bottomRight);
        Line upperRightToBottomRight = new Line(upperRight, bottomRight);
        list.add(upperLeftToUpperRight);
        list.add(upperLeftToBottomLeft);
        list.add(bottomLeftToBottomRight);
        list.add(upperRightToBottomRight);
        return list;
    }

    /**
     * Returns the closest intersection point of the rectangle with a given line.
     *
     * @param line the line to check intersection with.
     * @return the closest intersection point.
     */
    public Point closestIntersectionPoint(Line line) {
        List<Point> intersectionPoints = intersectionPoints(line);
        if (intersectionPoints == null) {
            return null;
        }
        Point closest = null;
        double minDistance = Double.POSITIVE_INFINITY;
        for (Point p : intersectionPoints) {
            double distance = line.start().distance(p);
            if (distance < minDistance) {
                closest = p;
                minDistance = distance;
            }
        }
        return closest;
    }
}