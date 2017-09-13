package io.pantheist.jumpalive.editor;

import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class JumpAliveSourceViewerConfiguration extends SourceViewerConfiguration
{
	private ITextDoubleClickStrategy doubleClickStrategy;

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(
			final ISourceViewer sourceViewer,
			final String contentType)
	{
		if (doubleClickStrategy == null)
		{
			doubleClickStrategy = new JumpAliveDoubleClickStrategy();
		}
		return doubleClickStrategy;
	}

}
