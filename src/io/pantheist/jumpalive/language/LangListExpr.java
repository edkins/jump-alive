package io.pantheist.jumpalive.language;

import java.util.List;

import io.pantheist.jumpalive.misc.Lists;

@Rule(JumpAliveParser.RULE_listExpr)
public class LangListExpr implements LangExpr
{
	List<LangExpr> exprs;

	@Override
	public String toString()
	{
		return String.format("[%s]", Lists.join(",", exprs));
	}
}
