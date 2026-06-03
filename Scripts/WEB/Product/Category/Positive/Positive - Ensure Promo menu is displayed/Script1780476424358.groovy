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

WebUI.mouseOver(findTestObject('WEB/Home/Header/Menu/Menu Promo/menu_promo'))

WebUI.waitForElementVisible(findTestObject('WEB/Home/Header/Menu/Menu Promo/submenu_Flash_sale'), 10)

WebUI.click(findTestObject('WEB/Home/Header/Menu/Menu Promo/submenu_Flash_sale'))

WebUI.waitForPageLoad(10)

WebUI.mouseOver(findTestObject('WEB/Home/Header/Menu/Menu Promo/menu_promo'))

WebUI.waitForElementVisible(findTestObject('WEB/Home/Header/Menu/Menu Promo/submenu_Pre_order'), 10)

WebUI.click(findTestObject('WEB/Home/Header/Menu/Menu Promo/submenu_Pre_order'))

WebUI.waitForPageLoad(10)

WebUI.mouseOver(findTestObject('WEB/Home/Header/Menu/Menu Promo/menu_promo'))

WebUI.waitForElementVisible(findTestObject('WEB/Home/Header/Menu/Menu Promo/submenu_Pre_test'), 10)

WebUI.click(findTestObject('WEB/Home/Header/Menu/Menu Promo/submenu_Pre_test'))

WebUI.waitForPageLoad(10)

WebUI.mouseOver(findTestObject('WEB/Home/Header/Menu/Menu Promo/menu_promo'))

WebUI.waitForElementVisible(findTestObject('WEB/Home/Header/Menu/Menu Promo/submenu_Khuyen_Mai_Tet_2026'), 10)

WebUI.click(findTestObject('WEB/Home/Header/Menu/Menu Promo/submenu_Khuyen_Mai_Tet_2026'))

WebUI.waitForPageLoad(10)

