package com.coen6312.ocs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import com.coen6312.ocs.bean.AppointmentBean;
import com.coen6312.ocs.bean.CredentialsBean;
import com.coen6312.ocs.bean.DoctorBean;
import com.coen6312.ocs.bean.PatientBean;
import com.coen6312.ocs.bean.ProfileBean;
import com.coen6312.ocs.bean.ScheduleBean;
import com.coen6312.ocs.dao.Dao;
import com.coen6312.ocs.util.DBUtil;
import com.coen6312.ocs.util.User;

public class Administrator 
{
	
	public String addDoctor(DoctorBean doctoerBean)
	{
		Dao dao=new Dao();
		String result="FAILURE";
		try
		{
			Connection connection;
			connection=DBUtil.getConnection();
			//doctoerBean.setDoctorID(dao.generateCandidateId(doctoerBean.getDoctorName()));
			String sql1="insert into OCS_TBL_Doctor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql1);
			pstmt.setString(1,doctoerBean.getDoctorID());
			pstmt.setString(2,doctoerBean.getDoctorName());
			pstmt.setDate(3,new java.sql.Date(doctoerBean.getDateOfBirth().getTime()));
			pstmt.setDate(4,new java.sql.Date(doctoerBean.getDateOfJoining().getTime()));
			pstmt.setString(5,doctoerBean.getGender());
			pstmt.setString(6,doctoerBean.getQualification());
			pstmt.setString(7,doctoerBean.getSpecialization());
			pstmt.setInt(8,doctoerBean.getYearsOfExperience());
			pstmt.setString(9,doctoerBean.getStreet());
			pstmt.setString(10,doctoerBean.getLocation());
			pstmt.setString(11,doctoerBean.getCity());
			pstmt.setString(12,doctoerBean.getState());
			pstmt.setString(13,doctoerBean.getPincode());
			pstmt.setString(14,doctoerBean.getContactNumber());
			pstmt.setString(15,doctoerBean.getEmailID());
			int rows=pstmt.executeUpdate();
			if(rows!=0)
			{
				result="DOCTOR ADDED SUCCESSFULLY";
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String generateAdminId1(CredentialsBean crbean)
	{
		String result="ERROR";
		Dao dao=new Dao();
		try
		{
			//System.out.println(crbean.getUserID()+"hi");
			result=dao.generateAdminId1(crbean.getUserID());
		} catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public boolean modifyDoctor(DoctorBean doctoerBean)
	{
		Dao dao=new Dao();
		
		try 
		{
			
			boolean status=dao.findDoctorByDoctorId(doctoerBean);
			
				
				if(status==true)
				{
					return true;
				}
				else
				{
					return false;
				}
					
		
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<DoctorBean> viewAllDoctors()
	{
		ArrayList<DoctorBean> list1=new ArrayList<DoctorBean>();
		Dao dao1=new Dao();
		try 
		{
			list1=dao1.findAll();
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list1;
	}
	public ArrayList<DoctorBean> suggestDoctors(String patientID, Date date)
	{
		ArrayList<DoctorBean> list2=new ArrayList<DoctorBean>();
		return list2;
	}
	public Map<PatientBean,AppointmentBean> viewPatientsByDate(Date appointmentDate)
	{
		Map<PatientBean,AppointmentBean> map=new HashMap<PatientBean,AppointmentBean>();
		Dao daoobj=new Dao();
		try 
		{
			map=daoobj.findPatientsByDate(appointmentDate);
			System.out.println(map.size());
		}
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	
	public String setUserId(ProfileBean profilebean)
	{
		String result="ERROR";
		if(profilebean.getFirstName()==null)
		{
			result="First Name Can Not Be Null";
		}
		else
		{
			Dao dao= new Dao();
			try 
			{
				result=dao.generateUserIdByName(profilebean.getFirstName());
			}
			catch (ClassNotFoundException | SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public String changePassword(CredentialsBean bean,String newpswrd)
	{
		//Administrator administrator=new Administrator();
		User user=new User();
		Dao dao=new Dao();
		String change="";
		if(!(user.login(bean).equals("Admin")) && !(user.login(bean).equals("Reporter")) && !(user.login(bean).equals("Patient")))
		{
			change="User doesnot exist";
		}
		else
		{
			try
			{
				dao.changePassword(bean,newpswrd);
				change="exists";
			} 
			catch (ClassNotFoundException | SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return change;
		
	}
	public String setAdminPassWord(CredentialsBean credentialsBean)
	{
		
		String result="ERROR"; 
		if(credentialsBean.getPassword().equalsIgnoreCase("admin"))
		{
			result="Please Change The PassWord";
		}
		else
		{
			Dao dao= new Dao();
			try {
				//String userID=dao.generateAdminId1(credentialsBean.getUserID());
				//credentialsBean.setUserID(userID);
				if(dao.setAdminPassWord(credentialsBean)==true)
				{
					result="SUCCESS";
				}
				else
				{
					result="ERROR";
				}
			} catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public String deleteDoctorByID(String doctorID)
	{
		String result="INVALID ID";
		Dao dao= new Dao();
		try 
		{
			if(dao.deleteDoctorByID(doctorID)==true)
			{
				result="DOCTOR DELETED SUCCESSFULLY";
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "CHILD RECORD FOUND CAN'T BE DELETED");
		}
		return result;
	}
	

	public String updateDoctorDetails(DoctorBean dBean,String doctorId)
	{
		Dao daos=new Dao();
		boolean update;
		try 
		{
			return(daos.updateDoctorDetails(dBean,doctorId));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "UNSUCCESSFUL";
	}
	public String addPatientDetails(ProfileBean profilebean)
	{
		Dao dao=new Dao();
		String result="ERROR";
		if(profilebean==null)
		{
			result="INVALID ENTIRY";
		}
		else
		{
			try {
				if(dao.addPatientDetails(profilebean)==true)
				{
					result="DATA SUCCESSFULLY UPDATED";
				}
				else
				{
					result="ERROR";
				}
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return result;
		
	}
	public String addUserByUserId(CredentialsBean credentialsBean)
	{
		String result="ERROR";
		if(credentialsBean==null)
		{
			result="ERROR BLANK FILEDS !!";
		}
		else
		{
			Dao dao= new Dao();
			try 
			{
				if(dao.addUserByUserId(credentialsBean)==true)
				{
					result="DATA INSERTED";
				}
				else
				{
					result="DATA NOT INSERTED";
				}
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean updatestatusbyappointmentid(String appointmentid){
		boolean flag=false;
		Dao dao=new Dao();
		try {
			if(dao.updatestatusbyappointmentid(appointmentid)==true){
				flag=true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	//------------------------------
	public String addScheduleDetails(ScheduleBean schbean)
	{
		String result="ERROR";
		Dao dao= new Dao();
		try {
			if(dao.addScheduleDetails(schbean)==true)
			{
				result="SUCCESS";
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public String generateScheduleId(ScheduleBean schbean)
	{
		String result="ERROR";
		Dao dao= new Dao();
		try {
			result=dao.generateScheduleId(schbean);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public String updateScheduleDetails(ScheduleBean schedulebean)
	{
		String result="ERROR";
		Dao dao= new Dao();
		try
		{
			result=dao.updateScheduleDetails(schedulebean);
		} catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<ScheduleBean> viewScheduledDoctors()
	{
		ArrayList<ScheduleBean> alist= new ArrayList<ScheduleBean>();
		Dao dao1=new Dao();
		try {
			alist=dao1.viewScheduledDoctors();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alist;
	}
	
}
