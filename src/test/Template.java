package test;

import org.junit.After;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;


public class Template {


    protected static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        String s = System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

    }

    @Test
    public void VerifTest() {
        //accor hotel
        System.out.println("connexion au site d'Accor Hotel...");
        driver.get("https://www.accorhotels.com/france/index.fr.shtml");
        //Début des instructions
        System.out.println("...");
        driver.findElement(By.xpath("//input[@id='search-destination']")).sendKeys("Lyon, France");
        driver.findElement(By.className("autocompleteItem__label")).click();
        //body/div[@id='body-page']/main[@id='main']/section[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]
        //body/div[@id='body-page']/main[@id='main']/section[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[1]

        //driver.findElement(By.xpath("//input[@id='search-dateIn-boo']")).sendKeys("07");
        driver.findElement(By.xpath("//input[@id='search-dateIn-boo']")).click();
        driver.findElement(By.linkText("7")).click();
        driver.findElement(By.xpath("//input[@id='search-dateout-boo']")).click();
        driver.findElement(By.linkText("9")).click();


        //driver.findElement(By.xpath("//body/div[@id='body-page']/main[@id='main']/section[1]/div[1]/form[1]/div[1]/div[3]/button[1]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Rechercher')]")).click();

        WebElement webhebergements = driver.findElement(By.cssSelector("p.toolbar__label"));
        String hebergements = webhebergements.getAttribute("innerText");

        assertNull(hebergements);
        //assertNotNull(hebergements);
    }



        /*isElementPresent("/html[1]/body[1]/div[3]/div[1]/div[1]/main[1]/div[1]/div[2]/div[2]/div[1]/div[1]/section[1]/div[2]/section[1]/div[1]/div[1]/p[1]"")


    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
*/



    @AfterClass
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @After
    public static void tearDown(){
        driver.quit();
    }
}
