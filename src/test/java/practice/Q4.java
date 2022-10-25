package practice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.*; // burada * isaretinin yeridne assertEquals vardi * yaparak hepsini Import ettik...

public class Q4 extends TestBase {

 @Test
 public void test01(){

  // 1. Launch browser
  //2. Navigate to url 'http://automationexercise.com'
  driver.navigate().to("http://automationexercise.com");

  //3. Verify that home page is visible successfully
  String expectedTitle= "Automation Exercise";
  assertEquals(expectedTitle,driver.getTitle()); // Assert kismini sildik ve sonra da Import ettik...

  String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();

  //4. Click on 'Contact Us' button
  driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

  //5. Verify 'GET IN TOUCH' is visible
  Actions actions= new Actions(driver);
  actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

  WebElement getInTouch= driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
  assertTrue(getInTouch.isDisplayed());

  //6. Enter name, email, subject and message
  Faker faker= new Faker();
  String emailAddress= faker.internet().emailAddress();

  WebElement name= driver.findElement(By.xpath("(//input[@type='text'])[1]"));
  name.sendKeys(faker.name().firstName());
  wait(1);

  WebElement email= driver.findElement(By.xpath("(//input[@type='email'])[1]"));
  email.sendKeys(emailAddress);
  wait(1);

  WebElement subject= driver.findElement(By.xpath("(//input[@type='text'])[2]"));
  subject.sendKeys("Test");
  wait(1);
  WebElement message= driver.findElement(By.id("message"));
  message.sendKeys("Hello, test is passed");

  //7. Upload file
  WebElement chooseFileButton= driver.findElement(By.xpath("//input[@type='file']"));
  String uploadFilePath= "C:\\Users\\ffyil\\Downloads\\logo.png";
  chooseFileButton.sendKeys(uploadFilePath);
  wait(1);

  //8. Click 'Submit' button
  driver.findElement(By.xpath("//input[@type='submit']")).click();

  //9. Click OK button
  driver.switchTo().alert().accept();

  //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
  assertTrue(driver.findElement(By.xpath("(//*[text()='Success! Your details have been submitted successfully.'])[1]")).isDisplayed());

  //11. Click 'Home' button and verify that landed to home page successfully
  driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
  wait(1);

  String expectedTitle2= "Automation Exercise";
  assertEquals(expectedTitle2,driver.getTitle());

 }


}
