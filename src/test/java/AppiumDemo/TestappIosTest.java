package AppiumDemo;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by arvin on 2018/7/5.
 */
public class TestappIosTest {
    /**
     * @param args
     */
    WebDriver wd;
    @Before
    public void setup() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability("devicesName","iPhone 6");
        capabilities.setCapability("platformVersion","9.2");
        capabilities.setCapability("platName","iOS");
        capabilities.setCapability("browseName","safari");
        wd = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }
    @After
    public void tearDown() throws Exception {
        wd.quit();
    }
    @Test
    public void Test() throws Exception{
        wd.get("http://baidu.com");
        Thread.sleep(1000);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
