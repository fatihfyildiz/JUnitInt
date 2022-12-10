package day10_file_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class C04_Senkronizasyon {

    /*
    Testlerimizi calistirirken
    internet, bilgisayarimizin hizi veya calistirdigimiz uygulamadan kaynaklanan gecikmeler olabilir

    Bu durumlarda testimizin failed olmamasi icin kodlarimiz ile calisma ortamimizi
    (yani internet + bilgisayar + calistigimiz uygulama) senkronize etmemiz gerekir

    Senkronizasyon problemlerinde Java'dan 1, Sleenium'dan 2 yardimci vardir:
    1- Thread.sleep() ==> Java'dan gelir ve dinamik degildir
        yazilan sure kadar kodlarin alt satira gecmesini -mutlaka- bekletir
        dezavantaji ise esnek olmamasidir, internet yavassa sizin belirlediginiz sure de yetmeyebilir
        ve bu nedenle gercek test icinde bircok asamada kullanilirsa test'i yavaslatir
        Mesela 30 bin test olan bir banka uygulamasinda Thread.sleep() nedeniyle bir test'in sadece 20 saniye beklemesi
        30 bin test dusunuldugunda 160 saat (6,5 gun) fazladan calisma anlamina gelir
        Bu nedenle de Thread.sleep() pek kullanilmaz

     2- implicitlyWait(max. bekleme suresi) ==> Selenium'dan gelir
        dinamiktir, yani gorev odaklidir
        her adimda max.sure beklemek yerine, gorevin gerceklesecegi sure kadar bekler
        max. sure kadar beklemedigi (sadece gorev gerceklesilinceye kadar bekledigi) icin
        fazladan zaman harcanmasinin onune geceer...

        implicitlyWait tum class'i kapsar ve tum class'taki herbir locate vb. islem icn dinamik bekleme suresi saglar

        ancak, max. bekleme suresi doldugu halde gorev gerceklesmemis olursa ==> hata verir...
        bu nedenle ne cok uzun, ne de cok kisa sure belirlenmesi tercih edilmez
        optimum bir max bekleme suresi belirlenmelidir

     3- Explicitly wait

        Eger test sirasinda yapacagimiz herhangi bir islem icin implicitlyWait ile belirledigimiz sure yetmiyorsa
        tum testlerdeki implicitly wait surelerini artirmak yerine
        sadece o teste ve sadece o isleme ozel bekleme olusturulabilir

        explicitly wait tek bir goreve odaklanmis bekleme suresi olusturur
        explicitly wait, dinamiktir yani sureye degil de goreve odaklidir
        gorev erkene tamamlanirsa explicitly wait de daha fazla beklemeden test'in kalanina gecisi saglar
     */

    @Test
    public void test01() throws InterruptedException {
        // extends yapmadan ve implicitly wait olmadan
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // Youtube'a gidip cookies'i kabul edip
        driver.get("https://www.youtube.com/");
        Thread.sleep(5);
        driver.findElement(By.xpath("//*[text()='Accept all']")).click();

        // ikinci videoya tiklayalim
        driver.findElement(By.xpath("(//img[@draggable='false'])[5]")).click();


    }
}
