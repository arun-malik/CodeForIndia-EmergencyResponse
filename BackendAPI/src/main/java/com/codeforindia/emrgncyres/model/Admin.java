package com.codeforindia.emrgncyres.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the admin database table.
 * 
 */
@Entity
@Table(name="admin")
@NamedQuery(name="Admin.findByUsername", query="SELECT a FROM Admin a WHERE a.username= :username")
public class Admin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id  @GeneratedValue
	@Column(unique=true, nullable=false)
	private int adminKey;

	@Column(length=100)
	private String password;

	@Column(length=55)
	private String username;

	//bi-directional many-to-one association to NotificationHistory
	@OneToMany(mappedBy="admin")
	private List<NotificationHistory> notificationHistories;

	public Admin() {
	}

	public int getAdminKey() {
		return this.adminKey;
	}

	public void setAdminKey(int adminKey) {
		this.adminKey = adminKey;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<NotificationHistory> getNotificationHistories() {
		return this.notificationHistories;
	}

	public void setNotificationHistories(List<NotificationHistory> notificationHistories) {
		this.notificationHistories = notificationHistories;
	}

	public NotificationHistory addNotificationHistory(NotificationHistory notificationHistory) {
		getNotificationHistories().add(notificationHistory);
		notificationHistory.setAdmin(this);

		return notificationHistory;
	}

	public NotificationHistory removeNotificationHistory(NotificationHistory notificationHistory) {
		getNotificationHistories().remove(notificationHistory);
		notificationHistory.setAdmin(null);

		return notificationHistory;
	}

}