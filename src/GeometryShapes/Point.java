/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package GeometryShapes;
/**
 * The type Point.
 */
public class Point {
    /**
     * The EPSILON.
     */
    static final double EPSILON = 0.00001;
        /**
         * Instantiates a new Point.
         *
         * @param x the x coordinate of the point
         * @param y the y coordinate of the point
         */
        private double x;
         private double y;

    /**
     * Constructor for a new Point object with the specified x and y coordinates.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }

    /**
     * * Calculates the Euclidean distance between this point and another point.
     *
     * @param other the other point to calculate the distance to
     * @return the Euclidean distance between this point and the other point
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * Compares two double precision values to see if they are equal.
     *
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if the difference between the two numbers is less than 0.00001, false otherwise
     */
    public boolean compareDoubles(double num1, double num2) {
        return (Math.abs(num1 - num2) < EPSILON);
    }

    /**
     * Checks if this point is equal to another point.
     *
     * @param other the other point to compare to
     * @return true if the x and y coordinates of both points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (compareDoubles(this.x, other.x)) {
            return compareDoubles(this.y, other.y);
        } else {
            return false;
        }
    }

    /**
     * Returns the x coordinate of this point.
     *
     * @return the x coordinate of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Returns the y coordinate of this point.
     *
     * @return the y coordinate of this point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Equals x boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equalsX(Point other) {
        return compareDoubles(this.x, other.x);
    }

    /**
     * Equals x boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean equalsY(Point other) {
        return compareDoubles(this.y, other.y);
    }
}
