package io.pantheist.jumpalive.editor;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextViewer;

import io.pantheist.jumpalive.language.LangSourceFile;
import io.pantheist.jumpalive.language.Processor;

public class JumpAliveDoubleClickStrategy implements ITextDoubleClickStrategy
{

	@Override
	public void doubleClicked(final ITextViewer viewer)
	{
		final int pos = viewer.getSelectedRange().x;

		try
		{
			System.out.println(String.format("You double clicked %s ", viewer.getDocument().getChar(pos)));
		}
		catch (final BadLocationException e)
		{
			System.out.println("You double clicked a bad location");
		}

		final DocumentCharStream charStream = new DocumentCharStream(viewer.getDocument());
		final LangSourceFile sourceFile = new Processor().process(charStream);
		System.out.println(sourceFile);
	}

}
