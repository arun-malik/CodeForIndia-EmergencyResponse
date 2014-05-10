package com.codeforindia.emrgncyres.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the userDeatils database table.
 * 
 */
@Entity
@Table(name="userDeatils")
@NamedQueries({
	@NamedQuery(name="UserDetails.findAll", query="SELECT u FROM UserDetails u"),
	@NamedQuery(name="UserDetails.findByUserDetailsKey", query="SELECT u FROM UserDetails u where u.userDeatilsKey = :key")
})

public class UserDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id  @GeneratedValue
	@Column(unique=true, nullable=false)
	private int userDeatilsKey;

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

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDateTime;

	@Column(length=55)
	private String mothersName;

	private byte trackStatus;

	//bi-directional many-to-one association to IncidentReported
	@OneToMany(mappedBy="userDeatil")
	private List<IncidentReported> incidentReporteds;

	//bi-directional many-to-one association to Tracking
	@OneToMany(mappedBy="userDeatil")
	private List<Tracking> trackings;

	//bi-directional many-to-one association to TrackingHistory
	@OneToMany(mappedBy="userDeatil")
	private List<TrackingHistory> trackingHistories;

	public UserDetails() {
	}

	public int getUserDeatilsKey() {
		return this.userDeatilsKey;
	}

	public void setUserDeatilsKey(int userDeatilsKey) {
		this.userDeatilsKey = userDeatilsKey;
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

	public Date getModifiedDateTime() {
		return this.modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public String getMothersName() {
		return this.mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public byte getTrackStatus() {
		return this.trackStatus;
	}

	public void setTrackStatus(byte trackStatus) {
		this.trackStatus = trackStatus;
	}

	public List<IncidentReported> getIncidentReporteds() {
		return this.incidentReporteds;
	}

	public void setIncidentReporteds(List<IncidentReported> incidentReporteds) {
		this.incidentReporteds = incidentReporteds;
	}

	public IncidentReported addIncidentReported(IncidentReported incidentReported) {
		getIncidentReporteds().add(incidentReported);
		incidentReported.setUserDeatil(this);

		return incidentReported;
	}

	public IncidentReported removeIncidentReported(IncidentReported incidentReported) {
		getIncidentReporteds().remove(incidentReported);
		incidentReported.setUserDeatil(null);

		return incidentReported;
	}

	public List<Tracking> getTrackings() {
		return this.trackings;
	}

	public void setTrackings(List<Tracking> trackings) {
		this.trackings = trackings;
	}

	public Tracking addTracking(Tracking tracking) {
		getTrackings().add(tracking);
		tracking.setUserDeatil(this);

		return tracking;
	}

	public Tracking removeTracking(Tracking tracking) {
		getTrackings().remove(tracking);
		tracking.setUserDeatil(null);

		return tracking;
	}

	public List<TrackingHistory> getTrackingHistories() {
		return this.trackingHistories;
	}

	public void setTrackingHistories(List<TrackingHistory> trackingHistories) {
		this.trackingHistories = trackingHistories;
	}

	public TrackingHistory addTrackingHistory(TrackingHistory trackingHistory) {
		getTrackingHistories().add(trackingHistory);
		trackingHistory.setUserDeatil(this);

		return trackingHistory;
	}

	public TrackingHistory removeTrackingHistory(TrackingHistory trackingHistory) {
		getTrackingHistories().remove(trackingHistory);
		trackingHistory.setUserDeatil(null);

		return trackingHistory;
	}

}