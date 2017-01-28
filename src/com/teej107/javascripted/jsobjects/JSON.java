package com.teej107.javascripted.jsobjects;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import java.util.*;

/**
 * Created by tanner on 1/28/17.
 */
public class JSON implements Map<String, Object>
{
	private ScriptObjectMirror nashornObject;

	public JSON(ScriptObjectMirror object)
	{
		this.nashornObject = object;
	}

	@Override
	public int size()
	{
		return nashornObject.size();
	}

	@Override
	public boolean isEmpty()
	{
		return nashornObject.size() > 0;
	}

	@Override
	public boolean containsKey(Object o)
	{
		return nashornObject.containsKey(o);
	}

	@Override
	public boolean containsValue(Object o)
	{
		return nashornObject.containsValue(o);
	}

	@Override
	public Object get(Object o)
	{
		return nashornObject.get(o);
	}

	@Override
	public Object put(String s, Object o)
	{
		return nashornObject.put(s, o);
	}

	@Override
	public Object remove(Object o)
	{
		return nashornObject.remove(o);
	}

	@Override
	public void putAll(Map<? extends String, ?> map)
	{
		nashornObject.putAll(map);
	}

	@Override
	public void clear()
	{
		nashornObject.clear();
	}

	@Override
	public Set<String> keySet()
	{
		return nashornObject.keySet();
	}

	@Override
	public Collection<Object> values()
	{
		return nashornObject.values();
	}

	@Override
	public Set<Entry<String, Object>> entrySet()
	{
		return nashornObject.entrySet();
	}

	@Override
	public int hashCode()
	{
		return nashornObject.hashCode();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("{");
		for(Entry<String, Object> entrySet : nashornObject.entrySet())
		{
			sb.append("\n\t").append(entrySet.getKey()).append(": ").append(entrySet.getValue()).append(',');
		}
		sb.setLength(sb.length() - 1);
		sb.append("\n}");
		return sb.toString();
	}
}
