package function

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class QLKhachHangKeywords {

	@Keyword
	public void VerifyFormatTable() {
		// Đảm bảo table hiển thị
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/lbl_khachhang'), 10);
		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/lbl_khachhang'));
		WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/QLKhachHang/tbl_khachhang'), 10);

		String[] expectedHeaders = [
			'STT',
			'Mã Khách Hàng',
			'Ảnh',
			'Họ Và Tên',
			'Giới Tính',
			'Ngày Sinh',
			'Địa Chỉ',
			'Email',
			'Số Điện Thoại',
			'Trạng Thái',
			'Action'
		];
		List<WebElement> actualHeaders = WebUI.findWebElements(findTestObject('Object Repository/Admin/QLKhachHang/list_header_table'), 10);

		for(int i = 0; i < expectedHeaders.length; i++) {
			String actualHeaderText = actualHeaders.get(i).getText().trim().toLowerCase();
			String expectedHeadersText = expectedHeaders[i].toLowerCase();
			WebUI.verifyEqual(expectedHeadersText, actualHeaderText, FailureHandling.STOP_ON_FAILURE);
			WebUI.comment("Header : " + actualHeaderText + " == " + expectedHeadersText + " verify successfully.");
		}
	}

	@Keyword
	public void CheckBtnAction() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/QLKhachHang/btn_updatekh'), 10);
		WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/QLKhachHang/btn_statuskh'), 10);
		Thread.sleep(3000)
	}

	@Keyword
	public void CheckEnablePrevNextPage() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/lbl_khachhang'), 10);
		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/lbl_khachhang'));
		WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/QLKhachHang/tbl_khachhang'), 10);

		// Cuộn đến phần tử
		WebUI.scrollToElement(findTestObject('Object Repository/Admin/QLKhachHang/btn_nextpage'), 5)
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/btn_nextpage'), FailureHandling.CONTINUE_ON_FAILURE);
		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/btn_nextpage'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/btn_prevpage'), FailureHandling.CONTINUE_ON_FAILURE);
		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/btn_prevpage'));
	}

	@Keyword
	public void VerifyVisible10RecordTable() {
		List<WebElement> listkh = WebUI.findWebElements(findTestObject('Object Repository/Admin/QLKhachHang/list_khachhang'), 10);
		if(listkh.size() == 10) {
			WebUI.verifyEqual(listkh.size(), 10);
			WebUI.comment("Success 10 record");
		} else {
			WebUI.comment("Not success 10 record");
		}
		Thread.sleep(3000);
	}

	@Keyword
	public void CheckVisibleInput() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/lbl_khachhang'), 10);
		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/lbl_khachhang'));
		WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/QLKhachHang/tbl_khachhang'), 10);

		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/btn_linkthemmoikh'));
		
		// Check hiển thị trên giao diện
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txt_hovaten'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txt_ngaysinh'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txt_sodienthoai'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txt_email'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txt_diachichitiet'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txt_phuongxa'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txt_quanhuyen'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txt_tinhthanh'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/cbo_gioitinh'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/cbo_trangthai'));
		WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/txta_mota'));
		
		// Check click nhập được kí tự
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txt_hovaten'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txt_ngaysinh'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txt_sodienthoai'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txt_email'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txt_diachichitiet'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txt_phuongxa'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txt_quanhuyen'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txt_tinhthanh'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/cbo_gioitinh'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/cbo_trangthai'));
		WebUI.verifyElementClickable(findTestObject('Object Repository/Admin/QLKhachHang/txta_mota'));
	}
	
	@Keyword
	public void CheckVisibleAndEnableBtnCreateKH() {
		TestObject btn_create = findTestObject('Object Repository/Admin/QLKhachHang/btn_createkh');
		TestObject btn_lammoi = findTestObject('Object Repository/Admin/QLKhachHang/btn_lammoi');
		TestObject btn_quaylai = findTestObject('Object Repository/Admin/QLKhachHang/btn_quaylai');
		
		if(WebUI.verifyElementVisible(btn_create) && WebUI.verifyElementClickable(btn_create)) {
			WebUI.comment("Button thêm mới đã hiển thị và enable");
		}
		
		if(WebUI.verifyElementVisible(btn_lammoi) && WebUI.verifyElementClickable(btn_lammoi)) {
			WebUI.comment("Button làm mới đã hiển thị và enable");
		}
		
		if(WebUI.verifyElementVisible(btn_quaylai) && WebUI.verifyElementClickable(btn_quaylai)) {
			WebUI.comment("Button quay lại đã hiển thị và enable");
		}
		Thread.sleep(3000);
	}
	
	@Keyword
	public void CheckNavigationQLKH() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/QLKhachHang/lbl_khachhang'), 10);
		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/lbl_khachhang'));
		
		TestObject tbl_tablekh = findTestObject('Object Repository/Admin/QLKhachHang/tbl_khachhang');
		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/btn_linkthemmoikh'));
		
		WebUI.scrollToElement(findTestObject('Object Repository/Admin/QLKhachHang/btn_quaylai'), 5);
		WebUI.delay(2);
		WebUI.click(findTestObject('Object Repository/Admin/QLKhachHang/btn_quaylai'));
		if(WebUI.verifyElementPresent(tbl_tablekh, 10)) {
			WebUI.comment("Điều hướng quay lại màn quản lý kh thành công");
		}
		Thread.sleep(3000);
	}
}
