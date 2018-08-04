package accessor;

public class AA {
	int a;
	
	public int A(int a) {
		this.a = a+1;
		return this.a;
	}
	
	private int B(int a) {
		this.a = a+1;
		return this.a;
	}
	
	public int C(int a) {
		this.a = a+1;
		return B(this.a);
	}

}
