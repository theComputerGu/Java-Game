import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The type Main main.
 */
public class MainMain {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        String corpusDirPath = "C:\\Users\\user\\Desktop\\degree in computer seince\\first year\\semester B\\java\\"
                + "task7\\check";
        String lemma = "water";

        File corpusDir = new File(corpusDirPath);
        if (!corpusDir.isDirectory()) {
            System.out.println("Invalid corpus directory path.");
            return;
        }

        File[] files = corpusDir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Corpus directory is empty.");
            return;
        }
        Map<String, Integer> hypernymOccurrences = new HashMap<>();

        String[] hearstPatterns = {
                "<np>[^<]+<\\/np>( |, | , | ,)such as <np>[^<]+<\\/np>(( |, | , | ,)"
                        + "<np>[^<]+<\\/np>)*"
                        + "(( |, | , | ,)(and |or |)<np>[^<]+<\\/np>)?",

                "such <np>[^<]+<\\/np> as <np>[^<]+<\\/np>(( |, | , | ,)<np>[^<]+<\\/np>)*"
                        + "(( |, | , | ,)(and |or |)<np>[^<]+<\\/np>)?",

                "<np>[^<]+<\\/np>( |, | , | ,)including <np>[^<]+<\\/np>"
                        + "(( |, | , | ,)<np>[^<]+<\\/np>)*"
                        + "(( |, | , | ,)(and |or |)<np>[^<]+<\\/np>)?",

                "<np>[^<]+<\\/np>( |, | , | ,)which is "
                        + "((an example|a kind|a class) of )?<np>[^<]+<\\/np>",

                "<np>[^<]+<\\/np>( |, | , | ,)especially <np>[^<]+<\\/np>"
                        + "(( |, | , | ,)<np>[^<]+<\\/np>)*"
                        + "(( |, | , | ,)(and |or |)<np>[^<]+<\\/np>)?"
        };
        SuchAs s1 = new SuchAs(hypernymOccurrences);
        SuchAsNp s2 = new SuchAsNp(hypernymOccurrences);
        Including s3 = new Including(hypernymOccurrences);
        Especially s4 = new Especially(hypernymOccurrences);
        WhichIs s5 = new WhichIs(hypernymOccurrences);
        Pattern regexPat = Pattern.compile("<np>(.+?)</np>");
        Pattern[] regexPatterns = new Pattern[hearstPatterns.length];
        for (int i = 0; i < hearstPatterns.length; i++) {
            regexPatterns[i] = Pattern.compile(hearstPatterns[i]);
        }
        for (File file : files) {
            if (file.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    StringBuilder sentenceBuilder = new StringBuilder();
                    int character;
                    while ((character = reader.read()) != -1) {
                        char c = (char) character;
                        sentenceBuilder.append(c);

                        if (c == '.') {
                            String sentence = sentenceBuilder.toString();
                            if (sentence.contains(lemma)) {
                                for (Pattern regexPattern : regexPatterns) {
                                    Matcher matcher = regexPattern.matcher(sentence);
                                    while (matcher.find()) {
                                        if (matcher.toString().equals(lemma)) {
                                            String hypernym = matcher.toString().substring(1);
                                            System.out.println(hypernym);
                                        }
                                    }
                                }
                            }

                            sentenceBuilder.setLength(0);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file.getName());
                }
            }
        }
        List<Map.Entry<String, Integer>> sortedOccurrences = hypernymOccurrences.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        if (sortedOccurrences.isEmpty()) {
            System.out.println("The lemma doesn't appear in the hypernyms.");
        } else {
            for (Map.Entry<String, Integer> entry : sortedOccurrences) {
                System.out.println(entry.getKey() + ": (" + entry.getValue() + ")");
            }
        }
    }
}
