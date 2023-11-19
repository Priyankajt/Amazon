package baseackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pompackage.PomLogin;

public class BaseamazonClass {

	public static Properties prop= new Properties();
	public static WebDriver driver;
	public static PomLogin log;
	
	public BaseamazonClass() {
		try {
			FileInputStream file= new FileInputStream("/Users/priyanka/eclipse-workspace/Amazontest/src/test/java/environmentvariables/Config.properties");
			prop.load(file);
		} 
		catch (FileNotFoundException e) {
						e.printStackTrace();
		} 
		catch (IOException a) {
						a.printStackTrace();
		}
	}
	
	public static void initiation() {
		
		String browsername=prop.getProperty("browser");
		if(browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/priyanka/eclipse-workspace/Amazontest/geckodriver");
			driver= new FirefoxDriver();
		}
		else if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
			
		
	}
	 public static void login() throws InterruptedException
     {
    	
		 log= new PomLogin();
		 Thread.sleep(5000);
		 
		log.Signinbutton();
    	 
    	 log.provideEmail("priyanka.jain1511@gmail.com");
    	 log.continueButtonClick();
    	 log.providePassword("prijt15");
    	 log.KeepMeSignedCheckboxCheck();
	     log.signInButtonClick();
	     
		 
     }
}
