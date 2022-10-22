package day09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        /*
        Klavyede (Keyboard) cok fazla tus olsa da her bir tus ile ilgili 2 islem vardir...

        1- tek seferlik basmak:
            send.Keys(Keys.ENTER)

        2- uzun sureli basmak ve isimiz bitince tustan elimizi kaldirmak
            - basmak icin keyDown() method'u kullanilir
            - basili tusu birakmak icin keyUp() method'u kullanilir
         */

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");


        // ve arama kutusuna nutella yazdirin
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella");

        // aramayi yapmak icin ENTER tusuna basin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

        wait(2);

        // arama kutusunu temizleyelim
        driver.navigate().back();

        // arama kutusuna actions class'ini kullarak SamsungA71 yazdirin
        WebElement searchBox2= driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions= new Actions(driver);
        wait(2);

        actions.click(searchBox2)
                .keyDown(Keys.SHIFT).sendKeys("s")
                .keyUp(Keys.SHIFT).sendKeys("amsung")
                .keyDown(Keys.SHIFT).sendKeys("a")
                .keyUp(Keys.SHIFT).sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        wait(2);

    }

}
