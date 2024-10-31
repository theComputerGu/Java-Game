/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package GeometryShapes;
/**
 * The type Velocity.
 */
public class Velocity {
    /**
     * The SPEED.
     */
    static final int SPEED = 7;
    private  double dx;
    private  double dy;
    private double speed;
    /**
     * From angle and speed velocity.
     *
     * @param angle the angle in degrees
     * @param speed the speed in pixels per second
     * @return the velocity object corresponding to the input angle and speed
     */
    public Velocity fromAngleAndSpeed(double angle, double speed) {
        // Convert the angle from degrees to radians
        double radia = Math.toRadians(angle);
        // Calculate the horizontal and vertical components of the velocity
        double dx = speed * Math.sin(radia);
        // invert y-axis because positive y is downwards
        double dy = -speed * Math.cos(radia);
        // Return a new Velocity object with the calculated components
        return new Velocity(dx, dy);
        }

    /**
     * Instantiates a new Velocity object.
     *
     * @param dx the horizontal component of the velocity
     * @param dy the vertical component of the velocity
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        this.speed = SPEED;
    }
    /**
     * Gets speed.
     *
     * @return the speed
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * Gets the vertical component of the velocity.
     *
     * @return the vertical component of the velocity
     */
    public double getY() {
        return this.dy;
    }

    /**
     * Gets the horizontal component of the velocity.
     *
     * @return the horizontal component of the velocity
     */
    public double getX() {
        return this.dx;
    }

    /**
     * Applies the velocity to a point, returning a new point.
     *
     * @param p the point to which the velocity should be applied
     * @return a new point object representing the result of applying the velocity to p
     */
    public Point applyToPoint(Point p) {
        // Create a new point object with the new x and y coordinates
        Point p1;
        p1 = new Point(p.getX() + this.dx,  p.getY() + this.dy);
        // Return the new point object
        return p1;
    }
}