package Day6QuestionTDD;

import junit.framework.TestCase;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// abcx
// abcy
// abcz

// "yes" on abcxyz (duplicates dont matter)

// each groups answers separated by blank line

/*
abc

a
b
c

ab
ac

a
a
a
a

b
*/

public class Day6Test extends TestCase {
    public void testEmptyFormSumsToZero() {
        assertEquals(0, sumDeclarationForm(""));
    }

    public void testFormWithASumsToOne() {
        assertEquals(1, sumDeclarationForm("a"));
    }

    public void testDuplicateAnswersOnForm() {
        assertEquals(1, sumDeclarationForm("aa"));
    }

    public void testMultipleAnswersOnForm() {
        assertEquals(2, sumDeclarationForm("ab"));
    }

    public void testGroupAnswersOnForm() {
        assertEquals(1, sumDeclarationForm("a\r\na"));
    }

    public void testMultipleGroupAnswersOnForm() {
        assertEquals(2, sumDeclarationForm("ab\r\nab"));
    }

    public void testGroupChange() {
        assertEquals(2, sumDeclarationForm("a\r\n\r\na"));
    }

    public void testInput() throws IOException {
        // read the file as a string
        byte[] input = Files.readAllBytes(Paths.get("src\\Day6QuestionTDD\\Day6Input.txt"));
        System.out.println(input[0]);
        String readableInput;
        readableInput = new String(input);
        System.out.println(sumDeclarationForm(readableInput));
        // dump output to log
    }

    int sumDeclarationForm(String form) {
        String[] groups = form.split("\r\n\r\n");

        int groupAnswers = 0;

        for (String group : groups) {
            groupAnswers += groupCount(group);
        }

        return groupAnswers;
    }

    int groupCount(String group) {
        String[] splitGroup = group.split("\r\n");

        String joinedAnswers = String.join("", splitGroup);

        IntStream joinedAnswersAsChar = joinedAnswers.chars();

        return Array.getLength(joinedAnswersAsChar.distinct().toArray());
    }
}
