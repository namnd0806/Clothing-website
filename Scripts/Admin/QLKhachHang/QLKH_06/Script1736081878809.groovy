import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'function.LoginKeywords.LoginAdminSuccess'(username, password);

'Step1 : Kiểm tra hiển thị button Prev và button Next'
CustomKeywords.'function.QLKhachHangKeywords.CheckEnablePrevNextPage'();

'Step2 : Kiểm tra hiển thị 10 bản ghi trên 1 trang'
CustomKeywords.'function.QLKhachHangKeywords.VerifyVisible10RecordTable'();
WebUI.closeBrowser();