package resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();		
		String path = System.getProperty("user.dir");		
		FileInputStream fis = new FileInputStream(path+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", path+"/resource/chromedriver.exe");

			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {

			//System.setProperty("webdriver.gecko.driver", path+"/resource/chromedriver.exe");

			driver = new FirefoxDriver();
		}else if(browserName.equals("IE")) {

			//System.setProperty("webdriver.ie.driver", path+"/resource/chromedriver.exe");

			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;

	}

}
