package me.winter.ai;

import java.util.List;

/**
 *
 * Created by Alexander Winter on 2015-12-01.
 */
public interface User
{
	String getOriginalName();
	List<String> getAliases();

	default float getIdentityLevel(String name)
	{
		if(getOriginalName().equals(name))
			return 1;

		for(String alias : getAliases())
			if(alias.equals(name))
				return 0.5f;

		return 0;
	}
}
