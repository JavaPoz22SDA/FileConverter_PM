package pl.sda.fileconverter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Paweł Matyaszczyk
 */
public class JSONReader implements Reader{

    private Path path;

    @Override
    public void read(String inputFilePath) {
        try{
            path = Paths.get(inputFilePath);
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(bytes);
            String content = new String(bytes);
            System.out.println(content);
            JSONArray jsonArray = new JSONArray(content);

            for (int i=0; i<jsonArray.length(); i++){
                Object rawObject = jsonArray.get(i);
                JSONObject record = new JSONObject(rawObject.toString());
                System.out.println(jsonArray.get(i));
                System.out.println(record.getString("city"));
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
