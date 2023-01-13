package day10_file_waits.day13_excel_screenshot_jsExecutor;

import org.junit.Test;
import utilities.TestBase;

import java.io.IOException;

public class C03_Screenshot extends TestBase {

    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");

        tumSayfaScreenshot();

        wait(1);

        driver.get("https://www.youtube.com");

        tumSayfaScreenshot();

    }
}
