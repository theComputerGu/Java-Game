package Animation;
import Sprites.SpriteCollection;
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Countdown animation.
 */
public class CountdownAnimation implements Animation {
    /**
     * The WIDTHSCREEN.
     */
    static final int WIDTHSCREEN = 800;
    /**
     * The HEUGHTSCREEN.
     */
    static final int HEUGHTSCREEN = 600;
    /**
     * The ONETHOUSAND.
     */
    static final int ONETHOUSAND = 1000;
    /**
     * The NUMBERZERO.
     */
    static final int NUMBERZERO = 0;
    /**
     * The NUMBERTWO.
     */
    static final int NUMBERTWO = 2;
    /**
     * The NUMBERTHIRTYTWO.
     */
    static final int NUMBERTHIRTYTWO = 32;
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private long startTime;
    private long frameDuration;
    private String level;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     * @param level        the level
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, String level) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.frameDuration = (long) (ONETHOUSAND * numOfSeconds / countFrom);
        this.level = level;
    }
    /**
     * Performs one frame of the countdown animation.
     *
     * @param d the drawing surface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // Set the background color based on the level name
        if (this.level.equals("Wide Easy")) {
            d.setColor(Color.white);
        } else if (this.level.equals("Direct Hit")) {
            d.setColor(Color.black);
        } else if (this.level.equals("Green 3")) {
            d.setColor(Color.green.darker().darker().darker());
        }
        d.fillRectangle(NUMBERZERO, NUMBERZERO, WIDTHSCREEN, HEUGHTSCREEN);
        long currentTime = System.currentTimeMillis();
        if (currentTime - startTime >= frameDuration) {
            countFrom--;
            startTime = currentTime;
        }

        gameScreen.drawAllOn(d); // Draw the game screen

        if (countFrom > NUMBERZERO) {
            // Set the color and draw the count value based on the level name
            if (this.level.equals("Wide Easy")) {
                d.setColor(Color.BLACK);
                d.drawText(d.getWidth() / NUMBERTWO, d.getHeight() / NUMBERTWO, Integer.toString(countFrom),
                        NUMBERTHIRTYTWO);
            } else if (this.level.equals("Direct Hit")) {
                d.setColor(Color.white);
                d.drawText(d.getWidth() / NUMBERTWO, d.getHeight() / NUMBERTWO, Integer.toString(countFrom),
                        NUMBERTHIRTYTWO);
            } else if (this.level.equals("Green 3")) {
                d.setColor(Color.BLACK);
                d.drawText(d.getWidth() / NUMBERTWO, d.getHeight() / NUMBERTWO, Integer.toString(countFrom),
                        NUMBERTHIRTYTWO);
            }
        } else {
            stop = true;
        }
    }
    /**
     * Determines whether the countdown animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
}