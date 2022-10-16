package H_Works;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HWork_day05 {

    // As a home-work and a personal study
    // 1-Create a new class

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void hWorkTest(){
        //2- go to the web page https://www.google.com/
        driver.get("https://www.google.com/");

        //3- close the cookies warning by accepting
        WebElement cookiesAccept= driver.findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]"));
        cookiesAccept.click();

        //4- test whether the actual title contains “Google” or not
        String expectedTitle= "Google";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Web page title contains Google");
        } else {
            System.out.println("Web page title does NOT contain Google");
        }

        /*
        Alternatively; we can also directly test as follows:
        if (driver.getTitle().contains("Google")){
            System.out.println("Web page title contains Google");
        } else {
            System.out.println("Web page title does NOT contain Google");
        }
         */

        //5- write “Nutella” into the search box
        WebElement searchBox= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        //6- print the numbers of the found results
        WebElement resultsNumber= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(resultsNumber.getText()); // About 161 000 000 results (0,48 seconds)

        //7- test as the numbers of results are whether more than 10 million or not
        String resultsStr= resultsNumber.getText();
        resultsStr= resultsStr.substring(resultsStr.indexOf(" ")+1,resultsStr.indexOf("results")-1);
        // with this, we ignore and get rid of the letters and only the numbers are left such as 161 000 000

        resultsStr=resultsStr.replaceAll("\\ ","");
        // with this, we ignore the spaces and only the numbers are left such as 161000000
        System.out.println(resultsStr); // 161000000

        if (Integer.parseInt(resultsStr)>10000000){
            System.out.println("Number of the results are MORE than 10 000 000");
        } else {
            System.out.println("Number of the results are LESS than 10 000 000");
        }

    }

    //8-Close the page
    @After
    public void teardown(){
        driver.close();
    }

}
