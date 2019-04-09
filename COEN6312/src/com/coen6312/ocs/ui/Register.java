package com.coen6312.ocs.ui;

import java.awt.Font;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.coen6312.ocs.listener.registerlistener;

public class Register {
		public JFrame registerframe;
		public JLabel useridlabel;
		public JLabel firstnamelabel;
		public JLabel lastnamelabel;
		public JLabel dateofbirthlabel;
		public JLabel genderlabel;
		public JLabel streetlabel;
		public JLabel locationlabel;
		public JLabel citylabel;
		public JLabel statelabel;
		public JLabel postalcode;
		public JLabel mobilenolabel;
		public JLabel emailidlabel;
		public static JTextField useridfield;
		public JTextField firstnamefield;
		public JTextField lastnamefield;
		public JComboBox day;
		public JComboBox month;
		public JComboBox year;
		public JRadioButton malebutton;
		public JRadioButton femalebutton;
		public ButtonGroup group;
		public JTextArea streetarea;
		public JTextField locationfield;
		public JTextField cityfield;
		public JTextField statefield;
		public JTextField postalcodefield;
		public JTextField mobilenofield;
		public JTextField emailidfield;
		public JButton submitbutton;
		public JLabel signUpHeadingLabel;
	
	public Register()
	{
	registerframe=new JFrame("REGISTER");
	
	registerframe.setSize(600, 720);
	registerframe.setResizable(false);
	registerframe.setLayout(null);
	try
	{
		registerframe.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src/poi.jpg")))));
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
	


	
	signUpHeadingLabel=new JLabel("Sign Up Form");
	signUpHeadingLabel.setFont(new Font("Serif", Font.BOLD,25));
	useridlabel=new JLabel("USER ID");
	useridfield=new JTextField(6);
	useridfield.setEditable(false);
	firstnamelabel=new JLabel("FIRST NAME");
	firstnamefield=new JTextField(15);
	lastnamelabel=new JLabel("LAST NAME");
	lastnamefield=new JTextField(15);
	dateofbirthlabel=new JLabel("DOB");
	submitbutton=new JButton("SUBMIT");
	submitbutton.setFont(new Font("Serif", Font.BOLD,15));
	day=new JComboBox();
	day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
	month=new JComboBox();
	month.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
	year=new JComboBox();
	year.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"}));
	genderlabel=new JLabel("GENDER");
	group=new ButtonGroup();
	malebutton=new JRadioButton("Male");
	femalebutton=new JRadioButton("Female");
	streetlabel=new JLabel("STREET");
	streetarea=new JTextArea();
	locationlabel=new JLabel("LOCATION");
	locationfield=new JTextField(15);
	citylabel=new JLabel("CITY");
	cityfield=new JTextField(15);
	statelabel=new JLabel("STATE");
	statefield=new JTextField(15);
	postalcode=new JLabel("POSTAL CODE");
	postalcodefield=new JTextField(10);
	mobilenolabel=new JLabel("MOBILE NO.");
	mobilenofield=new JTextField(10);
	emailidlabel=new JLabel("EMAIL");
	emailidfield=new JTextField(10);
	registerframe.add(signUpHeadingLabel);
	signUpHeadingLabel.setBounds(215,1, 200, 80);
	//registerframe.add(useridlabel);
	//useridlabel.setBounds(110,80,70,25);
	//registerframe.add(useridfield);
	//useridfield.setBounds(290,80,150,25);
	registerframe.add(firstnamelabel);
	firstnamelabel.setBounds(110,120,70,25);
	registerframe.add(firstnamefield);
	firstnamefield.setBounds(290,120,150,25);						firstnamefield.setOpaque(false);
	registerframe.add(lastnamelabel);
	lastnamelabel.setBounds(110,160,70,25);
	registerframe.add(lastnamefield);								lastnamefield.setOpaque(false);
	lastnamefield.setBounds(290,160,150,25);
	registerframe.add(dateofbirthlabel);
	dateofbirthlabel.setBounds(110,200,70,25);
	registerframe.add(day);
	day.setBounds(290,200, 50, 25);
	registerframe.add(month);
	month.setBounds(370,200, 55, 25);
	registerframe.add(year);
	year.setBounds(450,200, 65, 25);
	registerframe.add(genderlabel);
	genderlabel.setBounds(110,240,70,25);
	group.add(malebutton);											malebutton.setOpaque(false);
	group.add(femalebutton);										femalebutton.setOpaque(false);
	registerframe.add(malebutton);
	malebutton.setBounds(290,240, 60, 25);
	registerframe.add(femalebutton);
	femalebutton.setBounds(370,240, 90, 25);
	registerframe.add(streetlabel);
	streetlabel.setBounds(110,280,70,25);
	registerframe.add(streetarea);
	streetarea.setBounds(290,278, 200, 32);							streetarea.setOpaque(false);
	registerframe.add(locationlabel);
	locationlabel.setBounds(110,320,70,25);
	registerframe.add(locationfield);
	locationfield.setBounds(290,320, 150, 25);						locationfield.setOpaque(false);
	registerframe.add(citylabel);
	citylabel.setBounds(110,360,70,25);								cityfield.setOpaque(false);
	registerframe.add(cityfield);
	cityfield.setBounds(290,360, 150, 25);
	registerframe.add(statelabel);
	statelabel.setBounds(110,400,70,25);
	registerframe.add(statefield);									statefield.setOpaque(false);
	statefield.setBounds(290,400, 150, 25);
	registerframe.add(postalcode);
	postalcode.setBounds(110,440,100,25);
	registerframe.add(postalcodefield);								postalcodefield.setOpaque(false);
	postalcodefield.setBounds(290,440, 150, 25);
	registerframe.add(mobilenolabel);
	mobilenolabel.setBounds(110,480,70,25);
	registerframe.add(mobilenofield);								mobilenofield.setOpaque(false);
	mobilenofield.setBounds(290,480, 150, 25);
	registerframe.add(emailidlabel);
	emailidlabel.setBounds(110,520,70,25);
	registerframe.add(emailidfield);								emailidfield.setOpaque(false);
	emailidfield.setBounds(290,520, 150, 25);
	registerframe.add(submitbutton);								submitbutton.setOpaque(false);
	submitbutton.setBounds(215,600 ,125 ,25);
	submitbutton.addActionListener(new registerlistener(this));
	registerframe.setLocationRelativeTo(null);
	registerframe.setVisible(true);
	ImageIcon logo= new ImageIcon("src/Healthcare.jpg");
	Image img=logo.getImage();
	registerframe.setIconImage(img);
	//registerframe.setContentPane(new JLabel(new ImageIcon("src/login.jpg")));
	
	registerframe.setDefaultCloseOperation(registerframe.EXIT_ON_CLOSE);}
	
	
	
		
}
