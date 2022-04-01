package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;



public class main {


	public static void main(String[] args) {
		try {
			setup("firefox");
		} catch(Exception e) {
			e.printStackTrace();
		}

	
	}
	
	public static void setup(String browser) throws Exception {
        WebDriver driver;

		if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 
		}
		else{
		System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		driver.get("https://utasks-buggy.web.app/login");
		
        Thread.sleep(1000);         
        SignUp(driver);
        Thread.sleep(5000);
		Login(driver);
        Thread.sleep(1000);         
		AddProject(driver);
		AddTask_Inbox(driver);
		AddTask_TopBar(driver);
		Logout(driver);
        Thread.sleep(1000);         
        SignUp(driver);
  	    WebElement Errormsg = driver.findElement(By.cssSelector(".fade"));
  	    String ExpectedText = "Failed to create an account";
  	    Assert.assertEquals(ExpectedText, Errormsg.getText());
  	    System.out.println("IRCTC text is a expected – Assert passed");
        driver.close();

	}
	
	
	public static void SignUp(WebDriver driver) {

		 WebElement signup_link = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/a"));
		 signup_link.click();
		 
		 WebElement username = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/div[1]/input"));
		 username.sendKeys("John Wickkkk");
		 
		 WebElement jobtitle = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/div[2]/input"));
		 jobtitle.sendKeys("Ninja Testerrrr");

		 WebElement company_name = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/div[3]/input"));
		 company_name.sendKeys("TestMECAAAA");
		 
		 WebElement Email = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/div[4]/input"));
		 Email.sendKeys("oo@utasks.com");
		 
		 WebElement Password = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/div[5]/input"));
		 Password.sendKeys("123456789123");
		 
		 WebElement Password_Confirmation = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/div[6]/input"));
		 Password_Confirmation.sendKeys("123456789123");
		 
		 WebElement signup_button = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/button"));
         signup_button.click();
        	}
	
	public static void Login(WebDriver driver) {

		 WebElement Email = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/div[1]/input"));
		 Email.sendKeys("oo@utasks.com");
		 
		 WebElement Password = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/div[2]/input"));
		 Password.sendKeys("123456789123");
		 
		 WebElement login_button = driver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div/form/button"));
		 login_button.click();
	
	}
	public static void AddProject(WebDriver driver) {
		
		 WebElement AddProject_Link = driver.findElement(By.className("add-project__text"));
		 AddProject_Link.click();
		 
		 WebElement Projectname = driver.findElement(By.xpath("/html/body/div/div/main/section/div[1]/div[2]/div/input"));
		 Projectname.sendKeys("New projectt");
		 
		 WebElement AddProject_Button = driver.findElement(By.xpath("/html/body/div/div/main/section/div[1]/div[2]/div/button"));
		 AddProject_Button.click();
		 		 	 		
	}
	
	
	public static void AddTask_Inbox(WebDriver driver) {
		 WebElement Plus_icon = driver.findElement(By.xpath("/html/body/div/div/main/section/div[2]/div/div/span[1]"));
		 Plus_icon.click();
		
		 WebElement Taaskname = driver.findElement(By.xpath("/html/body/div/div/main/section/div[2]/div/div[2]/input"));
		 Taaskname.sendKeys("New taskk");
		 
		 WebElement Calendar_icon = driver.findElement(By.cssSelector(".add-task__date > svg:nth-child(1) > path:nth-child(1)"));
		 Calendar_icon.click();
		 
		 WebElement Tomorrow = driver.findElement(By.xpath("/html/body/div/div/main/section/div[2]/div/div[2]/div/ul/li[2]/div/span[2]"));
		 Tomorrow.click();
		 
		 		 
		 WebElement AddTask_Button = driver.findElement(By.xpath("/html/body/div/div/main/section/div[2]/div/div[2]/button"));
		 AddTask_Button.click();
		 		 
	}
	

		
    public static void AddTask_TopBar(WebDriver driver) {
    	
    	 WebElement Plus_icon_fromBar = driver.findElement(By.xpath("/html/body/div/div/main/header/nav/div[2]/ul/li[1]/button"));
    	 Plus_icon_fromBar.click();
    	 
    	 WebElement Quickadd_field = driver.findElement(By.xpath("/html/body/div/div/main/header/div/div/input"));
    	 Quickadd_field.sendKeys("Quick task");
    	 
    	 WebElement Calendar_icon = driver.findElement(By.cssSelector("div.add-task__main:nth-child(1) > span:nth-child(5) > svg:nth-child(1)"));
		 Calendar_icon.click();
    	 
		 WebElement Tomorrow = driver.findElement(By.xpath("/html/body/div/div/main/header/div/div/div[2]/ul/li[2]/div"));
		 Tomorrow.click();
    	 
    	 WebElement AddTask_Button = driver.findElement(By.xpath("/html/body/div/div/main/header/div/div/button"));
		 AddTask_Button.click();
    	 
    	
    }
    
    public static void Logout(WebDriver driver) {
    	 WebElement logout_button = driver.findElement(By.cssSelector(".settings__logout > button:nth-child(1) > svg:nth-child(1)"));
    	 logout_button.click();
    	 		
}

   
}
