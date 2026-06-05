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

        println("START TEST CASE : ${testCaseContext.getTestCaseId()}")

        WebUI.openBrowser('')

        WebUI.setViewPortSize(1920, 1080)

        WebUI.navigateToUrl(GlobalVariable.URL)

        // Debug viewport
        def width = WebUI.executeJavaScript(
                "return window.innerWidth", null)

        def height = WebUI.executeJavaScript(
                "return window.innerHeight", null)

        KeywordUtil.logInfo(
                "Viewport Size : ${width} x ${height}"
        )

        WebUI.takeScreenshot(
                RunConfiguration.getReportFolder() +
                "/START_PAGE.png"
        )
    }

    @AfterTestCase
    def afterTestCase(TestCaseContext testCaseContext) {

        try {

            if (DriverFactory.getWebDriver() != null) {

                String tcName =
                        testCaseContext.getTestCaseId()
                        .replaceAll("[^a-zA-Z0-9]", "_")

                String screenshotPath =
                        RunConfiguration.getReportFolder() +
                        "/${tcName}_${testCaseContext.getTestCaseStatus()}.png"

                WebUI.takeScreenshot(screenshotPath)

                KeywordUtil.logInfo(
                        "Screenshot saved : ${screenshotPath}"
                )

                WebUI.closeBrowser()
            }

        } catch (Exception e) {

            KeywordUtil.markWarning(
                    "Listener Error : ${e.getMessage()}"
            )
        }
    }
}