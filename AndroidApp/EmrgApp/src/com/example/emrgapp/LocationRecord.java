package com.example.emrgapp;

public class LocationRecord {
	private String longitute;
	private String latitute;
	private String accuracy;
	private String timestamp;
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getLatitute() {
		return latitute;
	}
	public void setLatitute(String latitute) {
		this.latitute = latitute;
	}
	public String getLongitute() {
		return longitute;
	}
	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}
}
