import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokerFileReader {
    private final String filePath;

    public PokerFileReader(String filePath){
        this.filePath = filePath;
    }

    public List<String> readLines() throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + e.getMessage(), e);
        }
        return lines;
    }

}
