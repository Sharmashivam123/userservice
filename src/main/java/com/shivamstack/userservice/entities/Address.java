package com.shivamstack.userservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.shivamstack.userservice.util.DbConstants.ADDRESS_TABLE;
import static com.shivamstack.userservice.util.DbConstants.ADDRESS_ID;
import static com.shivamstack.userservice.util.DbConstants.FIRST_LINE;
import static com.shivamstack.userservice.util.DbConstants.SECOND_LINE;
import static com.shivamstack.userservice.util.DbConstants.PINCODE;

@Entity
@Table(name = ADDRESS_TABLE)
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ADDRESS_ID)
	private long addressId;

	@Column(name = FIRST_LINE)
	private String firstLine;

	@Column(name = SECOND_LINE)
	private String secondLine;

	@Column(name = PINCODE)
	private String pincode;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
