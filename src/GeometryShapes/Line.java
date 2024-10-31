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
 * The Line class represents a line in the Euclidean plane.
 */
public class Line {
    /**
     * The EPSILON.
     */
    static final double EPSILON = 0.00001;
    /**
     * The DIVISIONBYTWO.
     */
    static final int DIVISIONBYTWO = 2;
    // Instance variables:
    private Point start;
    private double x1;
    private double y1;
    private Point end;
    private double x2;
    private double y2;

    /**
     * Constructs a Line object using two Point objects.
     *
     * @param start the starting Point of the Line
     * @param end   the ending Point of the Line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
    }

    /**
     * Constructs a Line object using four double values as coordinates.
     *
     * @param x1 the x-coordinate of the starting Point
     * @param y1 the y-coordinate of the starting Point
     * @param x2 the x-coordinate of the ending Point
     * @param y2 the y-coordinate of the ending Point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Helper method to compare two doubles with a small epsilon tolerance.
     *
     * @param num1 the first double
     * @param num2 the second double
     * @return true if the difference between the two doubles is less than 0.00001, false otherwise
     */
    public boolean compareDoubles(double num1, double num2) {
        return (Math.abs(num1 - num2) < EPSILON);
    }

    /**
     * Computes the length of the Line object.
     *
     * @return the length of the Line object as a double value
     */
    public double length() {
        return Math.sqrt(((this.x1 - this.x2) * (this.x1 - this.x2)) + ((this.y1 - this.y2) * (this.y1 - this.y2)));
    }

    /**
     * Computes the midpoint of the Line object.
     *
     * @return the midpoint of the Line object as a Point object
     */
    public Point middle() {
        //half from the Width of the screen
        double lengthX = (this.x1 + this.x2) / DIVISIONBYTWO;
        //half from the Height of the screen
        double lengthY = (this.y1 + this.y2) / DIVISIONBYTWO;
        Point p1 = new Point(lengthX, lengthY);
        return p1;
    }

    /**
     * Gets the starting Point of the Line object.
     *
     * @return the starting Point of the Line object
     */
    public Point start() {
        return this.start;
    }

    /**
     * Gets the ending Point of the Line object.
     *
     * @return the ending Point of the Line object
     */
    public Point end() {
        return this.end;
    }

