package Base;


import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;


public class Base {
	public static WebDriver driver;
	ReadConfig reco=new ReadConfig();
	@BeforeSuite
	public void timeStamp() {
		Date d=new Date();
		Timestamp ts=new Timestamp(d.getTime());
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(ts));
	}
	
	@BeforeTest
	public void driverIni() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void login() throws IOException {
//		System.out.println(reco.passWord());
		driver.get(reco.Url());
		driver.findElement(By.id("username")).sendKeys(reco.userName());
		driver.findElement(By.id("password")).sendKeys(reco.passWord());
		driver.findElement(By.id("login")).click();
	}
	
	@AfterTest
	public void driverClose() {
		driver.close();
	}
	
	@AfterSuite
	public void timeStamp01() {
		Date d=new Date();
		Timestamp ts=new Timestamp(d.getTime());
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(ts));
	}

}
