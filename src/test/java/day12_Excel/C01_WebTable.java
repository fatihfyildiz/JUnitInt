package day12_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTable extends TestBase {

    @Test
    public void webTableTesti (){

        // Bir Class olusturun D19_WebtablesHomework
        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklariyazdirin
        List<WebElement> baslikElementleriListesi=
                driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));

        for (WebElement eachElement: baslikElementleriListesi
             ) {
            System.out.print(eachElement.getText() + "--"); // First Name--Last Name--Age--Email--Salary--Department--Action--
        }

        // 3. 3.sutunun basligini yazdirin
        System.out.println("");
        System.out.println(baslikElementleriListesi.get(2).getText()); // Age ==> index 0 ile basliyor, 3ncu sutun index'i 2

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> dataElementleriListesi= driver.findElements(By.xpath("//div[@class='rt-td']"));

        for (WebElement eachElement: dataElementleriListesi
             ) {
            System.out.println(eachElement.getText());
        }

        // 5a. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println(dataElementleriListesi.size()); // 70

        // 5b. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        /*
        is.Blank() ==> space/bosluklardan olsuup olusmadigini sorgular
        is.Empty() ==> ise bos olup olmadigini sorgular
         */
        int sayac=0;

        for (WebElement eachElement: dataElementleriListesi
             ) {
            if (!eachElement.getText().isBlank()) {
                sayac++;
            }
        }

        System.out.println("Tabloda bos olmayan hucre sayisi : " + sayac); // 18

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriListesi= driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        System.out.println("Tablodaki satir sayisi : " + satirElementleriListesi.size());

        // 7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriListesi.size());

        // 8. Tablodaki 3.kolonu/sutunu yazdirin
        /*
        Tablo' table tag'lari ile olusturulmadigindan data bilgisine dinamik olarak ulasamiyoruz
         */

        for (int i = 2; i < dataElementleriListesi.size(); i+=7) { // 3.sutun'un ndex degeri 2 oldugu icin 2 ile baslattik
            System.out.println(dataElementleriListesi.get(i).getText());
        }

        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        for (int i = 0; i < dataElementleriListesi.size(); i++) {
            if (dataElementleriListesi.get(i).getText().equalsIgnoreCase("Kierra")){
                System.out.println("Kierra'nin maasi : " + dataElementleriListesi.get(i+4).getText());
                // First Name'den 4 sutun sonra Salary geliyor o nedenle i+4 yazdik
            }
        }

        // 10. Class icerisinde bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    }
}
