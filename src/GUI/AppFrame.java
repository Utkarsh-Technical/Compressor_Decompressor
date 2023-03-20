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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class AppFrame extends JFrame implements ActionListener {

    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
    	this.setTitle("Compressor and Decompressor");
        this.setSize(800,400);
        this.setLocation(400,200);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressButton = new JButton("SELECT TO COMPRESS");
        compressButton.setBounds(80,100,200,50);
        compressButton.addActionListener(this);

        decompressButton = new JButton("SELECT TO DECOMPRESS");
        decompressButton.setBounds(500,100,200,50);
        decompressButton.addActionListener(this);


        this.add(compressButton);
        this.add(decompressButton);
        this.getContentPane().setBackground(Color.decode("#E3B778"));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println("Compresser "+file);
                try{
                    compressor.method(file);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }

        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println("DeCompresser "+file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }
}