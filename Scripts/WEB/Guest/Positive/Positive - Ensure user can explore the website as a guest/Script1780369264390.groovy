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

WebUI.waitForElementVisible(findTestObject('WEB/Home/Header/Icon Menu/Logo Home/logo_home'), 10)

WebUI.mouseOver(findTestObject('WEB/Home/Header/Icon Menu/Logo Home/logo_home'))

WebUI.click(findTestObject('WEB/Home/Header/Icon Menu/Logo Home/logo_home'))

WebUI.verifyElementPresent(findTestObject('WEB/Home/Header/Icon Menu/Logo Home/logo_home'), 5)

WebUI.waitForElementVisible(findTestObject('WEB/Home/Header/Icon Menu/Account/icon-account'), 10)

WebUI.mouseOver(findTestObject('WEB/Home/Header/Icon Menu/Account/icon-account'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('WEB/Home/Header/Icon Menu/Account/icon-account'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Mobile Phones menu is displayed'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Ipad menu is displayed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Watch menu is displayed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Mac menu is displayed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Accessories menu is displayed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Audio menu is displayed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure TV menu is displayed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Promo menu is displayed'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Installment Plans menu is displayed'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('WEB/Product/Category/Positive/Positive - Ensure Learn more menu is displayed'), [:], FailureHandling.STOP_ON_FAILURE)

