/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Sprites;
import GeometryShapes.Line;
import Hit.HitListener;
import Hit.HitNotifier;
import biuoop.DrawSurface;
import GeometryShapes.Point;
import GeometryShapes.Velocity;
import Game.GameEnvironment;
import Game.GameLevel;
import Collidable.CollisionInfo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-05-01
 */
// Mark Sheinberg 324078708

/**
 * The type Ball.
 */
public class Ball implements Sprite, HitNotifier {
    /**
     * The WIDTHDEFAULT.
     */
    static final int WIDTHDEFAULT = 800;
    /**
     * The HEIGHTDEAFULT.
     */
    static final int HEIGHTDEAFULT = 600;
    /**
     * The STARTPOSITIONOFX.
     */
    static final int STARTPOSITIONOFX = 0;
    /**
     * The STARTPOSITIONOFY.
     */
    static final int STARTPOSITIONOFY = 0;
    /**
     * The ENDTPOSITIONOFX.
     */
    static final int ENDPOSITIONOFX = 200;
    /**
     * The STARTPOSITIONOFY.
     */
    static final int ENDPOSITIONOFY = 200;
    /**
     * The NUMBERTHIRTY.
     */
    static final int NUMBERTHIRTY = 30;
    /**
     * The ZERONUMBER.
     */
    static final int ZERONUMBER = 0;
    /**
     * The ONENUMBER.
     */
    static final int ONENUMBER = 1;
    /**
     * The TWODIVISION.
     */
    static final int TWODIVISION = 2;
    /**
     * The FIVEDIVISON.
     */
    static final int FIVEDIVISON = 5;
    /**
     * The FOURDIVISION.
     */
    static final int FOURDIVISION = 4;
    /**
     * The NUMBERFIVE.
     */
    static final int NUMBERFIVE = 5;
    /**
     * Instantiates a new Ball.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity veloc;
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new Ball.
     *
     * @param center the center
     * @param r      the r
     * @param color  the color
     */
// constructor that takes a Point object as the center of the ball
    public Ball(Point center, int r, java.awt.Color color) {
        // set default values for starting and ending x and y coordinates
        this.startX = STARTPOSITIONOFX;
        this.startY = STARTPOSITIONOFY;
        this.endY = ENDPOSITIONOFY;
        this.endX = ENDPOSITIONOFX;
        // set the center of the ball
        this.center = center;
        // set the radius of the ball to either the given value or the default value of 30
        if (r <= ZERONUMBER) {
            this.radius = NUMBERTHIRTY;
        } else {
            this.radius = r;
        }
        // check if the radius is greater than the allowed maximum and set to default value of 30
        if ((this.radius > endX) || (this.radius > endY)) {
            this.radius = NUMBERTHIRTY;
        }
        // check if the ball fits within the allowed dimensions and set to default value of 30
        if ((this.radius + this.center.getX() > this.endX) || (this.radius + this.center.getY() > this.endY)) {
            this.radius = NUMBERTHIRTY;
        }
        // set the color of the ball
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x     the x
     * @param y     the y
     * @param r     the r
     * @param color the color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        // set default values for starting and ending x and y coordinates
        this.hitListeners = new ArrayList<>();
        this.startX = STARTPOSITIONOFX;
        this.startY = STARTPOSITIONOFY;
        this.endY = HEIGHTDEAFULT; //ENDPOSITIONOFY;
        this.endX = WIDTHDEFAULT; //ENDPOSITIONOFX;
        // set the center of the ball
        this.center = new Point(x, y);
        // set the radius of the ball to either the given value or the default value of 30
        if (r <= ZERONUMBER) {
            this.radius = NUMBERTHIRTY;
        } else {
            this.radius = r;
        }
        // check if the radius is greater than the allowed maximum and set to default value of 30
        if ((this.radius > endX) || (this.radius > endY)) {
            this.radius = NUMBERTHIRTY;
        }
        // check if the ball fits within the allowed dimensions and set to default value of 30
        if ((this.radius + this.center.getX() > this.endX) || (this.radius + this.center.getY() > this.endY)) {
            this.radius = NUMBERTHIRTY;
        }
        // set the color of the ball
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param x      the x-coordinate of the center point
     * @param y      the y-coordinate of the center point
     * @param r      the radius of the ball
     * @param color  the color of the ball
     * @param width  the width of the game board
     * @param height the height of the game board
     */
    public Ball(double x, double y, int r, java.awt.Color color, int width, int height) {
        // Set the start and end coordinates for the ball's movement
        this.startX = STARTPOSITIONOFX;
        this.startY = STARTPOSITIONOFY;
        this.endY = height;
        this.endX = width;
        // Set the center point of the ball
        this.center = new Point(x, y);
        // Set the radius of the ball
        if (r <= ZERONUMBER) {
            // Default radius if the input is invalid
            this.radius = NUMBERTHIRTY;
        } else {
            this.radius = r;
        }
        // Check if the radius is too big for the game board
        if ((this.radius > endX) || (this.radius > endY)) {
            // Default radius if the input is invalid
            this.radius = NUMBERTHIRTY;
        }
        // Check if the ball is positioned outsideof the game board
        if ((this.radius + this.center.getX() > this.endX) || (this.radius + this.center.getY() > this.endY)) {
            // Default radius if the input is invalid
            this.radius = NUMBERTHIRTY;
        }
        // Set the color of the ball
        this.color = color;
    }

    /**
     * Instantiates a new Ball.
     *
     * @param p1          the center point of the ball
     * @param r           the radius of the ball
     * @param color       the color of the ball
     * @param startWidth  the starting x-coordinate of the ball's movement
     * @param startHeight the starting y-coordinate of the ball's movement
     * @param endWidth    the ending x-coordinate of the ball's movement
     * @param endHeight   the ending y-coordinate of the ball's movement
     */
    public Ball(Point p1, int r, java.awt.Color color, int startWidth, int startHeight, int endWidth,
                int endHeight) {
        // Set the start and end coordinates for the ball's movement
        this.startX = startWidth;
        this.startY = startHeight;
        this.endY = endHeight;
        this.endX = endWidth;
        // Set the center point of the ball
        this.center = p1;
        // Set the radius of the ball
        if (r <= ZERONUMBER) {
            // Default radius if the input is invalid
            this.radius = NUMBERTHIRTY;
        } else {
            this.radius = r;
        }
        // Check if the radius is too big for the game board
        if ((this.radius > endX) || (this.radius > endY)) {
            // Default radius if the input is invalid
            this.radius = NUMBERTHIRTY;
        }
        // Check if the ball is positioned outsideof the game board
        if ((this.radius + this.center.getX() > this.endX) || (this.radius + this.center.getY() > this.endY)) {
            // Default radius if the input is invalid
            this.radius = NUMBERTHIRTY;
        }
        // Set the color of the ball
        this.color = color;
    }
    /**
     * Sets game environment.
     *
     * @param g1 the g 1
     */
    public void setGameEnvironment(GameEnvironment g1) {
        this.gameEnvironment = g1;
    }

    /**
     * Gets the start x position of the ball's movement boundary.
     *
     * @return the start x position
     */
    public double getStartX() {
        return  this.startX;
    }

    /**
     * Gets the radius of the ball.
     *
     * @return the radius
     */
    public double getRadius() {
        return  this.radius;
    }

    /**
     * Gets the start y position of the ball's movement boundary.
     *
     * @return the start y position
     */
    public double getStartY() {
        return  this.startY;
    }

    /**
     * Gets the end x position of the ball's movement boundary.
     *
     * @return the end x position
     */
    public double getendX() {
        return  this.endX;
    }

    /**
     * Gets the end y position of the ball's movement boundary.
     *
     * @return the end y position
     */
    public double getendY() {
        return  this.endY;
    }

    /**
     * Gets the x position of the ball.
     *
     * @return the x position
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Gets the y position of the ball.
     *
     * @return the y position
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Gets the size (radius) of the ball.
     *
     * @return the size (radius)
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * Gets the color of the ball.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }


    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface the DrawSurface to draw on
     */
    public void drawOnFrames(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
    }


    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface the DrawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        surface.setColor(Color.black);
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.radius);
        //set endX and endY
        this.endX = surface.getWidth();
        this.endY = surface.getHeight();
    }

    /**
     * Sets the velocity of the ball.
     *
     * @param v the velocity
     */
    public void setVelocity(Velocity v) {
        this.veloc = v;
    }

    /**
     * Sets start x.
     *
     * @param num the num
     */
    public void setStartX(double num) {
        this.startX = num;
    }

    /**
     * Sets start y.
     *
     * @param num the num
     */
    public void setStartY(double num) {
        this.startY = num;
    }

    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public void setVelocity(double dx, double dy) {
        this.veloc = new Velocity(dx, dy);
    }

    /**
     * Gets environment.
     *
     * @return the environment
     */
    public GameEnvironment getEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.veloc;
    }

    /**
     * Radius check.
     *
     * @param b1      the b 1
     * @param surface the surface
     */
    public void radiusCheck(Ball b1, DrawSurface surface) {
            // Check if the ball is partially or fully outside the left or right boundaries of the screen
            if ((this.center.getX() - this.radius < startX) || (this.center.getX() + this.radius > endX)) {
                // Set the radius to a default value of 5
                this.radius = NUMBERFIVE;
            }
            // Check if the ball is partially or fully outside the top or bottom boundaries of the screen
            if ((this.center.getY() - this.radius < startY) || (this.center.getY() + this.radius > endY)) {
                // Set the radius to a default value of 5
                this.radius = NUMBERFIVE;
            }
    }

    /**
     * Check limit velocity.
     *
     * @param dx      the dx
     * @param dy      the dy
     * @param surface the surface
     */
    public void checkLimitVelocity(double dx, double dy, DrawSurface surface) {
        // Check if the vertical velocity of the ball exceeds 1/4 of the screen height
        if (dy >= (surface.getHeight() / (double) FOURDIVISION)) {
            // Set the vertical velocity to 1/5 of the screen height
           this.veloc = new Velocity(dx, surface.getHeight() / (double) FIVEDIVISON);
            // Update the current vertical velocity
           dy = surface.getHeight() / (double) FIVEDIVISON;
        }
        // Check if the horizontal velocity of the ball exceeds 1/4 of the screen width
        if (dx >= (surface.getWidth() / (double) FOURDIVISION)) {
            // Set the horizontal velocity to 1/5 of the screen height
            this.veloc = new Velocity(surface.getHeight() / (double) FIVEDIVISON, dy);
        }
    }

    /**
     * Out of bounds boolean.
     */
    public void outOfBounds() {
        // Check if the ball is completely outside the left boundary of the screen
        if (this.center.getX() < startX) {
            // Set the ball to the center of the screen
            this.center = new Point((double) ((this.endX + this.startX) / TWODIVISION),
                    (double) ((this.endY + this.startY) / TWODIVISION));
            // Check if the ball is completely outside the top boundary of the screen
        } else if (this.center.getY() < startY) {
            // Set the ball to the center of the screen
            this.center = new Point((double) ((this.endX + this.startX) / TWODIVISION),
                    (double) ((this.endY + this.startY) / TWODIVISION));
            // Check if the ball is partially or fully outside the left or right boundaries of the screen
        } else if ((this.center.getX() - this.radius < startX) || (this.center.getX() + this.radius > endX)) {
            // Set the ball to the center of the screen
                this.center = new Point((double) ((this.endX + this.startX) / TWODIVISION),
                     (double) ((this.endY + this.startY) / TWODIVISION));
            // Check if the ball is partially or fully outside the top or bottom boundaries of the screen
        } else if ((this.center.getY() - this.radius < startY) || (this.center.getY() + this.radius > endY)) {
            // Set the ball to the center
            this.center = new Point((double) ((this.endX + this.startX) / TWODIVISION),
                        (double) ((this.endY + this.startY) / TWODIVISION));
        }
    }

    /**
     * Move one step.
     */
    public void moveOneStep() {
        Line l1 = new Line(this.center, new Point(this.center.getX() + this.veloc.getX(),
                this.center.getY() + this.veloc.getY()));
        CollisionInfo col1 = this.gameEnvironment.getClosestCollision(l1);
        if (this.veloc != null) {
            if (col1 == null) {
                // Get the current velocity and calculate the ball's new position
                Velocity velocity = this.getVelocity();
                Point newPosition = velocity.applyToPoint(this.center);
                /*
                // Check if the ball hits the left or right edge of the screen
                if (newPosition.getX() - this.radius <= startX || newPosition.getX() + this.radius >= endX) {
                    // If it hits the edge, change the horizontal direction of the velocity
                    velocity = new Velocity(-velocity.getX(), velocity.getY());
                }
                // Check if the ball hits the top or bottom edge of the screen
                if (newPosition.getY() - this.radius <= startY || newPosition.getY() + this.radius >= endY) {
                    // If it hits the edge, change the vertical direction of the velocity
                    velocity = new Velocity(velocity.getX(), -velocity.getY());
                }
                 */
                // Update the position of the ball based on its new velocity
                this.center = velocity.applyToPoint(this.center);
                this.setVelocity(velocity);
            } else {
                /*
                Point tmp = this.gameEnvironment.getClosestCollision(l1).collisionPoint();
                Velocity velocity = this.getVelocity();
                if ((velocity.getY() > 0) && (velocity.getX() < 0)) {
                    double numX = tmp.getX();
                    double numY = tmp.getY() - (this.radius / 10);
                    Point p1 = new Point(numX, numY);
                    this.center = p1;
                } else if () {

                } else if () {

                } else if () {

                }
                // Get the current velocity and calculate the ball's new position
                velocity = col1.collisionObject().hit(tmp, velocity);
                this.setVelocity(velocity);
                 */
                Point tmp = this.gameEnvironment.getClosestCollision(l1).collisionPoint();
                Velocity velocity = this.getVelocity();
                double numX = tmp.getX() - velocity.getX() / Math.abs(velocity.getX());
                double numY = tmp.getY() - velocity.getY() / Math.abs(velocity.getY());
                if (velocity.getY() == ZERONUMBER) {
                    numY = tmp.getY();
                }
                if (velocity.getX() == ZERONUMBER) {
                    numX = tmp.getX();
                }
                    Point p1 = new Point(numX, numY);
                    this.center = p1;
                // Get the current velocity and calculate the ball's new position
                velocity = col1.collisionObject().hit(this, tmp, velocity);
                this.setVelocity(velocity);
            }
        }
    }
    /**
     * timePassed.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Adds the ball to the given game.
     *
     * @param g1 the game to add the ball to
     */
    public void addToGame(GameLevel g1) {
        // Add the ball as a sprite to the game
        g1.addSprite(this);
        // Set the game environment of the ball to the game's environment
        this.gameEnvironment = g1.getEnvironment();
        this.setGameEnvironment(g1.getEnvironment());
    }
    /**
     * Removes the ball from the game.
     *
     * @param gameLevel the game from which the ball should be removed
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }
    /**
     * Adds a hit listener to the ball.
     *
     * @param hl the hit listener to be added
     */
    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    /**
     * Removes a hit listener from the ball.
     *
     * @param hl the hit listener to be removed
     */
    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}