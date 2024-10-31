/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-05-28
 */
// Mark Sheinberg 324078708
package Sprites;
import biuoop.DrawSurface;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import GeometryShapes.Velocity;
import Collidable.Collidable;
import Game.GameLevel;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {
    /**
     * The REGIONSINTHEOADDLE.
     */
    static final int REGIONSINTHEOADDLE = 5;
    /**
     * The LARGEWIDTHOFTHESCREEN.
     */
    static final int LARGEWIDTHOFTHESCREEN = 790;
    /**
     * The SMALLWIDTHOFTHESCREEN.
     */
    static final int SMALLWIDTHOFTHESCREEN = 10;
    /**
     * The NUMBERTHIRTY.
     */
    static final int NUMBERTHIRTY = 30;
    /**
     * The NUMBERSIXTY.
     */
    static final int NUMBERSIXTY = 60;
    /**
     * The NUMBERTHREEHUNDRED.
     */
    static final int NUMBERTHREEHUNDRED = 300;
    /**
     * The NUMBERTHREEHUNDREDANDTHIRTY.
     */
    static final int NUMBERTHREEHUNDREDANDTHIRTY = 330;
    /**
     * The NUMBERTWO.
     */
    static final int NUMBERTWO = 2;
    /**
     * The NUMBERTHREE.
     */
    static final int NUMBERTHREE = 3;
    /**
     * The NUMBERFOUR.
     */
    static final int NUMBERFOUR = 4;
    /**
     * The NUMBERTWENTY.
     */
    static final int NUMBERTWENTY = 20;
    /**
     * The PADDLEHIT.
     */
    static final int PADDLEHIT = 780;
    private biuoop.KeyboardSensor keyboard; // a KeyboardSensor object used to detect keyboard input
    private Rectangle rectangle; // a Rectangle object that represents the paddle
    private java.awt.Color color; // the color of the paddle
    private int speed; // the speed at which the paddle moves
    private int regionWidth; // the width of each of the five regions of the paddle

    /**
     * Constructor for the Paddle class.
     * Initializes the member variables of the class.
     *
     * @param rectangle   the Rectangle object that represents the paddle
     * @param color       the color of the paddle
     * @param speed       the speed at which the paddle moves
     * @param keyboard    the KeyboardSensor object used to detect keyboard input
     * @param regionWidth the width of each of the five regions of the paddle
     */
    public Paddle(Rectangle rectangle, java.awt.Color color, int speed, biuoop.KeyboardSensor keyboard,
                  int regionWidth) {
        this.rectangle = rectangle;
        this.color = color;
        this.speed = speed;
        this.keyboard = keyboard;
        // set the region width to be one fifth of the paddle width
        this.regionWidth = (int) this.rectangle.getWidth() / REGIONSINTHEOADDLE;
    }

    /**
     * Move the paddle to the left.
     * Updates the location of the paddle's rectangle.
     */
    public void moveLeft() {
            // calculate the new x coordinate of the paddle's upper-left point
            double newX = rectangle.getUpperLeft().getX() - speed;
            // make sure the paddle doesn't move off the left side of the screen
            if (newX <= NUMBERTWENTY) {
                newX = NUMBERTWENTY;
            }
            // update the location of the paddle's rectangle
            rectangle = new Rectangle(new Point(newX, rectangle.getUpperLeft().getY()), rectangle.getWidth(),
                    rectangle.getHeight());
    }

    /**
     * Move the paddle to the right.
     * Updates the location of the paddle's rectangle.
     */
    public void moveRight() {
            // Calculate the new x coordinate for the right movement
            double newX = rectangle.getUpperLeft().getX() + speed;
            // Check if the paddle's right edge has reached the right edge of the screen
            if (newX + rectangle.getWidth() >= PADDLEHIT) {
                // If so, adjust the x coordinate to keep the paddle within the screen
                newX = PADDLEHIT - rectangle.getWidth();
            }
            // Create a new Rectangle with the updated coordinates and dimensions
            rectangle = new Rectangle(new Point(newX, rectangle.getUpperLeft().getY()), rectangle.getWidth(),
                    rectangle.getHeight());
    }
    /**
     * Update the paddle's position according to the user's input.
     */
    @Override
    public void timePassed() {
        // If the left arrow key is pressed, move the paddle left
        if (keyboard.isPressed(biuoop.KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        // If the right arrow key is pressed, move the paddle right
        if (keyboard.isPressed(biuoop.KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * Draw the paddle on the given `DrawSurface`.
     *
     * @param d the `DrawSurface` object to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        // Set the color of the draw surface to the color of the paddle
        d.setColor(color);
        // Draw a filled rectangle using the dimensions of the paddle's rectangle
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        // Set the color to black and draw the outline of the rectangle
        d.setColor(java.awt.Color.BLACK);
        d.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }
    /**
     * Return the rectangle representing the collision boundary of the paddle.
     *
     * @return the rectangle representing the collision boundary of the paddle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * This method handles the ball's hit with the paddle and returns the new velocity of the ball after the hit.
     *
     * @param collisionPoint   the point of collision between the ball and the paddle
     * @param currentVelocity  the current velocity of the ball
     * @return                 the new velocity of the ball after the hit
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // Check if the ball has a velocity
        if (currentVelocity != null) {
            // Case 1: hit on the left side of the paddle
            if (collisionPoint.equalsX(this.rectangle.getUpperLeft())) {
                // Check if the hit occurred within the paddle's height
                if (((collisionPoint.getY() > this.rectangle.getUpperLeft().getY())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY())))
                        && ((collisionPoint.getY() < this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight())
                        || (collisionPoint.compareDoubles(collisionPoint.getY(), this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight())))) {
                    return new Velocity(-currentVelocity.getX(), currentVelocity.getY());
                }
            }
            // Case 2: hit on the bottom side of the paddle
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
            // Case 3: hit on the top side of the paddle
            if (collisionPoint.equalsY(this.rectangle.getUpperLeft())) {
                // Check if the hit occurred within the paddle's width
                if (((collisionPoint.getX() > this.rectangle.getUpperLeft().getX())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX())))
                        && ((collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth())
                        || (collisionPoint.compareDoubles(collisionPoint.getX(), this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth())))) {
                    double dx = currentVelocity.getX();
                    double dy = currentVelocity.getY();

                    // Get the relative position of the collision point within the paddle's width
                    double relativePos = collisionPoint.getX() - this.rectangle.getUpperLeft().getX();

                    if (relativePos <= regionWidth) { // Hit the leftmost region (region 1)
                        return currentVelocity.fromAngleAndSpeed(NUMBERTHREEHUNDRED, currentVelocity.getSpeed());
                    } else if (relativePos <= NUMBERTWO * regionWidth) { // Hit the second region
                        return currentVelocity.fromAngleAndSpeed(NUMBERTHREEHUNDREDANDTHIRTY,
                                currentVelocity.getSpeed());
                    } else if (relativePos <= NUMBERTHREE * regionWidth) { // Hit the middle region (region 3)
                        return new Velocity(dx, -dy);
                    } else if (relativePos <= NUMBERFOUR * regionWidth) { // Hit the fourth region
                        return currentVelocity.fromAngleAndSpeed(NUMBERTHIRTY, currentVelocity.getSpeed());
                    } else { // Hit the rightmost region (region 5)
                        return currentVelocity.fromAngleAndSpeed(NUMBERSIXTY, currentVelocity.getSpeed());
                    }
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

    /**
     * Add to game.
     * This method adds the paddle both as a collidable object and as a sprite to the game.
     *
     * @param g1 the game to add the paddle to.
     */
    public void addToGame(GameLevel g1) {
        // Add this paddle as a collidable object to the game
        g1.addCollidable(this);
        // Add this paddle as a sprite to the game
        g1.addSprite(this);
    }
}