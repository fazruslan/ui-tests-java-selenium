import com.test.utils.Webdriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestClass {

    WebDriver driver = Webdriver.getChromeDriver();


    @Before
    public void setUp(){
    driver.get("http://automationpractice.com");
    }

    @Test
    public void test1()
    {
        System.out.println("hello, world");
    }
}
