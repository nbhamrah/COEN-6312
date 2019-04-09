
package com.coen6312.ocs.listener;

//com.coen6312.ocs.listener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.JTableHeader;

import com.coen6312.ocs.bean.AppointmentBean;
import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.bean.DoctorBean;
import com.coen6312.ocs.bean.PatientBean;
import com.coen6312.ocs.bean.ScheduleBean;
import com.coen6312.ocs.dao.Dao;
import com.coen6312.ocs.service.Administrator;
import com.coen6312.ocs.ui.Adminui;
import com.coen6312.ocs.ui.UI;
import com.coen6312.ocs.util.User;

public class adminlistener implements MenuListener,ActionListener
{	
	public static String str="";
	Adminui adminui;
	public adminlistener(Adminui adminui)
	{
		this.adminui=adminui;
	}
	
	public void menuSelected(MenuEvent e) 
	{
		if(e.getSource()==adminui.addadmin)
		{
			//adminui.mainpanel.removeAll();
			//adminui.adminframe.remove(adminui.mainpanel);
			//adminui.adminframe.setContentPane(adminui.addadminpanel);
			adminui.mainpanel.removeAll();
			adminui.mainpanel.setVisible(false);
			adminui.addadmin();
			
		}
		if(e.getSource()==adminui.viewadmin)
		{
			adminui.mainpanel.removeAll();
			adminui.mainpanel.setVisible(false);
			//adminui.mainpanel.setVisible(true);
			adminui.mainpanel.setLayout(null);
			adminui.listofdoctors=new JLabel("LIST OF DOCTORS");
			 Font font4 = new Font("Courier", Font.BOLD,30);
			 adminui.listofdoctors.setFont(font4);
			 adminui.listofdoctors.setBounds(230,120,900,25);
			 adminui.mainpanel.add(adminui.listofdoctors);
			
			ArrayList<DoctorBean> list1=new ArrayList<DoctorBean>();
			Administrator administrator=new Administrator();
			list1=administrator.viewAllDoctors();
			int size=list1.size();
			String column_names[]={"DOCTORID","DOCTORNAME","DATEOFBIRTH","DATEOFJOINING","GENDER","QUALIFICATION","SPECIALIZATION","YEARSOFEXPERIENCE","STREET","CONTACTNUMBER","EMAILID"};
			Object rows[][]=new Object[size][11];
			Iterator<DoctorBean> it=list1.iterator();
			int i=0;
			while(it.hasNext())
			{
				DoctorBean doctorBean=new DoctorBean();
				doctorBean=it.next();
				rows[i][0]=doctorBean.getDoctorID();
				rows[i][1]=doctorBean.getDoctorName();
				rows[i][2]=doctorBean.getDateOfBirth();
				rows[i][3]=doctorBean.getDateOfJoining();
				rows[i][4]=doctorBean.getGender();
				rows[i][5]=doctorBean.getQualification();
				rows[i][6]=doctorBean.getSpecialization();
				rows[i][7]=doctorBean.getYearsOfExperience();
				rows[i][8]=doctorBean.getStreet();
				//rows[i][9]=doctorBean.getLocation();
				//rows[i][10]=doctorBean.getCity();
				//rows[i][11]=doctorBean.getState();
				//rows[i][12]=doctorBean.getPincode();
				rows[i][9]=doctorBean.getContactNumber();
				rows[i][10]=doctorBean.getEmailID();
				i++;
																
			}
			adminui.viewtable=new JTable(rows,column_names);
			
			 
			adminui.viewtable.getColumnModel().getColumn(0).setPreferredWidth(80);
            adminui.viewtable.getColumnModel().getColumn(1).setPreferredWidth(100);
            adminui.viewtable.getColumnModel().getColumn(2).setPreferredWidth(100);
            adminui.viewtable.getColumnModel().getColumn(3).setPreferredWidth(150);
            adminui.viewtable.getColumnModel().getColumn(4).setPreferredWidth(80);
            adminui.viewtable.getColumnModel().getColumn(5).setPreferredWidth(100);
            adminui.viewtable.getColumnModel().getColumn(6).setPreferredWidth(150);
            adminui.viewtable.getColumnModel().getColumn(7).setPreferredWidth(150);
            adminui.viewtable.getColumnModel().getColumn(8).setPreferredWidth(60);
            adminui.viewtable.getColumnModel().getColumn(9).setPreferredWidth(120);
            adminui.viewtable.getColumnModel().getColumn(10).setPreferredWidth(80);
            adminui.viewtable.setMinimumSize(new Dimension(600,200));
            JTableHeader header = adminui.viewtable.getTableHeader();
			adminui.tablepane=new JScrollPane();
            adminui.tablepane.setBounds(20,200,1040,300);
			adminui.tablepane.setMinimumSize(new Dimension(600, 23));
			adminui.tablepane.setViewportView(adminui.viewtable);
			adminui.mainpanel.add(adminui.tablepane);
			adminui.viewtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			adminui.mainpanel.setMinimumSize(new Dimension(600,200));
			//adminui.newpanel.add(adminui.mainpanel);
			adminui.adminframe.add(adminui.mainpanel);
			adminui.mainpanel.setVisible(true);
			adminui.adminframe.setVisible(true);
			/*
			 *patientobj.appointmentstatustable=new JTable(rows,column_names);
			patientobj.appointmentstatustable.getColumnModel().getColumn(0).setPreferredWidth(150);
			patientobj.appointmentstatustable.getColumnModel().getColumn(1).setPreferredWidth(150);
			patientobj.appointmentstatustable.getColumnModel().getColumn(2).setPreferredWidth(150);
			patientobj.appointmentstatustable.getColumnModel().getColumn(3).setPreferredWidth(150);
			patientobj.appointmentstatustable.getColumnModel().getColumn(4).setPreferredWidth(150);
			patientobj.appointmentstatustable.getColumnModel().getColumn(5).setPreferredWidth(150);
			patientobj.appointmentstatustable.setMinimumSize(new Dimension(600,200));
			 JTableHeader header = patientobj.appointmentstatustable.getTableHeader();
			 patientobj.appointmentstatuspane=new JScrollPane();
			 patientobj.appointmentstatuspane.setBounds(100,250,900,70);
			// patientobj.specialpane.setMinimumSize(new Dimension(600, 23));
			 patientobj.appointmentstatuspane.setViewportView(patientobj.appointmentstatustable);
			 patientobj.mpatientpanel.add(patientobj.appointmentstatuspane);
			 patientobj.appointmentstatustable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			// patientobj.mpatientpanel.setMinimumSize(new Dimension(600,200));
			 patientobj.patientframe.add(patientobj.mpatientpanel);
			 patientobj.mpatientpanel.setVisible(true);
			 patientobj.patientframe.setVisible(true);
			 */
			
			
			/*JTable table = new JTable(data,col);
		      table.setMinimumSize(new Dimension(600,200));
		      JTableHeader header = table.getTableHeader();
		      JScrollPane pane = new JScrollPane(table);
		      pane.setMinimumSize(new Dimension(600, 23));
		      table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);*/
		}
		if(e.getSource()==adminui.deleteadmin)
		{
			adminui.mainpanel.removeAll();
			//adminui.adminframe.remove(adminui.mainpanel);
			adminui.mainpanel.setVisible(false);
			//adminui.adminframe.setContentPane(adminui.deleteadminpanel);
			adminui.deleteadmin();
			
			ArrayList<DoctorBean> list11=new ArrayList<DoctorBean>();
			Administrator administrator1=new Administrator();
			list11=administrator1.viewAllDoctors();
			int size=list11.size();
			Iterator<DoctorBean> it1=list11.iterator();
			while(it1.hasNext())
			{
				DoctorBean doctorBean=new DoctorBean();
				doctorBean=it1.next();
				adminui.delDoctorIDcombo.addItem(doctorBean.getDoctorID());
						//System.out.println(doctorBean.getDoctorID());
						
						
			}
			
			
			
		}
		if(e.getSource()==adminui.logoutadmin)
		{
			//UI ui = null;
			adminui.mainpanel.removeAll();
			
			adminui.mainpanel.setVisible(false);
			User user=new User();////////?     LOGINID KHA SE AAYEGI??
			JOptionPane pane=new JOptionPane();
			boolean flag=user.logout(adminui.getGetlogoutid());
			if(flag=true)
			{
				pane.showMessageDialog(null,"Successfully Logout");
				adminui.adminframe.setVisible(false);
				UI ui=new UI();
			}
			else
			{
				pane.showMessageDialog(null,"Unable to Logout due to some error");
			}
		}
		if(e.getSource()==adminui.updateadmin)
		{
			adminui.mainpanel.removeAll();
			adminui.mainpanel.setVisible(false);
			adminui.changepassword();
			/*JPopupMenu popup = new JPopupMenu();
	        JTextField field = new JTextField("My text");
	        popup.insert(field, 0);
	        popup.setVisible(true);
	        popup.setBounds(220,220,75,25);
	        adminui.adminframe.add(popup);
	        adminui.adminframe.setVisible(true);*/
		}
		if(e.getSource()==adminui.modifyadmin)
		{
			adminui.mainpanel.removeAll();
			adminui.mainpanel.setVisible(false);
			adminui.modifydoctor();
			ArrayList<DoctorBean> list11=new ArrayList<DoctorBean>();
			Administrator administrator1=new Administrator();
			list11=administrator1.viewAllDoctors();
			int size=list11.size();
			Iterator<DoctorBean> it1=list11.iterator();
			while(it1.hasNext())
			{
				DoctorBean doctorBean=new DoctorBean();
				doctorBean=it1.next();
						adminui.modifyidcombo.addItem(doctorBean.getDoctorID());
						System.out.println(doctorBean.getDoctorID());
			}
		}
		if(e.getSource()==adminui.viewpatientbydate)
		{
			adminui.mainpanel.removeAll();
			adminui.mainpanel.setVisible(false);
			adminui.viewpatientsbydate();
		}
		if(e.getSource()==adminui.confirmappointment){
			adminui.mainpanel.removeAll();
			adminui.mainpanel.setVisible(false);
			adminui.confirmappointment();
			ArrayList<AppointmentBean> list11=new ArrayList<AppointmentBean>();
			Dao dao=new Dao();
			try {
				list11=dao.findAllappointments();
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int size=list11.size();
			Iterator<AppointmentBean> it1=list11.iterator();
			while(it1.hasNext())
			{
				AppointmentBean appointmentBean=new AppointmentBean();
				appointmentBean=it1.next();
						adminui.appointmentfieldtoconfirm.addItem(appointmentBean.getAppointmentID());
						//System.out.println(doctorBean.getDoctorID());
			}
			
		}
		if(e.getSource()==adminui.addDocSchedule)
		{
			adminui.mainpanel.removeAll();
			adminui.mainpanel.setVisible(false);
			adminui.addDocSchedule();
			ArrayList<DoctorBean> list11=new ArrayList<DoctorBean>();
			Administrator administrator1=new Administrator();
			list11=administrator1.viewAllDoctors();
			int size=list11.size();
			Iterator<DoctorBean> it1=list11.iterator();
			while(it1.hasNext())
			{
				DoctorBean doctorBean=new DoctorBean();
				doctorBean=it1.next();
						adminui.addDocIDcombo.addItem(doctorBean.getDoctorID());
						//System.out.println(doctorBean.getDoctorID());
			}
		}
		if(e.getSource()==adminui.modifyDocSchedule)
		{
			adminui.mainpanel.removeAll();
			adminui.mainpanel.setVisible(false);
			adminui.modifyDocSchedule();
			ArrayList<ScheduleBean> list11=new ArrayList<ScheduleBean>();
			Administrator administrator1=new Administrator();
			list11=administrator1.viewScheduledDoctors();
			int size=list11.size();
			Iterator<ScheduleBean> it1=list11.iterator();
			while(it1.hasNext())
			{
				ScheduleBean schedulebean= new ScheduleBean();
				schedulebean=it1.next();
						adminui.modifyDocIDcombo.addItem(schedulebean.getDoctorID());
						//System.out.println(doctorBean.getDoctorID());
			}
		}
		
	}
	@Override
	public void menuDeselected(MenuEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void menuCanceled(MenuEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Administrator administrator=new Administrator();
		DoctorBean doctoerBean=new DoctorBean();
		Dao dao=new Dao();
		String gender="";
		if(e.getSource()==adminui.addbutton)
		{
			String day=(String)adminui.day.getSelectedItem();
	        String month=(String)adminui.month.getSelectedItem();
	        String year=(String)adminui.year.getSelectedItem();
	        String dob=day+"-"+month+"-"+year;
	        
	        String dayofjoining=(String)adminui.dayofjoining.getSelectedItem();
	        String monthofjoining=(String)adminui.monthofjoining.getSelectedItem();
	        String yearofjoining=(String)adminui.yearofjoining.getSelectedItem();
	        String dateofjoining=dayofjoining+"-"+monthofjoining+"-"+yearofjoining;
	        if(adminui.month.getSelectedItem().equals("Feb") &&  (adminui.day.getSelectedItem().equals("31") || adminui.day.getSelectedItem().equals("30"))){
				JOptionPane.showMessageDialog(null,"INVALID DATE IN MONTH");
			}
			else if((adminui.month.getSelectedItem().equals("Apr") || adminui.month.getSelectedItem().equals("Jun")|| adminui.month.getSelectedItem().equals("Sep")  ||adminui.month.getSelectedItem().equals("Nov") )&&  (adminui.day.getSelectedItem().equals("31") )){
				JOptionPane.showMessageDialog(null,"INVALID DATE IN MONTH");
			}
	        
			else
			{
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	        Date date = null;
	        Date doj=null;
	        try 
	        {
				date = formatter.parse(dob);
				doj=formatter.parse(dateofjoining);
			} catch (ParseException e1) 
	        {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			//doctoerBean.setDoctorID(dao.generateCandidateId(doctoerBean.getDoctorName()));
			/*try {
				//adminui.idfield.setText(dao.generateCandidateId(doctoerBean.getDoctorName()));
				if(!adminui.namefield.getText().trim().matches("[a-zA-Z]+") || adminui.namefield.getText().length()<2 ){
					JOptionPane.showMessageDialog(null, "ENTER VALID NAME");
				}else{
				doctoerBean.setDoctorName(adminui.namefield.getText());
				doctoerBean.setDoctorID(dao.generateCandidateId(doctoerBean.getDoctorName()));
				adminui.idfield.setText(doctoerBean.getDoctorID());
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String day=(String)adminui.day.getSelectedItem();
	        String month=(String)adminui.month.getSelectedItem();
	        String year=(String)adminui.year.getSelectedItem();
	        String dob=day+"-"+month+"-"+year;
	        
	        String dayofjoining=(String)adminui.dayofjoining.getSelectedItem();
	        String monthofjoining=(String)adminui.monthofjoining.getSelectedItem();
	        String yearofjoining=(String)adminui.yearofjoining.getSelectedItem();
	        String dateofjoining=dayofjoining+"-"+monthofjoining+"-"+yearofjoining;
	       
	        
	        
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	        Date date = null;
	        Date doj=null;
			try {
				//date = formatter.parse(dob);
				//doj=formatter.parse(dateofjoining);
				if(Integer.parseInt(year)<Integer.parseInt(yearofjoining) && Integer.parseInt(year)+25<Integer.parseInt(yearofjoining)){
					 date = formatter.parse(dob);
						doj=formatter.parse(dateofjoining);
						doctoerBean.setDateOfBirth(date);
						doctoerBean.setDateOfJoining(doj);
			        }else{
			        	JOptionPane.showMessageDialog(null, "INVALID DATE OF JOINING");
			        }
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			if(adminui.group.getSelection()==null){
				JOptionPane.showMessageDialog(null, "SELECT GENDER");
			}
			else{
			if(adminui.malebutton.isSelected()){
		        gender=adminui.malebutton.getText();
		        }
		        if(adminui.femalebutton.isSelected()){
		        gender=adminui.femalebutton.getText();
		        }
			doctoerBean.setGender(gender);
			}
			if(adminui.qualificationfield.getText().trim().length()<2){
				JOptionPane.showMessageDialog(null, "ENTER VALID QUALIFICATION");
			}else{
				doctoerBean.setQualification(adminui.qualificationfield.getText());
			}
			if((adminui.yearsofexperiencefield.getText()).trim().matches("[a-zA-Z]+") ){
				JOptionPane.showMessageDialog(null, "INVALID YEARS OF EXPERIENCE");
			}
			else{
				doctoerBean.setYearsOfExperience(Integer.parseInt(adminui.yearsofexperiencefield.getText()));
			}
			if(adminui.streetarea.getText().length()==0){
				JOptionPane.showMessageDialog(null, "PLEASE ENTER STREET AREA");
			}else
			{
			doctoerBean.setStreet(adminui.streetarea.getText());
			}
			if(adminui.locationfield.getText().length()==0){
				JOptionPane.showMessageDialog(null, "PLEASE ENTER LOCATION");
			}else
			{
			doctoerBean.setLocation(adminui.locationfield.getText());
			}
			if(adminui.cityfield.getText().length()==0){
				JOptionPane.showMessageDialog(null, "PLEASE ENTER CITY");
			}else
			{
			doctoerBean.setCity(adminui.cityfield.getText());
			}
			if(adminui.statefield.getText().length()==0){
				JOptionPane.showMessageDialog(null, "PLEASE ENTER STATE");
			}else
			{
			doctoerBean.setState(adminui.statefield.getText());
			}
			if(adminui.pincodefield.getText().length()<6 || !(adminui.pincodefield.getText().matches("[0-9]+"))){
				JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID PINCODE");
			}else
			{
			doctoerBean.setPincode(adminui.pincodefield.getText());
			}
			if(adminui.contactnumberfield.getText().length()<10 || !(adminui.contactnumberfield.getText().matches("[0-9]+") )){
				JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID MOBILE NUMBER");
			}
			else
			{
			doctoerBean.setContactNumber(adminui.contactnumberfield.getText());
			}
			if(adminui.emailidfield.getText().length()<10){
				JOptionPane.showMessageDialog(null, "PLEASE ENTER VALID EMAILID");
			}else{
			doctoerBean.setEmailID(adminui.emailidfield.getText());
			}
			doctoerBean.setSpecialization((String)adminui.specializationbox.getSelectedItem());
			
			String result=administrator.addDoctor(doctoerBean);
			JOptionPane pane=new JOptionPane();
			pane.showMessageDialog(null, result);*/
			//--------------------------
	        if(adminui.namefield.getText().trim().length()!=0&&adminui.namefield.getText().trim().matches("[a-zA-Z ]+") && adminui.namefield.getText().trim().length()>=2)
			 {
				 if(Integer.parseInt(year)<Integer.parseInt(yearofjoining) && Integer.parseInt(year)+25<Integer.parseInt(yearofjoining))
				 {
					 if(!(adminui.group.getSelection()==null))
					 {
						 if(adminui.qualificationfield.getText().trim().length()>=2 && adminui.qualificationfield.getText().trim().matches("[a-zA-Z ]+") )
						 {
							 if(!(adminui.yearsofexperiencefield.getText().trim().matches("[a-zA-Z]+") ) && adminui.yearsofexperiencefield.getText().length()>0)
							 {
								 if(!(adminui.streetarea.getText().trim().length()==0))
								 {
									 if(!(adminui.locationfield.getText().length()==0)&& adminui.locationfield.getText().trim().matches("[a-zA-Z]+"))
									 {
										 if((!(adminui.cityfield.getText().length()==0))&&adminui.cityfield.getText().matches("[a-zA-Z ]+"))
										 {
											 if((!(adminui.statefield.getText().length()==0))&&adminui.statefield.getText().matches("[a-zA-Z ]+"))
											 {
												 if(adminui.pincodefield.getText().trim().length()==6 && (adminui.pincodefield.getText().matches("[0-9]+"))&& !adminui.pincodefield.getText().equals("000000"))
												 { 
													 if(adminui.contactnumberfield.getText().length()==10 && (adminui.contactnumberfield.getText().matches("[0-9]+") &&!adminui.contactnumberfield.getText().equals("0000000000") ))
													 { 
														 if(adminui.emailidfield.getText().length()>=10 && adminui.emailidfield.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
														 {
															 doctoerBean.setDoctorName(adminui.namefield.getText());
																try
																{
																	doctoerBean.setDoctorID(dao.generateCandidateId(doctoerBean.getDoctorName()));
																} catch (
																		ClassNotFoundException
																		| SQLException e1)
																{
																	// TODO Auto-generated catch block
																	e1.printStackTrace();
																}
																adminui.idfield.setText(doctoerBean.getDoctorID());
																System.out.println("doctor ID"+doctoerBean.getDoctorID());
																doctoerBean.setDateOfBirth(date);
																doctoerBean.setDateOfJoining(doj);
																if(adminui.malebutton.isSelected()){
															        gender=adminui.malebutton.getText();
															        }
															        if(adminui.femalebutton.isSelected()){
															        gender=adminui.femalebutton.getText();
															        }
																doctoerBean.setGender(gender);
																doctoerBean.setQualification(adminui.qualificationfield.getText());
																doctoerBean.setYearsOfExperience(Integer.parseInt(adminui.yearsofexperiencefield.getText()));
																doctoerBean.setStreet(adminui.streetarea.getText());
																doctoerBean.setLocation(adminui.locationfield.getText());
																doctoerBean.setCity(adminui.cityfield.getText());
																doctoerBean.setState(adminui.statefield.getText());
																doctoerBean.setPincode(adminui.pincodefield.getText());
																doctoerBean.setContactNumber(adminui.contactnumberfield.getText());
																doctoerBean.setEmailID(adminui.emailidfield.getText());
																doctoerBean.setSpecialization((String)adminui.specializationbox.getSelectedItem());
									
																String result=administrator.addDoctor(doctoerBean);
																doctoerBean.setDoctorName("");
																JOptionPane pane=new JOptionPane();
																pane.showMessageDialog(null, result);
																adminui.mainpanel.setVisible(false);
																
														 }
														 else if(adminui.emailidfield.getText().length()==0 )
														 {
															 JOptionPane.showMessageDialog(null, "EMAIL CAN NOT BE EMPTY");
															 
														 }
														 else if(!adminui.emailidfield.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
														 {
															 JOptionPane.showMessageDialog(null,"EMAIL SHOULD BE IN THE FORMATE OF eg. xyzQ@adc.com !!");
														 }
														 else if(adminui.emailidfield.getText().length()<10 )
														 {
															 JOptionPane.showMessageDialog(null, "EMAIL MUST BE ATLEAST OF 10 CHARACTERS");
															 
														 }
													 }
													 else if(adminui.contactnumberfield.getText().equals("0000000000"))
													 {
														 JOptionPane.showMessageDialog(null, " OPPS!! MOBILE NUMBER CAN NOT BE 0000000000");
													 }
													 else if(adminui.contactnumberfield.getText().trim().length()==0)
													 {
														 JOptionPane.showMessageDialog(null, "MOBILE NUMBER CAN NOT BE EMPTY");
													 }else if(adminui.contactnumberfield.getText().trim().length()!=10){
														 JOptionPane.showMessageDialog(null, "MOBILE NUMBER MUST CONTAIN 10 DIGITS");
													 }
													 else if(!adminui.contactnumberfield.getText().matches("[0-9]+"))
													 {
														 JOptionPane.showMessageDialog(null, "CONTACT NUMBER MUST CONTAIN DIGITS ONLY");
													 }
												 }
												 else if (adminui.pincodefield.getText().equals("000000"))
												 {
													 JOptionPane.showMessageDialog(null, "PINCODE CAN NOT BE 000000");
												 }
												 else if(adminui.pincodefield.getText().trim().length()==0)
												 {
													 JOptionPane.showMessageDialog(null, "PINCODE CAN NOT BE EMPTY");
												 }
												 else if(!adminui.pincodefield.getText().matches("[0-9]+"))
												 {
													 JOptionPane.showMessageDialog(null, "PLEASE ENTER NUMBERS PINCODE ONLY");
												 }
												 else if(adminui.pincodefield.getText().trim().length()!=6)
												 {
													 JOptionPane.showMessageDialog(null, "PLEASE ENTER ONLY SIX DIGIT PINCODE");
												 }
											 }
											 else if (adminui.statefield.getText().length()==0)
											 {
												 JOptionPane.showMessageDialog(null, "STATE CAN NOT EMPTY");
											 }
											 else if(!adminui.statefield.getText().trim().matches("[a-zA-Z]+"))
											 {
												 JOptionPane.showMessageDialog(null, "STATE MUST CONTAIN CHARACTERS ONLY");
											 }
											 
										 }
										 else if (adminui.cityfield.getText().length()==0)
										 {
											 JOptionPane.showMessageDialog(null, "CITY CAN NOT EMPTY");
										 }
										 else if(!adminui.cityfield.getText().trim().matches("[a-zA-Z]+"))
										 {
											 JOptionPane.showMessageDialog(null, "CITY MUST CONTAIN CHARACTERS ONLY");
										 }
										
									 }
									 else if (adminui.locationfield.getText().length()==0)
									 {
										 JOptionPane.showMessageDialog(null, "LOCATION CAN NOT BE EMPTY");
									 }
									 else if(!adminui.locationfield.getText().trim().matches("[a-zA-Z]+"))
									 {
										 JOptionPane.showMessageDialog(null, "LOCATION MUST CONTAIN CHARACTERS ONLY");
									 }
									
								 }
								 else if(adminui.streetarea.getText().trim().length()==0)
								 {
									 JOptionPane.showMessageDialog(null, "PLEASE ENTER STREET AREA");
								 }
							 }
							 else if(adminui.yearsofexperiencefield.getText().length()==0)
							 {
								 JOptionPane.showMessageDialog(null, "YEARS OF EXPERIENCE CAN NOT BE EMPTY");
							 }
							 else if(adminui.yearsofexperiencefield.getText().trim().matches("[a-zA-Z]+"))
							 {
								 JOptionPane.showMessageDialog(null, "YEARS OF EXPERIENCE MUST CONTAIN NUMBERS ONLY");
							 }
							 else if(adminui.yearsofexperiencefield.getText().length()<0)
							 {
								 JOptionPane.showMessageDialog(null, "YEARS OF EXPERIENCE CAN NOT CONTAIN NEGATIVE VALUE");
							 }
							 
						 }
						 else if(adminui.qualificationfield.getText().trim().length()==0)
						 {
							 JOptionPane.showMessageDialog(null, "QUALIFICATION CAN NOT BE EMPTY");
						 }
						 else if(adminui.qualificationfield.getText().trim().length()<2)
						 {
							 JOptionPane.showMessageDialog(null, "QUALIFICATION MUST CONTAINS ATLEAST 2 CHARACTERS");
						 }
						 else if(!adminui.qualificationfield.getText().trim().matches("[a-zA-Z ]+"))
						 {
							 JOptionPane.showMessageDialog(null, "ONLY CHARACTERS ARE ALLOWED IN QUALIFICATION");
						 }
						 
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "SELECT GENDER");
					 }
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null, "DATE OF JOINING MUST BE 25 YEARS MORE THAN THE DATE OF BIRTH");
				 }
			 }
			 else if(adminui.namefield.getText().trim().length()==0)
			 {
				 JOptionPane.showMessageDialog(null, "NAME CAN NOT BE EMPTY");
			 }
			 else if(adminui.namefield.getText().trim().length()<2)
			 {
				 JOptionPane.showMessageDialog(null, "NAME MUST CONTAN ATLEAST 2 CHARACTERS");
			 }
			 else if(!adminui.namefield.getText().trim().matches("[a-zA-Z ]+"))
			 {
				 JOptionPane.showMessageDialog(null, "NAME MUST CONTAN CHARACTERS ONLY");
			 }
			 
			}  
			  
			  
			 
		}
		if(e.getSource()==adminui.deletebutton)
		{
			String docID=(String) adminui.delDoctorIDcombo.getSelectedItem();
			//DoctorBean doctorbean= new DoctorBean();
			doctoerBean.setDoctorID(docID);
			Administrator admin= new Administrator();
			JOptionPane.showMessageDialog(null,	admin.deleteDoctorByID(doctoerBean.getDoctorID()));
			adminui.mainpanel.setVisible(false);
		}
		if(e.getSource()==adminui.changebutton)
		{
			CredentialsBean bean=new CredentialsBean();
			bean.setUserID(adminui.idfieldpass.getText());
			bean.setPassword(adminui.oldidfield.getText());
			String oldpass=String.valueOf(adminui.oldidfield.getText());
			String newpswrd=String.valueOf(adminui.newidfield.getText());
			String retypenewpswrd=String.valueOf(adminui.matchidfield.getText());
				
			if(!(newpswrd.equals(retypenewpswrd)))
			{
				JOptionPane.showMessageDialog(null,"PASSWORD DOES NOT MATCH");
			}
			else
			{
				if(newpswrd.equals(oldpass))
				{
					JOptionPane.showMessageDialog(null, "NEW PASSWORD CAN NOT BE SAME AS OLD PASSWORD");
				}
				else
				{
					
					if(administrator.changePassword(bean, newpswrd).equals("exists"))
					  {
						JOptionPane.showMessageDialog(null,"NEW PASSWORD UPDATED");
					  }
				    	else 
					   {
						JOptionPane.showMessageDialog(null,"USER DOES NOT EXIST");
					   }
				}
			  
			}
		}
			
			
		
		if(e.getSource()==adminui.showbutton)
		{	
			
			String doctorId=(String) adminui.modifyidcombo.getSelectedItem();
			//System.out.println(adminui.modifyidfield.getText());
			doctoerBean.setDoctorID(doctorId);
			boolean status=administrator.modifyDoctor(doctoerBean);
			System.out.println(status);
			if(status==true)
			{	
				
				/*for(int i=0;i<adminui.size;i++){
					DoctorBean doctorBean=new DoctorBean();
				adminui.modifyidcombo.setSelectedItem(list11.get(i).doctorBean);
				}*/
				adminui.modifynamefield.setText(doctoerBean.getDoctorName());
				adminui.modifyqualificationfield.setText(doctoerBean.getQualification());
				adminui.modifyyearsofexperiencefield.setText(String.valueOf(doctoerBean.getYearsOfExperience()));
				adminui.modifylocationfield.setText(doctoerBean.getLocation());
				adminui.modifycityfield.setText(doctoerBean.getCity());
				adminui.modifystatefield.setText(doctoerBean.getState());
				adminui.modifypincodefield.setText(doctoerBean.getPincode());
				adminui.modifycontactnumberfield.setText(doctoerBean.getContactNumber());
				adminui.modifyemailidfield.setText(doctoerBean.getEmailID());
				adminui.modifystreetarea.setText(doctoerBean.getStreet());
				String genderget=doctoerBean.getGender();
				if(genderget.equalsIgnoreCase("Male"))
				{
					adminui.modifymalebutton.setSelected(true);
					adminui.modifyfemalebutton.setSelected(false);
				}
				else if(genderget.equals("Female"))
				{
					adminui.modifyfemalebutton.setSelected(true);
					adminui.modifymalebutton.setSelected(false);
				}
		
				String specialization=doctoerBean.getSpecialization();
				adminui.modifyspecializationbox.setSelectedItem(specialization);
			
				DateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
				Date dob=doctoerBean.getDateOfBirth();
				String dobs=df.format(dob);
				
				String str[]=dobs.split("-");
				
				adminui.modifyday.setSelectedItem(str[0]);
				adminui.modifymonth.setSelectedItem(str[1]);
				adminui.modifyyear.setSelectedItem(str[2]);
			
			
				Date doj=doctoerBean.getDateOfJoining();
				String dojs=df.format(doj);
			
				String strs[]=dojs.split("-");
				adminui.modifydayofjoining.setSelectedItem(strs[0]);
				adminui.modifymonthofjoining.setSelectedItem(strs[1]);
				adminui.modifyyearofjoining.setSelectedItem(strs[2]);
			
			
			}
		
		}
		if(e.getSource()==adminui.updatebutton)
		{

		/*	
			
			doctoerBean.setDoctorName(adminui.modifynamefield.getText());
			doctoerBean.setQualification(adminui.modifyqualificationfield.getText());
			doctoerBean.setYearsOfExperience(Integer.parseInt(adminui.modifyyearsofexperiencefield.getText()));
			doctoerBean.setStreet(adminui.modifystreetarea.getText());
			doctoerBean.setLocation(adminui.modifylocationfield.getText());
			doctoerBean.setCity(adminui.modifycityfield.getText());
			doctoerBean.setState(adminui.modifystatefield.getText());
			doctoerBean.setPincode(adminui.modifypincodefield.getText());
			doctoerBean.setContactNumber(adminui.modifycontactnumberfield.getText());
			doctoerBean.setEmailID(adminui.modifyemailidfield.getText());
			if(adminui.modifymalebutton.isSelected()==true)
			{
				doctoerBean.setGender("Male");
				
			}
			else
			{
				doctoerBean.setGender("Female");
			}
		
			doctoerBean.setSpecialization(String.valueOf(adminui.modifyspecializationbox.getSelectedItem()));
		   String day=String.valueOf(adminui.modifyday.getSelectedItem());
		   String month=String.valueOf(adminui.modifymonth.getSelectedItem());
		   String year=String.valueOf(adminui.modifyyear.getSelectedItem());
		
		   String dob=day + "-" + month + "-" + year;
		   SimpleDateFormat dd=new SimpleDateFormat("dd-MMM-yyyy");
		   try 
		   {
			   Date date=dd.parse(dob);
			   doctoerBean.setDateOfBirth(date);
			
			   String days=String.valueOf(adminui.modifydayofjoining.getSelectedItem());
			   String months=String.valueOf(adminui.modifymonthofjoining.getSelectedItem());
			   String years=String.valueOf(adminui.modifyyearofjoining.getSelectedItem());
		   
			   String doj=days + "-" + months + "-" + years;
		   
			   Date dates=dd.parse(doj);
			   doctoerBean.setDateOfJoining(dates);
			   
			   String doctorIds=(String)adminui.modifyidcombo.getSelectedItem();
			   doctoerBean.setDoctorID(doctorIds);
		   
			   JOptionPane.showMessageDialog(null, administrator.updateDoctorDetails(doctoerBean,doctorIds));  
		   
		   } 
		   catch (ParseException e1)
		   {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		   }*/
			


			if(adminui.modifynamefield.getText().trim().length()>=2)
			{
					if(adminui.modifynamefield.getText().trim().matches("[a-zA-Z ]+"))
					{
						doctoerBean.setDoctorName(adminui.modifynamefield.getText().trim());
				
						String day=String.valueOf(adminui.modifyday.getSelectedItem());
						String month=String.valueOf(adminui.modifymonth.getSelectedItem());
						String year=String.valueOf(adminui.modifyyear.getSelectedItem());

						String dob=day + "-" + month + "-" + year;
						SimpleDateFormat dd=new SimpleDateFormat("dd-MMM-yyyy");
						try 
						{
								Date date=dd.parse(dob);
								Date datee=new Date();
								if(datee.compareTo(date)>0 && (datee.getYear()-date.getYear()>=18))
								{
										doctoerBean.setDateOfBirth(date);
										String days=String.valueOf(adminui.modifydayofjoining.getSelectedItem());
										String months=String.valueOf(adminui.modifymonthofjoining.getSelectedItem());
										String years=String.valueOf(adminui.modifyyearofjoining.getSelectedItem());

										String doj=days + "-" + months + "-" + years;

										Date dates=dd.parse(doj);
										Date dots=new Date();
									
										if(dots.compareTo(dates)>0)
										{
												doctoerBean.setDateOfJoining(dates);
												boolean flag=false;
												if(adminui.modifymalebutton.isSelected())
												{
													flag=true;
													doctoerBean.setGender("Male");
	
												}
												else if(adminui.modifyfemalebutton.isSelected())
												{
													flag=true;
													doctoerBean.setGender("Female");
												}
												
												if(flag==false)
												{
													JOptionPane.showMessageDialog(null, "SELECT GENDER");
												}
									            if(flag==true)
									            {	
									
									            	String quali=adminui.modifyqualificationfield.getText();
						                            if(adminui.modifyqualificationfield.getText().trim().length()>=2)
						                            {	
														if(adminui.modifyqualificationfield.getText().trim().matches("[a-zA-Z ]+"))
														{	
															doctoerBean.setQualification(adminui.modifyqualificationfield.getText().trim());
															doctoerBean.setSpecialization(String.valueOf(adminui.modifyspecializationbox.getSelectedItem()));
						                                    if(!adminui.modifyyearsofexperiencefield.getText().trim().isEmpty())
						                                    {
						
						                                         if(adminui.modifyyearsofexperiencefield.getText().trim().matches("[0-9]+")&&Integer.parseInt(adminui.modifyyearsofexperiencefield.getText().trim())>=0)
						                                         {
						                                        	 doctoerBean.setYearsOfExperience(Integer.parseInt(adminui.modifyyearsofexperiencefield.getText().trim()));
						                                        	 if(adminui.modifystreetarea.getText().trim().length()==0)
						                                        	 {	 
						                                        		 JOptionPane.showMessageDialog(null, "STREET FIELD CANNOT BE EMPTY");
						                                        		 
						                                        	 }
						                                        	 else
						                                        	 {
																			
																			doctoerBean.setStreet(adminui.modifystreetarea.getText().trim());
																					
																			if(adminui.modifylocationfield.getText().trim().length()==0)
																			{
																				JOptionPane.showMessageDialog(null, "LOCATION FIELD CANNOT BE EMPTY");
																			}
																			else if(!(adminui.modifylocationfield.getText().trim().matches("[a-zA-Z ]+")))
																			{
																				JOptionPane.showMessageDialog(null,"LOCATION FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
																				
																			}
																			else
																			{
																				doctoerBean.setLocation(adminui.modifylocationfield.getText().trim());
																			
																			    if(adminui.modifycityfield.getText().trim().length()==0)
																			    {
																			    	JOptionPane.showMessageDialog(null, "CITY FIELD CANNOT BE EMPTY");
																			    }	
																			    else if(!(adminui.modifycityfield.getText().trim().matches("[a-zA-Z ]+")))
																				{
																					JOptionPane.showMessageDialog(null,"CITY FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
																					
																				}
																			    else
																			    {
																			    	doctoerBean.setCity(adminui.modifycityfield.getText().trim());
																			    	
																			    	if(adminui.modifystatefield.getText().trim().length()==0)
																			    	{
																			    		JOptionPane.showMessageDialog(null, "STATE FIELD CANNOT BE EMPTY");
																			    		
																			    	}
																			    	else if(!(adminui.modifystatefield.getText().trim().matches("[a-zA-Z ]+")))
																					{
																							JOptionPane.showMessageDialog(null,"STATE FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
																							
																					}
																			    	else
																			    	{
																			    		doctoerBean.setState(adminui.modifystatefield.getText().trim());
																			    		 
																			    		if(adminui.modifypincodefield.getText().trim().length()==0)
																			    		{
																			    			JOptionPane.showMessageDialog(null, "PINCODE FIELD CANNOT BE EMPTY");
																			    		}
																			    		else if(!(adminui.modifypincodefield.getText().trim().matches("[0-9]+")))
																			    		{
																			    			JOptionPane.showMessageDialog(null, "PINCODE FIELD SHOULD CONTAIN NUMERIC DIGIT");
																			    			
																			    		}
																			    		else if(adminui.modifypincodefield.getText().trim().length()!=6)
																			    		{
																			    			JOptionPane.showMessageDialog(null, "PINCODE FIELD SHOULD CONTAIN 6 DIGITS");	
																			    			
																			    		}
																			    		else
																			    		{
																			    			doctoerBean.setPincode(adminui.modifypincodefield.getText().trim());
																			    			
																			    			if(adminui.modifycontactnumberfield.getText().trim().length()==0)
																			    			{
																			    				JOptionPane.showMessageDialog(null, "CONTACTNO. FIELD CANNOT BE EMPTY");
																			    				
																			    			}
																			    			else if(!(adminui.modifycontactnumberfield.getText().trim().matches("[0-9]+")))
																			    			{
																			    				JOptionPane.showMessageDialog(null, "CONTACTNO. FIELD SHOULD CONTAIN NUMERIC DIGIT");	
																			    				
																			    			}
																			    			else if(adminui.modifycontactnumberfield.getText().trim().length()!=10)
																			    			{
																			    				JOptionPane.showMessageDialog(null, "CONTACTNO. FIELD SHOULD CONTAIN 10 DIGITS");	
																			    				
																			    			}
																			    			else
																			    			{
																			    				doctoerBean.setContactNumber(adminui.modifycontactnumberfield.getText().trim());
																			    				
																			    				if(adminui.modifyemailidfield.getText().trim().length()==0)
																			    				{
																			    					
																			    					JOptionPane.showMessageDialog(null, "EMAIL FIELD CANNOT BE EMPTY");
																			    					
																			    				}
																			    				else if(adminui.modifyemailidfield.getText().trim().matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+" ))
																			    				{
																			    					
																			    					JOptionPane.showMessageDialog(null, "EMAIL FIELD SHOULD CONTAIN NUMBERS,ALPHABETIC CHARACTERS OR SPECIAL CHARACTERS");
																			    				}
																			    				else
																			    				{
																								
																									
																									doctoerBean.setEmailID(adminui.modifyemailidfield.getText().trim());
														
		
																									     String doctorIds=(String)adminui.modifyidcombo.getSelectedItem();
																									     doctoerBean.setDoctorID(doctorIds);
																		    							 JOptionPane.showMessageDialog(null, administrator.updateDoctorDetails(doctoerBean,doctorIds));
														
			
																			    				}
			   
																						
																			    			}		
																									
																			    		}			
																									
		   
																			    	}					  
														
																			    }
																			}							
																										
						                                        	 }
						                                         }
						                                         else if(Integer.parseInt(adminui.modifyyearsofexperiencefield.getText().trim())<0)
						                                         {
						                                        	 JOptionPane.showMessageDialog(null, "YEARS OF EXPERIENCE CAN NOT BE LESS THAN ZERO");
						                                         }
						                                         else
						                                         {
						                                        	 JOptionPane.showMessageDialog(null, "YEARS OF EXPERIENCE FIELD SHOULD CONTAIN NUMERIC DIGIT");
						                                         }
						                                    
						                                    }
						                                    else
						                                    {
						                                    	
						                                    	JOptionPane.showMessageDialog(null,"YEARS OF EXPERIENCE FIELD CANNOT BE EMPTY");
						                                    	
						                                    }
						                                    
						                                    
						                                }
														else
														{
															JOptionPane.showMessageDialog(null,"QUALIFICATION FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
														}
						                            
													}
						                            else if(adminui.modifyqualificationfield.getText().trim().isEmpty())
						                            {
						                            	JOptionPane.showMessageDialog(null, "QUALIFICATION FIELD CANNOT BE EMPTY");
						                            	
						                            }
						                            else
						                            {
						                            	
						                            	JOptionPane.showMessageDialog(null, "QUALIFICATION FIELD SHOULD BE GREATER THAN 2 CHARACTERS");
						                            	
						                            }
								
									             }
								
										}
										else
										{
											JOptionPane.showMessageDialog(null,"DATE OF JOINING SHOULD BE BEFORE CURRENT DATE");
										}
								
								   }
								   else
								   {
									   JOptionPane.showMessageDialog(null, "DOB SHOULD BE GREATER THAN OR EQUAL TO 18 YEARS");
								   }
								
						}								 
					    catch (ParseException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}								
							
								
								
														
					}
					else
					{
						JOptionPane.showMessageDialog(null,"NAME FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
						
					}
														
		
			}
			
		    else if(adminui.modifynamefield.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"NAME FIELD CANNOT BE  EMPTY");
			}
			
			else
			{
				
				JOptionPane.showMessageDialog(null,"DOCTOR NAME SHOULD BE GREATER THAN 2 CHARACTERS");
			}
			
			
			
			
	   
		
		}
		if(e.getSource()==adminui.viewpatientbydatebutton)
		{
			
			adminui.mainpanel.setLayout(null);
			Map<PatientBean,AppointmentBean> newmap=new HashMap<PatientBean,AppointmentBean>();
			
			 String days=(String)adminui.viewpatientdate.getSelectedItem();
			// System.out.println(days);
			   String months=(String)adminui.viewpatientmonth.getSelectedItem();
			   //System.out.println(months);
			   String years=(String)adminui.viewpatientyear.getSelectedItem();
			   String appointmentdate=days+"-"+months+"-"+years;
			   SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			   //System.out.println(appointmentdate);
			   //String date=formatter.format(appointmentdate);
		        Date appointmentbydate = null;
				try 
				{
					appointmentbydate = formatter.parse(appointmentdate);
					//System.out.println(appointmentbydate);
					newmap=administrator.viewPatientsByDate(appointmentbydate);
					String column_names[]={"PATIENTID","APPOINTMENT_DATE","APPOINTMENTID","DOCTORID","APPOINTMENT_TIME","USERID","AILMENT_TYPE","AILMENT_DETAILS","DIAGNOSIS_HISTORY"};
					Object rows[][]=new Object[newmap.size()][9];
					//System.out.println(newmap.size());
					int index = 0;
					Set<PatientBean> s= newmap.keySet();
					//System.out.println(newmap.keySet().size());
	                  Iterator i = s.iterator();
	                  while(i.hasNext())
	                  {
	                	  PatientBean patientBean=new PatientBean();
	          			AppointmentBean appointmentBean=new AppointmentBean();
	                	  patientBean=(PatientBean) i.next();
	                	  appointmentBean=newmap.get(patientBean);
	                	  rows[index][0]=patientBean.getPatientID();
	                	  System.out.println(patientBean.getPatientID());
	                	  rows[index][1]=patientBean.getAppointmentDate();
	                	  rows[index][2]=appointmentBean.getAppointmentID();
	                	  rows[index][3]=appointmentBean.getDoctorID();
	                	  rows[index][4]=appointmentBean.getAppointmentTime();
	                	  rows[index][5]=patientBean.getUserID();
	                	  rows[index][6]=patientBean.getAilmentType();
	                	  rows[index][7]=patientBean.getAilmentDetails();
	                	  rows[index][8]=patientBean.getDiagnosisHistory();
	                	  System.out.println(patientBean.getDiagnosisHistory());
	                			  index++;
	                  }
	                  
	                  adminui.appointmentdatetabel=new JTable(rows,column_names);
	                  adminui.appointmentdatetabel.setMinimumSize(new Dimension(600,200));
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(0).setPreferredWidth(100);
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(1).setPreferredWidth(150);
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(2).setPreferredWidth(100);
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(3).setPreferredWidth(80);
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(4).setPreferredWidth(150);
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(5).setPreferredWidth(60);
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(6).setPreferredWidth(100);
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(7).setPreferredWidth(120);
	                  adminui.appointmentdatetabel.getColumnModel().getColumn(8).setPreferredWidth(150);
	                  adminui.appointmentdatetabel.setMinimumSize(new Dimension(600,200));
	     			 JTableHeader header = adminui.appointmentdatetabel.getTableHeader();
	     			adminui.appointmentpane=new JScrollPane();
	     			adminui.appointmentpane.setBounds(20,200,1010,200);
	     			//adminui.appointmentpane.setBounds(adminui.appointmentdatetabel.getBounds());
	     			adminui.appointmentpane.setMinimumSize(new Dimension(600, 23));
	     			adminui.appointmentpane.setViewportView(adminui.appointmentdatetabel);
	     			adminui.mainpanel.add(adminui.appointmentpane);
	     			adminui.appointmentdatetabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	     			adminui.mainpanel.setMinimumSize(new Dimension(600,200));
	     			//adminui.newpanel.add(adminui.mainpanel);
	     			adminui.adminframe.add(adminui.mainpanel);
	     			adminui.mainpanel.setVisible(true);
	     			adminui.adminframe.setVisible(true);
	     			//-------------
	     			
	     			/*JFrame frame = new JFrame();
	     			frame.getContentPane().add(adminui.appointmentpane);
	     			frame.pack();
	     			frame.setVisible(true);*/
					/*for (PatientBean key : newmap.keySet())
					{
					    Student student = students.get(key);
					    tableData[index][0] = student.getXXX
					    tableData[index][1] = student.getYYY
					    tableData[index][2] = student.getZZZ
					    // and so forth
					    index++;
					}*/
				} 
				catch (ParseException e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		if(e.getSource()==adminui.confirmbutton){
			boolean flag;
			Administrator admin=new Administrator();
			//str=(String)adminui.appointmentfieldtoconfirm.getSelectedItem();
			flag=admin.updatestatusbyappointmentid((String)adminui.appointmentfieldtoconfirm.getSelectedItem());
			
			if(flag==true){
				//adminui.appointmentfieldtoconfirm.setSelectedItem(PatientListener.appointmentid);
				adminui.statusfieldtoconfirm.setText("CONFIRM");
				JOptionPane.showMessageDialog(null,"APPOINTMENT OF "+" "+ (String)adminui.appointmentfieldtoconfirm.getSelectedItem()+" "+"is confirmed");
			}else{
				//adminui.appointmentfieldtoconfirm.setSelectedItem(PatientListener.appointmentid);
				adminui.statusfieldtoconfirm.setText("FAIL"
						+ "");
				JOptionPane.showMessageDialog(null,"FIRST TAKE APPOINTMENT");
			}
			adminui.mainpanel.setVisible(true);
 			adminui.adminframe.setVisible(true);
			
		}
		
		//-------------------------
		if(e.getSource()==adminui.submitbtnsch)
		{
			ScheduleBean schedulebean= new ScheduleBean();
			Administrator admin= new Administrator();
			
			schedulebean.setScheduleID(admin.generateScheduleId(schedulebean));
			schedulebean.setDoctorID((String)adminui.addDocIDcombo.getSelectedItem());
			
			schedulebean.setSlots((String)adminui.combs.getSelectedItem());
			String availabledays=" ";
			if(adminui.mondaychk.isSelected())
			{
				
				availabledays=availabledays+adminui.mondaychk.getText()+" ";
				
			}
			if(adminui.tuesdaychk.isSelected())
			{
				
				availabledays=availabledays+adminui.tuesdaychk.getText()+" ";
				
			}
			if(adminui.wednsdaychk.isSelected())
			{
			
				availabledays=availabledays+adminui.wednsdaychk.getText()+" ";
				
			}
			if(adminui.thrusdaychk.isSelected())
			{
				
				availabledays=availabledays+adminui.thrusdaychk.getText()+" ";
				
			}
			if(adminui.fridaychk.isSelected())
			{
				
				availabledays=availabledays+adminui.fridaychk.getText()+" ";
				
			}
			schedulebean.setAvailableDays(availabledays.trim());
			
			adminui.addSchIDtxtfield.setText(schedulebean.getScheduleID());
			
			admin.addScheduleDetails(schedulebean);
			
			 JOptionPane.showMessageDialog(null, "SCHEDULE SUCCESSFULLY ADDED");
			 adminui.mainpanel.setVisible(false);
		}
		if(e.getSource()==adminui.modifysubmitbtnsch)
		{
			ScheduleBean schedulebean= new ScheduleBean();
			Administrator admin= new Administrator();
			
			
			schedulebean.setDoctorID((String)adminui.modifyDocIDcombo.getSelectedItem());
			schedulebean.setSlots((String)adminui.modifycombs.getSelectedItem());
			
			String availabledays=" ";
			if(adminui.modifymondaychk.isSelected())
			{
				availabledays=availabledays+adminui.modifymondaychk.getText()+" ";
			}
			if(adminui.modifytuesdaychk.isSelected())
			{
				availabledays=availabledays+adminui.modifytuesdaychk.getText()+" ";
			}
			if(adminui.modifywednsdaychk.isSelected())
			{
				availabledays=availabledays+adminui.modifywednsdaychk.getText()+" ";
			}
			if(adminui.modifythrusdaychk.isSelected())
			{
				availabledays=availabledays+adminui.modifythrusdaychk.getText()+" ";
			}
			if(adminui.modifyfridaychk.isSelected())
			{
				availabledays=availabledays+adminui.modifyfridaychk.getText()+" ";
			}
			schedulebean.setAvailableDays(availabledays.trim());
			admin.updateScheduleDetails(schedulebean);

			 JOptionPane.showMessageDialog(null, "SCHEDULE SUCCESSFULLY MODIFIED");
             adminui.mainpanel.setVisible(false);
		}

		}
		
	}


