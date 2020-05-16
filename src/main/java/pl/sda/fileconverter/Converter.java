package pl.sda.fileconverter;

import java.util.List;
import java.util.Map;

/**
 * @author Paweł Matyaszczyk
 */
public class Converter {
    public void convert(String sourceFilePath, String outputFilePath){
        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);
        List<Map<String,Object>> fileRead =  reader.read(sourceFilePath);

        WriterFactory writerFactory = new WriterFactory();
        Writer writer = writerFactory.produce(outputFilePath);
        writer.write(outputFilePath, fileRead);

        if (reader instanceof JSONReader){

        }
        if (reader instanceof CSVReader){

        }
        if (reader instanceof ExcelReader){
            System.out.println(reader.read(sourceFilePath));
        }
    }
}
