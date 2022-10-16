package day07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_HandleAlerts {

    /*
    Otomasyon sirasinda karsimiza 2 tur alert cikar.
    1- HTML alert:
        bunlar diger HTML elementleri gibi locate edilebilir ve
        otomasyonda kullanilabilirler
    2- javaScript alerts:
        bunlar ise HTML kodlarla locate edilemezler
        dolayisiyla da click, getText gibi method'lar calismaz

    javaScript alert'ler icin tek yontemimiz vardir...
    switchTo() method'u kullanilarak alert'e gecmek ve
    alert'in izin verdigi islevleri yapmak
     */

    /*
    ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve
       result mesajının “You successfully clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve
       result mesajında isminizin görüntülendiğini doğrulayın.
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void alertTest() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // 1. butona tıklayın,
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);

        // alert'de OK butonuna tıklayın ve
        driver.switchTo().alert().accept();

        // result mesajının “You successfully clicked an alert” oldugunu test edin.
        String expectedSonucYazisi= "You successfully clicked an alert";
        String actualSonucYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
        Thread.sleep(2000);

    }

    @Test
    public void dismissalertTest() throws InterruptedException {
        // 2. butona tıklayın,
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        // uyarıdaki Cancel butonuna tıklayın ve
        driver.switchTo().alert().dismiss();

        // result mesajının “successfuly” icermedigini test edin.
        String unexpectedSonucYazisi= "successfuly";
        String actualSonucYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertFalse(actualSonucYazisi.contains(unexpectedSonucYazisi));
    }

    @Test
    public void sendKeysTest() throws InterruptedException {
        // 3. butona tıklayın,
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);

        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Professor");
        Thread.sleep(2000);

        // OK butonuna  tıklayın ve
        driver.switchTo().alert().accept();

        // result mesajında isminizin görüntülendiğini doğrulayın.
        String actualSonucYazisi= driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedKelime= "Professor";
        Thread.sleep(2000);

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
    }

    @After
    public void teardown(){
        driver.close();
    }
}
