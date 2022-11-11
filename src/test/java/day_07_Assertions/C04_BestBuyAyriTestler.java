package day_07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyriTestler {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //1. https://www.bestbuy.com/ adresine gidin farklı test metodları oluşturarak aşağıdaki testleri yapın.
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void urlTest(){
        //  a. Sayfa URL'inin https://www.bestbuy.com/ 'a eşit olduğunu test edin.
        String actualURL = driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL); //soutv

        String expectedURL = "https://www.bestbuy.com/";
        System.out.println("expectedURL = " + expectedURL); //soutv

        Assert.assertEquals("Tekrar test edilmeli",expectedURL,actualURL); //assert fail olursa mesaj döndürür.
        //Assert.assertEquals(expectedURL,actualURL);
    }

    @Test
    public void titleTest(){
        //  b. titleTest => sayfa başlığının "Rest" içermediğini(contains) test edin.
        String pageTitle = driver.getTitle();
        System.out.println("pageTitle = " + pageTitle);

        String word = "Rest";

        Assert.assertFalse(pageTitle.contains(word)); //sonuç doğru dönerse test failed olur ve buradan sonrasını çalıştırmaz.
    }

    @Test
    public void logoTest(){
        //  c. logoTest => BestBuy logosunun görüntülendiğini test edin.
        WebElement pageLogo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(pageLogo.isDisplayed());
    }

    @Test
    public void frTest(){
        //  d. FrancaisLinkTest => Fransızca linkin görüntülendiğini test edin.
        WebElement francais = driver.findElement(By.xpath("//button[@lang='fr']"));

        Assert.assertTrue(francais.isDisplayed());
    }



    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
