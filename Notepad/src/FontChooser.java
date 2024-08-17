import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class FontChooser {
private final JDialog dialog;
private Font selectedFont;
public FontChooser(Frame parent,Font currentFont) {
	dialog = new JDialog(parent,"Choose Font",true);
	dialog.setLayout(new BorderLayout());
	dialog.setSize(400,300);
	
	JComboBox<String> fontComboBox=new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
	fontComboBox.setSelectedItem(currentFont.getFamily());
	dialog.add(fontComboBox,BorderLayout.NORTH);
	
	JComboBox<Integer> styleComboBox=new JComboBox<>(new Integer[] {Font.PLAIN, Font.BOLD, Font.ITALIC, Font.BOLD | Font.ITALIC});
	styleComboBox.setSelectedItem(currentFont.getStyle());
	dialog.add(styleComboBox,BorderLayout.CENTER);
	
	JComboBox<Integer> sizeComboBox=new JComboBox<>(new Integer[]{8, 10, 12, 14, 16, 18, 20, 24, 30, 36, 48, 72});
	sizeComboBox.setSelectedItem(currentFont.getSize());
	dialog.add(sizeComboBox,BorderLayout.SOUTH);
	
	JButton okButton=new JButton("Ok");
	okButton.addActionListener(e->{
		String fontName = (String) fontComboBox.getSelectedItem();
        int fontStyle = (Integer) styleComboBox.getSelectedItem();
        int fontSize = (Integer) sizeComboBox.getSelectedItem();
        selectedFont = new Font(fontName, fontStyle, fontSize);
        dialog.dispose();
	});
	dialog.add(okButton,BorderLayout.SOUTH);
	dialog.setLocationRelativeTo(parent);
}
public Font showDialog() {
	dialog.setVisible(true);
	return selectedFont;
}

}
