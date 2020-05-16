package pl.sda.fileconverter;

/**
 * @author Paweł Matyaszczyk
 */
public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String sourceFilePath = "test.csv";
        String outputFilePath = "test.xlsx";
        converter.convert(sourceFilePath,outputFilePath);
    }
}
