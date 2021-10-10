 package helper;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validation  {

	public static boolean checkRegex(String regex, String str) {
		while (true) {
			Pattern patter = Pattern.compile(regex);
			Matcher match = patter.matcher(str);
			if (match.matches()) {
				return true;
			}
			return false;
		}
	}

}
