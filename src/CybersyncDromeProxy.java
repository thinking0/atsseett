import java.util.ArrayList;
import java.util.List;

public class CybersyncDromeProxy implements IProxy {

	@Override
	public List<String> getList() {
		//TODO: get proxy list from http://www.cybersyndrome.net/search.cgi?q=&a=ABCD&f=s&s=rcc&n=200&p=2
		// only KR server . need to use hTML parser
		ArrayList<String> proxyList = new ArrayList<String>();
		proxyList.add("222.231.44.200:80");
		proxyList.add("222.231.44.200:80");
		
		return proxyList;
	}

}
