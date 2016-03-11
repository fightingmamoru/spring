package com.mamoru.common.util;

import org.junit.Test;

/**
 * Created by KIMJB on 2016-03-11.
 */
public class JavascriptUtilTest
{
	@Test
	public void javascriptCallingTest()
	{
		String script = "if ( country == 'KOREA' )" +
						"{" +
						"	return 'KOR';" +
						"}" +
						"else if ( country == 'JAPAN' )" +
						"{" +
						"	return 'JAP';" +
						"}" +
						"else" +
						"{" +
						"	return 'EU';" +
						"}";

		StringBuilder sb = new StringBuilder();
		sb.append("function getCountry(country) {")
		  .append(script)
		  .append("}");

		Object[] params = {"US"};

		System.out.println(JavascriptUtil.callJavaScript(sb.toString(), "getCountry", params));
	}
}