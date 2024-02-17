package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {
	
	private Prisoner[] prisoners;
	private int prisonerCount;
	
	public Prison(int size) {
		prisoners = new Prisoner[size];
		prisonerCount = 0;
	}
	
	public Prisoner[] getPrisoner() {
		return prisoners;
	}
	public void setPrisoner(Prisoner[] prisoner) {
		this.prisoners = prisoner;
	}
	public int getPrisonerCount() {
		return prisonerCount;
	}
	public void setPrisonerCount(int prisonerCount) {
		this.prisonerCount = prisonerCount;
	}

	
		
	

	@Override
	public void addPerson(Person person) {
		
		if(prisoners.length > prisonerCount) {
			
			prisoners[prisonerCount] = (Prisoner)person;
			System.out.println("수감자가 추가되었습니다 - " + prisoners[prisonerCount].getInfo());
			
			prisonerCount++;
		} else {
			System.out.println("인원이 모두 충원되었습니다.");
		}
	}
	
	@Override
	public void removePerson(String id) {
		
		for(int i=0; i < prisoners.length; i++) {
			
			if(prisoners[i].getId().equals(id)) {
				
				System.out.println("수감자가 삭제되었습니다 - " + prisoners[i].getInfo());
				
				prisoners[i] = null;
				
				break;
			}
		}

		
	}
	@Override
	public void displayAllPersons() {
		
		System.out.println("전체 수감자 명단 : ");
		
		for( Prisoner prs : prisoners) {
			
			if(prs == null) {
				continue;
			}
			
			System.out.println(prs.getInfo());
			
		}
		
		
	}

	
	
}
