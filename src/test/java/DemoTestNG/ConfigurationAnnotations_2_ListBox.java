package DemoTestNG;

import org.testng.annotations.*;

@Test
public class ConfigurationAnnotations_2_ListBox {


    public void test1_BootStrapDatePicker(){

        System.out.println("     (5) test method 1: Bootstrap date picker");
    }


    public void test2_JQueryDatePicker(){

        System.out.println("     (5) test method 2: JQuery date picker");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("    (4) Execute before each test statements");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("    (4) Execute after each test statement");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("   (3) Execute before the class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("  (3) Execute after the class");
    }
}
