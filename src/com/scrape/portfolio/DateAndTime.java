package com.scrape.portfolio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="date_time")
public class DateAndTime {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="date_time_id")
	private int date_time_id;
	
	private FormatTimeService formatTimeService;
	
	@Autowired
	public DateAndTime(FormatTimeService theFormatTimeService) throws ParseException {
		String dateTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		String[] timeSplit = dateTime.split("\\s+");
		
		this.date = timeSplit[0];
		this.time = theFormatTimeService.formatTime(timeSplit[1]);
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime()  {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDate_time_id() {
		return date_time_id;
	}

	public void setDate_time_id(int date_time_id) {
		this.date_time_id = date_time_id;
	}

}

