/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Score;
/**
 * The type Counter.
 */
public class Counter {
    /**
     * The NUMBERZERO.
     */
    static final int NUMBERZERO = 0;
    private int count;

    /**
     * Constructs a new Counter with an initial count of 0.
     */
    public Counter() {
        this.count = NUMBERZERO;
    }

    /**
     * Increases the count by the given number.
     *
     * @param number the number to increase the count by
     */
// add number to current count.
    public void increase(int number) {
        count = count + number;
    }

    /**
     * Decreases the count by the given number.
     *
     * @param number the number to decrease the count by
     */
// subtract number from current count.
    public void decrease(int number) {
        count -= number;
    }
    /**
     * Returns the current count.
     *
     * @return the current count
     */
// get current count.
    public int getValue() {
        return count;
    }
}