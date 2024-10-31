package Level;

import GeometryShapes.Rectangle;
import GeometryShapes.Velocity;
import Sprites.Block;
import Sprites.Sprite;
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
 * The type Green 3.
 */
public class Green3 implements LevelInformation {
    /**
     * The NUMBERONEHUNDRED.
     */
    static final int NUMBERONEHUNDRED = 100;
    /**
     * The NUMBERTWENTY.
     */
    static final int NUMBERTWENTY = 20;
    /**
     * The NUMBERTEN.
     */
    static final int NUMBERTEN = 10;
    /**
     * The NUMBERZERO.
     */
    static final int NUMBERZERO = 0;
    /**
     * The NUMBERFITH.
     */
    static final int NUMBERFITH = 5;
    /**
     * The NUMBERTWO.
     */
    static final int NUMBERTWO = 2;
    /**
     * The NUMBERFORTY.
     */
    static final int NUMBERFORTY = 40;
    /**
     * The MINUSFIVE.
     */
    static final int MINUSFIVE = -5;
    /**
     * The THREEHUNDREDEIGHTY.
     */
    static final int THREEHUNDREDEIGHTY = 380;
    /**
     * The ONEHUNDREDFIFTHY.
     */
    static final int ONEHUNDREDFIFTHY = 150;
    /**
     * Number of balls int.
     *
     * @return the int
     */
    @Override
    public int numberOfBalls() {
        return NUMBERTWO;
    }
    /**
     * Get the initial velocities of the balls.
     *
     * @return a list of initial velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(MINUSFIVE, MINUSFIVE)); //add velocity
        velocities.add(new Velocity(NUMBERFITH, MINUSFIVE)); //add velocity
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
        return NUMBERONEHUNDRED;
    }

    /**
     * Get the name of the level.
     *
     * @return the level name
     */
    @Override
    public String levelName() {
        return "Green 3";
    }

    /**
     * Get the background sprite of the level.
     *
     * @return the background sprite
     */
    @Override
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
        //creating rows of block in different colors
        List<Block> blocks = new ArrayList<>();
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.gray);
        colorList.add(Color.red);
        colorList.add(Color.yellow);
        colorList.add(Color.blue);
        colorList.add(Color.white);
        int num = NUMBERTEN;
        int tmp = NUMBERZERO;
        int y = ONEHUNDREDFIFTHY;
        int counter = THREEHUNDREDEIGHTY;
        //creating 5 rows of blocks
        for (int i = NUMBERZERO; i < NUMBERFITH; i++) {
            //creating the blocks in the row
            for (int j = NUMBERZERO; j < num; j++) {
                GeometryShapes.Point p2 = new GeometryShapes.Point(counter + tmp, y);
                Block block = new Block(new Rectangle(p2, NUMBERFORTY, NUMBERTWENTY), colorList.get(i));
                blocks.add(block);
                tmp = tmp + NUMBERFORTY;
            }
            tmp = NUMBERZERO;
            counter = counter + NUMBERFORTY;
            num--;
            y = y + NUMBERTWENTY;
        }
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
