package com.teej107.javascripted;

import javax.script.*;

/**
 * Created by teej107 on 1/16/2017.
 */
public class JavaScriptManager
{
	private static final JavaScriptManager JAVA_SCRIPT_MANAGER = new JavaScriptManager();

	private ScriptEngineManager manager;
	private ScriptEngine engine;

	private JavaScriptManager()
	{
		this.manager = new ScriptEngineManager();
		this.engine = manager.getEngineByName("JavaScript");
	}

	public static JavaScriptManager getInstance()
	{
		return JAVA_SCRIPT_MANAGER;
	}

	public String eval(String s)
	{
		try
		{
			String result = engine.eval(s).toString();
			return result == null ? "" : result;
		}
		catch (ScriptException e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
