package ders11_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Scanner;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01(){

        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//*[text()='Accept all']")).click(); // cookies -- Accept all

        Set<Cookie> cookiesSet= driver.manage().getCookies();

        for (Cookie eachCookie: cookiesSet
             ) {
            System.out.println(eachCookie);
        }

        System.out.println("======================");

        Cookie cookie= new Cookie("best cookies is", "my cookie");
        driver.manage().addCookie(cookie);

        cookiesSet= driver.manage().getCookies();

        Set<Cookie> cookiesSeti= driver.manage().getCookies();

        for (Cookie eachCookie: cookiesSeti
        ) {
            System.out.println(eachCookie);
        }

        wait(10);

    }

}
