/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Remove;
import Sprites.Ball;
import Sprites.Block;
import Game.GameLevel;
import Hit.HitListener;
import Score.Counter;
/**
 * The type Block remover.
 */
// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Constructs a new BlockRemover.
     *
     * @param gameLevel          the game to remove blocks from
     * @param removedBlocks the counter for tracking the remaining blocks
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * Handles the hit event where a block is hit by a ball.
     *
     * @param beingHit the block being hit
     * @param hitter   the ball that hits the block
     */
// Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // Remove the block from the game
        beingHit.removeFromGame(gameLevel);
        // Remove this listener from the block
        beingHit.removeHitListener(this);
        // Decrease the count of remaining blocks
        remainingBlocks.decrease(1);
    }
}