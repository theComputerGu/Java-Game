package Collidable;
import GeometryShapes.Point;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Collision info.
 */
public class CollisionInfo {
    /**
     * The Collision.
     */
    private Point collision;

    private Collidable object;

    /**
     * Instantiates a new Collision info.
     *
     * @param collision the collision
     * @param object    the object
     */
    public CollisionInfo(Point collision, Collidable object) {
        this.collision = collision;
        this.object = object;
    }

    /**
     * Collision.
     *
     * @return the point
     */
// the point at which the collision occurs.
    public Point collisionPoint() {
        return this.collision;
    }

    /**
     * Collision object collidable.
     *
     * @return the collidable
     */
// the collidable object involved in the collision.
    public Collidable collisionObject() {
        return this.object;
    }
}