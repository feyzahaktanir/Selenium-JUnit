package day_06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 1. https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 2. cookies uyarısını kabul ederek kapatın


        // 3. Sayfa başlığının Google ifadesi içerdiğini test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle ="Google";

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Title Test: PASS");
        }else{
            System.out.println("Title Test: FAILED \nActual Title: "+actualTitle);
        }

        // 4. Arama çubuğuna "Nutella" yazıp aratın.
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Nutella"+ Keys.ENTER);

        // 5. Bulunan sonuç sayısını yazdırın
        WebElement result = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Sonuç Sayısı: "+result.getText());


        // 6. sonuc sayısının 10 milyondan fazla olduğunu test edin
        String splitresult = result.getText();
        String resultwords[] = splitresult.split(" ");
        System.out.println(Arrays.toString(resultwords));

        String actualResult = resultwords[1];
        actualResult=  actualResult.replace(".", "");
        int actualNutella = Integer.parseInt(actualResult);
        System.out.println(actualNutella);

        if (actualNutella > 10000000){
            System.out.println("Nutella Search Test: PASS");
        }else{
            System.out.println("Nutella Search Test: FAILED");
        }

        // 7. sayfayı kapatın
        driver.close();
    }
}
