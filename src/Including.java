import java.util.Map;
import java.util.regex.Pattern;

/**
 * The type Including.
 */
public class Including extends Patterns {
    private Pattern pattern;
    /**
     * Instantiates a new Patterns.
     *
     * @param map the map
     */
    public Including(Map<String, Integer> map) {
        super(map);
        this.pattern = Pattern.compile("<np>(.+?)</np> ,? ?including <np>(.+?)</np>"
                + " ?(,? ?(or|and)? ?<np>(.+?)</np> ?)*");
    }
}
