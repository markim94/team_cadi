package ClassTest;

public class Animal {
	private double weight;
	private String picture;
	
	void eat() {
		System.out.println("eat() 호출됨.");
	}
	
	void sleep() {
		System.out.println("sleep() 호출됨.");
	}
	
	void setWeight(double weight) {  // weight를 설정해주는 메소드, weight는 private이므로 설정해주는 메소드가 별도로 필요함.
		this.weight = weight;
	}
	
	void printWeight() {
		System.out.println(this.weight);  // weight를 출력해주는 메소드
	}

}
