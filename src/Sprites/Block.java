/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Sprites;
import Collidable.Collidable;
import Game.GameLevel;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import GeometryShapes.Velocity;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import Hit.HitNotifier;
import Hit.HitListener;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-05-01
 */
// Mark Sheinberg 324078708

/**
 * The type Block.
 */
public class Block  implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * Constructs a new Block with the specified rectangle and color.
     *
     * @param rectangle the rectangle representing the block's position and size
     * @param color     the color of the block
     */
    public Block(Rectangle rectangle, Color color) {
        this.rectangle = rectangle;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }
    /**
     * Removes the ball from the game.
     *
     * @param gameLevel the game from which the ball should be removed
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }
    /**
     * Returns the collision rectangle of the block.
     *
     * @return the collision rectangle of the block
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Calculates the new velocity of the ball after hitting the paddle.
     * @param collisionPoint the point where the ball hit the paddle
     * @param currentVelocity the current velocity of the ball
     * @return the new velocity after hitting the paddle
     */
    /*
    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity) {
        // Check if the ball has a velocity
        if (currentVelocity != null) {
            // Case 1: hit on the left side of the block
            if (collisionPoint.equalsX(this.rectangle.getUpperLeft())) {
                // Check if the hit occurred within the block's height
                if (((collisionPoint.getY() > this.rectangle.getUpperLeft().getY())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())))
                        && ((collisionPoint.getY() < this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight())))) {
                    return new Velocity(-currentVelocity.getX(), currentVelocity.getY());
                }
            }
            // Case 2: hit on the bottom side of the block
            if (collisionPoint.compareDoubles(this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight(),
                    collisionPoint.getY())) {
                if (((collisionPoint.getX() > this.rectangle.getUpperLeft().getX())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())))
                        && ((collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth())))) {
                    return new Velocity(currentVelocity.getX(), -currentVelocity.getY());
                }
            }
            // Case 3: hit on the top side of the block
            if (collisionPoint.equalsY(this.rectangle.getUpperLeft())) {
                // Check if the hit occurred within the block's width
                if (((collisionPoint.getX() > this.rectangle.getUpperLeft().getX())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())))
                        && ((collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth())))) {
                    return new Velocity(currentVelocity.getX(), -currentVelocity.getY());
                }
            }
            // Case 4: Hit the right side of the block
            if (collisionPoint.compareDoubles(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth(),
                    collisionPoint.getX())) {
                if (((collisionPoint.getY() > this.rectangle.getUpperLeft().getY())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())))
                        && ((collisionPoint.getY() < this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight())))) {
                    return new Velocity(-currentVelocity.getX(), currentVelocity.getY());
                }
            }
        }
        return currentVelocity;
    }
     */
    /**
     * Draw the block on the given `DrawSurface`.
     *
     * @param surface the `DrawSurface` object to draw on
     */
    @Override
    public void drawOn(DrawSurface surface) {
        // Set the color of the draw surface to the color of the block
        surface.setColor(this.color);
        // Draw a filled rectangle using the dimensions of the block's rectangle
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        // Set the color to black and draw the outline of the rectangle
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }
    /**
     * timePassed.
     *
     * @param.
     */
    @Override
    public void timePassed() {
    }

    /**
     * Add to game.
     * This method adds the block both as a collidable object and as a sprite to the game.
     *
     * @param g1 the game to add the block to.
     */
    public void addToGame(GameLevel g1) {
        // Add this block as a collidable object to the game
        g1.addCollidable(this);
        // Add this block as a sprite to the game
        g1.addSprite(this);
    }

    /**
     * Adds a hit listener to the list of listeners.
     *
     * @param hl the hit listener to be added
     */
    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    /**
     * Removes a hit listener from the list of listeners.
     *
     * @param hl the hit listener to be removed
     */
    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
    /**
     * Notifies all hit listeners about a hit event.
     *
     * @param hitter the ball that caused the hit
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Hit velocity.
     *
     * @param hitter          the hitter
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the velocity
     */
// Notice that we changed the hit method to include a "Ball hitter" parameter -- update the
    // Collidable interface accordingly.
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // Check if the ball has a velocity
        if (currentVelocity != null) {
            // Case 1: hit on the left side of the block
            if (collisionPoint.equalsX(this.rectangle.getUpperLeft())) {
                // Check if the hit occurred within the block's height
                if (((collisionPoint.getY() > this.rectangle.getUpperLeft().getY())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())))
                        && ((collisionPoint.getY() < this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight())))) {
                    this.notifyHit(hitter);
                    return new Velocity(-currentVelocity.getX(), currentVelocity.getY());
                }
            }
            // Case 2: hit on the bottom side of the block
            if (collisionPoint.compareDoubles(this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight(),
                    collisionPoint.getY())) {
                if (((collisionPoint.getX() > this.rectangle.getUpperLeft().getX())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())))
                        && ((collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth())))) {
                    this.notifyHit(hitter);
                    return new Velocity(currentVelocity.getX(), -currentVelocity.getY());
                }
            }
            // Case 3: hit on the top side of the block
            if (collisionPoint.equalsY(this.rectangle.getUpperLeft())) {
                // Check if the hit occurred within the block's width
                if (((collisionPoint.getX() > this.rectangle.getUpperLeft().getX())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())))
                        && ((collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth())))) {
                    this.notifyHit(hitter);
                    return new Velocity(currentVelocity.getX(), -currentVelocity.getY());
                }
            }
            // Case 4: Hit the right side of the block
            if (collisionPoint.compareDoubles(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth(),
                    collisionPoint.getX())) {
                if (((collisionPoint.getY() > this.rectangle.getUpperLeft().getY())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())))
                        && ((collisionPoint.getY() < this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight())))) {
                    this.notifyHit(hitter);
                    return new Velocity(-currentVelocity.getX(), currentVelocity.getY());
                }
            }
        }
        this.notifyHit(hitter);
        return currentVelocity;
    }
}
