package pl.sda.fileconverter;

/**
 * @author Paweł Matyaszczyk
 */
public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String sourceFilePath = "test.xlsx";
        String outputFilePath = "testOut.xlsx";
        converter.convert(sourceFilePath,outputFilePath);
    }
}
