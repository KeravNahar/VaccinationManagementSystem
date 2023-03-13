package com.wu.VaccinationManagementSystem.SpringVaccinationManagementSystem.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.wu.VaccinationManagementSystem.SpringVaccinationManagementSystem.entity.Citizen;

@Repository
public class CitizenDAOImplementation implements CitizenDAO {
	
	private EntityManager entityManager;
	
	public CitizenDAOImplementation(EntityManager theEntityManager) {
		this.entityManager=theEntityManager;
	}
	
	@Override
	@Transactional
	public List<Citizen> displayAllRecords() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Citizen> theQuery = currentSession.createQuery("from Citizen",Citizen.class);
		List<Citizen> citizens = theQuery.getResultList();
		return citizens;
	}

	@Override
	@Transactional
	public Citizen displayById(long theid) {
		Session currentSession = entityManager.unwrap(Session.class);
		Citizen theCitizen = currentSession.get(Citizen.class, theid);
		return theCitizen;
	}

	@Override
	@Transactional
	public void saveRecords(Citizen theCitizen) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCitizen);
	}

	@Override
	@Transactional
	public int deleteRecords(long citizenId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("delete from Citizen where citizen_id=:citizenId AND VACCINATION_DOSE=2 AND BOOSTERSHOT=1");
		theQuery.setParameter("citizenId", citizenId);
		int status = theQuery.executeUpdate();
		return status;
	}

	@Override
	@Transactional
	public int updateRecords(Citizen theCitizen) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Date dose1Date = theCitizen.getDose1Date();
		Date dose2Date = theCitizen.getDose2Date();
		Date boosterDate = theCitizen.getBoosterDoseDate();
		
		long dose1DateInMs = dose1Date.getTime();
		long dose2DateInMs = dose2Date.getTime();
		long boosterDateInMs = boosterDate.getTime();
		
		long daysDiff=0;
		if(theCitizen.getBoosterDose()==0) {
			long timeDiff = Math.abs(dose2DateInMs - dose1DateInMs);
			daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
		}else {
			long timeDiff = Math.abs(boosterDateInMs - dose2DateInMs);
			daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
		}
		
		
		if(daysDiff>120) {
			currentSession.saveOrUpdate(theCitizen);
			return 1;
		}else {
			return 0;
		}
	}


}
