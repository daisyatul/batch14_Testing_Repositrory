import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class SampleSelenium {

    public static void main( String[] args )
    {
        System.setProperty("webdriver.chrome.driver", "D://Programming//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.amazon.com");
    }
}
