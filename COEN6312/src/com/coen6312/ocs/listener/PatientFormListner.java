package com.coen6312.ocs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.service.Administrator;
import com.coen6312.ocs.ui.Adminui;
import com.coen6312.ocs.ui.PatientSetPassword;
import com.coen6312.ocs.ui.PatientUi;
import com.coen6312.ocs.ui.UI;

public class PatientFormListner implements ActionListener
{
	PatientSetPassword patientsetpassword;
	public PatientFormListner(PatientSetPassword patientsetpassword) 
	{
		this.patientsetpassword=patientsetpassword;
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==patientsetpassword.loginbutton)
		{
			patientsetpassword.loginframe.setVisible(true);
			CredentialsBean credentialsBean=new CredentialsBean();
			String name=patientsetpassword.useridfield.getText();
			
			char[] password=patientsetpassword.passwordfield.getPassword();
			
			char[] confirmpass=patientsetpassword.confirmpasswordfield.getPassword();
			if(!String.valueOf(password).equals(null)&&(!String.valueOf(password).isEmpty()))
			{
				
				 if(!String.valueOf(confirmpass).equals(null)&&!String.valueOf(confirmpass).isEmpty())
				{
					 
					 if(String.valueOf(password).equals(String.valueOf(confirmpass)))
						{
							credentialsBean.setUserID(name);
							credentialsBean.setPassword(String.valueOf(password));
							
							Administrator administrator=new Administrator();
							if(administrator.addUserByUserId(credentialsBean).equalsIgnoreCase("DATA INSERTED"))
							{
								//System.out.println(credentialsBean.getUserID());
//								setGetlogoutid(id);
//								UI ui=new UI();//supposed to be replaced with rajat's frame PatientUI
								
								PatientUi patientUi=new PatientUi(credentialsBean);
								patientsetpassword.loginframe.setVisible(false);
							}
						}
					 else
						{
							JOptionPane.showMessageDialog(null, "PASSWORD DO NOT MATCH WITH CONFIRM PASSWORD !!");
						}
					 
					
					 
					
				 }
				 else 
					{
						JOptionPane.showMessageDialog(null, "CONFIRM PASSWORD CAN NOT BE EMPTY");
					}
					 
				}
			else
			{
				JOptionPane.showMessageDialog(null, "PASSWORD CAN NOT BE EMPTY");
			}
				
				
				
		}
			
			
		}
}

		
		
	
	
