package com.iu.start.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Car {
	
	//Car는 Engine이 없으면 안된다.
	//Car는 Engine인가? 아님
	//Car는 Engine에 의존적이다.
	//이게 의존성 주입이라고 한다.
	
	private Engine engine;
	
	/* 멤버변수 초기화하는 방법
	 
	  1. private Engine engine = new Engine();
	  2. Car car = new Car();
	     car.engine = new Engine();
	     
	  3.생성자에서 초기화 
	  	public Car(){
	  		this.engin = new Engine();
	  	}
	  3-1. Car(Engine engine){
	  		this.engine = engine;
	  	
	  4.
	  {
	  	this.engine = new Engine();
	  }
	  
	  5.setter와 getter를 사용해 넣는 방법
	  다른 곳에서 
	  Car car = new Car();
	  Engine engine = new Engine();
	  car.setEngine(engine);
	  
	  */
	
	// IOC (Inversion Of Control, 제어의 역전)
	// - java개발자가 직접 객체 생성하고 직접 DI 작업을 진행을 하는것이 아니고
	// - Spring에게 객체 생성과 주입을 위임(우리는 조립 설계도 제공해줘야 한다.)
	// spring에서 Controller는 service에 대해 의존적이다.
	// Controller에는 주입을 위임해주고,
	// Service에는 생성을 위임해준다.
	
	// 위임방법 2가지
	// 1. Annotation
	// - 생성을 위임
	// - 주입을 위임
	// 2. xml
	
	/*
	 * 객체를 만들면 spring이 pool이라는 곳에 저장을 한다.

		pool에 있는 객체들은 모두 '싱글톤'이다.
		싱글톤 : 객체가 딱 한개만 있는 것.

		@객체만드는 어노테이션으로 선언해주면 pool에 생성해놓고, 주입이 필요할 때 찾아서 주입해준다.
		생성되어 있지 않은 경우 아래의 에러가 뜬다.
		* 에러메시지 : org.springframework.beans.factory.UnsatisfiedDependencyException
		* 참고용어 : bean :자바객체를 의미함

	 */
	
	private Wheel leftWheel;
	private Wheel rightWheel;
//	@Autowired
	public Car(/*Engine engine,*/ Wheel leftWheel, Wheel rightWheel) {
//		this.engine = engine;
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	
	//@Autowired는 같은 타입의 객체가 여러개 있으면 bean name으로 검색

	//@Qualifier("대입할 bean의 이름")
	
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

}
