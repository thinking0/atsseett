import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;


public class Inspection {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
     // The Firefox driver supports javascript 
        //WebDriver driver = new ChromeDriver();
        
        WebDriver driver=null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        driver.get("http://www.google.com/webhp?complete=1&hl=en");
        
        // Go to the Google Suggest home page
        //driver.get("http://www.google.com/webhp?complete=1&hl=en");
        
        // Enter the query string "Cheese"
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("Cheese");
        query.submit();
        Sleeper.sleepTightInSeconds(5);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //jse.executeScript("window.scrollBy(0,250)", "");
        jse.executeScript("scroll(0, 250);");
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
