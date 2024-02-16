package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {
	
	private Prisoner[] prisoner;
	private int prisonerCount;
	
	public Prison(int size) {
		
	}
	
	public Prisoner[] getPrisoner() {
		return prisoner;
	}
	public void setPrisoner(Prisoner[] prisoner) {
		this.prisoner = prisoner;
	}
	public int getPrisonerCount() {
		return prisonerCount;
	}
	public void setPrisonerCount(int prisonerCount) {
		this.prisonerCount = prisonerCount;
	}

	
	@Override
	public void addPerson() {
		
		
	}

	@Override
	public void removePerson() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayAllPersons() {
		// TODO Auto-generated method stub
		
	}
	
	
}
