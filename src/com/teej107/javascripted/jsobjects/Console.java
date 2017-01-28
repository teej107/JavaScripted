package com.teej107.javascripted.jsobjects;

import com.teej107.javascripted.swing.ResultPanel;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * Created by tanner on 1/28/17.
 */
public class Console
{
	private ResultPanel panel;

	public Console(ResultPanel panel)
	{
		this.panel = panel;
	}

	public void log(Object... o)
	{
		StringBuilder sb = new StringBuilder();
		for (Object obj : o)
		{
			if(obj instanceof ScriptObjectMirror)
			{
				sb.append(new JSON((ScriptObjectMirror) obj).toString()).append(' ');
			}
			else
			{
				sb.append(obj.toString()).append(' ');
			}
		}
		sb.setLength(sb.length() - 1);
		sb.append("\n");
		panel.append(sb.toString());
	}
}
