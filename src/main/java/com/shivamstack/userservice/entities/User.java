package com.shivamstack.userservice.entities;

import static com.shivamstack.userservice.util.DbConstants.ADDRESS;
import static com.shivamstack.userservice.util.DbConstants.FIRST_NAME;
import static com.shivamstack.userservice.util.DbConstants.LAST_NAME;
import static com.shivamstack.userservice.util.DbConstants.MAIL_ID;
import static com.shivamstack.userservice.util.DbConstants.PHONE;
import static com.shivamstack.userservice.util.DbConstants.USER_ID;
import static com.shivamstack.userservice.util.DbConstants.USER_TABLE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = USER_TABLE)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = USER_ID)
	private long userId;

	@Column(name = FIRST_NAME)
	private String firstName;

	@Column(name = LAST_NAME)
	private String lastName;

	@Column(name = PHONE)
	private String phone;

	@Column(name = MAIL_ID)
	private String mailId;

	@OneToOne
	@JoinColumn(name = ADDRESS, referencedColumnName = "addressId")
	@Cascade(CascadeType.ALL)
	private Address address;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
