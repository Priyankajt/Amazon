package testlayer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseackage.BaseamazonClass;
import pompackage.PomLogin;
import pompackage.PomYourAccount;

public class YourAccount extends BaseamazonClass {

	PomLogin pom;
	PomYourAccount log;
		public YourAccount() 
		{
			super();
		}
		
		@BeforeMethod
		public void initmethod() throws InterruptedException {
			BaseamazonClass.initiation();
			BaseamazonClass.login();
			pom= new PomLogin();
			log = new PomYourAccount();
		}
		@Test(priority=1)
		public void Yaccount() {
			pom.loggedin();
			log.mousehover();
		
		}
		@Test(priority=2)
		public void account() {
			pom.loggedin();
			log.click();
		}
		
		@AfterMethod
		public void close() {
			driver.close();
		}

}
