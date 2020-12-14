package me.djelectro.bealepapers;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Encoder {

	public void launchEncoder() {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		
		JFrame frame = new JFrame("Beale Cipher Encoder");
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
		
		
		JLabel cipherLabel = new JLabel("Encode Text:");
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
		content.add(go);
		

		JLabel resultLabel = new JLabel("Cipher Code:");
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
				String[] bruh = sourceText.getText().split(" ");
				String[] xd = cipherText.getText().split(" ");
				int b = bruh.length;
				System.out.println(b);
				
				sourceLabel.setText("Source Text: " + bruh.length + " chars");
				cipherLabel.setText("Cipher Text: " + xd.length + " chars");
				
				for(String r : cipherText.getText().split("")) {
					char letter_to_find = r.charAt(0);
					int word = 0;
					for (String y : bruh) {
						if(y.charAt(0) == letter_to_find) {
							textFinal = textFinal + (word + 1) + ",";
							break;
						}
						word++;
					}
				}
				resultText.setText(textFinal);
			}
		});
	}
}
