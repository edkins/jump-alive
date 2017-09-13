package io.pantheist.jumpalive.language;

@Rule(JumpAliveParser.RULE_returnStatement)
public class LangReturnStatement implements LangStatement
{
	LangExpr returnExpr;

	@Override
	public String toString()
	{
		return String.format("return %s;", returnExpr);
	}
}
