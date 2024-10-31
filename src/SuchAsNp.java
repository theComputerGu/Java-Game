import java.util.Map;
import java.util.regex.Pattern;

/**
 * The type Such as np.
 */
public class SuchAsNp extends Patterns {
    private Pattern pattern;
    /**
     * Instantiates a new Patterns.
     *
     * @param map the map
     */
    public SuchAsNp(Map<String, Integer> map) {
        super(map);
        this.pattern = Pattern.compile("such <np>(.+?)</np> as <np>(.+?)</np> ?(,? ?(or|and)?"
                + " ?<np>(.+?)</np> ?)*");
    }
}
