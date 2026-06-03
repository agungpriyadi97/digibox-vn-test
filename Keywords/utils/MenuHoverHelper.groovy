package utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import java.util.Arrays

public class MenuHoverHelper {

    @Keyword
    def hoverAndClickSubMenu(TestObject parentMenu, TestObject childItem) {
        WebElement parentElement = WebUiCommonHelper.findWebElement(parentMenu, 10)
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent('mouseover', true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
            "arguments[0].dispatchEvent(evObj);"
        WebUI.executeJavaScript(javaScript, Arrays.asList(parentElement))
        WebUI.waitForElementClickable(childItem, 10)
        WebUI.click(childItem)
    }
}