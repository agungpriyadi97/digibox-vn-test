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

WebUI.callTestCase(findTestCase('WEB/Authentication/Login/Positive/Positive - Ensure user can log in using valid account and password'), 
    [:], FailureHandling.STOP_ON_FAILURE)

// ========================= SEARCH PRODUCT =========================
WebUI.waitForElementClickable(findTestObject('WEB/Home/Header/Icon Menu/Search/icon_search'), 10)
WebUI.click(findTestObject('WEB/Home/Header/Icon Menu/Search/icon_search'))
WebUI.setText(findTestObject('WEB/Home/Header/Icon Menu/Search/input_search'), 'iphone')
WebUI.sendKeys(findTestObject('WEB/Home/Header/Icon Menu/Search/input_search'), Keys.chord(Keys.ENTER))

// ========================= SELECT PRODUCT =========================
WebUI.click(findTestObject('WEB/Product/PDP/iphone 12'))

// ========================= ADD TO CART =========================
WebUI.scrollToElement(findTestObject('WEB/Product/PDP/btn_add to cart'), 5)
WebUI.click(findTestObject('WEB/Product/PDP/btn_add to cart'))

// ========================= VERIFY SUCCESS MESSAGE =========================
WebUI.waitForElementVisible(findTestObject('WEB/Product/PDP/msg_success'), 5)
String actualMsg = WebUI.getText(findTestObject('WEB/Product/PDP/msg_success'))
WebUI.verifyMatch(actualMsg, 'Thành công', false)

// ========================= VERIFY CART BADGE =========================
WebUI.waitForElementPresent(findTestObject('WEB/Home/Header/Icon Menu/Cart/badge_cart_count'), 10)
String cartCount = WebUI.getText(findTestObject('WEB/Home/Header/Icon Menu/Cart/badge_cart_count'))
int actualCount = Integer.parseInt(cartCount.trim())
WebUI.verifyGreaterThanOrEqual(actualCount, 1)

// ========================= OPEN CART PAGE =========================
WebUI.click(findTestObject('WEB/Home/Header/Icon Menu/Cart/icon_cart'))
WebUI.waitForPageLoad(10)
