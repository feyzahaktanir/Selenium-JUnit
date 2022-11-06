package day_07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_CheckBox {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void test01() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        //   https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. CheckBox1 ve CheckBox2 elementlerini locate edin.
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //c. CheckBox1 seçili değilse onay kutusuna tıklayın.
        Thread.sleep(3000);
        if (checkbox1.isSelected()==false){
            checkbox1.click();
            System.out.println("CheckBox 1 got checked");
        }else{
            System.out.println("CheckBox 1 already checked");
        }

        //d. CheckBox2 seçili değilse onay kutusuna tıklayın.
        Thread.sleep(3000);
        if (!checkbox2.isSelected()){                       //ünlem(!) de false niteliği taşır.
            checkbox2.click();
            System.out.println("CheckBox 2 got checked");
        }else{
            System.out.println("CheckBox 2 already checked");
        }

    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
