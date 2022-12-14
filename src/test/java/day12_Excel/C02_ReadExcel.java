package day12_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void readExcelTesti () throws IOException {

        // 7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu= "C:\\Users\\ffyil\\Desktop\\ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis= new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        /*
        Yukarida once bir workbook olusturup
        fis objesi ile okunan excel'deki bilgileri workbook'a yukledik
        boylece excel'deki datalarin bir kopyasi workbook objesine yuklendi
         */

        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");

        //12. Row objesi olusturun sheet.getRow(index)
        Row row= sheet.getRow(13); // index mantigi ile calisiyor ve 3ncu satir== 2nci index

        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(2); // index mantigi ile calisiyor ve 3ncu hucre== 2nci index

        System.out.println(cell); //

        //14. 14ncu satirdaki ulkenin Bahreyn oldugunu test edin
        String expectedIsim= "Bahreyn";
        String actualIsim= cell.toString();

        Assert.assertEquals(expectedIsim,actualIsim);

    }
}
