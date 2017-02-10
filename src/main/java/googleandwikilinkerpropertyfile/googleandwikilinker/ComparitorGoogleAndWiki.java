package googleandwikilinkerpropertyfile.googleandwikilinker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by alexanderboffin on 12/01/17.
 * With only property file
 */
public class ComparitorGoogleAndWiki {
    WebDriver driver;
    SearchAndFind searchObject;
    CompareTextGoogleWiki comparetexts;

    InputStream inputStream;

    @BeforeTest
    public void open_browser()
    {
        System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
        driver = new FirefoxDriver();
        System.out.println("have started initiation");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterTest
    public void close_browser()
    {
        driver.quit();
    }


    @Test
    public  void testGoogleExercise() throws IOException {
        //Same as trypageobjectmodel. Only the elements in the not-called classes are made private
        //=>this comes in handy=> can then only select the "masterelements" that we want to use

        try {
            Properties prop = new Properties();
            String propFileName = "belgium.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            String webdomain=prop.getProperty("domainname");
            //System.out.println(name);

            //String webdomain="com";
            driver.get("https://www.google."+webdomain);

            //create search on google site =>here place driver we are working on!
            searchObject=new SearchAndFind(driver);
            //can now do search

            String search=prop.getProperty("searchfor");
            searchObject.placeSearchOnGoogle(search);
            //searchObject.placeSearchOnGoogle("GUI Tests");

            comparetexts=new CompareTextGoogleWiki(driver);
            comparetexts.compateGoogleAndWikiTexts();
            System.out.println("worked");


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }

    }

}
