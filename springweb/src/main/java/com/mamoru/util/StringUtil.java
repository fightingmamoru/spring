package com.mamoru.util;

public class StringUtil
{
	/**
	 * Check this string is empty.
	 *
	 * @param		str			String
	 * @return		boolean		A string is null or empty.
	 */
	public static boolean isEmpty(Object str)
	{
		return str == null || "".equals(str);
	}
}
