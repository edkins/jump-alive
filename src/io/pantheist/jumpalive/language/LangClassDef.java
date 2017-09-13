package io.pantheist.jumpalive.language;

import java.util.List;

import io.pantheist.jumpalive.misc.Lists;

@Rule(JumpAliveParser.RULE_classDef)
public class LangClassDef
{
	@Token("ID")
	String className;

	List<LangClassStatement> classStatements;

	@Override
	public String toString()
	{
		return String.format("class %s {\n%s\n}\n", className, Lists.join("\n", classStatements));
	}
}
