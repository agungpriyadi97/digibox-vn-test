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

Map user = CustomKeywords.'utils.DummyData.generateRegistrationData'()

'Call Test Case\r\n'
WebUI.callTestCase(findTestCase('Authentication/Login/Positive/Positive - Ensure Create an account link redirects user to registration page'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Input Email'
WebUI.setText(findTestObject('Authentication/Registration/input_email'), user.email)

'Input Account'
WebUI.setText(findTestObject('Authentication/Registration/input_account'), user.account)

'Input Password'
WebUI.setText(findTestObject('Authentication/Registration/input_password'), '')

'Verify Success Registration'
WebUI.verifyTextPresent('Bắt buộc', false)

