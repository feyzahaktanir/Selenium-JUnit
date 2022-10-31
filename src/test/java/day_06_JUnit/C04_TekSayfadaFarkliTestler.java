package day_06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTestler {

    static WebDriver driver;
    static WebElement searchBox;
    static WebElement result;

    @Test
    public void Test01(){
        // amazon sayfasında nutella için arama yapıp sonuç yazısının nutella içerdiğini test edelim.
        searchBox.sendKeys("nutella"+ Keys.ENTER);
        result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualvalue = result.getText();
        String expectedvalue = "nutella";

        if (actualvalue.contains(expectedvalue)){
            System.out.println("Nutella Test: PASS");
        }else{
            System.out.println("Nutella Test: FAILED \nActual Value: " + actualvalue);
        }

        System.out.println("1. Test Metod'u çalıştı");
    }

    @Test
    public void Test02(){
        // amazon sayfasında java için arama yapıp sonuç yazısının java içerdiğini test edelim.
        searchBox.sendKeys("java");
        result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualvalue = result.getText();
        String expectedvalue = "java";

        if (actualvalue.contains(expectedvalue)){
            System.out.println("Java Test: PASS");
        }else{
            System.out.println("Java Test: FAILED \nActual Value: " + actualvalue);
        }

        System.out.println("2. Test Metod'u çalıştı");
    }

    @Test
    public void Test03(){
        // amazon sayfasında ali için arama yapıp sonuç yazısının ali içerdiğini test edelim.
        searchBox.sendKeys("ali");
        result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualvalue = result.getText();
        String expectedvalue = "ali";

        if (actualvalue.contains(expectedvalue)){
            System.out.println("Ali Test: PASS");
        }else{
            System.out.println("Ali Test: FAILED \nActual Value: " + actualvalue);
        }

        System.out.println("3. Test Metod'u çalıştı");
    }

    @BeforeClass
    public static void beforeClassmethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.com/");
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        System.out.println("Before Class Metodu' çalıştı");
    }

    @AfterClass
    public static void afterClassmethod(){
        driver.close();
        System.out.println("After Class Metodu' çalıştı");
    }
}
