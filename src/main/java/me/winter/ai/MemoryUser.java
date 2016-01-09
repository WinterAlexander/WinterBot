package me.winter.ai;

import java.util.Collections;
import java.util.List;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public class MemoryUser implements User
{
	private String name;

	public MemoryUser(String name)
	{
		this.name = name;
	}

	@Override
	public String getOriginalName()
	{
		return name;
	}

	@Override
	public List<String> getAliases()
	{
		return Collections.emptyList();
	}
}
