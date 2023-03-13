package com.wu.VaccinationManagementSystem.SpringVaccinationManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.VaccinationManagementSystem.SpringVaccinationManagementSystem.dao.CitizenDAO;
import com.wu.VaccinationManagementSystem.SpringVaccinationManagementSystem.entity.Citizen;

@RestController
@RequestMapping("/api")
public class CitizenRestController {
	private CitizenDAO citizenDAO;
	
	public CitizenRestController(CitizenDAO theCitizenDAO) {
		this.citizenDAO = theCitizenDAO;
	}
	
	@GetMapping("/citizen")
	public List<Citizen> displayAllRecords(){
		return citizenDAO.displayAllRecords();
	}
	

	@GetMapping("/citizen/{citizenId}")
	public Citizen DisplayById(@PathVariable long citizenId){
		return citizenDAO.displayById(citizenId);
	}
	
	@PostMapping("/citizen")
	public Citizen RegisterCitizen(@RequestBody Citizen theCitizen){
		citizenDAO.saveRecords(theCitizen);
		return theCitizen;
	}
	
	@PutMapping("/citizen")
	public String EditCitizen(@RequestBody Citizen theCitizen){
		int status=citizenDAO.updateRecords(theCitizen);
		if(status>0) {
			return "Citizen Records updated citizen_id = "+theCitizen.getCitizenId();
		}else {
			return "Citizen Record not updated Vaccination dates are not 120 days apart";
		}
	}
	
	@DeleteMapping("/citizen/{citizenId}")
	public String deleteCitizen(@PathVariable long citizenId){
		int status=citizenDAO.deleteRecords(citizenId);
		if(status>0) {
			return "Citizen Record deleted with citizen_id = "+citizenId;
		}else {
			return "Citizen Record not deleted Vaccination pending";
		}
	}
}
