package com.coen6312.ocs.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.coen6312.ocs.listener.adminlistener;

public class Adminui 
{
	public JFrame adminframe;
	public JPanel mainpanel;
	public JPanel newpanel;
	public JLabel listofdoctors;
	//public JPanel deleteadminpanel;
	public JLabel headingadd;
	public JMenuBar adminbar;
	public JMenu addadmin;
	public JMenu viewadmin;
	public JMenu deleteadmin;
	public JMenu modifyadmin;
	public JMenu logoutadmin;
	public JMenu updateadmin;
	public JMenu viewpatientbydate;
	public JMenu confirmappointment;
	public JLabel doctorid;
	public JLabel doctorname;
	public JLabel dateofbirth;
	public JLabel dateofjoining;
	public JLabel gender;
	public JLabel qualification;
	public JLabel specialization;
	public JLabel yearsofexperience;
	public JLabel street;
	public JLabel location;
	public JLabel city;
	public JLabel state;
	public JLabel pincode;
	public JLabel contactnumber;
	public JLabel emailid;
	public JLabel id;
	public JTextField idfield1;
	public JTextField namefield;
	public JTextField qualificationfield;
	public JComboBox specializationbox;
	public JTextField yearsofexperiencefield;
	public JTextArea streetarea;
	public JTextField locationfield;
	public JTextField cityfield;
	public JTextField statefield;
	public JTextField pincodefield;
	public JTextField contactnumberfield;
	public JTextField emailidfield;
	public JTextField idfield;
	public JRadioButton malebutton;
	public JRadioButton femalebutton;
	public ButtonGroup group;
	public JComboBox day;
	public JComboBox month;
	public JComboBox year;
	public JComboBox dayofjoining;
	public JComboBox monthofjoining;
	public JComboBox yearofjoining;
	public JButton addbutton;
	public JButton deletebutton;
	public JButton showbutton;
	public JButton updatebutton;
	public JTable viewtable;
	public JScrollPane tablepane;
	public JTextArea logoutfield;
	public String getlogoutid;
	//-------------------------
	public JLabel headingdelete;
	public JLabel heading;
	public JLabel idlabel;
	public JLabel oldplabel;
	public JLabel newplabel;
	public JLabel matchpasslabel;
	public JTextField idfieldpass;
	public JPasswordField oldidfield;
	public JPasswordField newidfield;
	public JPasswordField matchidfield;
	public JButton changebutton;
	//---------------------------------
	public JLabel headingmodify;
	public JLabel modifydoctorid;
	public JLabel modifydoctorname;
	public JLabel modifydateofbirth;
	public JLabel modifydateofjoining;
	public JLabel modifygender;
	public JLabel modifyqualification;
	public JLabel modifyspecialization;
	public JLabel modifyyearsofexperience;
	public JLabel modifystreet;
	public JLabel modifylocation;
	public JLabel modifycity;
	public JLabel modifystate;
	public JLabel modifypincode;
	public JLabel modifycontactnumber;
	public JLabel modifyemailid;
	public JLabel modifyid;
	public JTextField modifyidfield1;
	public JTextField modifynamefield;
	public JTextField modifyqualificationfield;
	public JComboBox modifyspecializationbox;
	public JTextField modifyyearsofexperiencefield;
	public JTextArea modifystreetarea;
	public JTextField modifylocationfield;
	public JTextField modifycityfield;
	public JTextField modifystatefield;
	public JTextField modifypincodefield;
	public JTextField modifycontactnumberfield;
	public JTextField modifyemailidfield;
	public JTextField modifyidfield;
	public JComboBox modifyidcombo;
	public JRadioButton modifymalebutton;
	public JRadioButton modifyfemalebutton;
	public ButtonGroup modifygroup;
	public JComboBox modifyday;
	public JComboBox modifymonth;
	public JComboBox modifyyear;
	public JComboBox modifydayofjoining;
	public JComboBox modifymonthofjoining;
	public JComboBox modifyyearofjoining;
	//------------------------------------
	public JLabel headingtime;
	public JScrollPane appointmentpane;
	public JTable appointmentdatetabel;
	public JLabel viewdatelabel;
	public JComboBox viewpatientdate;
	public JComboBox viewpatientmonth;
	public JComboBox viewpatientyear;
	public JButton viewpatientbydatebutton;
	
