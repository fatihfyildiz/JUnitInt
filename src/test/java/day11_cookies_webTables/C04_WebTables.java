package day11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01(){

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com/");

        // en alttaki web table'da 10 satir oldugunu test edin
        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//table//tr"));

        Assert.assertTrue(satirlarListesi.size()==10);

        wait(5);

        // 1 satirdaki sutun sayisinin 14 oldugunu test edin
        List<WebElement> ilkSatirSutunlarListesi= driver.findElements(By.xpath("//table//tr[1]/td"));

        Assert.assertTrue(ilkSatirSutunlarListesi.size()==14);

        // 3ncu sutunu yazdirin
        List<WebElement> ucuncuSutunlarListesi= driver.findElements(By.xpath("//table//tr/td[3]"));

        for (WebElement each: ucuncuSutunlarListesi
             ) {
            System.out.println(each.getText());
        }

        // 5nci satiri yazdirin
        System.out.println("======================"); // anlasilsin, bir usttekinden ayrimi gorulsun diye...

        List<WebElement> besinciSatirListesi= driver.findElements(By.xpath("//table//tr[5]"));

        for (WebElement each: besinciSatirListesi
             ) {
            System.out.println(each.getText());
        }
        
        // 3ncu satir, 5nci sutundaki basligin Home Services oldugunu test edin
        WebElement ucuncuSatirBesinciSutun= driver.findElement(By.xpath("//table//tr[3]/td[5]"));

        String expectedIcerik= "Home Services";
        String actualData= ucuncuSatirBesinciSutun.getText();

        Assert.assertTrue(actualData.contains(expectedIcerik));

        // satir ve sutun degerlerini verildiginde, tablodaki o bolumu yazdiracak bir method olusturun
        System.out.println("======================");

        dataYazdir(3,5);

    }

    public void dataYazdir(int satir, int sutun) {

        WebElement arananData= driver.findElement(By.xpath("//table//tr["+satir+"]/td["+sutun+"]"));

        System.out.println(satir + ".ncisatir" + sutun + ".ncisutun datasi: " + arananData.getText());

    }
}
