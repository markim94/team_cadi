package override01;
	
	
class SuperClass{
	public void itis() {
		System.out.println("It's super class");
	}
}

class SubClass extends SuperClass{
	public void itis() {
		System.out.println("It's sub class");
	}
}

class overrideExample {
	public static void main(String[] args) {
		SuperClass sc = new SuperClass();
		SubClass bc = new SubClass();
		
		sc.itis();
		bc.itis();
	}
}


	


