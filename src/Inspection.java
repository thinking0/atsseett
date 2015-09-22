import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class Inspection {
	
	
    public static void main(String[] args) {
        // TODO Auto-generated method stub
     // The Firefox driver supports javascript 
        //WebDriver driver = new ChromeDriver();
        
    	
        try {
        	WebDriverManager wManager = new WebDriverManager();
        	WebDriver mDriver = wManager.getWebDriver();
        	//testApp e = new testApp(mDriver);
        	
        	ExplorationN e = new ExplorationN(mDriver);
        	
        	e.init(new URL("http://www.google.com/webhp?complete=1&hl=en"));
        	e.run();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        
        
        // Go to the Google Suggest home page
        //driver.get("http://www.google.com/webhp?complete=1&hl=en");
        
        // Enter the query string "Cheese"
        
        
    /*List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }*/
        // Sleep until the div we want is visible or 5 seconds is over
        /*long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            WebElement resultsDiv = driver.findElement(By.className("y yp"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed()) {
              break;
            }
        }*/

        // And now list the suggestions
        /*List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
        
        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }*/

        //driver.quit();
    }
    
    
   

}


