package Level;

import GeometryShapes.Velocity;
import Sprites.Ball;
import Sprites.Block;
import Sprites.Sprite;
import GeometryShapes.Rectangle;
import GeometryShapes.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Direct hit.
 */
public class DirectHit implements LevelInformation {
    /**
     * The NUMBERONE.
     */
    static final int NUMBERONE = 1;
    /**
     * The MINUSFITH.
     */
    static final int MINUSFITH = -5;
    /**
     * The NUMBERZERO.
     */
    static final int NUMBERZERO = 0;
    /**
     * The NUMBERTEN.
     */
    static final int NUMBERTEN = 10;
    /**
     * The ONEHUNDRED.
     */
    static final int ONEHUNDRED = 100;
    /**
     * The TWOHUNDRED.
     */
    static final int TWOHUNDRED = 200;
    /**
     * The NUMBERTHREEHUNDREDEIGHTY.
     */
    static final int NUMBERTHREEHUNDREDEIGHTY = 380;
    /**
     * The NUMBERFORTHY.
     */
    static final int NUMBERFORTHY = 40;
    private Ball ball;
    /**
     * Number of balls int.
     *
     * @return the int
     */
    @Override
    public int numberOfBalls() {
        return NUMBERONE;
    }

    /**
     * Get the initial velocities of the balls.
     *
     * @return a list of initial velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(NUMBERZERO, MINUSFITH));
        return velocities;
    }

    /**
     * Get the speed of the paddle.
     *
     * @return the paddle speed
     */
    @Override
    public int paddleSpeed() {
        return NUMBERTEN;
    }
    /**
     * Get the width of the paddle.
     *
     * @return the paddle width
     */
    @Override
    public int paddleWidth() {
        return ONEHUNDRED;
    }

    /**
     * Get the name of the level.
     *
     * @return the level name
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * Get the background sprite of the level.
     *
     * @return the background sprite
     */
    public Sprite getBackground() {
        return null;
    }
    /**
     * Get the blocks that make up the level.
     *
     * @return a list of blocks
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        // Add the single block for Level 1
        Point p1 = new Point(NUMBERTHREEHUNDREDEIGHTY, TWOHUNDRED);
        Block b1 = new Block(new Rectangle(p1, NUMBERFORTHY, NUMBERFORTHY), Color.red);
        blocks.add(b1);
        return blocks;
    }

    /**
     * Get the number of blocks to remove in the level.
     *
     * @return the number of blocks to remove
     */
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
