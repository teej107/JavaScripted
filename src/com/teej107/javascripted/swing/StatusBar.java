package com.teej107.javascripted.swing;

import com.teej107.javascripted.JavaScriptManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.peer.MouseInfoPeer;

/**
 * Created by tanner on 1/26/17.
 */
public class StatusBar extends JPanel implements MouseListener
{
	private JButton run;
	private EditorPanel editorPanel;
	private ResultPanel resultPanel;
	private JavaScriptManager jsManager;

	public StatusBar(ApplicationPanel panel)
	{
		this.editorPanel = panel.getEditorPanel();
		this.resultPanel = panel.getResultPanel();
		this.jsManager = panel.getJavaScriptManager();
		this.run = new JButton("Run");
		run.addMouseListener(this);

		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		add(run, BorderLayout.LINE_END);
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent)
	{
		resultPanel.setText(null);
		resultPanel.append(jsManager.eval(editorPanel.getText()));
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent)
	{

	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent)
	{

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent)
	{

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent)
	{

	}
}
