package pl.sda.fileconverter;

import java.util.List;
import java.util.Map;

public interface Reader {
    //List<Map> read (String inputFilePath);
    List<Map<String,Object>> read (String inputFilePath);
}
