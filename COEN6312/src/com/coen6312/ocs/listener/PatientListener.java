package com.coen6312.ocs.listener;

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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.plaf.multi.MultiOptionPaneUI;
import javax.swing.table.JTableHeader;

import com.coen6312.ocs.bean.AppointmentBean;
import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.bean.DoctorBean;
import com.coen6312.ocs.bean.PatientBean;
import com.coen6312.ocs.dao.Dao;
import com.coen6312.ocs.service.*;
import com.coen6312.ocs.ui.*;
import com.coen6312.ocs.util.User;

public class PatientListener implements MenuListener,ActionListener
{
	
	PatientUi patientobj;
	public static String appointmentid="";
	//static int count=0;
	

	public PatientListener(PatientUi patientobj)
	{
		this.patientobj=patientobj;
	}


	public String getAppointmentid() {
		return appointmentid;
	}


	public void setAppointmentid(String appointmentid) {
		this.appointmentid = appointmentid;
	}


	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void menuSelected(MenuEvent e) 
	{
		String sts="";
		if(e.getSource()==patientobj.patientadd)
		{	
			patientobj.mpatientpanel.removeAll();
			patientobj.mpatientpanel.setVisible(false);
			patientobj.addAilmentDetails();
			//patientobj.mpatientpanel.removeAll();
		}

		if(e.getSource()==patientobj.patientmodify)
		{
			patientobj.mpatientpanel.removeAll();
			patientobj.mpatientpanel.setVisible(false);
			patientobj.modifyAilmentDetails();
		//	patientobj.patientpanel.removeAll();
		}
		if(e.getSource()==patientobj.patientChngpass)
		{
			patientobj.mpatientpanel.removeAll();
			patientobj.mpatientpanel.setVisible(false);
			patientobj.changePassword();
		}
		if(e.getSource()==patientobj.patientReqAppoint){
			
			patientobj.mpatientpanel.removeAll();
			patientobj.mpatientpanel.setVisible(false);
			patientobj.mpatientpanel.setLayout(null);
			
		/*	patientobj.day.setSelectedItem(patientobj.getselecteddate);
			patientobj.month.setSelectedItem(patientobj.getselectedmonth);
			patientobj.year.setSelectedItem(patientobj.getselectedyear);*/
			ArrayList<DoctorBean> list=new ArrayList<DoctorBean>();
			DoctorBean doctor=new DoctorBean();
			String ailmenttype="";
			Patient service=new Patient();
			PatientBean bean=new PatientBean();
			///patientobj.specializationtabel=new JTable();
			sts=service.findPatientByUserId(patientobj.txtpatientuserid.getText());
			//bean.setPatientID(sts);
			//patientobj.idfield3.setText(sts);
			ailmenttype=service.ailmenttypebypatientid(sts);
			
			//"Frequent Heartburn","Asthma","Back Pain","Diabetes" ,"Insomnia","Migraines","Epilepsy","Obesity","Parkinson’s Disease","Alzheimer"
			if(ailmenttype.equals("Frequent Heartburn")){
				doctor.setSpecialization("Heart");
			}
			else if(ailmenttype.equals("Epilepsy")){
				doctor.setSpecialization("Kidney");
			}
			else if(ailmenttype.equals("Diabetes")){
				doctor.setSpecialization("Apetite");
			}
			else if(ailmenttype.equals("Obesity")){
				doctor.setSpecialization("Apetite");
			}
			else if(ailmenttype.equals("Back Pain")){
				doctor.setSpecialization("Bones");
			}
			else if(ailmenttype.equals("Insomnia")){
				doctor.setSpecialization("Psychiatrists");
			}
			else if(ailmenttype.equals("Alzheimer")){
				doctor.setSpecialization("Kidney");
			}
			else if(ailmenttype.equals("Parkinson’s Disease")){
				doctor.setSpecialization("Heart");
			}else{
				doctor.setSpecialization("All");
			}
			System.out.println("specialization");
			System.out.println(doctor.getSpecialization());
			list=service.viewListOfDoctors(doctor.getSpecialization());
			System.out.println(list.size());
			String column_names[]={"DOCTORID","DOCTORNAME","GENDER","CONTACTNUMBER","EMAILID","SPECIALIZATION"};
			Object rows[][]=new Object[list.size()][6];
			Iterator<DoctorBean> it=list.iterator();
			int i=0;
			while(it.hasNext())
			{
				DoctorBean doctorBean=new DoctorBean();
				doctorBean=it.next();
				rows[i][0]=doctorBean.getDoctorID();
				rows[i][1]=doctorBean.getDoctorName();
				rows[i][2]=doctorBean.getGender();
				rows[i][3]=doctorBean.getContactNumber();
				rows[i][4]=doctorBean.getEmailID();
				rows[i][5]=doctorBean.getSpecialization();
				i++;
				
				System.out.println(doctorBean.getContactNumber());
				System.out.println(doctorBean.getDoctorID());
				System.out.println(doctorBean.getDoctorName());
				System.out.println(doctorBean.getEmailID());
				System.out.println(doctorBean.getGender());
				System.out.println(doctorBean.getSpecialization());
																
			}
		
			patientobj.specializationtabel=new JTable(rows,column_names);
			patientobj.specializationtabel.setMinimumSize(new Dimension(600,200));
			 JTableHeader header = patientobj.specializationtabel.getTableHeader();
			 patientobj.specializationtabel.getColumnModel().getColumn(0).setPreferredWidth(75);
			 patientobj.specializationtabel.getColumnModel().getColumn(1).setPreferredWidth(75);
			 patientobj.specializationtabel.getColumnModel().getColumn(2).setPreferredWidth(75);
			 patientobj.specializationtabel.getColumnModel().getColumn(3).setPreferredWidth(75);
			 patientobj.specializationtabel.getColumnModel().getColumn(4).setPreferredWidth(50);
			 patientobj.specializationtabel.getColumnModel().getColumn(5).setPreferredWidth(150);
			 patientobj.specialpane=new JScrollPane();
			 patientobj.specialpane.setBounds(20,65,500,150);
			// patientobj.specialpane.setMinimumSize(new Dimension(600, 23));
			 patientobj.specialpane.setViewportView(patientobj.specializationtabel);
			 patientobj.mpatientpanel.add(patientobj.specialpane);
			 patientobj.specializationtabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			// patientobj.mpatientpanel.setMinimumSize(new Dimension(600,200));
			 patientobj.patientframe.add(patientobj.mpatientpanel);
			 patientobj.mpatientpanel.setVisible(true);
			 patientobj.patientframe.setVisible(true);
			patientobj.requestforappointment();//-----????
			patientobj.idfield3.setText(sts);
		}
		if(e.getSource()==patientobj.appointmentstatus){
			
			Dao dao=new Dao();
			String PatientId = null;
			String appointmentId1 = null;
			System.out.println("new"+PatientSetPassword.useridfield.getText());
			if(!(UI.useridfield.getText().trim().equals("")))
			{
				//,PatientId1=null;
			
				//String s2=PatientSetPassword.useridfield.getText().trim();
				//,appointmentId2 = null;
				try {
					System.out.println("listener 1"+UI.useridfield.getText().trim());
					PatientId=(dao.getPatientId(UI.useridfield.getText().trim()));
					//PatientId1=(dao.getPatientId(s2));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(PatientId!=null )//|| PatientId1!=null)
				{
					
					
					try {
						appointmentId1=(dao.getPatientAppointmentId(PatientId));
						//appointmentId2=(dao.getPatientAppointmentId(PatientId1));
						System.out.println("test1"+appointmentId1);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
				patientobj.mpatientpanel.removeAll();
				patientobj.mpatientpanel.setVisible(false);
				patientobj.mpatientpanel.setLayout(null);
				patientobj.app=new JLabel("CHECK YOUR APPOINTMENT STATUS");
				 Font font4 = new Font("Courier", Font.BOLD,30);
				 patientobj.app.setFont(font4);
				 patientobj.app.setBounds(180,20,900,25);
				 patientobj.mpatientpanel.add(patientobj.app);
				Patient patient=new Patient();
				ArrayList<AppointmentBean> list=new ArrayList<AppointmentBean>();
				
				list=patient.viewappointmentstatusbyappointmentid(appointmentId1);
				System.out.println("chak");
				System.out.println(appointmentid);
				System.out.println(list.size());
				String column_names[]={"APPOINTMENT ID","DOCTOR ID","PATIENT ID","APPOINTMENT DATE","APPOINTMENT TIME","STATUS"};
				Object rows[][]=new Object[list.size()][6];
				Iterator<AppointmentBean> it=list.iterator();
				int i=0;
				while(it.hasNext())
				{
					AppointmentBean appointmentBean=new AppointmentBean();
					appointmentBean=it.next();
					rows[i][0]=appointmentBean.getAppointmentID();
					rows[i][1]=appointmentBean.getDoctorID();
					rows[i][2]=appointmentBean.getPatientID();
					rows[i][3]=appointmentBean.getAppointmentDate();
					rows[i][4]=appointmentBean.getAppointmentTime();
					rows[i][5]=dao.selectstatusbyappointmentid(appointmentId1);
					//System.out.println("yo"+appointmentid);
					i++;
																	
				}
				patientobj.appointmentstatustable=new JTable(rows,column_names);
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
				}
			}
			else
			{
				//,PatientId1=null;
				
				//String s2=PatientSetPassword.useridfield.getText().trim();
				//,appointmentId2 = null;
				try {
					System.out.println("listener 1"+PatientSetPassword.useridfield.getText().trim());
					PatientId=(dao.getPatientId(PatientSetPassword.useridfield.getText().trim()));
					//PatientId1=(dao.getPatientId(s2));
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				if(PatientId!=null )//|| PatientId1!=null)
				{
					
					
					try {
						appointmentId1=(dao.getPatientAppointmentId(PatientId));
						//appointmentId2=(dao.getPatientAppointmentId(PatientId1));
						System.out.println("test1"+appointmentId1);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
					PatientSetPassword.useridfield.setText("");
				patientobj.mpatientpanel.removeAll();
				patientobj.mpatientpanel.setVisible(false);
				patientobj.mpatientpanel.setLayout(null);
				patientobj.app=new JLabel("CHECK YOUR APPOINTMENT STATUS");
				 Font font4 = new Font("Courier", Font.BOLD,30);
				 patientobj.app.setFont(font4);
				 patientobj.app.setBounds(180,20,900,25);
				 patientobj.mpatientpanel.add(patientobj.app);
				Patient patient=new Patient();
				ArrayList<AppointmentBean> list=new ArrayList<AppointmentBean>();
				
				list=patient.viewappointmentstatusbyappointmentid(appointmentId1);
				System.out.println("chak");
				System.out.println(appointmentid);
				System.out.println(list.size());
				String column_names[]={"APPOINTMENT ID","DOCTOR ID","PATIENT ID","APPOINTMENT DATE","APPOINTMENT TIME","STATUS"};
				Object rows[][]=new Object[list.size()][6];
				Iterator<AppointmentBean> it=list.iterator();
				int i=0;
				while(it.hasNext())
				{
					AppointmentBean appointmentBean=new AppointmentBean();
					appointmentBean=it.next();
					rows[i][0]=appointmentBean.getAppointmentID();
					rows[i][1]=appointmentBean.getDoctorID();
					rows[i][2]=appointmentBean.getPatientID();
					rows[i][3]=appointmentBean.getAppointmentDate();
					rows[i][4]=appointmentBean.getAppointmentTime();
					rows[i][5]=dao.selectstatusbyappointmentid(appointmentId1);
					//System.out.println("yo"+appointmentid);
					i++;
																	
				}
				patientobj.appointmentstatustable=new JTable(rows,column_names);
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
			}}
			// patientobj.mpatientpanel.setMinimumSize(new Dimension(600,200));
			 patientobj.patientframe.add(patientobj.mpatientpanel);
			 patientobj.mpatientpanel.setVisible(true);
			 patientobj.patientframe.setVisible(true);
			
			
		}
		if(e.getSource()==patientobj.logoutpatient)
		{
			//UI ui = null;
			 patientobj.mpatientpanel.removeAll();
			
			 patientobj.mpatientpanel.setVisible(false);
			User user=new User();////////?     LOGINID KHA SE AAYEGI??
			JOptionPane pane=new JOptionPane();
			boolean flag=user.logout(PatientUi.getId);
			if(flag=true)
			{
				pane.showMessageDialog(null,"Successfully Logout");
				patientobj.patientframe.setVisible(false);
				UI ui=new UI();
			}
			else
			{
				pane.showMessageDialog(null,"Unable to Logout due to some error");
			}
		}}
	


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		PatientBean pbean=new PatientBean();
		if(e.getSource()==patientobj.btnpatientadd)
		{
			Patient service=new Patient();
			String sts=service.findPatientByUserId(patientobj.txtpatientuserid.getText());
			if(sts.equals("fail"))
			{
				
			
				if(!patientobj.txtpatientuserid.getText().isEmpty())
				{
				
					String pday=(String) patientobj.cmbpatientday.getSelectedItem();
					patientobj.getselecteddate= (String) patientobj.cmbpatientday.getSelectedItem();
					String pmonth=(String) patientobj.cmbpatientmonth.getSelectedItem();
					patientobj.getselectedmonth=(String) patientobj.cmbpatientmonth.getSelectedItem();
					String pyear=(String) patientobj.cmbpatientyear.getSelectedItem();
					patientobj.getselectedyear=(String) patientobj.cmbpatientyear.getSelectedItem();
		
					System.out.println(patientobj.getselecteddate);
					System.out.println(patientobj.getselectedmonth);
					System.out.println(patientobj.getselectedyear);
					String doa=pday + "-" + pmonth + "-" + pyear;
					DateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
					try 
					{
						Date doas=df.parse(doa);
						pbean.setAppointmentDate(doas);
						Date date=new Date();
						
						String cuurentDatee=df.format(date);
						String appDatee=df.format(doas);
						
						
						if(date.compareTo(doas)<0 || cuurentDatee.equals(appDatee) )
						{
							
							String userid=patientobj.txtpatientuserid.getText();	
							pbean.setUserID(userid);
							
							
							
							String type=(String) patientobj.cmbpatientailtype.getSelectedItem();
							pbean.setAilmentType(type);
							
							String details=patientobj.txapatientailmentdetails.getText().trim();
							
							
							if(details.isEmpty())
							{
								JOptionPane.showMessageDialog(null,"AILMENT DETAILS FIELD CANNOT BE BLANK");
							}
							else if(!(details.matches("[a-zA-Z ]+")))
							{
								JOptionPane.showMessageDialog(null, "AILMENT DETAILS FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
								
							}
							else
							{
								pbean.setAilmentDetails(details);
								String history=patientobj.txapatienthistory.getText().trim();
								if((history.length()!=0) && (!history.matches("[a-zA-Z ]+")) )
								{
									JOptionPane.showMessageDialog(null, "DIAGNOSIS HISTORY FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
								}
								else
								{
									pbean.setDiagnosisHistory(history);
									patientobj.patientpane.showMessageDialog(null,service.addAilmentDetails(pbean));
									patientobj.txtpatientid.setText(pbean.getPatientID());
								}
							}
							
						}
						else
						{
							patientobj.patientpane.showMessageDialog(null,"Appointment Date should be greater than current time");
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
					patientobj.patientpane.showMessageDialog(null,"User id cannot be empty");
				}			
		    			
		    }
			else
			{
				patientobj.patientpane.showMessageDialog(null,"ALREADY ADDED THE DETAILS");
			}
			
		}
		
		if(e.getSource()==patientobj.btnpatientcancel)
		{
			//patientobj.txtpatientuserid.setText("");
			patientobj.txapatientailmentdetails.setText("");
			patientobj.txapatienthistory.setText("");
		}
		
		if(e.getSource()==patientobj.btnmpatientshow)
		{
			patientobj.btnmpatientmodify.setEnabled(true);
			
			
			PatientBean bean=new PatientBean();
			Patient services=new Patient();
			
			String ids=patientobj.txtmpatientuserid.getText();
			
			bean.setUserID(ids);
			boolean b=services.viewAilmentDetails(bean);
			
			patientobj.txtmpatientid.setText(bean.getPatientID());
			
			String type=bean.getAilmentType();
			patientobj.cmbmpatientailtype.setSelectedItem(type);
			
			patientobj.txampatientailmentdetails.setText(bean.getAilmentDetails());
			patientobj.txampatienthistory.setText(bean.getDiagnosisHistory());
		
		
			DateFormat df1=new SimpleDateFormat("dd-MMM-yyyy");
			Date doa=bean.getAppointmentDate();
			String doas=df1.format(doa);
			
			String str[]=doas.split("-");
			
			patientobj.cmbmpatientday.setSelectedItem(str[0]);
			patientobj.cmbmpatientmonth.setSelectedItem(str[1]);
			patientobj.cmbmpatientyear.setSelectedItem(str[2]);
		
		
		
		
		
		
		
		
		}
		
		if(e.getSource()==patientobj.btnmpatientmodify)
		{
			PatientBean beans=new PatientBean();
			
			beans.setPatientID(patientobj.txtmpatientid.getText());
			String pUserId=patientobj.txtmpatientuserid.getText();
			
			
			
			beans.setUserID(pUserId);
			String daay=(String) patientobj.cmbmpatientday.getSelectedItem();
			String moonth=(String) patientobj.cmbmpatientmonth.getSelectedItem();
			String yeaar=(String) patientobj.cmbmpatientyear.getSelectedItem();
			
			String dooa=daay + "-" + moonth + "-" + yeaar;
			SimpleDateFormat dd=new SimpleDateFormat("dd-MMM-yyyy");
			 
			//beans.setAilmentType((String) patientobj.cmbmpatientailtype.getSelectedItem());
			//beans.setAilmentDetails(patientobj.txampatientailmentdetails.getText());
			//beans.setDiagnosisHistory(patientobj.txampatienthistory.getText());
			 
			
			try 
			{
				Date dates = dd.parse(dooa);
				Date currdate=new Date();
				
				String cuurentDate=dd.format(currdate);
				String appDate=dd.format(dates);
				
				
				
				if(currdate.compareTo(dates)<0 || cuurentDate.equals(appDate))
				{
					beans.setAppointmentDate(dates);
					String deat=(String) patientobj.cmbmpatientailtype.getSelectedItem();
					
					beans.setAilmentType(deat);
					
					String deet=patientobj.txampatientailmentdetails.getText();
					
					
					
					if(deet.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"AILMENT DETAILS FIELD CANNOT BE BLANK");
					}
					else if(!(deet.matches("[a-zA-Z ]+")))
					{
						JOptionPane.showMessageDialog(null, "AILMENT DETAILS FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
						
					}
					else
					{
						beans.setAilmentDetails(deet);
						String historya=patientobj.txampatienthistory.getText().trim();
						
						if((historya.length()!=0) && (!historya.matches("[a-zA-Z ]+")))
						{
							JOptionPane.showMessageDialog(null, "DIAGNOSIS HISTORY FIELD SHOULD CONTAIN ALPHABETIC CHARACTERS");
						}
						else
						{
							beans.setDiagnosisHistory(historya);
							Patient servic=new Patient();
							patientobj.mpatientpane.showMessageDialog(null,servic.updatePatientAilmentDetails(beans,pUserId));
						}
					}
					
					
			    }
				else
				{
					patientobj.mpatientpane.showMessageDialog(null,"Appointment Date should be greater than current time");
					
				}
				
				
				
				
				
			} 
			catch (ParseException e1)
			{
				
				e1.printStackTrace();
			}
			
			
			
			
		
		
		
		
		}
		
		
		if(e.getSource()==patientobj.changebuttonm)
		{
			Administrator administrator=new Administrator();
			CredentialsBean bean=new CredentialsBean();
			bean.setUserID(patientobj.idfieldpassm.getText());
			bean.setPassword(patientobj.oldidfieldm.getText());
			String newpswrd=String.valueOf(patientobj.newidfieldm.getText());
			String retypenewpswrd=String.valueOf(patientobj.matchidfieldm.getText());
			
			if(patientobj.idfieldpassm.getText().trim().length()==0)
			{
				JOptionPane.showMessageDialog(null,"User Id field cannot be empty");
			}
			else
			{
			     if(patientobj.oldidfieldm.getText().trim().length()==0)
			     {
						JOptionPane.showMessageDialog(null,"Old Password field cannot be empty");
 
			     }
			     else
			     {
			            
			    	 if(patientobj.newidfieldm.getText().trim().length()==0)
			    	 {
			    		 JOptionPane.showMessageDialog(null,"New Password field cannot be empty");
			    	 }
			    	 else
			    	 {
			
			    		 if(patientobj.matchidfieldm.getText().trim().length()==0)
			    		 {
			    			 JOptionPane.showMessageDialog(null,"Re-Type Password field cannot be empty"); 
			    			 
			    		 }
			    		 else
			    		 {
			    			 		if(!(newpswrd.equals(retypenewpswrd)))
			    			 		{
			    			 			JOptionPane.showMessageDialog(null,"Password doesnot match");
			    			 		}
			    			 		else
			    			 		{
			    			 			if(administrator.changePassword(bean, newpswrd).equals("exists"))
			    			 			{
			    			 				JOptionPane.showMessageDialog(null,"New Password Updated");
			    			 			}
			    			 		else
			    			 		{
			    			 			JOptionPane.showMessageDialog(null,"User does not exists");
			    			 		}
						  }	
					  }		
								
			      }			
			
			}
		}
		
		
	}
		if(e.getSource()==patientobj.viewappointmentbutton){
			Patient patient=new Patient();
			//patientobj.mpatientpanel.removeAll();
			
			//patientobj.mpatientpanel.setVisible(false);
			patientobj.mpatientpanel.setLayout(null);
			//patientobj.idfield1.getText();
			String slot=patient.selectslotbydoctorid(patientobj.idfield1.getText());
			System.out.println(slot);
			if(slot.equals("Morning")){
				patientobj.slotbox.setSelectedItem("Morning");
				patientobj.slotbox.setSelectedIndex(0);
				patientobj.slotnumberbox1.setVisible(true);
				patientobj.slotnumberbox2.setVisible(false);
			}
			if(slot.equals("Evening")){
				patientobj.slotbox.setSelectedItem("Evening");
				patientobj.slotbox.setSelectedIndex(1);
				patientobj.slotnumberbox2.setVisible(true);
				patientobj.slotnumberbox1.setVisible(false);
			}
			//patientobj.mpatientpanel.setLayout(new BorderLayout());
			Map<AppointmentBean,PatientBean> newmap=new HashMap<AppointmentBean,PatientBean>();
			
			 String days=(String)patientobj.day.getSelectedItem();
			// System.out.println(days);
			   String months=(String)patientobj.month.getSelectedItem();
			   //System.out.println(months);
			   String years=(String)patientobj.year.getSelectedItem();
			   String appointmentdate=days+"-"+months+"-"+years;
			   SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			   //System.out.println(appointmentdate);
			   //String date=formatter.format(appointmentdate);
			   String doctorID=patientobj.idfield1.getText();
		        Date appointmentbydate = null;
				
					try {
						appointmentbydate = formatter.parse(appointmentdate);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//System.out.println(appointmentbydate);
					System.out.println(doctorID);
					   System.out.println(appointmentbydate);
					newmap=patient.viewAppointmentDetails(doctorID,appointmentbydate);
					String column_names[]={"PATIENTID","APP.DATE","APPOINTMENTID","DOCTORID","TIME","USERID","AILMENT_TYPE","AILMENT_DETAILS","DIAGNOSIS_HISTORY"};
					Object rows[][]=new Object[newmap.size()][9];
					//System.out.println(newmap.size());
					int index = 0;
					Set<AppointmentBean> s= newmap.keySet();
					//System.out.println(newmap.keySet().size());
	                  Iterator i = s.iterator();
	                  while(i.hasNext())
	                  {
	                	  PatientBean patientBean=new PatientBean();
	          			AppointmentBean appointmentBean=new AppointmentBean();
	          			appointmentBean=(AppointmentBean) i.next();
	                	  //patientBean=(PatientBean) i.next();
	                	  //appointmentBean=newmap.get(patientBean);
	                	  patientBean=newmap.get(appointmentBean);
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
	                  
	                  patientobj.viewappointmentdetailbutton=new JTable(rows,column_names);
	                  patientobj.viewappointmentdetailbutton.setMinimumSize(new Dimension(600,200));
	     			 JTableHeader header = patientobj.viewappointmentdetailbutton.getTableHeader();
	     			patientobj.appointmentpan=new JScrollPane();
	     			 patientobj.appointmentpan.setBounds(550,180,500,150);
	     			//adminui.appointmentpane.setBounds(adminui.appointmentdatetabel.getBounds());
	     			patientobj.appointmentpan.setMinimumSize(new Dimension(600, 23));
	     			patientobj.appointmentpan.setViewportView(patientobj.viewappointmentdetailbutton);
	     			patientobj.mpatientpanel.add(patientobj.appointmentpan);
	     			patientobj.viewappointmentdetailbutton.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	     			patientobj.mpatientpanel.setMinimumSize(new Dimension(600,200));
	     			//adminui.newpanel.add(adminui.mainpanel);
	     			patientobj.patientframe.add(patientobj.mpatientpanel);
	     			patientobj.mpatientpanel.setVisible(true);
	     			patientobj.patientframe.setVisible(true);
				
}
			if(e.getSource()==patientobj.requestforappointmentbutton){
				Dao dao=new Dao();
				AppointmentBean appointmentbean=new AppointmentBean();
				Patient patient=new Patient();
				//String appointmentid="";
				String days=(String)patientobj.day.getSelectedItem();
				// System.out.println(days);
				   String months=(String)patientobj.month.getSelectedItem();
				   //System.out.println(months);
				   String years=(String)patientobj.year.getSelectedItem();
				   String appointmentdate=days+"-"+months+"-"+years;
				   SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				   Date appointmentbydate = null;
				try {
					appointmentbydate = formatter.parse(appointmentdate);
					 appointmentid=dao.generateappointmentidbypatientiddoctorid(appointmentdate);
					 
					// setAppointmentid(dao.generateappointmentidbypatientiddoctorid(appointmentdate));
					patientobj.appointmentidfield.setText(appointmentid);
					appointmentbean.setAppointmentDate(appointmentbydate);
					appointmentbean.setAppointmentID(appointmentid);
					if(patientobj.slotnumberbox1.isVisible()){
					appointmentbean.setAppointmentTime((String)patientobj.slotnumberbox1.getSelectedItem());
					}else{
						appointmentbean.setAppointmentTime((String)patientobj.slotnumberbox2.getSelectedItem());
					}
					appointmentbean.setDoctorID(patientobj.idfield1.getText());
					appointmentbean.setPatientID(patientobj.idfield3.getText());
					if(dao.findtimebydoctorid(appointmentbean.getAppointmentTime())==false){
					patient.addAppointment(appointmentbean);
					patientobj.appointmentidfield.setText(appointmentid);
					patientobj.appointmentidlabel.setVisible(true);
					patientobj.appointmentidfield.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null,"PLEASE SELECT ANOTHER TIME! DOCTOR IS NOT AVAILABLE AT"+"" +appointmentbean.getAppointmentTime());
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}







}
}
