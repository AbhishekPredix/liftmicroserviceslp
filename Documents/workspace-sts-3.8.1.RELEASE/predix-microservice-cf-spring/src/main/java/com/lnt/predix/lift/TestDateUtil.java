/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 
 
package com.lnt.predix.lift;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

*//**
 * 
 * @author predix -
 *//*
public class TestDateUtil {

	*//**
	 * @param args -
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tesDate();
	}
	
	
   public static void tesDate(){
	   SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	   Calendar c =  Calendar.getInstance();
	   //Date s =  c.getTime();
	  // System.out.println("Pure Date format output" + s);
	   
	   
	   try {
		String d = sdf1.format(c.getTime());
		System.out.println("Expected Date format output " + d);
		c.add(Calendar.DATE, 1);
		String d1 = sdf1.format(c.getTime());
		System.out.println("Next Expected Date format output " + d1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Exception handled " + e );
	}
	   d= c.getTime();
	   System.out.println("In date variable" + d);
	   
	  try {
		System.out.println("Parsed date formate  " + sdf1.parse(c.getTime().toString()));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
*/