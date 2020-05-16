package pl.sda.fileconverter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Paweł Matyaszczyk
 */
public class ExcelWriter implements Writer {
    @Override
    public void write (String outputFilePath, List<Map<String, Object>> records) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Writer");
        int rowNumber =0;
        Row row = sheet.createRow(rowNumber++);
        int cellNumber =0;
        for (Object value:records.get(0).keySet()) {
            Cell cell = row.createCell(cellNumber++);
            cell.setCellValue(value.toString());
        }

        for (Map<String, Object> element: records) {
            row = sheet.createRow(rowNumber++);
            cellNumber =0;
            for (Object value:element.values()) {
                Cell cell = row.createCell(cellNumber++);
                cell.setCellValue(value.toString());
            }
        }

        try{
            FileOutputStream out = new FileOutputStream(new File(outputFilePath));
            workbook.write(out);
            out.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
