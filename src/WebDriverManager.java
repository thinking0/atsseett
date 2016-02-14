import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {
	
	public static boolean PROXY_ENABLE = true;
	private WebDriver mDriver;
	private ProxyManager mProxyManager;
	
	public WebDriverManager() {
		
		if(mProxyManager == null) {
			mProxyManager = new ProxyManager();
		}
		
		if (mDriver == null) {
			try {
				DesiredCapabilities dc = getDesiredCapability();
				mDriver = new RemoteWebDriver(new URL("http://localhost:9515"), dc);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("cookie1 : "+mDriver.manage().getCookies());
		
		mDriver.manage().deleteAllCookies();
		System.out.println("cookie2 : "+mDriver.manage().getCookies());
		

	}
	
    public WebDriver getWebDriver() {
    	return mDriver;
    }
    
    
    private  DesiredCapabilities getDesiredCapability() {
    	WebDriver dr = null;
    	
    	Proxy proxy = setProxyServer(mProxyManager.getSpecificProxy());
    	DesiredCapabilities dc = DesiredCapabilities.chrome();
    	// TODO: add proxy list
    	if (PROXY_ENABLE == true) {
    		dc.setCapability(CapabilityType.PROXY, proxy);	
    	}
    	
    	return dc;
    }
    
    private  Proxy setProxyServer(String proxyserver) {
    	Proxy proxy = new org.openqa.selenium.Proxy();
    	/*String[] host = proxyserver.split(":");
    	String ip = host[0];
    	String port = host[1];*/
    	proxy.setHttpProxy(proxyserver);
    	return proxy;
    }

}
