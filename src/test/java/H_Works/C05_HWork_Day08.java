package H_Works;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_HWork_Day08 extends TestBase {

    /*
 Bir class olusturun: IframeTest02
 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
 2) sayfadaki iframe sayısını bulunuz.
 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
 4) ilk iframe'den çıkıp ana sayfaya dönünüz
 5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
 */

    @Test
    public void test01() throws InterruptedException {
        //  1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        WebElement anIframeElement= driver.findElement(By.xpath("//iframe[@id='gdpr-consent-notice']"));
        driver.switchTo().frame(anIframeElement);

        WebElement rejectAllcookies= driver.findElement(By.xpath("//button[@class='mat-focus-indicator solo-button mat-button mat-button-base mat-raised-button']"));
        rejectAllcookies.click();

        // 2) sayfadaki iframe sayısını bulunuz
        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().defaultContent();

        WebElement iframeElement2= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(iframeElement2);

        WebElement youtubeButton= driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        youtubeButton.click();
        Thread.sleep(2000);

        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        // 5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement jmeter= driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(jmeter);

        WebElement jmeterPage= driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
        jmeterPage.click();

        driver.switchTo().defaultContent();

    }


}
