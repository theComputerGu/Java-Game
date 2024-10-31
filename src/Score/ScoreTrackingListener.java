/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Score;
import Sprites.Ball;
import Sprites.Block;
import Hit.HitListener;

/**
 * The type Score tracking listener.
 */
public class ScoreTrackingListener implements HitListener {
    /**
     * The NUMBERFITH.
     */
    static final int NUMBERFITH = 5;
    private Counter currentScore;

    /**
     * Creates a new ScoreTrackingListener with the given score counter.
     *
     * @param scoreCounter the score counter to track
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * Performs the relevant actions when a hit event occurs.
     *
     * @param beingHit the block being hit
     * @param hitter   the ball that hits the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // Update the score by adding 5 points for hitting a block
        currentScore.increase(NUMBERFITH);
    }
}