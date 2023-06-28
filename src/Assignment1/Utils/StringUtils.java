package Assignment1.Utils;

import java.util.ArrayList;
import java.util.StringTokenizer;

public final class StringUtils {
	
	public static ArrayList<String> tokenTextAndClean(String text, String splitter) {
		StringTokenizer st = new StringTokenizer(text, splitter);
		final var tokens = new ArrayList<String>();
		while(st.hasMoreTokens()) {
			final var token = cleanToken(st.nextToken());
			tokens.add(token);
		}
		return tokens;
	}
	
	public static String cleanToken(String token) {
		final var result = token.replaceAll("\\.|\\(|\\)|\\:|\\,", "");
		System.out.println(token + " : " + result);
		return result;
	}
}
