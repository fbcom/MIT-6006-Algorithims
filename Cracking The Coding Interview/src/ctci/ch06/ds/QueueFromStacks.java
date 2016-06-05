package ctci.ch06.ds;

public class QueueFromStacks {

	private Stack in;
	private Stack out;

	public QueueFromStacks() {
		this.in = new Stack();
		this.out = new Stack();
	}

	public void enqueue(Object value) {
		this.in.push(value);
	}

	public Object dequeue() {
		if (isEmpty()) {
			return null;
		}
		this.mergeStacks();
		return this.out.pop();
	}

	public Object peek() {
		if (this.isEmpty()) {
			return null;
		}
		this.mergeStacks();
		return this.out.peek();
	}

	public boolean isEmpty() {
		return this.in.isEmpty() && this.out.isEmpty();
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(this.out.toString());
		s.append(new StringBuilder(this.in.toString()).reverse());
		return s.toString();
	}

	private void mergeStacks() {
		if (this.out.isEmpty()) {
			// copies all elements from the in stack to the out-stack if the
			// out-stack is empty
			while (!this.in.isEmpty()) {
				this.out.push(this.in.pop());
			}
		}
	}

	public static void main(String[] args) {
		QueueFromStacks q = new QueueFromStacks();

		System.out.println("dequeue: " + q.peek());
		System.out.println("peek   : " + q.peek());
		for (int i = 0; i < 10; i++) {
			System.out.println("enqueue: " + i);
			q.enqueue(i);
			System.out.println("peek   : " + q.peek());
			System.out.println("queue  : " + q);
		}
		while (!q.isEmpty()) {
			System.out.println("dequeue: " + q.dequeue());
			System.out.println("queue  : " + q);
		}
	}

}
