package com.coen6312.ocs.ui;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.coen6312.ocs.bean.ProfileBean;
import com.coen6312.ocs.listener.AdminFormListner;
import com.coen6312.ocs.listener.PatientFormListner;
import com.coen6312.ocs.service.Administrator;

public class PatientSetPassword 
{
	public JFrame loginframe;
	public JLabel useridlabel;
	public JLabel passwordlabel,confirmpasswordlbl;
	public static JTextField useridfield;
	public JPasswordField passwordfield, confirmpasswordfield;
	public JButton loginbutton;
	public JButton registerbutton;
	public PatientSetPassword(ProfileBean profilebean) 
	{
		loginframe=new JFrame();
		loginframe.setTitle("ONLINE CLINIC SYSTEM");
		loginframe.setSize(460,350);
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
		//loginframe.setLocation(250, 300);
		loginframe.setLocationRelativeTo(null);// to set frame in center of the screen
		loginframe.setLayout(null);
		loginframe.setResizable(false);
		useridlabel=new JLabel("	USER ID		");
		useridlabel.setBounds(50,80,70,25);
		useridfield=new JTextField(10);
		useridfield.setText(profilebean.getUserId());
		useridfield.setEditable(false);
		useridfield.setBounds(190,80,150,25);
		passwordlabel=new JLabel("PASSWORD");
		passwordlabel.setBounds(50,110, 70, 25);
		passwordfield=new JPasswordField(20);
	    passwordfield.setBounds(190,110, 150,25);
	    
	    confirmpasswordlbl=new JLabel("CONFIRM PASSWORD");
	    confirmpasswordlbl.setBounds(50, 140, 150, 25);
	    confirmpasswordfield=new JPasswordField(20);
	    confirmpasswordfield.setBounds(190, 140, 150, 25);
	    
		loginbutton=new JButton("LOGIN");
		loginbutton.setBounds(155, 180,150,30);
//		registerbutton=new JButton("REGISTER");
//		registerbutton.setBounds(235, 160, 150, 30);
		loginframe.add(useridlabel);
		loginframe.add(useridfield);
		loginframe.add(passwordlabel);
		loginframe.add(passwordfield);
		loginframe.add(confirmpasswordlbl);
		loginframe.add(confirmpasswordfield);
		loginframe.add(loginbutton);
	//	loginframe.add(registerbutton);
		loginframe.setVisible(true);
		//loginframe.pack();
		loginbutton.addActionListener(new PatientFormListner(this));
		//registerbutton.addActionListener(new Loginlistener(this));
		ImageIcon logo= new ImageIcon("src/Healthcare.jpg");
		Image img=logo.getImage();
		loginframe.setIconImage(img);
		loginframe.setDefaultCloseOperation(loginframe.EXIT_ON_CLOSE);
	}
}
