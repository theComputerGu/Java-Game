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
 * The type Printing hit listener.
 */
public class PrintingHitListener implements HitListener {
    /**
     * Hit event.
     *
     * @param beingHit the being hit
     * @param hitter   the hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}