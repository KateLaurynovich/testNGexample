package parent;

import org.testng.annotations.*;

public class BaseClass {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("parent.BaseClass's Before Test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("parent.BaseClass's After Test method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("parent.BaseClass's Before Class method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("parent.BaseClass's After Class method");
    }
}
