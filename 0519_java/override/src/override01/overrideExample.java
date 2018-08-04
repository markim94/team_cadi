package override01;
	
class SuperClass{ 			// 부모 클래스
	public void itis() { 	// 부모클래스의 itis 메소드 
		System.out.println("It's super class"); // it's super class 출력 
	}
}

class SubClass extends SuperClass{  // 부모 클래스를 상속(extends)해서 만든 자식 클래스
	public void itis() {			// 자식 클래스의 itis 메소드, 부모 클래스의 itis 메소드를 재정의(오버라이딩).
		System.out.println("It's sub class"); // it's sub class 출력
	}
}

class overrideExample { 			// 재정의한 메소드를 확인하고자 만든 메인 클래스
	public static void main(String[] args) { 
		SuperClass sc = new SuperClass(); // 부모 클래스를 sc로 객체화함.
		SubClass bc = new SubClass(); 	  // 자식 클래스를 bc로 객체화함.
		
		sc.itis();		//부모 클래스의 itis메소드 호출
		bc.itis();		//자식 클래스의 itis메소드 호출
	}
}


	


