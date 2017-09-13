package io.pantheist.jumpalive.language;

import java.util.stream.Collectors;

import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import io.pantheist.jumpalive.language.JumpAliveParser.ClassDefContext;
import io.pantheist.jumpalive.language.JumpAliveParser.ClassStatementContext;
import io.pantheist.jumpalive.language.JumpAliveParser.EmptyListExprContext;
import io.pantheist.jumpalive.language.JumpAliveParser.ExprContext;
import io.pantheist.jumpalive.language.JumpAliveParser.ImplementsStatementContext;
import io.pantheist.jumpalive.language.JumpAliveParser.ListExprContext;
import io.pantheist.jumpalive.language.JumpAliveParser.ReturnStatementContext;
import io.pantheist.jumpalive.language.JumpAliveParser.SourceFileContext;
import io.pantheist.jumpalive.language.JumpAliveParser.StatementContext;
import io.pantheist.jumpalive.language.JumpAliveParser.StringExprContext;

public class Processor
{
	public LangSourceFile process(final CharStream text)
	{
		final JumpAliveLexer lexer = new JumpAliveLexer(text);
		final TokenStream tokenStream = new CommonTokenStream(lexer);
		final JumpAliveParser parser = new JumpAliveParser(tokenStream);
		parser.setErrorHandler(new BailErrorStrategy());

		final SourceFileContext sourceFile = parser.sourceFile();
		return convert(sourceFile);
	}

	private LangSourceFile convert(final SourceFileContext sourceFile)
	{
		final LangSourceFile result = new LangSourceFile();
		result.classDef = convert(sourceFile.classDef());
		return result;
	}

	private LangClassDef convert(final ClassDefContext classDef)
	{
		final LangClassDef result = new LangClassDef();
		result.className = classDef.ID().getText();
		result.classStatements = classDef.classStatement()
				.stream()
				.map(this::convert)
				.collect(Collectors.toList());
		return result;
	}

	private LangClassStatement convert(final ClassStatementContext classStatement)
	{
		return convert(classStatement.implementsStatement());
	}

	private LangImplementsStatement convert(final ImplementsStatementContext implementsStatement)
	{
		final LangImplementsStatement result = new LangImplementsStatement();
		result.implementedType = implementsStatement.ID().getText();
		result.statements = implementsStatement.statement()
				.stream()
				.map(this::convert)
				.collect(Collectors.toList());
		return result;
	}

	private LangStatement convert(final StatementContext statement)
	{
		return convert(statement.returnStatement());
	}

	private LangReturnStatement convert(final ReturnStatementContext returnStatement)
	{
		final LangReturnStatement result = new LangReturnStatement();
		result.returnExpr = convert(returnStatement.expr());
		return result;
	}

	private LangExpr convert(final ExprContext expr)
	{
		if (expr.emptyListExpr() != null)
		{
			return convert(expr.emptyListExpr());
		}
		else if (expr.listExpr() != null)
		{
			return convert(expr.listExpr());
		}
		else
		{
			return convert(expr.stringExpr());
		}
	}

	private LangStringExpr convert(final StringExprContext stringExpr)
	{
		final LangStringExpr result = new LangStringExpr();
		result.string = stringExpr.STRING().getText();
		return result;
	}

	private LangListExpr convert(final ListExprContext listExpr)
	{
		final LangListExpr result = new LangListExpr();
		result.exprs = listExpr.expr()
				.stream()
				.map(this::convert)
				.collect(Collectors.toList());
		//result.exprs = Collections.singletonList(convert(listExpr.expr()));
		return result;
	}

	private LangEmptyListExpr convert(final EmptyListExprContext emptyListExpr)
	{
		return new LangEmptyListExpr();
	}
}
