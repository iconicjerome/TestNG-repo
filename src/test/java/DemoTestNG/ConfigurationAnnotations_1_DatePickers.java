package DemoTestNG;

import org.testng.annotations.*;

public class ConfigurationAnnotations_1_DatePickers {
    @Test(groups = "smoke")
    public void test1_BootStrapDatePicker(){

        System.out.println("     (5) test method 1: Bootstrap date picker");
    }

    @Test(groups = {"regression"})
    public void test2_JQueryDatePicker(){

        System.out.println("     (5) test method 2: JQuery date picker");
    }

    @Test(priority = -1)
    public void test3_TryTry(){

        System.out.println("     (7) test method 3: TRY TRY TRY");
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

    @BeforeGroups (groups = {"smoke", "regression"})
    public void beforeGroups(){
        System.out.println("     (6) Execute before group");
    }
}
