package Game;
import Animation.Animation;
import Sprites.Sprite;
import biuoop.DrawSurface;
import java.awt.Font;
import java.awt.Color;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Level name.
 */
public class LevelName implements Sprite {
    /**
     * The NUMBERFIFTEEN.
     */
    static final int NUMBERFIFTEEN = 15;
    /**
     * The FITHHUNDRED.
     */
    static final int FITHHUNDRED = 500;
    /**
     * The NUMBERTWENTY.
     */
    static final int NUMBERTWENTY = 20;
    private String name;

    /**
     * Instantiates a new Level name.
     *
     * @param name the name
     */
    public LevelName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Draw the level name on the DrawSurface.
     *
     * @param d the DrawSurface object to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        // Set font and color for the scoreboard
        Font font = new Font("Arial", Font.BOLD, NUMBERTWENTY);
        Color color = Color.BLACK;

        // Set the score value

        // Draw the scoreboard
        d.setColor(color);
        d.drawText(FITHHUNDRED, NUMBERFIFTEEN, "Level Name: " + this.name, NUMBERFIFTEEN);
    }
    /**
     * Update the sprite's state as time passes.
     */
    @Override
    public void timePassed() {

    }
}
