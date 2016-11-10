/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.lnt.predix.lift;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ge.predix.model.LiftDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import springfox.documentation.spring.web.json.Json;

/**
 * 
 * @author predix -
 */
@RestController
public class LiftController {

	/**
	 *  -
	 */
	
	public LiftController() {
		super();
	}
	@SuppressWarnings("nls")
    @RequestMapping(value = "/liftDetails", method = RequestMethod.GET)
    public String liftDetails()
    {
        return String.format("{\"Floor\":\"1st-Floor\", \"LiftName\": \"L3 main Lift\"}");
    }
	
	private  LiftDetails lftDetail;
	
	
	@SuppressWarnings("nls")
    @RequestMapping(value = "/elevatorList", method = RequestMethod.GET)
	public @ResponseBody String getElevatorList() throws JSONException{
	
		populateLiftData();
		JSONArray liftDetailsArray = new JSONArray();
		JSONObject liftDetailsJson = null;
		if(liftDetailsList.size()>0){			
			for(LiftDetails d:liftDetailsList){
				liftDetailsJson = new JSONObject();
				liftDetailsJson.put("Tenant ID",d.getTenentID());
				liftDetailsJson.put("Sessin ID",d.getSessionID());
				liftDetailsJson.put("Location ID",d.getLocationID());
				/*liftDetailsJson.put("elevator ID",d.getElevatorID());*/
				liftDetailsArray.put(liftDetailsJson);
			}
			
		}
		liftDetailsList= new ArrayList<>();
		
		return liftDetailsArray.toString();
			
	}
	
	
	
	/*Getting alarm trend data on API call*/
	@SuppressWarnings("nls")
    @RequestMapping(value = "/elevatorAlarmTrend", method = RequestMethod.GET)
	/*public @ResponseBody JSONArray myMethod() throws JSONException{*/
	public @ResponseBody String  getElevatorAlarmTrend() throws JSONException{
		populateLiftData();
		JSONArray liftDetailsArray = new JSONArray();
		JSONObject liftDetailsJson = null;
		if(liftDetailsList.size()>0){			
			for(LiftDetails d:liftDetailsList){
				liftDetailsJson = new JSONObject();
				liftDetailsJson.put("Tenant ID",d.getTenentID());
				liftDetailsJson.put("Sessin ID",d.getSessionID());
				liftDetailsJson.put("Location ID",d.getLocationID());
				liftDetailsJson.put("elevator ID",d.getElevatorID());
				liftDetailsArray.put(liftDetailsJson);
			}
			
		}
		liftDetailsList= new ArrayList<>();
		
		return liftDetailsArray.toString();
			
	}
	
	
	
	@SuppressWarnings("nls")
    @RequestMapping(value = "/elevatorTripTrend", method = RequestMethod.GET)
	public @ResponseBody String getElevatorTripTrend() throws JSONException{

		populateLiftData();
		JSONArray liftDetailsArray = new JSONArray();
		JSONObject liftDetailsJson = null;
		if(liftDetailsList.size()>0){			
			for(LiftDetails d:liftDetailsList){
				liftDetailsJson = new JSONObject();
				liftDetailsJson.put("Tenant ID",d.getTenentID());
				liftDetailsJson.put("Sessin ID",d.getSessionID());
				liftDetailsJson.put("Location ID",d.getLocationID());
				liftDetailsJson.put("elevator ID",d.getElevatorID());
				liftDetailsJson.put("StartDate",d.getElevatorStartDate());
				liftDetailsJson.put("To Date",d.getElevatorToDate());
				liftDetailsArray.put(liftDetailsJson);
			}
			
		}
		liftDetailsList= new ArrayList<>();
		
		return liftDetailsArray.toString();
			
	}

	
	@SuppressWarnings("nls")
    @RequestMapping(value = "/elevatorAlertList", method = RequestMethod.GET)
	public @ResponseBody String getAlertList() throws JSONException{

		populateLiftData();
		JSONArray liftDetailsArray = new JSONArray();
		JSONObject liftDetailsJson = null;
		if(liftDetailsList.size()>0){			
			for(LiftDetails d:liftDetailsList){
				liftDetailsJson = new JSONObject();
				liftDetailsJson.put("Tenant ID",d.getTenentID());
				liftDetailsJson.put("Sessin ID",d.getSessionID());
				liftDetailsJson.put("Location ID",d.getLocationID());
				liftDetailsJson.put("elevator ID",d.getElevatorID());
				/*liftDetailsJson.put("StartDate",d.getElevatorStartDate());
				liftDetailsJson.put("To Date",d.getElevatorToDate());
*/				liftDetailsArray.put(liftDetailsJson);
			}
			
		}
		liftDetailsList= new ArrayList<>();
		
		return liftDetailsArray.toString();
			
	}
	
