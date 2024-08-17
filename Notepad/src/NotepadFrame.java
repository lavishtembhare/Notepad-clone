import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotepadFrame extends JFrame {
private static final Writer Writer = null;
private final NotepadTextArea textArea;
private File currentFile;
public NotepadFrame(){
	setTitle("Notepad Clone");
	setSize(800,600);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	textArea=new NotepadTextArea();
	add(new JScrollPane(textArea), BorderLayout.CENTER);
	
	setJMenuBar(createMenuBar());
	setVisible(true);
}
private JMenuBar createMenuBar() {
	JMenuBar menuBar=new JMenuBar();
	
	JMenu fileMenu=new JMenu("File");
	menuBar.add(fileMenu);
	
	addMenuItem(fileMenu,"New",e->newFile());
	addMenuItem(fileMenu,"Open",e->openFile());
	addMenuItem(fileMenu,"Save",e->saveFile());
	addMenuItem(fileMenu,"Save As",e->saveAsFile());
	addMenuItem(fileMenu,"Exit",e->System.exit(0));
	
	JMenu editMenu=new JMenu("Edit");
	menuBar.add(editMenu);
	addMenuItem(editMenu,"Cut",e->textArea.cut());
	addMenuItem(editMenu,"Copy",e->textArea.copy());
	addMenuItem(editMenu,"Paste",e->textArea.paste());
	addMenuItem(editMenu,"Undo",e->textArea.undo());
	
	JMenu formatMenu=new JMenu("Format");
	menuBar.add(formatMenu);
	
	addMenuItem(formatMenu,"Font",e->chooseFont());
	
	return menuBar;
}

private void addMenuItem(JMenu menu, String label,ActionListener listener) {
	JMenuItem menuItem=new JMenuItem(label);
	menuItem.addActionListener(listener);
	menu.add(menuItem);
}
private void newFile() {
	textArea.setText("");
	currentFile=null;
}
private void openFile() {
	JFileChooser fileChooser=new JFileChooser();
	fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files","txt","text"));
	int option=fileChooser.showOpenDialog(this);
	if(option==JFileChooser.APPROVE_OPTION) {
		currentFile=fileChooser.getSelectedFile();
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(currentFile), StandardCharsets.UTF_8))){
			textArea.read(reader,null);
		}catch(IOException ex) {
			showError("File could not be opened");
		}
	}
}
private void saveFile() {
	if(currentFile==null) {
		saveAsFile();
	}else {
		try(BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(currentFile), StandardCharsets.UTF_8))){
			textArea.write(Writer);
		}catch(IOException ex) {
			showError("File could not be saved");
		}
	}
}
private void saveAsFile() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt", "text"));
    int option = fileChooser.showSaveDialog(this);
    if (option == JFileChooser.APPROVE_OPTION) {
        currentFile = fileChooser.getSelectedFile();
        if (!currentFile.getName().endsWith(".txt")) {
            currentFile = new File(currentFile.getAbsolutePath() + ".txt");
        }
        saveFile();
    }
}

private void chooseFont() {
    Font currentFont = textArea.getFont();
    FontChooser fontChooser = new FontChooser(this, currentFont);
    Font selectedFont = fontChooser.showDialog();
    if (selectedFont != null) {
        textArea.setFont(selectedFont);
    }
}

private void showError(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
}

}