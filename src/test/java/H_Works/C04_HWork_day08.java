package H_Works;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_HWork_day08 {
       /*
   ...Exercise6...
// 1. Amazon.com'a gidelim.
// 2. DropDown üzerinde Books secelim.(All yazan yerde)
//    kategorilerin hepsini konsola yazdiralim
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
// 4. Sonuc sayisini ekrana yazdiralim.
// 5. Sonucların Les Miserables i icerdigini assert edelim
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
    public void test01() throws InterruptedException {
        // 1. Amazon.com'a gidelim.
        driver.get("https:www.amazon.com");

        WebElement allButton= driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']"));
        allButton.click();
        Thread.sleep(1000);

        // 2. DropDown üzerinde Books secelim.(All yazan yerde) kategorilerin hepsini konsola yazdiralim
        WebElement books= driver.findElement(By.xpath("//a[@data-menu-id='3']"));
        books.click();
        Thread.sleep(1000);

        WebElement allCategory= driver.findElement(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']"));
        System.out.println(allCategory.getText());
        Thread.sleep(1000);

        // 3. Arama kutusuna Les Miserables yazalım ve arama yapalim
        WebElement xPoint= driver.findElement(By.xpath("//div[@class='nav-sprite hmenu-close-icon']"));
        xPoint.click();
        Thread.sleep(1000);

        WebElement searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Les Miserables" + Keys.ENTER);

        // 4. Sonuc sayisini ekrana yazdiralim
        WebElement results= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(results.getText());

        // 5. Sonucların Les Miserables'i icerdigini assert edelim
        Assert.assertTrue(results.getText().contains("Les Miserables"));

    }

    @After
    public void teardown() {
        driver.close();
    }
}
