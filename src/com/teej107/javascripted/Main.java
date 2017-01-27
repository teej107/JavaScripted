package com.teej107.javascripted;

import com.teej107.javascripted.swing.ApplicationFrame;

import javax.swing.*;

/**
 * Created by teej107 on 1/14/2017.
 */
public class Main
{
	public static void main(String[] args)
	{
		if (args.length > 0)
		{

		}
		else
		{
			try
			{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			createAndShowGUI();
		}
	}

	private static void createAndShowGUI()
	{
		SwingUtilities.invokeLater(() -> new ApplicationFrame().setVisible(true));
	}
}
