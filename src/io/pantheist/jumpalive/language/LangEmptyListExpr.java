package io.pantheist.jumpalive.language;

@Rule(JumpAliveParser.RULE_emptyListExpr)
public class LangEmptyListExpr implements LangExpr
{
	@Override
	public String toString()
	{
		return "[]";
	}
}
