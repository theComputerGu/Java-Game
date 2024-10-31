package Sprites;
import biuoop.DrawSurface;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The interface Sprite.
 */
public interface Sprite {
    /**
     * Draw on.
     *
     * @param d the d
     */
// draw the sprite to the screen
    void drawOn(DrawSurface d);

    /**
     * timePassed.
     *
     * @param.
     */
// notify the sprite that time has passed
    void timePassed();
}