    /**
     * Is intersecting boolean.
     *
     * @param other the other line to check for intersection
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        // check if the other line is null
        if (other == null) {
            // if it is null, return false
            return false;
        }
        // Case 1: lines are vertical
        if (compareDoubles(this.y1, other.y1) && compareDoubles(this.y2, other.y2)
                && compareDoubles(this.y2, this.y1)) {
            // Check if the x-coordinates of the lines overlap
            return ((((Math.max(this.start.getX(), this.end.getX()) > Math.min(other.start.getX(), other.end.getX()))
                    || compareDoubles(Math.max(this.start.getX(), this.end.getX()), Math.min(other.start.getX(),
                    other.end.getX())))
                    && ((Math.max(other.start.getX(), other.end.getX()) > Math.min(this.start.getX(), this.end.getX()))
                    || compareDoubles(Math.max(other.start.getX(), other.end.getX()), Math.min(this.start.getX(),
                    this.end.getX()))))
                    || (((Math.max(other.start.getX(), other.end.getX()) > Math.min(this.start.getX(), this.end.getX()))
                    || compareDoubles(Math.max(other.start.getX(), other.end.getX()), Math.min(this.start.getX(),
                    this.end.getX())))
                    && ((Math.max(this.start.getX(), this.end.getX()) > Math.min(other.start.getX(), other.end.getX()))
                    || compareDoubles(Math.max(this.start.getX(), this.end.getX()), Math.min(other.start.getX(),
                    other.end.getX())))));
            // Case 2: lines are horizontal
        } else if (compareDoubles(this.x1, other.x1) && compareDoubles(this.x2, other.x2)
                && compareDoubles(this.x2, this.x1)) {
            // Check if the y-coordinates of the lines overlap
            return ((((Math.max(this.start.getY(), this.end.getY()) > Math.min(other.start.getY(), other.end.getY()))
                    || compareDoubles(Math.max(this.start.getY(), this.end.getY()), Math.min(other.start.getY(),
                    other.end.getY())))
                    && ((Math.max(other.start.getY(), other.end.getY()) > Math.min(this.start.getY(), this.end.getY()))
                    || compareDoubles(Math.max(other.start.getY(), other.end.getY()), Math.min(this.start.getY(),
                    this.end.getY()))))
                    || (((Math.max(other.start.getY(), other.end.getY()) > Math.min(this.start.getY(), this.end.getY()))
                    || compareDoubles(Math.max(other.start.getY(), other.end.getY()), Math.min(this.start.getY(),
                    this.end.getY())))
                    && ((Math.max(this.start.getY(), this.end.getY()) > Math.min(other.start.getY(), other.end.getY()))
                    || compareDoubles(Math.max(this.start.getY(), this.end.getY()), Math.min(other.start.getY(),
                    other.end.getY())))));
            // Case 3: this line is vertical and the other line is not
        } else if ((compareDoubles(this.start.getX(), this.end.getX()))
                && (!compareDoubles(this.start.getY(), this.end.getY()))) {
            // Calculate the slope and y-intercept of the non-vertical line
            double slope = (other.y2 - other.y1) / (other.x2 - other.x1);
            double yIntercept = other.y1 - slope * other.x1;
            // Calculate the y-coordinate of the intersection point
            double y = slope * this.x1 + yIntercept;
            ////////////////////////////////////////////////////////////
            if (Math.min(other.x1, other.x2) > this.x1) {
                return false;
            }
            if (Math.max(other.x1, other.x2) < this.x1) {
                return false;
            }
            // Check if intersection point lies within the range of y-coordinates of the non-vertical line
            return (((y > Math.min(this.y1, this.y2) || compareDoubles(y, Math.min(this.y1, this.y2)))
                    && (y < Math.max(this.y2, this.y1)) || compareDoubles(y, Math.max(this.y2, this.y1)))
                    && ((y > Math.min(other.y1, other.y2) || compareDoubles(y, Math.min(other.y1, other.y2)))
                    && (y < Math.max(other.y2, other.y1)) || compareDoubles(y, Math.max(other.y2, other.y1))));
        } else if ((compareDoubles(other.start.getX(), other.end.getX()))
                && (!compareDoubles(other.start.getY(), other.end.getY())))  {
            // Calculate the slope and y-intercept of the non-vertical line
            double slope = (this.y2 - this.y1) / (this.x2 - this.x1);
            double yIntercept = this.y1 - slope * this.x1;
            // Calculate the y-coordinate of the intersection point
            double y = slope * other.x1 + yIntercept;
            if ((other.x1 < Math.max(this.x1, this.x2) || compareDoubles(other.x1, Math.max(this.x1, this.x2)))
                  && (other.x1 > Math.min(this.x1, this.x2) || compareDoubles(other.x1, Math.min(this.x1, this.x2)))) {
                // Check if intersection point lies within the range of y-coordinates of the non-vertical line
                return (((y > Math.min(this.y1, this.y2) || compareDoubles(y, Math.min(this.y1, this.y2)))
                        && (y < Math.max(this.y2, this.y1)) || compareDoubles(y, Math.max(this.y2, this.y1)))
                        && ((y > Math.min(other.y1, other.y2) || compareDoubles(y, Math.min(other.y1, other.y2)))
                        && (y < Math.max(other.y2, other.y1)) || compareDoubles(y, Math.max(other.y2, other.y1))));
            } else {
                return false;
            }
        } else {
            //case 4: Calculate the slopes and y-intercepts of the two line segments.
            double slope1 = (this.y2 - this.y1) / (this.x2 - this.x1);
            double slope2 = (other.y2 - other.y1) / (other.x2 - other.x1);
            double yIntercept1 = this.y1 - slope1 * this.x1;
            double yIntercept2 = other.y1 - slope2 * other.x1;
            // If the slopes and y-intercepts are the same, the line segments could be overlapping or parallel.
            if (compareDoubles(slope1, slope2) && compareDoubles(yIntercept1, yIntercept2)) {
                // Check if the line segments share any x-coordinates within their respective ranges.
               return ((((Math.max(this.start.getX(), this.end.getX()) > Math.min(other.start.getX(), other.end.getX()))
                     || compareDoubles(Math.max(this.start.getX(), this.end.getX()), Math.min(other.start.getX(),
                     other.end.getX())))
                     && ((Math.max(this.start.getX(), this.end.getX()) < Math.max(other.start.getX(), other.end.getX()))
                     || compareDoubles(Math.max(this.start.getX(), this.end.getX()), Math.max(other.start.getX(),
                     other.end.getX()))))
                    || (((Math.min(this.start.getX(), this.end.getX()) > Math.min(other.start.getX(), other.end.getX()))
                     || compareDoubles(Math.min(this.start.getX(), this.end.getX()), Math.min(other.start.getX(),
                     other.end.getX())))
                     && ((Math.min(this.start.getX(), this.end.getX()) < Math.max(other.start.getX(), other.end.getX()))
                     || compareDoubles(Math.min(this.start.getX(), this.end.getX()), Math.max(other.start.getX(),
                        other.end.getX())))));
                // If the slopes are the same but y-intercepts are different, the line segments are parallel and
                // non-intersecting.
            } else if (compareDoubles(slope1, slope2)) {
                return false;
            } else {
                // If slopes are not the same, find the intersection point of the two lines and check if it lies
                // on both line segments.
                double xIntersect = (yIntercept2 - yIntercept1) / (slope1 - slope2);
                double yIntersect = slope1 * xIntersect + yIntercept1;
                return ((xIntersect > this.x1 || compareDoubles(xIntersect, this.x1)) && (xIntersect < this.x2
                        || compareDoubles(xIntersect, this.x2)) || (xIntersect > this.x2
                        || compareDoubles(xIntersect, this.x2)) && (xIntersect < this.x1
                        || compareDoubles(xIntersect, this.x1)))
                && ((xIntersect > other.x1 || compareDoubles(xIntersect, other.x1)) && (xIntersect < other.x2
                        || compareDoubles(xIntersect, other.x2)) || (xIntersect > other.x2
                        || compareDoubles(xIntersect, other.x2)) && (xIntersect < other.x1
                        || compareDoubles(xIntersect, other.x1)))
                && ((yIntersect > this.y1 || compareDoubles(yIntersect, this.y1)) && (yIntersect < this.y2
                        || compareDoubles(yIntersect, this.y2)) || (yIntersect > this.y2
                        || compareDoubles(yIntersect, this.y2)) && (yIntersect < this.y1
                        || compareDoubles(yIntersect, this.y1)))
                && ((yIntersect > other.y1 || compareDoubles(yIntersect, other.y1))
                        && (yIntersect < other.y2
                        || compareDoubles(yIntersect, other.y2)) || (yIntersect > other.y2
                        || compareDoubles(yIntersect, other.y2)) && (yIntersect < other.y1
                        || compareDoubles(yIntersect, other.y1)));
            }
        }
    }

    /**
     * Returns true if the lines intersect, and false otherwise.
     *
     * @param other the other line
     * @return true if the lines intersect, and false otherwise
     */
    public Point intersectionWith(Line other) {
        // check if the other line is null
        if (other == null) {
            // if it is null, return null
            return null;
        }
        //checking if the lines isIntersecting
        if (!this.isIntersecting(other)) {
            return null;
        }
        //case 1: Check if the lines are vertical and overlapping
        if (compareDoubles(this.y1, other.y1) && compareDoubles(this.y2, other.y2)
                && compareDoubles(this.y2, this.y1)) {
            // If the lines are the same, return null
            if (this.equals(other)) {
                return null;
                // If they intersect at some point, return that point
            } else if (compareDoubles(Math.max(this.start.getX(), this.end.getX()),
                    Math.min(other.start.getX(), other.end.getX()))) {
                return new Point(Math.max(this.start.getX(), this.end.getX()), this.y1);
                // If they intersect at some point, return that point
            } else if (compareDoubles(Math.max(other.start.getX(), other.end.getX()),
                    Math.min(this.start.getX(), this.end.getX()))) {
                return new Point(Math.max(other.start.getX(), other.end.getX()), this.y1);
                // Otherwise, return null
            } else {
                return null;
            }
            //case 2: Check if the lines are horizontal and overlapping
        } else if (compareDoubles(this.x1, other.x1) && compareDoubles(this.x2, other.x2)
                && compareDoubles(this.x2, this.x1)) {
            // If the lines are the same, return null
            if (this.equals(other)) {
                return null;
                // If they intersect at some point, return that point
            } else if (compareDoubles(Math.max(this.start.getY(), this.end.getY()),
                    Math.min(other.start.getY(), other.end.getY()))) {
                return new Point(this.x1, Math.max(this.start.getY(), this.end.getY()));
                // If they intersect at some point, return that point
            } else if (compareDoubles(Math.max(other.start.getY(), other.end.getY()),
                    Math.min(this.start.getY(), this.end.getY()))) {
                return new Point(this.x1, Math.max(other.start.getY(), other.end.getY()));
                // Otherwise, return null
            } else {
                return null;
            }
            //case 3: Check if this line is vertical
        } else if ((compareDoubles(this.start.getX(), this.end.getX()))
                && (!compareDoubles(this.start.getY(), this.end.getY())))  {
            // Calculate the slope and y-intercept of the non-vertical line
            double slope = (other.y2 - other.y1) / (other.x2 - other.x1);
            double yIntercept = other.y1 - slope * other.x1;
            // Calculate the y-coordinate of the intersection point
            double y = slope * this.x1 + yIntercept;
            // return the intersection point
            return new Point(this.x1, y);
            //case 4: Check if the other line is vertical
        } else if ((compareDoubles(other.start.getX(), other.end.getX()))
                && (!compareDoubles(other.start.getY(), other.end.getY()))) {
            // Calculate the slope and y-intercept of the non-vertical line
            double slope = (this.y2 - this.y1) / (this.x2 - this.x1);
            double yIntercept = this.y1 - slope * this.x1;
            // Calculate the y-coordinate of the intersection point
            double y = slope * other.x1 + yIntercept;
            // return the intersection point
            return new Point(other.x1, y);
        } else {
            //case 5: Check if the two line segments intersect
            // Find the slopes and y-intercepts of the two lines
            double slope1 = (this.y2 - this.y1) / (this.x2 - this.x1);
            double slope2 = (other.y2 - other.y1) / (other.x2 - other.x1);
            double yIntercept1 = this.y1 - slope1 * this.x1;
            double yIntercept2 = other.y1 - slope2 * other.x1;
            // If the slopes and y-intercepts are equal, the lines are either coincident or overlapping
            if (compareDoubles(slope1, slope2) && compareDoubles(yIntercept1, yIntercept2)) {
                // If the lines are coincident, return null to indicate that there is no unique intersection point
                if (compareDoubles(slope1, slope2) && this.equals(other)) {
                    return null;
                    // Otherwise, the lines are overlapping and their intersection is at the lower-left endpoint
                    // of their overlap
                } else if ((compareDoubles(Math.min(this.start.getX(), this.end.getX()),
                        Math.min(other.start.getX(), other.end.getX())))
                        && (compareDoubles(Math.min(this.start.getY(), this.end.getY()),
                        Math.min(other.start.getY(), other.end.getY())))) {
                    return new Point(Math.min(this.start.getX(), this.end.getX()),
                            Math.min(this.start.getY(), this.end.getY()));
                    // If the lines are not overlapping, return null to indicate that there is no intersection point
                } else {
                    return null;
                }
                // If the slopes and/or y-intercepts are different, the lines intersect at a unique point
            } else {
                // Compute the x-coordinate of the intersection point
                double xIntersect = (yIntercept2 - yIntercept1) / (slope1 - slope2);
                // Compute the y-coordinate of the intersection point using either line equation
                double yIntersect = slope1 * xIntersect + yIntercept1;

                // check if the point of intersection is within the bounds of both lines
                return new Point(xIntersect, yIntersect);
            }
        }
    }

