package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

   public static WebDriver driver;
   public static Properties prop;

    public TestBase(){

            try {
                prop = new Properties();
                FileInputStream fileInputStream = new FileInputStream("C:/Users/WELCOME/IdeaProjects/HybirdLevelFramework/src/main/java/"
                       + "Configuration/Config.properties");
                prop = new Properties();
                prop.load(fileInputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void initializeBrowser(){
        String br=prop.getProperty("browser");
            if (br.equals("firefox")) {
                driver = new FirefoxDriver();
            }
            else if (br.equals("edgeDriver")) {
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
            driver.get(prop.getProperty("url"));
        }




    }

