package H_Works;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C11_AssertClass extends TestBase {

    @Test
    public void test01(){

        // 1) Bir class oluşturun: BestBuyAssertions
        // 2) https://www.bestbuy.com/ Adresine gidin
        driver.get("https://www.bestbuy.com/");

        // farkli test method'lari olusturarak asagidaki testleri yapin
        //    ○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
        wait(2);

        //    ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
        Assert.assertFalse(driver.getTitle().contains("Rest"));
        System.out.println(driver.getTitle());

        //    ○ logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        //    ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement frenchLink=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(frenchLink.isDisplayed());

    }
}