	//--------
	public JLabel headingconfirm;
	public JLabel appointmentidtoconfirm;
	public JComboBox appointmentfieldtoconfirm;
	public JLabel statustoconfirm;
	public JTextField statusfieldtoconfirm;
	public JButton confirmbutton;
	
	//----------------------------------
	public JMenu addDocSchedule;
	public JMenu modifyDocSchedule;
		public JLabel addSchIDlabel;
		public JTextField addSchIDtxtfield;
		public JLabel addDocIDlabel;
		public JComboBox addDocIDcombo;
		public JLabel addAvalbleDaysLbl;
		public JCheckBox check;
		public JCheckBox mondaychk;
		public JCheckBox tuesdaychk;
		public JCheckBox wednsdaychk;
		public JCheckBox thrusdaychk;
		public JCheckBox fridaychk;
		public JLabel Headingschd;
		public JLabel slotlbl;
		public JComboBox combs;
		public JButton submitbtnsch;
		//----------------------------------------
		public JLabel modifySchIDlabel;
		public JTextField modifySchIDtxtfield;
		public JLabel modifyDocIDlabel;
		public JComboBox modifyDocIDcombo;
		public JLabel modifyAvalbleDaysLbl;
		public JCheckBox modifycheck;
		public JCheckBox modifymondaychk;
		public JCheckBox modifytuesdaychk;
		public JCheckBox modifywednsdaychk;
		public JCheckBox modifythrusdaychk;
		public JCheckBox modifyfridaychk;
		public JLabel modifyHeadingschd;
		public JLabel modifyslotlbl;
		public JComboBox modifycombs;
		public JButton modifysubmitbtnsch;
		public JComboBox delDocIDcombo;
		public JComboBox delDoctorIDcombo;
	
		public String getGetlogoutid() 
		{
			return getlogoutid;
		}



	public void setGetlogoutid(String getlogoutid) {
		this.getlogoutid = getlogoutid;
	}

	public Adminui(){
		adminframe=new JFrame("ADMIN FRAME");
		mainpanel=new JPanel();
//		/mainpanel.setS
		//deleteadminpanel=new JPanel();
		ImageIcon logo= new ImageIcon("src/Healthcare.jpg");
		Image img=logo.getImage();
		adminframe.setIconImage(img);
		adminframe.setResizable(false);
		adminframe.setSize(1080,720);
		adminframe.setVisible(true);
		adminbar=new JMenuBar();
		adminframe.setJMenuBar(adminbar);
		addadmin=new JMenu("Add Doctor");
		deleteadmin=new JMenu("Delete Doctor");
		modifyadmin=new JMenu("Modify Doctor");
		viewadmin=new JMenu("View Doctors");
		logoutadmin=new JMenu("Logout");
		updateadmin=new JMenu("Update Password");
		viewpatientbydate=new JMenu("View Patients By Date");
		confirmappointment=new JMenu("Confirm Appointment");
		addDocSchedule=new JMenu("Add Doctor Schedule");
		modifyDocSchedule=new JMenu("Modify Doctor Schedule");
		adminbar.add(addadmin);
		adminbar.add(deleteadmin);
		adminbar.add(modifyadmin);
		adminbar.add(viewadmin);
		adminbar.add(updateadmin);
		adminbar.add(viewpatientbydate);
		adminbar.add(viewpatientbydate);
		adminbar.add(confirmappointment);
		adminbar.add(addDocSchedule);
		adminbar.add(modifyDocSchedule);
		adminbar.add(logoutadmin);
		adminframe.setVisible(true);
		adminframe.setDefaultCloseOperation(adminframe.EXIT_ON_CLOSE);
		addadmin.addMenuListener(new adminlistener(this));
		deleteadmin.addMenuListener(new adminlistener(this));
		modifyadmin.addMenuListener(new adminlistener(this));
		viewadmin.addMenuListener(new adminlistener(this));
		updateadmin.addMenuListener(new adminlistener(this));
		logoutadmin.addMenuListener(new adminlistener(this));
		viewpatientbydate.addMenuListener(new adminlistener(this));
		confirmappointment.addMenuListener(new adminlistener(this));
		addDocSchedule.addMenuListener(new adminlistener(this));
		modifyDocSchedule.addMenuListener(new adminlistener(this));
	}
	
