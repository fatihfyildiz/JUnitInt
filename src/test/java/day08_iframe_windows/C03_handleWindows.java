package day08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_handleWindows {

    /*
    driver.switchTo().newWindow() method'u ile yen ibir sayfa olusturup
    driver'i o sayfaya switch ederiz...

    bu gecis, driver uzerinden yapildigi icin driver da yeni sayfaya gecer ve
    biz yeni sayfada islem yapabiliriz...

    driver'i switchTo() ile yeni bir TAB veya Window'a gecirebiliriz
    yeni Window olusturmak disinda
    herhangi bir Window'a gecmenin TEK BIR YOLU VARDIR:
    bu yol da gecmek istenilen sayfanin window handle degerini kullanmak...

    Yani; bir test sirasinda yeniden donmemiz gereken bir Window'da iseniz
    o sayfanin window handle degerini onceden KAYDETMELISINIZ
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
    public void windowTesti() throws InterruptedException {
        // Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com/");

        // Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        // Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle= "Amazon";
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        /*
            driver.switchTo().newWindow() method'u ile yeni bir sayfa olusturup
            driver'i o sayfaya switch ederiz...

            bu gecis, driver uzerinden yapildigi icin driver da yeni sayfaya gecer ve
            biz yeni sayfada islem yapabiliriz...
         */

        // Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        Thread.sleep(3000);

        // Sayfa title’nin “Wise Quarter” icerdigini test edin
        expectedTitle= "Wise Quarter";
        actualTitle= driver.getTitle();

        Thread.sleep(2000);
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com/");

        // Sayfa title’nin “Walmart” icerdigini test edin
        expectedTitle= "Walmart";
        actualTitle= driver.getTitle();

        Thread.sleep(2000);
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

        /*
        driver'i switchTo() ile yeni bir TAB veya Window'a gecirebiliriz
        yeni Window olusturmak disinda
        herhangi bir Window'a gecmenin TEK BIR YOLU VARDIR:
        bu yol da gecmek istenilen sayfanin window handle degerini kullanmak...

        Yani; bir test sirasinda yeniden donmemiz gereken bir Window'da iseniz
        o sayfanin window handle degerini onceden KAYDETMELISINIZ
         */
        driver.switchTo().window(ilkSayfaHandleDegeri);
        expectedTitle= "Amazon";
        actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @After
    public void teardown(){
        driver.quit();
    }
}
