package com.shivamstack.userservice.util;

public class DbConstants {

	/* Constants related to User Table */
	public static final String USER_TABLE = "user";
	public static final String USER_ID = "userid";
	public static final String FIRST_NAME = "firstname";
	public static final String LAST_NAME = "lastname";
	public static final String PHONE = "phone";
	public static final String MAIL_ID = "email";
	public static final String ADDRESS = "address";

	/* Constants related to Address table */

	public static final String ADDRESS_TABLE = "address";
	public static final String ADDRESS_ID = "addressid";
	public static final String FIRST_LINE = "firstline";
	public static final String SECOND_LINE = "secondline";
	public static final String PINCODE = "pincode";

	/* Db Query Constants */

	public static final String FIND_BY_EMAIL = "select * from User where email =?1 ";

}
