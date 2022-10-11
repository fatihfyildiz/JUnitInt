package day05_notations;

import org.junit.Test;

public class C01_JUnitfirstTest {
    /*
    JUnit ile:
    1- Bir class'da birden fazla bagimsiz test method'u olusturabiliriz
    2- Bu test method'larni istersek bagimsiz olarak calistirabilir
       istersek class level'dan tum method'lari calistirabiliriz
    3- @Test notasyonu ile main method bagimliligi ortadan kalkar
       @Test notasyonu kullanilan method'lar bagimsiz olarak calistirilabilir
    4- JUnit standart olarak calistirilan Test method'larinin basarili bir sekilde calistigini
       veya Failed oldugunu raporlar
    5- JUnit Assert Class'indan hazir method'lar yaparak test'leri gerceklestirir
       Boylece if-else ile expected ve actual sonuclari arsilastirmamiza gerek kalmaz
    6- JUnit, Failed olan test'lerde actual ve expected datalarin farkini da raporlar

     */


    @Test
    public void test01(){

        System.out.println("Test01");

    }

    @Test
    public void test02(){

        System.out.println("Test02");

    }

    @Test
    public void test03(){

        System.out.println("Test03");

    }

}
