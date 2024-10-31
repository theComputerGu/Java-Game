package Animation;
import biuoop.DrawSurface;
import biuoop.GUI;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Animation runner.
 */
public class AnimationRunner {
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
    private GUI gui;
    private int framesPerSecond;

    /**
     * Instantiates a new Animation runner.
     *
     * @param framesPerSecond the frames per second
     */
    public AnimationRunner(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
        this.gui = new GUI("title", WIDTHSCREEN, HEUGHTSCREEN);
    }
    /**
     * Gets gu.
     *
     * @return the gu
     */
    public  biuoop.GUI getGU() {
        return this.gui;
    }

    /**
     * Runs the specified animation.
     *
     * @param animation the animation to run
     */
        public void run(Animation animation) {
            biuoop.Sleeper sleeper = new biuoop.Sleeper();
            int millisecondsPerFrame = ONETHOUSAND / this.framesPerSecond;
            while (!animation.shouldStop()) {
                long startTime = System.currentTimeMillis(); // timing
                DrawSurface d = this.gui.getDrawSurface();
                animation.doOneFrame(d);
                this.gui.show(d);
                long usedTime = System.currentTimeMillis() - startTime;
                long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
                if (milliSecondLeftToSleep > NUMBERZERO) {
                    sleeper.sleepFor(milliSecondLeftToSleep);
                }
            }
        }
    }
