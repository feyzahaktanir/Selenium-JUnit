package day_07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_RadioButtons {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void test01() throws InterruptedException {
        //a. https://www.facebook.com/ adresine gidin.
        driver.get("https://www.facebook.com/");

        //b. Cookies'i kabul edin.

        //c. "Create an Account" button'a basın.
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //d. "radio buttons" elementlerini locate edin.
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));

        //e. Seçili değilse cinsiyet butonundan size uygun olanı seçin.
        female.click();
        Thread.sleep(1000);
        male.click();
        Thread.sleep(1000);
        custom.click();

    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
