package io.pantheist.jumpalive.misc;

import java.util.List;
import java.util.stream.Collectors;

public class Lists
{
	public static String join(final String delim, final List<?> list)
	{
		return list.stream().map(Object::toString).collect(Collectors.joining(delim));
	}
}
