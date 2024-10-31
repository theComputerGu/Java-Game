package Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Key press stoppable animation.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    /**
     * Instantiates a new Key press stoppable animation.
     *
     * @param sensor    the sensor
     * @param key       the key
     * @param animation the animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true; // Set to true initially to prevent immediate response
    }

    /**
     * Performs one frame of the animation.
     *
     * @param d the drawing surface
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // Run the wrapped animation
        this.animation.doOneFrame(d);

        // Check if the key is pressed
        if (!this.keyboard.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * Determines whether the animation should stop.
     *
     * @return true if the animation should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        // Stop when the key is pressed and not already marked as pressed
        return !this.isAlreadyPressed && this.keyboard.isPressed(this.key);
    }
}