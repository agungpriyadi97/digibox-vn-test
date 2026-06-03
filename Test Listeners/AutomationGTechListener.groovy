import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase

import com.kms.katalon.core.context.TestCaseContext

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

class AutomationListener {

    @BeforeTestCase
    def beforeTestCase(TestCaseContext testCaseContext) {

        println("START TEST CASE : " + testCaseContext.getTestCaseId())

        WebUI.openBrowser('')

        WebUI.maximizeWindow()

        WebUI.navigateToUrl(GlobalVariable.URL)

        KeywordUtil.logInfo("Browser opened")
    }

    @AfterTestCase
    def afterTestCase(TestCaseContext testCaseContext) {

        try {

            if (DriverFactory.getWebDriver() != null) {

                String status = testCaseContext.getTestCaseStatus()

                String tcName = testCaseContext.getTestCaseId()
                        .replaceAll('[^a-zA-Z0-9]', '_')

                String screenshotPath =
                        RunConfiguration.getReportFolder() +
                        "/" + tcName + "_" + status + ".png"

                WebUI.takeScreenshot(screenshotPath)

                KeywordUtil.logInfo(
                        "Screenshot saved : " + screenshotPath
                )

                WebUI.closeBrowser()

                KeywordUtil.logInfo("Browser closed")
            }

        } catch (Exception e) {

            KeywordUtil.markWarning(
                    "Listener Error : " + e.getMessage()
            )
        }
    }
}