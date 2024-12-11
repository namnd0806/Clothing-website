package utils

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import com.kms.katalon.core.annotation.Keyword
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.Iterator
import internal.GlobalVariable

public class UtilsExcelKeywords {

    // Đọc dữ liệu từ Excel vào một List
    @Keyword
    public static List<List<String>> readExcelData(String fileName, String sheetName) throws IOException {
        List<List<String>> data = new ArrayList<>()
        
        // Lấy đường dẫn thư mục làm việc hiện tại
        String dir = getDir()
        FileInputStream file = new FileInputStream(new File(dir + "/" + fileName))
        
        // Tạo Workbook và Sheet
        Workbook workbook = new XSSFWorkbook(file)
        Sheet sheet = workbook.getSheet(sheetName)
        
        Iterator<Row> rowIterator = sheet.iterator()
        
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next()
            List<String> rowData = new ArrayList<>()
            
            // Lấy dữ liệu từng ô trong mỗi dòng
            Iterator<Cell> cellIterator = row.cellIterator()
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next()
                rowData.add(cell.toString()) // Đọc dữ liệu của ô
            }
            data.add(rowData)
        }
        
        workbook.close()
        file.close()
        
        return data
    }

    // Ghi dữ liệu vào Excel
    @Keyword
    public static void writeExcelData(String fileName, String sheetName, List<List<String>> data) throws IOException {
        // Lấy đường dẫn thư mục làm việc hiện tại
        String dir = getDir()
        
        // Tạo một Workbook mới
        Workbook workbook = new XSSFWorkbook()
        Sheet sheet = workbook.createSheet(sheetName)
        
        // Viết dữ liệu vào sheet
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i)
            List<String> rowData = data.get(i)
            
            for (int j = 0; j < rowData.size(); j++) {
                Cell cell = row.createCell(j)
                cell.setCellValue(rowData.get(j))
            }
        }
        
        // Ghi Workbook vào tệp Excel
        FileOutputStream fileOut = new FileOutputStream(new File(dir + "/" + fileName))
        workbook.write(fileOut)
        fileOut.close()
        workbook.close()
    }

    // Lấy thư mục hiện tại (working directory)
    @Keyword
    public static String getDir() {
        // Trả về đường dẫn thư mục làm việc hiện tại
        return System.getProperty("user.dir")
    }
}
