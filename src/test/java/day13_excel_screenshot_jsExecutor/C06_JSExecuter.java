package day13_excel_screenshot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSExecuter extends TestBase {

    @Test
    public void tst01(){

     // amazon ana sayfaya gidiniz
        driver.get("https://www.amazon.com");

     // sell butonuna JS (Java Scprit) Executive ile basalim
        WebElement sellButton= driver.findElement(By.xpath("//a[text()='Sell']"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",sellButton);

        wait(2);

     // bir alert oluturup Yasasin yazdiralim

        jse.executeScript("alert('Yasasin');");

        wait(2);

        driver.switchTo().alert().accept();

    }
}
