package H_Works;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_HWork_day09 extends TestBase {

    @Test
    public void testActionClass(){

        // ACTIONS CLASS ODEV-1:
        //Yeni Class olusturun ActionsClassHomeWork
        //1- “http://webdriveruniversity.com/Actions” sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First” kutusunun ustune gelin
        WebElement hoverOverMeFirst= driver.findElement(By.xpath("//div[@class='dropdown hover']"));

        Actions actions= new Actions(driver);
        actions.moveToElement(hoverOverMeFirst).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//div[@class='dropdown-content'])[1]")).click();

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText()); // Well done you clicked on the link!
        wait(2);

        //5- Popup’i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold” kutusuna basili tutun
        WebElement clickAndHoldBox= driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldBox).perform();
        wait(2);

        //7-“Click and hold” kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldBox.getText()); // Well done! keep holding that click now.....

        //8- “Double click me” butonunu cift tiklayin
        WebElement doubleClickMeBox= driver.findElement(By.xpath("//div[@id='double-click']"));
        actions.doubleClick(doubleClickMeBox).perform();

        wait(4);

    }

}
