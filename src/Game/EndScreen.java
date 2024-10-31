package Game;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import Animation.Animation;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708

/**
 * The type End screen.
 */
public class EndScreen implements Animation {
    /**
     * The NUMBERFIFTHY.
     */
    static final int NUMBERFIFTHY = 50;
    /**
     * The NUMBERTWENTYFOUR.
     */
    static final int NUMBERTWENTYFOUR = 24;
    /**
     * The ONEHUNDRED.
     */
    static final int ONEHUNDRED = 100;
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
    private boolean isWin;
    private int score;
    private KeyboardSensor keyboard;

    /**
     * Instantiates a new End screen.
     *
     * @param isWin    the is win
     * @param score    the score
     * @param keyboard the keyboard
     */
    public EndScreen(boolean isWin, int score, KeyboardSensor keyboard) {
        this.isWin = isWin;
        this.score = score;
        this.keyboard = keyboard;
    }

    /**
     * Performs one frame of the animation.
     *
     * @param d the drawing surface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        String endMessage;
        if (isWin) {
            endMessage = "You Win! Your score is " + this.score;
        } else {
            endMessage = "Game Over. Your score is " + this.score;
        }

        // Clear the screen
        d.setColor(Color.BLACK);
        d.fillRectangle(NUMBERZERO, NUMBERZERO, d.getWidth(), d.getHeight());

        // Draw the end message
        d.setColor(Color.WHITE);
        d.drawText(d.getWidth() / NUMBERTWO - ONEHUNDRED, d.getHeight() / NUMBERTWO, endMessage, NUMBERTHIRTYTWO);

        // Draw instructions to press space to exit
        d.setColor(Color.YELLOW);
        d.drawText(d.getWidth() / NUMBERTWO - ONEHUNDRED, d.getHeight() / NUMBERTWO + NUMBERFIFTHY,
                "Press space to exit", NUMBERTWENTYFOUR);
    }
    /**
     * Determines whether the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
       // return this.keyboard.isPressed(KeyboardSensor.SPACE_KEY);
        return isWin;
    }
}