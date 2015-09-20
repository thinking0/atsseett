import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ProxyManager {


	private Date mExpiredDate;
	
	private List<String> mProxyList;
	
	public ProxyManager() {
		int expiredDateFlg = checkExpiredList();
		if(expiredDateFlg == 1) {
			createProxyList();
		}
	}

	public String getSpecificProxy() {
		String ip="";
		List<String> proxyList = getProxyList();
		Random rnd = new Random();
		int proxyIndex = rnd.nextInt(proxyList.size()-1);
		System.out.println("proxy index : " + proxyIndex);
		return proxyList.get(proxyIndex);
	}

	public void createProxyList() {
		IProxy proxy = new CybersyncDromeProxy();
		mProxyList = proxy.getList();
	}
	
	private int checkExpiredList() {
		int result = 0;
		if(mExpiredDate == null) {
			mExpiredDate = new Date();
			
			//TODO: get time from online. offline time can be manipulated by user
			mExpiredDate = Calendar.getInstance().getTime();
			result = 1;
		} else {
			//TODO: compre current and expired date
			Date curDate = Calendar.getInstance().getTime();
			long diff = Math.abs(curDate.getTime() - mExpiredDate.getTime());
			long diffDays = diff / (24 * 60 * 60 * 1000);
			if (diffDays >=1) {
				result = 1;
			}
		}
		
		return result;
	}
	
	public List<String> getProxyList() {
		return mProxyList;
	}
	
}
