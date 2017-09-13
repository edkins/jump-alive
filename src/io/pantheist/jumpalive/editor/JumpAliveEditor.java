package io.pantheist.jumpalive.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class JumpAliveEditor extends TextEditor
{
	public JumpAliveEditor()
	{
		setSourceViewerConfiguration(new JumpAliveSourceViewerConfiguration());
	}
}
