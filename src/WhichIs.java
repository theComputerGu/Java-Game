import java.util.Map;
import java.util.regex.Pattern;

/**
 * The type Which is.
 */
public class WhichIs extends Patterns {
    private Pattern pattern;
    /**
     * Instantiates a new Patterns.
     *
     * @param map the map
     */
    public WhichIs(Map<String, Integer> map) {
        super(map);
        this.pattern = Pattern.compile("<np>[^<]+<\\/np>( |, | , | ,)which is "
                + "((an example|a kind|a class) of )?<np>[^<]+<\\/np>");
    }
    /**
     * Gets pattern.
     *
     * @return the pattern
     */
    public Pattern getPattern() {
        return this.pattern;
    }
}
