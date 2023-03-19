package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_decomp.compressor;
import comp_decomp.decompressor;


public class AppFrame extends JFrame implements ActionListener {
	
	JButton compressButton;
	JButton decompressButton;
	
	AppFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		compressButton = new JButton("Select file to compress");
		compressButton.setBounds(20, 100, 200, 30);
		compressButton.addActionListener(this);
		
		decompressButton = new JButton("Select file to decompress");
		decompressButton.setBounds(250, 100, 200, 30);
		decompressButton.addActionListener(this);
		
		this.add(compressButton);
		this.add(decompressButton);
		this.setSize(1000, 500);
		this.getContentPane().setBackground(Color.red);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == compressButton) {
			JFileChooser filechooser = new JFileChooser();
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
				try {
					compressor.method(file);
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,ee.toString());
				}
			}
		}
		if(e.getSource() == decompressButton) {
			JFileChooser filechooser = new JFileChooser();
			int response = filechooser.showSaveDialog(null);
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(filechooser.getSelectedFile().getAbsolutePath());
				System.out.println(file);
				try {
					decompressor.method(file);
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,ee.toString());
				}
			}
		}
	}
}
