package day12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        // ulkeler Excel'inde Turkce ulke isimleri Senegal iceriyor mu, test edin
        // Toplam 190 ulke oldugunu test edin
        // en uzun ulke isminin Macaristan oldugunu test edin

        String dosyaYolu= "C:\\Users\\ffyil\\Desktop\\ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        List<String> ulkelerListesi= new ArrayList<>();
        int sonSatirIndexi= workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i < sonSatirIndexi; i++) {
            ulkelerListesi.add(workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString());
        }

        System.out.println(ulkelerListesi);

        ulkelerListesi.remove(0); // basligi sildik ki ulke listesi dogru olsun

        // ulkeler Excel'inde Turkce ulke isimleri Senegal iceriyor mu, test edin
        Assert.assertTrue(ulkelerListesi.contains("Senegal"));

        // Toplam 191 ulke oldugunu test edin
        Assert.assertEquals(190,ulkelerListesi.size());

        // en uzun ulke isminin Macaristan oldugunu test edin

        String enUuzunIsim= "Macaristan";

        for (String each: ulkelerListesi
             ) {
            if (each.length()>enUuzunIsim.length()){
                enUuzunIsim= each;
            }
        }

        System.out.println("En uzun isimli ulke : " + enUuzunIsim);

        Assert.assertEquals("Mikronezya Federal Devletleri",enUuzunIsim);

    }
}
