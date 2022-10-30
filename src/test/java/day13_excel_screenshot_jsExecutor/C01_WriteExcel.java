package day13_excel_screenshot_jsExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        // 1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()

        //3) Adimlari takip ederek 1.satira kadar gidelim
        //4) 4.ncu index'teki hucreye (E1 hucresi) yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim

        String dosyaYolu= "C:\\Users\\ffyil\\Desktop\\ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        /*
        bu tur islemleri yaparken ilgili Excel dokumani acik ise bozulur
        o nedenle kapaliyken bu islemleri yapmaliyiz

        ayrica su anda sadece workbook ortaminda yaptik bunu,
        yani Excel dokumanini acip baksak Nufus yazildigini goremeyiz
         */

        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");

        //7) 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");

        //8) 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");

        //9) 15.satirdaki nufus bilgisini 640000 olarak duzeltelim
        workbook.getSheet("Sayfa1").getRow(14).getCell(4).setCellValue("640000");

        //10) Dosyayi kaydedelim
        FileOutputStream fos= new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        //11)Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();
        /*
        fis ve fos akis programlari oldugu icin memory etkiler surekli calisilan sistemlerde...
        o nedenle kapatmaliyiz...
         */


    }
}
