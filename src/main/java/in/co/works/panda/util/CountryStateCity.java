package in.co.works.panda.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CountryStateCity {
	
	public static void main(String[] args) {
		
		Format dateFormat = new SimpleDateFormat("EEE");
	      String res = dateFormat.format(new Date());
	      System.out.println("Date = " + res);
	}

}
