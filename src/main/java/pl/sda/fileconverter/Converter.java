package pl.sda.fileconverter;

/**
 * @author Paweł Matyaszczyk
 */
public class Converter {
    public void convert(String sourceFilePath, String outputFilePath){
        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);
        reader.read(sourceFilePath);
        if (reader instanceof JSONReader){

        }
        if (reader instanceof CSVReader){

        }
        System.out.println(reader.read(sourceFilePath));

    }

}
