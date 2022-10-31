package day_06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C02_AramaTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 1. https://www.saucedemo.com/ adresine gidin
        driver.get("https://www.saucedemo.com/");

        // 2. Username kutusune "standard_user" yazın.
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // 3. Password kutusune "secret_sauce" yazın.
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // 4. Login tuşuna basın
        driver.findElement(By.id("login-button")).click();

        // 5. ilk ürünün ismini kaydedin ve bu ürünün sayfasına gidin
        WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String firstProdName = firstProduct.getText();
        System.out.println(firstProdName);
        firstProduct.click();

        // 6. Add to Card butonuna basın
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // 7. Alışveriş sepetine tıklayın
        driver.findElement(By.id("shopping_cart_container")).click();

        // 8. Seçtiğiniz ürünün başarılı şekilde sepetinize eklendiğini kontrol edin.
        WebElement actualProd = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        if (actualProd.getText().equals(firstProdName)){
            System.out.println("Add Product Test: PASS");
        }else{
            System.out.println("Add Product Test: FAILED");
        }

        // 9. Sayfayı kapatın.
        driver.close();

    }
}
