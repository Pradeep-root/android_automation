package utills

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By

class AndroidHelper implements Helper {

    AppiumDriver driver

    AndroidHelper(AppiumDriver driver) {
        this.driver = driver
    }

    @Override
    MobileElement text() {
        return elements(By.className("android.widget.EditText"))
    }

    @Override
    MobileElement text(int xpathIndex) {
        return element(By.xpath("//android.widget.TextView["+xpathIndex+"]"))
    }

    @Override
    MobileElement text(String text) {
        return element(By.xpath("//android.widget.TextView[contains(@text='"+text+"')]"))
    }

    @Override
    MobileElement textExact(String text) {
        return element(By.xpath("//android.widget.TextView[@text='"+text+"']"))
    }
}