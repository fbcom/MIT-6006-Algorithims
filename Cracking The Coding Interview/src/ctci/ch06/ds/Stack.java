package ctci.ch06.ds;

public class Stack {

	private Element tos; // top of stack

	public void push(Object value) {
		this.tos = new Element(value, tos);
	}

	public Object pop() {
		Object ret = null;
		if (!isEmpty()) {
			ret = this.tos.value;
			this.tos = tos.next;
		}
		return ret;
	}

	public Object peek() {
		if (!this.isEmpty()) {
			return tos.value;
		}
		return null;
	}

	public boolean isEmpty() {
		return this.tos == null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Element e = tos; e != null; e = e.next) {
			if (s.length() == 0) {
				s.append("=>");
			} else {
				s.append("->");
			}
			s.append(e.value);
		}
		return s.toString();
	}

	private class Element {
		// This is a wrapper class for putting values on the stack providing a
		// reference to the next element on the stack

		private Object value;
		private Element next;

		private Element(Object value, Element next) {
			this.value = value;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();

		System.out.println("pop  : " + s.peek());
		System.out.println("peek : " + s.peek());
		for (int i = 0; i < 10; i++) {
			System.out.println("push : " + i);
			s.push(i);
			System.out.println("peek : " + s.peek());
			System.out.println("stack: " + s);
		}
		while (!s.isEmpty()) {
			System.out.println("pop  : " + s.pop());
		}

	}

}