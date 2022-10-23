package day10_file_waits;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.dir")); // C:\Users\ffyil\Desktop\JUnitInt

        // asagida baskalarinin yolu vardir:
        // C:\Users\Notebook\Desktop\TESTER\JUnuitInt
        // C:\Users\toshiba\IdeaProjects\Junit
        // C:\Users\HP\Desktop\JUnitInt

        System.out.println(System.getProperty("user.home")); // C:\Users\ffyil

        // Masaustunde olusturdugumuz txt file'in path'i (yolu):
        // C:\Users\ffyil\Desktop\FileTesti\deneme.txt

        // C:\Users\ffyil\Downloads

        /*
        System.getProperty("user.home") ==> tum bilgisayarlarda kullaniciya kadar olan ana yolu verir
        ve bu kisim her bilgisayar ve her kullanici icin farklidir

        user.home'dan sonrasi tum kullanicilar icin ortak olabilir
        ornegin tum kullanicilarin masaustu(desktop)

        user.home / Desktop

        ve kullanicilarin %90'i icin

        user.home / Downloads

        Dolayisiyla, eger birden fazla bilgisayarda file ile ilgili bir test yapacaksaniz
        dosya yolunu dinamik olarak olusturmaniz gerekir
         */

        // dinamik dosya yolu olusturma
        // masa ustunde FileTesti diye bir klasir ve onun altinda deneme diye bir text dosyasi icin olmuyor
        // o nedenle kisisel olaak ben deneme.txt kismini en sondan sildim

        String dosyaYolu= System.getProperty("user.home") + "\\Desktop\\FileTesti";
        // String dosyaYolu= "C:\\Users\\ffyil\\Desktop\\FileTesti\\deneme.txt";

        System.out.println(Files.exists(Paths.get(dosyaYolu))); // true veya false

    }
}
