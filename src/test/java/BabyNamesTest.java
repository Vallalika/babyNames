import edu.duke.FileResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BabyNamesTest {

    BabyNames babyNames;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void before() {
        System.setOut(new PrintStream(outContent));
        babyNames = new BabyNames();
    }

    @Test
    public void totalBirthsTest() {
        FileResource fr = new FileResource("testing/yob2014short.csv");
        babyNames.totalBirths(fr);
        assertEquals("Total births: 47" + "\n" +
                "Total names: 10" + "\n" + "Total girls' names: 5" + "\n" + "Total boys' names: 5", outContent.toString().trim());
    }

    @Test
    public void getRanktest() {
        assertEquals(-1,babyNames.getRank(2012, "Mason", "F"));
        assertEquals(2,babyNames.getRank(2012, "Mason", "M"));
    }

    @Test
    public void getNameTest() {
        assertEquals("Jacob",babyNames.getName(2014,4,"M"));
        assertEquals("NO NAME",babyNames.getName(2014,6,"F"));
    }

    @Test
    public void nameInOtherYearFemaleTest() {
        String name = babyNames.whatIsNameInYear("Sophia", 2012, 2014, "F");
        assertEquals("Emma", name);
    }

    @Test
    public void nameInOtherYearMaleTest() {
        String name = babyNames.whatIsNameInYear("Jacob", 2014, 2012, "M");
        assertEquals("Noah", name);
    }

    @Test
    public void yearOfHighestRankFemaleTest() {
        String highestRankYear = babyNames.yearOfHighestRank("Sophia", "F");
        assertEquals(2012, highestRankYear);
    }

    @Test
    public void yearOfHighestRankMaleTest() {
        String highestRankYear = babyNames.yearOfHighestRank("Noah", "M");
        assertEquals(2014, highestRankYear);
    }

    @Test
    public void yearOfHighestRankNoNameTest() {
        String highestRankYear = babyNames.yearOfHighestRank("Vallalika", "F");
        assertEquals(-1, highestRankYear);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

}