package Sprites;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708

/**
 * The type Sprite collection.
 */
public class SpriteCollection {
    private List<Sprite> list;

    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.list = new ArrayList<Sprite>();
    }

    /**
     * Gets sprite.
     *
     * @param s the s
     * @return the sprite
     */
    public  List<Sprite> getSprite(Sprite s) {
        return this.list;
    }

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }

    /**
     * Notify all time passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> s1 = new ArrayList<>(this.list);
        for (Sprite s : s1) {
            s.timePassed(); // call timePassed() on all sprites.
        }
    }

    /**
     * Draw all on.
     *
     * @param d the d
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.list) {
            s.drawOn(d); // call drawOn(d) on all sprites.
        }
    }

    /**
     * Remove sprite.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        this.list.remove(s);
    }
}