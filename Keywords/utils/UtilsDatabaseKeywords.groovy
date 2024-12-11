package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kms.katalon.core.annotation.Keyword;

public class UtilsDatabaseKeywords {
    private static Connection conn = null;

    @Keyword
    public static void connectDB(String url, String username, String password) throws SQLException {
        try {       
            conn = DriverManager.getConnection(url, username, password);
            println "Connect successful!"
        } catch (SQLException e) {
            System.err.println("Connect failed " + e.getMessage());
            throw e;
        }
    }

	/** Hàm sử dụng trường hợp query trả về 1 danh sách các bản ghi
	 * @Return : List<HashMap<String, String>>
	 * **/
	@Keyword
	public static List<HashMap<String, String>> executeQuery(String query) throws SQLException {
		List<HashMap<String, String>> resultList = new ArrayList<>();
		if (conn != null && !conn.isClosed()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			int columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				HashMap<String, String> row = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					row.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				}
				resultList.add(row);
			}
			rs.close();
			stmt.close();
		} else {
			System.err.println("Connect failed!");
		}
		return resultList;
	}

	/** Hàm sử dụng trường hợp query trả về duy nhất 1 bản ghi 
	 * @Return : HashMap<String, String>
	 * **/
	@Keyword
	public static HashMap<String, String> executeSingleRecordQuery(String query) throws SQLException {
		HashMap<String, String> resultMap = null;
		if (conn != null && !conn.isClosed()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			int columnCount = rs.getMetaData().getColumnCount();
			if (rs.next()) {
				resultMap = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					resultMap.put(rs.getMetaData().getColumnName(i), rs.getString(i));
				}
			}
			rs.close();
			stmt.close();
		} else {
			System.err.println("Connect failed!");
		}
		return resultMap;
	}

    @Keyword
    public static void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Close connect successful!");
        } else {
            System.err.println("Close connect failed or closed!");
        }
    }
}
