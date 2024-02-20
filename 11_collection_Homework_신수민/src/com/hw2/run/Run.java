package com.hw2.run;

import com.hw2.model.dto.Animal;
import com.hw2.model.dto.Monkey;
import com.hw2.model.dto.Tiger;
import com.hw2.model.service.Zoo;

public class Run {
	
	public static void main(String[] args) {

		// Zoo 객체 생성
		Zoo zoo = new Zoo();
				
		//Tiger 객체 생성하여 zoo에 추가하기
		//Animal tiger = new Tiger("호랑이");
		zoo.addAnimal(new Tiger("호랑이"));
		
		// Monkey 객체 생성하여 zoo에 추가하기
		//Animal monkey = new Monkey("원숭이");
		zoo.addAnimal(new Monkey("원숭이"));
		
		zoo.displayMenu();
		
	}
	
}
