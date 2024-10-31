import java.util.Map;
import java.util.regex.Pattern;

/**
 * The type Patterns.
 */
public class Patterns {
    private Map<String, Integer> map;

    /**
     * Instantiates a new Patterns.
     *
     * @param map the map
     */
    public Patterns(Map<String, Integer> map) {
        this.map = map;
    }

    /**
     * Instantiates a new Add score.
     *
     * @param map the map
     * @param key the key
     */
    public void addScore(Map<String, Integer> map, String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    /**
     * Check.
     */
    public void Check() {

    }
}
