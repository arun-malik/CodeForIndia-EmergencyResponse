package com.codeforindia.emrgncyres.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the trackingHistory database table.
 * 
 */
@Entity
@Table(name="trackingHistory")

@NamedQuery(name="TrackingHistory.findAllByUser", query="SELECT u FROM TrackingHistory u where u.userDetail = :key")
//@NamedQuery(name="TrackingHistory.findAllByUser", query="SELECT u FROM TrackingHistory u")


public class TrackingHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id  @GeneratedValue
	@Column(unique=true, nullable=false)
	private int trackingHistoryKey;

	private int accuracyRadius;

	@Column(length=50)
	private String lat;

	@Column(name="long", length=50)
	private String long_;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDateTime;

	@Column(nullable=false)
	private int trackingKey;

	@Column(length=45)
	private String triggerAction;

	//bi-directional many-to-one association to UserDeatil
	@ManyToOne
	@JoinColumn(name="userDetailsKey")
	private UserDetails userDetail;

	public TrackingHistory() {
	}

	public int getTrackingHistoryKey() {
		return this.trackingHistoryKey;
	}

	public void setTrackingHistoryKey(int trackingHistoryKey) {
		this.trackingHistoryKey = trackingHistoryKey;
	}

	public int getAccuracyRadius() {
		return this.accuracyRadius;
	}

	public void setAccuracyRadius(int accuracyRadius) {
		this.accuracyRadius = accuracyRadius;
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

	public Date getModifiedDateTime() {
		return this.modifiedDateTime;
	}

	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}

	public int getTrackingKey() {
		return this.trackingKey;
	}

	public void setTrackingKey(int trackingKey) {
		this.trackingKey = trackingKey;
	}

	public String getTriggerAction() {
		return this.triggerAction;
	}

	public void setTriggerAction(String triggerAction) {
		this.triggerAction = triggerAction;
	}

	public UserDetails getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetails userDeatil) {
		this.userDetail = userDeatil;
	}

}