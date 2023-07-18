package jw.bit.frontcontroller;

public class ViewResolver {
	private final static String prefix ="/WEB-INF/member";
	private final static String postfix =".jsp";
	public static String getPath(String url) {
		return prefix+url+postfix;
	}
}
