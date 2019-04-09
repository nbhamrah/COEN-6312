package com.coen6312.ocs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.service.Administrator;
import com.coen6312.ocs.ui.AdminForm;
import com.coen6312.ocs.ui.Adminui;
import com.coen6312.ocs.ui.PatientUi;

public class AdminFormListner implements ActionListener
{
	AdminForm adminform;
	public AdminFormListner(AdminForm adminform)
	{
		this.adminform=adminform;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==adminform.loginbutton)
		{
			CredentialsBean credentialsBean=new CredentialsBean();
			String name=adminform.useridfield.getText();
			char[] password=adminform.passwordfield.getPassword();
			char[] confirmpass=adminform.confrmpasswordfield.getPassword();
			if(!String.valueOf(password).equals(null)&&(!String.valueOf(password).isEmpty()))
			{
				
				 if(!String.valueOf(confirmpass).equals(null)&&!String.valueOf(confirmpass).isEmpty())
				{
					 if(String.valueOf(password).length()>5 &&String.valueOf(confirmpass).length()>5)
					 {
					 if(String.valueOf(password).equals(String.valueOf(confirmpass)))
						{

							credentialsBean.setUserID(name);
							credentialsBean.setPassword(String.valueOf(password));
							Administrator administrator=new Administrator();
							if(administrator.setAdminPassWord(credentialsBean).equalsIgnoreCase("Success"))
							{
								Adminui adminui=new Adminui();
								adminui.setGetlogoutid(credentialsBean.getUserID());
								adminform.loginframe.setVisible(false);
							}
						}
					 else
						{
							JOptionPane.showMessageDialog(null, "PASSWORD DO NOT MATCH WITH CONFIRM PASSWORD !!");
						}
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "LENGTH OF THE PASSWORD MUST BE GREATER THAN 5 CHARACTERS !!");
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
