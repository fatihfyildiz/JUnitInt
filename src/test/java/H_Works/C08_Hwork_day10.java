package H_Works;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_Hwork_day10 extends TestBase {

    @Test
    public void test01(){
        // “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // “Our Products” butonuna basin
        WebElement ilkIframe= driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(ilkIframe);

        WebElement ourProducts= driver.findElement(By.xpath("//a[@href='products.html']"));
        ourProducts.click();

        wait(2);
        // “Cameras product”i tiklayin
        WebElement ikinciIframe= driver.findElement(By.xpath("(//p[@class='sub-heading'])[1]"));
        ikinciIframe.click();
        wait(2);

        // Popup mesajini yazdirin
        WebElement popUpElement= driver.findElement(By.xpath("//div[@class='modal-content']"));
        wait(2);
        System.out.println(popUpElement.getText());

        // “close” butonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        wait(1);

        // "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        WebElement iframeLink= driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]"));
        iframeLink.click();
        wait(1);

        // "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl= "http://webdriveruniversity.com/index.html";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
