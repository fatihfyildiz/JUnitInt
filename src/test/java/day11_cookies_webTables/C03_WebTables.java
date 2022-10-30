package day11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void amazonTesti(){
        // amazon anasayfaya gidin ve
        driver.get("https://www.amazon.com/");

        // en alttaki web table'dan Home Services secenegini tiklayin

        driver.findElement(By.xpath("//table//tr[3]//td[5]")).click(); // tr==> satir; td==> sutun

        // ilgili sayfaya gittigini test edin
        WebElement baslikYaziElement= driver.findElement(By.xpath("//img[@alt='Home services appointments during COVID-19']"));

        Assert.assertTrue(baslikYaziElement.isDisplayed());

        // tum tablo body'sini yazdirin

        WebElement tableBody= driver.findElement(By.xpath("//table//tbody"));
        System.out.println(tableBody.getText());

        // tum tablo body'sinde care kelimesinin gecmedigini test edin

        Assert.assertFalse(tableBody.getText().contains("care"));

        wait(5);
    }

}
