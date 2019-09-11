package sdfjk;

import java.util.Iterator;
import java.util.TreeSet;
public class Demo {
	

	public static void main(String[] args) {
//		String value = "45dsf sdfjk  dsf  sdd 45d  sdkjkdsjk  sdfkjjk";
//		String reg = "\\b[a-z]{3}\\b";
//		Pattern parttern = Pattern.compile(reg);
//		
//		Matcher m = parttern.matcher(value);
//		System.out.println("sf");
//		while(m.find()) {
//			System.out.println(m.group());
//		}
		
		
		
//		String value = "我我我。。。。。。。。要要要。。。。学学学。。学。学学学。。编程。编编。。。程程";
//		
//		String reg = "\\。+";
//		String fina = value.replaceAll(reg,"");
//		System.out.println(fina);
//		
//		fina = fina.replaceAll("(.)\\1","");
//		System.out.println(fina);
		
		
		String value = "192.68.254 102.49.23 013.10.10 10.10.2 2.2.89 256.443.11";
		
		value = value.replaceAll("(\\d+)", "00$1");
		//System.out.println(value);
		
		value = value.replaceAll("0*(\\d{3})", "$1");
		//System.out.println(value);
		TreeSet<String> set =new TreeSet<String>();

		String [] str = value.split(" +");
		for (String s : str) {
			set.add(s);
		}
		
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().replaceAll("0*(\\d+)", "$1"));
		}
		
//		
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	private static java.util.TreeSet<String> TreeSet() {
		// TODO Auto-generated method stub
		return null;
	}
}
