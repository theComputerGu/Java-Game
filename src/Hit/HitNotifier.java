/**
 * @author Mark Sheinberg < sheinberg.mark@live.biu.ac.il >
 * @version 1.0
 * @since 2023-06-14
 */
// Mark Sheinberg 324078708
package Hit;
/**
 * The interface Hit notifier.
 */
public interface HitNotifier {
    /**
     * Adds a hit listener to the list of listeners.
     *
     * @param hl the hit listener to be added
     */
// Add hl as a listener to hit events.
    void addHitListener(HitListener hl);
    /**
     * Removes a hit listener from the list of listeners.
     *
     * @param hl the hit listener to be removed
     */
// Remove hl from the list of listeners to hit events.
    void removeHitListener(HitListener hl);
}