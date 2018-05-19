package overload01;

public class Test01 {
	public static void main(String[] args) {
		AAA a1 = new AAA();
		a1.showPrint(10);
		a1.showPrint(10, 20);
		a1.showPrint(10, 3.14);
	}

}
