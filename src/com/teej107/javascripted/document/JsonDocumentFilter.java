package com.teej107.javascripted.document;

import com.teej107.javascripted.swing.EditorPanel;

import javax.swing.text.*;

/**
 * Created by teej107 on 1/15/2017.
 */
public class JsonDocumentFilter extends DocumentFilter
{
	private EditorPanel panel;

	public JsonDocumentFilter(EditorPanel panel)
	{
		this.panel = panel;
	}

	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException
	{
		super.remove(fb, offset, length);

		format((StyledDocument) fb.getDocument(), offset, false);
	}

	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException
	{
		System.out.println("JsonDocumentFilter.insertString");
		super.insertString(fb, offset, string, attr);
	}

	@Override
	public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attr) throws BadLocationException
	{
		super.replace(fb, offset, length, string, attr);
		if(string.length() == 1)
		{
			format((StyledDocument) fb.getDocument(), offset, true);
		}
		else
		{
			int end = fb.getDocument().getLength();
			int current = offset;
			while(current < end)
			{
				Word word = panel.getWordAt(current);
				current = word.getOffset() + word.toString().length() + 1;

				format(word, (StyledDocument) fb.getDocument(), true);
			}
		}
	}

	private void format(Word word, StyledDocument document, boolean style) throws BadLocationException
	{
		Style st = document.getStyle(word.toString());
		if(st == null)
		{
			document.setCharacterAttributes(word.getOffset(), word.toString().length(),
					StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE), true);
		}
		else if(style)
		{
			document.setCharacterAttributes(word.getOffset(), word.toString().length(), st, true);
		}
	}

	private void format(StyledDocument document, int offset, boolean style) throws BadLocationException
	{
		Word word = panel.getWordAt(offset);
		format(word, document, style);
	}
}
