import java.net.URL;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testApp {
	WebDriver mDriver=null;
	WebDriverWait mWait;
	
	public testApp(WebDriver driver) {
		super();
		mDriver = driver;
	}
	
	public void init(URL url) {
		
		mWait = new WebDriverWait(mDriver, 300);
		mDriver.get("http://carspyshot.tistory.com/10951#.VgFfjd_5eUk");
		resideOnpage();
		
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
	private int mMaxResideSecond = 3;
	Random mRnd = new Random();
	
	private void randomScrollDown(String scrollY) {
		int resideSecond = mRnd.nextInt(mMaxResideSecond - mMinResideSecond+1) + mMinResideSecond;
		Sleeper.sleepTightInSeconds(resideSecond);
		System.out.println("reside second : " + resideSecond);
		JavascriptExecutor jse = (JavascriptExecutor)mDriver;
		
		// TODO: important, change x,y values by random with time
        jse.executeScript("window.scrollBy(0, "+ scrollY +");");
        
        
	}
}
