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

WebUI.callTestCase(findTestCase('WEB/Cart/Positive/Positive - Ensure user can add product to cart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('WEB/Checkout/Guest/input_guest_email'), 'agung.priyadi96@gmail.com')

WebUI.mouseOver(findTestObject('WEB/Checkout/Guest/btn_guest_continue'))

WebUI.click(findTestObject('WEB/Checkout/Guest/btn_guest_continue'))

// Pilih radio "Công ty"
WebUI.click(findTestObject('WEB/Checkout/DeliveryAddressCompany/radio_cong_ty'))

// Isi field company
WebUI.clearText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_company_name'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_company_name'), 'Công ty TNHH ABC')

WebUI.clearText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_tax_code'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_tax_code'), '0123456789')

// Isi field umum
WebUI.click(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_first_name'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_first_name'), 'Agung')

WebUI.clearText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_last_name'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_last_name'), 'Priyadi')

WebUI.clearText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_mobile'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_mobile'), '0987654321')

WebUI.clearText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_address'))

WebUI.setText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_address'), 'No. 45, Jalan Dinh Tien Hoang')

WebUI.clearText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_zip'))

WebUI.setText(findTestObject('WEB/Checkout/DeliveryAddressCompany/input_zip'), '70000')

WebUI.click(findTestObject('WEB/Checkout/DeliveryAddressIndividual/btn_save'))

