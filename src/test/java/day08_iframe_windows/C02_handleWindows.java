package day08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_handleWindows {

    /*
    birden fazla TAB/window'a gecerken eger switchTo ile gecmiyorsak;
    acilan her sayfanin Window Handle degerini alip kaydederiz ki sonra onu kullanabilelim...
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
    public void windowtesti(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();

        // elemental selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        /*
        Bir link'e tikladiginizda driver'i acilan yeni Window'a dogrudan switch yapamayiz...

        Oncelikle o sayfanin window handle degerini bulmus olmali ve o degeri kaydetmeliyiz
        sonra da o degeri kullanarak yeni sayfaya gecmeliyiz...
         */

        Set<String> windowHandlesSet= driver.getWindowHandles();
        // bununla tum window'larin handle degerleri SET olarak elde edilmis olur

        /*
        System.out.println("ilk sayfa window handle degeri : " + ilkSayfaWindowHandleDegeri);
        System.out.println("iki sayfanin window handle degerleri : " + windowHandlesSet);

        sout sonuclari soyle cikti...

        ilk sayfa window handle degeri : CDwindow-BCD37421A094AB9F41FBDE7972ABD4F8
        iki sayfanin window handle degerleri : [CDwindow-BCD37421A094AB9F41FBDE7972ABD4F8, CDwindow-0C2AB4761115CB534253766218EF9CA3]
         */

        String ikinciSayfaWindowHandleDegeri= "";

        for (String eachHandleDegeri: windowHandlesSet
             ) {
            if (!eachHandleDegeri.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri= eachHandleDegeri; // yani ikinci sayfanin window handle degerini simdi bulduk...
            }
        }

        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        // acilan sayfada en bastaki yazinin gorunur oldugunu test edin
        WebElement baslikElementi= driver.findElement(By.tagName("h1"));
        Assert.assertTrue(baslikElementi.isDisplayed());

        // ve bu acilan sayfadaki yazinin Elemental Selenium oldugunu test edin
        String expectedYazi= "Elemental Selenium";
        String actualYazi= baslikElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }

    /*
    driver.get() ile https://the-internet.herokuapp.com/iframe sayfasina gittik
    ama acilan yeni sayfanin url'i ise: http://elementalselenium.com/

    bir test sirasinda birden fazla window (sayfa) aciliyorsa
    driver'a bu window'lar arasinda gecis yaptirabiliriz...
     */

    @After
    public void teardown(){
        driver.quit();
    }
}
