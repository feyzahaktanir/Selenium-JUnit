package day_07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class C05_YoutubeAssertions {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //1. https://www.youtube.com adresine gidin.
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest(){
        //a. Sayfa başlığının "Youtube" olduğunu test edin.
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, "Youtube");
    }

    @Test
    public void imageTest(){
        //b. Youtube resminin görüntülendiğini (isDisplayed()) test edin.
        WebElement logo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void searchBox(){
        //c. SearchBox'ın erişilebilir olduğunu test edin (isEnabled()).
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        //d. Sayfa başlığının "youtube" olmadığını doğrulayın.

    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
