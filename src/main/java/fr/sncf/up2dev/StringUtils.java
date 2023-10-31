package fr.sncf.up2dev;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for string manipulation.
 */
public class StringUtils {

    /**
     * Count occurrences of one word in a given text.
     *
     * @param text  the text to be searched
     * @param word  the word to be looked for
     * @return  number of occurrences of {@code word}
     */
    public static long countWord(String text, String word) {
        long count = 0;
        for (String current: StringUtils.split(text)) {
            if (word.equals(current)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Slugify a text.
     *
     * @param original  the text to be slugified
     * @return          the slugified text
     */
    public static String slugify(String original) {
        List<String> words = new ArrayList<>();
        for (String word: StringUtils.split(original)) {
            if (!word.isEmpty()) {
                word = StringUtils.removePunctuations(word);
                word = StringUtils.stripAccents(word);
                word = word.toLowerCase();
                words.add(word);
            }
        }
        return String.join("-", words.toArray(new String[0]));
    }

    /**
     * Strip accents from a given text. For instance the word naïve becomes naive.
     *
     * @param original  the original text
     * @return          the same text without accents
     */
    public static String stripAccents(String original) {
        return Normalizer.normalize(original, Normalizer.Form.NFKD).replaceAll("\\P{ASCII}+", "");
    }

    /**
     * Remove punctuations from a given string.
     *
     * @param original  original string
     * @return          same string without punctuations
     */
    public static String removePunctuations(String original) {
        return original.replaceAll("\\p{Punct}+", "");
    }

    /**
     * Split a string using empty spaces, dashes and underscores as separators.
     *
     * @param original  original text
     * @return          a list of tokens
     */
    public static List<String> split(String original) {
        return List.of(original.split("[\\s\\-_]+"));
    }
}
