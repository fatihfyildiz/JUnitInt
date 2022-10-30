package day12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C06_ExceliMapYapma {

    @Test
    public void excelMapTest() throws IOException {

        // Bazen excel'deki tum datayi kod alanimiza almak isteriz
        // (Fatih:) bunu da database'e en yakin olan Map ile yapabiliriz

        String dosyaYolu= "C:\\Users\\ffyil\\Desktop\\ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        // Excel'de birden fazla sutun oldugu ucun list gibi bir yapiya
        // bu gilgileri depolamak mumkun olmaz
        // reel database'e en yakin java yapisi olan Map kullanilabilir

        // Ingilizce ulkeler ismini (1nci/0nci index) Key
        // diger 3 bilgiyi birlestirdigimiz String ise Value olsun

        Map<String, String > ulkelerMapi= new TreeMap<>();

        int sonSatirIndexi= workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i < sonSatirIndexi; i++) {

            String keyUlke= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String valueUlke= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                            + ", "
                            + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                            + ", "
                            + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();

            ulkelerMapi.put(keyUlke,valueUlke);

        }

        System.out.println(ulkelerMapi);

        // Ingilizce ismi Barbados olan ulkenin basket isminin
        // Ingilizce olarak Bridgetown oldugunu test etiniz

        String barbadosValue= ulkelerMapi.get("Barbados");

        System.out.println(barbadosValue); // Bridgetown,Barbados,Barbados

        String [] barbadosValueArrayi= barbadosValue.split(", ");

        String actualBskentIsmi= barbadosValueArrayi[0];
        String expectedBaskentIsmi= "Bridgetown";

        Assert.assertEquals(expectedBaskentIsmi,actualBskentIsmi);
        /*
        Or, alternatively we can direclty write as follows:
        Assert.assertEquals("Bridgetown",barbadosValueArrayi[0]);
         */

    }
}
