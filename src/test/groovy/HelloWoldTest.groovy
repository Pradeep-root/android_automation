import io.appium.java_client.MobileElement
import org.openqa.selenium.By

class HelloWoldTest extends BaseSpecs {

    def"Test hello world"(){
        given:""
        def text = helper.element(By.id("txt_display"))
        when:""
        helper.element(By.id("edt_txt_display")).sendKeys("hi")
        helper.element(By.id("btn_print")).click()

        then:""
         assert text.text == "hi"

    }
}