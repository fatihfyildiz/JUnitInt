package day10_file_waits.day13_excel_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C05_Screenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        // amazon ana sayfay gidelim
        driver.get("https://www.amazon.com");

        // tum sayfanin fotografini cekelim
        tumSayfaScreenshot();
        wait(1);

        // arama kutusuna Nutella yazip fotografini cekelim
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella");

        webElementScreenShot(searchBox);
        searchBox.submit();

        // arama yapip sonucun Nutella icerdigini test edin
        WebElement resultsElement=
                driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedWord= "Nutella";
        String actualWord= resultsElement.getText();

        Assert.assertTrue(actualWord.contains(expectedWord));

        // ve sonuc yazisinin fotografini cekin
        webElementScreenShot(resultsElement);

    }
}
