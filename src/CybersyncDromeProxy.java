import java.util.ArrayList;
import java.util.List;

public class CybersyncDromeProxy implements IProxy {

	@Override
	public List<String> getList() {
		//TODO: get proxy list from http://www.cybersyndrome.net/search.cgi?q=&a=ABCD&f=s&s=rcc&n=200&p=2
		// only KR server . need to use hTML parser
		ArrayList<String> proxyList = new ArrayList<String>();
		proxyList.add("222.236.46.16:80");
		proxyList.add("218.49.74.233:8080");
		proxyList.add("218.150.214.27:80");
		proxyList.add("211.170.156.163:80");
		proxyList.add("203.171.176.185:80");
		proxyList.add("183.111.169.209:3128");
		proxyList.add("183.111.169.208:3128");
		proxyList.add("183.111.169.206:3128");
		proxyList.add("183.111.169.205:3128");
		proxyList.add("183.111.169.204:3128");
		proxyList.add("183.111.169.202:3128");
		proxyList.add("183.111.169.201:3128");
		proxyList.add("175.120.28.17:80");
		proxyList.add("114.207.216.220:80");
		proxyList.add("106.240.250.106:808");
		return proxyList;
	}

}
