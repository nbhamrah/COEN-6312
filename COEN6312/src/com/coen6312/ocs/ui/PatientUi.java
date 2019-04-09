package com.coen6312.ocs.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.listener.PatientListener;
import com.coen6312.ocs.listener.adminlistener;

public class PatientUi extends JFrame {

	
	public static String getselecteddate="";
	public static String getselectedmonth="";
	public static String getselectedyear="";
	
	
	
	public JFrame patientframe;
	public JMenuBar patientbar;
	public JMenu patientadd,patientmodify,patientviewAlDetails,patientAppointDetails,viewDoctList,patientReqAppoint,patientChngpass,patientLogout;
	//public JPanel patientpanel,datepanel;
	public JMenu appointmentstatus;
	public JLabel lblpatientid,lblpatientuserid,lblpatientappointmentdate,lblpatientailmenttype,lblpatientailmentdetails,lblpatientdiagnosishistory;
	public JTextField txtpatientid,txtpatientuserid;
	public JComboBox cmbpatientday,cmbpatientmonth,cmbpatientyear;
	public JComboBox cmbpatientailtype;
	public JTextArea txapatientailmentdetails,txapatienthistory;
	public JButton btnpatientadd,btnpatientcancel;
	public JOptionPane patientpane;
	public JLabel patientlabel;
	public JMenu logoutpatient;
	
	public JLabel lblmpatientid,lblmpatientuserid,lblmpatientappointmentdate,lblmpatientailmenttype,lblmpatientailmentdetails,lblmpatientdiagnosishistory;
	public JTextField txtmpatientid,txtmpatientuserid;
	public JComboBox cmbmpatientday,cmbmpatientmonth,cmbmpatientyear;
	public JComboBox cmbmpatientailtype;
	public JTextArea txampatientailmentdetails,txampatienthistory;
	public JButton btnmpatientshow,btnmpatientmodify;
	public JOptionPane mpatientpane;
	
	public JPanel mpatientpanel,mdatepanel;
	
	public JLabel mpatientlabel;
	//------------------------------------------
	public JTable specializationtabel;
	public JScrollPane specialpane;
	public JTextField idfield1;
	public JLabel idlabel1;
	public JTextField idfield2;
	public JLabel idlabel2;
	public String getlogoutid;
	public JLabel headingrequest;
	public JComboBox day;
	public JComboBox month;
	public JComboBox year;
	public JLabel idlabel3;
	public JTextField idfield3;
	public JButton viewappointmentbutton;
	public JTable viewappointmentdetailbutton;
	public JScrollPane appointmentpan;
	public JButton requestforappointmentbutton;
	public JComboBox slotbox;
	public JComboBox slotnumberbox1;
	public JComboBox slotnumberbox2;
	public JLabel slotlabel;
	public JLabel appointmentidlabel;
	public JLabel appointmentidfield;
	public JLabel slotnumberlabel;
	public JLabel eachslot;
	public JTable appointmentstatustable;
	public JScrollPane appointmentstatuspane;
	public JLabel app;
	public String getGetlogoutid()
	{
		return getlogoutid;
	}



	public void setGetlogoutid(String getlogoutid) 
	{
		this.getlogoutid = getlogoutid;
	}
	

	//Change password
	
	public JLabel headingm,idlabelm,oldplabelm,newplabelm,matchpasslabelm;
	public JTextField idfieldpassm,oldidfieldm,newidfieldm,matchidfieldm;
	public JButton changebuttonm;
	
	
	
