import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class drone {

    private static WebDriver driver;

    @BeforeMethod

    public void setup() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");

    }

    @Test
    public void dronePurchase(){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("drone for kids");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();

        String actualUrl = driver.getCurrentUrl();
        //String expectedUrl = "https://www.amazon.com/s?k=drone+for+kids&crid=2MD4QQKSEUP9W&sprefix=drone+for+%2Caps%2C199&ref=nb_sb_ss_organic-diversity_1_10";
        Assert.assertTrue(actualUrl.contains("drone+for+kids"));

//        Usage: git config –global user.name “[name]”
//        Usage: git config –global user.email “[email address]”
//        Usage: git add [file]
//        Usage: git commit -m “[ Type in the commit message]”



    }

        @AfterMethod
        public void finish(){
         //   driver.close();
        }
    }
