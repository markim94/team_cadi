package overload01;

public class AAA {
	
	public void showPrint(int n) {
		System.out.println(n);
	}
	
	public void showPrint(int n1, int n2) {
		System.out.println(n1+","+n2);
	}
	
	public void showPrint(int n1, double n2) {
		System.out.println(n1+","+n2);
	}
}
