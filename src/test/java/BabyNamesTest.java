import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BabyNamesTest {

    BabyNames babyNames;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    FileResource fr;

    @Before
    public void before() {
        System.setOut(new PrintStream(outContent));
        babyNames = new BabyNames();
        fr = new FileResource("testing/yob2014short.csv");
    }

    @Test
    public void totalBirthsTest() {
        babyNames.totalBirths(fr);
        assertEquals("Total births: 47" + "\n" +
                "Total girls: 18" + "\n" + "Total boys: 29", outContent.toString().trim());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut));
    }
}
