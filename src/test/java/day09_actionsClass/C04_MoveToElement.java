package day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MoveToElement extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // Yeni bir class olusturalim: MouseActions3
        //1- https://www.amazon.com/ adresine gidelim
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
        WebElement accountListElement= driver.findElement(By.xpath("//*[text()='Account & Lists']"));

        Actions actions= new Actions(driver);
        actions.moveToElement(accountListElement).perform();

        Thread.sleep(2000);

        //3- “Create a list” butonuna basalim
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        Thread.sleep(2000);

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim
        WebElement yourList= driver.findElement(By.xpath("//div[@role='heading']"));

        String expectedYazi= "Your Lists";
        String actualYazi= yourList.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        wait(3); // ==> = Thread.sleep(3000);

        // or alternatively;
        // Assert.assertTrue(yourList.isDisplayed());
    }
}
