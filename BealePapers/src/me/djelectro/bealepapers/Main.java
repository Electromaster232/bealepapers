package me.djelectro.bealepapers;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import me.djelectro.bealepapers.Encoder;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		
		JFrame frame = new JFrame("Beale Cipher Solver");
		JPanel content = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		frame.add(content, BorderLayout.CENTER);
		JButton go = new JButton("Go!");
		JButton go2 = new JButton("Open Encoder >>");
		go2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				new Encoder().launchEncoder();
			}
		});
		content.add(go2);
		JButton go3 = new JButton("Launch Char >>");
		go3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				new CharacterMode().launchChar();
			}
		});
		content.add(go3);
		content.add(go);
		
		JLabel charLabel = new JLabel("Char/Word Shift:");
		JTextField shifter = new JTextField("0");
		shifter.setColumns(3);
		content.add(charLabel);
		content.add(shifter);
		JLabel letterLabel = new JLabel("Char/Letter Shift:");
		JTextField letterShifter = new JTextField("0");
		letterShifter.setColumns(3);
		content.add(letterLabel);
		content.add(letterShifter);
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
		
		frame.setVisible(true);
		
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				String textFinal = "";
				String bigCipher = cipherText.getText().replace(" ", "");
				bigCipher = bigCipher.replace("\n", "");
				String[] bruh = sourceText.getText().split(" ");
				String[] xd = bigCipher.split(",");
				int b = bruh.length;
				System.out.println(b);
				
				int megaOof = Integer.parseInt(letterShifter.getText());
				sourceLabel.setText("Source Text: " + bruh.length + " chars");
				cipherLabel.setText("Cipher Text: " + xd.length + " chars");
				
				for(String r : bigCipher.split(",")) {
					String n;
					if(Integer.parseInt(shifter.getText()) < 0) {
							n = bruh[Math.abs((Integer.parseInt(r) - Integer.parseInt(shifter.getText())-1) % b)].charAt(megaOof) + "";
					}
					else {
							n = bruh[Math.abs((Integer.parseInt(r) + Integer.parseInt(shifter.getText())-1) % b)].charAt(megaOof) + "";
					}
						
						textFinal = textFinal + n.charAt(0);
				}
				resultText.setText(textFinal);
			}
		});
		
		
		

	}

}
