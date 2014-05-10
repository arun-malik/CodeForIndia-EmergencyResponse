package com.codeforindia.emrgncyres.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the incidentReported database table.
 * 
 */
@Entity
@Table(name="incidentReported")
@NamedQuery(name="IncidentReported.findAll", query="SELECT i FROM IncidentReported i")
public class IncidentReported implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id  @GeneratedValue
	@Column(unique=true, nullable=false)
	private int incidentReportedKey;

	@Column(length=55)
	private String lat;

	@Column(name="long", length=55)
	private String long_;

	@Column(length=200)
	private String reportedMessage;

	//bi-directional many-to-one association to UserDeatil
	@ManyToOne
	@JoinColumn(name="userKey")
	private UserDetails userDeatil;

	public IncidentReported() {
	}

	public int getIncidentReportedKey() {
		return this.incidentReportedKey;
	}

	public void setIncidentReportedKey(int incidentReportedKey) {
		this.incidentReportedKey = incidentReportedKey;
	}

	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLong_() {
		return this.long_;
	}

	public void setLong_(String long_) {
		this.long_ = long_;
	}

	public String getReportedMessage() {
		return this.reportedMessage;
	}

	public void setReportedMessage(String reportedMessage) {
		this.reportedMessage = reportedMessage;
	}

	public UserDetails getUserDeatil() {
		return this.userDeatil;
	}

	public void setUserDeatil(UserDetails userDeatil) {
		this.userDeatil = userDeatil;
	}

}