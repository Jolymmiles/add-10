import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMain {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    public TestMain() {
        Locale.setDefault(new Locale("en", "US"));
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testMainFirst() {
        String data = "2\r\n9\r\n-2\r\n1\r\n6\r\n6\r\n6\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 4;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

    @Test
    public void testMainSecond() {
        String data = "4\r\n2\r\n1\r\n-2\r\n2\r\n4\r\n-2\r\n3\r\n4\r\n-2\r\n-3\r\n-1\r\n3\r\n-2\r\n3\r\n-3\r\n5\r\n3\r\n-2\r\n5\r\n-3\r\n-1\r\n-2\r\n3\r\n-1\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 12;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

    @Test
    public void testMainThird() {
        String data = "-3\r\n1\r\n4\r\n2\r\n3\r\n4\r\n2\r\n-3\r\n4\r\n3\r\n5\r\n-3\r\n3\r\n-1\r\n-1\r\n3\r\n2\r\n1\r\n5\r\n3\r\n-1\r\n2\r\n2\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 8;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

    @Test
    public void testMainForth() {
        String data = "-2\r\n4\r\n5\r\n-1\r\n-3\r\n-1\r\n-3\r\n1\r\n1\r\n2\r\n4\r\n-1\r\n-3\r\n2\r\n3\r\n3\r\n1\r\n2\r\n4\r\n-3\r\n-3\r\n-2\r\n-1\r\n10\r\n-2\r\n-4\r\n3\r\n10\r\n6\r\n1\r\n-10\r\n-4\r\n-4\r\n-3\r\n6\r\n-1\r\n-8\r\n7\r\n-1\r\n1\r\n7\r\n8\r\n3\r\n-1\r\n-2\r\n3\r\n1\r\n2\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 22;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

    @Test
    public void testMainFifth() {
        String data = "-1\r\n4\r\n3\r\n3\r\n-2\r\n3\r\n-1\r\n-3\r\n1\r\n-3\r\n1\r\n3\r\n-2\r\n5\r\n5\r\n-3\r\n5\r\n3\r\n2\r\n-1\r\n-2\r\n-3\r\n3\r\n0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        Main.main(null);
        int expected = 6;
        int actual = Integer.parseInt(outContent.toString().replaceAll("[\\r\\n]", ""));

        assertEquals(expected, actual);
    }

}