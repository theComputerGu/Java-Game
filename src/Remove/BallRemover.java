/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Remove;
import Game.GameLevel;
import Sprites.Ball;
import Sprites.Block;
import Hit.HitListener;
import Score.Counter;
/**
 * The type Ball remover.
 */
public class BallRemover implements HitListener {
    /**
     * The NUMBERONE.
     */
    static final int NUMBERONE = 1;
    private GameLevel gameLevel;
    private Counter ballsCounter;

    /**
     * Constructs a new BallRemover.
     *
     * @param gameLevel         the game object
     * @param ballsCounter the counter for tracking the number of balls
     */
    public BallRemover(GameLevel gameLevel, Counter ballsCounter) {
        this.gameLevel = gameLevel;
        this.ballsCounter = ballsCounter;
    }

    /**
     * Handles the hit event when a ball hits a block.
     *
     * @param beingHit the block that was hit
     * @param hitter   the ball that hit the block
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // Remove the ball from the game
        hitter.removeFromGame(gameLevel);
        hitter.removeHitListener(this);
        // Decrease the balls counter
        ballsCounter.decrease(NUMBERONE);
    }
}