	//to get id
	
	
	public static String getId;
	
	
	public PatientUi(CredentialsBean been)
	{
		
		getId=been.getUserID();
		
		
		
		
		
		
		
		patientframe=new JFrame("PATIENT");
		patientframe.setVisible(true);
		patientframe.setDefaultCloseOperation(3);
		patientframe.setSize(1080,720);
		patientframe.setResizable(false);
		patientframe.setLocationRelativeTo(null);
		
		mpatientpanel=new JPanel();
		patientbar=new JMenuBar();
		patientadd=new JMenu("Add");
		patientmodify=new JMenu("Modify");
		patientviewAlDetails=new JMenu("ViewAilmentDetails");
		patientAppointDetails=new JMenu("ViewAppointmentDetails");
		viewDoctList=new JMenu("ViewDoctorList");
		patientReqAppoint=new JMenu("RequestForAppointment");
		patientChngpass=new JMenu("ChangePassword");
		//patientLogout=new JMenu("Logout");
		appointmentstatus=new JMenu("APPOINTMENT STATUS");
		logoutpatient=new JMenu("LOGOUT");
		
		
		
		
		
		
		
		patientbar.add(patientadd);
		patientbar.add(patientmodify);
		//patientbar.add(patientviewAlDetails);
		//patientbar.add(patientAppointDetails);
		//patientbar.add(viewDoctList);
		patientbar.add(patientReqAppoint);
		patientbar.add(appointmentstatus);
		//patientbar.add(patientChngpass);
		patientbar.add(logoutpatient);
		patientframe.setJMenuBar(patientbar);
		
		patientadd.addMenuListener(new PatientListener(this));
		patientmodify.addMenuListener(new PatientListener(this));
		patientReqAppoint.addMenuListener(new PatientListener(this));
		appointmentstatus.addMenuListener(new PatientListener(this));
		logoutpatient.addMenuListener(new PatientListener(this));
	}
	
	
	
