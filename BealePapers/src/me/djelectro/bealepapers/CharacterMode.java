package me.djelectro.bealepapers;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CharacterMode {

	public void launchChar() {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		
		JFrame frame = new JFrame("Beale Cipher Solver - CHARACTER MODE");
		JPanel content = new JPanel();
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(790,660);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		JTextArea sourceText = new JTextArea(10, 63);
		//sourceText.setColumns(20);
		
		JLabel sourceLabel = new JLabel("Source Text:");
		content.add(sourceLabel);
		
		
		//sourceText.setPreferredSize(new Dimension(750, 150));
		
		
		sourceText.setLineWrap(true);
		sourceText.setWrapStyleWord(true);
		JScrollPane sourceScroller = new JScrollPane(sourceText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//scroller.getVerticalScrollBar().setUnitIncrement(3);
		sourceScroller.setVisible(true);
		content.add(sourceScroller);
		
		
		JLabel cipherLabel = new JLabel("Cipher Code:");
		content.add(cipherLabel);
		
		
		
		JTextArea cipherText = new JTextArea(10, 63);
		cipherText.setLineWrap(true);
		//sourceText.setColumns(20);
		//cipherText.setPreferredSize(new Dimension(790,150));
		JScrollPane cipherScroller = new JScrollPane(cipherText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		content.add(cipherScroller);
		
		cipherText.setWrapStyleWord(true);
		JButton charFind = new JButton("Char Find");
		charFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				String goTo = JOptionPane.showInputDialog(frame,
                        "Warning! Spaces in source text will be removed!\n\nJump to Character:", null);	
				int goToo = Integer.parseInt(goTo);
				String bigCipher = sourceText.getText().replace(" ", "");
				sourceText.setText(bigCipher);
				sourceText.requestFocus();
				sourceText.setCaretPosition(goToo);
			}});
		content.add(charFind);
		frame.add(content, BorderLayout.CENTER);
		JButton go = new JButton("Go!");
		content.add(go);
		
		JLabel charLabel = new JLabel("Character/Letter Shift:");
		JTextField shifter = new JTextField("0");
		shifter.setColumns(3);
		content.add(charLabel);
		content.add(shifter);
		JLabel resultLabel = new JLabel("Result:");
		content.add(resultLabel);
		
		
		JTextArea resultText = new JTextArea(10, 63);
		JScrollPane resultScroller = new JScrollPane(resultText, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//sourceText.setColumns(20);
		resultText.setEditable(false);
		//resultText.setPreferredSize(new Dimension(790,150));
		resultText.setLineWrap(true);
		resultText.setWrapStyleWord(true);
		content.add(resultScroller);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
		
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				String textFinal = "";
				String bigCipher = cipherText.getText().replace(" ", "");
				bigCipher = bigCipher.replace("\n", "");
				String bruh = sourceText.getText().replace(" ", "");
				String[] xd = bigCipher.split(",");
				int b = bruh.length();
				System.out.println(b);
				
				sourceLabel.setText("Source Text: " + bruh.length() + " chars");
				cipherLabel.setText("Cipher Text: " + xd.length + " chars");
				
				for(String r : bigCipher.split(",")) {
					String n;
					if(Integer.parseInt(shifter.getText()) < 0) {	
							n = bruh.charAt(Math.abs(Integer.parseInt(r) - (b - (Integer.parseInt(shifter.getText()) + 1)))) + "";
							StringBuffer a = new StringBuffer(n);
							n = a.reverse().toString();
					}
					else {
							n = bruh.charAt(Integer.parseInt(r) + (Integer.parseInt(shifter.getText()) - 1)) + "";
					}
						
						textFinal = textFinal + n;
				}
				resultText.setText(textFinal);
			}
		});
		
		
		

	}

}
