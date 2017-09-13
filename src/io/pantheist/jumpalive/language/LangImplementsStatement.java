package io.pantheist.jumpalive.language;

import java.util.List;

import io.pantheist.jumpalive.misc.Lists;

@Rule(JumpAliveParser.RULE_implementsStatement)
public class LangImplementsStatement implements LangClassStatement
{
	@Token("ID")
	String implementedType;

	List<LangStatement> statements;

	@Override
	public String toString()
	{
		return String.format("implements %s {\n%s\n}\n", implementedType, Lists.join(",", statements));
	}
}
