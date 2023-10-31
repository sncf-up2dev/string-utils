package fr.sncf.up2dev;

import org.junit.jupiter.api.Test;

import static fr.sncf.up2dev.StringUtils.countWord;
import static fr.sncf.up2dev.StringUtils.slugify;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilsTest {

    @Test
    void slugify_empty_string() {
        assertEquals( "", slugify(""));
    }

    @Test
    void slugify_capital_letters() {
        assertEquals( "hello-world", slugify("Hello World"));
    }

    @Test
    void slugify_dash() {
        assertEquals( "hello-world", slugify("Hello-World"));
    }

    @Test
    void slugify_underscore() {
        assertEquals( "hello-world", slugify("Hello_World"));
    }

    @Test
    void slugify_padding() {
        assertEquals( "hello-world", slugify("  Hello   World "));
    }

    @Test
    void slugify_special_characters() {
        assertEquals( "hello-world", slugify("#Hello %!World$"));
    }

    @Test
    void slugify_accents() {
        assertEquals("hello-world" , slugify("Hẹ́llo Ẃôrld"));
    }

    @Test
    void countWords_empty_text() {
        assertEquals( 0L, countWord("", "needle"));
    }

    @Test
    void countWords_empty_word() {
        assertEquals( 0L, countWord("heap", ""));
    }

    @Test
    void countWords_one() {
        assertEquals( 1L, countWord("needle in a heap", "needle"));
    }

    @Test
    void countWords_two() {
        assertEquals( 2L, countWord("needle in a heap, another needle", "needle"));
    }

    @Test
    void countWords_with_words_with_suffix() {
        assertEquals( 1L, countWord("needle in a heap, other needles", "needle"));
    }

    @Test
    void countWords_with_words_with_prefix() {
        assertEquals( 1L, countWord("needle in a heap, theneedle", "needle"));
    }

    @Test
    void countWords_with_words_with_prefix_and_sudffix() {
        assertEquals( 1L, countWord("needle in a heap, theneedles", "needle"));
    }
}