package com.wu.VaccinationManagementSystem.SpringVaccinationManagementSystem.dao;
import java.util.List;
import com.wu.VaccinationManagementSystem.SpringVaccinationManagementSystem.entity.Citizen;

public interface CitizenDAO {
	public List<Citizen> displayAllRecords();	
	public Citizen displayById(long theid);
	public void saveRecords(Citizen theCitizen);
	public int updateRecords(Citizen theCitizen);
	public int deleteRecords(long theId);
}
