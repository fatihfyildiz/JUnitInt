package H_Works;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C13_AutomationExercise1 extends TestBase {

    @Test
    public void automationExerciseTest01 () throws IOException {

        // 1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePageLogo= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));

        assertTrue(homePageLogo.isDisplayed());

        wait(1);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        wait(1);

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignup= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));

        assertTrue(newUserSignup.isDisplayed());
        wait(1);

        //6. Enter name and email address
        WebElement nameBox= driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("Fatih+-=");
        wait(1);

        WebElement emailBox= driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailBox.sendKeys("fatih@.gmailcom");
        wait(1);

        WebElement submitButton= driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        submitButton.click();
        wait(1);

        assertTrue(newUserSignup.isDisplayed()); // ==> error occurs due to wrong format of email and name
        // and web element newUserSignup still exist which means there is an error

        nameBox.clear();
        emailBox.clear();

        System.out.println("=============================");

        nameBox.sendKeys("Fatih*/-");
        emailBox.sendKeys("faTiH19@gmailcom");
        wait(1);
        submitButton.click();

        //7. Click 'Signup' button
        tumSayfaScreenshot(); // to prove that there is a bug here we take a whole page screenshot

        driver.navigate().back(); // if we want to make a negative testcase, we must stay in this page and try again

        nameBox.clear();
        emailBox.clear();

        Faker faker= new Faker();
        String email= faker.internet().emailAddress();
        String name= faker.name().fullName();

        Actions actions=new Actions(driver);

        actions.click(nameBox).sendKeys(name).perform();
        actions.click(emailBox).sendKeys(email).perform();

        submitButton.click();
        wait(1);

        // web element newUserSignup doesn't exist anymore which means there is NOT an error

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformation= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        assertTrue(enterAccountInformation.isDisplayed());
        wait(1);

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title =driver.findElement(By.xpath("(//input[@type='radio'])[1]"));

        actions.click(title).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("98765").sendKeys(Keys.TAB).
                sendKeys("28").sendKeys(Keys.TAB).sendKeys("May").sendKeys(Keys.TAB).sendKeys("1981").sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN). sendKeys(Keys.ARROW_DOWN). sendKeys(Keys.ARROW_DOWN). sendKeys(Keys.ARROW_DOWN).perform();

        wait(1);

        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        WebElement newsLatter= driver.findElement(By.xpath("//input[@name='newsletter']"));
        WebElement reciveSpecial= driver.findElement(By.xpath("//input[@name='optin']"));

        actions.moveToElement(newsLatter).click(newsLatter).moveToElement(reciveSpecial).click(reciveSpecial).
                sendKeys(Keys.TAB).perform();

        wait(1);

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        actions.sendKeys("Nevzat").sendKeys(Keys.TAB).sendKeys("Celik").sendKeys(Keys.TAB).sendKeys("ISVEC").
                sendKeys(Keys.TAB).sendKeys("huddinge/Stockholm").sendKeys(Keys.TAB).sendKeys("-").sendKeys(Keys.TAB)
                .sendKeys("Canada").sendKeys(Keys.TAB).sendKeys("-").sendKeys(Keys.TAB).sendKeys("Stockholm")
                .sendKeys(Keys.TAB).sendKeys("12321").sendKeys(Keys.TAB).sendKeys("+4612345678").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        wait(2);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCrt=driver.findElement(By.xpath("//*[text()='Account Created!']"));
        assertTrue(accountCrt.isDisplayed());

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        wait(1);

        //16. Verify that 'Logged in as username' is visible
        WebElement logged=driver.findElement(By.xpath("(//li//a)[10]"));
        assertTrue(logged.isDisplayed());

        //17. Click 'Delete Account' button
        WebElement deleteAccount=driver.findElement(By.xpath("//a[@href='/delete_account']"));
        deleteAccount.click();
        wait(1);

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleted=driver.findElement(By.xpath("//*[text()='Account Deleted!']"));

        assertTrue(deleted.isDisplayed());

    }

}
