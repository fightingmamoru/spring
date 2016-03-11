package com.mamoru.common.util;


import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.ScriptableObject;
import org.springframework.util.StringUtils;

public class JavascriptUtil
{
	// 자바스크립트를 호출하여 결과값을 리턴하는 메소드
	public static Object callJavaScript(String script, String functionName, Object[] params)
	{
		Object result = null;
		Context context = Context.enter();

		String callingFunctionName = StringUtils.isEmpty(functionName) ? "getValue" : functionName;

		try
		{
			ScriptableObject scope = context.initStandardObjects();
			context.evaluateString(scope, script, "script", 1, null);

			Function function = (Function) scope.get(callingFunctionName, scope);

			result = function.call(context, scope, scope, params);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			Context.exit();
		}

		return result;
	}
}
