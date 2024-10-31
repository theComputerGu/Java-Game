package Game;
import Collidable.Collidable;
import GeometryShapes.Point;
import GeometryShapes.Rectangle;
import GeometryShapes.Velocity;
import Level.LevelInformation;
import Pause.PauseScreen;
//import Remove.BallRemover;
import Remove.BallRemover;
import Remove.BlockRemover;
import Score.Counter;
//import Score.ScoreTrackingListener;
import Score.ScoreIndicator;
import Score.ScoreTrackingListener;
import Sprites.Block;
import Sprites.Paddle;
import Sprites.Sprite;
import Sprites.SpriteCollection;
import Sprites.Ball;
import biuoop.DrawSurface;
import biuoop.GUI;
import Animation.Animation;
import Animation.AnimationRunner;
import java.awt.Color;
import java.util.List;
import Animation.CountdownAnimation;
import Animation.KeyPressStoppableAnimation;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708

/**
 * The type Game.
 */
public class GameLevel implements Animation {
    /**
     * The NUMBERFIFTHHUNDREDANDEIGHTY.
     */
    static final int NUMBERFIFTHHUNDREDANDEIGHTY = 580;
    /**
     * The NUMBERSEVENHUNDREDANDNINTHY.
     */
    static final int NUMBERSEVENHUNDREDANDNINTHY = 790;
    /**
     * The NUMBERSEVENHUNDRENANDEIGHTY.
     */
    static final int NUMBERSEVENHUNDREDANDEIGHTY = 780;
    /**
     * The NUMBERFOURHUNDREDANDTHIRTY.
     */
    static final int NUMBERFOURHUNDREDANDTHIRTY = 430;
    /**
     * The NUMBERFOURHUNDRED.
     */
    static final int NUMBERFOURHUNDRED = 400;
    /**
     * The NUMBERONEHUNDREDANDNINTHY.
     */
    static final int NUMBERONEHUNDREDANDNINTHY = 590;
    /**
     * The NUMBERTWELVE.
     */
    static final int NUMBERTWELVE = 12;
    /**
     * The NUMBERONETHOUSAND.
     */
    static final int NUMBERONETHOUSAND = 1000;
    /**
     * The NUMBERSIXTEEN.
     */
    static final int NUMBERSIXTEEN = 16;
    /**
     * The NUMBERFIFTY.
     */
    static final int NUMBERFIFTY = 50;
    /**
     * The NUMBERSIXTY.
     */
    static final int NUMBERSIXTY = 60;
    /**
     * The NUMBERSIX.
     */
    static final int NUMBERSIX = 6;
    /**
     * The NUMBERFIVE.
     */
    static final int NUMBERFIVE = 5;
    /**
     * The NUMBERONEHUNDRED.
     */
    static final int NUMBERONEHUNDRED = 100;
    /**
     * The NUMBERTTHIRTY.
     */
    static final int NUMBERTTHIRTY = 30;
    /**
     * The NUMBERTWENTY.
     */
    static final int NUMBERTWENTY = 20;
    /**
     * The NUMBERTEN.
     */
    static final int NUMBERTEN = 10;
    /**
     * The HEIGHTOFTHESCREEN.
     */
    static final int HEIGHTOFTHESCREEN = 600;
    /**
     * The WIDTHOFTHESCREEN.
     */
    static final int WIDTHOFTHESCREEN = 800;
    /**
     * The NUMBERZERO.
     */
    static final int NUMBERZERO = 0;
    /**
     * The NUMBERONE.
     */
    static final int NUMBERONE = 1;
    /**
     * The NUMBERTHREE.
     */
    static final int NUMBERTHREE = 3;
    /**
     * The NUMBERFITH.
     */
    static final int NUMBERFITH = 5;
    /**
     * The NUMBERFOUR.
     */
    static final int NUMBERFOUR = 4;
    /**
     * The NUMBERTWO.
     */
    static final int NUMBERTWO = 2;
    /**
     * The NUMBERFORTY.
     */
    static final int NUMBERFORTY = 40;
    /**
     * The SEVENHUNDRENEIGHTY.
     */
    static final int SEVENHUNDRENEIGHTY = 780;
    /**
     * The FOURHUNDRED.
     */
    static final int FOURHUNDRED = 400;
    /**
     * The FITHHUNDREDFIFTHY.
     */
    static final int FITHHUNDREDFIFTHY = 550;
    /**
     * The NUMBERTWO.
     */
    static final int THREEHUNDREDFIFTHY = 350;
    /**
     * The NUMBERTWO.
     */
    static final int FITHHUNDREDSIXTY = 560;
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter remainingBlocks;
    private Counter remainBalls;
    private Counter score;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation level;

