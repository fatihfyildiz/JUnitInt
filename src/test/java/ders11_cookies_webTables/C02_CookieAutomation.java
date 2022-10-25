package ders11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_CookieAutomation extends TestBase {

    @Test
    public void cookiesTesti(){

        // Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet= driver.manage().getCookies();

        int siraNo=1;

        for (Cookie eachCookie: cookiesSet
        ) {
            System.out.println(siraNo + "-" + eachCookie);
            siraNo++;
        }

        wait(3);

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(siraNo>5);

        // Or alternatively,
        // Assert.assertTrue(cookiesSet.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        Cookie i18Cookies= driver.manage().getCookieNamed("i18n-prefs");
        String i18Value= i18Cookies.getValue();
        Assert.assertEquals("USD",i18Value);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie cookie= new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        System.out.println("==================");

        cookiesSet= driver.manage().getCookies();

        siraNo=1;

        for (Cookie eachCookie: cookiesSet
        ) {
            System.out.println(siraNo + "-" + eachCookie);
            siraNo++;
        }

        wait(3);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        Cookie enSevdigimCookie= driver.manage().getCookieNamed("en sevdigim cookie");
        String enSevdigimCookieValue= enSevdigimCookie.getValue();
        Assert.assertEquals("cikolatali", enSevdigimCookieValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        int silmedenOnceCookieSayisi= cookiesSet.size();
        driver.manage().deleteCookieNamed("skin");

        cookiesSet= driver.manage().getCookies();
        int sildiktenSonraCookieSayisi= cookiesSet.size();

        siraNo=1;

        for (Cookie eachCookie: cookiesSet
        ) {
            System.out.println(siraNo + "-" + eachCookie);
            siraNo++;
        }

        wait(3);

        Assert.assertEquals(silmedenOnceCookieSayisi,sildiktenSonraCookieSayisi+1);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        cookiesSet= driver.manage().getCookies();

        Assert.assertTrue(cookiesSet.size()==0);

    }


}
