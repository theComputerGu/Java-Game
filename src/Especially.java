import java.util.Map;
import java.util.regex.Pattern;

/**
 * The type Especially.
 */
public class Especially extends Patterns {
    private Pattern pattern;
    /**
     * Instantiates a new Patterns.
     *
     * @param map the map
     */
    public Especially(Map<String, Integer> map) {
        super(map);
        this.pattern = Pattern.compile("<np>(.+?)</np> ,? ?especially <np>(.+?)</np>"
                + " ?(,? ?(or|and)? ?<np>(.+?)</np> ?)*");
    }
}
