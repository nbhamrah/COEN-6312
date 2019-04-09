package com.coen6312.ocs.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.ui.AdminForm;
import com.coen6312.ocs.ui.Adminui;
import com.coen6312.ocs.ui.PatientUi;
import com.coen6312.ocs.ui.Register;
import com.coen6312.ocs.ui.UI;
import com.coen6312.ocs.util.Authentication;
import com.coen6312.ocs.util.User;

public class loginlistener implements ActionListener 
{
	UI ui;
	public loginlistener(UI obj)
	{
		ui=obj;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		CredentialsBean credentialsBean=new CredentialsBean();
		JOptionPane pane=new JOptionPane();
		// TODO Auto-generated method stub
		
		
		if(e.getSource()==ui.loginbutton)
		{
			if(ui.useridfield.getText().isEmpty())
			{
				pane.showMessageDialog(null,"USER ID CANNOT BE LEFT BLANK");
			}
			else if(ui.passwordfield.getPassword().length==0)
			{
				pane.showMessageDialog(null,"PASSWORD CANNOT BE LEFT BLANK");
			}
			else
			{
			String id=ui.useridfield.getText();
			char[] pass=ui.passwordfield.getPassword();
			credentialsBean.setUserID(id);
			credentialsBean.setPassword(String.valueOf(pass));
			User user=new User();
			
			String login=user.login(credentialsBean);
			//System.out.println(login);
			if(login.equalsIgnoreCase("Admin")&&id.equalsIgnoreCase("admin"))
			{
				
				AdminForm adminfrom=new AdminForm(credentialsBean);
				//Adminui adminui=new Adminui();
				//adminui.setGetlogoutid(id);
				ui.loginframe.setVisible(false);
			}
			else if(login.equalsIgnoreCase("Admin")&&(!id.equalsIgnoreCase("admin")))
			{
				Adminui adminui=new Adminui();
				adminui.setGetlogoutid(id);
				ui.loginframe.setVisible(false);
			}
			else if(login.equalsIgnoreCase("Patient")&&(!id.equalsIgnoreCase("admin")))
			{
				
				PatientUi patientUi=new PatientUi(credentialsBean);
				//adminui.setGetlogoutid(id);
				ui.loginframe.setVisible(false);
			}
			/*else 
			{
				JOptionPane.showMessageDialog(null,login);
			}*/
			else
			{
			pane.showMessageDialog(null,"INVALID USERNAME OR PASSWORD");
			}
		}
		}
		if(e.getSource()==ui.registerbutton)
		{
			ui.loginframe.setVisible(false);
			Register register=new Register();
		}
		
	}

}

