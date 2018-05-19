package accessor2;

public class publicTest {
	public int x;
	private int y;
	
	public publicTest(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void print() {
		System.out.println("x = " + x + ", y = "+y);
	}
	
	/*public void setValue(int a) {
		this.y = a;
	}
	*/ 
}
