package com.coen6312.ocs.ui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.listener.AdminFormListner;
import com.coen6312.ocs.listener.loginlistener;
import com.coen6312.ocs.service.Administrator;

public class AdminForm 
{
	public JFrame loginframe;
	public JLabel useridlabel;
	public JLabel passwordlabel,confrmpassword;
	public JTextField useridfield;
	public JPasswordField passwordfield,confrmpasswordfield;
	
	public JButton loginbutton;
	public JButton registerbutton;
	public AdminForm(CredentialsBean credentialsBean) 
	{
		loginframe=new JFrame();
		ImageIcon logo= new ImageIcon("src/Healthcare.jpg");
		Image img=logo.getImage();
		loginframe.setIconImage(img);
		loginframe.setTitle("LOGIN");
		loginframe.setSize(460,350);
		//loginframe.setLocation(250, 300);
		loginframe.setLocationRelativeTo(null);// to set frame in center of the screen
		loginframe.setLayout(null);
		loginframe.setResizable(false);
		useridlabel=new JLabel("	USER ID		");
		useridlabel.setBounds(50,80,70,25);
		useridfield=new JTextField(10);
		Administrator administrator=new Administrator();
		useridfield.setText(administrator.generateAdminId1(credentialsBean));//this id supposed to be passed to as adminui.setGetlogoutid(id);
		useridfield.setEditable(false);
		useridfield.setBounds(190,80,150,25);
		passwordlabel=new JLabel("		PASSWORD		");
		passwordlabel.setBounds(50,110, 70, 25);
		passwordfield=new JPasswordField(20);
	    passwordfield.setBounds(190,110, 150,25);
	    confrmpassword=new JLabel("CONFIRM PASSWORD");
	    confrmpassword.setBounds(50, 140, 70, 25);
	    confrmpasswordfield=new JPasswordField(20);
	    confrmpasswordfield.setBounds(190, 140, 150, 25);
		loginbutton=new JButton("LOGIN");
		loginbutton.setBounds(75, 180,150,30);
//		registerbutton=new JButton("REGISTER");
//		registerbutton.setBounds(235, 160, 150, 30);
		loginframe.add(useridlabel);
		loginframe.add(useridfield);
		loginframe.add(passwordlabel);
		loginframe.add(passwordfield);
		loginframe.add(confrmpassword);
		loginframe.add(confrmpasswordfield);
		loginframe.add(loginbutton);
	//	loginframe.add(registerbutton);
		loginframe.setVisible(true);
		loginframe.setDefaultCloseOperation(loginframe.EXIT_ON_CLOSE);
		//loginframe.pack();
		loginbutton.addActionListener(new AdminFormListner(this));
		//registerbutton.addActionListener(new Loginlistener(this));
	}
}
