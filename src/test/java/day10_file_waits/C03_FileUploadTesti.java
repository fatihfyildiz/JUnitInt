package day10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void uploadTest(){

        // 1.Tests packagenin altina bir class oluşturun : C05_UploadFile
        // 2.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // 3.chooseFile butonuna basalim
        WebElement dosyaSecButonu= driver.findElement(By.id("file-upload"));

        // 4.Yuklemek istediginiz dosyayi secelim.

        /*
        Dosya Sec butonuna bastiktan sonra bilgisayardan Selenium ile dosya secmemiz mumkun degil
        onun yerine
        dosyaSecButonu.sendKeys("DosyaYolu")
         */

        String yuklenecekDosyaYolu= "C:\\Users\\ffyil\\Downloads\\logo.png";

        dosyaSecButonu.sendKeys(yuklenecekDosyaYolu);

        wait(5);

        // 5.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        wait(5);

        // 6.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement fileYaziUploadElement= driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileYaziUploadElement.isDisplayed());

    }
}
