package com.coen6312.ocs.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coen6312.ocs.bean.CredentialsBean;

public class Authentication {
	public boolean authenticate(CredentialsBean user){
		boolean flag=false;
		Connection connection1;
		try {
			connection1=DBUtil.getConnection();
			String query="select * from OCS_TBL_User_Credentials where USERID=? and PASSWORD=?";
			PreparedStatement pstmt1= connection1.prepareStatement(query);
			pstmt1.setString(1,user.getUserID());
			pstmt1.setString(2,user.getPassword());
			ResultSet rs1=pstmt1.executeQuery();
			if(rs1.next())
			{
				flag=true;
			}
			
		} 
		catch (ClassNotFoundException | SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.out.println(user.getUserID());
		//System.out.println(user.getPassword());
		return flag;
	}
	public String authorize(String userID){
		String user="";
		Connection connection2;
		try {
			connection2=DBUtil.getConnection();
			String query1="select USERTYPE from OCS_TBL_User_Credentials where USERID=?";
			PreparedStatement pstmt2= connection2.prepareStatement(query1);
			pstmt2.setString(1,userID);
			ResultSet rs2=pstmt2.executeQuery();
			while(rs2.next()){
				user=rs2.getString(1);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return user;	
	}
	public boolean changeLoginStatus(CredentialsBean user,int loginStatus){
		boolean flag=false;
		Connection connection3;
		try {
			connection3=DBUtil.getConnection();
			String query2="update OCS_TBL_User_Credentials set LOGINSTATUS=? where USERID=?";
			PreparedStatement pstmt3= connection3.prepareStatement(query2);
			pstmt3.setInt(1,loginStatus);
			pstmt3.setString(2,user.getUserID());
			int row=pstmt3.executeUpdate();
			if(row!=0){
				flag=true;
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return flag;
	}
	
	
}
