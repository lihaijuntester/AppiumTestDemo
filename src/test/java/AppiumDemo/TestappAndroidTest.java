package AppiumDemo;

import static org.junit.Assert.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import android.widget.TextView;
import android.util.Log;
/**
 * Created by arvin on 2018/7/5.
 */
public class TestappAndroidTest {
    private boolean isNeedInstall=false;
    private AppiumDriver driver=null;
    private AndroidDriver driver1 = null;
    @Before
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Nexus_4");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "4.4");
        capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
        if(isNeedInstall){ //isNeedInstall为真时appium需要解析本地的apk包来得到包名和mainActivity
            String appDir=System.getProperty("user.dir");
            File apppath=new File(appDir, "apps");
            File app = new File(apppath, "qianbao_4.3.0.apk");
            capabilities.setCapability("app", app.getAbsolutePath());
        }else { //isNeedInstall为假时通过appium不需要解析apk直接通过appPackage和appActivity服务关键字的设置在目标手机上查找启动app
            capabilities.setCapability("appPackage", "com.qianwang.qianbao");
            capabilities.setCapability("appActivity", ".im.ui.login.BlankActivity");
        }
        //支持中文输入
        capabilities.setCapability("unicodeKeyboard", "true");
        //重置输入法为系统默认
        capabilities.setCapability("resetKeyboard", "true");
        //安装时是否对apk进行重签名，为true不进行重签名
        capabilities.setCapability("noSign","true");
//      capabilities.setCapability("noReset","true");
        try {
            driver = new  AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findqianbao() throws UiObjectNotFoundException{
        //找对象－－点击对象
        //UiObject qianbaoicon = new UiObject (new UiSelector().text("钱宝"));
        UiSelector qb = new UiSelector().text("钱宝");     //搜索条件
        UiObject qianbaoicon = new UiObject(qb);          //根据搜索条件找到对象
        qianbaoicon.clickAndWaitForNewWindow();           //操作对象
        //找到“我的”点击
        UiObject myicon = new UiObject ( new UiSelector().resourceId("com.qianwang.qianbao:id/main_tab_item_text"));
        myicon.clickAndWaitForNewWindow();
        //输入用户命及密码登录
        UiObject User = new UiObject ( new UiSelector().text("手机号/邮箱/用户名"));
        User.click();
        //sleep(200);
        User.setText("13917357664");
        UiObject Password = new UiObject ( new UiSelector().resourceId("com.qianwang.qianbao:id/password_ed"));
        Password.click();
        //sleep(200);
        Password.setText("f123456");
        UiObject loginbutton = new UiObject (new UiSelector().text("登录"));
        loginbutton.click();
        //sleep(5000);
        UiObject frdRecomment = new UiObject ( new UiSelector().resourceId("com.qianwang.qianbao:id/myviewpager"));
        frdRecomment.dragTo(frdRecomment, 0);
        //sleep(500);
        UiObject jumper = new UiObject ( new UiSelector().text("跳过"));
        jumper.click();
        //sleep(200);
    }
    @Test
    public void testqianbao() throws Exception{
        WebElement el = driver.findElement(By.className("android.widget.TextView"));
        el.click();
        WebElement e2 = driver.findElementById("com.qianwang.qianbao:id/main_tab_item_text");
        e2.click();
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
    public static void main(String[] args) throws Exception {
        new TestappAndroidTest().setUp();
        System.out.println("setup sucessful");
        new TestappAndroidTest().testqianbao();
        System.out.println("test sucessful");
        new TestappAndroidTest().tearDown();
        System.out.println("tearDown sucessful");
        fail("Not yet implemented");
    }

}
