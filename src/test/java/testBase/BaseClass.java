package testBase;

import java.time.Duration;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.*;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setup(String os , String br) throws IOException 
	
	{
		FileReader file = new FileReader(".//src/test/resources//config.properties");
		p = new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("No mathcing browser");
					return;			
		}
		

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	public String randomAlphabet() {
		
		String generateAlphabet = RandomStringUtils.randomAlphabetic(4);
		return generateAlphabet;
	}
	
	public String randomNumber() {
		String generateNumber = RandomStringUtils.randomNumeric(9);
		return generateNumber;
	}
	
	public String randomAlphaNum() {
		String generateAlphabet = RandomStringUtils.randomAlphabetic(3).toLowerCase();
		String generateOneAlphabet = RandomStringUtils.randomAlphabetic(1).toUpperCase();
		String generateNummber = RandomStringUtils.randomNumeric(4);
		return (generateOneAlphabet+generateAlphabet+"@"+generateNummber);
	}
	
	public String randomOneAlphabet() {
		
		String generateAlphabet = RandomStringUtils.randomAlphabetic(1);
		return generateAlphabet;
	}
	
}
