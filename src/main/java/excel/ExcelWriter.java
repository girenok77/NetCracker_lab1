package excel;

import analyzer.Stat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Girenok
 * This class write excel file with time tatistic of methods of sorting
 */
public class ExcelWriter {
    private static Workbook workbook;

    public static void main(String[] args) {
        readWorkbook();
        for(int i = 1; i< 10; i++) {
            System.out.println(i);
            writeStatMapToExcel(i);
        }
        try {
            FileOutputStream fos = new FileOutputStream("excel.xlsx");
            workbook.write(fos);
            fos.close();
            System.out.println("Writed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void readWorkbook() {
        try {
            FileInputStream fileInputStream = new FileInputStream("excel.xlsx");
            workbook = new XSSFWorkbook(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeStatMapToExcel(int arraySize) {
        Stat stat = new Stat(arraySize);
        HashMap<String, HashMap<String, Long>> sheetsMap = stat.getResult();
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {

            HashMap<String, Long> SortsMap = sheetsMap.get(workbook.getSheetName(i));
            Sheet sheet = workbook.getSheetAt(i);
            Iterator rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = (Row) rowIterator.next();
                String rowName = row.getCell(0).toString();
                long SortingTime = SortsMap.get(rowName);
                row.createCell(arraySize).setCellValue(SortingTime/1000);

            }

        }




    }
}
