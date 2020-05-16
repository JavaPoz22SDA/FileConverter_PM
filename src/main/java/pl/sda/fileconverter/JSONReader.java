package pl.sda.fileconverter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Paweł Matyaszczyk
 */
public class JSONReader implements Reader{

    private Path path;

    @Override
    public List<Map<String,Object>> read(String inputFilePath) {
        List<Map<String,Object>> result = new ArrayList<>();
        try{
            path = Paths.get(inputFilePath);
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes);
            JSONArray jsonArray = new JSONArray(content);

            for (int i=0; i<jsonArray.length(); i++){
                Object rawObject = jsonArray.get(i);
                JSONObject record = new JSONObject(rawObject.toString());
                System.out.println(jsonArray.get(i));
                System.out.println(record.get());
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
