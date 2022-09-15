package TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.Base;
import utilities.ReadXL;

public class TestCase extends Base{
	
	
	ReadXL rxl=new ReadXL();
	@Test(priority = 0)
	public void searchHotel() {
		WebElement loc=driver.findElement(By.id("location"));
		WebElement hotel=driver.findElement(By.id("hotels"));
		WebElement roomty=driver.findElement(By.id("room_type"));
		Select s=new Select(loc);
		s.selectByValue("New York");
		Select s1=new Select(hotel);
		s1.selectByIndex(1);
		Select s2=new Select(roomty);
		s2.selectByIndex(1);
		driver.findElement(By.id("Submit")).click();
	}
	@Test(priority = 1)
	private void selectHotel() {
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.xpath(".//input[@id='continue']")).click();
	}
	
	@Test(priority = 2)
	private void bookAHotel() throws IOException {
		System.out.println(rxl.readExcelSheet());
		driver.findElement(By.id("first_name")).sendKeys(rxl.readExcelSheet());
		driver.findElement(By.name("last_name")).sendKeys("N");
		driver.findElement(By.xpath(".//textarea[@rows='4']")).sendKeys("abcd");
		driver.findElement(By.xpath(".//input[@id='cc_num']")).sendKeys("1234567891234567");
		Select s3=new Select(driver.findElement(By.id("cc_type")));
		s3.selectByIndex(4);
		Select s4=new Select(driver.findElement(By.xpath(".//select[@id='cc_exp_month']")));
		s4.selectByVisibleText("December");
		Select s5=new Select(driver.findElement(By.xpath(".//select[@id='cc_exp_year']")));
		s5.selectByVisibleText("2022");
		driver.findElement(By.id("cc_cvv")).sendKeys("123");
		driver.findElement(By.id("book_now")).click();
	}
	@Test(priority = 3)
	private void printOrderNo() throws InterruptedException {
		Thread.sleep(7000);
		String orderNo=driver.findElement(By.id("order_no")).getAttribute("value");
		System.out.println("Order Number is : "+orderNo);
	}

}
