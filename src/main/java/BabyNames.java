import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class BabyNames {
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalNames = 0;
        for (CSVRecord rec: fr.getCSVParser(false)) {

            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            totalNames ++;

        }
        int totalGirlsNames = totalNames/2;
        int totalBoysNames = totalNames/2;
        System.out.println("Total births: " + totalBirths);
        System.out.println("Total names: " + totalNames);
        System.out.println("Total girls' names: " + totalGirlsNames);
        System.out.println("Total boys' names: " + totalBoysNames);
    }

    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource("testing/yob"+year+"short.csv");
        int nameRank = -1;
        int genderRank = 0;
        for (CSVRecord rec: fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                genderRank++;
                if (rec.get(0).equals(name)) {
                    nameRank = genderRank;
                }
            }
        }
        return nameRank;
    }

    public String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource("testing/yob"+year+"short.csv");
        String name = "NO NAME";
        int genderRank = 0;
        for (CSVRecord rec: fr.getCSVParser(false)) {
            if (rec.get(1).equals(gender)) {
                genderRank++;
                if (genderRank == rank) {
                    name = rec.get(0);
                }
            }
        }
        return name;
    }

}