import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplorationN{
	WebDriver mDriver=null;
	Dimension mWindowSize;

	public ExplorationN(WebDriver driver) {
		super();
		mDriver = driver;
	}
	
	public void init(URL url) {
		
		mWait = new WebDriverWait(mDriver, 300);
		mDriver.get("http://www.naver.com/");
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

	WebDriverWait mWait;
	public void run() {
		//TODO: if here is no checking access to webpage, through this to failure
		
		
		
		WebElement query = mWait.until(ExpectedConditions.elementToBeClickable(By.name("query")));
		Point point = query.getLocation();
        System.out.println("size : " + point);
        query.sendKeys("nav ");
        query.submit();
        Sleeper.sleepTightInSeconds(1);
        //goto blog
        WebElement blogLink = mWait.until(ExpectedConditions.elementToBeClickable(By.className("lnb3")));
        blogLink.click();
        String searchLinkTxt = "http://carspyshot.tistory.com/10951";
        searchLink(searchLinkTxt);
		
		
        /*List<WebElement> menuHoverLink = mDriver.findElements(By.cssSelector("a"));
        System.out.println("siz11e : " + menuHoverLink.size());
        if(menuHoverLink.size() > 0) {
        	System.out.println("siz11e : " + menuHoverLink.get(0).getAttribute("href"));	
        }
        
        String searchLinkTxt = "http://whatismyipaddress.com/";
        searchLink(searchLinkTxt);*/
        

        
        
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
        
        
        //mDriver.close();
	}


	private void goAnotherPage2 (String curPage, String searchText) {
		List<WebElement> elementList = mDriver.findElements(By.cssSelector(".paging *"));
		
		/*WebElement curPageElement = mDriver.findElement(By.cssSelector(".paging strong"));
		curPageElement.*/
		System.out.println("sizizi : " + elementList.get(0).getTagName() + " , " + elementList.get(1).getTagName());
		
    	for (WebElement ele : elementList) {
    		String pageNumber = ele.getText();
    		String nextPage = String.valueOf(Integer.parseInt(curPage)+1);
    		if (pageNumber.equals(nextPage)) {
    			ele.click();
    			break;
    		} else {
    			
    		}
    	}
    	
    	searchLink(searchText);
	}
	
	
	private void searchLink(String searchLinkText) {
		Sleeper.sleepTightInSeconds(1);
		
		List<WebElement> menuHoverLinkList = mDriver.findElements(By.cssSelector("a"));
        System.out.println("ssize : " + menuHoverLinkList.size());
        boolean foundPage = false;
        WebElement specificPageLink = null;
        
        //current page string
        WebElement curPageElement = mWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".paging strong")));
        String curPage = curPageElement.getText();
        for (WebElement ele : menuHoverLinkList) {
        	// TODO: need to determine when scroll will be down
        	String link = ele.getAttribute("href");
        	if(link != null) {
        		System.out.println("title : " + link);
            	
    			if (link.equals(searchLinkText)) {
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
        	//specificPageLink.sendKeys(Keys.CONTROL, Keys.TAB, Keys.TAB);
        	//TODO: change to new tab
        	resideOnpage();
        } else {

        	// TODO: determine scrolling process
        	findElement();
        	// go to other page
        	//TODO: if there is final page, should be done
        	goAnotherPage2(curPage, searchLinkText);
        	
        }
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
		//scroll
		//http://stackoverflow.com/questions/30495721/selenium-webdriver-javascript-how-do-i-scroll-through-a-page
		//http://aksahu.blogspot.kr/2015/05/scroll-pages-in-selenium-webdriver.html
		randomScrollDown("150");
		randomScrollDown("250");
		randomScrollDown("350");
		randomScrollDown("450");
		randomScrollDown("550");
		randomScrollDown("650");
	}
	private int mMinResideSecond = 1;
	private int mMaxResideSecond = 3;
	Random mRnd = new Random();
	
	private void randomScrollDown(String scrollY) {
		int resideSecond = mRnd.nextInt(mMaxResideSecond - mMinResideSecond+1) + mMinResideSecond;
		Sleeper.sleepTightInSeconds(resideSecond);
		System.out.println("reside second : " + resideSecond);
		JavascriptExecutor jse = (JavascriptExecutor)mDriver;
		WebElement web = mDriver.findElement(By.tagName("body")); 
		// TODO: important, change x,y values by random with time
        jse.executeScript("window.scrollBy(0, "+ scrollY +");",web);
        //jse.executeAsyncScript("window.scrollBy(0, "+ scrollY +");",web);
        
        
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