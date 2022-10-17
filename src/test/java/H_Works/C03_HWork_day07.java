package H_Works;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_HWork_day07 {

    /*
 1. go to http://zero.webappsecurity.com/ address
 2. click to Sign in button
 3. write "username" into the Login box
 4. write “password” into the Password box
 5. click to the Sign in button
 6. go to the Pay Bills page
 7. click to the “Purchase Foreign Currency” button
 8. select “Currency” from the drop down menu
 9. enter an amount to the “amount” box
 10. check whether that “US Dollars” is not selected
 11. select the “Selected currency” button
 12. click to the “Calculate Costs” button then click to the “purchase” button
 13. check whether that “Foreign currency cash was successfully purchased.” is written

     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() throws InterruptedException {
        // 1. go to http://zero.webappsecurity.com/ address
        driver.get("http://zero.webappsecurity.com/");

        // 2. click to Sign in button
        WebElement sigInButton= driver.findElement(By.xpath("//button[@id='signin_button']"));
        sigInButton.click();
        Thread.sleep(2000);

        // 3. write "username" into the Login box
        WebElement loginBox= driver.findElement(By.xpath("//input[@type='text']"));
        loginBox.sendKeys("username");
        Thread.sleep(2000);

        // 4. write “password” into the Password box
        WebElement passwordBox= driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("password");
        Thread.sleep(2000);

        // 5. click to the Sign in button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(2000);

        driver.navigate().back(); // there is a bug in this website, in order eliminate this we come back

        // 6. go to the Pay Bills page ==> to do this we must click More Services on the page
        WebElement moreServices= driver.findElement(By.xpath("//a[@id='online-banking']"));
        moreServices.click();
        Thread.sleep(1000);

        WebElement payBills= driver.findElement(By.xpath("(//span[@class='headers'])[4]"));
        payBills.click();
        Thread.sleep(1000);

        // 7. click to the “Purchase Foreign Currency” button
        WebElement purchaseForeignCurrency= driver.findElement(By.xpath("//a[@href='#ui-tabs-3']"));
        purchaseForeignCurrency.click();
        Thread.sleep(1000);

        // 8. select “Currency” from the drop down menu
        WebElement euroZone= driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select= new Select(euroZone);
        select.selectByVisibleText("Eurozone (euro)");
        Thread.sleep(2000);

        // 9. enter an amount to the “amount” box
        WebElement amountBox= driver.findElement(By.xpath("//input[@id='pc_amount']"));
        amountBox.sendKeys("100");
        Thread.sleep(1000);

        // 10. check whether that “US Dollars” is not selected
        WebElement usDollar= driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        System.out.println(usDollar.isSelected());
        Thread.sleep(1000);

        // 11. select the “Selected currency” button
        WebElement selectedCurrency= driver.findElement(By.xpath("//input[@id='pc_inDollars_false']"));
        selectedCurrency.click();

        // 12. click to the “Calculate Costs” button then click to the “purchase” button
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();

        // 13. check whether that “Foreign currency cash was successfully purchased.” is written
        WebElement foreignCurrency= driver.findElement(By.xpath("//div[@id='alert_content']"));
        System.out.println(foreignCurrency.isDisplayed());

    }


    @After
    public void teardown(){
        // driver.close();
    }
}
