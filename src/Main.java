//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String text = "...<np>semitic languages</np> , such as <np>Hebrew</np> , <np>Arabic</np> , <np>Aabic</np>";

        Pattern pattern = Pattern.compile("<np>(.+?)</np> ,? ?such as <np>(.+?)</np> ?(,? ?(or|and)?"
                +
                " ?<np>(.+?)</np> ?)*");
        final Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}