    /**
     * Check if two lines are equal.
     * Two lines are considered equal if they have the same start and end points,
     * or if they have the same start and end points but in reverse order.
     *
     * @param other the other line to compare to.
     * @return true if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        // check that both lines are not null
        if (other != null && this != null) {
            // check if the lines have the same start and end points
            // or if they have the same points but in reverse order
            return ((compareDoubles(this.x1, other.x1) && compareDoubles(this.y1, other.y1)
                    && compareDoubles(this.x2, other.x2) && compareDoubles(this.y2, other.y2))
                    || (compareDoubles(this.x1, other.x2) && compareDoubles(this.y1, other.y2)
                    && compareDoubles(this.x2, other.x1) && compareDoubles(this.y2, other.y1)));
        } else {
            // if one or both lines are null, they are not equal
            return false;
        }
    }

    /**
     * Closest intersection to start of line point.
     *
     * @param rect the rect
     * @return the point
     */
// If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line l1 = new Line(this.start, this.end);
        List<Point> listOfPoints =  new ArrayList<>();
        List<Line> listOfLines =  new ArrayList<>();
        listOfLines = rect.allTheLinesInRectangle();
        for (int i = 0; i < 4; i++) {
            listOfPoints.add(listOfLines.get(i).intersectionWith(l1));
        }
        Point tmp = listOfPoints.get(0);
        Point p2 = tmp;
        double distance = tmp.distance(this.start);
        for (int i = 1; i < 4; i++) {
            Point p1 = listOfPoints.get(i);
            if (distance >= p1.distance(this.start)) {
                distance = p1.distance(this.start);
                 p2 = p1;
            }
        }
        return p2;
    }
}