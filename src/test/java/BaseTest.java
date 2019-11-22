import framework.logger.MyLogger;

import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

@Test
public class BaseTest {
    private static MyLogger LOGGER = new MyLogger();

    @BeforeSuite
    private void beforeSuite() {
        System.out.println("Before suite");
    }

    @BeforeTest
    private void beforeTest() {
        System.out.println("Before test");
    }

    @BeforeMethod
    private void beforeMethod() {
        System.out.println("Before method");
    }
    @Parameters({ "first-name" })
    @Test(groups = {"functest", "checkintest"})
    public void test1(String first) {
        System.out.println("test1 " + first);
    }

    @Parameters({ "first-name" })
    @Test(groups = {"checkintest"})
    public void test2(String first) {
        System.out.println("test2 " + first);
    }

    @Test(dependsOnGroups = {"functest"})
    public void test3() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test3");
    }

    @Test(groups = {"functest"}, dataProvider = "create", dataProviderClass = StaticProvider.class)
    public void test4(Integer n) {
        System.out.println("test4 = " + n);
    }

    @Test(alwaysRun = true)
    public void test5() {
        System.out.println("test5 " );
    }
    @AfterSuite
    private void afterSuite() {
        System.out.println("After suite");
    }

    @AfterTest
    private void afterTest() {
        System.out.println("After test");
    }

    @AfterClass
    private void afterClass() {
        System.out.println("After class");
    }

    @AfterMethod
    private void afterMethod() {
        System.out.println("After method");
    }


    public static class StaticProvider {

        @DataProvider(name = "create")
        public static Object[][] createData() {
            return new Object[][]{
                    new Object[]{42}
            };
        }

    }

}
