import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;

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
}
