package Level;

import GeometryShapes.Velocity;
import Sprites.Block;
import Sprites.Sprite;
import java.util.List;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the int
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list.
     *
     * @return the list
     */
// The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed int.
     *
     * @return the int
     */
    int paddleSpeed();

    /**
     * Paddle width int.
     *
     * @return the int
     */
    int paddleWidth();

    /**
     * Level name string.
     *
     * @return the string
     */
// the level name will be displayed at the top of the screen.
    String levelName();

    /**
     * Gets background.
     *
     * @return the background
     */
// Returns a sprite with the background of the level
    Sprite getBackground();

    /**
     * Blocks list.
     *
     * @return the list
     */
// The Blocks that make up this level, each block contains
    // its size, color and location.
    List<Block> blocks();

    /**
     * Number of blocks to remove int.
     *
     * @return the int
     */
// Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    int numberOfBlocksToRemove();
}