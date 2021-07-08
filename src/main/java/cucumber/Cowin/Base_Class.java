package cucumber.Cowin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {
	public static WebDriver driver;
	/*----------1.BROWSER LAUNCH--------*/
	public static void browserLaunch(String options) {
		
		try {
			if (options.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+("\\Driver\\chromedriver.exe"));
			 driver = new ChromeDriver();
}
else if (options.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+("\\Driver\\geckodriver.exe"));
			driver = new FirefoxDriver();
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*-------8.GET URL--------------*/
public static void get(String url) {
try {
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
/*--------4.NAVIGATE TO();-------------*/
public static void goTo(String address) {
	try {
		driver.navigate().to(address);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*--------5.NAVIGATE BACK();-------------*/
public static void GoBack() {
	try {
		driver.navigate().back();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*--------6.NAVIGATE FORWARD();-------------*/
public static void forward() {
	try {
		driver.navigate().forward();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*--------7.NAVIGATE REFRESH();-------------*/
public static void refresh() {
	try {
		driver.navigate().refresh();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*--------21.GET CURRENT URL();-------------*/
public static void currentUrl() {
	try {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*---------27.SENDKEYS();----------*/
public static void typeOnElement( WebElement findElement, String value) {
	//WebElement findElement = driver.findElement(By.id(""));
	findElement.sendKeys(value);
}
/*------31.CLICK(); AND 15.CHECK BOX-----*/
public static void clickOnElement(WebElement element) {
	//WebElement element = driver.findElement(By.id(""));
	element.click();
	
}
/*---------18.IS SELECTED();------------*/
public static void isSelected(WebElement element) {
	try {
		// WebElement element = driver.findElement(By.id(""));
		 boolean selected = element.isSelected();
		System.out.println(selected);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*---------17.IS DISPLAYED();------------*/
public static void isDisplayed(WebElement element) {
	 try {
		//WebElement element = driver.findElement(By.id(""));
		 boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*---------16.IS ENABLED();------------*/
public static void isEnabled(WebElement element) {
	 try {
		//WebElement element = driver.findElement(By.id(""));
		 boolean enabled = element.isEnabled();
		System.out.println(enabled);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*---------30.IS MULTIPLE();------------*/
public static void isMultiple(WebElement mul) {
	try {
		//WebElement mul = driver.findElement(By.xpath(""));		
		Select s = new Select(mul);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*---------19.GET OPTIONS();------------*/
public static void getOptions(WebElement mul) {
		//WebElement mul = driver.findElement(By.xpath(""));		
		Select s = new Select(mul);
		List<WebElement> options = s.getOptions();
		for (WebElement seperateoptions : options) {
			try {
				String text = seperateoptions.getText();
				System.out.println(text);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
/*---------20.GET TITLE();------------*/
public static void getTitle() {
	try {
		String title = driver.getTitle();
		System.out.println(title);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*---------14.DROP DOWN();------------*/
public static void clickOnDropDown(WebElement element, String options, String value) {
	//WebElement element = driver.findElement(By.id(""));
	Select s = new Select(element);
	try {
		if (options.equalsIgnoreCase("byIndex")) {
			int value1 = Integer.parseInt(value);
			s.selectByIndex(value1);
		} else if (options.equalsIgnoreCase("byValue")) {
			s.selectByValue(value);
		} 
		else if (options.equalsIgnoreCase("byVisibleText")) {
			s.selectByVisibleText(value);
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
/*---------28.GET FIRST SELECTED OPTION();------------*/
public static void firstSelectedOption(WebElement element) {
try {
	//WebElement element = driver.findElement(By.id(""));
	Select s = new Select(element);
	WebElement firstSelectedOption = s.getFirstSelectedOption();
	String text = firstSelectedOption.getText();
	System.out.println(text);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}
/*---------29.GET ALL SELECTED OPTION();------------*/
public static void allSelectedOption(WebElement element) {
	try {
		//WebElement element = driver.findElement(By.id(""));
		Select s = new Select(element);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement options : allSelectedOptions) {
			String text = options.getText();
			System.out.println(text);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
/*---------25.SCREENSHOT();------------*/
public static void screenshot(String path) throws Throwable {
	try {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File take = ts.getScreenshotAs(OutputType.FILE);
		File store = new File(path);
		FileUtils.copyFileToDirectory(take, store);
	} catch (WebDriverException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*---------22.GETTEXT();------------*/
public static void getText(WebElement element) {
	try {
		//WebElement element = driver.findElement(By.id(""));
		String text = element.getText();
		System.out.println(text);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*------23.GET ATTRIBUTE()---------*/
public static void getAttribute(WebElement element, String value) {
	try {
		//WebElement element = driver.findElement(By.id(""));
		String attribute = element.getAttribute(value);
		System.out.println(attribute);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
/*------10.ACTIONS()---------*/
public static void mouseHover(WebElement findElement, String options) {
	try {
		//WebElement findElement = driver.findElement(By.id(""));
		Actions act = new Actions(driver);
		
		if (options.equalsIgnoreCase("moveToElement")) {
			act.moveToElement(findElement).build().perform();
		}
			else if (options.equalsIgnoreCase("contextClick")) {
				act.contextClick().build().perform();
			}
			else if (options.equalsIgnoreCase("doubleClick")) {
				act.doubleClick().build().perform();
			}
		else if (options.equalsIgnoreCase("doubleClickWebElement")) {
			act.doubleClick(findElement).build().perform();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
/*------10(1).ACTIONS(DDRAG AND DROP)---------*/
public static void dragAndDrop(WebElement findElement, WebElement findElement2, String options) {
	
		try {
			//WebElement findElement = driver.findElement(By.id(""));
			Actions act = new Actions(driver);
			
			if (options.equalsIgnoreCase("dragAndDrop")) {
				act.dragAndDrop(findElement, findElement2).build().perform();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
/*-----------9.ALERT();-------*/
public static void alert(String option) {
	try {
		if (option.equalsIgnoreCase("Accept")) {
			driver.switchTo().alert().accept();
		} 
		else if (option.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*-----------9(1).ALERT SEND();-------*/
public static void alertSend(String option, String Value) {
	try {
		if (option.equalsIgnoreCase("alertSend")) {
			driver.switchTo().alert().sendKeys(Value);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
/*-----------12.ROBOT();-------*/
public static void robot(String option) throws Throwable {
	try {
		Robot r = new Robot();
		if (option.equalsIgnoreCase("Down")) {
			r.keyPress(KeyEvent.VK_DOWN);	
		}
		else if (option.equalsIgnoreCase("Enter")) {
			r.keyPress(KeyEvent.VK_ENTER);	
		}
	} catch (AWTException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
/*---------11.FRAMES();-----*/
public static void frame(String option, WebElement value, String value1 ) {
	try {
		if (option.equalsIgnoreCase("byIndex")) {
			driver.switchTo().frame(value);
		}
		else if (option.equalsIgnoreCase("byString")) {
			driver.switchTo().frame(value1);
		}
		else if (option.equalsIgnoreCase("byWebElement")) {
			driver.switchTo().frame(value);
		}else if (option.equalsIgnoreCase("parent")) {
			driver.switchTo().parentFrame();
		}
		else if (option.equalsIgnoreCase("default")) {
			driver.switchTo().defaultContent();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
/*----------13.WINDOW HANDLING-----*/

public static void addressOfwindow() {
	String windowHandle = driver.getWindowHandle();
	System.out.println(windowHandle);
}
public static void addressOfWindows() {
Set<String> windowHandles = driver.getWindowHandles();
System.out.println(windowHandles);
}
public static void titleOfWindow() {
	String windowHandle = driver.getWindowHandle();
	String title = driver.switchTo().window(windowHandle).getTitle();
	System.out.println(title);
}
public static void titlesOfWindows() {
Set<String> windowHandles = driver.getWindowHandles();
for (String adrs : windowHandles) {
	String title = driver.switchTo().window(adrs).getTitle();
	System.out.println(title);
}
}
public static void switchToWindow(String titleName) {
	Set<String> windowHandles = driver.getWindowHandles();
	for (String adrs : windowHandles) {
		if (adrs.equalsIgnoreCase(titleName)) {
			driver.switchTo().window(adrs);	
		}
		
	}

}

}
