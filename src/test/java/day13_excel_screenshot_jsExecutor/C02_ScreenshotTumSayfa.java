package day13_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotTumSayfa extends TestBase {

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

        // Tum sayfanin screenshot'ini almak icin 4 adim gerekiyor:
        // 1- TakesScreenshot objesi olusturup deger olarak cast ettigimiz driver'i atayalim

        TakesScreenshot tss= (TakesScreenshot)driver;

        // 2- Resmi kaydedecegimiz bir dosya olusturulur
        File tumSayfaScreenshot= new File("target/Screenshot/tumSayfaScreenShotlar.jpeg");

        // 3- screenshot objesi kullanarak fotografi cekip gecici dosyaya kaydedelim
        File geciciResim= tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, hazirladigimiz file'a kopyalayalim
        FileUtils.copyFile(geciciResim,tumSayfaScreenshot);

    }
}
