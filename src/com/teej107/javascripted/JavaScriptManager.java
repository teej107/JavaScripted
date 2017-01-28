package com.teej107.javascripted;

import javax.script.*;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by teej107 on 1/16/2017.
 */
public class JavaScriptManager
{
	private ScriptEngineManager manager;
	private ScriptEngine engine;
	private String global;

	public JavaScriptManager()
	{
		this.manager = new ScriptEngineManager();
		this.engine = manager.getEngineByName("JavaScript");

		try
		{
			global = new String(Files.readAllBytes(Paths.get(getClass().getResource("/assets/global.js").toURI())));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public ScriptEngineManager getManager()
	{
		return manager;
	}

	public String eval(String s)
	{
		try
		{
			Object result = engine.eval(global + s);
			return result == null ? "" : result.toString();
		}
		catch (ScriptException e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
	}

	public String global()
	{
		return global;
	}
}
