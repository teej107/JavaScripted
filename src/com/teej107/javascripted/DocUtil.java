package com.teej107.javascripted;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by teej107 on 1/15/2017.
 */
public class DocUtil
{
	private static Pattern RGB_COLOR = Pattern.compile("rgb *\\( *([0-9]+), *([0-9]+), *([0-9]+) *\\)");

	public static Color parseColor(String s)
	{
		if(s.startsWith("#"))
		{
			if(s.length() == 4)
			{
				StringBuilder sb = new StringBuilder("#");
				for(char c : s.substring(1).toCharArray())
				{
					sb.append(c).append(c);
				}
				s = sb.toString();
			}
			return Color.decode(s);
		}
		else if(s.toLowerCase().startsWith("rgb"))
		{
			Matcher m = RGB_COLOR.matcher(s);
			if (m.matches())
				return new Color(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)), Integer.parseInt(m.group(3)));
		}
		return Color.BLACK;
	}
}
