package com.coen6312.ocs.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.coen6312.ocs.bean.ProfileBean;
import com.coen6312.ocs.service.Administrator;
import com.coen6312.ocs.ui.PatientSetPassword;
import com.coen6312.ocs.ui.Register;

public class registerlistener implements ActionListener
{
	Register register;
	public registerlistener(Register register)
	{
		this.register=register;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		Administrator administrator=new Administrator();
		ProfileBean profilebean= new ProfileBean();
		if(e.getSource()==register.submitbutton)
		{
			register.registerframe.setDefaultCloseOperation(register.registerframe.EXIT_ON_CLOSE);
			register.registerframe.setVisible(true);
			
			if(register.firstnamefield.getText().trim().length()>=2 && register.firstnamefield.getText().trim().length()<15)
			{
				if(register.firstnamefield.getText().trim().matches("[a-zA-Z ]+"))
				{
					profilebean.setFirstName(register.firstnamefield.getText().trim());
					
					
					if(register.lastnamefield.getText().trim().matches("[a-zA-Z ]+"))
					{
						profilebean.setLastName(register.lastnamefield.getText());
						
						String day =(String) register.day.getSelectedItem();
						String month=(String) register.month.getSelectedItem();
						String year=(String) register.year.getSelectedItem();
						String date=day+"-"+month+"-"+year;
						if(register.month.getSelectedItem().equals("Feb") &&  (register.day.getSelectedItem().equals("31") || register.day.getSelectedItem().equals("30"))){
							JOptionPane.showMessageDialog(null,"INVALID DATE IN MONTH");
						}
						else if((register.month.getSelectedItem().equals("Apr") || register.month.getSelectedItem().equals("Jun")|| register.month.getSelectedItem().equals("Sep")  || register.month.getSelectedItem().equals("Nov") )&&  (register.day.getSelectedItem().equals("31") )){
							JOptionPane.showMessageDialog(null,"INVALID DATE IN MONTH");
						}
						else{
						DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
						Date utildate= new Date();
						try
						{
							utildate=df.parse(date);
						} catch (ParseException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Date sysdate= new Date();
						int temp=sysdate.compareTo(utildate);
						if(temp>0)
						{
							profilebean.setDateOfBirth(utildate);
							
							String gender="";
							boolean flag=false;
							if(register.malebutton.isSelected())
							{
								 gender=register.malebutton.getText();
								 flag=true;
							}
							else if(register.femalebutton.isSelected())
							{
								 gender=register.femalebutton.getText();
								 flag=true;
							}
							if(flag==false)
							{
								JOptionPane.showMessageDialog(null,"SELECT GENDER  !!");
							}
							if(flag==true)
							{
								profilebean.setGender(gender);
								if(register.streetarea.getText().trim().length()==0)
								{
									JOptionPane.showMessageDialog(null,"STREET CAN NOT BE NULL  !!");
								}
								else if(register.streetarea.getText().trim().length()>30)
								{
									JOptionPane.showMessageDialog(null,"STREET CAN NOT BE MORE THAN 30 CHARACTERS  !!");
								}
								else
								{

									profilebean.setStreet(register.streetarea.getText());
									
									if(register.locationfield.getText().trim().length()==0)
									{
										JOptionPane.showMessageDialog(null,"LOCATION CAN NOT BE NULL  !!");	
									}
									else if(register.locationfield.getText().trim().length()>15)
									{
										JOptionPane.showMessageDialog(null,"LOCATION CAN NOT BE MORE THAN 15 CHARACTERS  !!");
									}
									else
									{
										profilebean.setLocation(register.locationfield.getText());
										if(register.cityfield.getText().trim().length()==0)
										{
											JOptionPane.showMessageDialog(null,"CITY CAN NOT BE NULL  !!");
										}
										else if(register.cityfield.getText().trim().length()>15)
										{
											JOptionPane.showMessageDialog(null,"CITY CAN NOT BE MORE THAN 15 CHARACTERS  !!");
										}
										else if(register.cityfield.getText().trim().matches("[a-zA-Z]+"))
										{

											profilebean.setCity(register.cityfield.getText());
											
											if(register.statefield.getText().trim().length()==0)
											{
												JOptionPane.showMessageDialog(null,"STATE CAN NOT BE NULL  !!");
											}
											else if(register.statefield.getText().trim().length()>15)
											{
												JOptionPane.showMessageDialog(null,"CITY CAN NOT BE MORE THAN 15 CHARACTERS  !!");
											}
											else if(register.statefield.getText().trim().matches("[a-zA-Z]+"))
											{

												profilebean.setState(register.statefield.getText());
												
												if(register.postalcodefield.getText().trim().length()==0)
												{
													JOptionPane.showMessageDialog(null,"POSTAL CODE CAN NOT BE NULL  !!");
												}
												else if(register.postalcodefield.getText().trim().matches("[a-zA-Z0-9]*"))
												{
													if(register.postalcodefield.getText().trim().length()==6 &&(!register.postalcodefield.getText().trim().equals("000000")))
													{
														profilebean.setPincode(register.postalcodefield.getText());
														
														if(register.mobilenofield.getText().trim().length()==0)
														{
															JOptionPane.showMessageDialog(null,"MOBILE NUMBER CAN NOT BE NULL  !!");
														}
														else if(register.mobilenofield.getText().trim().matches("[0-9]+"))
														{
															if(register.mobilenofield.getText().trim().length()==10 &&(!register.mobilenofield.getText().trim().equals("0000000000")))
															{
																profilebean.setMobileNo(register.mobilenofield.getText());
																
																if(register.emailidfield.getText().trim().length()==0)
																{
																	JOptionPane.showMessageDialog(null,"EMAIL CAN NOT BE NULL  !!");
																}
																else if(register.emailidfield.getText().trim().length()<5)
																{
																	JOptionPane.showMessageDialog(null,"EMAIL CAN NOT BE LESS THAN 5 CHARACTERS !!");
																}
																else if(register.emailidfield.getText().trim().length()>30)
																{
																	JOptionPane.showMessageDialog(null,"EMAIL CAN NOT BE MORE THAN 30 CHARACTERS !!");
																}
																else 
																{
																	if((register.emailidfield.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")))
																	{
																		profilebean.setEmailID(register.emailidfield.getText());
																		profilebean.setUserId(administrator.setUserId(profilebean));
																		if(administrator.addPatientDetails(profilebean).equalsIgnoreCase("DATA SUCCESSFULLY UPDATED"))
																		{
																			
																			PatientSetPassword patientsetpassword=new PatientSetPassword(profilebean);
																			register.registerframe.setVisible(false);
																		}
																		else 
																		{
																			JOptionPane.showMessageDialog(null,"ERROR WHILE UPDATING");
																		}	
																	}
																	else
																	{
																		JOptionPane.showMessageDialog(null,"EMAIL SHOULD BE IN THE FORMATE OF eg. xyzQ@adc.com !!");
																	}
																}
															}
															else if((register.mobilenofield.getText().trim().equals("0000000000")))
																	{
																		JOptionPane.showMessageDialog(null,"OPPS!! MOBILE NUMBER CANT NOT BE '0000000000' !!");
																	}
															else
															{
																JOptionPane.showMessageDialog(null,"MOBILE NUMBER LENGTH MUST BE 10 !!");
															}
														}
														else
														{
															JOptionPane.showMessageDialog(null,"MOBILE NUMBER CONTAINS ONLY NUMBERS !!");
														}
													}
													else if(register.postalcodefield.getText().trim().equals("000000"))
													{
														JOptionPane.showMessageDialog(null,"OPPS !!POSTAL CODE CAN NOT BE '000000'  !!");
													}
													else
													{
														JOptionPane.showMessageDialog(null,"POSTAL CODE LENGTH MUST BE 6  !!");
													}
												}
												else
												{
													JOptionPane.showMessageDialog(null,"POSTAL CODE CONTAINS ONLY NUMBERS AND LETTERS  !!");
												}
											}
											else
											{
												JOptionPane.showMessageDialog(null,"STATE CONTAINS ONLY LETTERS  !!");
												register.statefield.setText("");
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null,"CITY CONTAINS ONLY LETTERS  !!");
											register.cityfield.setText("");
										}
									}
								
								}
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"SELECTED DATE MUST BE LESS THAN CURRENT DATE  !!");
						}
					}
				}
					else if(register.lastnamefield.getText().trim().length()>15)
					{
						JOptionPane.showMessageDialog(null,"LAST NAME CANT NOT BE MORE THAN 15 CHARACTERS  !!");
					}
					else if(register.lastnamefield.getText().trim().length()==0)
					{
						JOptionPane.showMessageDialog(null," LAST NAME CANT NOT BE NULL !!");
					}
					else
					{
						JOptionPane.showMessageDialog(null,"ONLY CHARACTERS ARE ALLOWED IN LAST NAME !!");
						register.lastnamefield.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"ONLY CHARACTERS ARE ALLOWED IN FIRST NAME!!");
					register.firstnamefield.setText("");
				}
			}
			else if(register.firstnamefield.getText().trim().length()>15)
			{
				JOptionPane.showMessageDialog(null,"FIRST NAME CANT NOT BE MORE THAN 15 CHARACTERS  !!");
			}
			else if(register.firstnamefield.getText().trim().length()==0)
			{
				JOptionPane.showMessageDialog(null,"FIRST NAME CANT NOT BE NULL  !!");	
			}
			else
			{
				JOptionPane.showMessageDialog(null,"LENGTH OF NAME MUST BE GREATER THAN TWO CHARACTERS !!");
			}
		}
	}
	
		
	}


