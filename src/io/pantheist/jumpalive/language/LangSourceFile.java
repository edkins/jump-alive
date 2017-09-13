package io.pantheist.jumpalive.language;

@Rule(JumpAliveParser.RULE_sourceFile)
public class LangSourceFile
{
	LangClassDef classDef;

	@Override
	public String toString()
	{
		return classDef.toString();
	}
}
