package H_Works;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C09_HWork_day10 extends TestBase {

    @Test
    public void test01(){

        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        // 2."Login Portal" a  kadar asagi inin
        Actions actions= new Actions(driver);

        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).perform();

        wait(2);

        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri); // CDwindow-E8F91CE88C0500BE0828B851CFFBEAC6

        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();

        // 4.Diger window'a gecin
        /*
        Diger sayfaya gectigimiz icin driver onceki sayfada kaldi ve diger sayfaya gecmedi...
        Bu nedenle, diger sayfaya gecmeden once Handle degerlerini almis olmamiz lazim...
         */

        Set<String> windowHandlesSet= driver.getWindowHandles();
        System.out.println(windowHandlesSet);
        // [CDwindow-90AB4195466765F3BEC807C3C3148BE4, CDwindow-5370DB195BBF3F3C18734223F5DB7CBA]

        String ikinciSayfaWindowHandleDegeri= "";

        for (String eachHandleDegeri: windowHandlesSet
        ) {
            if (!eachHandleDegeri.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri= eachHandleDegeri; // yani ikinci sayfanin window handle degerini simdi bulduk...
            }
        }

        driver.switchTo().window(ikinciSayfaWindowHandleDegeri); // iste! simdi ikinci sayfaya gectik...

        // 5."username" ve  "password" kutularina deger yazdirin
        WebElement username= driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("Fatih");

        wait(2);

        WebElement password= driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("12345");
        wait(2);

        // 6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedText= "validation failed";
        String actualText= driver.switchTo().alert().getText();
        wait(2);
        Assert.assertEquals(expectedText,actualText);

        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        wait(1);

        // 9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        wait(3);

        // 10.Ilk sayfaya donuldugunu test edin
        String expectedUrl= "http://webdriveruniversity.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

}
