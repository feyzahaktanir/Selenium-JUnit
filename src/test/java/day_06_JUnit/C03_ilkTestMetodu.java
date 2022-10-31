package day_06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ilkTestMetodu {

    WebDriver driver;

    @Test
    public void Test01(){
        // amazon.com'a gidelim ve Title'ın "amazon" içerdiğini test edelim
        driver.get("https://www.amazon.com/");

        String actualTitle = driver.getTitle();
        String expectedvalue = "amazon";
        if (actualTitle.contains(expectedvalue)){
            System.out.println("Title Test: PASS");
        }else{
            System.out.println("Title Test: FAILED \nActual Title: " + actualTitle);
        }
        System.out.println("1. Test Metod'u çalıştı");
    }

    @Test
    public void Test02(){
        // google.com'a gidelim ve Title'ın "google" içerdiğini test edelim
        driver.get("https://www.google.com/");

        String actualTitle = driver.getTitle();
        String expectedTitle ="google";

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title Test: PASS");
        }else{
            System.out.println("Title Test: FAILED \nActual Title: "+actualTitle);
        }

        System.out.println("2. Test Metod'u çalıştı");
    }

    @Before
    public void beforemethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Before Metodu' çalıştı");
    }
    @After
    public void aftermethod(){
        driver.close();
        System.out.println("After Metodu' çalıştı");
    }

}
