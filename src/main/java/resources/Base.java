package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	    WebDriver driver;
	     public Properties prop;
		public WebDriver intializeDriver() {
		
		 prop = new Properties();
		
		String propPath = System.getProperty("user.dir");
	
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propPath+"\\src\\main\\java\\resources\\data.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String BrowserName = prop.getProperty("browser");

		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}else if (BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}else if (BrowserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}
		
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		return driver;

		
	
	}

		public void takeScreenShot(String testName,WebDriver driver) throws IOException {
			File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
			FileUtils.copyFile(sourcefile, new File(destinationFilePath));
			
		}
}
