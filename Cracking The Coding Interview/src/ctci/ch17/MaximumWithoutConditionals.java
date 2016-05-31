package ctci.ch17;

public class MaximumWithoutConditionals {

	public int max(int a, int b) {
		return (a + b + (int)Math.abs(a-b)) / 2;
	}

	public int min(int a, int b) {
		return (a + b - (int)Math.abs(a-b)) / 2;
	}

	public static void main(String[] args) {
		int a = 10, b = 20;
		
		
		MaximumWithoutConditionals foo = new MaximumWithoutConditionals(); 
		
		System.out.println("Maximum: " + foo.max(a,b));
		System.out.println("Minimum: " + foo.min(a, b));

	}

}