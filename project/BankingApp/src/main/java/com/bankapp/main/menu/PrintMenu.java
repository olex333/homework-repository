package com.bankapp.main.menu;

import org.apache.log4j.Logger;



public class PrintMenu {
	private static Logger Log = Logger.getLogger(PrintMenu.class);

	
	public void printUserMenu() {
		Log.info("User MENU");
		Log.info("------------------");
		Log.info("Are you a employee or customer?");
		Log.info("1) Customer");
		Log.info("2) Employee");
		Log.info("3) Exit");
	}
	
	public void printCustomerLoginMenu() {
		Log.info("1) Login");
		Log.info("2) Register for an account");
	}
	
	public void printEmployeeLoginMenu() {
		Log.info("1) Login");
		Log.info("2) Register for an account");
	}
	
//	public void 

}
