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

import java.time.Duration;

public class C02_HWork_day05 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void testSaucedemo() throws InterruptedException {
    // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

    // 2. Username kutusuna “standard_user” yazdirin
        WebElement usernameBox= driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameBox.sendKeys("standard_user" + Keys.ENTER);
        /*
        Or, alternatively we can also use the following:
        WebElement usernameBox= driver.findElement(By.id("user-name"));
        usernameBox.sendKeys("standard_user" + Keys.ENTER);
         */
        Thread.sleep(2000);

    // 3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='password']"));
        passwordBox.sendKeys("secret_sauce" + Keys.ENTER);
        Thread.sleep(2000);

    // 4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

    // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstItem= driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        System.out.println("The name of the first product is" + firstItem.getText()); //

    // 6. Add to Cart butonuna basin
        WebElement addcartButton= driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addcartButton.click();
        Thread.sleep(2000);

    // 7. Alisveris sepetine tiklayin
        WebElement shoppingBox= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingBox.click();
        Thread.sleep(2000);

    // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement successfullyAdded= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        if (successfullyAdded.isDisplayed()){
            System.out.println("The product is successfully added to shopping box and test PASSED");
        } else {
            System.out.println("The item is NOT successfully added to shopping box and test FAILED");
        }
    }

    //9. Sayfayi kapatin
    @After
    public void teardown(){
        driver.close();
    }

}
