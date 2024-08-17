import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;

public class NotepadTextArea extends JTextArea{
private final UndoManager undoManager;
public NotepadTextArea() {
	setLineWrap(true);
	setWrapStyleWord(true);
	
	undoManager=new UndoManager();
	getDocument().addUndoableEditListener(undoManager);
}
public void undo() {
	if(undoManager.canUndo()) {
		undoManager.undo();
	}
}
}