	public void addadmin(){
		//adminframe.setLayout(null);
		String[] arr=new String[100];
		int j=1920;
		for(int i=0;i<arr.length;i++){
			arr[i]=String.valueOf(j);
			j++;
		}
		mainpanel.setLayout(null);
		headingadd=new JLabel("ADD DOCTOR DETAILS");
		 Font font = new Font("Courier", Font.BOLD,30);
		 headingadd.setFont(font);
		 headingadd.setBounds(180,30,450,25);
		 mainpanel.add(headingadd);
		group=new ButtonGroup();
		malebutton=new JRadioButton("Male");
		femalebutton=new JRadioButton("Female");
		specializationbox=new JComboBox();
		specializationbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Heart","Kidney","Bones","Apetite","Psychiatrists","All"}));
		day=new JComboBox();
		day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		month=new JComboBox();
		month.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
		year=new JComboBox();
		//year.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"}));
		year.setModel(new javax.swing.DefaultComboBoxModel(arr));
		dayofjoining=new JComboBox();
		dayofjoining.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		monthofjoining=new JComboBox();
		monthofjoining.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
		yearofjoining=new JComboBox();
		//yearofjoining.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"}));
		yearofjoining.setModel(new javax.swing.DefaultComboBoxModel(arr));
		doctorid=new JLabel("DOCTOR ID");
		doctorname=new JLabel("DOCTOR NAME");
		dateofbirth=new JLabel("DATE OF BIRTH");
		dateofjoining=new JLabel("DATE OF JOINING");
		gender=new JLabel("GENDER");
		qualification=new JLabel("QUALIFICATION");
		specialization=new JLabel("SPECIALIZATION");
		yearsofexperience=new JLabel("YEARS OF EXPERIENCE");
		street=new JLabel("STREET");
		location=new JLabel("LOCATION");
		city=new JLabel("CITY");
		state=new JLabel("STATE");
		pincode=new JLabel("PINCODE");
		contactnumber=new JLabel("CONTACT NUMBER");
		emailid=new JLabel("EMAIL ID");
		idfield=new JTextField(6);
		idfield.setEditable(false);
		namefield=new JTextField(20);
		qualificationfield=new JTextField(20);
		yearsofexperiencefield=new JTextField(20);
		streetarea=new JTextArea();
		locationfield=new JTextField(20);
		cityfield=new JTextField(20);
		statefield=new JTextField(20);
		pincodefield=new JTextField(20);
		contactnumberfield=new JTextField(20);
		emailidfield=new JTextField(20);
		mainpanel.add(doctorid);
		doctorid.setBounds(110,80 ,70 ,25);
		mainpanel.add(idfield);
		idfield.setBounds(400,80 ,125 ,25);
		mainpanel.add(doctorname);
		doctorname.setBounds(110,110 ,125 ,25);
		mainpanel.add(namefield);
		namefield.setBounds(400,110 ,125 ,25);//
		mainpanel.add(dateofbirth);
		dateofbirth.setBounds(110,140 ,125 ,25);
		mainpanel.add(day);
		day.setBounds(400,140,50,25);//
		mainpanel.add(month);
		month.setBounds(470,140,50,25);
		mainpanel.add(year);
		year.setBounds(540,140,70,25);
		mainpanel.add(dateofjoining);
		dateofjoining.setBounds(110,170 ,125 ,25);
		mainpanel.add(dayofjoining);
		dayofjoining.setBounds(400,170,50,25);
		mainpanel.add(monthofjoining);
		monthofjoining.setBounds(470,170,50,25);
		mainpanel.add(yearofjoining);
		yearofjoining.setBounds(540,170,70,25);
		mainpanel.add(gender);
		gender.setBounds(110,200 ,125 ,25);
		group.add(malebutton);
		group.add(femalebutton);
		mainpanel.add(malebutton);
		malebutton.setBounds(400,200 ,55 ,25);
		mainpanel.add(femalebutton);
		femalebutton.setBounds(460,200 ,125 ,25);//
		mainpanel.add(qualification);
		qualification.setBounds(110,230 ,125 ,25);
		mainpanel.add(qualificationfield);
		qualificationfield.setBounds(400,230,125,25);
		mainpanel.add(specialization);
		specialization.setBounds(110,260 ,125 ,25);
		mainpanel.add(specializationbox);
		specializationbox.setBounds(400,260,125,25);
		mainpanel.add(yearsofexperience);
		yearsofexperience.setBounds(110,290 ,155 ,25);
		mainpanel.add(yearsofexperiencefield);
		yearsofexperiencefield.setBounds(400,290,125,25);//
		mainpanel.add(street);
		street.setBounds(110,320 ,125 ,25);
		mainpanel.add(streetarea);
		streetarea.setBounds(400,320,220,35);////
		mainpanel.add(location);
		location.setBounds(110,360 ,125 ,25);
		mainpanel.add(locationfield);
		locationfield.setBounds(400,360,125,25);
		mainpanel.add(city);
		city.setBounds(110,390 ,125 ,25);
		mainpanel.add(cityfield);
		cityfield.setBounds(400,390,125,25);
		mainpanel.add(state);
		state.setBounds(110,420 ,125 ,25);
		mainpanel.add(statefield);
		statefield.setBounds(400,420,125,25);
		mainpanel.add(pincode);
		pincode.setBounds(110,450 ,125 ,25);
		mainpanel.add(pincodefield);
		pincodefield.setBounds(400,450,125,25);
		mainpanel.add(contactnumber);
		contactnumber.setBounds(110,480 ,125 ,25);
		mainpanel.add(contactnumberfield);
		contactnumberfield.setBounds(400,480,125,25);
		mainpanel.add(emailid);
		emailid.setBounds(110,510 ,125 ,25);
		mainpanel.add(emailidfield);
		emailidfield.setBounds(400,510,125,25);
		addbutton=new JButton("ADD");
		mainpanel.add(addbutton);
		addbutton.setBounds(450,550, 200,50);
		addbutton.addActionListener(new adminlistener(this));
		adminframe.add(mainpanel);
		mainpanel.setVisible(true);
		adminframe.setVisible(true);
	}
	public void deleteadmin(){
		
		mainpanel.setLayout(null);
		headingdelete=new JLabel("DELETE DOCTORS");
		headingdelete.setBounds(350,40,700,25);
		 Font font = new Font("Courier", Font.BOLD,30);
		 headingdelete.setFont(font);
		 mainpanel.add(headingdelete);
		id=new JLabel("DOCTOR ID");
		mainpanel.add(id);
		id.setBounds(370,120 ,75,20 );
		delDoctorIDcombo=new JComboBox();
		delDoctorIDcombo.setBounds(440,120,125,25);
		mainpanel.add(delDoctorIDcombo);
		deletebutton=new JButton("DELETE");
		deletebutton.setBounds(420,160,100,30);
		mainpanel.add(deletebutton);
		deletebutton.addActionListener(new adminlistener(this));
		adminframe.add(mainpanel);
		mainpanel.setVisible(true);
		adminframe.setVisible(true);
	}
	public void changepassword(){
		mainpanel.setLayout(null);
		heading=new JLabel("UPDATE PASSWORD");
		idlabel=new JLabel("ADMIN ID");
		oldplabel=new JLabel("OLD PASSWORD");
		newplabel=new JLabel("NEW PASSWORD");
		matchpasslabel=new JLabel("RE-TYPE PASSWORD");
		idfieldpass=new JTextField(20);
		oldidfield=new JPasswordField(20);
		newidfield=new JPasswordField(20);
		matchidfield=new JPasswordField(20);
		changebutton=new JButton("CHANGE");
		mainpanel.add(heading);
		heading.setBounds(350,40,700,25);
		 Font font = new Font("Courier", Font.BOLD,30);
		 heading.setFont(font);
		mainpanel.add(idlabel);
		idlabel.setBounds(250,150,75,25);
		mainpanel.add(idfieldpass);
		idfieldpass.setBounds(400,150,125,25);
		mainpanel.add(oldplabel);
		oldplabel.setBounds(250,190,125,25);
		mainpanel.add(oldidfield);
		oldidfield.setBounds(400,190,125,25);
		mainpanel.add(newplabel);
		newplabel.setBounds(250,230,125,25);
		mainpanel.add(newidfield);
		newidfield.setBounds(400,230,125,25);
		mainpanel.add(matchpasslabel);
		matchpasslabel.setBounds(250,270,125,25);
		mainpanel.add(matchidfield);
		matchidfield.setBounds(400,270,125,25);
		mainpanel.add(changebutton);
		changebutton.setBounds(300,310,125,25);
		changebutton.addActionListener(new adminlistener(this));
		adminframe.add(mainpanel);
		mainpanel.setVisible(true);
		adminframe.setVisible(true);
	}
	public void modifydoctor(){
		String[] arr=new String[100];
		int j=1920;
		for(int i=0;i<arr.length;i++){
			arr[i]=String.valueOf(j);
			j++;
		}
		mainpanel.setLayout(null);
		//adminframe.getContentPane().setBackground(Color.lightGray);
		headingmodify=new JLabel("MODIFY DETAILS");
		 Font font = new Font("Courier", Font.BOLD,30);
		 headingmodify.setFont(font);
		 headingmodify.setBounds(180,30,300,25);
		 mainpanel.add(headingmodify);
		modifygroup=new ButtonGroup();
		modifymalebutton=new JRadioButton("Male");
		modifyfemalebutton=new JRadioButton("Female");
		modifyspecializationbox=new JComboBox();
		modifyspecializationbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Heart","Kidney","Bones"}));
		modifyday=new JComboBox();
		modifyday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		modifymonth=new JComboBox();
		modifymonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
		modifyyear=new JComboBox();
		//year.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"}));
		modifyyear.setModel(new javax.swing.DefaultComboBoxModel(arr));
		modifydayofjoining=new JComboBox();
		modifydayofjoining.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		modifymonthofjoining=new JComboBox();
		modifymonthofjoining.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
		modifyyearofjoining=new JComboBox();
		//yearofjoining.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"}));
		modifyyearofjoining.setModel(new javax.swing.DefaultComboBoxModel(arr));
		modifydoctorid=new JLabel("DOCTOR ID");
		modifydoctorname=new JLabel("DOCTOR NAME");
		modifydateofbirth=new JLabel("DATE OF BIRTH");
		modifydateofjoining=new JLabel("DATE OF JOINING");
		modifygender=new JLabel("GENDER");
		modifyqualification=new JLabel("QUALIFICATION");
		modifyspecialization=new JLabel("SPECIALIZATION");
		modifyyearsofexperience=new JLabel("YEARS OF EXPERIENCE");
		modifystreet=new JLabel("STREET");
		modifylocation=new JLabel("LOCATION");
		modifycity=new JLabel("CITY");
		modifystate=new JLabel("STATE");
		modifypincode=new JLabel("PINCODE");
		modifycontactnumber=new JLabel("CONTACT NUMBER");
		modifyemailid=new JLabel("EMAIL ID");
		//modifyidfield=new JTextField(6);
		modifyidcombo= new JComboBox();
//		/idfield.setEditable(false);
		modifynamefield=new JTextField(20);
		modifyqualificationfield=new JTextField(20);
		modifyyearsofexperiencefield=new JTextField(20);
		modifystreetarea=new JTextArea();
		modifylocationfield=new JTextField(20);
		modifycityfield=new JTextField(20);
		modifystatefield=new JTextField(20);
		modifypincodefield=new JTextField(20);
		modifycontactnumberfield=new JTextField(20);
		modifyemailidfield=new JTextField(20);
		mainpanel.add(modifydoctorid);
		modifydoctorid.setBounds(110,80 ,70 ,25);
		mainpanel.add(modifyidcombo);
		modifyidcombo.setBounds(400,80 ,125 ,25);
		mainpanel.add(modifydoctorname);
		modifydoctorname.setBounds(110,110 ,125 ,25);
		mainpanel.add(modifynamefield);
		modifynamefield.setBounds(400,110 ,125 ,25);//
		mainpanel.add(modifydateofbirth);
		modifydateofbirth.setBounds(110,140 ,125 ,25);
		mainpanel.add(modifyday);
		modifyday.setBounds(400,140,50,25);//
		mainpanel.add(modifymonth);
		modifymonth.setBounds(470,140,50,25);
		mainpanel.add(modifyyear);
		modifyyear.setBounds(540,140,70,25);
		mainpanel.add(modifydateofjoining);
		modifydateofjoining.setBounds(110,170 ,125 ,25);
		mainpanel.add(modifydayofjoining);
		modifydayofjoining.setBounds(400,170,50,25);
		mainpanel.add(modifymonthofjoining);
		modifymonthofjoining.setBounds(470,170,50,25);
		mainpanel.add(modifyyearofjoining);
		modifyyearofjoining.setBounds(540,170,70,25);
		mainpanel.add(modifygender);
		modifygender.setBounds(110,200 ,125 ,25);
		modifygroup.add(modifymalebutton);
		modifygroup.add(modifyfemalebutton);
		mainpanel.add(modifymalebutton);
		modifymalebutton.setBounds(400,200 ,55 ,25);
		mainpanel.add(modifyfemalebutton);
		modifyfemalebutton.setBounds(460,200 ,125 ,25);//
		mainpanel.add(modifyqualification);
		modifyqualification.setBounds(110,230 ,125 ,25);
		mainpanel.add(modifyqualificationfield);
		modifyqualificationfield.setBounds(400,230,125,25);
		mainpanel.add(modifyspecialization);
		modifyspecialization.setBounds(110,260 ,125 ,25);
		mainpanel.add(modifyspecializationbox);
		modifyspecializationbox.setBounds(400,260,125,25);
		mainpanel.add(modifyyearsofexperience);
		modifyyearsofexperience.setBounds(110,290 ,155 ,25);
		mainpanel.add(modifyyearsofexperiencefield);
		modifyyearsofexperiencefield.setBounds(400,290,125,25);//
		mainpanel.add(modifystreet);
		modifystreet.setBounds(110,320 ,125 ,25);
		mainpanel.add(modifystreetarea);
		modifystreetarea.setBounds(400,320,220,35);////
		mainpanel.add(modifylocation);
		modifylocation.setBounds(110,360 ,125 ,25);
		mainpanel.add(modifylocationfield);
		modifylocationfield.setBounds(400,360,125,25);
		mainpanel.add(modifycity);
		modifycity.setBounds(110,390 ,125 ,25);
		mainpanel.add(modifycityfield);
		modifycityfield.setBounds(400,390,125,25);
		mainpanel.add(modifystate);
		modifystate.setBounds(110,420 ,125 ,25);
		mainpanel.add(modifystatefield);
		modifystatefield.setBounds(400,420,125,25);
		mainpanel.add(modifypincode);
		modifypincode.setBounds(110,450 ,125 ,25);
		mainpanel.add(modifypincodefield);
		modifypincodefield.setBounds(400,450,125,25);
		mainpanel.add(modifycontactnumber);
		modifycontactnumber.setBounds(110,480 ,125 ,25);
		mainpanel.add(modifycontactnumberfield);
		modifycontactnumberfield.setBounds(400,480,125,25);
		mainpanel.add(modifyemailid);
		modifyemailid.setBounds(110,510 ,125 ,25);
		mainpanel.add(modifyemailidfield);
		modifyemailidfield.setBounds(400,510,125,25);
		showbutton=new JButton("SHOW");
		showbutton.setBounds(300,600,150,40);
		mainpanel.add(showbutton);
		updatebutton=new JButton("UPDATE");
		mainpanel.add(updatebutton);
		updatebutton.setBounds(450,600, 150,40);
		showbutton.addActionListener(new adminlistener(this));
		updatebutton.addActionListener(new adminlistener(this));
		adminframe.add(mainpanel);
		mainpanel.setVisible(true);
		adminframe.setVisible(true);
	}
	public void viewpatientsbydate(){
		mainpanel.setLayout(null);
		String[] arr=new String[100];
		int j=1920;
		for(int i=0;i<arr.length;i++){
			arr[i]=String.valueOf(j);
			j++;
		}
		headingtime=new JLabel("VIEW PATIENTS BY APPOINTMENT DATE");
		 Font font = new Font("Courier", Font.BOLD,30);
		 headingtime.setFont(font);
		 headingtime.setBounds(180,30,900,25);
		 mainpanel.add(headingtime);
		viewdatelabel=new JLabel("APPOINTMENT DATE");
		viewpatientdate=new JComboBox();
		viewpatientbydatebutton=new JButton("VIEW");
		viewpatientdate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		viewpatientmonth=new JComboBox();
		viewpatientmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
		viewpatientyear=new JComboBox();
		viewpatientyear.setModel(new javax.swing.DefaultComboBoxModel(arr));
		mainpanel.add(viewdatelabel);
		viewdatelabel.setBounds(250,100,125,75);
		mainpanel.add(viewpatientdate);
		viewpatientdate.setBounds(360,100,75,25);
		mainpanel.add(viewpatientmonth);
		viewpatientmonth.setBounds(470,100,75,25);
		mainpanel.add(viewpatientyear);
		viewpatientyear.setBounds(580,100,75,25);
		mainpanel.add(viewpatientbydatebutton);
		viewpatientbydatebutton.setBounds(420,130,125,25);
		viewpatientbydatebutton.addActionListener(new adminlistener(this));
		adminframe.add(mainpanel);
		mainpanel.setVisible(true);
		adminframe.setVisible(true);
	}
	public void confirmappointment(){
		mainpanel.setLayout(null);
		headingconfirm=new JLabel("CONFIRM APPOINTMENT");
		 Font font = new Font("Courier", Font.BOLD,30);
		 headingconfirm.setFont(font);
		 headingconfirm.setBounds(180,30,900,25);
		 mainpanel.add(headingconfirm);
			appointmentidtoconfirm=new JLabel("APPOINTMENT ID");
			appointmentfieldtoconfirm=new JComboBox();
			statustoconfirm=new JLabel("STATUS");
			statusfieldtoconfirm=new JTextField();
			mainpanel.add(appointmentidtoconfirm);
			appointmentidtoconfirm.setBounds(250,150,125,25);
			mainpanel.add(appointmentfieldtoconfirm);
			appointmentfieldtoconfirm.setBounds(450,150,125,25);
			mainpanel.add(statustoconfirm);
			statustoconfirm.setBounds(250,200,125,25);
			mainpanel.add(statusfieldtoconfirm);
			statusfieldtoconfirm.setBounds(450,200,125,25);
			confirmbutton=new JButton("CONFIRM");
			confirmbutton.setBounds(320,250,200,25);
			mainpanel.add(confirmbutton);
			confirmbutton.addActionListener(new adminlistener(this));
			adminframe.add(mainpanel);
			mainpanel.setVisible(true);
			adminframe.setVisible(true);
	}
	
	
	