	 List<LiftDetails> liftDetailsList = new ArrayList<LiftDetails>();
	@SuppressWarnings({ "javadoc", "unqualified-field-access" })
	public void populateLiftData(){
		
		 int tenentID=0;
		 String  sessionID="AX";//$NON-NLS-1$
		 String  locationID="Loc";//$NON-NLS-1$
		 String  elevatorID="El"; //$NON-NLS-1$
				
		for (int i=0;i<10;i++){
			 lftDetail= new LiftDetails();
			tenentID= i+1;
			sessionID =sessionID + Integer.toString(i);
			locationID =locationID + Integer.toString(i);
			elevatorID =elevatorID + Integer.toString(i);
			
			 SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			   Calendar c =  Calendar.getInstance();
					   
			   try {
				String d = sdf1.format(c.getTime());
				lftDetail.setElevatorStartDate(d);
				System.out.println("Expected Date format output " + d);
				c.add(Calendar.DATE, i);
				String d1 = sdf1.format(c.getTime());
				System.out.println("Next Expected Date format output " + d1);
				lftDetail.setElevatorToDate(d1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Exception handled " + e );
			}
			 
			lftDetail.setTenentID(tenentID);
			lftDetail.setSessionID(sessionID);
			lftDetail.setElevatorID(elevatorID);
			lftDetail.setLocationID(locationID);
			liftDetailsList.add(lftDetail);
			//lftDetail=null;
		}
	}
	
	public String  getFromdatetoTodate(Date d,int i){
		
		Calendar cal = Calendar.getInstance();
				  
				   // print current date
		System.out.println("The current date is : " + d.getTime());
				  // System.out.println("The current date is : " + cal.getTime());

				   // add 20 days to the calendar
				   cal.add(Calendar.DATE, 1);
				   System.out.println("1 days later: " + cal.getTime());
				   Date retundate = cal.getTime();
				   System.out.println("My 1 days later: " + retundate);

		return null ;
	}
	
	@SuppressWarnings({ "nls", "javadoc" })
	
	//@Path("/tokenvalidation/{year}/{month}/{day}")
   // @RequestMapping(value = "/tokenvalidation/{varX}", method = RequestMethod.GET)
	@RequestMapping(method=RequestMethod.POST, value="/tokenvalidation/{varX}", produces=MediaType.TEXT_PLAIN_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String tokenvalidation(@PathVariable String varX)
    { 
		/*//Start of adding code for UAA Token verification
		const uaa_util = require('predix-uaa-client');
		// Call with client credentials (UAAUrl, ClientID, ClientSecret), 
		// will fetch a client token using these credentials. 
		// In this case the client needs authorized_grant_types: client_credentials 
		uaa_util.getToken(url, clientId, clientSecret).then((token) => {
		    // Use token.access_token as a Bearer token Authroization header 
		    // in calls to secured services. 
		    request.get({
		        uri: 'https://secured.service.example.com',
		        headers: {
		            Authorization: 'Bearer ' + token.access_token
		        }
		    }).then((data) => {
		        console.log('Got ' + data + ' from service');
		    }).catch((err) => {
		        console.error('Error getting data', err);
		    });
		}).catch((err) => {
		    console.error('Error getting token', err);
		});*/
		//End of UAA verification code
		/*JSONArray totalEnergyGenerationarray = new JSONArray();
		JSONObject totalEnergyGenerationJson = new JSONObject();*/
		if(varX.equals("eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiI2ZjIzNmJjYzFkNDk0MTQzYmJiOGQ2YWYyZTdlMzU1MCIsInN1YiI6ImFkbWluIiwic2NvcGUiOlsiY2xpZW50cy5yZWFkIiwiY2xpZW50cy5zZWNyZXQiLCJpZHBzLndyaXRlIiwidWFhLnJlc291cmNlIiwic3BzLnJlYWQiLCJzcHMud3JpdGUiLCJjbGllbnRzLndyaXRlIiwiY2xpZW50cy5hZG1pbiIsImlkcHMucmVhZCIsInNjaW0ud3JpdGUiLCJ6b25lcy42OTFlMzdkOS03ZGUzLTQ4ZTItOTg0OS1jMTk2NzQzOGY0ODYuYWRtaW4iLCJzY2ltLnJlYWQiXSwiY2xpZW50X2lkIjoiYWRtaW4iLCJjaWQiOiJhZG1pbiIsImF6cCI6ImFkbWluIiwiZ3JhbnRfdHlwZSI6ImNsaWVudF9jcmVkZW50aWFscyIsInJldl9zaWciOiIxYTNlMTU0MCIsImlhdCI6MTQ3NzU3MDM0NywiZXhwIjoxNDc3NjEzNTQ3LCJpc3MiOiJodHRwczovL2xpZnQucHJlZGl4LXVhYS5ydW4uYXdzLXVzdzAyLXByLmljZS5wcmVkaXguaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiI2OTFlMzdkOS03ZGUzLTQ4ZTItOTg0OS1jMTk2NzQzOGY0ODYiLCJhdWQiOlsic2NpbSIsImNsaWVudHMiLCJ1YWEiLCJzcHMiLCJhZG1pbiIsInpvbmVzLjY5MWUzN2Q5LTdkZTMtNDhlMi05ODQ5LWMxOTY3NDM4ZjQ4NiIsImlkcHMiXX0.ZyGnqN4IrNHLMzpEzhQ1VhqCdj1Sd1sGnxVEit3EB262wFx7r-V8dreWQ_ib7w1h8O_CIFX7_vSAYyTOn8vX6HSWeOcdXNasTWnhf3DAhU42xlx8prj6-CDJX1aTmAKXmMwxBz8un1Z2mUPph2NP-NfJYSRwfzKF_iSW1M0udFQ-BciguuXlB9ofHUzjPvltuRqJ4xpRAcpTo9bXkBSId9fdcrmJ1MX7xhgpasGTacrVljXarp_mZf3EwBtQW8lOVOv5OTVLbVnQAHxz-SLIjRbHJDdp5WJXvIY1gpzf_BfV_VRb2IdNU_xkigfQ6CM0TyDCHYMakoC4Yt8XPsjZrA"))
		//if(varX.equals("abc"))
			return String.format("{\"token\":\"valid\", \"Token is \": varX\"}");
		else return String.format("{\"Token\":\"invalid\", \"token value is \": \"testing\"}");
    }
}
