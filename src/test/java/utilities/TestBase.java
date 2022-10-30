package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){

        driver.close();
    }

    public static void wait(int secondToWait){
        try {
            Thread.sleep(secondToWait*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void tumSayfaScreenshot() throws IOException {
        // Tum sayfanin screenshot'ini almak icin 4 adim gerekiyor:
        // 1- TakesScreenshot objesi olusturup deger olarak cast ettigimiz driver'i atayalim

        TakesScreenshot tss= (TakesScreenshot)driver;

        // 2- Resmi kaydedecegimiz bir dosya olusturulur
        // (ama bunu dinamik yapmaliyiz aksi halde sadece en son SS alinani buraya koyar)
        // bu nedenle dinamik resim isimleri olsun ve zaman damgasi (tarih) eklemek icin resim dosya yoluna tarih eklenir
        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");

        File tumSayfaScreenshot= new File("target/Screenshot/tumSayfaScreenShotlar"+ldt.format(dtf)+".jpeg");

        // 3- screenshot objesi kullanarak fotografi cekip gecici dosyaya kaydedelim
        File geciciResim= tss.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, hazirladigimiz file'a kopyalayalim
        FileUtils.copyFile(geciciResim,tumSayfaScreenshot);
    }

    public void webElementScreenShot(WebElement target) throws IOException {

        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");

        File webElementScreenshot= new File("target/Screenshot/webElementScreenShot"+ldt.format(dtf)+".jpeg");

        File geciciResim= target.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,webElementScreenshot);
    }

}
