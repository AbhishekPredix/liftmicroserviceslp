/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.ge.predix.solsvc.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author predix -
 */
@RestController
public class MYFirstController {

	/**
	 *  -
	 */
	public MYFirstController() {
		super();
	}
	
	@SuppressWarnings("nls")
    @RequestMapping(value = "/myControlerTest", method = RequestMethod.GET)
    public String myTest1()
    {
        return String.format("{\"Controller\":\"MYFirstController\", \"Welocome Message\": \" Greeting your First controller succesfully created\"}");
    }
}
