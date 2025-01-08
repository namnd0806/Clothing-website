import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


CustomKeywords.'function.LoginKeywords.LoginAdminSuccess'(username, password);

'Step 1 : Kiểm tra định dạng table';
CustomKeywords.'function.QLKhachHangKeywords.VerifyFormatTable'();

'Step 2 : Kiểm tra dòng đầu tiên';
CustomKeywords.'function.QLKhachHangKeywords.CheckBtnAction'();
WebUI.closeBrowser();




