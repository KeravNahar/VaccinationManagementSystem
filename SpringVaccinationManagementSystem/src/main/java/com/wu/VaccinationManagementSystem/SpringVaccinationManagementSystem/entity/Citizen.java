package com.wu.VaccinationManagementSystem.SpringVaccinationManagementSystem.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Citizen")
public class Citizen {
	
	public Citizen() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="CITIZEN_ID",updatable=false)
	private long citizenId;
	
	@Column(name="FULL_NAME",updatable=false)
	private String fullName;
	
	@Column(name="MOBILE_NUMBER")
	private int mobileNumber;
	
	@Column(name="VACCINE_NAME",updatable=false)
	private String vaccinationName;
	
	@Column(name="VACCINATION_DOSE")
	private int vaccinationDose;
	
	@Column(name="CITY")
	private String city;

	@Column(name="DOSE1DATE")
	private Date dose1Date;
	
	@Column(name="DOSE2DATE")
	private Date dose2Date;
	
	@Column(name="BOOSTERSHOT")
	private int boosterDose;
	
	@Column(name="BOOSTERDATE")
	private Date boosterDoseDate;
	
	public long getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(long citizenId) {
		this.citizenId = citizenId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getVaccinationName() {
		return vaccinationName;
	}

	public void setVaccinationName(String vaccinationName) {
		this.vaccinationName = vaccinationName;
	}

	public int getVaccinationDose() {
		return vaccinationDose;
	}

	public void setVaccinationDose(int vaccinationDose) {
		this.vaccinationDose = vaccinationDose;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDose1Date() {
		return dose1Date;
	}

	public void setDose1Date(Date dose1Date) {
		this.dose1Date = dose1Date;
	}

	public Date getDose2Date() {
		return dose2Date;
	}

	public void setDose2Date(Date dose2Date) {
		this.dose2Date = dose2Date;
	}

	public int getBoosterDose() {
		return boosterDose;
	}

	public void setBoosterDose(int boosterDose) {
		this.boosterDose = boosterDose;
	}

	public Date getBoosterDoseDate() {
		return boosterDoseDate;
	}

	public void setBoosterDoseDate(Date boosterDoseDate) {
		this.boosterDoseDate = boosterDoseDate;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		return "Citizen [citizenId=" + citizenId + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber
				+ ", vaccinationName=" + vaccinationName + ", vaccinationDose=" + vaccinationDose + ", city=" + city
				+ ", dose1Date=" + dateFormat.format(dose1Date) + ", dose2Date=" + dateFormat.format(dose2Date) + ", boosterDose=" + boosterDose
				+ ", boosterDoseDate=" + dateFormat.format(boosterDoseDate) + "]";
	}

	public Citizen(long citizenId, String fullName, int mobileNumber, String vaccinationName, int vaccinationDose,
			String city, Date dose1Date, Date dose2Date, int boosterDose, Date boosterDoseDate) {
		this.citizenId = citizenId;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.vaccinationName = vaccinationName;
		this.vaccinationDose = vaccinationDose;
		this.city = city;
		this.dose1Date = dose1Date;
		this.dose2Date = dose2Date;
		this.boosterDose = boosterDose;
		this.boosterDoseDate = boosterDoseDate;
	}


	
	
}
