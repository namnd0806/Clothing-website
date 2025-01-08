package function

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


public class LoginKeywords {

	@Keyword
	public void LoginAdminSuccess(String username, String password) {
		WebUI.openBrowser(GlobalVariable.url);
		WebUI.maximizeWindow();
		WebUI.sendKeys(findTestObject('Object Repository/Admin/Login/txt_username'), username);
		WebUI.sendKeys(findTestObject('Object Repository/Admin/Login/txt_password'), password);
		WebUI.scrollToElement(findTestObject('Object Repository/Admin/Login/btn_login'), 10);
		WebUI.click(findTestObject('Object Repository/Admin/Login/btn_login'));
		WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/Login/verify_loginsuccess'), 10);
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/Login/verify_visible_thongke'), 10);
	}
}
