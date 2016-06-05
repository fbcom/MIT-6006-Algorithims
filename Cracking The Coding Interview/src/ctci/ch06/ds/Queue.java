package ctci.ch06.ds;

public class Queue {

	private Element head, tail;

	public void enqueue(Object value) {
		if (this.head == null) {
			this.tail = this.head = new Element(value, null);
		} else {
			this.tail.next = new Element(value, null);
			this.tail = tail.next;
		}
	}

	public Object dequeue() {
		if (isEmpty()) {
			return null;
		}
		Object ret = head.value;
		head = head.next;
		return ret;
	}

	public Object peek() {
		if (!this.isEmpty()) {
			return this.head.value;
		}
		return null;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Element e = this.head; e != null; e = e.next) {
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
		// This is a wrapper class for appending values to the queue providing a
		// reference to the next element in the queue
		private Object value;
		private Element next;

		private Element(Object value, Element next) {
			this.value = value;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue();

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
		}

	}

}