    /**
     * Instantiates a new Game.
     *
     * @param level the level
     * @param c1    the c 1
     * @param r1    the r 1
     */
    public GameLevel(LevelInformation level, Counter c1, AnimationRunner r1) {
        // Instantiate a new SpriteCollection and GameEnvironment
        this.level = level;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainingBlocks = new Counter();
        this.remainBalls = new Counter();
        this.score = c1;
        this.running = true;
        this.runner = r1;
        this.keyboard = this.runner.getGU().getKeyboardSensor();
    }

    /**
     * Instantiates a new Game.
     *
     * @param sprites         the sprites
     * @param environment     the environment
     * @param gui             the gui
     * @param remainingBlocks the remaining blocks
     */
    public GameLevel(SpriteCollection sprites, GameEnvironment environment, GUI gui, Counter remainingBlocks) {
        // Set the sprites, environment, and gui for the game
        this.sprites = sprites;
        this.environment = environment;
        this.gui = new GUI("title", WIDTHOFTHESCREEN, HEIGHTOFTHESCREEN);
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * Gets balls.
     *
     * @return the balls
     */
    public int getBalls() {
        return this.remainBalls.getValue();
    }

    /**
     * Gets blocks.
     *
     * @return the blocks
     */
    public int getBlocks() {
        return this.remainingBlocks.getValue();
    }

    /**
     * Removes a collidable object from the game environment.
     *
     * @param c the collidable object to be removed
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Removes a sprite object from the sprite collection.
     *
     * @param s the sprite object to be removed
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Gets environment.
     *
     * @return the environment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * Add collidable.
     *
     * @param c the c
     */
    public void addCollidable(Collidable c) {
        // Adds a Collidable object to the GameEnvironment's list of collidables
        this.environment.addCollidable(c);
    }

    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        // Adds a Sprite object to the SpriteCollection's list of sprites
        this.sprites.addSprite(s);
    }

