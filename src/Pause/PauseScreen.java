package Pause;
import Animation.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Pause screen.
 */
public class PauseScreen implements Animation {
    /**
     * The NUMBERTEN.
     */
    static final int NUMBERTEN = 10;
    /**
     * The NUMBERTWO.
     */
    static final int NUMBERTWO = 2;
    /**
     * The NUMBERTHIRTYTWO.
     */
    static final int NUMBERTHIRTYTWO = 32;
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * Instantiates a new Pause screen.
     *
     * @param k the k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * Perform one frame of the animation.
     *
     * @param d the DrawSurface object to draw on
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(NUMBERTEN, d.getHeight() / NUMBERTWO, "paused -- press space to continue", NUMBERTHIRTYTWO);
        //if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
         //   this.stop = true;
        //}
    }

    /**
     * Determine whether the animation should stop or continue.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}