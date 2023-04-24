package drivers;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	@Override
	public void createDriver() {
//		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driverThreadLocal.set(driver);
	}
}