import java.util.Map;
import java.util.regex.Pattern;

/**
 * The type Such as.
 */
public class SuchAs extends Patterns {
    private Pattern pattern;

    /**
     * Instantiates a new Patterns.
     *
     * @param map the map
     */
    public SuchAs(Map<String, Integer> map) {
        super(map);
        this.pattern = Pattern.compile("<np>(.+?)</np> ,?"
                + " ?such as <np>(.+?)</np> ?(,? ?(or|and)? ?<np>(.+?)</np> ?)*");
    }
}
