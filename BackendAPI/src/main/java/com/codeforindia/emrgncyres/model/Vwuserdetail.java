package com.codeforindia.emrgncyres.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigInteger;


/**
 * The persistent class for the vwuserdetails database table.
 * 
 */
@Entity
@Table(name="vwuserdetails")

@NamedQueries({
	@NamedQuery(name="vWfindAll", query="SELECT v FROM Vwuserdetail v"),
	@NamedQuery(name="findUserByUserCodeOrName", query="SELECT v FROM Vwuserdetail v where v.firstName = :username or v.userCode = :username")
})


public class Vwuserdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=45)
	private String bloodGroup;

	@Column(length=55)
	private String emergencyContactName;

	private BigInteger emergencyContactNumber;

	@Column(length=55)
	private String fathersName;

	private int fellowPassengerCount;

	@Column(length=55)
	private String firstName;

	@Column(length=55)
	private String lastName;

	private BigInteger mobileNumber;

	@Column(length=55)
	private String mothersName;

	@Id
	private double userCode;

	@Column(nullable=false)
	private int userDetailsKey;

	public Vwuserdetail() {
	}

	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getEmergencyContactName() {
		return this.emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public BigInteger getEmergencyContactNumber() {
		return this.emergencyContactNumber;
	}

	public void setEmergencyContactNumber(BigInteger emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	public String getFathersName() {
		return this.fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public int getFellowPassengerCount() {
		return this.fellowPassengerCount;
	}

	public void setFellowPassengerCount(int fellowPassengerCount) {
		this.fellowPassengerCount = fellowPassengerCount;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigInteger getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMothersName() {
		return this.mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public double getUserCode() {
		return this.userCode;
	}

	public void setUserCode(double userCode) {
		this.userCode = userCode;
	}

	public int getUserDeatilsKey() {
		return this.userDetailsKey;
	}

	public void setUserDeatilsKey(int userDeatilsKey) {
		this.userDetailsKey = userDeatilsKey;
	}

}