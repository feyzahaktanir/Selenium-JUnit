package day_07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertion {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void test01(){
        //1. https://www.bestbuy.com/ adresine gidin farklı test metodları oluşturarak aşağıdaki testleri yapın.
        driver.get("https://www.bestbuy.com/");

        //  a. Sayfa URL'inin https://www.bestbuy.com/ 'a eşit olduğunu test edin.
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.bestbuy.com/";

        //Assert.assertEquals("Tekrar test edilmeli",expectedURL,actualURL);
        Assert.assertEquals(expectedURL,actualURL);

        //  b. titleTest => sayfa başlığının "Rest" içermediğini(contains) test edin.


        //  c. logoTest => BestBuy logosunun görüntülendiğini test edin.


        //  d. FrancaisLinkTest => Fransızca linkin görüntülendiğini test edin.

    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
