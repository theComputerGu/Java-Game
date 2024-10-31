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
 * The type Wide easy.
 */
public class WideEasy implements LevelInformation {
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
     * The MINUSFOURHALF.
     */
    static final double MINUSFOURHALF = -4.5;
    /**
     * The MINUSFOURHALF.
     */
    static final double MINUSFIVEHALF = -5.5;
    /**
     * The MINUSFOUR.
     */
    static final double MINUSFOUR = -4;
    /**
     * The MINUSSIX.
     */
    static final double MINUSSIX = -6;
    /**
     * The MINUSTHREEHALF.
     */
    static final double MINUSTHREEHALF = -3.5;
    /**
     * The MINUSTHREE.
     */
    static final double MINUSTHREE = -3;
    /**
     * The NUMBERTHREE.
     */
    static final int NUMBERTHREE = 3;
    /**
     * The NUMBERFOUR.
     */
    static final int NUMBERFOUR = 4;
    /**
     * The NUMBERTHREEHALF.
     */
    static final double NUMBERTHREEHALF = 3.5;
    /**
     * The NUMBERFOURHALF.
     */
    static final double NUMBERFOURHALF = 4.5;
    /**
     * The MINUSSIXHALF.
     */
    static final double MINUSSIXHALF = -6.5;
    /**
     * The MINUSSEVEN.
     */
    static final double MINUSSEVEN = -7;
    /**
     * The FIVEHUNDREDFIFTHY.
     */
    static final int FIVEHUNDREDFIFTHY = 550;
    /**
     * The NUMBERSIX.
     */
    static final int NUMBERSIX = 6;
    /**
     * The NUMBERONE.
     */
    static final int NUMBERONE = 1;
    /**
     * The NUMBERTWOHUNDEREDSEVENTY.
     */
    static final int NUMBERTWOHUNDEREDSEVENTY = 270;
    /**
     * The FIFTHYONE.
     */
    static final int FIFTHYONE = 51;
    /**
     * The SEVENTYONE.
     */
    static final int SEVENTYONE = 71;
    /**
     * The FIFTHY.
     */
    static final int FIFTHY = 50;
    /**
     * The FORTYSEVEN.
     */
    static final int FORTYSEVEN = 47;
    /**
     * Returns the number of balls in the level.
     *
     * @return the number of balls
     */
    @Override
    public int numberOfBalls() {
        return NUMBERTEN;
    }

    /**
     * Returns the initial velocities of the balls.
     *
     * @return the list of ball velocities
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(MINUSFIVE, MINUSFIVE)); // add velocity
        velocities.add(new Velocity(MINUSFOURHALF, MINUSFIVEHALF)); // add velocity
        velocities.add(new Velocity(MINUSFOUR, MINUSSIX)); // add velocity
        velocities.add(new Velocity(MINUSTHREEHALF, MINUSSIXHALF)); // add velocity
        velocities.add(new Velocity(MINUSTHREE, MINUSSEVEN)); // add velocity
        velocities.add(new Velocity(NUMBERTHREE, MINUSSEVEN)); // add velocity
        velocities.add(new Velocity(NUMBERTHREEHALF, MINUSSIXHALF)); // add velocity
        velocities.add(new Velocity(NUMBERFOUR, MINUSSIX)); // add velocity
        velocities.add(new Velocity(NUMBERFOURHALF, MINUSFIVEHALF)); // add velocity
        velocities.add(new Velocity(NUMBERFITH, MINUSFIVE)); // add velocity
        return velocities;
    }

    /**
     * Returns the paddle speed.
     *
     * @return the paddle speed
     */
    @Override
    public int paddleSpeed() {
        return NUMBERFITH;
    }

    /**
     * Returns the paddle width.
     *
     * @return the paddle width
     */
    @Override
    public int paddleWidth() {
        return FIVEHUNDREDFIFTHY;
    }

    /**
     * Returns the level name.
     *
     * @return the level name
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * Returns a new instance of the background.
     *
     * @return the background
     */
    @Override
    public Sprite getBackground() {
        return null;
    }

    /**
     * Returns the blocks that make up the level.
     *
     * @return the list of blocks
     */
    @Override
    public List<Block> blocks() {
        //creating row of blocks in different colors
        List<Block> blocks = new ArrayList<>();
        List<Color> colorList = new ArrayList<>();
        colorList.add(Color.red);
        colorList.add(Color.orange);
        colorList.add(Color.yellow);
        colorList.add(Color.green);
        colorList.add(Color.blue);
        colorList.add(Color.pink);
        colorList.add(Color.lightGray);
        int counter = SEVENTYONE;
        //////red:
        GeometryShapes.Point p1 = new GeometryShapes.Point(NUMBERTWENTY, NUMBERTWOHUNDEREDSEVENTY);
        Block block = new Block(new Rectangle(p1, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERZERO));
        GeometryShapes.Point p2 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block1 = new Block(new Rectangle(p2, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERZERO));
        blocks.add(block);
        blocks.add(block1);
        //////
        //////orange:
        GeometryShapes.Point p3 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block2 = new Block(new Rectangle(p3, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERONE));
        GeometryShapes.Point p4 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block3 = new Block(new Rectangle(p4, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERONE));
        blocks.add(block2);
        blocks.add(block3);
        //////
        //////yellow:
        GeometryShapes.Point p5 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block4 = new Block(new Rectangle(p5, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERTWO));
        GeometryShapes.Point p6 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block5 = new Block(new Rectangle(p6, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERTWO));
        blocks.add(block4);
        blocks.add(block5);
        //////
        //////green:
        GeometryShapes.Point p7 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block6 = new Block(new Rectangle(p7, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERTHREE));
        GeometryShapes.Point p8 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block7 = new Block(new Rectangle(p8, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERTHREE));
        GeometryShapes.Point p9 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block8 = new Block(new Rectangle(p9, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERTHREE));
        blocks.add(block6);
        blocks.add(block7);
        blocks.add(block8);
        //////
        //////blue:
        GeometryShapes.Point p10 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block9 = new Block(new Rectangle(p10, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERFOUR));
        GeometryShapes.Point p11 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block10 = new Block(new Rectangle(p11, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERFOUR));
        blocks.add(block9);
        blocks.add(block10);
        //////
        //////pink:
        GeometryShapes.Point p12 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHYONE;
        Block block11 = new Block(new Rectangle(p12, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERFITH));
        GeometryShapes.Point p13 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FORTYSEVEN;
        Block block12 = new Block(new Rectangle(p13, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERFITH));
        blocks.add(block11);
        blocks.add(block12);
        //////
        //////light blue:
        GeometryShapes.Point p14 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        counter = counter + FIFTHY;
        Block block13 = new Block(new Rectangle(p14, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERSIX));
        GeometryShapes.Point p15 = new GeometryShapes.Point(counter, NUMBERTWOHUNDEREDSEVENTY);
        Block block14 = new Block(new Rectangle(p15, FIFTHYONE, NUMBERTWENTY), colorList.get(NUMBERSIX));
        blocks.add(block13);
        blocks.add(block14);
        //////
        return blocks;
    }

    /**
     * Returns the number of blocks to be removed in order to clear the level.
     *
     * @return the number of blocks to be removed
     */
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
