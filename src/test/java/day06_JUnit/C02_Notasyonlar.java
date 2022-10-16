package day06_JUnit;

import org.junit.*;

public class C02_Notasyonlar {

    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class calisti");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("After Class calisti");
    }

    @Before
    public void setUpMethod(){
        System.out.println("Before calisti");
    }

    @After
    public void afterMethod(){
        System.out.println("After calisti");
    }

    @Test
    public void test1(){
        System.out.println("Test1 calisti");
    }

    @Test
    public void test2(){
        System.out.println("Test2 calisti");
    }

    @Test
    public void test3(){
        System.out.println("Test3 calisti");
    }

}
