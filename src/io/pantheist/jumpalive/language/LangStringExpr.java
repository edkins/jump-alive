package io.pantheist.jumpalive.language;

@Rule(JumpAliveParser.RULE_stringExpr)
public class LangStringExpr implements LangExpr
{
	@Token("STRING")
	String string;

	@Override
	public String toString()
	{
		return string;
	}
}
