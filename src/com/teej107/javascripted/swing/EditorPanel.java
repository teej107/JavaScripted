package com.teej107.javascripted.swing;

import com.teej107.javascripted.DocUtil;
import com.teej107.javascripted.document.JsonDocumentFilter;
import com.teej107.javascripted.document.Word;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by teej107 on 1/14/2017.
 */
public class EditorPanel extends JPanel
{
	private JTextPane textPane;
	private Map<String, Object> json;
	private DefaultStyledDocument document;

	public EditorPanel()
	{
		setLayout(new BorderLayout());
		this.document = new DefaultStyledDocument();
		this.textPane = new JTextPane(document);

		//document.setDocumentFilter(new JsonDocumentFilter(this));
		add(textPane, BorderLayout.CENTER);
		try
		{
			json = (Map<String, Object>) new JSONParser()
					.parse(new InputStreamReader(getClass().getResourceAsStream("/assets/keywords.json")));
			loadStyles(json, false);
		}
		catch (Exception e)
		{
			json = new HashMap<>();
			e.printStackTrace();
		}
	}

	public void loadStyles(Map<String, Object> json, boolean reset)
	{
		if (reset)
		{
			Enumeration<?> styles = document.getStyleNames();
			while (styles.hasMoreElements())
			{
				document.removeStyle(styles.nextElement().toString());
			}
		}

		for (Map.Entry<String, Object> entry : json.entrySet())
		{
			if (entry.getValue() instanceof String)
			{
				Style style = textPane.addStyle(entry.getKey(), null);
				StyleConstants.setForeground(style, DocUtil.parseColor(entry.getValue().toString()));
			}
			else if (entry.getValue() instanceof Map)
			{
				loadSpecificStyles(entry.getKey(), (Map<String, Object>) entry.getValue());
			}
		}
	}

	private void loadSpecificStyles(String key, Map<String, Object> json)
	{
		Style style = textPane.addStyle(key, null);
		for (Map.Entry<String, Object> entry : json.entrySet())
		{
			switch (entry.getKey())
			{
				case "color":
					StyleConstants.setForeground(style, DocUtil.parseColor(entry.getValue().toString()));
					break;
				case "bold":
					StyleConstants.setBold(style, Boolean.parseBoolean(entry.getValue().toString()));
					break;
				case "italic":
					StyleConstants.setItalic(style, Boolean.parseBoolean(entry.getValue().toString()));
					break;
				case "font-size":
					StyleConstants.setFontSize(style, Integer.parseInt(entry.getValue().toString()));
					break;
				case "font-family":
					StyleConstants.setFontFamily(style, entry.getValue().toString());
					break;
				case "underline":
					StyleConstants.setUnderline(style, Boolean.parseBoolean(entry.getValue().toString()));
					break;
				case "highlight":
					StyleConstants.setBackground(style, DocUtil.parseColor(entry.getValue().toString()));
					break;
			}
		}
	}

	public Word getWordAt(int offset) throws BadLocationException
	{
		Document doc = textPane.getDocument();
		int wordStart = Utilities.getWordStart(textPane, offset);
		int wordEnd = Utilities.getWordEnd(textPane, offset);
		return new Word(doc.getText(wordStart, wordEnd - wordStart), wordStart);
	}

	public String getText()
	{
		return textPane.getText();
	}
}
