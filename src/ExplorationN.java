import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class ExplorationN{
	WebDriver mDriver=null;
	Dimension mWindowSize;

	public ExplorationN(WebDriver driver) {
		super();
		mDriver = driver;
	}
	
	public void init(URL url) {
		mDriver.get("http://www.google.com/webhp?complete=1&hl=en");
		mWindowSize = mDriver.manage().window().getSize();
		System.out.println("size11 : " + mWindowSize);
		
	}
	
	/**
	 * used for scrolling
	 */
	private Dimension getWholeHeight() {
        WebElement query2 = mDriver.findElement(By.id("center_col"));
        Dimension point2 = query2.getSize();
        return point2;
	}
	
	private void currentScrollStatus() {
		//boolean scrollBarPresent = (boolean) ((JavascriptExecutor)mDriver).executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");	
	}

	public void run() {
		//TODO: if here is no checking access to webpage, through this to failure
		
		WebElement query = mDriver.findElement(By.name("q"));
		Point point = query.getLocation();
        System.out.println("size : " + point);
        query.sendKeys("ip check");
        query.submit();
        Sleeper.sleepTightInSeconds(1);
        
        
        
        List<WebElement> menuHoverLink = mDriver.findElements(By.cssSelector("a"));
        System.out.println("siz11e : " + menuHoverLink.size());
        if(menuHoverLink.size() > 0) {
        	System.out.println("siz11e : " + menuHoverLink.get(0).getAttribute("href"));	
        }
        
        String searchLinkTxt = "http://whatismyipaddress.com/";
        searchLink(searchLinkTxt);
        

        //searchSentence("Vermont Cheese");
        
        
        /*
        // find link text by mouse
        Actions actions = new Actions(mDriver);
        try{
        	WebElement menuHoverLink = mDriver.findElement(By.linkText("Apps/Cheese - GNOME Wiki!"));
            actions.moveToElement(menuHoverLink);

            //WebElement subLink = mDriver.findElement(By.cssSelector("#headerMenu .subLink"));
            //actions.moveToElement(subLink);
            actions.click();
            actions.perform();	
        }catch(Exception e){
        	
        }*/
        
        
        
        
        
        /*WebElement elementList = (WebElement) mDriver.findElements(By.xpath("/html/body[@id='gsr']/div[@id='main']/div[@id='cnt']/div[@class='mw'][2]/div[@id='rcnt']/div[@class='col'][1]/div[@id='center_col']/div[5]/div[@id='foot']/span[@id='xjs']/div[@id='navcnt']/table[@id='nav']/tbody/tr/td[5]/a[@class='fl']"));
        
        org.openqa.selenium.interactions.internal.Coordinates coord=(org.openqa.selenium.interactions.internal.Coordinates) ((org.openqa.selenium.internal.Locatable)elementList).getCoordinates();
        coord.inViewPort();*/
        
        /*boolean found = findElement();
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
        }*/
        //mDriver.close();
	}
	private void searchLink(String searchLinkText) {
		Sleeper.sleepTightInSeconds(1);
		
		List<WebElement> menuHoverLinkList = mDriver.findElements(By.cssSelector("a"));
        System.out.println("ssize : " + menuHoverLinkList.size());
        boolean foundPage = false;
        WebElement specificPageLink = null;
        
        //current page string
        WebElement eleCurrentPage = mDriver.findElement(By.className("cur"));
        String curPage = eleCurrentPage.getText();
        System.out.println("curpage : " + curPage);
        for (WebElement ele : menuHoverLinkList) {
        	// TODO: need to determine when scroll will be down
        	String link = ele.getAttribute("href");
        	if(link != null) {
        		System.out.println("title : " + link);
            	
    			if (link.matches(searchLinkText)) {
    					System.out.println("success");
    					foundPage = true;
    					specificPageLink = ele;
            			break;
            	} else {
            		foundPage = false;
            	}	
        	}
        	
        }
        if (foundPage == true) {
        	specificPageLink.click();
        	resideOnpage();
        } else {

        	// TODO: determine scrolling process
        	findElement();
        	// go to other page
        	goAnotherPage2(curPage,searchLinkText);
        	
        }
	}
	

	private void goAnotherPage2 (String currentPage, String searchText) {
		List<WebElement> elementList = mDriver.findElements(By.className("fl"));
		String nextPage = String.valueOf((Integer.parseInt(currentPage)+1));
    	for (WebElement ele : elementList) {
    		String pageStr = ele.getText();
    		
    		if(currentPage == pageStr) continue;
    	
    		if(pageStr.equals(nextPage)) {
    			ele.click();
    			break;
    		}
    	}
    	
    	searchLink(searchText);
	}
	
	
	private void searchSentence(String searchTxt) {
		Sleeper.sleepTightInSeconds(1);
        List<WebElement> elementList2 = mDriver.findElements(By.className("rc"));
        boolean foundPage = false;
        WebElement specificPageLink = null;
        
        //current page string
        WebElement eleCurrentPage = mDriver.findElement(By.className("cur"));
        String curPage = eleCurrentPage.getText();
        System.out.println("curpage : " + curPage);
        String searchtxtrex = ".*" + searchTxt + ".*";
        for (WebElement ele : elementList2) {
        	// TODO: need to determine when scroll will be down
        	WebElement link = ele.findElement(By.className("r")).findElement(By.tagName("a"));
        	String title = link.getText();
        	System.out.println("title : " + title);
        	
			if (title.matches(searchtxtrex)) {
					System.out.println("success");
					foundPage = true;
					specificPageLink = link;
        			break;
        	} else {
        		foundPage = false;
        	}
        }
        if (foundPage == true) {
        	specificPageLink.click();
        	resideOnpage();
        } else {

        	// TODO: determine scrolling process
        	findElement();
        	// go to other page
        	goAnotherPage(curPage,searchTxt);
        	
        }
	}
	
	private void resideOnpage() {
		randomScrollDown("150");
		randomScrollDown("250");
		randomScrollDown("350");
		randomScrollDown("450");
		randomScrollDown("550");
		randomScrollDown("650");
	}
	private int mMinResideSecond = 1;
	private int mMaxResideSecond = 10;
	Random mRnd = new Random();
	
	private void randomScrollDown(String scrollY) {
		int resideSecond = mRnd.nextInt(mMaxResideSecond - mMinResideSecond+1) + mMinResideSecond;
		Sleeper.sleepTightInSeconds(resideSecond);
		System.out.println("reside seconde : " + resideSecond);
		JavascriptExecutor jse = (JavascriptExecutor)mDriver;
		
		// TODO: important, change x,y values by random with time
        jse.executeScript("window.scrollBy(0, "+ scrollY +");");
        
        
	}

	private void goAnotherPage (String currentPage, String searchText) {
		List<WebElement> elementList = mDriver.findElements(By.className("fl"));
		String nextPage = String.valueOf((Integer.parseInt(currentPage)+1));
    	for (WebElement ele : elementList) {
    		String pageStr = ele.getText();
    		
    		if(currentPage == pageStr) continue;
    	
    		if(pageStr.equals(nextPage)) {
    			ele.click();
    			break;
    		}
    	}
    	
    	searchSentence(searchText);
	}
	
	private boolean findElement() {
		boolean foundElement=true;
		//TODO: calculate whole scroll length and doing when scroll is end
		JavascriptExecutor jse = (JavascriptExecutor)mDriver;
        jse.executeScript("scroll(0, 850);");
        if(foundElement) {
        	
        }
        
        return foundElement;
        
	}
}