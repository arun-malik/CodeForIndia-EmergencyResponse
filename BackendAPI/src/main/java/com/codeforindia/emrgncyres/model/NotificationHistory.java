package com.codeforindia.emrgncyres.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the notificationHistory database table.
 * 
 */
@Entity
@Table(name="notificationHistory")
@NamedQuery(name="NotificationHistory.findAll", query="SELECT n FROM NotificationHistory n")
public class NotificationHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id  @GeneratedValue
	@Column(unique=true, nullable=false)
	private int notificationHistoryKey;

	@Column(length=55)
	private String channelKey;

	@Column(length=180)
	private String messageText;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="adminKey")
	private Admin admin;

	public NotificationHistory() {
	}

	public int getNotificationHistoryKey() {
		return this.notificationHistoryKey;
	}

	public void setNotificationHistoryKey(int notificationHistoryKey) {
		this.notificationHistoryKey = notificationHistoryKey;
	}

	public String getChannelKey() {
		return this.channelKey;
	}

	public void setChannelKey(String channelKey) {
		this.channelKey = channelKey;
	}

	public String getMessageText() {
		return this.messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}