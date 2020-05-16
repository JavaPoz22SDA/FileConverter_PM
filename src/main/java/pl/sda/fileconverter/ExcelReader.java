package pl.sda.fileconverter;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Paweł Matyaszczyk
 */
public class ExcelReader implements Reader {
    @Override
    public List<Map<String, Object>> read(String inputFilePath) {
        List<Map<String,Object>> result = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(
                    new File(inputFilePath));

            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();
            List<String> keys = new ArrayList<>();
            int start  = 0;
            while (rowIterator.hasNext()){
                if (start == 0) {
                    for (int i=0; i<numberOfColumns; i++){
                        keys.add(sheet.getRow(0).getCell(i).getStringCellValue());
                    }
                    rowIterator.next();
                }else {
                    Map<String,Object> map = new HashMap<>();
                    Row row = rowIterator.next();
                    for (int i=0; i<numberOfColumns; i++){
                        map.put(keys.get(i),row.getCell(i));
                    }

                    result.add(map);
                }
                ++start;
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return result;
    }
}
