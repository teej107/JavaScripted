package com.teej107.javascripted.swing;

import javax.swing.*;

/**
 * Created by teej107 on 1/14/2017.
 */
public class ApplicationFrame extends JFrame
{
	public ApplicationFrame()
	{
		setContentPane(new EditorPanel());

		setSize(800, 600);
		setLocationByPlatform(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
