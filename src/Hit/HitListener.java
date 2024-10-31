/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Hit;
import Sprites.Block;
import Sprites.Ball;
/**
 * The interface Hit listener.
 */
public interface HitListener {
    /**
     * Handles the hit event when an object is hit.
     *
     * @param beingHit the object that was hit
     * @param hitter   the object that hit the other object
     */
// This method is called whenever the beingHit object is hit.
    // The hitter parameter is the Ball that's doing the hitting.
    void hitEvent(Block beingHit, Ball hitter);
}