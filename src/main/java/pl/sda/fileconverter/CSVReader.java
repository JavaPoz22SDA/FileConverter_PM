package pl.sda.fileconverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Paweł Matyaszczyk
 */
public class CSVReader implements Reader {
    private Path path;
    @Override
    public List<Map<String, Object>> read(String inputFilePath) {
        List<Map<String,Object>> result = new ArrayList<>();
        List<Map<String,Object>> test = new ArrayList<>();
        try {
            path = Paths.get(inputFilePath);
            List<String> lines = Files.readAllLines(path);
            String headers[] = lines.get(0).split(";");
            for (int i = 1 ; i<lines.size(); i++){
                Map<String,Object> map = new HashMap<>();
                String arr[] = lines.get(i).split(";");
               for (int j = 0; j<headers.length;j++){
                    map.put(headers[j],arr[j]);
                }
                result.add(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
