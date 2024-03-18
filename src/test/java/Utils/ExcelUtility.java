package Utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelWSheet;

    public static void setExcelFile(String path, String sheetName) {
        try {
            FileInputStream excelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[][] getTestData(String tableName) {
        String[][] testData = null;

        try {
            XSSFCell[] boundaryCells = findCells(tableName);
            XSSFCell startCell = boundaryCells[0];

            XSSFCell endCell = boundaryCells[1];

            int startRow = startCell.getRowIndex() + 1;
            int endRow = endCell.getRowIndex() - 1;
            int startCol = startCell.getColumnIndex() + 1;
            int endCol = endCell.getColumnIndex() - 1;

            testData = new String[endRow - startRow + 1][endCol - startCol + 1];

            for (int i = startRow; i < endRow + 1; i++) {
                for (int j = startCol; j < endCol + 1; j++) {
                    testData[i - startRow][j - startCol] = excelWSheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }

    public static XSSFCell[] findCells(String tableName) {
        String pos = "begin";
        XSSFCell[] cells = new XSSFCell[2];

        for (Row row: excelWSheet){
            for (Cell cell : row){
                if (tableName.equals(cell.getStringCellValue())){
                    cells[0] = (XSSFCell) cell;
                    pos = "end";
                }else {
                    cells[1] = (XSSFCell) cell;
                }
            }
        }
        return cells;
    }
}
