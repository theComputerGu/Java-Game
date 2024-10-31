package Game;
import Animation.AnimationRunner;
//import GeometryShapes.Point;
//import GeometryShapes.Rectangle;
import Animation.KeyPressStoppableAnimation;
import Level.LevelInformation;
import Score.Counter;
//import Sprites.Block;
import biuoop.KeyboardSensor;
//import biuoop.KeyboardSensor;
//import java.awt.Color;
import java.util.List;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
/**
 * The type Game flow.
 */
public class GameFlow {
    /**
     * The NUMBERZERO.
     */
    static final int NUMBERZERO = 0;
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar    the ar
     * @param score the score
     * @param ks    the ks
     */
    public GameFlow(AnimationRunner ar, Counter score, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = score;
    }
    /**
     * Runs the list of levels.
     *
     * @param levels the list of levels to run
     */
    public void runLevels(List<LevelInformation> levels) {
        // Flag to track if the player won all levels
        boolean b1 = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.score, this.animationRunner);

            level.initialize();
            // Run the level until all blocks are destroyed or no more balls are left
            while ((level.getBlocks() > NUMBERZERO) && (level.getBalls() > NUMBERZERO)) {
                level.run();
            }
            // Check if the player lost all their balls
            if (level.getBalls() == NUMBERZERO) {
                b1 = false;
                break;
            }
        }
        // Create and run the end screen with the player's score
        EndScreen endScreen = new EndScreen(b1, this.score.getValue(), this.keyboardSensor);
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
               endScreen));
        //this.animationRunner.run(endScreen);
        this.animationRunner.getGU().close();
    }
}