package com.coen6312.ocs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.coen6312.ocs.bean.AppointmentBean;
import com.coen6312.ocs.bean.DoctorBean;
import com.coen6312.ocs.bean.PatientBean;
import com.coen6312.ocs.dao.Dao;
import com.coen6312.ocs.ui.UI;
import com.coen6312.ocs.util.DBUtil;

public class Patient {
	
	
	
	
	public String addAilmentDetails(PatientBean patientBean)
	{
		if(patientBean!=null)
		{
		
			try 
			{
				Dao daos=new Dao();
				String sts=daos.generatePatientId();
				if(!sts.equals(null))
				{
				
					patientBean.setPatientID(sts);
					String st=daos.addAilmentDetails(patientBean);
					if(st.equals("SUCCESS"))
					{
						return "SUCCESS ! PLEASE GO TO REQUEST APPOINTMENT PAGE ";
					}
					else
					{
						return "UNSUCCESSFUL";
					}
				}
				else
				{
					return "UNSUCCESSFUL";
				}
			} 
		
		
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		return "UNSUCCESSFUL";
	
	
	
	}
	
	public String findPatientByUserId(String userId)
	{
		Dao daao=new Dao();
		
		try
		{
			String s=daao.findPatientByUserId(userId);
			if(s!=null)
			{
			
				return s;
			}
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
		
	}
	
	
	public boolean viewAilmentDetails(PatientBean patientBean)
	{
		
		
		try 
		{
			Dao dw=new Dao();
			boolean h=dw.viewAilmentDetails(patientBean);
			if(h==true)
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
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	public String updatePatientAilmentDetails(PatientBean pBean,String userId)
	{
		Dao ds=new Dao();
		try 
		{
			return(ds.updatePatientAilmentDetails(pBean, userId));
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
		
		
		return "UNSUCCESSFUL";
	}
	
	
	

	
	public boolean modifyailmentDetails(PatientBean patientBean){
		boolean flag=false;
		return flag;
	}
		public ArrayList<PatientBean> viewAilmentDetails(String patientID)
		{
			
			ArrayList<PatientBean> list5=null;
			
			Dao dos=new Dao();
			//dos.viewAilmentDetails(patientID);
			
			return list5;
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String ailmenttypebypatientid(String patientid){
		String ailmenttype="";
		Dao dao=new Dao();
		try {
			ailmenttype=dao.ailmenttypebypatientid(patientid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ailmenttype;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public String addAilmentDetails(PatientBean patientBean){
		String result="FAIL";
		return result;
	}
		public boolean modifyailmentDetails(PatientBean patientBean){
		boolean flag=false;
		return flag;
	}
		public ArrayList<PatientBean> viewAilmentDetails(String patientID){
			ArrayList<PatientBean> list5=new ArrayList<PatientBean>();
			return list5;
		}*/
		public ArrayList<DoctorBean> viewListOfDoctors(String specialization){
			ArrayList<DoctorBean> list6=new ArrayList<DoctorBean>();
			Dao dao=new Dao();
			try {
				list6=dao.findAllDoctorsbySpecialization(specialization);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list6;
		}
		String requestForAppointment(String doctorID,Date appointmentDate){
			String value="";
			return value;
		}
		public Map<AppointmentBean,PatientBean> viewAppointmentDetails(String doctorID,Date date){
			Map<AppointmentBean,PatientBean> map=new HashMap<AppointmentBean,PatientBean>();
			Dao dao=new Dao();
			try 
			{
				map=dao.viewAppointmentDetails(doctorID,date);
				System.out.println(map.size());
			}
			catch (ClassNotFoundException | SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return map;
			
			
		}
		public String selectslotbydoctorid(String doctorID){
			Dao dao=new Dao();
			String slot="";
			try {
				slot=dao.selectslotbydoctorid(doctorID);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return slot;
		}
		public String addAppointment(AppointmentBean appointmentBean)
		{
			Dao dao=new Dao();
			String result="REQUEST FAILED";
			try
			{
				Connection connection;
				connection=DBUtil.getConnection();
				//doctoerBean.setDoctorID(dao.generateCandidateId(doctoerBean.getDoctorName()));
				//String sql1="insert into OCS_TBL_Doctor values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				String query="insert into OCS_TBL_Appointments values(?,?,?,?,?,'PENDING')";
				PreparedStatement pstmt=connection.prepareStatement(query);
				pstmt.setString(1,appointmentBean.getAppointmentID());
				pstmt.setString(2,appointmentBean.getDoctorID());
				pstmt.setString(3,appointmentBean.getPatientID());
				pstmt.setDate(4,new java.sql.Date(appointmentBean.getAppointmentDate().getTime()));
				pstmt.setString(5,appointmentBean.getAppointmentTime());
				
				int rows=pstmt.executeUpdate();
				if(rows!=0)
				{
					result="REQUEST SUCCEDED";
				}
				
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}
		public ArrayList<AppointmentBean> viewappointmentstatusbyappointmentid(String appointmentid){
			ArrayList<AppointmentBean> list=new ArrayList<AppointmentBean>();
			Dao dao=new Dao();
			try {
				list=dao.viewappointmentstatusbyappointmentid(appointmentid);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		/*public String getPatientAppointmentId(String PatientId)
		{
			String patientId="";
			String appointmentid="";
			Dao dao=new Dao();
			try {
				if((dao.getPatientAppointmentId(PatientId).length()>0))
				{
					PatientId=(dao.getPatientId(UI.useridfield));
					appointmentid=(dao.getPatientAppointmentId(PatientId));
					
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return result;
		}*/
		
		
		
}
