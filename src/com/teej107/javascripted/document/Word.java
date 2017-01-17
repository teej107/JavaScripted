package com.teej107.javascripted.document;

/**
 * Created by teej107 on 1/15/2017.
 */
public class Word
{
	private String text;
	private int offset;

	public Word(String text, int offset)
	{
		this.text = text;
		this.offset = offset;
	}

	public int getOffset()
	{
		return offset;
	}

	@Override
	public String toString()
	{
		return text;
	}
}
