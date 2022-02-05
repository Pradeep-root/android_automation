package utills

import io.appium.java_client.MobileElement
import org.openqa.selenium.By

trait Helper  {

    MobileElement element(By locator){
        driver.findElement(locator)
    }

    List<MobileElement> elements(By locator){
        driver.findElements(locator)
    }

    List<MobileElement> tags(String tagName){
        elements(forTags(tagName))
    }

    By forTags(String  tagName){
        By.className(tagName)
    }

    void back(){
        driver.navigate().back()
    }

    MobileElement name(String txt){
            element(By.name(txt))
    }

    abstract MobileElement text()
    abstract MobileElement text(int xpathIndex)
    abstract MobileElement text(String text)
    abstract MobileElement textExact(String text)

}