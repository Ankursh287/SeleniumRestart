package DataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {
    public static void main(String[] args) {

        XSSFWorkbook excelWBook;
        XSSFSheet excelWSheet;
        XSSFCell cell;

        String path = "C:\\Users\\Radhekrishna-NUC\\IdeaProjects\\SeleniumRestart\\datafiles\\ExcelRead.xlsx.xlsx";
        String sheetName = "Sheet1";

        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
            cell = excelWSheet.getRow(1).getCell(2);
            String cellvalue = cell.getStringCellValue();
            System.out.println(cellvalue);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cellvalue = excelWSheet.getRow(i).getCell(j).getStringCellValue();
                    System.out.println(cellvalue);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
