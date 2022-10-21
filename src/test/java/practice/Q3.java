package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    // https://www.teknosa.com/ adresine gidiniz
    // arama cubuguna oppo yazip enter deyiniz
    // sonuc sayisini yazdiriniz
    // cikan ilk urune tiklayiniz
    // sepete ekleyiniz
    // sepetime git e tiklayiniz
    // consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    // Alisverisi tamamlayiniz
    // son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    // driver'i kapatiniz

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        // driver.close();
    }

    @Before
    public void beforeTest() {
        //  https://www.teknosa.com/ adresine gidiniz
        driver.get("https://www.teknosa.com/");
    }

    @Test
    public void test() throws InterruptedException {
        // arama cubuguna oppo yazip enter deyiniz
        WebElement aramaKutusu= driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        aramaKutusu.sendKeys("oppo");
        Thread.sleep(2000);

        // sonuc sayisini yazdiriniz

        // cikan ilk urune tiklayiniz
        // sepete ekleyiniz
        // sepetime git e tiklayiniz
        // consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
        // Alisverisi tamamlayiniz
        // son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    }
}
