package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {

    /*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximize edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */


    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Before
    public void beforeTest() {
        driver.get(" http://www.google.com");

    }

    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Accept all']")).click(); // accepting all cookies
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("The Lord of the Rings" + Keys.ENTER);

    }

    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Brave Heart" + Keys.ENTER);

    }

    @Test
    public void test03(){
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Harry Potter" + Keys.ENTER);
    }

    @After
    public void afterTest(){
        System.out.println("Test sonucu" + driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
