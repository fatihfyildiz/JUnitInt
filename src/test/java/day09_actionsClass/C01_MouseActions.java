package day09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MouseActions extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        // Amazon sayfasina gidin
        driver.get("https://www.amazon.com/");

        // sayfanin en altindaki USD-US Dollar'a tiklayin
        // driver.findElement(By.xpath("//*[text()='USD - U.S. Dollar']")).click();
        // Thread.sleep(3000);

        /*
        Bir test gerceklestirilirken mouse veya klavye ile ekstra islemler yapmak gerekebilir
        Ornegin Create a Link'ine tiklayabilmek icin Account & List menusunun uzerinde mouse beklemek gerekir

        Driver -genellikle- (web developer'larin kullandiklari argumanlara gore degisebilir) gorebildigi web elementleri kullanabilir

        Selenium, mouse ve klavye ile yapilabilecek tum fonksiyonlari driver ile gerceklestirebilmek icin
        Actions Class'ini olusturmustur
         */

        // Actions class'inin ozelliklerini kullanabilmek icin obje olusturulmalidir

        Actions actions= new Actions(driver);

        // Create a link'ini tiklayin
        WebElement accountListElement= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountListElement).perform(); // ==> her actions sonrasi perform mutlaka gerekir
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        Thread.sleep(3000);

    }

}
