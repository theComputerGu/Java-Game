/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Score;
import Sprites.Sprite;
import biuoop.DrawSurface;
import java.awt.Font;
import java.awt.Color;
/**
 * The type Score indicator.
 */
public class ScoreIndicator implements Sprite {
    /**
     * The FONTSIZE.
     */
    static final int FONTSIZE = 20;
    /**
     * The HEIGHT.
     */
    static final int HEIGHT = 15;
    /**
     * The XCORDINANT.
     */
    static final int XCORDINANT = 380;
    /**
     * The YCORDINANT.
     */
    static final int YCORDINANT = 15;
    private Counter scoreCounter;

    /**
     * Creates a new ScoreIndicator with the given score counter.
     *
     * @param scoreCounter the score counter to display
     */
    public ScoreIndicator(Counter scoreCounter) {
        this.scoreCounter = scoreCounter;
    }
    /**
     * Draws the score indicator on the given DrawSurface.
     *
     * @param d the DrawSurface to draw on
     */
    @Override
    public void drawOn(DrawSurface d) {
        // Set font and color for the scoreboard
        Font font = new Font("Arial", Font.BOLD, FONTSIZE);
        Color color = Color.BLACK;

        // Set the score value
        int score = scoreCounter.getValue();

        // Draw the scoreboard
        d.setColor(color);
        d.drawText(170, YCORDINANT, "Score: " + score, HEIGHT);
    }

    /**
     * Performs the relevant actions when time passed.
     * This method is empty for the ScoreIndicator.
     */
    @Override
    public void timePassed() {
        // Score indicator doesn't need to perform any action in each frame
    }
}