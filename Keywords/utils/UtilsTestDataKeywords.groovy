package utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import java.util.HashMap

public class UtilsTestDataKeywords {

    /**
     * Lấy một dòng dữ liệu từ Test Data theo TC_ID và trả về HashMap<String, String>
     * 
     * @param testDataName tên của Test Data
     * @param tcId giá trị của TC_ID cần tìm
     * @return HashMap<String, String> với cột là key và giá trị là value
     */
    @Keyword
    public static HashMap<String, String> getDataByTCID(String testDataName, String tcId) {
        // Lấy Test Data từ Katalon Test Data
        TestData testData = TestDataFactory.findTestData(testDataName)
        
        // Duyệt qua tất cả các dòng trong Test Data để tìm TC_ID
        int rowCount = testData.getRowNumbers()
        HashMap<String, String> resultData = new HashMap<>()
        
        for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
            // Lấy giá trị của TC_ID tại dòng hiện tại
            String currentTCID = testData.getValue("TC_ID", rowIndex) // Giả sử "TC_ID" là tên cột chứa ID
            
            if (currentTCID.equals(tcId)) {
                // Nếu tìm thấy TC_ID, lấy tất cả các giá trị cột và thêm vào HashMap
                int columnCount = testData.getColumnNumbers()
                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    String columnName = testData.getColumnNames().get(colIndex - 1)
                    String cellValue = testData.getValue(colIndex, rowIndex)
                    resultData.put(columnName, cellValue)
                }
                break // Dừng lại khi đã tìm thấy dòng cần thiết
            }
        }
        
        return resultData
    }
	
	/** Kiểm tra sự tồn tại của một TC_ID **/
	@Keyword
	public static boolean isTCIDExist(String testDataName, String tcId) {
		TestData testData = TestDataFactory.findTestData(testDataName)
		int rowCount = testData.getRowNumbers()
		
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			String currentTCID = testData.getValue("TC_ID", rowIndex)
			if (currentTCID.equals(tcId)) {
				return true // TC_ID tồn tại
			}
		}
		return false // TC_ID không tồn tại
	}
	
	/** Lấy tất cả các giá trị của một cột **/
	@Keyword
	public static List<String> getColumnValues(String testDataName, String columnName) {
		TestData testData = TestDataFactory.findTestData(testDataName)
		List<String> columnValues = new ArrayList<>()
		int rowCount = testData.getRowNumbers()
		
		for (int rowIndex = 1; rowIndex <= rowCount; rowIndex++) {
			String value = testData.getValue(columnName, rowIndex)
			columnValues.add(value)
		}
		
		return columnValues
	}
	
}
