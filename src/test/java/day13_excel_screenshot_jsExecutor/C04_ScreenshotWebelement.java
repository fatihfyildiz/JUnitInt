package day13_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_ScreenshotWebelement extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");

        // Nutella icin armaa yapalim
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edelim
        WebElement resultsElement=
                driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedWord= "Nutella";
        String actualWord= resultsElement.getText();

        Assert.assertTrue(actualWord.contains(expectedWord));

        // sadece sonuc yazisi elementinin (resultsElement) screen shot'unu cekelim
        // 1.adim screenshot yapacagimiz web elementi locate edelim
        // 2, 3 ve 4ncu adimlar yine ayni

        File webElementScreenshot= new File("target/Screenshot/webElementScreenShotlar.jpeg");

        File geciciResim= resultsElement.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,webElementScreenshot);

    }

}
