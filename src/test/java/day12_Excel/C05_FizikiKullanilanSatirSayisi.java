package day12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_FizikiKullanilanSatirSayisi {

    @Test
    public void test01() throws IOException {

        // ulkeler excel'indeki Sayfa2'de fiziki olarak kullanilan satir sayisinin 15 oldugunu test ediniz

        String dosyaYolu= "C:\\Users\\ffyil\\Desktop\\ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        int toplamSatirSayisi= workbook.getSheet("Sayfa2").getLastRowNum();

        System.out.println("Toplam satir sayisi :" + (toplamSatirSayisi+1)); // 24
        // index kullanildigi icin 24 olan satir sayisini 23 veriyor (0nci index'ten basliyor) bu nedenle 1 ekledik

        int fizikiKullanilanSatirSayisi= workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("Fiziki kullanilan satir sayisi : " + fizikiKullanilanSatirSayisi);

    }

}