	public void addAilmentDetails()
	{
		
		patientpane=new JOptionPane();
		
		mpatientpanel.setLayout(null);
		//datepanel=new JPanel();
		
		patientlabel=new JLabel("ADD AILMENT DETAILS");
		patientlabel.setBounds(380,10, 500, 80);
		patientlabel.setFont(new Font("Serif", Font.BOLD, 20));
		mpatientpanel.add(patientlabel);	
		
		
		
		
		
		
		
		lblpatientid=new JLabel("PATIENT ID");
		lblpatientuserid=new JLabel("USER ID");
		lblpatientappointmentdate=new JLabel("APPOINTMENT DATE");
		lblpatientailmenttype=new JLabel("AILMENT TYPE");
		lblpatientailmentdetails=new JLabel("AILMENT DETAILS");
		lblpatientdiagnosishistory=new JLabel("DIAGNOSIS HISTORY");
		
		txtpatientid=new JTextField(10);
		txtpatientid.setEditable(false);
		txtpatientuserid=new JTextField(10);
		txtpatientuserid.setText(getId);
		txtpatientuserid.setEditable(false);
		
		txapatientailmentdetails=new JTextArea();
		txapatienthistory=new JTextArea();
		
		cmbpatientday=new JComboBox();
		cmbpatientday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		cmbpatientmonth=new JComboBox();
		cmbpatientmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));

		
		
		cmbpatientyear=new JComboBox();
		cmbpatientyear.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"2016","2017","2018","2019"}));

		cmbpatientailtype=new JComboBox();
		cmbpatientailtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Frequent Heartburn","Asthma","Back Pain","Diabetes" ,"Insomnia","Migraines","Epilepsy","Obesity","Parkinson’s Disease","Alzheimer"}));
		
		
		btnpatientadd=new JButton("ADD");
		btnpatientcancel=new JButton("CANCEL");
		
		
		
		
		cmbpatientday.setBounds(500, 250,50, 25);
		
		
		cmbpatientmonth.setBounds(560, 250,50, 25);
		
		
		cmbpatientyear.setBounds(620, 250,55, 25);
		
		
		//datepanel.add(cmbpatientday);
		//datepanel.add(cmbpatientmonth);
		//datepanel.add(cmbpatientyear);
		
		
		
		lblpatientid.setBounds(350, 150,175, 25);
		mpatientpanel.add(lblpatientid);
		
		txtpatientid.setBounds(500,150,175,25);
		mpatientpanel.add(txtpatientid);
		
		lblpatientuserid.setBounds(350,200 ,175, 25);
		mpatientpanel.add(lblpatientuserid);
		
		txtpatientuserid.setBounds(500,200,175,25);
		mpatientpanel.add(txtpatientuserid);
		
		
		lblpatientappointmentdate.setBounds(350,250,175,25);
		mpatientpanel.add(lblpatientappointmentdate);
		
		mpatientpanel.add(cmbpatientday);
		mpatientpanel.add(cmbpatientmonth);
		mpatientpanel.add(cmbpatientyear);
		
		//patientpanel.add(datepanel);
		
		
		lblpatientailmenttype.setBounds(350,300,175, 25);
		mpatientpanel.add(lblpatientailmenttype);
		
		
		
		cmbpatientailtype.setBounds(500, 300,175,25);
		mpatientpanel.add(cmbpatientailtype);
		
		lblpatientailmentdetails.setBounds(350, 350,175,25);
		mpatientpanel.add(lblpatientailmentdetails);
		
		
		txapatientailmentdetails.setBounds(500, 350,200,70);
		mpatientpanel.add(txapatientailmentdetails);
		
		lblpatientdiagnosishistory.setBounds(350, 450,175,25);
		mpatientpanel.add(lblpatientdiagnosishistory);
		txapatienthistory.setBounds(500, 450,200,70);
		mpatientpanel.add(txapatienthistory);
		
		btnpatientadd.setFont(new Font("Serif", Font.BOLD, 15));
		btnpatientadd.setBounds(390, 580,100,25);
		mpatientpanel.add(btnpatientadd);
		
		btnpatientcancel.setFont(new Font("Serif", Font.BOLD, 15));
		btnpatientcancel.setBounds(540, 580,100,25);
		mpatientpanel.add(btnpatientcancel);
		
		patientframe.add(mpatientpanel);
		mpatientpanel.setVisible(true);
		patientframe.setVisible(true);
		
		btnpatientadd.addActionListener(new PatientListener(this));
		btnpatientcancel.addActionListener(new PatientListener(this));
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	public void modifyAilmentDetails()
	
	{
		mpatientpane=new JOptionPane();
		//mpatientpanel=new JPanel();
		mpatientpanel.setLayout(null);
		//mdatepanel=new JPanel();
		
		mpatientlabel=new JLabel("MODIFY AILMENT DETAILS");
		mpatientlabel.setBounds(380,10, 500, 80);
		mpatientlabel.setFont(new Font("Serif", Font.BOLD, 20));
		mpatientpanel.add(mpatientlabel);	
		
		
		
		
		
		
		
		lblmpatientid=new JLabel("PATIENT ID");
		lblmpatientuserid=new JLabel("USER ID");
		lblmpatientappointmentdate=new JLabel("APPOINTMENT DATE");
		lblmpatientailmenttype=new JLabel("AILMENT TYPE");
		lblmpatientailmentdetails=new JLabel("AILMENT DETAILS");
		lblmpatientdiagnosishistory=new JLabel("DIAGNOSIS HISTORY");
		
		txtmpatientid=new JTextField(10);
		txtmpatientid.setEditable(false);
		txtmpatientuserid=new JTextField(10);
		txtmpatientuserid.setText(getId);
		txtmpatientuserid.setEditable(false);
		
		txampatientailmentdetails=new JTextArea();
		txampatienthistory=new JTextArea();
		
		cmbmpatientday=new JComboBox();
		cmbmpatientday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		cmbmpatientmonth=new JComboBox();
		cmbmpatientmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));

		
		
		cmbmpatientyear=new JComboBox();
		cmbmpatientyear.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"2016","2017","2018","2019"}));

		cmbmpatientailtype=new JComboBox();
		cmbmpatientailtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Frequent Heartburn","Asthma","Back Pain","Diabetes" ,"Insomnia","Migraines","Epilepsy","Obesity","Parkinson’s Disease","Alzheimer"}));
		
		
		btnmpatientshow=new JButton("SHOW");
		btnmpatientmodify=new JButton("UPDATE");
		btnmpatientmodify.setEnabled(false);
		
		
		
		
		cmbmpatientday.setBounds(500, 250,50, 25);
		
		
		cmbmpatientmonth.setBounds(560, 250,50, 25);
		
		
		cmbmpatientyear.setBounds(620, 250,55, 25);
		
		
		//datepanel.add(cmbpatientday);
		//datepanel.add(cmbpatientmonth);
		//datepanel.add(cmbpatientyear);
		
		
		
		lblmpatientid.setBounds(350, 150,175, 25);
		mpatientpanel.add(lblmpatientid);
		
		txtmpatientid.setBounds(500,150,175,25);
		mpatientpanel.add(txtmpatientid);
		
		lblmpatientuserid.setBounds(350,200 ,175, 25);
		mpatientpanel.add(lblmpatientuserid);
		
		txtmpatientuserid.setBounds(500,200,175,25);
		mpatientpanel.add(txtmpatientuserid);
		
		
		lblmpatientappointmentdate.setBounds(350,250,175,25);
		mpatientpanel.add(lblmpatientappointmentdate);
		
		mpatientpanel.add(cmbmpatientday);
		mpatientpanel.add(cmbmpatientmonth);
		mpatientpanel.add(cmbmpatientyear);
		
		//patientpanel.add(datepanel);
		
		
		lblmpatientailmenttype.setBounds(350,300,175, 25);
		mpatientpanel.add(lblmpatientailmenttype);
		
		
		
		cmbmpatientailtype.setBounds(500, 300,175,25);
		mpatientpanel.add(cmbmpatientailtype);
		
		lblmpatientailmentdetails.setBounds(350, 350,175,25);
		mpatientpanel.add(lblmpatientailmentdetails);
		
		
		txampatientailmentdetails.setBounds(500, 350,200,70);
		mpatientpanel.add(txampatientailmentdetails);
		
		lblmpatientdiagnosishistory.setBounds(350, 450,175,25);
		mpatientpanel.add(lblmpatientdiagnosishistory);
		txampatienthistory.setBounds(500, 450,200,70);
		mpatientpanel.add(txampatienthistory);
		
		btnmpatientshow.setFont(new Font("Serif", Font.BOLD, 15));
		btnmpatientshow.setBounds(390, 580,100,25);
		mpatientpanel.add(btnmpatientshow);
		
		btnmpatientmodify.setFont(new Font("Serif", Font.BOLD, 15));
		btnmpatientmodify.setBounds(540, 580,100,25);
		mpatientpanel.add(btnmpatientmodify);
		
		patientframe.add(mpatientpanel);
		mpatientpanel.setVisible(true);
		patientframe.setVisible(true);
		
		btnmpatientshow.addActionListener(new PatientListener(this));
		btnmpatientmodify.addActionListener(new PatientListener(this));
		
		
	
		/*mpatientpane=new JOptionPane();
		mpatientpanel=new JPanel();
		mpatientpanel.setLayout(new GridLayout(0,2,25,70));
		mdatepanel=new JPanel();
		
		
		lblmpatientid=new JLabel("PATIENT ID");
		lblmpatientuserid=new JLabel("USER ID");
		lblmpatientappointmentdate=new JLabel("APPOINTMENT DATE");
		lblmpatientailmenttype=new JLabel("AILMENT TYPE");
		lblmpatientailmentdetails=new JLabel("AILMENT DETAILS");
		lblmpatientdiagnosishistory=new JLabel("DIAGNOSIS HISTORY");
		
		txtmpatientid=new JTextField(10);
		txtmpatientid.setEditable(false);
		txtmpatientuserid=new JTextField(10);
		//txtpatientuserid.setEditable(false);
		
		txampatientailmentdetails=new JTextArea();
		txampatienthistory=new JTextArea();
		
		cmbmpatientday=new JComboBox();
		cmbmpatientday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

		cmbmpatientmonth=new JComboBox();
		cmbmpatientmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));

		
		
		cmbmpatientyear=new JComboBox();
		cmbmpatientyear.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"2016","2017","2018","2019"}));

		cmbmpatientailtype=new JComboBox();
		cmbmpatientailtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Asthma","Back Pain","Diabetes" ,"Insomnia","Migraines","Epilepsy","Frequent Heartburn","Obesity","Parkinson’s Disease","Alzheimer"}));
		
		
		btnmpatientshow=new JButton("SHOW");
		btnmpatientmodify=new JButton("UPDATE");
		
		
		
		
		
		
		mdatepanel.add(cmbmpatientday);
		mdatepanel.add(cmbmpatientmonth);
		mdatepanel.add(cmbmpatientyear);
		
		
		mpatientpanel.add(lblmpatientid);
		mpatientpanel.add(txtmpatientid);
		mpatientpanel.add(lblmpatientuserid);
		mpatientpanel.add(txtmpatientuserid);
		mpatientpanel.add(lblmpatientappointmentdate);
		mpatientpanel.add(mdatepanel);
		mpatientpanel.add(lblmpatientailmenttype);
		mpatientpanel.add(cmbmpatientailtype);
		mpatientpanel.add(lblmpatientailmentdetails);
		mpatientpanel.add(txampatientailmentdetails);
		mpatientpanel.add(lblmpatientdiagnosishistory);
		mpatientpanel.add(txampatienthistory);
		mpatientpanel.add(btnmpatientshow);
		mpatientpanel.add(btnmpatientmodify);
		patientframe.add(mpatientpanel);
		patientframe.setVisible(true);
		
		btnpatientadd.addActionListener(new PatientListener(this));
		btnpatientcancel.addActionListener(new PatientListener(this));*/
		
	}
	
	public void changePassword()
	{
		mpatientpanel.setLayout(null);
		headingm=new JLabel("UPDATE PASSWORD");
		idlabelm=new JLabel("PATIENT USER ID");
		oldplabelm=new JLabel("OLD PASSWORD");
		newplabelm=new JLabel("NEW PASSWORD");
		matchpasslabelm=new JLabel("RE-TYPE PASSWORD");
		idfieldpassm=new JTextField(20);
		oldidfieldm=new JTextField(20);
		newidfieldm=new JTextField(20);
		matchidfieldm=new JTextField(20);
		changebuttonm=new JButton("CHANGE");
		mpatientpanel.add(headingm);
		headingm.setBounds(350,40,700,25);
		 Font font = new Font("Courier", Font.BOLD,30);
		 headingm.setFont(font);
		mpatientpanel.add(idlabelm);
		idlabelm.setBounds(250,150,75,25);
		mpatientpanel.add(idfieldpassm);
		idfieldpassm.setBounds(400,150,125,25);
		mpatientpanel.add(oldplabelm);
		oldplabelm.setBounds(250,190,125,25);
		mpatientpanel.add(oldidfieldm);
		oldidfieldm.setBounds(400,190,125,25);
		mpatientpanel.add(newplabelm);
		newplabelm.setBounds(250,230,125,25);
		mpatientpanel.add(newidfieldm);
		newidfieldm.setBounds(400,230,125,25);
		mpatientpanel.add(matchpasslabelm);
		matchpasslabelm.setBounds(250,270,125,25);
		mpatientpanel.add(matchidfieldm);
		matchidfieldm.setBounds(400,270,125,25);
		mpatientpanel.add(changebuttonm);
		changebuttonm.setBounds(300,310,125,25);
		changebuttonm.addActionListener(new PatientListener(this));
		patientframe.add(mpatientpanel);
		mpatientpanel.setVisible(true);
		patientframe.setVisible(true);
		
		
	}
	//patientobj.specialpane.setBounds(20,45,200,70);
	public void requestforappointment(){
		mpatientpanel.setLayout(null);
		//mpatientpanel.setBounds(370,40,325,530);
		String[] arr=new String[100];
		int j=1920;
		for(int i=0;i<arr.length;i++){
			arr[i]=String.valueOf(j);
			j++;
		}
		headingrequest=new JLabel("REQUEST FOR APPOINTMENT");
		 Font font = new Font("Courier", Font.BOLD,30);
		 headingrequest.setFont(font);
		 headingrequest.setBounds(180,20,900,25);
		 mpatientpanel.add(headingrequest);
		idfield1=new JTextField();
		//idfield2=new JTextField();
		appointmentidlabel=new JLabel("YOUR APPOINTMENT ID IS :-");
		appointmentidfield=new JLabel();
		 Font font1 = new Font("Courier", Font.BOLD,15);
		 appointmentidlabel.setFont(font1);
		 Font font2 = new Font("Courier", Font.BOLD,20);
		 appointmentidfield.setFont(font2);
		appointmentidlabel.setVisible(false);
		appointmentidfield.setVisible(false);
		idlabel1=new JLabel("ENTER DOCTOR ID");
		idlabel2=new JLabel("CHOOSE DATE");
		idlabel3=new JLabel("PATIENT ID");
		idfield3=new JTextField();
		mpatientpanel.add(idlabel3);
		idlabel3.setBounds(20,260,125,25);
		idfield3.setBounds(90,260,75,25);
		mpatientpanel.add(idfield3);
		mpatientpanel.add(idlabel1);
		idlabel1.setBounds(20,290,125,25);
		mpatientpanel.add(idfield1);
		idfield1.setBounds(150,290,75,25);
		mpatientpanel.add(idlabel2);
		idlabel2.setBounds(20,320,125,25);
		day=new JComboBox();
		day.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		month=new JComboBox();
		month.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}));
		year=new JComboBox();
		year.setModel(new javax.swing.DefaultComboBoxModel(arr));
		day.setSelectedItem(getselecteddate);
		month.setSelectedItem(getselectedmonth);
		year.setSelectedItem(getselectedyear);
		
		//year.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"}));
		mpatientpanel.add(day);
		mpatientpanel.add(month);
		mpatientpanel.add(year);
		day.setBounds(120,320,50,25);//
		month.setBounds(180,320,75,25);
		year.setBounds(260,320,75,25);
		viewappointmentbutton=new JButton("APPOINTMENTS OF DOCTOR");
		viewappointmentbutton.setBounds(650,65,300,25);
		mpatientpanel.add(viewappointmentbutton);
		requestforappointmentbutton=new JButton("REQUEST FOR APPOINTMENT");
		//mpatientpanel.add(requestforappointmentbutton,BorderLayout.SOUTH);
		requestforappointmentbutton.setBounds(350,550,300,75);
		slotlabel=new JLabel("SLOT");
		mpatientpanel.add(slotlabel);
		slotlabel.setBounds(20,350,75,25);
		slotbox=new JComboBox();
		slotbox.setEnabled(false);
		slotbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Morning","Evening"}));
		mpatientpanel.add(slotbox);
		slotbox.setBounds(70,350,125,25);
		slotnumberbox1=new JComboBox();
		slotnumberbox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"9:00AM","9:15AM","9:30AM","9:45AM","10:00AM","10:15AM","10:30AM","10:45AM","11:00AM","11:15AM","11:30AM","11:45AM"}));
		slotnumberbox2=new JComboBox();
		slotnumberbox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"2:00PM","2:15PM","2:30PM","2:45PM","3:00PM","3:15PM","3:30PM","3:45PM","4:00PM","4:15PM","4:30PM","4:45PM"}));
		slotnumberlabel=new JLabel("CHOOSE SLOT");
		mpatientpanel.add(slotnumberlabel);
		slotnumberlabel.setBounds(20,380,125,25);
		mpatientpanel.add(slotnumberbox1);
		slotnumberbox1.setBounds(120,380,75,25);
		mpatientpanel.add(slotnumberbox2);
		slotnumberbox2.setBounds(200,380,75,25);
		mpatientpanel.add(requestforappointmentbutton);
		
		eachslot = new JLabel( "***Each slot is of 15 minutes");
		eachslot.setBounds(20,400,175,25);
		mpatientpanel.add(eachslot);
		mpatientpanel.add(appointmentidlabel);
		appointmentidlabel.setBounds(550,400,350,70);
		mpatientpanel.add(appointmentidfield);
		appointmentidfield.setBounds(780,400,350,70);
		patientframe.add(mpatientpanel);
		viewappointmentbutton.addActionListener(new PatientListener(this));
		requestforappointmentbutton.addActionListener(new PatientListener(this));
		mpatientpanel.setVisible(true);
		patientframe.setVisible(true);
	}
	
	
	
	
	
	
	
	
	/*
	public static void main(String[] args) 
	{	CredentialsBean been=new CredentialsBean();
		new PatientUi(been);

	}
*/
}
