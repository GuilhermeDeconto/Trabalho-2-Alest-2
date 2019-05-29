import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderClass {
    private String armySize;
    private String castles;
    private String roads;

    public FileReaderClass (String armySize, String castles, String roads){
        this.armySize = armySize;
        this.castles = castles;
        this.roads = roads;
    }

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            String currLine;
            bufferedReader = new BufferedReader(new FileReader("./res/caso30.txt"));

            currLine = bufferedReader.readLine();
            String[] tokens = currLine.split(" ");
            FileReaderClass record = new FileReaderClass(tokens[0],tokens[1],tokens[2]);

            while ((currLine = bufferedReader.readLine()) != null) {
                System.out.println(currLine);
            }
            printInfo();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void printInfo() {

    }
}