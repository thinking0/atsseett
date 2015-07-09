import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class ExplorationN{
	WebDriver mDriver=null;
	

	public ExplorationN(WebDriver driver) {
		super();
		mDriver = driver;
	}
	
	public void init(URL url) {
		mDriver.get("http://www.google.com/webhp?complete=1&hl=en");
	}
	
	public void run() {
		//TODO: if here is no checking access to webpage, through this to failure
		
		WebElement query = mDriver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        query.submit();
        Sleeper.sleepTightInSeconds(1);
        boolean found = findElement();
        if (found == true) {
        
        	List<WebElement> elementList = mDriver.findElements(By.className("fl"));

        	for (WebElement ele : elementList) {
        	String elementStr = ele.getText();
        		if(elementStr.equals("2")) {
        			ele.click();
        			break;
        		}
        	}
        }
        Sleeper.sleepTightInSeconds(1);
        List<WebElement> elementList2 = mDriver.findElements(By.className("rc"));
        for (WebElement ele : elementList2) {
        	WebElement link = ele.findElement(By.className("r")).findElement(By.tagName("a"));
        	String title = link.getText();
        	System.out.println("title : " + title);
			if(title.equals("Tillamook Dairy Co-Op")) {
        			link.click();
        			break;
        	}
        }
	}
	private boolean findElement() {
		boolean foundElement=true;
		//TODO: calculate whole scroll length and doing when scroll is end
		JavascriptExecutor jse = (JavascriptExecutor)mDriver;
        jse.executeScript("scroll(0, 650);");
        if(foundElement) {
        	
        }
        
        return foundElement;
        
	}
}