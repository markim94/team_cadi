package ClassTest;

public class AnimalTest {
	
	public static void main(String[] args) {
		Eagle eagle = new Eagle();
		eagle.eat();
		eagle.sleep();
		eagle.fly();
		eagle.setWeight(20); // eagle의 weight를 20으로 설정
		eagle.printWeight(); // weight 출력
		eagle.weight = 10;
		
		Lion lion = new Lion();
		lion.roar();
		lion.eat();
		lion.sleep();
		lion.setWeight(30); // lion의 weight를 3으로 설정 
		lion.printWeight(); // lion의 weight 출
		
		eagle.printWeight(); // lion의 weight와 eagle의 weight는 별개임을 알 수 있음. 
		
	}
}
