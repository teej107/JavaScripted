package com.teej107.javascripted.jsobjects;

import com.teej107.javascripted.swing.ResultPanel;

import javax.swing.*;

/**
 * Created by tanner on 1/26/17.
 */
public class JavaScriptGlobalObject
{
	private ResultPanel resultPanel;
	private Console console;

	public JavaScriptGlobalObject(ResultPanel resultPanel)
	{
		this.resultPanel = resultPanel;
		this.console = new Console(resultPanel);
	}

	public Console getConsole()
	{
		return console;
	}

	public void alert(Object obj)
	{
		JOptionPane.showMessageDialog(null, obj.toString());
	}
}
