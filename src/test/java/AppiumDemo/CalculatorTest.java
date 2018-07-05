package AppiumDemo;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import io.appium.java_client.android.AndroidDriver;
import org.apache.bcel.generic.ANEWARRAY;
import org.apache.tools.ant.taskdefs.Sleep;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.naming.MalformedLinkException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by arvin on 2018/6/30.
 */
public class CalculatorTest {
    public static void main(String[] args) throws MalformedURLException{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability( "automationName","Appium" );
        capabilities.setCapability( "platformName","Android" );
        capabilities.setCapability( "platformVersion","4.1.2");
        //capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appPackage", "com.android.contacts");
        capabilities.setCapability("appActivity", ".activities.DialtactsActivity");
        AndroidDriver androidDriver = new AndroidDriver( new URL( "http://127.0.0.1:4723/wd/hub"),capabilities );
        //androidDriver.findElement( By.className("android.widget.Button")).click();
        //androidDriver.findElementByXPath( "//android.widget.TableLayout/android.widget.TableRow[0]/android.widget.ImageButton[contains(@index 1)]").click();
        androidDriver.findElement( By.className("android.widget.ImageView")).click();
        androidDriver.findElement( By.className("android.widget.ImageButton") ).click();
        //全路径找
        //androidDriver.findElementByXPath( "//android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.Button[5]").click();//androidDriver.findElementByXPath( "//android.support.v4.view.ViewPager/ndroid.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]").click();//androidDriver.findElement( By.xpath( "//android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.Button[1]" )).click();
        //通过文本查找目标控件
        //androidDriver.findElementByXPath("//android.widget.Button[contains(@text,'6')]").click();
        //通过index查找目标控件
        //androidDriver.findElementByXPath( "//android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[contains(@index,1)]").click();
//        Thread.sleep( 2000 );
//        String result = androidDriver.findElement( By.id( "com.android.calculator2:id/formula" ) ).getText();
//        System.out.println(result);
//        androidDriver.quit();
    }
    @Test
    public void testdailPhone() throws UiObjectNotFoundException {
        //找到对象---点击对象
        DesiredCapabilities capabilities = new DesiredCapabilities(  );
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability( "automationName","Appium" );
        capabilities.setCapability( "platformName","Android" );
        capabilities.setCapability( "platformVersion","4.1.2");
        //capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appPackage", "com.android.contacts");
        capabilities.setCapability("appActivity", ".activities.DialtactsActivity");
        try {
            AndroidDriver androidDriver = new AndroidDriver( new URL( "http://127.0.0.1:4723/wd/hub"),capabilities );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        UiSelector l= new UiSelector().className("android.widget.ImageButton").index( 1);
        UiObject object=new UiObject(l);
        object.click();
        object.clickAndWaitForNewWindow( 100 );

    }
}
