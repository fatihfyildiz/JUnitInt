package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Q5_Exercise extends TestBase {

    //     ...Exercise3...
    //    // http://the-internet.herokuapp.com/add_remove_elements/
    //    // click on the "Add Element" button 100 times
    //    // write a function that takes a number, and clicks the "Delete" button
    //    // given number of times, and then validates that given number of
    //    // buttons was deleted

    @Test
    public void test01(){
        // http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // click on the "Add Element" button 100 times
        WebElement addElement= driver.findElement(By.xpath("//button[@onclick]"));

        wait(1);

        for (int i = 1; i <=100; i++) {
            addElement.click();
        }

        // write a function that takes a number, and clicks the "Delete" button
        WebElement deleteElement= driver.findElement(By.xpath("(//button[@class='added-manually'])[100]"));

        for (int i = 1; i <=100 ; i++) {
            deleteElement.click();
        }
    }
}
