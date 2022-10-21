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

public class C01_iframe {

    // ● Bir class olusturun: IframeTest
    //  ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //  ● Bir metod olusturun: iframeTest
    // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
    // ○ Text Box’a “Merhaba Dunya!” yazin.
    // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.


    /*
    ulasilmak istenen web element bir iframe icerisindeyse driver o web element'e dogrudan ulasamaz ve
    once o webelement'in icinde oldugu iframe'e geci yapmamiz gerekir...

    Bir iframe'e gecis icin o iframe'nin
            - index
            - name veya id attribute'nin degeri
            - webelement olarak lcoate edilen obje
         seceneklerinden birisi ile switchTo().frame() method'u kullanilir

    Bir iframe'nin icerisine girdikten sonra asil sayfa ile ilgili bir islem yapmak istenilirse
    oncelikle icerisine girilen iframe'den cikis yapilmalidir
    Bunun icin de 2 method vardir:

    - switchTo().defaultContent ==> Ana sayfaya cikar
    - switchTo().parentFrame() ==> ic ice birden fazla iframe varsa, bulundugu iframe'in bir ust iframe'ine cikar
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // Bir metod olusturun: iframeTest
    @Test
    public void iframe() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // “An IFrame containing….” textinin erisilebilir oldugunu test edin
        WebElement anIframeYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeYaziElementi.isEnabled());

        // ve  konsolda  yazdirin.
        System.out.println(anIframeYaziElementi.getText());

        // ○ Text Box’a “Merhaba Dunya!” yazin.
        /*
         ulasilmak istenen web element bir iframe icerisindeyse driver o web element'e dogrudan ulasamaz ve
         once o webelement'in icinde oldugu iframe'e geci yapmamiz gerekir...

         Bir iframe'e gecis icin o iframe'nin
            - index
            - name veya id attribute'nin degeri
            - webelement olarak lcoate edilen obje
         seceneklerinden birisi ile switchTo().frame() method'u kullanilir
        */
        WebElement iframeElementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);

        WebElement yaziAlaniElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(1000); // sometimes codes work faster than the speed of internet which leads to unclean, thus we put sleep
        yaziAlaniElementi.clear();
        yaziAlaniElementi.sendKeys("Merhaba Dunya!");
        Thread.sleep(3000);

        // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin
        /*
            Bir iframe'nin icerisine girdikten sonra asil sayfa ile ilgili bir islem yapmak istenilirse
            oncelikle icerisine girilen iframe'den cikis yapilmalidir
            Bunun icin de 2 method vardir:

        - switchTo().defaultContent ==> Ana sayfaya cikar
        - switchTo().parentFrame() ==> ic ice birden fazla iframe varsa, bulundugu iframe'in bir ust iframe'ine cikar
         */
        driver.switchTo().defaultContent();

        WebElement elementalSeleniumLinki= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumLinki.isEnabled());

        // ve  konsolda yazdirin.
        System.out.println(elementalSeleniumLinki.getText());

    }

    @After
    public void teardown(){
        driver.close();
    }
}
