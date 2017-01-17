package com.teej107.javascripted;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

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

	public static ScriptEngine getInstance()
	{
		return JAVA_SCRIPT_MANAGER.engine;
	}
}
