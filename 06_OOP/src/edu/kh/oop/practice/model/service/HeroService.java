package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Hero;

public class HeroService {
	
	public void ex1() {
		
		/*
		패키지명 : edu.kh.oop.practice.model.vo
		클래스 : Hero(영웅 클래스)
		- 닉네임 : nickName
		- 직업 : job
		- 체력 : hp
		- 마력 : mp
		- 레벨 : level
		- 경험치 : exp
		
		(추상화/캡슐화)
		
		메서드
		- getter/setter
		- attack(exp) : nick + "은/는 공격을 했다!" 출력 후 전달 받은 경험치를 현재 경험치에 누적,
						누적 경험치가 500을 넘으면 레벨 1업 하기,
						레벨이 올랐다는 문구 출력 + 현재 레벨 표시
		- magicJump() : 점프할 때마다 nickName + "의 점프!" 출력 동시에 mp가 -10씩 감소됨.
		단, 현재 mp가 0 이하라면 "더 이상 매직 점프할 수 없어요!" 출력
		
		기능 제공용 클래스 : edu.kh.oop.practice.model.service.HeroService
		실행용 클래스 : edu.kh.oop.practice.run.PracticeRun
		 */
		
		
		Hero hr1 = new Hero();
		Hero hr2 = new Hero();
		
		hr1.setNickName("홍길동");
		hr1.setJob("마법사");
		hr1.setHp(50);
		hr1.setMp(70);
		hr1.setLevel(1);
		hr1.setExp(0);
		
		System.out.printf("%s 직업으로 '%s' 님이 생성되었습니다. 현재 레벨 : %d\n",
					hr1.getJob(), hr1.getNickName(), hr1.getLevel()
				);
		
		hr1.attack(400);
		hr1.attack(400);
		hr1.attack(400);

		hr1.magicJump();
		hr1.magicJump();
		hr1.magicJump();
		hr1.magicJump();
		hr1.magicJump();
		hr1.magicJump();
		hr1.magicJump();
		hr1.magicJump();
		hr1.magicJump();

		System.out.println("==========================");
			
		hr2.setNickName("김길동");
		hr2.setJob("전사");
		hr2.setHp(200);
		hr2.setMp(30);
		hr2.setLevel(1);
		hr2.setExp(0);
		
		System.out.printf("%s 직업으로 '%s' 님이 생성되었습니다. 현재 레벨 : %d\n",
				hr2.getJob(), hr2.getNickName(), hr2.getLevel()
			);
		
		hr2.attack(400);
		hr2.attack(400);
		hr2.attack(400);
		hr2.attack(400);
		hr2.attack(400);
		hr2.magicJump();
		hr2.magicJump();
		hr2.magicJump();
		hr2.magicJump();
		hr2.magicJump();

	
	}
	

}
