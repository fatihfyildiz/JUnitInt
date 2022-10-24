package H_Works;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C10_AssertSolution extends TestBase {

    @Test
    public void test01(){

        // 1. Create a class about Invalid email adress test
        // 2. Go to the http://automationpractice.com/index.php web adress
        driver.get("http://automationpractice.com/index.php");

        // 3. Click to Sign in button
        WebElement loginButton=driver.findElement(By.xpath("//a[@class='login']"));
        loginButton.click();
        wait(2);

        // 4. Write an email adress without @ into the email box
        WebElement mailSection= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        mailSection.sendKeys("fatih2gmail.com"+ Keys.ENTER);
        wait(2);

        // after entering it, test at whether warning "Invalid email address" text is found or not
        WebElement invalidEmail= driver.findElement(By.xpath("//li[text()='Invalid email address.']"));
        System.out.println(invalidEmail.getText());
        Assert.assertTrue(invalidEmail.isDisplayed());
        wait(3);

        /*
        Or alternatively, we can also solve by follows:

        String expectedText= "Invalid email address.";
        String actualText= invalidEmail.getText();
        Assert.assertEquals(expectedText,actualText);
         */
    }
}
