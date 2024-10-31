package Game;
import GeometryShapes.Point;
import Collidable.Collidable;
import Collidable.CollisionInfo;
import GeometryShapes.Line;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708

/**
 * The type Game environment.
 */
public class GameEnvironment {

    private List<Collidable> list;

    /**
     * Instantiates a new GameEnvironment object.
     */
    public GameEnvironment() {
        // Initialize the list of collidables as an empty ArrayList
        this.list = new ArrayList<Collidable>();
    }

    /**
     * Gets the list of collidables in the game environment.
     *
     * @return the list of collidables
     */
    public List<Collidable> getList() {
        return this.list;
    }

    /**
     * Adds a collidable object to the list of collidables in the game environment.
     *
     * @param c the collidable object to add
     */
    public void addCollidable(Collidable c) {
        list.add(c);
    }

    /**
     * Finds the closest collision between a given trajectory and any of the collidable objects in the game environment.
     *
     * @param trajectory the trajectory to check for collisions
     * @return a CollisionInfo object representing the closest collision, or null if there are no collisions
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> collisions = new ArrayList<Collidable>();
        // Find all collidables that intersect with the trajectory
        for (Collidable c : this.list) {
            if (c.getCollisionRectangle().intersectionPoints(trajectory) != null) {
                collisions.add(c);
            }
        }
        // If there are no collisions, return null
        if (collisions.isEmpty()) {
            return null;
        }
        // Find the closest collision
        double minDistance = Double.POSITIVE_INFINITY;
        Collidable closest = null;
        for (Collidable c : collisions) {
            List<Point> intersectionPoints = c.getCollisionRectangle().intersectionPoints(trajectory);
            for (Point p : intersectionPoints) {
                double distance = trajectory.start().distance(p);
                if (distance < minDistance) {
                    minDistance = distance;
                    closest = c;
                }
            }
        }
        // Return information about the closest collision
        Point collisionPoint = trajectory.end();
        if (closest != null) {
            collisionPoint = closest.getCollisionRectangle().closestIntersectionPoint(trajectory);
        } else {
            return null;
        }
        return new CollisionInfo(collisionPoint, closest);
    }

    /**
     * Remove collidable.
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {
        list.remove(c);
    }
}