import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import utils.UtilsDatabaseKeywords

//Khởi tạo đối tượng
UtilsDatabaseKeywords db = new UtilsDatabaseKeywords()

//Gọi hàm connectDB để kết nối tới Cơ sở dữ liệu
db.connectDB(GlobalVariable.url_database, GlobalVariable.username_database, GlobalVariable.password_database)

String query = "Select * from NhanVien"

//Thực thi câu query và dùng results đón kết quả trả về
results = db.executeQuery(query)
KeywordUtil.logInfo("results"+ results.toString())