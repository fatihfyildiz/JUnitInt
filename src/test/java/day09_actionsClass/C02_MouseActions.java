package day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions= new Actions(driver);
        actions.contextClick(ciziliAlan).perform();
        Thread.sleep(4000);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //   test edelim.
        String expectedAlertYazisi= "You selected a context menu";
        String actualAlertYazisi= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        /*
        Once driver'i ailan sayfaya (2nci sayfa) gecirmeliyiz.
        Bunun icin de 2nci sayfanin handle degerini bulmaliyiz
         */

        Set<String> handleDegerlerSeti= driver.getWindowHandles();

        String ikinciSayfaHandleDegeri= "";

        for (String eachHandleDeger: handleDegerlerSeti
             ) {
            if (!eachHandleDeger.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=eachHandleDeger;
            }
        }

        driver.switchTo().window(ikinciSayfaHandleDegeri);

        WebElement h1TagElementi= driver.findElement(By.tagName("h1"));

        String expectedYazi= "Elemental Selenium";
        String actualYazi= h1TagElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
        Thread.sleep(2000);

    }
}
