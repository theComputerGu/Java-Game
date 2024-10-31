//import Animation.Animation;
//import Animation.Animation;
import Animation.AnimationRunner;
//import Animation.KeyPressStoppableAnimation;
//import Game.EndScreen;
import Game.GameFlow;
//import Game.GameLevel;
import Level.DirectHit;
import Level.Green3;
//import Level.DirectHit;
//import Level.Green3;
//import Level.DirectHit;
//import Level.Green3;
import Level.LevelInformation;
import Level.WideEasy;
//import Animation.KeyPressStoppableAnimation;
//import Game.EndScreen;
//import Pause.PauseScreen;
import Score.Counter;
//import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;
//import Level.WideEasy;
//import Level.WideEasy;
/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708

/**
 * The type Ass 3 game.
 */
public class Ass6Game {
    /**
     * The NUMBERSIXTY.
     */
    static final int NUMBERSIXTY = 60;
    /**
     * The NUMBERSIXTY.
     */
    static final int NUMBERZERO = 0;
    /**
     * The NUMBERONE.
     */
    static final int NUMBERONE = 1;
    /**
     * The NUMBERSIXTY.
     */
    static final int NUMBERTWO = 2;
    /**
     * The NUMBERSIXTY.
     */
    static final int NUMBERTHREE = 3;
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        AnimationRunner animationRunner = new AnimationRunner(NUMBERSIXTY);
        biuoop.KeyboardSensor keyboard = animationRunner.getGU().getKeyboardSensor();
        Counter c1 = new Counter();
        // Create a list to store the levels
        List<LevelInformation> levels = new ArrayList<>();
        // Create a list to store the selected levels
        List<LevelInformation> selectedLevels = new ArrayList<>();
        DirectHit levelNumber1 = new DirectHit();
        WideEasy levelNumber2 = new WideEasy();
        Green3 levelNumber3 = new Green3();
        // Check if there are command-line arguments
        if (args.length > NUMBERZERO) {
            // Loop through each argument
            for (String arg : args) {
                try {
                    int levelNum = Integer.parseInt(arg);
                    if (levelNum == NUMBERTWO) {
                        selectedLevels.add(levelNumber2);
                    } else if (levelNum == NUMBERTHREE) {
                        selectedLevels.add(levelNumber3);
                    } else if (levelNum == NUMBERONE) {
                        selectedLevels.add(levelNumber1);
                    }
                } catch (NumberFormatException e) {
                    // Invalid argument, ignore it
                }
            }
            // Check if there are selected levels
            if (!selectedLevels.isEmpty()) {
                GameFlow g1 = new GameFlow(animationRunner, c1, keyboard);
                g1.runLevels(selectedLevels);
            } else {
                levels.add(levelNumber1);
                levels.add(levelNumber2);
                levels.add(levelNumber3);
                GameFlow g1 = new GameFlow(animationRunner, c1, keyboard);
                g1.runLevels(levels);
            }
        } else {
            levels.add(levelNumber1);
            levels.add(levelNumber2);
            levels.add(levelNumber3);
            GameFlow g1 = new GameFlow(animationRunner, c1, keyboard);
            g1.runLevels(levels);
        }
    }
}
