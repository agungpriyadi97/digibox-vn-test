import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utils.WindowHelper as WindowHelper
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('WEB/Authentication/Login/Positive/Positive - Ensure user can log in using valid account and password'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Cart/Positive/Positive - Ensure user can add product to cart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Checkout/Payment/radio_zalopay'))

// Order Summary
// Verifikasi ringkasan pesanan
String summary = WebUI.getText(findTestObject('WEB/Checkout/OrderSummary/lbl_order_summary'))

WebUI.verifyMatch(summary, '.*Tóm tắt đơn hàng.*', true)

// Masukkan kode promo
not_run: WebUI.setText(findTestObject('WEB/Checkout/OrderSummary/input_promo_code'), 'DISCOUNT10')

not_run: WebUI.click(findTestObject('WEB/Checkout/OrderSummary/btn_apply_promo'))

// Ambil nilai total
String total = WebUI.getText(findTestObject('WEB/Checkout/OrderSummary/txt_total'))

println('Total: ' + total)

// Centang checkbox setujui syarat & ketentuan
WebUI.click(findTestObject('WEB/Checkout/OrderSummary/chk_accept_terms'))

WebUI.delay(10)

WebUI.click(findTestObject('WEB/Checkout/OrderSummary/button_thanh_thon_2'))

WebUI.waitForPageLoad(10)

// ========================= VERIFIKASI ELEMEN GATEWAY =========================
WebUI.waitForElementVisible(findTestObject('WEB/ZaloPayGateway/lbl_order_info'), 10)

WebUI.verifyElementPresent(findTestObject('WEB/ZaloPayGateway/option_open_zalopay_app'), 5)

WebUI.verifyElementPresent(findTestObject('WEB/ZaloPayGateway/timer_countdown'), 5)

// Ambil nilai "Số tiền thanh toán"
String paymentAmount = WebUI.getText(findTestObject('WEB/ZaloPayGateway/lbl_payment_amount_value'))

// Screenshot dokumentasi
WebUI.takeScreenshot('ZaloPay_Gateway.png')

