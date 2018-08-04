package accessor2;

public class Test01 {
	public static void main(String[] args) {
		publicTest t = new publicTest(10, 10);
		t.x = 20;
		//t.y=20; y는 private이라 접근 불가
		//t.setValue(30);
		t.print();
	}

}
