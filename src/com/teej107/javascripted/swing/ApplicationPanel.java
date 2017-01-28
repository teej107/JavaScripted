package com.teej107.javascripted.swing;

import com.teej107.javascripted.JavaScriptManager;
import com.teej107.javascripted.jsobjects.JavaScriptGlobalObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tanner on 1/26/17.
 */
public class ApplicationPanel extends JPanel
{
	private EditorPanel editorPanel;
	private StatusBar statusBar;
	private ResultPanel resultPanel;
	private JSplitPane splitPane;
	private JavaScriptManager jsManager;
	private JavaScriptGlobalObject jsGlobalObject;

	public ApplicationPanel()
	{
		this.jsManager = new JavaScriptManager();

		setLayout(new BorderLayout());
		this.editorPanel = new EditorPanel();
		this.resultPanel = new ResultPanel();
		this.statusBar = new StatusBar(this);
		this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, editorPanel, resultPanel);
		this.jsGlobalObject = new JavaScriptGlobalObject(resultPanel);

		setupJavaScriptEngine();

		splitPane.setDividerLocation(400);

		add(splitPane, BorderLayout.CENTER);
		add(statusBar, BorderLayout.PAGE_END);
	}

	private void setupJavaScriptEngine()
	{
		jsManager.getManager().put("console", jsGlobalObject.getConsole());
		jsManager.getManager().put("window", jsGlobalObject);
	}

	public JavaScriptGlobalObject getJavaScriptGlobalObject()
	{
		return jsGlobalObject;
	}

	public ResultPanel getResultPanel()
	{
		return resultPanel;
	}

	public EditorPanel getEditorPanel()
	{
		return editorPanel;
	}

	public JavaScriptManager getJavaScriptManager()
	{
		return jsManager;
	}
}
