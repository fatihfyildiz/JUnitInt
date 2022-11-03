package H_Works;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C14_AutomationExercise2 extends TestBase {

    @Test
    public void automationExerciseTest (){

        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        assertEquals(expectedTitle,driver.getTitle());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        wait(1);

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        assertTrue(loginToYourAccount.isDisplayed());

        //6. Enter correct email address and password
        WebElement emailAddressBox= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement passwordBox= driver.findElement(By.xpath("//input[@type='password']"));

        emailAddressBox.sendKeys("aurora@gmail.com");
        passwordBox.sendKeys("aurora");
        wait(1);

        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        wait(1);

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedInAs= driver.findElement(By.xpath("//li//a[text()=' Logged in as ']"));
        assertTrue(loggedInAs.isDisplayed());

        wait(1);

        //9. Click 'Delete Account' button
        WebElement deleteAccount=driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccount.click();
        wait(1);

        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deleted=driver.findElement(By.xpath("//*[text()='Account Deleted!']"));

        assertTrue(deleted.isDisplayed());

    }

}
