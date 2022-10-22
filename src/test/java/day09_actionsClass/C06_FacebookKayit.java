package day09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {

    @Test
    public void test01(){

        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com ");

        // 2- cookies'i kabul edin
        driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();

        // ve yeni hesap olustur butonuna basalim
        driver.findElement(By.linkText("Create New Account")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement nameBox= driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions= new Actions(driver);

        actions.click(nameBox).sendKeys("Levent")
                .sendKeys(Keys.TAB)
                .sendKeys("Celik")
                .sendKeys(Keys.TAB)
                .sendKeys("fatih@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("fatih@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345Eksi")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Nov")
                .sendKeys(Keys.TAB)
                .sendKeys("1981")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT) // to select Male
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        // 4- Kaydol tusuna basalim

        wait(20);

    }
}
