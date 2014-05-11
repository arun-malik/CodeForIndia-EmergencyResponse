package com.codeforindia.emrgncyres.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the tracking database table.
 * 
 */
@Entity
@Table(name="tracking")


@NamedQueries({
	@NamedQuery(name="Tracking.findAll", query="SELECT t FROM Tracking t"),
	//@NamedQuery(name="Tracking.findTrackByKey", query="SELECT t FROM Tracking t")
	@NamedQuery(name="Tracking.findTrackByKey", query="SELECT t FROM Tracking t where t.userDetail = :key")

})


public class Tracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id  @GeneratedValue
	@Column(unique=true, nullable=false)
	private int trackingKey;

	private int accuracyRadius;

	@Column(length=50)
	private String lat;

	@Column(name="long", length=50)
	private String long_;

	
	private Date modifiedDateTime;

	//bi-directional many-to-one association to UserDeatil
	@ManyToOne
	@JoinColumn(name="userDetailsKey")
	private UserDetails userDetail;

	public Tracking() {
	}

	public int getTrackingKey() {
		return this.trackingKey;
	}

	public void setTrackingKey(int trackingKey) {
		this.trackingKey = trackingKey;
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

	public UserDetails getUserDeatil() {
		return this.userDetail;
	}

	public void setUserDeatil(UserDetails userDetail) {
		this.userDetail = userDetail;
	}

}