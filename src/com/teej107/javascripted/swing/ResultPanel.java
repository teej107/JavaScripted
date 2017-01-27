package com.teej107.javascripted.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by tanner on 1/26/17.
 */
public class ResultPanel extends JPanel
{
	private JTextPane textPane;

	public ResultPanel()
	{
		setLayout(new BorderLayout());
		this.textPane = new JTextPane();

		textPane.setEditable(false);

		add(textPane, BorderLayout.CENTER);
	}

	public void append(String s)
	{
		textPane.setText(textPane.getText() + s);
	}

	public void setText(String s)
	{
		textPane.setText(s);
	}
}
