package day10_file_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C05_Senkronizasyon {

    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //  Iki metod icin de asagidaki adimlari test edin.
    // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 4. Remove butonuna basin.
    // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    // 6. Add buttonuna basin
    // 7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElement= driver.findElement(By.id("message"));
        Assert.assertTrue(itsGoneElement.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement= driver.findElement(By.id("message"));
        Assert.assertTrue(itsBackElement.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        /*
        implicitlyWait() tanimlamadigimiz icin butona bastiktan hemen sonra
        it's gone mesajini bulamaz ve hata verir
        dolayisiyla burasi icin Wait yaptiracagiz
         */
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));

        /*
        WebElement itsGoneElement= driver.findElement(By.id("message"));
        Klasik olarak bir web elementini beklemesini soylemek icin
        once o web elementi locate etmemiz gerekir
        ancak bu soruda oldugu gibi
        bekledigimiz element henuz ortada yok iken locate edemeyiz,
        locate edemedigimiz bir elementi beklemesini de driver'a soyleyemeyiz

        Bu nedenle, bu tur problemlerde web element olusturma, bekleme ve locate, ucunu bir arada yapilir
         */
        WebElement itsGoneElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGoneElement.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsBackElement.isDisplayed());

    }

}