	//--------------------------
	public void addDocSchedule()
	{
		mainpanel.setLayout(null);
		Headingschd= new JLabel("ADD SCHEDULE");
		Headingschd.setBounds(300, 80, 450, 40);
		 Font font = new Font("Courier", Font.BOLD,30);
		 Headingschd.setFont(font);
		addSchIDlabel=new JLabel("Schedule ID");
		addSchIDlabel.setBounds(300, 140, 70, 25);
		addSchIDtxtfield=new JTextField(10);
		addSchIDtxtfield.setBounds(400, 140, 120, 25);
		addSchIDtxtfield.setEditable(false);
		mainpanel.add(Headingschd);
		mainpanel.add(addSchIDlabel);
		mainpanel.add(addSchIDtxtfield);
		 addDocIDlabel=new JLabel("Doctor ID");
		 addDocIDcombo= new JComboBox();
		 addDocIDcombo.setBounds(400,200 ,125 ,25);
		 mainpanel.add(addDocIDlabel);
		 addDocIDlabel.setBounds(300,200 ,70 ,25);
		 mainpanel.add(addDocIDcombo);
		 addAvalbleDaysLbl=new JLabel("Available On ");
		 addAvalbleDaysLbl.setBounds(300, 240, 90, 25);
		 mondaychk = new JCheckBox("Mon");
		 tuesdaychk = new JCheckBox("Tue");
		 wednsdaychk = new JCheckBox("Wed");
		 thrusdaychk = new JCheckBox("Thu");
		 fridaychk = new JCheckBox("Fri");
		 
		 mondaychk.setBounds(400,240 ,125 ,25);
		 tuesdaychk.setBounds(400,280 ,125 ,25);
		 wednsdaychk.setBounds(400,320 ,125 ,25);
		 thrusdaychk.setBounds(400,360 ,125 ,25);
		 fridaychk.setBounds(400,400 ,125 ,25);
		 slotlbl=new JLabel("Slot");
		 slotlbl.setBounds(300,440, 90, 25);
		 combs= new JComboBox();
		 combs.setBounds(400,440 ,125 ,25);
		 combs.addItem("Morning");
		 combs.addItem("Evening");
		 submitbtnsch= new JButton("SUBMIT");
		 submitbtnsch.setBounds(350, 495, 100, 30);
		 
		 
		 mainpanel.add(submitbtnsch);
		 mainpanel.add(slotlbl);
		 mainpanel.add(combs);
		 mainpanel.add(addAvalbleDaysLbl);
		 mainpanel.add(mondaychk);
		 mainpanel.add(tuesdaychk);
		 mainpanel.add(wednsdaychk);
		 mainpanel.add(thrusdaychk);
		 mainpanel.add(fridaychk);
		    
		adminframe.add(mainpanel);
		submitbtnsch.addActionListener(new adminlistener(this));
		mainpanel.setVisible(true);
		adminframe.setVisible(true);
	}
	public void modifyDocSchedule()
	{
		mainpanel.setLayout(null);
		
		modifyHeadingschd= new JLabel("MODIFY SCHEDULE");
		modifyHeadingschd.setBounds(300, 80, 450, 40);
		 Font font = new Font("Courier", Font.BOLD,30);
		 modifyHeadingschd.setFont(font);
		modifySchIDlabel=new JLabel("Schedule ID");
		modifySchIDlabel.setBounds(300, 140, 70, 25);
		modifySchIDtxtfield=new JTextField(10);
		modifySchIDtxtfield.setBounds(400, 140, 120, 25);
		modifySchIDtxtfield.setEditable(false);
	mainpanel.add(modifyHeadingschd);
	//mainpanel.add(addSchIDlabel);
	//mainpanel.add(addSchIDtxtfield);
	modifyDocIDlabel=new JLabel("Doctor ID");
	modifyDocIDcombo= new JComboBox();
	modifyDocIDcombo.setBounds(400,200 ,125 ,25);
	 mainpanel.add(modifyDocIDlabel);
	 modifyDocIDlabel.setBounds(300,200 ,70 ,25);
	 mainpanel.add(modifyDocIDcombo);
	 modifyAvalbleDaysLbl=new JLabel("Available On ");
	 modifyAvalbleDaysLbl.setBounds(300, 240, 90, 25);
	 modifymondaychk = new JCheckBox("Mon");
	 modifytuesdaychk = new JCheckBox("Tue");
	 modifywednsdaychk = new JCheckBox("Wed");
	 modifythrusdaychk = new JCheckBox("Thu");
	 modifyfridaychk = new JCheckBox("Fri");
	 
	 modifymondaychk.setBounds(400,240 ,125 ,25);
	 modifytuesdaychk.setBounds(400,280 ,125 ,25);
	 modifywednsdaychk.setBounds(400,320 ,125 ,25);
	 modifythrusdaychk.setBounds(400,360 ,125 ,25);
	 modifyfridaychk.setBounds(400,400 ,125 ,25);
	 modifyslotlbl=new JLabel("Slot");
	 modifyslotlbl.setBounds(300,440, 90, 25);
	 modifycombs= new JComboBox();
	 modifycombs.setBounds(400,440 ,125 ,25);
	 modifycombs.addItem("Morning");
	 modifycombs.addItem("Evening");
	 modifysubmitbtnsch= new JButton("SUBMIT");
	 modifysubmitbtnsch.setBounds(350, 495, 100, 30);
	 
	 
	 mainpanel.add(modifysubmitbtnsch);
	 mainpanel.add(modifyslotlbl);
	 mainpanel.add(modifycombs);
	 mainpanel.add(modifyAvalbleDaysLbl);
	 mainpanel.add(modifymondaychk);
	 mainpanel.add(modifytuesdaychk);
	 mainpanel.add(modifywednsdaychk);
	 mainpanel.add(modifythrusdaychk);
	 mainpanel.add(modifyfridaychk);
	    
	adminframe.add(mainpanel);
	modifysubmitbtnsch.addActionListener(new adminlistener(this));
	mainpanel.setVisible(true);
	adminframe.setVisible(true);
	}
	}

