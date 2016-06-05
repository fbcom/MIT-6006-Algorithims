package ctci.ch06.ds;

public class Vector {

	private int size, resize;
	private Object[] array;

	public Vector(int size, int resize) {
		this.array = new Object[size];
		this.size = 0;
		this.resize = resize;
	}

	public synchronized void set(int i, Object value) {
		this.array[i] = value;
	}

	public synchronized Object get(int i) {
		return this.array[i];
	}

	public synchronized void add(Object e) {
		if (this.size >= this.array.length) {
			this.resize();
		}
		this.array[size++] = e;
	}

	public synchronized void add(int index, Object e) {
		if (index < 0 || index > this.array.length) {
			throw new IndexOutOfBoundsException();
		}

		ensureCapacity(this.size + 1);
		Object[] tmp = new Object[this.array.length];
		System.arraycopy(this.array, 0, tmp, 0, index);
		tmp[index] = e;
		System.arraycopy(this.array, index, tmp, index + 1, this.array.length - index);
		this.array = tmp;
	}

	public synchronized void remove(Object e) {
		int i = 0;
		for (Object o : this.array) {
			if (o == e) {
				this.remove(i);
				break;
			}
			i++;
		}
	}

	public synchronized void remove(int index) {
		if (index < 0 || index > this.array.length) {
			throw new IndexOutOfBoundsException();
		}
		Object[] tmp = new Object[this.array.length];
		System.arraycopy(this.array, 0, tmp, 0, index);
		System.arraycopy(this.array, index + 1, tmp, index, this.array.length - index - 1);
		this.array = tmp;
	}

	public synchronized void ensureCapacity(int capacity) {
		if (this.size < capacity) {
			this.resize(capacity - this.size);
		}
	}

	private synchronized void resize(int resize) {
		Object[] tmp = new Object[this.array.length + this.resize];
		System.arraycopy(this.array, 0, tmp, 0, this.size);
		this.array = tmp;
	}

	private synchronized void resize() {
		this.resize(this.resize);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		synchronized (this) {
			for (int i = 0; i < this.size; i++) {
				if (i == 0) {
					s.append("=>");
				} else {
					s.append("->");
				}
				s.append(this.array[i]);
			}
		}
		return s.toString();
	}

	public static void main(String[] args) {
		Vector v = new Vector(3, 3);

		Integer[] ints = new Integer[10];
		for (int i = 0; i < 10; i++) {
			ints[i] = 100 + i;
		}

		Stack s = new Stack();
		for (Integer i : ints) {
			s.push(i);
			v.add(i);
			System.out.println(v);
		}

		while (!s.isEmpty()) {
			// remove even elements in reverse order
			Integer i = (Integer) s.pop();
			if (i % 2 == 0)
				v.remove(i);
			System.out.println(v);
		}

	}

}
