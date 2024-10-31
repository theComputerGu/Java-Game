import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//import java.util.stream.Collectors;
//import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The type Discover hypernym.
 */
public class DiscoverHypernym {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
       // if (args.length < 2) {
          //  System.out.println("Please provide the corpus directory path and the lemma.");
         //   return;
       // }
        //String corpusDirPath = args[0].replace("\\", "/");
        //String lemma = args[1];
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
        Pattern regexPat = Pattern.compile("<np>([^<]+)</np>");
        WhichIs s5 = new WhichIs(hypernymOccurrences);
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
                                    boolean flag = true;
                                    while (matcher.find()) {
                                        String s1  = sentence.substring(matcher.start(), matcher.end());
                                        Matcher matcher1 = regexPat.matcher(sentence);
                                        while (matcher1.find()) {
                                            if (s1.contains(lemma)) {
                                                if (regexPattern.toString().equals(s5.getPattern().toString())) {
                                                    int i = 0;
                                                    while (matcher1.group(i) != null) {
                                                        if (matcher1.group(i).equals(lemma)) {
                                                            String hyp = matcher1.group(1);
                                                            incrementOccurrenceCount(hypernymOccurrences, hyp);
                                                        }
                                                        i++;
                                                    }
                                                } else {
                                                    int i = 0;
                                                    while (matcher1.group(i) != null) {
                                                        if (matcher1.group(i).equals(lemma)) {
                                                            String hyp = matcher1.group(1);
                                                            incrementOccurrenceCount(hypernymOccurrences, hyp);
                                                        }
                                                        i++;
                                                    }
                                                }
                                            }
                                        }
                                        /*
                                        String hypernym2 = matcher1.toString();
                                        if (flag) {
                                            System.out.println(hypernym2);
                                        }
                                        flag = false;
                                         */
                                        //System.out.println(sentenceBuilder.toString());
                                        //matcher1.region(matcher.start(), matcher.end());
                                      //System.out.println(matcher1.region(matcher.start(), matcher.end()).toString());
                                        /*
                                        while (matcher1.find()) {
                                            if (regexPattern.toString().equals(s5.getPattern().toString())) {
                                                if (matcher1.toString().contains(lemma)) {
                                                    //String hypernym1 = matcher.toString();
                                                    String hyper = matcher1.group(1);
                                                    //incrementOccurrenceCount(hypernymOccurrences, hyper);
                                                }
                                            } else {
                                                if (matcher1.toString().contains(lemma)) {
                                                    ///String hypernym1 = matcher.toString();
                                                    String hyper = matcher1.group(1);
                                                    incrementOccurrenceCount(hypernymOccurrences, hyper);
                                                }
                                            }
                                        }
                                         */
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
    private static void incrementOccurrenceCount(Map<String, Integer> map, String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}