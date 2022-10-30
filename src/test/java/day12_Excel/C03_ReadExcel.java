package day12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        /*
        Ulkeler excel belgesine gidiniz ve
        32.satirdaki (yani index'i 31) ulke isminin Canada oldugunu test ediniz
         */

        String dosyaYolu= "C:\\Users\\ffyil\\Desktop\\ulkeler.xlsx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        String actualIsim= workbook.getSheet("Sayfa1").getRow(31).getCell(0).toString();

        String expectedIsim= "Canada";

        Assert.assertEquals(expectedIsim, actualIsim);

    }
}
