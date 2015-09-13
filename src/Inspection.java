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
        	WebDriver mDriver = getWebDriver();
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
    
    
    private static WebDriver getWebDriver() {
    	WebDriver driver = null;
		try {
			DesiredCapabilities dc = getDesiredCapability();
			driver = new RemoteWebDriver(new URL("http://localhost:9515"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return driver;
    }
    
    private static DesiredCapabilities getDesiredCapability() {
    	WebDriver dr = null;
    	
    	Proxy proxy = setProxyServer();
    	DesiredCapabilities dc = DesiredCapabilities.chrome();
    	// TODO: add proxy list
    	//dc.setCapability(CapabilityType.PROXY, proxy);
    	return dc;
    }
    
    private static Proxy setProxyServer() {
    	Proxy proxy = new org.openqa.selenium.Proxy(); 
    	proxy.setSslProxy("proxyurl"+":"+8080); 
    	proxy.setFtpProxy("proxy url"+":"+8080); 
    	proxy.setSocksUsername("SSSLL277"); 
    	proxy.setSocksPassword("password");
    	return proxy;
    }

   

}


