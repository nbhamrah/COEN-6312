package com.coen6312.ocs.util;

import java.sql.SQLException;

import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.bean.ProfileBean;
import com.coen6312.ocs.dao.Dao;

public class User
{
	Authentication authentication=new Authentication();
	public String login(CredentialsBean credentialsBean)
	{
		String result="";
		if(authentication.authenticate(credentialsBean)==false)
		{
			result="INVALID";
		}
		else
		{
			if(authentication.authorize(credentialsBean.getUserID()).equalsIgnoreCase("A"))
			{
					result="Admin";
			}
			else if(authentication.authorize(credentialsBean.getUserID()).equalsIgnoreCase("R"))
			{
				result="Reporter";
			}
			else
			{
				result="Patient";
			}
			authentication.changeLoginStatus(credentialsBean,1);
		}
		return result;
		
	}
	public boolean logout(String userID){
		boolean flag=false;
		Dao dao=new Dao();
		CredentialsBean credentialsBean=new CredentialsBean();
		Authentication authentication=new Authentication();
		try {
			credentialsBean=dao.findUserByUserId(userID);
			authentication.changeLoginStatus(credentialsBean, 0);
			flag=true;
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
		return flag;
	}
	public String changePassword(CredentialsBean credentialsBean ,String userID){
		return null;
	}
	public String register(ProfileBean profileBean){
		return null;
		
	}
}
