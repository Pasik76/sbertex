import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pavel on 16.09.2015.
 */
public class ReadFileTest {
    public String[][] returnarr(String filepath) {

        BufferedReader br = null;
        String line = "";
        String SplitBy = ";";
        String[][] DataString = new String[4][4];

        try {

            br = new BufferedReader(new FileReader(filepath));
            int j = 0;


            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] linearr = line.split(SplitBy);
                int i = 0;
                while (i < 4) {
                    DataString[j][i] = linearr[i];
                    i++;
                }
                j++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return DataString;
    }
    public int resultat(int x, String filepath) {

        String[][] DataResult = new String[4][4];
        DataResult = returnarr(filepath);
        int z = 0;
        if (DataResult[x][2].equals("-")) {
            z = Integer.valueOf(DataResult[x][0]) - Integer.valueOf(DataResult[x][1]);
        }
        else if (DataResult[x][2].equals("+")) {
            z = Integer.valueOf(DataResult[x][0]) + Integer.valueOf(DataResult[x][1]);
        }
        else if (DataResult[x][2].equals("/")) {
            z = Integer.valueOf(DataResult[x][0]) / Integer.valueOf(DataResult[x][1]);
        }
        else if (DataResult[x][2].equals("*")) {
            z = Integer.valueOf(DataResult[x][0]) * Integer.valueOf(DataResult[x][1]);
        }
       return z;
    }

    @Test
    public void OneStringTest() throws Exception {

        String[][] TempData = new String[4][4];

        TempData = returnarr("src/main/resources/datfile.txt");

        int z = Integer.valueOf(TempData[0][3]);

            assertEquals("Calculations should be the result", z, resultat(0, "src/main/resources/datfile.txt"));
    }

    @Test
    public void TwoStringTest() throws Exception {

        String[][] TempData = new String[4][4];

        TempData = returnarr("src/main/resources/datfile.txt");

        int z = Integer.valueOf(TempData[1][3]);

        assertEquals("Calculations should be the result", z, resultat(1, "src/main/resources/datfile.txt"));
    }

    @Test
    public void ThreeStringTest() throws Exception {

        String[][] TempData = new String[4][4];

        TempData = returnarr("src/main/resources/datfile.txt");

        int z = Integer.valueOf(TempData[2][3]);

        assertEquals("Calculations should be the result", z, resultat(2, "src/main/resources/datfile.txt"));
    }
    @Test
    public void FourStringTest() throws Exception {

        String[][] TempData = new String[4][4];

        TempData = returnarr("src/main/resources/datfile.txt");

        int z = Integer.valueOf(TempData[3][3]);

        assertEquals("Calculations should be the result", z, resultat(3, "src/main/resources/datfile.txt"));
    }
}