    /**
     * This method initializes the game by creating and setting up all the necessary objects,
     * such as the sprites, the game environment, the GUI, the paddle, the balls, the blocks, and their colors.
     */
    public void initialize() {
        //sprites:
        ////////////////////////////////////////////////////////////////
         //Block b1 = (Block) this.level.getBackground();
         //b1.addToGame(this);
        ////////////////////////////////////////////////////////////////
        //score table:
        //////////////////////////////////////////////////////////////////////
        Point pointTable = new Point(NUMBERZERO, NUMBERZERO);
        Block scoreTable = new Block(new Rectangle(pointTable, WIDTHOFTHESCREEN, NUMBERTWENTY), Color.white);
        scoreTable.addToGame(this);
        //creating paddle:
        /////////////////////////////////////////////////
        biuoop.KeyboardSensor keyboard = this.runner.getGU().getKeyboardSensor();
        if (this.level.levelName().equals("Wide Easy")) {
            Paddle p1 = new Paddle(new Rectangle(new Point(NUMBERONEHUNDRED, FITHHUNDREDSIXTY),
                    this.level.paddleWidth(),
                    NUMBERTWENTY),
                    Color.orange,
                    this.level.paddleSpeed(), keyboard, this.level.paddleWidth());
            p1.addToGame(this);
        } else {
            Paddle p1 = new Paddle(new Rectangle(new Point(THREEHUNDREDFIFTHY, FITHHUNDREDSIXTY),
                    this.level.paddleWidth(), NUMBERTWENTY),
                    Color.orange,
                    this.level.paddleSpeed(), keyboard, this.level.paddleWidth());
            p1.addToGame(this);
        }
        //creating balls:
        /////////////////////////////////////////////////
        BallRemover ballRemover = new BallRemover(this, this.remainBalls);
        List<Velocity> ballVelocities = this.level.initialBallVelocities();
        for (int i = NUMBERZERO; i < this.level.numberOfBalls(); i++) {
            Ball ball = new Ball(FOURHUNDRED, FITHHUNDREDFIFTHY, NUMBERFITH, Color.white);
            ball.setVelocity(ballVelocities.get(i));
            ball.addToGame(this);
            ball.addHitListener(ballRemover);
            this.remainBalls.increase(NUMBERONE);
        }
        //creating 4 Rectangles:
        //////////////////////////////////////////////
        Point pointOfBlockUp = new Point(NUMBERZERO, NUMBERTWENTY);
        Point pointOfBlocDown = new Point(NUMBERTEN, HEIGHTOFTHESCREEN);
        Point pointOfBlockLeft = new Point(NUMBERZERO, NUMBERFORTY);
        Point pointOfBlockRight = new Point(SEVENHUNDRENEIGHTY, NUMBERFORTY);
        Block blockUp = new Block(new Rectangle(pointOfBlockUp, WIDTHOFTHESCREEN, NUMBERTWENTY), Color.gray);
        Block blockDown = new Block(new Rectangle(pointOfBlocDown, NUMBERSEVENHUNDREDANDEIGHTY, NUMBERTEN), Color.gray);
        Block blockLeft = new Block(new Rectangle(pointOfBlockLeft, NUMBERTWENTY, NUMBERONEHUNDREDANDNINTHY),
                Color.gray);
        Block blockRight = new Block(new Rectangle(pointOfBlockRight, NUMBERTWENTY,
                NUMBERONEHUNDREDANDNINTHY), Color.gray);
        blockUp.addToGame(this);
        blockDown.addToGame(this);
        blockLeft.addToGame(this);
        blockRight.addToGame(this);
        //score:
        //////////////////////////////////////////////////////////////////////
        LevelName l1 = new LevelName(this.level.levelName());
        this.addSprite(l1);
        ScoreIndicator scoreIndicator = new ScoreIndicator(score);
        this.addSprite(scoreIndicator);
        blockDown.addHitListener(new BallRemover(this, this.remainBalls));
        BlockRemover blockRemover = new BlockRemover(this, this.remainingBlocks);
        ScoreTrackingListener scoreListener = new ScoreTrackingListener(score);
        ////////////////////////////////////////////////////////////////////////
        // Example:
        List<Block> blocks = level.blocks();
        for (Block block : blocks) {
            block.addHitListener(scoreListener);
            block.addHitListener(blockRemover);
            this.remainingBlocks.increase(NUMBERONE);
            block.addToGame(this);
        }
    }

    /**
     * Run the game loop.
     */
    public void run() {
        // Create the CountdownAnimation
        CountdownAnimation countdown = new CountdownAnimation(NUMBERTWO, NUMBERFOUR, this.sprites,
                this.level.levelName());
        this.runner.run(countdown);
        // Run the CountdownAnimation
        //this.createBallsOnTopOfPaddle(); // or a similar method
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * Performs one frame of the game animation.
     *
     * @param d the DrawSurface on which to draw the frame
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        //checking which level in order to choose the color
        if (this.level.levelName().equals("Wide Easy")) {
            d.setColor(Color.white);
        } else if (this.level.levelName().equals("Direct Hit")) {
            d.setColor(Color.black);
        } else if (this.level.levelName().equals("Green 3")) {
            d.setColor(Color.green.darker().darker().darker());
        }
        d.fillRectangle(NUMBERZERO, NUMBERZERO, WIDTHOFTHESCREEN, HEIGHTOFTHESCREEN);
       if (this.keyboard.isPressed("p")) {
            //this.runner.run(new PauseScreen(this.keyboard));
           this.runner.run(new KeyPressStoppableAnimation(this.keyboard, keyboard.SPACE_KEY,
                   new PauseScreen(this.keyboard)));
       }
            // Check if there are no more blocks remaining or balls
            if ((this.remainingBlocks.getValue() > NUMBERZERO) && (this.remainBalls.getValue() > NUMBERZERO)) {
                this.sprites.notifyAllTimePassed();
                this.sprites.drawAllOn(d);
            } else {
                //checking if all the balls are vanished
                if (this.remainingBlocks.getValue() == NUMBERZERO) {
                    this.score.increase(NUMBERONEHUNDRED);
                    this.running = false;
                } else {
                    this.running = false;
                }
            }
    }
    /**
     * Determines if the game should stop running.
     *
     * @return true if the game should stop, false otherwise
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}