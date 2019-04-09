package com.coen6312.ocs.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.coen6312.ocs.listener.loginlistener;

public class UI
{
	public JFrame loginframe;
	public JLabel heading;
	public JLabel useridlabel;
	public JLabel passwordlabel;
	public static JTextField useridfield;
	  //public final JTextField useridfield;
	public JPasswordField passwordfield;
	public JButton loginbutton;
	public JButton registerbutton;
	public ImageIcon image;
	public JMenuBar bar;
	public JMenu menu;
	public UI()
	{
		
		loginframe=new JFrame();
		loginframe.getContentPane().setBackground(Color.lightGray);
		try
		{
			loginframe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/poi.jpg")))));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
		    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch(Exception e){

		}
		
		heading=new JLabel("ONLINE CLINIC SYSTEM");
		 Font font = new Font("Courier", Font.BOLD,30);
		 heading.setFont(font);
		 heading.setBounds(50,30,400,25);
		loginframe.setTitle("LOGIN");
		loginframe.setSize(480,320);
		loginframe.setLayout(null);
		loginframe.setResizable(false);
		useridlabel=new JLabel("USER ID");
		useridlabel.setBounds(110,80,70,25);
		useridfield=new JTextField(6);
		useridfield.setBounds(190,80,150,25);
		passwordlabel=new JLabel("PASSWORD");
		passwordlabel.setBounds(110,110, 70, 25);
		passwordfield=new JPasswordField(20);
		passwordfield.setBounds(190,110, 150,25);
		loginbutton=new JButton("LOGIN");
		loginbutton.setBounds(75, 160,150,30);
		registerbutton=new JButton("REGISTER");
		registerbutton.setBounds(235, 160, 150, 30);
		image=new ImageIcon("C:\\Users\\HA766519\\Desktop");
		bar=new JMenuBar();
		menu=new JMenu();
		loginframe.setJMenuBar(bar);
		menu.setIcon(image);
		bar.add(menu);
		loginframe.add(heading);
		loginframe.add(useridlabel);
		loginframe.add(useridfield);
		loginframe.add(passwordlabel);
		loginframe.add(passwordfield);
		loginframe.add(loginbutton);
		loginframe.add(registerbutton);
		loginframe.setVisible(true);
		loginframe.setDefaultCloseOperation(loginframe.EXIT_ON_CLOSE);
		loginframe.setLocationRelativeTo(null);
		loginbutton.addActionListener(new loginlistener(this));
		registerbutton.addActionListener(new loginlistener(this));
		ImageIcon logo= new ImageIcon("src/Healthcare.jpg");
		Image img=logo.getImage();
		loginframe.setIconImage(img);
	}
	public static void main(String[] args)
	{
		new UI();
	}
	
}
